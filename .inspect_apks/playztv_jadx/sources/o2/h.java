package o2;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends o1 {
    public final long F;
    public final long G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final ArrayList L;
    public final p1.e1 M;
    public f N;
    public g O;
    public long P;
    public long Q;

    public h(e eVar) {
        super(eVar.f9095a);
        this.F = eVar.f9096b;
        this.G = eVar.f9097c;
        this.H = eVar.f9098d;
        this.I = eVar.f9099e;
        this.J = eVar.f;
        this.K = eVar.f9100g;
        this.L = new ArrayList();
        this.M = new p1.e1();
    }

    @Override // o2.o1
    public final void E(p1.f1 f1Var) {
        if (this.O != null) {
            return;
        }
        H(f1Var);
    }

    public final void H(p1.f1 f1Var) {
        long j5;
        long j8;
        long j10;
        p1.e1 e1Var = this.M;
        f1Var.n(0, e1Var);
        long j11 = e1Var.f9726p;
        f fVar = this.N;
        long j12 = this.G;
        ArrayList arrayList = this.L;
        if (fVar == null || arrayList.isEmpty() || this.I) {
            boolean z2 = this.J;
            j5 = this.F;
            if (z2) {
                long j13 = e1Var.f9722l;
                j5 += j13;
                j8 = j13 + j12;
            } else {
                j8 = j12;
            }
            this.P = j11 + j5;
            this.Q = j12 != Long.MIN_VALUE ? j11 + j8 : Long.MIN_VALUE;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                long j14 = this.P;
                long j15 = this.Q;
                dVar.f9088y = j14;
                dVar.f9089z = j15;
            }
            j10 = j8;
        } else {
            j5 = this.P - j11;
            j10 = j12 != Long.MIN_VALUE ? this.Q - j11 : Long.MIN_VALUE;
        }
        try {
            f fVar2 = new f(f1Var, j5, j10, this.K);
            this.N = fVar2;
            q(fVar2);
        } catch (g e10) {
            this.O = e10;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                ((d) arrayList.get(i10)).A = this.O;
            }
        }
    }

    @Override // o2.a
    public final boolean a(p1.g0 g0Var) {
        a aVar = this.E;
        return aVar.j().f9760e.equals(g0Var.f9760e) && aVar.a(g0Var);
    }

    @Override // o2.a
    public final b0 c(d0 d0Var, s2.e eVar, long j5) {
        d dVar = new d(this.E.c(d0Var, eVar, j5), this.H, this.P, this.Q);
        this.L.add(dVar);
        return dVar;
    }

    @Override // o2.l, o2.a
    public final void n() throws g {
        g gVar = this.O;
        if (gVar != null) {
            throw gVar;
        }
        super.n();
    }

    @Override // o2.a
    public final void r(b0 b0Var) {
        ArrayList arrayList = this.L;
        s1.d.g(arrayList.remove(b0Var));
        this.E.r(((d) b0Var).f9084u);
        if (!arrayList.isEmpty() || this.I) {
            return;
        }
        f fVar = this.N;
        fVar.getClass();
        H(fVar.f9206e);
    }

    @Override // o2.l, o2.a
    public final void t() {
        super.t();
        this.O = null;
        this.N = null;
    }
}
