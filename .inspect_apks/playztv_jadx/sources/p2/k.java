package p2;

import o2.b1;
import p1.m0;
import p1.q;
import s1.u;
import v1.c0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends a {
    public final int I;
    public final long J;
    public final e K;
    public long L;
    public volatile boolean M;
    public boolean N;

    public k(v1.h hVar, v1.m mVar, q qVar, int i, Object obj, long j5, long j8, long j10, long j11, long j12, int i10, long j13, e eVar) {
        super(hVar, mVar, qVar, i, obj, j5, j8, j10, j11, j12);
        this.I = i10;
        this.J = j13;
        this.K = eVar;
    }

    @Override // p2.m
    public final long a() {
        return this.D + ((long) this.I);
    }

    @Override // s2.j
    public final void b() {
        c cVar = this.G;
        s1.d.h(cVar);
        if (this.L == 0) {
            long j5 = this.J;
            for (b1 b1Var : (b1[]) cVar.f10131w) {
                if (b1Var.F != j5) {
                    b1Var.F = j5;
                    b1Var.f9080z = true;
                }
            }
            e eVar = this.K;
            long j8 = this.E;
            long j10 = j8 == -9223372036854775807L ? -9223372036854775807L : j8 - this.J;
            long j11 = this.F;
            eVar.a(cVar, j10, j11 != -9223372036854775807L ? j11 - this.J : -9223372036854775807L);
        }
        try {
            v1.m mVarC = this.f10144v.c(this.L);
            c0 c0Var = this.C;
            w2.l lVar = new w2.l(c0Var, mVarC.f, c0Var.h(mVarC));
            while (!this.M) {
                try {
                    int iL = this.K.f10137u.l(lVar, e.D);
                    s1.d.g(iL != 1);
                    if (!(iL == 0)) {
                        break;
                    }
                } finally {
                    this.L = lVar.f13653x - this.f10144v.f;
                }
            }
            q qVar = this.f10146x;
            String str = qVar.f10022m;
            int i = qVar.M;
            int i10 = qVar.N;
            if (m0.m(str) && ((i > 1 || i10 > 1) && i != -1 && i10 != -1)) {
                h0 h0VarW = cVar.w(4);
                int i11 = i * i10;
                long j12 = (this.B - this.A) / ((long) i11);
                for (int i12 = 1; i12 < i11; i12++) {
                    h0VarW.f(0, new u());
                    h0VarW.a(((long) i12) * j12, 0, 0, 0, null);
                }
            }
            com.bumptech.glide.c.f(this.C);
            this.N = !this.M;
        } catch (Throwable th) {
            com.bumptech.glide.c.f(this.C);
            throw th;
        }
    }

    @Override // s2.j
    public final void c() {
        this.M = true;
    }

    @Override // p2.m
    public final boolean d() {
        return this.N;
    }
}
