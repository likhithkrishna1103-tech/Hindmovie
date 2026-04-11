package a0;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f77a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f78b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f79c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f80d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f81e;
    public HashMap f;

    public j() {
        m mVar = new m();
        mVar.f129a = 0;
        mVar.f130b = 0;
        mVar.f131c = 1.0f;
        mVar.f132d = Float.NaN;
        this.f78b = mVar;
        l lVar = new l();
        lVar.f122a = -1;
        lVar.f123b = 0;
        lVar.f124c = -1;
        lVar.f125d = Float.NaN;
        lVar.f126e = Float.NaN;
        lVar.f = Float.NaN;
        lVar.f127g = -1;
        lVar.f128h = null;
        lVar.i = -1;
        this.f79c = lVar;
        k kVar = new k();
        kVar.f83a = false;
        kVar.f89d = -1;
        kVar.f91e = -1;
        kVar.f = -1.0f;
        kVar.f94g = true;
        kVar.f96h = -1;
        kVar.i = -1;
        kVar.f99j = -1;
        kVar.f101k = -1;
        kVar.f103l = -1;
        kVar.f104m = -1;
        kVar.f106n = -1;
        kVar.f108o = -1;
        kVar.f110p = -1;
        kVar.f111q = -1;
        kVar.f112r = -1;
        kVar.f113s = -1;
        kVar.f114t = -1;
        kVar.f115u = -1;
        kVar.f116v = -1;
        kVar.f117w = 0.5f;
        kVar.f118x = 0.5f;
        kVar.f119y = null;
        kVar.f120z = -1;
        kVar.A = 0;
        kVar.B = 0.0f;
        kVar.C = -1;
        kVar.D = -1;
        kVar.E = -1;
        kVar.F = 0;
        kVar.G = 0;
        kVar.H = 0;
        kVar.I = 0;
        kVar.J = 0;
        kVar.K = 0;
        kVar.L = 0;
        kVar.M = Integer.MIN_VALUE;
        kVar.N = Integer.MIN_VALUE;
        kVar.O = Integer.MIN_VALUE;
        kVar.P = Integer.MIN_VALUE;
        kVar.Q = Integer.MIN_VALUE;
        kVar.R = Integer.MIN_VALUE;
        kVar.S = Integer.MIN_VALUE;
        kVar.T = -1.0f;
        kVar.U = -1.0f;
        kVar.V = 0;
        kVar.W = 0;
        kVar.X = 0;
        kVar.Y = 0;
        kVar.Z = 0;
        kVar.f84a0 = 0;
        kVar.f86b0 = 0;
        kVar.f88c0 = 0;
        kVar.f90d0 = 1.0f;
        kVar.f92e0 = 1.0f;
        kVar.f93f0 = -1;
        kVar.f95g0 = 0;
        kVar.f97h0 = -1;
        kVar.l0 = false;
        kVar.f105m0 = false;
        kVar.f107n0 = true;
        kVar.f109o0 = 0;
        this.f80d = kVar;
        n nVar = new n();
        nVar.f134a = 0.0f;
        nVar.f135b = 0.0f;
        nVar.f136c = 0.0f;
        nVar.f137d = 1.0f;
        nVar.f138e = 1.0f;
        nVar.f = Float.NaN;
        nVar.f139g = Float.NaN;
        nVar.f140h = -1;
        nVar.i = 0.0f;
        nVar.f141j = 0.0f;
        nVar.f142k = 0.0f;
        nVar.f143l = false;
        nVar.f144m = 0.0f;
        this.f81e = nVar;
        this.f = new HashMap();
    }

    public final void a(e eVar) {
        k kVar = this.f80d;
        eVar.f21e = kVar.f96h;
        eVar.f = kVar.i;
        eVar.f24g = kVar.f99j;
        eVar.f26h = kVar.f101k;
        eVar.i = kVar.f103l;
        eVar.f29j = kVar.f104m;
        eVar.f31k = kVar.f106n;
        eVar.f33l = kVar.f108o;
        eVar.f34m = kVar.f110p;
        eVar.f36n = kVar.f111q;
        eVar.f38o = kVar.f112r;
        eVar.f44s = kVar.f113s;
        eVar.f45t = kVar.f114t;
        eVar.f46u = kVar.f115u;
        eVar.f47v = kVar.f116v;
        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = kVar.F;
        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = kVar.G;
        ((ViewGroup.MarginLayoutParams) eVar).topMargin = kVar.H;
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = kVar.I;
        eVar.A = kVar.R;
        eVar.B = kVar.Q;
        eVar.f49x = kVar.N;
        eVar.f51z = kVar.P;
        eVar.E = kVar.f117w;
        eVar.F = kVar.f118x;
        eVar.f40p = kVar.f120z;
        eVar.f42q = kVar.A;
        eVar.f43r = kVar.B;
        eVar.G = kVar.f119y;
        eVar.T = kVar.C;
        eVar.U = kVar.D;
        eVar.I = kVar.T;
        eVar.H = kVar.U;
        eVar.K = kVar.W;
        eVar.J = kVar.V;
        eVar.W = kVar.l0;
        eVar.X = kVar.f105m0;
        eVar.L = kVar.X;
        eVar.M = kVar.Y;
        eVar.P = kVar.Z;
        eVar.Q = kVar.f84a0;
        eVar.N = kVar.f86b0;
        eVar.O = kVar.f88c0;
        eVar.R = kVar.f90d0;
        eVar.S = kVar.f92e0;
        eVar.V = kVar.E;
        eVar.f17c = kVar.f;
        eVar.f13a = kVar.f89d;
        eVar.f15b = kVar.f91e;
        ((ViewGroup.MarginLayoutParams) eVar).width = kVar.f85b;
        ((ViewGroup.MarginLayoutParams) eVar).height = kVar.f87c;
        String str = kVar.f102k0;
        if (str != null) {
            eVar.Y = str;
        }
        eVar.Z = kVar.f109o0;
        eVar.setMarginStart(kVar.K);
        eVar.setMarginEnd(kVar.J);
        eVar.a();
    }

    public final Object clone() {
        j jVar = new j();
        k kVar = jVar.f80d;
        kVar.getClass();
        k kVar2 = this.f80d;
        kVar.f83a = kVar2.f83a;
        kVar.f85b = kVar2.f85b;
        kVar.f87c = kVar2.f87c;
        kVar.f89d = kVar2.f89d;
        kVar.f91e = kVar2.f91e;
        kVar.f = kVar2.f;
        kVar.f94g = kVar2.f94g;
        kVar.f96h = kVar2.f96h;
        kVar.i = kVar2.i;
        kVar.f99j = kVar2.f99j;
        kVar.f101k = kVar2.f101k;
        kVar.f103l = kVar2.f103l;
        kVar.f104m = kVar2.f104m;
        kVar.f106n = kVar2.f106n;
        kVar.f108o = kVar2.f108o;
        kVar.f110p = kVar2.f110p;
        kVar.f111q = kVar2.f111q;
        kVar.f112r = kVar2.f112r;
        kVar.f113s = kVar2.f113s;
        kVar.f114t = kVar2.f114t;
        kVar.f115u = kVar2.f115u;
        kVar.f116v = kVar2.f116v;
        kVar.f117w = kVar2.f117w;
        kVar.f118x = kVar2.f118x;
        kVar.f119y = kVar2.f119y;
        kVar.f120z = kVar2.f120z;
        kVar.A = kVar2.A;
        kVar.B = kVar2.B;
        kVar.C = kVar2.C;
        kVar.D = kVar2.D;
        kVar.E = kVar2.E;
        kVar.F = kVar2.F;
        kVar.G = kVar2.G;
        kVar.H = kVar2.H;
        kVar.I = kVar2.I;
        kVar.J = kVar2.J;
        kVar.K = kVar2.K;
        kVar.L = kVar2.L;
        kVar.M = kVar2.M;
        kVar.N = kVar2.N;
        kVar.O = kVar2.O;
        kVar.P = kVar2.P;
        kVar.Q = kVar2.Q;
        kVar.R = kVar2.R;
        kVar.S = kVar2.S;
        kVar.T = kVar2.T;
        kVar.U = kVar2.U;
        kVar.V = kVar2.V;
        kVar.W = kVar2.W;
        kVar.X = kVar2.X;
        kVar.Y = kVar2.Y;
        kVar.Z = kVar2.Z;
        kVar.f84a0 = kVar2.f84a0;
        kVar.f86b0 = kVar2.f86b0;
        kVar.f88c0 = kVar2.f88c0;
        kVar.f90d0 = kVar2.f90d0;
        kVar.f92e0 = kVar2.f92e0;
        kVar.f93f0 = kVar2.f93f0;
        kVar.f95g0 = kVar2.f95g0;
        kVar.f97h0 = kVar2.f97h0;
        kVar.f102k0 = kVar2.f102k0;
        int[] iArr = kVar2.f98i0;
        if (iArr == null || kVar2.f100j0 != null) {
            kVar.f98i0 = null;
        } else {
            kVar.f98i0 = Arrays.copyOf(iArr, iArr.length);
        }
        kVar.f100j0 = kVar2.f100j0;
        kVar.l0 = kVar2.l0;
        kVar.f105m0 = kVar2.f105m0;
        kVar.f107n0 = kVar2.f107n0;
        kVar.f109o0 = kVar2.f109o0;
        l lVar = jVar.f79c;
        lVar.getClass();
        l lVar2 = this.f79c;
        lVar2.getClass();
        lVar.f122a = lVar2.f122a;
        lVar.f124c = lVar2.f124c;
        lVar.f126e = lVar2.f126e;
        lVar.f125d = lVar2.f125d;
        m mVar = this.f78b;
        int i = mVar.f129a;
        m mVar2 = jVar.f78b;
        mVar2.f129a = i;
        mVar2.f131c = mVar.f131c;
        mVar2.f132d = mVar.f132d;
        mVar2.f130b = mVar.f130b;
        n nVar = jVar.f81e;
        nVar.getClass();
        n nVar2 = this.f81e;
        nVar2.getClass();
        nVar.f134a = nVar2.f134a;
        nVar.f135b = nVar2.f135b;
        nVar.f136c = nVar2.f136c;
        nVar.f137d = nVar2.f137d;
        nVar.f138e = nVar2.f138e;
        nVar.f = nVar2.f;
        nVar.f139g = nVar2.f139g;
        nVar.f140h = nVar2.f140h;
        nVar.i = nVar2.i;
        nVar.f141j = nVar2.f141j;
        nVar.f142k = nVar2.f142k;
        nVar.f143l = nVar2.f143l;
        nVar.f144m = nVar2.f144m;
        jVar.f77a = this.f77a;
        return jVar;
    }
}
