package c2;

import a2.l0;
import a2.o0;
import com.google.android.gms.internal.measurement.k4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ k4 f2336u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ boolean f2337v;

    public /* synthetic */ i(k4 k4Var, boolean z2) {
        this.f2336u = k4Var;
        this.f2337v = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = (j) this.f2336u.f3071v;
        int i = s1.b0.f11647a;
        o0 o0Var = ((l0) jVar).f312u;
        boolean z2 = o0Var.f361u0;
        boolean z10 = this.f2337v;
        if (z2 == z10) {
            return;
        }
        o0Var.f361u0 = z10;
        o0Var.H.e(23, new a2.d0(1, z10));
    }
}
