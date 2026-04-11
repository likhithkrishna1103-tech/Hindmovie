package t6;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import e6.m;
import l6.r;
import l6.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {
    public boolean C;
    public boolean G;
    public Resources.Theme H;
    public boolean I;
    public boolean K;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12202u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12205x;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public m f12203v = m.f4537d;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.bumptech.glide.f f12204w = com.bumptech.glide.f.f2782w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12206y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12207z = -1;
    public int A = -1;
    public c6.f B = w6.c.f13747b;
    public c6.i D = new c6.i();
    public x6.c E = new x6.c(0);
    public Class F = Object.class;
    public boolean J = true;

    public static boolean h(int i, int i10) {
        return (i & i10) != 0;
    }

    public a a(a aVar) {
        if (this.I) {
            return clone().a(aVar);
        }
        int i = aVar.f12202u;
        if (h(aVar.f12202u, 1048576)) {
            this.K = aVar.K;
        }
        if (h(aVar.f12202u, 4)) {
            this.f12203v = aVar.f12203v;
        }
        if (h(aVar.f12202u, 8)) {
            this.f12204w = aVar.f12204w;
        }
        if (h(aVar.f12202u, 16)) {
            this.f12202u &= -33;
        }
        if (h(aVar.f12202u, 32)) {
            this.f12202u &= -17;
        }
        if (h(aVar.f12202u, 64)) {
            this.f12205x = 0;
            this.f12202u &= -129;
        }
        if (h(aVar.f12202u, 128)) {
            this.f12205x = aVar.f12205x;
            this.f12202u &= -65;
        }
        if (h(aVar.f12202u, 256)) {
            this.f12206y = aVar.f12206y;
        }
        if (h(aVar.f12202u, 512)) {
            this.A = aVar.A;
            this.f12207z = aVar.f12207z;
        }
        if (h(aVar.f12202u, 1024)) {
            this.B = aVar.B;
        }
        if (h(aVar.f12202u, 4096)) {
            this.F = aVar.F;
        }
        if (h(aVar.f12202u, 8192)) {
            this.f12202u &= -16385;
        }
        if (h(aVar.f12202u, 16384)) {
            this.f12202u &= -8193;
        }
        if (h(aVar.f12202u, 32768)) {
            this.H = aVar.H;
        }
        if (h(aVar.f12202u, 131072)) {
            this.C = aVar.C;
        }
        if (h(aVar.f12202u, 2048)) {
            this.E.putAll(aVar.E);
            this.J = aVar.J;
        }
        this.f12202u |= aVar.f12202u;
        this.D.f2521b.g(aVar.D.f2521b);
        r();
        return this;
    }

    public a b() {
        if (this.G && !this.I) {
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
            c6.i iVar = new c6.i();
            aVar.D = iVar;
            iVar.f2521b.g(this.D.f2521b);
            x6.c cVar = new x6.c(0);
            aVar.E = cVar;
            cVar.putAll(this.E);
            aVar.G = false;
            aVar.I = false;
            return aVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public a d(Class cls) {
        if (this.I) {
            return clone().d(cls);
        }
        this.F = cls;
        this.f12202u |= 4096;
        r();
        return this;
    }

    public a e(m mVar) {
        if (this.I) {
            return clone().e(mVar);
        }
        this.f12203v = mVar;
        this.f12202u |= 4;
        r();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return g((a) obj);
        }
        return false;
    }

    public a f(l6.m mVar) {
        return s(l6.m.f7984g, mVar);
    }

    public final boolean g(a aVar) {
        aVar.getClass();
        if (Float.compare(1.0f, 1.0f) != 0) {
            return false;
        }
        char[] cArr = x6.m.f14291a;
        return this.f12205x == aVar.f12205x && this.f12206y == aVar.f12206y && this.f12207z == aVar.f12207z && this.A == aVar.A && this.C == aVar.C && this.f12203v.equals(aVar.f12203v) && this.f12204w == aVar.f12204w && this.D.equals(aVar.D) && this.E.equals(aVar.E) && this.F.equals(aVar.F) && this.B.equals(aVar.B) && x6.m.b(this.H, aVar.H);
    }

    public int hashCode() {
        char[] cArr = x6.m.f14291a;
        return x6.m.h(x6.m.h(x6.m.h(x6.m.h(x6.m.h(x6.m.h(x6.m.h(x6.m.g(0, x6.m.g(0, x6.m.g(1, x6.m.g(this.C ? 1 : 0, x6.m.g(this.A, x6.m.g(this.f12207z, x6.m.g(this.f12206y ? 1 : 0, x6.m.h(x6.m.g(0, x6.m.h(x6.m.g(this.f12205x, x6.m.h(x6.m.g(0, x6.m.g(Float.floatToIntBits(1.0f), 17)), null)), null)), null)))))))), this.f12203v), this.f12204w), this.D), this.E), this.F), this.B), this.H);
    }

    public a i() {
        this.G = true;
        return this;
    }

    public a j() {
        return m(l6.m.f7982d, new l6.h());
    }

    public a k() {
        a aVarM = m(l6.m.f7981c, new l6.i());
        aVarM.J = true;
        return aVarM;
    }

    public a l() {
        a aVarM = m(l6.m.f7980b, new t());
        aVarM.J = true;
        return aVarM;
    }

    public final a m(l6.m mVar, l6.e eVar) {
        if (this.I) {
            return clone().m(mVar, eVar);
        }
        f(mVar);
        return w(eVar, false);
    }

    public a n(int i, int i10) {
        if (this.I) {
            return clone().n(i, i10);
        }
        this.A = i;
        this.f12207z = i10;
        this.f12202u |= 512;
        r();
        return this;
    }

    public a o(int i) {
        if (this.I) {
            return clone().o(i);
        }
        this.f12205x = i;
        this.f12202u = (this.f12202u | 128) & (-65);
        r();
        return this;
    }

    public a p() {
        if (this.I) {
            return clone().p();
        }
        this.f12204w = com.bumptech.glide.f.f2783x;
        this.f12202u |= 8;
        r();
        return this;
    }

    public final a q(c6.h hVar) {
        if (this.I) {
            return clone().q(hVar);
        }
        this.D.f2521b.remove(hVar);
        r();
        return this;
    }

    public final void r() {
        if (this.G) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public a s(c6.h hVar, Object obj) {
        if (this.I) {
            return clone().s(hVar, obj);
        }
        x6.f.b(hVar);
        x6.f.b(obj);
        this.D.f2521b.put(hVar, obj);
        r();
        return this;
    }

    public a t(c6.f fVar) {
        if (this.I) {
            return clone().t(fVar);
        }
        this.B = fVar;
        this.f12202u |= 1024;
        r();
        return this;
    }

    public a u() {
        if (this.I) {
            return clone().u();
        }
        this.f12206y = false;
        this.f12202u |= 256;
        r();
        return this;
    }

    public a v(Resources.Theme theme) {
        if (this.I) {
            return clone().v(theme);
        }
        this.H = theme;
        if (theme != null) {
            this.f12202u |= 32768;
            return s(n6.c.f8821b, theme);
        }
        this.f12202u &= -32769;
        return q(n6.c.f8821b);
    }

    public final a w(c6.m mVar, boolean z2) {
        if (this.I) {
            return clone().w(mVar, z2);
        }
        r rVar = new r(mVar, z2);
        x(Bitmap.class, mVar, z2);
        x(Drawable.class, rVar, z2);
        x(BitmapDrawable.class, rVar, z2);
        x(p6.b.class, new p6.c(mVar), z2);
        r();
        return this;
    }

    public final a x(Class cls, c6.m mVar, boolean z2) {
        if (this.I) {
            return clone().x(cls, mVar, z2);
        }
        x6.f.b(mVar);
        this.E.put(cls, mVar);
        int i = this.f12202u;
        this.f12202u = 67584 | i;
        this.J = false;
        if (z2) {
            this.f12202u = i | 198656;
            this.C = true;
        }
        r();
        return this;
    }

    public a y() {
        if (this.I) {
            return clone().y();
        }
        this.K = true;
        this.f12202u |= 1048576;
        r();
        return this;
    }
}
