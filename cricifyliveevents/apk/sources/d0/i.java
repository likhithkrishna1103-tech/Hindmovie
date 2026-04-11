package d0;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f3131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f3132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f3133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f3134e;
    public HashMap f;

    public i() {
        l lVar = new l();
        lVar.f3182a = 0;
        lVar.f3183b = 0;
        lVar.f3184c = 1.0f;
        lVar.f3185d = Float.NaN;
        this.f3131b = lVar;
        k kVar = new k();
        kVar.f3175a = -1;
        kVar.f3176b = 0;
        kVar.f3177c = -1;
        kVar.f3178d = Float.NaN;
        kVar.f3179e = Float.NaN;
        kVar.f = Float.NaN;
        kVar.f3180g = -1;
        kVar.f3181h = null;
        kVar.i = -1;
        this.f3132c = kVar;
        j jVar = new j();
        jVar.f3136a = false;
        jVar.f3142d = -1;
        jVar.f3144e = -1;
        jVar.f = -1.0f;
        jVar.f3147g = true;
        jVar.f3149h = -1;
        jVar.i = -1;
        jVar.f3152j = -1;
        jVar.f3154k = -1;
        jVar.f3156l = -1;
        jVar.f3158m = -1;
        jVar.f3160n = -1;
        jVar.f3162o = -1;
        jVar.f3163p = -1;
        jVar.f3164q = -1;
        jVar.f3165r = -1;
        jVar.f3166s = -1;
        jVar.f3167t = -1;
        jVar.f3168u = -1;
        jVar.f3169v = -1;
        jVar.f3170w = 0.5f;
        jVar.f3171x = 0.5f;
        jVar.f3172y = null;
        jVar.f3173z = -1;
        jVar.A = 0;
        jVar.B = 0.0f;
        jVar.C = -1;
        jVar.D = -1;
        jVar.E = -1;
        jVar.F = 0;
        jVar.G = 0;
        jVar.H = 0;
        jVar.I = 0;
        jVar.J = 0;
        jVar.K = 0;
        jVar.L = 0;
        jVar.M = Integer.MIN_VALUE;
        jVar.N = Integer.MIN_VALUE;
        jVar.O = Integer.MIN_VALUE;
        jVar.P = Integer.MIN_VALUE;
        jVar.Q = Integer.MIN_VALUE;
        jVar.R = Integer.MIN_VALUE;
        jVar.S = Integer.MIN_VALUE;
        jVar.T = -1.0f;
        jVar.U = -1.0f;
        jVar.V = 0;
        jVar.W = 0;
        jVar.X = 0;
        jVar.Y = 0;
        jVar.Z = 0;
        jVar.f3137a0 = 0;
        jVar.f3139b0 = 0;
        jVar.f3141c0 = 0;
        jVar.f3143d0 = 1.0f;
        jVar.f3145e0 = 1.0f;
        jVar.f3146f0 = -1;
        jVar.f3148g0 = 0;
        jVar.f3150h0 = -1;
        jVar.f3157l0 = false;
        jVar.f3159m0 = false;
        jVar.f3161n0 = true;
        jVar.o0 = 0;
        this.f3133d = jVar;
        m mVar = new m();
        mVar.f3187a = 0.0f;
        mVar.f3188b = 0.0f;
        mVar.f3189c = 0.0f;
        mVar.f3190d = 1.0f;
        mVar.f3191e = 1.0f;
        mVar.f = Float.NaN;
        mVar.f3192g = Float.NaN;
        mVar.f3193h = -1;
        mVar.i = 0.0f;
        mVar.f3194j = 0.0f;
        mVar.f3195k = 0.0f;
        mVar.f3196l = false;
        mVar.f3197m = 0.0f;
        this.f3134e = mVar;
        this.f = new HashMap();
    }

    public final void a(e eVar) {
        j jVar = this.f3133d;
        eVar.f3077e = jVar.f3149h;
        eVar.f = jVar.i;
        eVar.f3080g = jVar.f3152j;
        eVar.f3082h = jVar.f3154k;
        eVar.i = jVar.f3156l;
        eVar.f3085j = jVar.f3158m;
        eVar.f3087k = jVar.f3160n;
        eVar.f3089l = jVar.f3162o;
        eVar.f3091m = jVar.f3163p;
        eVar.f3093n = jVar.f3164q;
        eVar.f3095o = jVar.f3165r;
        eVar.f3100s = jVar.f3166s;
        eVar.f3101t = jVar.f3167t;
        eVar.f3102u = jVar.f3168u;
        eVar.f3103v = jVar.f3169v;
        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = jVar.F;
        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = jVar.G;
        ((ViewGroup.MarginLayoutParams) eVar).topMargin = jVar.H;
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = jVar.I;
        eVar.A = jVar.R;
        eVar.B = jVar.Q;
        eVar.f3105x = jVar.N;
        eVar.f3107z = jVar.P;
        eVar.E = jVar.f3170w;
        eVar.F = jVar.f3171x;
        eVar.f3096p = jVar.f3173z;
        eVar.f3098q = jVar.A;
        eVar.f3099r = jVar.B;
        eVar.G = jVar.f3172y;
        eVar.T = jVar.C;
        eVar.U = jVar.D;
        eVar.I = jVar.T;
        eVar.H = jVar.U;
        eVar.K = jVar.W;
        eVar.J = jVar.V;
        eVar.W = jVar.f3157l0;
        eVar.X = jVar.f3159m0;
        eVar.L = jVar.X;
        eVar.M = jVar.Y;
        eVar.P = jVar.Z;
        eVar.Q = jVar.f3137a0;
        eVar.N = jVar.f3139b0;
        eVar.O = jVar.f3141c0;
        eVar.R = jVar.f3143d0;
        eVar.S = jVar.f3145e0;
        eVar.V = jVar.E;
        eVar.f3073c = jVar.f;
        eVar.f3069a = jVar.f3142d;
        eVar.f3071b = jVar.f3144e;
        ((ViewGroup.MarginLayoutParams) eVar).width = jVar.f3138b;
        ((ViewGroup.MarginLayoutParams) eVar).height = jVar.f3140c;
        String str = jVar.f3155k0;
        if (str != null) {
            eVar.Y = str;
        }
        eVar.Z = jVar.o0;
        eVar.setMarginStart(jVar.K);
        eVar.setMarginEnd(jVar.J);
        eVar.a();
    }

    public final Object clone() {
        i iVar = new i();
        j jVar = iVar.f3133d;
        jVar.getClass();
        j jVar2 = this.f3133d;
        jVar.f3136a = jVar2.f3136a;
        jVar.f3138b = jVar2.f3138b;
        jVar.f3140c = jVar2.f3140c;
        jVar.f3142d = jVar2.f3142d;
        jVar.f3144e = jVar2.f3144e;
        jVar.f = jVar2.f;
        jVar.f3147g = jVar2.f3147g;
        jVar.f3149h = jVar2.f3149h;
        jVar.i = jVar2.i;
        jVar.f3152j = jVar2.f3152j;
        jVar.f3154k = jVar2.f3154k;
        jVar.f3156l = jVar2.f3156l;
        jVar.f3158m = jVar2.f3158m;
        jVar.f3160n = jVar2.f3160n;
        jVar.f3162o = jVar2.f3162o;
        jVar.f3163p = jVar2.f3163p;
        jVar.f3164q = jVar2.f3164q;
        jVar.f3165r = jVar2.f3165r;
        jVar.f3166s = jVar2.f3166s;
        jVar.f3167t = jVar2.f3167t;
        jVar.f3168u = jVar2.f3168u;
        jVar.f3169v = jVar2.f3169v;
        jVar.f3170w = jVar2.f3170w;
        jVar.f3171x = jVar2.f3171x;
        jVar.f3172y = jVar2.f3172y;
        jVar.f3173z = jVar2.f3173z;
        jVar.A = jVar2.A;
        jVar.B = jVar2.B;
        jVar.C = jVar2.C;
        jVar.D = jVar2.D;
        jVar.E = jVar2.E;
        jVar.F = jVar2.F;
        jVar.G = jVar2.G;
        jVar.H = jVar2.H;
        jVar.I = jVar2.I;
        jVar.J = jVar2.J;
        jVar.K = jVar2.K;
        jVar.L = jVar2.L;
        jVar.M = jVar2.M;
        jVar.N = jVar2.N;
        jVar.O = jVar2.O;
        jVar.P = jVar2.P;
        jVar.Q = jVar2.Q;
        jVar.R = jVar2.R;
        jVar.S = jVar2.S;
        jVar.T = jVar2.T;
        jVar.U = jVar2.U;
        jVar.V = jVar2.V;
        jVar.W = jVar2.W;
        jVar.X = jVar2.X;
        jVar.Y = jVar2.Y;
        jVar.Z = jVar2.Z;
        jVar.f3137a0 = jVar2.f3137a0;
        jVar.f3139b0 = jVar2.f3139b0;
        jVar.f3141c0 = jVar2.f3141c0;
        jVar.f3143d0 = jVar2.f3143d0;
        jVar.f3145e0 = jVar2.f3145e0;
        jVar.f3146f0 = jVar2.f3146f0;
        jVar.f3148g0 = jVar2.f3148g0;
        jVar.f3150h0 = jVar2.f3150h0;
        jVar.f3155k0 = jVar2.f3155k0;
        int[] iArr = jVar2.f3151i0;
        if (iArr == null || jVar2.f3153j0 != null) {
            jVar.f3151i0 = null;
        } else {
            jVar.f3151i0 = Arrays.copyOf(iArr, iArr.length);
        }
        jVar.f3153j0 = jVar2.f3153j0;
        jVar.f3157l0 = jVar2.f3157l0;
        jVar.f3159m0 = jVar2.f3159m0;
        jVar.f3161n0 = jVar2.f3161n0;
        jVar.o0 = jVar2.o0;
        k kVar = iVar.f3132c;
        kVar.getClass();
        k kVar2 = this.f3132c;
        kVar2.getClass();
        kVar.f3175a = kVar2.f3175a;
        kVar.f3177c = kVar2.f3177c;
        kVar.f3179e = kVar2.f3179e;
        kVar.f3178d = kVar2.f3178d;
        l lVar = this.f3131b;
        int i = lVar.f3182a;
        l lVar2 = iVar.f3131b;
        lVar2.f3182a = i;
        lVar2.f3184c = lVar.f3184c;
        lVar2.f3185d = lVar.f3185d;
        lVar2.f3183b = lVar.f3183b;
        m mVar = iVar.f3134e;
        mVar.getClass();
        m mVar2 = this.f3134e;
        mVar2.getClass();
        mVar.f3187a = mVar2.f3187a;
        mVar.f3188b = mVar2.f3188b;
        mVar.f3189c = mVar2.f3189c;
        mVar.f3190d = mVar2.f3190d;
        mVar.f3191e = mVar2.f3191e;
        mVar.f = mVar2.f;
        mVar.f3192g = mVar2.f3192g;
        mVar.f3193h = mVar2.f3193h;
        mVar.i = mVar2.i;
        mVar.f3194j = mVar2.f3194j;
        mVar.f3195k = mVar2.f3195k;
        mVar.f3196l = mVar2.f3196l;
        mVar.f3197m = mVar2.f3197m;
        iVar.f3130a = this.f3130a;
        return iVar;
    }
}
