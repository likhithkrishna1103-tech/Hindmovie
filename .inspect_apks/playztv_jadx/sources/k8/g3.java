package k8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g3 implements ServiceConnection, t7.b, t7.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f7215u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile m0 f7216v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ z2 f7217w;

    public g3(z2 z2Var) {
        this.f7217w = z2Var;
    }

    public final void a(Intent intent) {
        this.f7217w.p1();
        Context context = ((k1) this.f7217w.f2454v).f7282u;
        w7.a aVarB = w7.a.b();
        synchronized (this) {
            try {
                if (this.f7215u) {
                    this.f7217w.g().I.d("Connection attempt already in progress");
                    return;
                }
                this.f7217w.g().I.d("Using local app measurement service");
                this.f7215u = true;
                aVarB.a(context, intent, this.f7217w.f7572x, 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t7.c
    public final void c(q7.b bVar) {
        t7.v.c("MeasurementServiceConnection.onConnectionFailed");
        p0 p0Var = ((k1) this.f7217w.f2454v).C;
        if (p0Var == null || !p0Var.f7539w) {
            p0Var = null;
        }
        if (p0Var != null) {
            p0Var.D.c(bVar, "Service connection failed");
        }
        synchronized (this) {
            this.f7215u = false;
            this.f7216v = null;
        }
        this.f7217w.x().y1(new h3(this, 0));
    }

    @Override // t7.b
    public final void e(int i) {
        t7.v.c("MeasurementServiceConnection.onConnectionSuspended");
        z2 z2Var = this.f7217w;
        z2Var.g().H.d("Service connection suspended");
        z2Var.x().y1(new h3(this, 1));
    }

    @Override // t7.b
    public final void f() {
        t7.v.c("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                t7.v.h(this.f7216v);
                this.f7217w.x().y1(new f3(this, (h0) this.f7216v.u(), 1));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f7216v = null;
                this.f7215u = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        t7.v.c("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f7215u = false;
                this.f7217w.g().A.d("Service connected with null binder");
                return;
            }
            h0 i0Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    i0Var = iInterfaceQueryLocalInterface instanceof h0 ? (h0) iInterfaceQueryLocalInterface : new i0(iBinder);
                    this.f7217w.g().I.d("Bound to IMeasurementService interface");
                } else {
                    this.f7217w.g().A.c(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                this.f7217w.g().A.d("Service connect failed to get IMeasurementService");
            }
            if (i0Var == null) {
                this.f7215u = false;
                try {
                    w7.a aVarB = w7.a.b();
                    z2 z2Var = this.f7217w;
                    aVarB.c(((k1) z2Var.f2454v).f7282u, z2Var.f7572x);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f7217w.x().y1(new f3(this, i0Var, 0));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        t7.v.c("MeasurementServiceConnection.onServiceDisconnected");
        z2 z2Var = this.f7217w;
        z2Var.g().H.d("Service disconnected");
        z2Var.x().y1(new ea.t(18, this, componentName, false));
    }
}
