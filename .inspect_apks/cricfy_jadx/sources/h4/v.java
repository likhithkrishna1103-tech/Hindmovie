package h4;

import a3.i0;
import a3.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5799e;
    public i0 f;
    public boolean i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5803k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5804l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5806n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5807o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5811s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f5813u;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5798d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y1.t f5795a = new y1.t(2, new byte[15]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f5796b = new k0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f5797c = new y1.t();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final w f5808p = new w();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5809q = -2147483647;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5810r = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f5812t = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5802j = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5805m = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f5800g = -9.223372036854776E18d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f5801h = -9.223372036854776E18d;

    @Override // h4.i
    public final void a() {
        this.f5798d = 0;
        this.f5804l = 0;
        this.f5795a.G(2);
        this.f5806n = 0;
        this.f5807o = 0;
        this.f5809q = -2147483647;
        this.f5810r = -1;
        this.f5811s = 0;
        this.f5812t = -1L;
        this.f5813u = false;
        this.i = false;
        this.f5805m = true;
        this.f5802j = true;
        this.f5800g = -9.223372036854776E18d;
        this.f5801h = -9.223372036854776E18d;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0420  */
    @Override // h4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(y1.t r25) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 1376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.v.b(y1.t):void");
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5803k = i;
        if (!this.f5802j && (this.f5807o != 0 || !this.f5805m)) {
            this.i = true;
        }
        if (j4 != -9223372036854775807L) {
            if (this.i) {
                this.f5801h = j4;
            } else {
                this.f5800g = j4;
            }
        }
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.f5799e = g0Var.f5646e;
        g0Var.b();
        this.f = rVar.p(g0Var.f5645d, 1);
    }

    @Override // h4.i
    public final void c(boolean z10) {
    }
}
