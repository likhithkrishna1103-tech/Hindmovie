package u3;

import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12083e;
    public final y1.t f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y1.t f12084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12085h;
    public int i;

    public b(y1.t tVar, y1.t tVar2, boolean z10) throws n0 {
        this.f12084g = tVar;
        this.f = tVar2;
        this.f12083e = z10;
        tVar2.J(12);
        this.f12079a = tVar2.B();
        tVar.J(12);
        this.i = tVar.B();
        a3.b.c("first_chunk must be 1", tVar.j() == 1);
        this.f12080b = -1;
    }

    public final boolean a() {
        int i = this.f12080b + 1;
        this.f12080b = i;
        if (i == this.f12079a) {
            return false;
        }
        boolean z10 = this.f12083e;
        y1.t tVar = this.f;
        this.f12082d = z10 ? tVar.C() : tVar.z();
        if (this.f12080b == this.f12085h) {
            y1.t tVar2 = this.f12084g;
            this.f12081c = tVar2.B();
            tVar2.K(4);
            int i10 = this.i - 1;
            this.i = i10;
            this.f12085h = i10 > 0 ? tVar2.B() - 1 : -1;
        }
        return true;
    }
}
