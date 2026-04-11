package s2;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements i0, l2.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f11237v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public f3.a f11238w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public l2.k f11239x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ l f11240y;

    public j(l lVar, Object obj) {
        this.f11240y = lVar;
        this.f11238w = lVar.b(null);
        this.f11239x = new l2.k(lVar.f11150d.f7673c, 0, null);
        this.f11237v = obj;
    }

    @Override // l2.l
    public final void F(int i, c0 c0Var) {
        if (a(i, c0Var)) {
            this.f11239x.e();
        }
    }

    @Override // s2.i0
    public final void G(int i, c0 c0Var, t tVar, y yVar) {
        if (a(i, c0Var)) {
            f3.a aVar = this.f11238w;
            y yVarB = b(yVar, c0Var);
            aVar.getClass();
            aVar.e(new f0(aVar, tVar, yVarB, 0));
        }
    }

    @Override // l2.l
    public final void I(int i, c0 c0Var) {
        if (a(i, c0Var)) {
            this.f11239x.b();
        }
    }

    @Override // s2.i0
    public final void J(int i, c0 c0Var, y yVar) {
        if (a(i, c0Var)) {
            f3.a aVar = this.f11238w;
            y yVarB = b(yVar, c0Var);
            aVar.getClass();
            aVar.e(new androidx.fragment.app.e(24, aVar, yVarB));
        }
    }

    @Override // s2.i0
    public final void K(int i, c0 c0Var, y yVar) {
        if (a(i, c0Var)) {
            f3.a aVar = this.f11238w;
            y yVarB = b(yVar, c0Var);
            c0 c0Var2 = (c0) aVar.f3936x;
            c0Var2.getClass();
            aVar.e(new c8.b(aVar, c0Var2, yVarB, 12));
        }
    }

    @Override // s2.i0
    public final void L(int i, c0 c0Var, t tVar, y yVar) {
        if (a(i, c0Var)) {
            f3.a aVar = this.f11238w;
            y yVarB = b(yVar, c0Var);
            aVar.getClass();
            aVar.e(new f0(aVar, tVar, yVarB, 1));
        }
    }

    @Override // l2.l
    public final void N(int i, c0 c0Var, Exception exc) {
        if (a(i, c0Var)) {
            this.f11239x.d(exc);
        }
    }

    @Override // l2.l
    public final void O(int i, c0 c0Var, int i10) {
        if (a(i, c0Var)) {
            this.f11239x.c(i10);
        }
    }

    public final boolean a(int i, c0 c0Var) {
        c0 c0VarU;
        Object obj = this.f11237v;
        l lVar = this.f11240y;
        if (c0Var != null) {
            c0VarU = lVar.u(obj, c0Var);
            if (c0VarU == null) {
                return false;
            }
        } else {
            c0VarU = null;
        }
        int iW = lVar.w(i, obj);
        f3.a aVar = this.f11238w;
        if (aVar.f3935w != iW || !Objects.equals((c0) aVar.f3936x, c0VarU)) {
            this.f11238w = new f3.a((CopyOnWriteArrayList) lVar.f11149c.f3937y, iW, c0VarU);
        }
        l2.k kVar = this.f11239x;
        if (kVar.f7671a == iW && Objects.equals(kVar.f7672b, c0VarU)) {
            return true;
        }
        this.f11239x = new l2.k(lVar.f11150d.f7673c, iW, c0VarU);
        return true;
    }

    public final y b(y yVar, c0 c0Var) {
        long j4 = yVar.f;
        l lVar = this.f11240y;
        Object obj = this.f11237v;
        long jV = lVar.v(j4, obj);
        long j7 = yVar.f11372g;
        long jV2 = lVar.v(j7, obj);
        return (jV == j4 && jV2 == j7) ? yVar : new y(yVar.f11367a, yVar.f11368b, yVar.f11369c, yVar.f11370d, yVar.f11371e, jV, jV2);
    }

    @Override // s2.i0
    public final void f(int i, c0 c0Var, t tVar, y yVar, IOException iOException, boolean z10) {
        if (a(i, c0Var)) {
            f3.a aVar = this.f11238w;
            y yVarB = b(yVar, c0Var);
            aVar.getClass();
            aVar.e(new g0(aVar, tVar, yVarB, iOException, z10));
        }
    }

    @Override // s2.i0
    public final void o(int i, c0 c0Var, t tVar, y yVar, int i10) {
        if (a(i, c0Var)) {
            f3.a aVar = this.f11238w;
            y yVarB = b(yVar, c0Var);
            aVar.getClass();
            aVar.e(new e0(aVar, tVar, yVarB, i10));
        }
    }

    @Override // l2.l
    public final void t(int i, c0 c0Var) {
        if (a(i, c0Var)) {
            this.f11239x.a();
        }
    }
}
