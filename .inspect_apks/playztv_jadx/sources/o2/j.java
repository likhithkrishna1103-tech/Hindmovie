package o2;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements k0, f2.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f9142u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public aa.l0 f9143v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public f2.k f9144w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ l f9145x;

    public j(l lVar, Object obj) {
        this.f9145x = lVar;
        this.f9143v = lVar.b(null);
        this.f9144w = new f2.k(lVar.f9054x.f4741c, 0, null);
        this.f9142u = obj;
    }

    @Override // o2.k0
    public final void A(int i, d0 d0Var, u uVar, z zVar, IOException iOException, boolean z2) {
        if (a(i, d0Var)) {
            aa.l0 l0Var = this.f9143v;
            z zVarB = b(zVar, d0Var);
            l0Var.getClass();
            l0Var.f(new h0(l0Var, uVar, zVarB, iOException, z2));
        }
    }

    @Override // f2.l
    public final void D(int i, d0 d0Var) {
        if (a(i, d0Var)) {
            this.f9144w.a();
        }
    }

    @Override // o2.k0
    public final void I(int i, d0 d0Var, u uVar, z zVar) {
        if (a(i, d0Var)) {
            aa.l0 l0Var = this.f9143v;
            z zVarB = b(zVar, d0Var);
            l0Var.getClass();
            l0Var.f(new g0(l0Var, uVar, zVarB, 0));
        }
    }

    @Override // o2.k0
    public final void J(int i, d0 d0Var, u uVar, z zVar, int i10) {
        if (a(i, d0Var)) {
            aa.l0 l0Var = this.f9143v;
            z zVarB = b(zVar, d0Var);
            l0Var.getClass();
            l0Var.f(new f0(l0Var, uVar, zVarB, i10));
        }
    }

    @Override // f2.l
    public final void Q(int i, d0 d0Var) {
        if (a(i, d0Var)) {
            this.f9144w.b();
        }
    }

    public final boolean a(int i, d0 d0Var) {
        d0 d0VarY;
        Object obj = this.f9142u;
        l lVar = this.f9145x;
        if (d0Var != null) {
            d0VarY = lVar.y(obj, d0Var);
            if (d0VarY == null) {
                return false;
            }
        } else {
            d0VarY = null;
        }
        int iA = lVar.A(i, obj);
        aa.l0 l0Var = this.f9143v;
        if (l0Var.f705v != iA || !Objects.equals((d0) l0Var.f706w, d0VarY)) {
            this.f9143v = new aa.l0((CopyOnWriteArrayList) lVar.f9053w.f707x, iA, d0VarY);
        }
        f2.k kVar = this.f9144w;
        if (kVar.f4739a == iA && Objects.equals(kVar.f4740b, d0VarY)) {
            return true;
        }
        this.f9144w = new f2.k(lVar.f9054x.f4741c, iA, d0VarY);
        return true;
    }

    public final z b(z zVar, d0 d0Var) {
        long j5 = zVar.f;
        l lVar = this.f9145x;
        Object obj = this.f9142u;
        long jZ = lVar.z(j5, obj);
        long j8 = zVar.f9260g;
        long jZ2 = lVar.z(j8, obj);
        return (jZ == j5 && jZ2 == j8) ? zVar : new z(zVar.f9255a, zVar.f9256b, zVar.f9257c, zVar.f9258d, zVar.f9259e, jZ, jZ2);
    }

    @Override // o2.k0
    public final void c(int i, d0 d0Var, u uVar, z zVar) {
        if (a(i, d0Var)) {
            aa.l0 l0Var = this.f9143v;
            z zVarB = b(zVar, d0Var);
            l0Var.getClass();
            l0Var.f(new g0(l0Var, uVar, zVarB, 1));
        }
    }

    @Override // o2.k0
    public final void g(int i, d0 d0Var, z zVar) {
        if (a(i, d0Var)) {
            aa.l0 l0Var = this.f9143v;
            z zVarB = b(zVar, d0Var);
            d0 d0Var2 = (d0) l0Var.f706w;
            d0Var2.getClass();
            l0Var.f(new dd.e(l0Var, d0Var2, zVarB, 8));
        }
    }

    @Override // o2.k0
    public final void l(int i, d0 d0Var, z zVar) {
        if (a(i, d0Var)) {
            aa.l0 l0Var = this.f9143v;
            z zVarB = b(zVar, d0Var);
            l0Var.getClass();
            l0Var.f(new b2.b(l0Var, 17, zVarB));
        }
    }

    @Override // f2.l
    public final void m(int i, d0 d0Var, Exception exc) {
        if (a(i, d0Var)) {
            this.f9144w.d(exc);
        }
    }

    @Override // f2.l
    public final void r(int i, d0 d0Var) {
        if (a(i, d0Var)) {
            this.f9144w.e();
        }
    }

    @Override // f2.l
    public final void s(int i, d0 d0Var, int i10) {
        if (a(i, d0Var)) {
            this.f9144w.c(i10);
        }
    }
}
