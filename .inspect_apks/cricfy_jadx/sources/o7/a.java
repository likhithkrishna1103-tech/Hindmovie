package o7;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import g7.n;
import g7.s;
import g7.u;
import x6.l;
import z6.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {
    public boolean D;
    public boolean H;
    public boolean I;
    public boolean K;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9564v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9567y;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public m f9565w = m.f15290d;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bumptech.glide.h f9566x = com.bumptech.glide.h.f2211x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9568z = true;
    public int A = -1;
    public int B = -1;
    public x6.e C = r7.a.f10891b;
    public x6.h E = new x6.h();
    public s7.c F = new s7.c(0);
    public Class G = Object.class;
    public boolean J = true;

    public static boolean h(int i, int i10) {
        return (i & i10) != 0;
    }

    public a a(a aVar) {
        if (this.I) {
            return clone().a(aVar);
        }
        int i = aVar.f9564v;
        if (h(aVar.f9564v, 1048576)) {
            this.K = aVar.K;
        }
        if (h(aVar.f9564v, 4)) {
            this.f9565w = aVar.f9565w;
        }
        if (h(aVar.f9564v, 8)) {
            this.f9566x = aVar.f9566x;
        }
        if (h(aVar.f9564v, 16)) {
            this.f9564v &= -33;
        }
        if (h(aVar.f9564v, 32)) {
            this.f9564v &= -17;
        }
        if (h(aVar.f9564v, 64)) {
            this.f9567y = 0;
            this.f9564v &= -129;
        }
        if (h(aVar.f9564v, 128)) {
            this.f9567y = aVar.f9567y;
            this.f9564v &= -65;
        }
        if (h(aVar.f9564v, 256)) {
            this.f9568z = aVar.f9568z;
        }
        if (h(aVar.f9564v, 512)) {
            this.B = aVar.B;
            this.A = aVar.A;
        }
        if (h(aVar.f9564v, 1024)) {
            this.C = aVar.C;
        }
        if (h(aVar.f9564v, 4096)) {
            this.G = aVar.G;
        }
        if (h(aVar.f9564v, 8192)) {
            this.f9564v &= -16385;
        }
        if (h(aVar.f9564v, 16384)) {
            this.f9564v &= -8193;
        }
        if (h(aVar.f9564v, 131072)) {
            this.D = aVar.D;
        }
        if (h(aVar.f9564v, 2048)) {
            this.F.putAll(aVar.F);
            this.J = aVar.J;
        }
        this.f9564v |= aVar.f9564v;
        this.E.f14403b.g(aVar.E.f14403b);
        q();
        return this;
    }

    public a b() {
        if (this.H && !this.I) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.I = true;
        return i();
    }

    @Override // 
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            a aVar = (a) super.clone();
            x6.h hVar = new x6.h();
            aVar.E = hVar;
            hVar.f14403b.g(this.E.f14403b);
            s7.c cVar = new s7.c(0);
            aVar.F = cVar;
            cVar.putAll(this.F);
            aVar.H = false;
            aVar.I = false;
            return aVar;
        } catch (CloneNotSupportedException e9) {
            throw new RuntimeException(e9);
        }
    }

    public a d(Class cls) {
        if (this.I) {
            return clone().d(cls);
        }
        this.G = cls;
        this.f9564v |= 4096;
        q();
        return this;
    }

    public a e(m mVar) {
        if (this.I) {
            return clone().e(mVar);
        }
        this.f9565w = mVar;
        this.f9564v |= 4;
        q();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return g((a) obj);
        }
        return false;
    }

    public a f(n nVar) {
        return r(n.f5200g, nVar);
    }

    public final boolean g(a aVar) {
        aVar.getClass();
        if (Float.compare(1.0f, 1.0f) != 0) {
            return false;
        }
        char[] cArr = s7.m.f11607a;
        return this.f9567y == aVar.f9567y && this.f9568z == aVar.f9568z && this.A == aVar.A && this.B == aVar.B && this.D == aVar.D && this.f9565w.equals(aVar.f9565w) && this.f9566x == aVar.f9566x && this.E.equals(aVar.E) && this.F.equals(aVar.F) && this.G.equals(aVar.G) && this.C.equals(aVar.C);
    }

    public int hashCode() {
        char[] cArr = s7.m.f11607a;
        return s7.m.h(s7.m.h(s7.m.h(s7.m.h(s7.m.h(s7.m.h(s7.m.h(s7.m.g(0, s7.m.g(0, s7.m.g(1, s7.m.g(this.D ? 1 : 0, s7.m.g(this.B, s7.m.g(this.A, s7.m.g(this.f9568z ? 1 : 0, s7.m.h(s7.m.g(0, s7.m.h(s7.m.g(this.f9567y, s7.m.h(s7.m.g(0, s7.m.g(Float.floatToIntBits(1.0f), 17)), null)), null)), null)))))))), this.f9565w), this.f9566x), this.E), this.F), this.G), this.C), null);
    }

    public a i() {
        this.H = true;
        return this;
    }

    public a j() {
        return m(n.f5198d, new g7.h());
    }

    public a k() {
        a aVarM = m(n.f5197c, new g7.i());
        aVarM.J = true;
        return aVarM;
    }

    public a l() {
        a aVarM = m(n.f5196b, new u());
        aVarM.J = true;
        return aVarM;
    }

    public final a m(n nVar, g7.e eVar) {
        if (this.I) {
            return clone().m(nVar, eVar);
        }
        f(nVar);
        return v(eVar, false);
    }

    public a n(int i, int i10) {
        if (this.I) {
            return clone().n(i, i10);
        }
        this.B = i;
        this.A = i10;
        this.f9564v |= 512;
        q();
        return this;
    }

    public a o(int i) {
        if (this.I) {
            return clone().o(i);
        }
        this.f9567y = i;
        this.f9564v = (this.f9564v | 128) & (-65);
        q();
        return this;
    }

    public a p() {
        if (this.I) {
            return clone().p();
        }
        this.f9566x = com.bumptech.glide.h.f2212y;
        this.f9564v |= 8;
        q();
        return this;
    }

    public final void q() {
        if (this.H) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public a r(x6.g gVar, n nVar) {
        if (this.I) {
            return clone().r(gVar, nVar);
        }
        s7.f.b(gVar);
        this.E.f14403b.put(gVar, nVar);
        q();
        return this;
    }

    public a s(r7.b bVar) {
        if (this.I) {
            return clone().s(bVar);
        }
        this.C = bVar;
        this.f9564v |= 1024;
        q();
        return this;
    }

    public a t() {
        if (this.I) {
            return clone().t();
        }
        this.f9568z = false;
        this.f9564v |= 256;
        q();
        return this;
    }

    public final a u(Class cls, l lVar, boolean z10) {
        if (this.I) {
            return clone().u(cls, lVar, z10);
        }
        s7.f.b(lVar);
        this.F.put(cls, lVar);
        int i = this.f9564v;
        this.f9564v = 67584 | i;
        this.J = false;
        if (z10) {
            this.f9564v = i | 198656;
            this.D = true;
        }
        q();
        return this;
    }

    public final a v(l lVar, boolean z10) {
        if (this.I) {
            return clone().v(lVar, z10);
        }
        s sVar = new s(lVar, z10);
        u(Bitmap.class, lVar, z10);
        u(Drawable.class, sVar, z10);
        u(BitmapDrawable.class, sVar, z10);
        u(k7.b.class, new k7.c(lVar), z10);
        q();
        return this;
    }

    public a w() {
        if (this.I) {
            return clone().w();
        }
        this.K = true;
        this.f9564v |= 1048576;
        q();
        return this;
    }
}
