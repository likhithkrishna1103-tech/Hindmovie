package r2;

import p1.g1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f11348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f11349b;

    public q(int i, g1 g1Var, int[] iArr) {
        if (iArr.length == 0) {
            s1.b.h("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.f11348a = g1Var;
        this.f11349b = iArr;
    }
}
