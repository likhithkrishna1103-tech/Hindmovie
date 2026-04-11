package r2;

import p1.g1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends n implements Comparable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f11315y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f11316z;

    public f(int i, g1 g1Var, int i10, j jVar, int i11) {
        int i12;
        super(i, g1Var, i10);
        this.f11315y = l4.a.h(i11, jVar.f11328u0) ? 1 : 0;
        p1.q qVar = this.f11338x;
        int i13 = qVar.f10030u;
        int i14 = -1;
        if (i13 != -1 && (i12 = qVar.f10031v) != -1) {
            i14 = i13 * i12;
        }
        this.f11316z = i14;
    }

    @Override // r2.n
    public final int a() {
        return this.f11315y;
    }

    @Override // r2.n
    public final /* bridge */ /* synthetic */ boolean b(n nVar) {
        return false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f11316z, ((f) obj).f11316z);
    }
}
