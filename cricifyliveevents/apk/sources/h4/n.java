package h4;

import a3.i0;
import g2.l0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements i {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f5686l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f5687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.t f5688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean[] f5689c = new boolean[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f5690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l0 f5691e;
    public m f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5693h;
    public i0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f5695k;

    public n(d0 d0Var) {
        this.f5687a = d0Var;
        l lVar = new l();
        lVar.f5678e = new byte[128];
        this.f5690d = lVar;
        this.f5695k = -9223372036854775807L;
        this.f5691e = new l0(178);
        this.f5688b = new y1.t();
    }

    @Override // h4.i
    public final void a() {
        z1.o.a(this.f5689c);
        l lVar = this.f5690d;
        lVar.f5674a = false;
        lVar.f5676c = 0;
        lVar.f5675b = 0;
        m mVar = this.f;
        if (mVar != null) {
            mVar.f5680b = false;
            mVar.f5681c = false;
            mVar.f5682d = false;
            mVar.f5683e = -1;
        }
        l0 l0Var = this.f5691e;
        if (l0Var != null) {
            l0Var.g();
        }
        this.f5692g = 0L;
        this.f5695k = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0236  */
    @Override // h4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(y1.t r20) {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.n.b(y1.t):void");
    }

    @Override // h4.i
    public final void c(boolean z10) {
        y1.d.h(this.f);
        if (z10) {
            this.f.b(0, this.f5692g, this.f5694j);
            m mVar = this.f;
            mVar.f5680b = false;
            mVar.f5681c = false;
            mVar.f5682d = false;
            mVar.f5683e = -1;
        }
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5695k = j4;
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.f5693h = g0Var.f5646e;
        g0Var.b();
        i0 i0VarP = rVar.p(g0Var.f5645d, 2);
        this.i = i0VarP;
        this.f = new m(i0VarP);
        this.f5687a.b(rVar, g0Var);
    }
}
