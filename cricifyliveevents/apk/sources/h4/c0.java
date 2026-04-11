package h4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f5567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.t f5568b = new y1.t(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5571e;
    public boolean f;

    public c0(b0 b0Var) {
        this.f5567a = b0Var;
    }

    @Override // h4.h0
    public final void a() {
        this.f = true;
    }

    @Override // h4.h0
    public final void b(int i, y1.t tVar) {
        boolean z10 = (i & 1) != 0;
        int iX = z10 ? tVar.f14610b + tVar.x() : -1;
        if (this.f) {
            if (!z10) {
                return;
            }
            this.f = false;
            tVar.J(iX);
            this.f5570d = 0;
        }
        while (tVar.a() > 0) {
            int i10 = this.f5570d;
            y1.t tVar2 = this.f5568b;
            if (i10 < 3) {
                if (i10 == 0) {
                    int iX2 = tVar.x();
                    tVar.J(tVar.f14610b - 1);
                    if (iX2 == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(tVar.a(), 3 - this.f5570d);
                tVar.h(tVar2.f14609a, this.f5570d, iMin);
                int i11 = this.f5570d + iMin;
                this.f5570d = i11;
                if (i11 == 3) {
                    tVar2.J(0);
                    tVar2.I(3);
                    tVar2.K(1);
                    int iX3 = tVar2.x();
                    int iX4 = tVar2.x();
                    this.f5571e = (iX3 & 128) != 0;
                    int i12 = (((iX3 & 15) << 8) | iX4) + 3;
                    this.f5569c = i12;
                    byte[] bArr = tVar2.f14609a;
                    if (bArr.length < i12) {
                        tVar2.c(Math.min(4098, Math.max(i12, bArr.length * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(tVar.a(), this.f5569c - this.f5570d);
                tVar.h(tVar2.f14609a, this.f5570d, iMin2);
                int i13 = this.f5570d + iMin2;
                this.f5570d = i13;
                int i14 = this.f5569c;
                if (i13 != i14) {
                    continue;
                } else {
                    if (!this.f5571e) {
                        tVar2.I(i14);
                    } else {
                        if (y1.a0.m(0, i14, -1, tVar2.f14609a) != 0) {
                            this.f = true;
                            return;
                        }
                        tVar2.I(this.f5569c - 4);
                    }
                    tVar2.J(0);
                    this.f5567a.b(tVar2);
                    this.f5570d = 0;
                }
            }
        }
    }

    @Override // h4.h0
    public final void c(y1.y yVar, a3.r rVar, g0 g0Var) {
        this.f5567a.c(yVar, rVar, g0Var);
        this.f = true;
    }
}
