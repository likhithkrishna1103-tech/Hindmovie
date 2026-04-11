package p7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import c2.o;
import com.google.android.gms.internal.measurement.r0;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements ServiceConnection {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10271u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Messenger f10272v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public p2.c f10273w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayDeque f10274x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final SparseArray f10275y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ m f10276z;

    public k(m mVar) {
        this.f10276z = mVar;
        r0 r0Var = new r0(Looper.getMainLooper(), new p6.f(1, this));
        Looper.getMainLooper();
        this.f10272v = new Messenger(r0Var);
        this.f10274x = new ArrayDeque();
        this.f10275y = new SparseArray();
    }

    public final synchronized void a(String str) {
        b(str, null);
    }

    public final synchronized void b(String str, SecurityException securityException) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i = this.f10271u;
            if (i == 0) {
                throw new IllegalStateException();
            }
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return;
                }
                this.f10271u = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f10271u = 4;
            w7.a.b().c((Context) this.f10276z.f10284v, this);
            o oVar = new o(str, securityException);
            Iterator it = this.f10274x.iterator();
            while (it.hasNext()) {
                ((l) it.next()).b(oVar);
            }
            this.f10274x.clear();
            for (int i10 = 0; i10 < this.f10275y.size(); i10++) {
                ((l) this.f10275y.valueAt(i10)).b(oVar);
            }
            this.f10275y.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        try {
            if (this.f10271u == 2 && this.f10274x.isEmpty() && this.f10275y.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f10271u = 3;
                w7.a.b().c((Context) this.f10276z.f10284v, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean d(l lVar) {
        int i = this.f10271u;
        if (i != 0) {
            if (i == 1) {
                this.f10274x.add(lVar);
                return true;
            }
            if (i != 2) {
                return false;
            }
            this.f10274x.add(lVar);
            ((ScheduledExecutorService) this.f10276z.f10285w).execute(new j(this, 0));
            return true;
        }
        this.f10274x.add(lVar);
        if (this.f10271u != 0) {
            throw new IllegalStateException();
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f10271u = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (w7.a.b().a((Context) this.f10276z.f10284v, intent, this, 1)) {
                ((ScheduledExecutorService) this.f10276z.f10285w).schedule(new j(this, 1), 30L, TimeUnit.SECONDS);
            } else {
                a("Unable to bind to service");
            }
        } catch (SecurityException e10) {
            b("Unable to bind to service", e10);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        ((ScheduledExecutorService) this.f10276z.f10285w).execute(new i(this, iBinder, 0));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        ((ScheduledExecutorService) this.f10276z.f10285w).execute(new j(this, 2));
    }
}
