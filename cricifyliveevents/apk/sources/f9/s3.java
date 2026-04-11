package f9;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s3 implements ServiceConnection, o8.b, o8.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f4400v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile r0 f4401w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ t3 f4402x;

    public s3(t3 t3Var) {
        this.f4402x = t3Var;
    }

    public final void a() {
        t3 t3Var = this.f4402x;
        t3Var.m1();
        Context context = ((r1) t3Var.f307w).f4363v;
        synchronized (this) {
            try {
                try {
                    if (this.f4400v) {
                        w0 w0Var = ((r1) this.f4402x.f307w).A;
                        r1.g(w0Var);
                        w0Var.J.a("Connection attempt already in progress");
                    } else {
                        if (this.f4401w != null && (this.f4401w.e() || this.f4401w.a())) {
                            w0 w0Var2 = ((r1) this.f4402x.f307w).A;
                            r1.g(w0Var2);
                            w0Var2.J.a("Already awaiting connection attempt");
                            return;
                        }
                        this.f4401w = new r0(context, Looper.getMainLooper(), o8.f0.a(context), l8.f.f7890b, 93, this, this, null);
                        w0 w0Var3 = ((r1) this.f4402x.f307w).A;
                        r1.g(w0Var3);
                        w0Var3.J.a("Connecting to remote service");
                        this.f4400v = true;
                        o8.u.g(this.f4401w);
                        this.f4401w.o();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // o8.c
    public final void b(l8.b bVar) {
        t3 t3Var = this.f4402x;
        p1 p1Var = ((r1) t3Var.f307w).B;
        r1.g(p1Var);
        p1Var.r1();
        w0 w0Var = ((r1) t3Var.f307w).A;
        if (w0Var == null || !w0Var.f4048x) {
            w0Var = null;
        }
        if (w0Var != null) {
            w0Var.J.b(bVar, "Service connection failed");
        }
        synchronized (this) {
            this.f4400v = false;
            this.f4401w = null;
        }
        p1 p1Var2 = ((r1) this.f4402x.f307w).B;
        r1.g(p1Var2);
        p1Var2.v1(new ya.s(15, this, bVar, false));
    }

    @Override // o8.b
    public final void e(int i) {
        r1 r1Var = (r1) this.f4402x.f307w;
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.r1();
        w0 w0Var = r1Var.A;
        r1.g(w0Var);
        w0Var.I.a("Service connection suspended");
        p1 p1Var2 = r1Var.B;
        r1.g(p1Var2);
        p1Var2.v1(new androidx.fragment.app.m(6, this));
    }

    @Override // o8.b
    public final void f() {
        p1 p1Var = ((r1) this.f4402x.f307w).B;
        r1.g(p1Var);
        p1Var.r1();
        synchronized (this) {
            try {
                o8.u.g(this.f4401w);
                i0 i0Var = (i0) this.f4401w.u();
                p1 p1Var2 = ((r1) this.f4402x.f307w).B;
                r1.g(p1Var2);
                p1Var2.v1(new q3(this, i0Var, 1));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f4401w = null;
                this.f4400v = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        p1 p1Var = ((r1) this.f4402x.f307w).B;
        r1.g(p1Var);
        p1Var.r1();
        synchronized (this) {
            if (iBinder == null) {
                this.f4400v = false;
                w0 w0Var = ((r1) this.f4402x.f307w).A;
                r1.g(w0Var);
                w0Var.B.a("Service connected with null binder");
                return;
            }
            i0 g0Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    g0Var = iInterfaceQueryLocalInterface instanceof i0 ? (i0) iInterfaceQueryLocalInterface : new g0(iBinder);
                    w0 w0Var2 = ((r1) this.f4402x.f307w).A;
                    r1.g(w0Var2);
                    w0Var2.J.a("Bound to IMeasurementService interface");
                } else {
                    w0 w0Var3 = ((r1) this.f4402x.f307w).A;
                    r1.g(w0Var3);
                    w0Var3.B.b(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                w0 w0Var4 = ((r1) this.f4402x.f307w).A;
                r1.g(w0Var4);
                w0Var4.B.a("Service connect failed to get IMeasurementService");
            }
            if (g0Var == null) {
                this.f4400v = false;
                try {
                    r8.a aVarB = r8.a.b();
                    t3 t3Var = this.f4402x;
                    aVarB.c(((r1) t3Var.f307w).f4363v, t3Var.f4419y);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                p1 p1Var2 = ((r1) this.f4402x.f307w).B;
                r1.g(p1Var2);
                p1Var2.v1(new q3(this, g0Var, 0));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        r1 r1Var = (r1) this.f4402x.f307w;
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.r1();
        w0 w0Var = r1Var.A;
        r1.g(w0Var);
        w0Var.I.a("Service disconnected");
        p1 p1Var2 = r1Var.B;
        r1.g(p1Var2);
        p1Var2.v1(new ya.s(14, this, componentName, false));
    }
}
