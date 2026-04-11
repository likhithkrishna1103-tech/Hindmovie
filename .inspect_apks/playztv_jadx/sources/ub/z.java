package ub;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z implements ServiceConnection {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f12911u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Intent f12912v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f12913w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayDeque f12914x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public x f12915y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12916z;

    public z(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(0, new y7.a("Firebase-FirebaseInstanceIdServiceConnection"));
        this.f12914x = new ArrayDeque();
        this.f12916z = false;
        Context applicationContext = context.getApplicationContext();
        this.f12911u = applicationContext;
        this.f12912v = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f12913w = scheduledThreadPoolExecutor;
    }

    public final synchronized void a() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f12914x.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                x xVar = this.f12915y;
                if (xVar == null || !xVar.isBinderAlive()) {
                    c();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f12915y.a((y) this.f12914x.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized o8.o b(Intent intent) {
        y yVar;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            yVar = new y(intent);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f12913w;
            yVar.f12910b.f9421a.b(scheduledThreadPoolExecutor, new nc.c(18, scheduledThreadPoolExecutor.schedule(new nc.b(9, yVar), 20L, TimeUnit.SECONDS)));
            this.f12914x.add(yVar);
            a();
        } catch (Throwable th) {
            throw th;
        }
        return yVar.f12910b.f9421a;
    }

    public final void c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb2 = new StringBuilder("binder is dead. start connection? ");
            sb2.append(!this.f12916z);
            Log.d("FirebaseMessaging", sb2.toString());
        }
        if (this.f12916z) {
            return;
        }
        this.f12916z = true;
        try {
            if (w7.a.b().a(this.f12911u, this.f12912v, this, 65)) {
                return;
            } else {
                Log.e("FirebaseMessaging", "binding to the service failed");
            }
        } catch (SecurityException e10) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e10);
        }
        this.f12916z = false;
        while (true) {
            ArrayDeque arrayDeque = this.f12914x;
            if (arrayDeque.isEmpty()) {
                return;
            } else {
                ((y) arrayDeque.poll()).f12910b.c(null);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f12916z = false;
            if (iBinder instanceof x) {
                this.f12915y = (x) iBinder;
                a();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            ArrayDeque arrayDeque = this.f12914x;
            while (!arrayDeque.isEmpty()) {
                ((y) arrayDeque.poll()).f12910b.c(null);
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
