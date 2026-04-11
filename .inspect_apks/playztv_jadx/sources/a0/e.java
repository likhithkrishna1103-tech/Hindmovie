package a0;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ViewGroup.MarginLayoutParams {
    public int A;
    public int B;
    public int C;
    public int D;
    public float E;
    public float F;
    public String G;
    public float H;
    public float I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public float R;
    public float S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public String Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f14a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f16b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f17c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f18c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f20d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f22e0;
    public int f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f23f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f24g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f25g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f27h0;
    public int i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f28i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f29j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f30j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f31k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f32k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f33l;
    public float l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f34m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f35m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f36n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f37n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f38o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f39o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f40p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public x.e f41p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f42q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f43r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f44s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f45t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f46u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f47v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f48w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f49x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f50y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f51z;

    public final void a() {
        this.f20d0 = false;
        this.f14a0 = true;
        this.f16b0 = true;
        int i = ((ViewGroup.MarginLayoutParams) this).width;
        if (i == -2 && this.W) {
            this.f14a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        int i10 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i10 == -2 && this.X) {
            this.f16b0 = false;
            if (this.M == 0) {
                this.M = 1;
            }
        }
        if (i == 0 || i == -1) {
            this.f14a0 = false;
            if (i == 0 && this.L == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.W = true;
            }
        }
        if (i10 == 0 || i10 == -1) {
            this.f16b0 = false;
            if (i10 == 0 && this.M == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.X = true;
            }
        }
        if (this.f17c == -1.0f && this.f13a == -1 && this.f15b == -1) {
            return;
        }
        this.f20d0 = true;
        this.f14a0 = true;
        this.f16b0 = true;
        if (!(this.f41p0 instanceof x.i)) {
            this.f41p0 = new x.i();
        }
        ((x.i) this.f41p0).S(this.V);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.e.resolveLayoutDirection(int):void");
    }
}
