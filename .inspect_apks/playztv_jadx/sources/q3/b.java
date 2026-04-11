package q3;

import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10604e;
    public final s1.u f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s1.u f10605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10606h;
    public int i;

    public b(s1.u uVar, s1.u uVar2, boolean z2) throws n0 {
        this.f10605g = uVar;
        this.f = uVar2;
        this.f10604e = z2;
        uVar2.J(12);
        this.f10600a = uVar2.B();
        uVar.J(12);
        this.i = uVar.B();
        w2.b.d("first_chunk must be 1", uVar.j() == 1);
        this.f10601b = -1;
    }

    public final boolean a() {
        int i = this.f10601b + 1;
        this.f10601b = i;
        if (i == this.f10600a) {
            return false;
        }
        boolean z2 = this.f10604e;
        s1.u uVar = this.f;
        this.f10603d = z2 ? uVar.C() : uVar.z();
        if (this.f10601b == this.f10606h) {
            s1.u uVar2 = this.f10605g;
            this.f10602c = uVar2.B();
            uVar2.K(4);
            int i10 = this.i - 1;
            this.i = i10;
            this.f10606h = i10 > 0 ? uVar2.B() - 1 : -1;
        }
        return true;
    }
}
