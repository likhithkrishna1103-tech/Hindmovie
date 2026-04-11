package t2;

import a3.i0;
import b2.f0;
import b2.o;
import nb.w;
import s2.z0;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends a {
    public final int J;
    public final p K;
    public long L;
    public boolean M;

    public m(b2.h hVar, o oVar, p pVar, int i, Object obj, long j4, long j7, long j10, int i10, p pVar2) {
        super(hVar, oVar, pVar, i, obj, j4, j7, -9223372036854775807L, -9223372036854775807L, j10);
        this.J = i10;
        this.K = pVar2;
    }

    @Override // w2.k
    public final void a() {
        f0 f0Var = this.D;
        w wVar = this.H;
        y1.d.h(wVar);
        for (z0 z0Var : (z0[]) wVar.f9017x) {
            if (z0Var.F != 0) {
                z0Var.F = 0L;
                z0Var.f11396z = true;
            }
        }
        i0 i0VarQ = wVar.Q(this.J);
        i0VarQ.f(this.K);
        try {
            long jB = f0Var.B(this.f11849w.c(this.L));
            if (jB != -1) {
                jB += this.L;
            }
            a3.l lVar = new a3.l(this.D, this.L, jB);
            for (int iB = 0; iB != -1; iB = i0VarQ.b(lVar, Integer.MAX_VALUE, true)) {
                this.L += (long) iB;
            }
            i0VarQ.e(this.B, 1, (int) this.L, 0, null);
            u8.a.g(f0Var);
            this.M = true;
        } catch (Throwable th) {
            u8.a.g(f0Var);
            throw th;
        }
    }

    @Override // t2.k
    public final boolean c() {
        return this.M;
    }

    @Override // w2.k
    public final void d() {
    }
}
