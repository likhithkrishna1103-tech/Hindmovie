package d0;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
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
    public int f3069a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f3070a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3071b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f3072b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3073c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f3074c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3075d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f3076d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3077e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f3078e0;
    public int f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f3079f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3080g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f3081g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3082h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f3083h0;
    public int i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f3084i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3085j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f3086j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3087k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f3088k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3089l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f3090l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3091m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f3092m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3093n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f3094n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3095o;
    public float o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3096p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public a0.d f3097p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3098q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3099r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3100s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3101t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3102u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3103v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3104w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3105x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3106y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3107z;

    public final void a() {
        this.f3076d0 = false;
        this.f3070a0 = true;
        this.f3072b0 = true;
        int i = ((ViewGroup.MarginLayoutParams) this).width;
        if (i == -2 && this.W) {
            this.f3070a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        int i10 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i10 == -2 && this.X) {
            this.f3072b0 = false;
            if (this.M == 0) {
                this.M = 1;
            }
        }
        if (i == 0 || i == -1) {
            this.f3070a0 = false;
            if (i == 0 && this.L == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.W = true;
            }
        }
        if (i10 == 0 || i10 == -1) {
            this.f3072b0 = false;
            if (i10 == 0 && this.M == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.X = true;
            }
        }
        if (this.f3073c == -1.0f && this.f3069a == -1 && this.f3071b == -1) {
            return;
        }
        this.f3076d0 = true;
        this.f3070a0 = true;
        this.f3072b0 = true;
        if (!(this.f3097p0 instanceof a0.h)) {
            this.f3097p0 = new a0.h();
        }
        ((a0.h) this.f3097p0).S(this.V);
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
        throw new UnsupportedOperationException("Method not decompiled: d0.e.resolveLayoutDirection(int):void");
    }
}
