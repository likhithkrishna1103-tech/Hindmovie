package o8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements ServiceConnection {
    public ComponentName A;
    public final /* synthetic */ f0 B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f9642v = new HashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9643w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9644x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public IBinder f9645y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d0 f9646z;

    public e0(f0 f0Var, d0 d0Var) {
        this.B = f0Var;
        this.f9646z = d0Var;
    }

    public final l8.b a(String str, Executor executor) throws Throwable {
        try {
            Intent intentA = w.a(this.B.f9655b, this.f9646z);
            this.f9643w = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(s8.e.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                f0 f0Var = this.B;
                r8.a aVar = f0Var.f9657d;
                Context context = f0Var.f9655b;
                d0 d0Var = this.f9646z;
                try {
                    boolean zD = aVar.d(context, str, intentA, this, 4225, executor);
                    this.f9644x = zD;
                    if (zD) {
                        f0Var.f9656c.sendMessageDelayed(f0Var.f9656c.obtainMessage(1, d0Var), f0Var.f);
                        l8.b bVar = l8.b.f7876z;
                        StrictMode.setVmPolicy(vmPolicy);
                        return bVar;
                    }
                    this.f9643w = 2;
                    try {
                        f0Var.f9657d.c(f0Var.f9655b, this);
                    } catch (IllegalArgumentException unused) {
                    }
                    l8.b bVar2 = new l8.b(16);
                    StrictMode.setVmPolicy(vmPolicy);
                    return bVar2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    StrictMode.setVmPolicy(vmPolicy);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (v e9) {
            return e9.f9698v;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f0 f0Var = this.B;
        synchronized (f0Var.f9654a) {
            try {
                f0Var.f9656c.removeMessages(1, this.f9646z);
                this.f9645y = iBinder;
                this.A = componentName;
                Iterator it = this.f9642v.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f9643w = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        f0 f0Var = this.B;
        synchronized (f0Var.f9654a) {
            try {
                f0Var.f9656c.removeMessages(1, this.f9646z);
                this.f9645y = null;
                this.A = componentName;
                Iterator it = this.f9642v.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f9643w = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
