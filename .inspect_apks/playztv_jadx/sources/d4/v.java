package d4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4036e;
    public w2.h0 f;
    public boolean i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4041l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4043n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4044o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4048s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4050u;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4035d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1.u f4032a = new s1.u(2, new byte[15]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.t f4033b = new s1.t();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f4034c = new s1.u();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final w f4045p = new w();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4046q = -2147483647;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4047r = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f4049t = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4039j = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4042m = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f4037g = -9.223372036854776E18d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f4038h = -9.223372036854776E18d;

    @Override // d4.i
    public final void a() {
        this.f4035d = 0;
        this.f4041l = 0;
        this.f4032a.G(2);
        this.f4043n = 0;
        this.f4044o = 0;
        this.f4046q = -2147483647;
        this.f4047r = -1;
        this.f4048s = 0;
        this.f4049t = -1L;
        this.f4050u = false;
        this.i = false;
        this.f4042m = true;
        this.f4039j = true;
        this.f4037g = -9.223372036854776E18d;
        this.f4038h = -9.223372036854776E18d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0420  */
    @Override // d4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(s1.u r25) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 1376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.v.d(s1.u):void");
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f4040k = i;
        if (!this.f4039j && (this.f4044o != 0 || !this.f4042m)) {
            this.i = true;
        }
        if (j5 != -9223372036854775807L) {
            if (this.i) {
                this.f4038h = j5;
            } else {
                this.f4037g = j5;
            }
        }
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.f4036e = h0Var.f3889e;
        h0Var.b();
        this.f = qVar.q(h0Var.f3888d, 1);
    }

    @Override // d4.i
    public final void e(boolean z2) {
    }
}
