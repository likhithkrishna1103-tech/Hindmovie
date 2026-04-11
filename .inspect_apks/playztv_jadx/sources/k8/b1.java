package k8;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b1 implements ServiceConnection {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f7087u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ a1 f7088v;

    public b1(a1 a1Var, String str) {
        this.f7088v = a1Var;
        this.f7087u = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a1 a1Var = this.f7088v;
        if (iBinder == null) {
            p0 p0Var = a1Var.f7070b.C;
            k1.f(p0Var);
            p0Var.D.d("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i = com.google.android.gms.internal.measurement.j0.f3062d;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            com.google.android.gms.internal.measurement.k0 m0Var = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.measurement.k0 ? (com.google.android.gms.internal.measurement.k0) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.measurement.m0(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService", 0);
            p0 p0Var2 = a1Var.f7070b.C;
            k1.f(p0Var2);
            p0Var2.I.d("Install Referrer Service connected");
            h1 h1Var = a1Var.f7070b.D;
            k1.f(h1Var);
            h1Var.y1(new ea.t(this, m0Var, this));
        } catch (RuntimeException e10) {
            p0 p0Var3 = a1Var.f7070b.C;
            k1.f(p0Var3);
            p0Var3.D.c(e10, "Exception occurred while calling Install Referrer API");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        p0 p0Var = this.f7088v.f7070b.C;
        k1.f(p0Var);
        p0Var.I.d("Install Referrer Service disconnected");
    }
}
