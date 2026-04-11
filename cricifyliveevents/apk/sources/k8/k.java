package k8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import i2.q;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements ServiceConnection {
    public final /* synthetic */ m A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7268v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Messenger f7269w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public i2.k f7270x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayDeque f7271y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final SparseArray f7272z;

    public k(m mVar) {
        this.A = mVar;
        a9.k kVar = new a9.k(Looper.getMainLooper(), new k7.f(1, this));
        Looper.getMainLooper();
        this.f7269w = new Messenger(kVar);
        this.f7271y = new ArrayDeque();
        this.f7272z = new SparseArray();
    }

    public final synchronized void a(String str) {
        b(str, null);
    }

    public final synchronized void b(String str, SecurityException securityException) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i = this.f7268v;
            if (i == 0) {
                throw new IllegalStateException();
            }
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return;
                }
                this.f7268v = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f7268v = 4;
            r8.a.b().c((Context) this.A.f7280w, this);
            q qVar = new q(str, securityException);
            Iterator it = this.f7271y.iterator();
            while (it.hasNext()) {
                ((l) it.next()).b(qVar);
            }
            this.f7271y.clear();
            for (int i10 = 0; i10 < this.f7272z.size(); i10++) {
                ((l) this.f7272z.valueAt(i10)).b(qVar);
            }
            this.f7272z.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        try {
            if (this.f7268v == 2 && this.f7271y.isEmpty() && this.f7272z.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f7268v = 3;
                r8.a.b().c((Context) this.A.f7280w, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean d(l lVar) {
        int i = this.f7268v;
        if (i != 0) {
            if (i == 1) {
                this.f7271y.add(lVar);
                return true;
            }
            if (i != 2) {
                return false;
            }
            this.f7271y.add(lVar);
            ((ScheduledExecutorService) this.A.f7281x).execute(new i(this, 0));
            return true;
        }
        this.f7271y.add(lVar);
        if (this.f7268v != 0) {
            throw new IllegalStateException();
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f7268v = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (r8.a.b().a((Context) this.A.f7280w, intent, this, 1)) {
                ((ScheduledExecutorService) this.A.f7281x).schedule(new i(this, 1), 30L, TimeUnit.SECONDS);
            } else {
                a("Unable to bind to service");
            }
        } catch (SecurityException e9) {
            b("Unable to bind to service", e9);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        ((ScheduledExecutorService) this.A.f7281x).execute(new s(29, this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        ((ScheduledExecutorService) this.A.f7281x).execute(new i(this, 2));
    }
}
