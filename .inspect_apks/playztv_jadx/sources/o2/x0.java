package o2;

import android.net.Uri;
import android.os.Looper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends a {
    public final v1.g B;
    public final nc.c C;
    public final f2.n D;
    public final k8.a0 E;
    public final int F;
    public final p1.q G;
    public boolean H = true;
    public long I = -9223372036854775807L;
    public boolean J;
    public boolean K;
    public v1.e0 L;
    public p1.g0 M;

    public x0(p1.g0 g0Var, v1.g gVar, nc.c cVar, f2.n nVar, k8.a0 a0Var, int i, p1.q qVar) {
        this.M = g0Var;
        this.B = gVar;
        this.C = cVar;
        this.D = nVar;
        this.E = a0Var;
        this.F = i;
        this.G = qVar;
    }

    @Override // o2.a
    public final boolean a(p1.g0 g0Var) {
        p1.c0 c0Var = j().f9757b;
        c0Var.getClass();
        p1.c0 c0Var2 = g0Var.f9757b;
        return c0Var2 != null && c0Var2.f9665a.equals(c0Var.f9665a) && c0Var2.f9671h == c0Var.f9671h && Objects.equals(c0Var2.f, c0Var.f);
    }

    @Override // o2.a
    public final b0 c(d0 d0Var, s2.e eVar, long j5) {
        v1.h hVarG = this.B.g();
        v1.e0 e0Var = this.L;
        if (e0Var != null) {
            hVarG.g(e0Var);
        }
        p1.c0 c0Var = j().f9757b;
        c0Var.getClass();
        Uri uri = c0Var.f9665a;
        s1.d.h(this.A);
        return new u0(uri, hVarG, new kc.b((w2.r) this.C.f8921v), this.D, new f2.k(this.f9054x.f4741c, 0, d0Var), this.E, b(d0Var), this, eVar, c0Var.f, this.F, this.G, s1.b0.O(c0Var.f9671h), null);
    }

    @Override // o2.a
    public final synchronized p1.g0 j() {
        return this.M;
    }

    @Override // o2.a
    public final void p(v1.e0 e0Var) {
        this.L = e0Var;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        b2.o oVar = this.A;
        s1.d.h(oVar);
        f2.n nVar = this.D;
        nVar.g(looperMyLooper, oVar);
        nVar.d();
        y();
    }

    @Override // o2.a
    public final void r(b0 b0Var) {
        u0 u0Var = (u0) b0Var;
        if (u0Var.R) {
            for (b1 b1Var : u0Var.O) {
                b1Var.k();
                f2.h hVar = b1Var.f9063h;
                if (hVar != null) {
                    hVar.c(b1Var.f9061e);
                    b1Var.f9063h = null;
                    b1Var.f9062g = null;
                }
            }
        }
        u0Var.G.e(u0Var);
        u0Var.L.removeCallbacksAndMessages(null);
        u0Var.M = null;
        u0Var.f9228j0 = true;
    }

    @Override // o2.a
    public final void t() {
        this.D.release();
    }

    @Override // o2.a
    public final synchronized void x(p1.g0 g0Var) {
        this.M = g0Var;
    }

    public final void y() {
        p1.f1 g1Var = new g1(this.I, this.J, this.K, j());
        if (this.H) {
            g1Var = new v0(g1Var);
        }
        q(g1Var);
    }

    public final void z(long j5, w2.b0 b0Var, boolean z2) {
        if (j5 == -9223372036854775807L) {
            j5 = this.I;
        }
        boolean zH = b0Var.h();
        if (!this.H && this.I == j5 && this.J == zH && this.K == z2) {
            return;
        }
        this.I = j5;
        this.J = zH;
        this.K = z2;
        this.H = false;
        y();
    }

    @Override // o2.a
    public final void n() {
    }
}
