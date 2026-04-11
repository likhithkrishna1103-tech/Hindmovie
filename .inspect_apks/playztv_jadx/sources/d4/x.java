package d4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f4054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.t f4055b = new s1.t(10, new byte[10]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4056c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s1.z f4058e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4060h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4063l;

    public x(i iVar) {
        this.f4054a = iVar;
    }

    @Override // d4.i0
    public final void a() {
        this.f4056c = 0;
        this.f4057d = 0;
        this.f4060h = false;
        this.f4054a.a();
    }

    @Override // d4.i0
    public final void b(int i, s1.u uVar) {
        s1.d.h(this.f4058e);
        int i10 = i & 1;
        int i11 = -1;
        int i12 = 2;
        i iVar = this.f4054a;
        if (i10 != 0) {
            int i13 = this.f4056c;
            if (i13 != 0 && i13 != 1) {
                if (i13 == 2) {
                    s1.b.p("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i13 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f4061j != -1) {
                        s1.b.p("PesReader", "Unexpected start indicator: expected " + this.f4061j + " more bytes");
                    }
                    iVar.e(uVar.f11711c == 0);
                }
            }
            this.f4056c = 1;
            this.f4057d = 0;
        }
        int i14 = i;
        while (uVar.a() > 0) {
            int i15 = this.f4056c;
            if (i15 != 0) {
                s1.t tVar = this.f4055b;
                if (i15 != 1) {
                    if (i15 == i12) {
                        if (c(uVar, tVar.f11703b, Math.min(10, this.i)) && c(uVar, null, this.i)) {
                            tVar.q(0);
                            this.f4063l = -9223372036854775807L;
                            if (this.f) {
                                tVar.t(4);
                                long jI = ((long) tVar.i(3)) << 30;
                                tVar.t(1);
                                long jI2 = ((long) (tVar.i(15) << 15)) | jI;
                                tVar.t(1);
                                long jI3 = jI2 | ((long) tVar.i(15));
                                tVar.t(1);
                                if (!this.f4060h && this.f4059g) {
                                    tVar.t(4);
                                    long jI4 = ((long) tVar.i(3)) << 30;
                                    tVar.t(1);
                                    long jI5 = jI4 | ((long) (tVar.i(15) << 15));
                                    tVar.t(1);
                                    long jI6 = jI5 | ((long) tVar.i(15));
                                    tVar.t(1);
                                    this.f4058e.b(jI6);
                                    this.f4060h = true;
                                }
                                this.f4063l = this.f4058e.b(jI3);
                            }
                            i14 |= this.f4062k ? 4 : 0;
                            iVar.f(i14, this.f4063l);
                            this.f4056c = 3;
                            this.f4057d = 0;
                        }
                    } else {
                        if (i15 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = uVar.a();
                        int i16 = this.f4061j;
                        int i17 = i16 == i11 ? 0 : iA - i16;
                        if (i17 > 0) {
                            iA -= i17;
                            uVar.I(uVar.f11710b + iA);
                        }
                        iVar.d(uVar);
                        int i18 = this.f4061j;
                        if (i18 != i11) {
                            int i19 = i18 - iA;
                            this.f4061j = i19;
                            if (i19 == 0) {
                                iVar.e(false);
                                this.f4056c = 1;
                                this.f4057d = 0;
                            }
                        }
                    }
                } else if (c(uVar, tVar.f11703b, 9)) {
                    this.f4056c = d() ? 2 : 0;
                    this.f4057d = 0;
                }
            } else {
                uVar.K(uVar.a());
            }
            i11 = -1;
            i12 = 2;
        }
    }

    public final boolean c(s1.u uVar, byte[] bArr, int i) {
        int iMin = Math.min(uVar.a(), i - this.f4057d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            uVar.K(iMin);
        } else {
            uVar.h(bArr, this.f4057d, iMin);
        }
        int i10 = this.f4057d + iMin;
        this.f4057d = i10;
        return i10 == i;
    }

    public final boolean d() {
        s1.t tVar = this.f4055b;
        tVar.q(0);
        int i = tVar.i(24);
        if (i != 1) {
            e6.j.p(i, "Unexpected start code prefix: ", "PesReader");
            this.f4061j = -1;
            return false;
        }
        tVar.t(8);
        int i10 = tVar.i(16);
        tVar.t(5);
        this.f4062k = tVar.h();
        tVar.t(2);
        this.f = tVar.h();
        this.f4059g = tVar.h();
        tVar.t(6);
        int i11 = tVar.i(8);
        this.i = i11;
        if (i10 == 0) {
            this.f4061j = -1;
        } else {
            int i12 = (i10 - 3) - i11;
            this.f4061j = i12;
            if (i12 < 0) {
                s1.b.p("PesReader", "Found negative packet payload size: " + this.f4061j);
                this.f4061j = -1;
            }
        }
        return true;
    }

    @Override // d4.i0
    public final void e(s1.z zVar, w2.q qVar, h0 h0Var) {
        this.f4058e = zVar;
        this.f4054a.g(qVar, h0Var);
    }
}
