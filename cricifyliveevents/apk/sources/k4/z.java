package k4;

import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.List;
import v1.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements v1.u0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final WeakReference f7198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WeakReference f7199w;

    public z(b0 b0Var, h1 h1Var) {
        this.f7198v = new WeakReference(b0Var);
        this.f7199w = new WeakReference(h1Var);
    }

    @Override // v1.u0
    public final void A(x1.c cVar) {
        v1.l1 l1Var;
        boolean z10;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar2 = f1Var.f6983o;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        if (!f1Var2.p()) {
            l1Var = l1Var2;
            if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                z10 = false;
            }
            y1.d.g(z10);
            b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar2, cVar, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
            b0VarF.f6909c.a(true, true);
        }
        l1Var = l1Var2;
        z10 = true;
        y1.d.g(z10);
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar2, cVar, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void B(int i, v1.v0 v0Var, v1.v0 v0Var2) {
        v1.l1 l1Var;
        boolean z10;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i10 = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        try {
            if (!f1Var2.p()) {
                l1Var = l1Var2;
                if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                    z10 = false;
                }
                y1.d.g(z10);
                b0VarF.f6923s = new f1(p0Var, i10, n1Var, v0Var, v0Var2, i, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
                b0VarF.f6909c.a(true, true);
                l0 l0Var = (l0) b0VarF.f6913h.i.f1829z;
                l0Var.N(l0Var.f7060g.f6924t);
                return;
            }
            l1Var = l1Var2;
            l0 l0Var2 = (l0) b0VarF.f6913h.i.f1829z;
            l0Var2.N(l0Var2.f7060g.f6924t);
            return;
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
            return;
        }
        z10 = true;
        y1.d.g(z10);
        b0VarF.f6923s = new f1(p0Var, i10, n1Var, v0Var, v0Var2, i, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void C(int i) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        h1 h1Var = (h1) this.f7199w.get();
        if (h1Var == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0VarH = h1Var.h();
        int i10 = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i11 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i12 = f1Var.f6977h;
        boolean z10 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i13 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i14 = f1Var.f6986r;
        boolean z11 = f1Var.f6987s;
        boolean z12 = f1Var.f6988t;
        int i15 = f1Var.f6989u;
        boolean z13 = f1Var.f6991w;
        int i16 = f1Var.f6992x;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var = f1Var.E;
        boolean z14 = i == 3 && z12 && i16 == 0;
        y1.d.g(f1Var2.p() || n1Var.f7106a.f13014b < f1Var2.o());
        b0VarF.f6923s = new f1(p0VarH, i10, n1Var, v0Var, v0Var2, i11, q0Var, i12, z10, r1Var, f1Var2, i13, j0Var, f, cVar, cVar2, iVar, i14, z11, z12, i15, i16, i, z14, z13, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
        try {
            b7.d dVar = b0VarF.f6913h.i;
            h1Var.h();
            l0 l0Var = (l0) dVar.f1829z;
            l0Var.N(l0Var.f7060g.f6924t);
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    @Override // v1.u0
    public final void D(v1.q0 q0Var) {
        v1.l1 l1Var;
        boolean z10;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        try {
            if (!f1Var2.p()) {
                l1Var = l1Var2;
                if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                    z10 = false;
                }
                y1.d.g(z10);
                b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
                b0VarF.f6909c.a(true, true);
                l0 l0Var = (l0) b0VarF.f6913h.i.f1829z;
                l0Var.N(l0Var.f7060g.f6924t);
                return;
            }
            l1Var = l1Var2;
            l0 l0Var2 = (l0) b0VarF.f6913h.i.f1829z;
            l0Var2.N(l0Var2.f7060g.f6924t);
            return;
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
            return;
        }
        z10 = true;
        y1.d.g(z10);
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void E(boolean z10) {
        v1.l1 l1Var;
        boolean z11;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        try {
            if (!f1Var2.p()) {
                l1Var = l1Var2;
                if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                    z11 = false;
                }
                y1.d.g(z11);
                b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
                b0VarF.f6909c.a(true, true);
                b0VarF.f6913h.i.t(z10);
                return;
            }
            l1Var = l1Var2;
            b0VarF.f6913h.i.t(z10);
            return;
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
            return;
        }
        z11 = true;
        y1.d.g(z11);
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void M(v1.n1 n1Var) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        b0VarF.f6923s = b0VarF.f6923s.a(n1Var);
        b0VarF.f6909c.a(true, false);
        b0VarF.d(new h2.e(18, n1Var));
    }

    @Override // v1.u0
    public final void P(v1.s0 s0Var) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        b0VarF.f(s0Var);
    }

    @Override // v1.u0
    public final void Q(boolean z10) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var = f1Var.E;
        y1.d.g(f1Var2.p() || n1Var.f7106a.f13014b < f1Var2.o());
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z10, z14, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
        try {
            l0 l0Var = (l0) b0VarF.f6913h.i.f1829z;
            l0Var.N(l0Var.f7060g.f6924t);
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
        b0VarF.t();
    }

    @Override // v1.u0
    public final void a(r1 r1Var) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z10 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z11 = f1Var.f6987s;
        boolean z12 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z13 = f1Var.f6990v;
        boolean z14 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var = f1Var.E;
        y1.d.g(f1Var2.p() || n1Var.f7106a.f13014b < f1Var2.o());
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
        try {
            b0VarF.f6913h.i.getClass();
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    @Override // v1.u0
    public final void c(int i) {
        v1.l1 l1Var;
        boolean z10;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i10 = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i11 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        try {
            if (!f1Var2.p()) {
                l1Var = l1Var2;
                if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                    z10 = false;
                }
                y1.d.g(z10);
                b0VarF.f6923s = new f1(p0Var, i10, n1Var, v0Var, v0Var2, i11, q0Var, i, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
                b0VarF.f6909c.a(true, true);
                b0VarF.f6913h.i.s(i);
                return;
            }
            l1Var = l1Var2;
            b0VarF.f6913h.i.s(i);
            return;
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
            return;
        }
        z10 = true;
        y1.d.g(z10);
        b0VarF.f6923s = new f1(p0Var, i10, n1Var, v0Var, v0Var2, i11, q0Var, i, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void e(v1.f1 f1Var, int i) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        h1 h1Var = (h1) this.f7199w.get();
        if (h1Var == null) {
            return;
        }
        b0VarF.f6923s = b0VarF.f6923s.c(f1Var, h1Var.C(), i);
        b0VarF.f6909c.a(false, true);
        try {
            b0VarF.f6913h.i.u(f1Var);
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    public final b0 f() {
        return (b0) this.f7198v.get();
    }

    @Override // v1.u0
    public final void g(int i) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        b0VarF.f6923s = f1Var.b(f1Var.f6989u, i, f1Var.f6988t);
        b0VarF.f6909c.a(true, true);
        try {
            l0 l0Var = (l0) b0VarF.f6913h.i.f1829z;
            l0Var.N(l0Var.f7060g.f6924t);
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    @Override // v1.u0
    public final void i(v1.l1 l1Var) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        b0VarF.f6923s = b0VarF.f6923s.d(l1Var);
        b0VarF.f6909c.a(true, true);
        b0VarF.d(new h2.e(17, l1Var));
    }

    @Override // v1.u0
    public final void j(v1.j0 j0Var) {
        v1.l1 l1Var;
        boolean z10;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var2 = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        try {
            if (!f1Var2.p()) {
                l1Var = l1Var2;
                if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                    z10 = false;
                }
                y1.d.g(z10);
                b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var2, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var, j4, j7, j10, n1Var2, l1Var);
                b0VarF.f6909c.a(true, true);
                b0VarF.f6913h.i.v();
                return;
            }
            l1Var = l1Var2;
            b0VarF.f6913h.i.v();
            return;
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
            return;
        }
        z10 = true;
        y1.d.g(z10);
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var2, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void k(int i, v1.g0 g0Var) {
        v1.l1 l1Var;
        boolean z10;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        try {
            if (!f1Var2.p()) {
                l1Var = l1Var2;
                if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                    z10 = false;
                }
                y1.d.g(z10);
                b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
                b0VarF.f6909c.a(true, true);
                b0VarF.f6913h.i.p(g0Var);
                return;
            }
            l1Var = l1Var2;
            b0VarF.f6913h.i.p(g0Var);
            return;
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
            return;
        }
        z10 = true;
        y1.d.g(z10);
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void n(v1.j0 j0Var) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z10 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z11 = f1Var.f6987s;
        boolean z12 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z13 = f1Var.f6990v;
        boolean z14 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var = f1Var.E;
        y1.d.g(f1Var2.p() || n1Var.f7106a.f13014b < f1Var2.o());
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
        try {
            b0VarF.f6913h.i.r(j0Var);
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    @Override // v1.u0
    public final void p(v1.c cVar) {
        v1.l1 l1Var;
        boolean z10;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        try {
            if (!f1Var2.p()) {
                l1Var = l1Var2;
                if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                    z10 = false;
                }
                y1.d.g(z10);
                b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
                b0VarF.f6909c.a(true, true);
                b0VarF.f6913h.i.n(cVar);
                return;
            }
            l1Var = l1Var2;
            b0VarF.f6913h.i.n(cVar);
            return;
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
            return;
        }
        z10 = true;
        y1.d.g(z10);
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void q(boolean z10) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var = f1Var.E;
        y1.d.g(f1Var2.p() || n1Var.f7106a.f13014b < f1Var2.o());
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z10, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
        try {
            b0VarF.f6913h.i.getClass();
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
        b0VarF.t();
    }

    @Override // v1.u0
    public final void s() {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        b6.f fVar = b0VarF.f6912g.f6944e;
        ua.i0 i0VarG = fVar.g();
        for (int i = 0; i < i0VarG.size(); i++) {
            s sVar = (s) i0VarG.get(i);
            fVar.i(sVar);
            b0VarF.c(sVar, new h2.e(19));
        }
    }

    @Override // v1.u0
    public final void u(v1.p0 p0Var) {
        v1.l1 l1Var;
        boolean z10;
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z11 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        float f = f1Var.f6982n;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z12 = f1Var.f6987s;
        boolean z13 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z14 = f1Var.f6990v;
        boolean z15 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var2 = f1Var.E;
        try {
            if (!f1Var2.p()) {
                l1Var = l1Var2;
                if (n1Var.f7106a.f13014b >= f1Var2.o()) {
                    z10 = false;
                }
                y1.d.g(z10);
                b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
                b0VarF.f6909c.a(true, true);
                l0 l0Var = (l0) b0VarF.f6913h.i.f1829z;
                l0Var.N(l0Var.f7060g.f6924t);
                return;
            }
            l1Var = l1Var2;
            l0 l0Var2 = (l0) b0VarF.f6913h.i.f1829z;
            l0Var2.N(l0Var2.f7060g.f6924t);
            return;
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
            return;
        }
        z10 = true;
        y1.d.g(z10);
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z11, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z12, z13, i14, i15, i16, z14, z15, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
    }

    @Override // v1.u0
    public final void y(int i, boolean z10) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        if (((h1) this.f7199w.get()) == null) {
            return;
        }
        f1 f1Var = b0VarF.f6923s;
        b0VarF.f6923s = f1Var.b(i, f1Var.f6992x, z10);
        b0VarF.f6909c.a(true, true);
        try {
            l0 l0Var = (l0) b0VarF.f6913h.i.f1829z;
            l0Var.N(l0Var.f7060g.f6924t);
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    @Override // v1.u0
    public final void z(float f) {
        b0 b0VarF = f();
        if (b0VarF == null) {
            return;
        }
        b0VarF.u();
        f1 f1Var = b0VarF.f6923s;
        v1.p0 p0Var = f1Var.f6971a;
        int i = f1Var.f6972b;
        n1 n1Var = f1Var.f6973c;
        v1.v0 v0Var = f1Var.f6974d;
        v1.v0 v0Var2 = f1Var.f6975e;
        int i10 = f1Var.f;
        v1.q0 q0Var = f1Var.f6976g;
        int i11 = f1Var.f6977h;
        boolean z10 = f1Var.i;
        v1.f1 f1Var2 = f1Var.f6978j;
        int i12 = f1Var.f6979k;
        r1 r1Var = f1Var.f6980l;
        v1.j0 j0Var = f1Var.f6981m;
        v1.c cVar = f1Var.f6983o;
        x1.c cVar2 = f1Var.f6984p;
        v1.i iVar = f1Var.f6985q;
        int i13 = f1Var.f6986r;
        boolean z11 = f1Var.f6987s;
        boolean z12 = f1Var.f6988t;
        int i14 = f1Var.f6989u;
        boolean z13 = f1Var.f6990v;
        boolean z14 = f1Var.f6991w;
        int i15 = f1Var.f6992x;
        int i16 = f1Var.f6993y;
        v1.j0 j0Var2 = f1Var.f6994z;
        long j4 = f1Var.A;
        long j7 = f1Var.B;
        long j10 = f1Var.C;
        v1.n1 n1Var2 = f1Var.D;
        v1.l1 l1Var = f1Var.E;
        y1.d.g(f1Var2.p() || n1Var.f7106a.f13014b < f1Var2.o());
        b0VarF.f6923s = new f1(p0Var, i, n1Var, v0Var, v0Var2, i10, q0Var, i11, z10, r1Var, f1Var2, i12, j0Var, f, cVar, cVar2, iVar, i13, z11, z12, i14, i15, i16, z13, z14, j0Var2, j4, j7, j10, n1Var2, l1Var);
        b0VarF.f6909c.a(true, true);
        try {
            b0VarF.f6913h.i.getClass();
        } catch (RemoteException e9) {
            y1.b.h("MediaSessionImpl", "Exception in using media1 API", e9);
        }
    }

    @Override // v1.u0
    public final /* synthetic */ void b(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void d(int i) {
    }

    @Override // v1.u0
    public final /* synthetic */ void h(v1.t0 t0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void l(boolean z10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void m(int i) {
    }

    @Override // v1.u0
    public final /* synthetic */ void r(v1.l0 l0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void v(v1.p0 p0Var) {
    }

    @Override // v1.u0
    public final /* synthetic */ void w(List list) {
    }

    @Override // v1.u0
    public final /* synthetic */ void H(int i, int i10) {
    }

    @Override // v1.u0
    public final /* synthetic */ void x(int i, boolean z10) {
    }
}
