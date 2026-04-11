package d4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f3798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.u f3799b = new s1.u(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3802e;
    public boolean f;

    public c0(b0 b0Var) {
        this.f3798a = b0Var;
    }

    @Override // d4.i0
    public final void a() {
        this.f = true;
    }

    @Override // d4.i0
    public final void b(int i, s1.u uVar) {
        boolean z2 = (i & 1) != 0;
        int iX = z2 ? uVar.f11710b + uVar.x() : -1;
        if (this.f) {
            if (!z2) {
                return;
            }
            this.f = false;
            uVar.J(iX);
            this.f3801d = 0;
        }
        while (uVar.a() > 0) {
            int i10 = this.f3801d;
            s1.u uVar2 = this.f3799b;
            if (i10 < 3) {
                if (i10 == 0) {
                    int iX2 = uVar.x();
                    uVar.J(uVar.f11710b - 1);
                    if (iX2 == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(uVar.a(), 3 - this.f3801d);
                uVar.h(uVar2.f11709a, this.f3801d, iMin);
                int i11 = this.f3801d + iMin;
                this.f3801d = i11;
                if (i11 == 3) {
                    uVar2.J(0);
                    uVar2.I(3);
                    uVar2.K(1);
                    int iX3 = uVar2.x();
                    int iX4 = uVar2.x();
                    this.f3802e = (iX3 & 128) != 0;
                    int i12 = (((iX3 & 15) << 8) | iX4) + 3;
                    this.f3800c = i12;
                    byte[] bArr = uVar2.f11709a;
                    if (bArr.length < i12) {
                        uVar2.c(Math.min(4098, Math.max(i12, bArr.length * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(uVar.a(), this.f3800c - this.f3801d);
                uVar.h(uVar2.f11709a, this.f3801d, iMin2);
                int i13 = this.f3801d + iMin2;
                this.f3801d = i13;
                int i14 = this.f3800c;
                if (i13 != i14) {
                    continue;
                } else {
                    if (!this.f3802e) {
                        uVar2.I(i14);
                    } else {
                        if (s1.b0.m(0, i14, -1, uVar2.f11709a) != 0) {
                            this.f = true;
                            return;
                        }
                        uVar2.I(this.f3800c - 4);
                    }
                    uVar2.J(0);
                    this.f3798a.d(uVar2);
                    this.f3801d = 0;
                }
            }
        }
    }

    @Override // d4.i0
    public final void e(s1.z zVar, w2.q qVar, h0 h0Var) {
        this.f3798a.e(zVar, qVar, h0Var);
        this.f = true;
    }
}
