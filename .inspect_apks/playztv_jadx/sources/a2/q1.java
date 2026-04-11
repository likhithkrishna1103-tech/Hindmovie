package a2;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q1 implements o2.k0, f2.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s1 f388u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ t1 f389v;

    public q1(t1 t1Var, s1 s1Var) {
        this.f389v = t1Var;
        this.f388u = s1Var;
    }

    @Override // o2.k0
    public final void A(int i, o2.d0 d0Var, final o2.u uVar, final o2.z zVar, final IOException iOException, final boolean z2) {
        final Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new Runnable() { // from class: a2.p1
                @Override // java.lang.Runnable
                public final void run() {
                    b2.h hVar = (b2.h) this.f380u.f389v.i;
                    Pair pair = pairA;
                    hVar.A(((Integer) pair.first).intValue(), (o2.d0) pair.second, uVar, zVar, iOException, z2);
                }
            });
        }
    }

    @Override // f2.l
    public final void D(int i, o2.d0 d0Var) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new l1(this, pairA, 0));
        }
    }

    @Override // o2.k0
    public final void I(int i, o2.d0 d0Var, o2.u uVar, o2.z zVar) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new m1(this, pairA, uVar, zVar, 1));
        }
    }

    @Override // o2.k0
    public final void J(int i, o2.d0 d0Var, o2.u uVar, o2.z zVar, int i10) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new o1(this, pairA, uVar, zVar, i10));
        }
    }

    @Override // f2.l
    public final void Q(int i, o2.d0 d0Var) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new l1(this, pairA, 2));
        }
    }

    public final Pair a(int i, o2.d0 d0Var) {
        o2.d0 d0VarA;
        s1 s1Var = this.f388u;
        o2.d0 d0Var2 = null;
        if (d0Var != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= s1Var.f403c.size()) {
                    d0VarA = null;
                    break;
                }
                if (((o2.d0) s1Var.f403c.get(i10)).f9093d == d0Var.f9093d) {
                    Object obj = d0Var.f9090a;
                    Object obj2 = s1Var.f402b;
                    int i11 = z1.f523n;
                    d0VarA = d0Var.a(Pair.create(obj2, obj));
                    break;
                }
                i10++;
            }
            if (d0VarA == null) {
                return null;
            }
            d0Var2 = d0VarA;
        }
        return Pair.create(Integer.valueOf(i + s1Var.f404d), d0Var2);
    }

    @Override // o2.k0
    public final void c(int i, o2.d0 d0Var, o2.u uVar, o2.z zVar) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new m1(this, pairA, uVar, zVar, 0));
        }
    }

    @Override // o2.k0
    public final void g(int i, o2.d0 d0Var, o2.z zVar) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new k1(this, pairA, zVar, 0));
        }
    }

    @Override // o2.k0
    public final void l(int i, o2.d0 d0Var, o2.z zVar) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new k1(this, pairA, zVar, 1));
        }
    }

    @Override // f2.l
    public final void m(int i, o2.d0 d0Var, Exception exc) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new g1(this, pairA, exc, 1));
        }
    }

    @Override // f2.l
    public final void r(int i, o2.d0 d0Var) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new l1(this, pairA, 1));
        }
    }

    @Override // f2.l
    public final void s(int i, o2.d0 d0Var, int i10) {
        Pair pairA = a(i, d0Var);
        if (pairA != null) {
            ((s1.y) this.f389v.f418j).c(new n1(this, pairA, i10, 0));
        }
    }
}
