package nc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements ServiceConnection {
    public boolean A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f9033v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Intent f9034w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f9035x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayDeque f9036y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public y f9037z;

    public a0(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new t8.a("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f9036y = new ArrayDeque();
        this.A = false;
        Context applicationContext = context.getApplicationContext();
        this.f9033v = applicationContext;
        this.f9034w = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f9035x = scheduledThreadPoolExecutor;
    }

    public final synchronized void a() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f9036y.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                y yVar = this.f9037z;
                if (yVar == null || !yVar.isBinderAlive()) {
                    c();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f9037z.a((z) this.f9036y.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized j9.p b(Intent intent) {
        z zVar;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            zVar = new z(intent);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f9035x;
            zVar.f9110b.f6688a.b(scheduledThreadPoolExecutor, new kb.d(4, scheduledThreadPoolExecutor.schedule(new androidx.emoji2.text.w(28, zVar), 20L, TimeUnit.SECONDS)));
            this.f9036y.add(zVar);
            a();
        } catch (Throwable th) {
            throw th;
        }
        return zVar.f9110b.f6688a;
    }

    public final void c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder("binder is dead. start connection? ");
            sb.append(!this.A);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.A) {
            return;
        }
        this.A = true;
        try {
            if (r8.a.b().a(this.f9033v, this.f9034w, this, 65)) {
                return;
            } else {
                Log.e("FirebaseMessaging", "binding to the service failed");
            }
        } catch (SecurityException e9) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e9);
        }
        this.A = false;
        while (true) {
            ArrayDeque arrayDeque = this.f9036y;
            if (arrayDeque.isEmpty()) {
                return;
            } else {
                ((z) arrayDeque.poll()).f9110b.c(null);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.A = false;
            if (iBinder instanceof y) {
                this.f9037z = (y) iBinder;
                a();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            ArrayDeque arrayDeque = this.f9036y;
            while (!arrayDeque.isEmpty()) {
                ((z) arrayDeque.poll()).f9110b.c(null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        a();
    }
}
