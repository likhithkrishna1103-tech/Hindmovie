package r2;

import p1.g1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f11335u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g1 f11336v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11337w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p1.q f11338x;

    public n(int i, g1 g1Var, int i10) {
        this.f11335u = i;
        this.f11336v = g1Var;
        this.f11337w = i10;
        this.f11338x = g1Var.f9765d[i10];
    }

    public abstract int a();

    public abstract boolean b(n nVar);
}
