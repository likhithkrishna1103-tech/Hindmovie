package t2;

import a3.i0;
import b2.f0;
import b2.o;
import nb.w;
import s2.z0;
import v1.m0;
import v1.p;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends a {
    public final int J;
    public final long K;
    public final d L;
    public long M;
    public volatile boolean N;
    public boolean O;

    public i(b2.h hVar, o oVar, p pVar, int i, Object obj, long j4, long j7, long j10, long j11, long j12, int i10, long j13, d dVar) {
        super(hVar, oVar, pVar, i, obj, j4, j7, j10, j11, j12);
        this.J = i10;
        this.K = j13;
        this.L = dVar;
    }

    @Override // w2.k
    public final void a() {
        w wVar = this.H;
        y1.d.h(wVar);
        if (this.M == 0) {
            long j4 = this.K;
            for (z0 z0Var : (z0[]) wVar.f9017x) {
                if (z0Var.F != j4) {
                    z0Var.F = j4;
                    z0Var.f11396z = true;
                }
            }
            d dVar = this.L;
            long j7 = this.F;
            long j10 = j7 == -9223372036854775807L ? -9223372036854775807L : j7 - this.K;
            long j11 = this.G;
            dVar.a(wVar, j10, j11 != -9223372036854775807L ? j11 - this.K : -9223372036854775807L);
        }
        try {
            o oVarC = this.f11849w.c(this.M);
            f0 f0Var = this.D;
            a3.l lVar = new a3.l(f0Var, oVarC.f, f0Var.B(oVarC));
            while (!this.N) {
                try {
                    int i = this.L.f11843v.i(lVar, d.E);
                    y1.d.g(i != 1);
                    if (!(i == 0)) {
                        break;
                    }
                } finally {
                    this.M = lVar.f215y - this.f11849w.f;
                }
            }
            p pVar = this.f11851y;
            String str = pVar.f12945m;
            int i10 = pVar.M;
            int i11 = pVar.N;
            if (m0.m(str) && ((i10 > 1 || i11 > 1) && i10 != -1 && i11 != -1)) {
                i0 i0VarQ = wVar.Q(4);
                int i12 = i10 * i11;
                long j12 = (this.C - this.B) / ((long) i12);
                for (int i13 = 1; i13 < i12; i13++) {
                    i0VarQ.a(0, new t());
                    i0VarQ.e(((long) i13) * j12, 0, 0, 0, null);
                }
            }
            u8.a.g(this.D);
            this.O = !this.N;
        } catch (Throwable th) {
            u8.a.g(this.D);
            throw th;
        }
    }

    @Override // t2.k
    public final long b() {
        return this.E + ((long) this.J);
    }

    @Override // t2.k
    public final boolean c() {
        return this.O;
    }

    @Override // w2.k
    public final void d() {
        this.N = true;
    }
}
