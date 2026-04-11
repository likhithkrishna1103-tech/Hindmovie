package g4;

import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z implements p1.u0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final WeakReference f5257u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final WeakReference f5258v;

    public z(b0 b0Var, j1 j1Var) {
        this.f5257u = new WeakReference(b0Var);
        this.f5258v = new WeakReference(j1Var);
    }

    @Override // p1.u0
    public final void B(int i, boolean z2) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        b0VarC.f4972s = h1Var.b(i, h1Var.f5081x, z2);
        b0VarC.f4958c.a(true, true);
        try {
            m0 m0Var = (m0) b0VarC.f4962h.i.f5101y;
            m0Var.N(m0Var.f5115g.f4973t);
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    @Override // p1.u0
    public final void C(float f) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z2 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z10 = h1Var.f5076s;
        boolean z11 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z12 = h1Var.f5079v;
        boolean z13 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var = h1Var.E;
        s1.d.g(f1Var.p() || p1Var.f5170a.f10081b < f1Var.o());
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z2, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z10, z11, i14, i15, i16, z12, z13, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
        try {
            b0VarC.f4962h.i.getClass();
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    @Override // p1.u0
    public final void E(int i) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        j1 j1Var = (j1) this.f5258v.get();
        if (j1Var == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0VarK = j1Var.k();
        int i10 = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i11 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i12 = h1Var.f5066h;
        boolean z2 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i13 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i14 = h1Var.f5075r;
        boolean z10 = h1Var.f5076s;
        boolean z11 = h1Var.f5077t;
        int i15 = h1Var.f5078u;
        boolean z12 = h1Var.f5080w;
        int i16 = h1Var.f5081x;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var = h1Var.E;
        boolean z13 = i == 3 && z11 && i16 == 0;
        s1.d.g(f1Var.p() || p1Var.f5170a.f10081b < f1Var.o());
        b0VarC.f4972s = new h1(p0VarK, i10, p1Var, v0Var, v0Var2, i11, q0Var, i12, z2, r1Var, f1Var, i13, j0Var, f, dVar, cVar, jVar, i14, z10, z11, i15, i16, i, z13, z12, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
        try {
            k0 k0Var = b0VarC.f4962h.i;
            j1Var.k();
            m0 m0Var = (m0) k0Var.f5101y;
            m0Var.N(m0Var.f5115g.f4973t);
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    @Override // p1.u0
    public final void F(int i, p1.v0 v0Var, p1.v0 v0Var2) {
        p1.l1 l1Var;
        boolean z2;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i10 = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        try {
            if (!f1Var.p()) {
                l1Var = l1Var2;
                if (p1Var.f5170a.f10081b >= f1Var.o()) {
                    z2 = false;
                }
                s1.d.g(z2);
                b0VarC.f4972s = new h1(p0Var, i10, p1Var, v0Var, v0Var2, i, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
                b0VarC.f4958c.a(true, true);
                m0 m0Var = (m0) b0VarC.f4962h.i.f5101y;
                m0Var.N(m0Var.f5115g.f4973t);
                return;
            }
            l1Var = l1Var2;
            m0 m0Var2 = (m0) b0VarC.f4962h.i.f5101y;
            m0Var2.N(m0Var2.f5115g.f4973t);
            return;
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
            return;
        }
        z2 = true;
        s1.d.g(z2);
        b0VarC.f4972s = new h1(p0Var, i10, p1Var, v0Var, v0Var2, i, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final void G(boolean z2) {
        p1.l1 l1Var;
        boolean z10;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        try {
            if (!f1Var.p()) {
                l1Var = l1Var2;
                if (p1Var.f5170a.f10081b >= f1Var.o()) {
                    z10 = false;
                }
                s1.d.g(z10);
                b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z2, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
                b0VarC.f4958c.a(true, true);
                b0VarC.f4962h.i.t(z2);
                return;
            }
            l1Var = l1Var2;
            b0VarC.f4962h.i.t(z2);
            return;
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
            return;
        }
        z10 = true;
        s1.d.g(z10);
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z2, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final void K(p1.p0 p0Var) {
        p1.l1 l1Var;
        boolean z2;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        try {
            if (!f1Var.p()) {
                l1Var = l1Var2;
                if (p1Var.f5170a.f10081b >= f1Var.o()) {
                    z2 = false;
                }
                s1.d.g(z2);
                b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
                b0VarC.f4958c.a(true, true);
                m0 m0Var = (m0) b0VarC.f4962h.i.f5101y;
                m0Var.N(m0Var.f5115g.f4973t);
                return;
            }
            l1Var = l1Var2;
            m0 m0Var2 = (m0) b0VarC.f4962h.i.f5101y;
            m0Var2.N(m0Var2.f5115g.f4973t);
            return;
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
            return;
        }
        z2 = true;
        s1.d.g(z2);
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final void N(p1.l1 l1Var) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        b0VarC.f4972s = b0VarC.f4972s.d(l1Var);
        b0VarC.f4958c.a(true, true);
        b0VarC.d(new b2.f(18, l1Var));
    }

    @Override // p1.u0
    public final void O(p1.q0 q0Var) {
        p1.l1 l1Var;
        boolean z2;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        try {
            if (!f1Var.p()) {
                l1Var = l1Var2;
                if (p1Var.f5170a.f10081b >= f1Var.o()) {
                    z2 = false;
                }
                s1.d.g(z2);
                b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
                b0VarC.f4958c.a(true, true);
                m0 m0Var = (m0) b0VarC.f4962h.i.f5101y;
                m0Var.N(m0Var.f5115g.f4973t);
                return;
            }
            l1Var = l1Var2;
            m0 m0Var2 = (m0) b0VarC.f4962h.i.f5101y;
            m0Var2.N(m0Var2.f5115g.f4973t);
            return;
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
            return;
        }
        z2 = true;
        s1.d.g(z2);
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final void P(boolean z2) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var = h1Var.E;
        s1.d.g(f1Var.p() || p1Var.f5170a.f10081b < f1Var.o());
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z2, z13, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
        try {
            m0 m0Var = (m0) b0VarC.f4962h.i.f5101y;
            m0Var.N(m0Var.f5115g.f4973t);
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
        b0VarC.t();
    }

    @Override // p1.u0
    public final void b(p1.r1 r1Var) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z2 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z10 = h1Var.f5076s;
        boolean z11 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z12 = h1Var.f5079v;
        boolean z13 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var = h1Var.E;
        s1.d.g(f1Var.p() || p1Var.f5170a.f10081b < f1Var.o());
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z2, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z10, z11, i14, i15, i16, z12, z13, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
        try {
            b0VarC.f4962h.i.getClass();
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    public final b0 c() {
        return (b0) this.f5257u.get();
    }

    @Override // p1.u0
    public final void d(int i) {
        p1.l1 l1Var;
        boolean z2;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i10 = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i11 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        try {
            if (!f1Var.p()) {
                l1Var = l1Var2;
                if (p1Var.f5170a.f10081b >= f1Var.o()) {
                    z2 = false;
                }
                s1.d.g(z2);
                b0VarC.f4972s = new h1(p0Var, i10, p1Var, v0Var, v0Var2, i11, q0Var, i, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
                b0VarC.f4958c.a(true, true);
                b0VarC.f4962h.i.s(i);
                return;
            }
            l1Var = l1Var2;
            b0VarC.f4962h.i.s(i);
            return;
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
            return;
        }
        z2 = true;
        s1.d.g(z2);
        b0VarC.f4972s = new h1(p0Var, i10, p1Var, v0Var, v0Var2, i11, q0Var, i, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final void f(int i) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        b0VarC.f4972s = h1Var.b(h1Var.f5078u, i, h1Var.f5077t);
        b0VarC.f4958c.a(true, true);
        try {
            m0 m0Var = (m0) b0VarC.f4962h.i.f5101y;
            m0Var.N(m0Var.f5115g.f4973t);
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    @Override // p1.u0
    public final void h(p1.j0 j0Var) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z2 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z10 = h1Var.f5076s;
        boolean z11 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z12 = h1Var.f5079v;
        boolean z13 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var = h1Var.E;
        s1.d.g(f1Var.p() || p1Var.f5170a.f10081b < f1Var.o());
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z2, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z10, z11, i14, i15, i16, z12, z13, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
        try {
            b0VarC.f4962h.i.r(j0Var);
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    @Override // p1.u0
    public final void k(p1.f1 f1Var, int i) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        j1 j1Var = (j1) this.f5258v.get();
        if (j1Var == null) {
            return;
        }
        b0VarC.f4972s = b0VarC.f4972s.c(f1Var, j1Var.b(), i);
        b0VarC.f4958c.a(false, true);
        try {
            b0VarC.f4962h.i.u(f1Var);
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
    }

    @Override // p1.u0
    public final void n(p1.j0 j0Var) {
        p1.l1 l1Var;
        boolean z2;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var2 = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        try {
            if (!f1Var.p()) {
                l1Var = l1Var2;
                if (p1Var.f5170a.f10081b >= f1Var.o()) {
                    z2 = false;
                }
                s1.d.g(z2);
                b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var2, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var, j5, j8, j10, n1Var, l1Var);
                b0VarC.f4958c.a(true, true);
                b0VarC.f4962h.i.v();
                return;
            }
            l1Var = l1Var2;
            b0VarC.f4962h.i.v();
            return;
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
            return;
        }
        z2 = true;
        s1.d.g(z2);
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var2, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final void o(int i, p1.g0 g0Var) {
        p1.l1 l1Var;
        boolean z2;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        try {
            if (!f1Var.p()) {
                l1Var = l1Var2;
                if (p1Var.f5170a.f10081b >= f1Var.o()) {
                    z2 = false;
                }
                s1.d.g(z2);
                b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
                b0VarC.f4958c.a(true, true);
                b0VarC.f4962h.i.o(g0Var);
                return;
            }
            l1Var = l1Var2;
            b0VarC.f4962h.i.o(g0Var);
            return;
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
            return;
        }
        z2 = true;
        s1.d.g(z2);
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final void p(p1.s0 s0Var) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        b0VarC.f(s0Var);
    }

    @Override // p1.u0
    public final void q(p1.n1 n1Var) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        b0VarC.f4972s = b0VarC.f4972s.a(n1Var);
        b0VarC.f4958c.a(true, false);
        b0VarC.d(new b2.f(19, n1Var));
    }

    @Override // p1.u0
    public final void t(boolean z2) {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var = h1Var.E;
        s1.d.g(f1Var.p() || p1Var.f5170a.f10081b < f1Var.o());
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z2, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
        try {
            b0VarC.f4962h.i.getClass();
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
        }
        b0VarC.t();
    }

    @Override // p1.u0
    public final void u() {
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        ub.o oVar = b0VarC.f4961g.f5006e;
        aa.j0 j0VarW = oVar.w();
        for (int i = 0; i < j0VarW.size(); i++) {
            s sVar = (s) j0VarW.get(i);
            oVar.A(sVar);
            b0VarC.c(sVar, new b2.f(20));
        }
    }

    @Override // p1.u0
    public final void w(p1.d dVar) {
        p1.l1 l1Var;
        boolean z2;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        r1.c cVar = h1Var.f5073p;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        try {
            if (!f1Var.p()) {
                l1Var = l1Var2;
                if (p1Var.f5170a.f10081b >= f1Var.o()) {
                    z2 = false;
                }
                s1.d.g(z2);
                b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
                b0VarC.f4958c.a(true, true);
                b0VarC.f4962h.i.m(dVar);
                return;
            }
            l1Var = l1Var2;
            b0VarC.f4962h.i.m(dVar);
            return;
        } catch (RemoteException e10) {
            s1.b.h("MediaSessionImpl", "Exception in using media1 API", e10);
            return;
        }
        z2 = true;
        s1.d.g(z2);
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final void x(r1.c cVar) {
        p1.l1 l1Var;
        boolean z2;
        b0 b0VarC = c();
        if (b0VarC == null) {
            return;
        }
        b0VarC.u();
        if (((j1) this.f5258v.get()) == null) {
            return;
        }
        h1 h1Var = b0VarC.f4972s;
        p1.p0 p0Var = h1Var.f5060a;
        int i = h1Var.f5061b;
        p1 p1Var = h1Var.f5062c;
        p1.v0 v0Var = h1Var.f5063d;
        p1.v0 v0Var2 = h1Var.f5064e;
        int i10 = h1Var.f;
        p1.q0 q0Var = h1Var.f5065g;
        int i11 = h1Var.f5066h;
        boolean z10 = h1Var.i;
        p1.f1 f1Var = h1Var.f5067j;
        int i12 = h1Var.f5068k;
        p1.r1 r1Var = h1Var.f5069l;
        p1.j0 j0Var = h1Var.f5070m;
        float f = h1Var.f5071n;
        p1.d dVar = h1Var.f5072o;
        p1.j jVar = h1Var.f5074q;
        int i13 = h1Var.f5075r;
        boolean z11 = h1Var.f5076s;
        boolean z12 = h1Var.f5077t;
        int i14 = h1Var.f5078u;
        boolean z13 = h1Var.f5079v;
        boolean z14 = h1Var.f5080w;
        int i15 = h1Var.f5081x;
        int i16 = h1Var.f5082y;
        p1.j0 j0Var2 = h1Var.f5083z;
        long j5 = h1Var.A;
        long j8 = h1Var.B;
        long j10 = h1Var.C;
        p1.n1 n1Var = h1Var.D;
        p1.l1 l1Var2 = h1Var.E;
        if (!f1Var.p()) {
            l1Var = l1Var2;
            if (p1Var.f5170a.f10081b >= f1Var.o()) {
                z2 = false;
            }
            s1.d.g(z2);
            b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
            b0VarC.f4958c.a(true, true);
        }
        l1Var = l1Var2;
        z2 = true;
        s1.d.g(z2);
        b0VarC.f4972s = new h1(p0Var, i, p1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var, i12, j0Var, f, dVar, cVar, jVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j5, j8, j10, n1Var, l1Var);
        b0VarC.f4958c.a(true, true);
    }

    @Override // p1.u0
    public final /* synthetic */ void L(p1.p0 p0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void M(p1.t0 t0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void a(boolean z2) {
    }

    @Override // p1.u0
    public final /* synthetic */ void e(int i) {
    }

    @Override // p1.u0
    public final /* synthetic */ void i(boolean z2) {
    }

    @Override // p1.u0
    public final /* synthetic */ void j(int i) {
    }

    @Override // p1.u0
    public final /* synthetic */ void v(p1.l0 l0Var) {
    }

    @Override // p1.u0
    public final /* synthetic */ void y(List list) {
    }

    @Override // p1.u0
    public final /* synthetic */ void H(int i, int i10) {
    }

    @Override // p1.u0
    public final /* synthetic */ void z(int i, boolean z2) {
    }
}
