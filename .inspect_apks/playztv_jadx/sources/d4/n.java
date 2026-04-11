package d4;

import a2.u0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements i {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float[] f3923l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f3924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.u f3925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean[] f3926c = new boolean[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f3927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u0 f3928e;
    public m f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3930h;
    public w2.h0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3932k;

    public n(d0 d0Var) {
        this.f3924a = d0Var;
        l lVar = new l();
        lVar.f3915e = new byte[128];
        this.f3927d = lVar;
        this.f3932k = -9223372036854775807L;
        this.f3928e = new u0(178);
        this.f3925b = new s1.u();
    }

    @Override // d4.i
    public final void a() {
        t1.p.a(this.f3926c);
        l lVar = this.f3927d;
        lVar.f3911a = false;
        lVar.f3913c = 0;
        lVar.f3912b = 0;
        m mVar = this.f;
        if (mVar != null) {
            mVar.f3917b = false;
            mVar.f3918c = false;
            mVar.f3919d = false;
            mVar.f3920e = -1;
        }
        u0 u0Var = this.f3928e;
        if (u0Var != null) {
            u0Var.g();
        }
        this.f3929g = 0L;
        this.f3932k = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0236  */
    @Override // d4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(s1.u r20) {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.n.d(s1.u):void");
    }

    @Override // d4.i
    public final void e(boolean z2) {
        s1.d.h(this.f);
        if (z2) {
            this.f.b(0, this.f3929g, this.f3931j);
            m mVar = this.f;
            mVar.f3917b = false;
            mVar.f3918c = false;
            mVar.f3919d = false;
            mVar.f3920e = -1;
        }
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f3932k = j5;
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.f3930h = h0Var.f3889e;
        h0Var.b();
        w2.h0 h0VarQ = qVar.q(h0Var.f3888d, 2);
        this.i = h0VarQ;
        this.f = new m(h0VarQ);
        this.f3924a.b(qVar, h0Var);
    }
}
