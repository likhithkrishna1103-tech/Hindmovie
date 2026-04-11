package g2;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 implements s2.i0, l2.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g1 f4666v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h1 f4667w;

    public e1(h1 h1Var, g1 g1Var) {
        this.f4667w = h1Var;
        this.f4666v = g1Var;
    }

    @Override // l2.l
    public final void F(int i, s2.c0 c0Var) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new a1(this, pairA, 1));
        }
    }

    @Override // s2.i0
    public final void G(int i, s2.c0 c0Var, s2.t tVar, s2.y yVar) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new b1(this, pairA, tVar, yVar, 1));
        }
    }

    @Override // l2.l
    public final void I(int i, s2.c0 c0Var) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new a1(this, pairA, 2));
        }
    }

    @Override // s2.i0
    public final void J(int i, s2.c0 c0Var, s2.y yVar) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new z0(this, pairA, yVar, 1));
        }
    }

    @Override // s2.i0
    public final void K(int i, s2.c0 c0Var, s2.y yVar) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new z0(this, pairA, yVar, 0));
        }
    }

    @Override // s2.i0
    public final void L(int i, s2.c0 c0Var, s2.t tVar, s2.y yVar) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new b1(this, pairA, tVar, yVar, 0));
        }
    }

    @Override // l2.l
    public final void N(int i, s2.c0 c0Var, Exception exc) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new androidx.emoji2.text.n(this, pairA, exc, 3));
        }
    }

    @Override // l2.l
    public final void O(int i, s2.c0 c0Var, int i10) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new c.k(this, pairA, i10, 2));
        }
    }

    public final Pair a(int i, s2.c0 c0Var) {
        s2.c0 c0VarA;
        g1 g1Var = this.f4666v;
        s2.c0 c0Var2 = null;
        if (c0Var != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= g1Var.f4719c.size()) {
                    c0VarA = null;
                    break;
                }
                if (((s2.c0) g1Var.f4719c.get(i10)).f11159d == c0Var.f11159d) {
                    Object obj = c0Var.f11156a;
                    Object obj2 = g1Var.f4718b;
                    int i11 = n1.f4811n;
                    c0VarA = c0Var.a(Pair.create(obj2, obj));
                    break;
                }
                i10++;
            }
            if (c0VarA == null) {
                return null;
            }
            c0Var2 = c0VarA;
        }
        return Pair.create(Integer.valueOf(i + g1Var.f4720d), c0Var2);
    }

    @Override // s2.i0
    public final void f(int i, s2.c0 c0Var, final s2.t tVar, final s2.y yVar, final IOException iOException, final boolean z10) {
        final Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new Runnable() { // from class: g2.d1
                @Override // java.lang.Runnable
                public final void run() {
                    h2.f fVar = (h2.f) this.f4652v.f4667w.i;
                    Pair pair = pairA;
                    fVar.f(((Integer) pair.first).intValue(), (s2.c0) pair.second, tVar, yVar, iOException, z10);
                }
            });
        }
    }

    @Override // s2.i0
    public final void o(int i, s2.c0 c0Var, s2.t tVar, s2.y yVar, int i10) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new c1(this, pairA, tVar, yVar, i10));
        }
    }

    @Override // l2.l
    public final void t(int i, s2.c0 c0Var) {
        Pair pairA = a(i, c0Var);
        if (pairA != null) {
            ((y1.x) this.f4667w.f4743j).c(new a1(this, pairA, 0));
        }
    }
}
