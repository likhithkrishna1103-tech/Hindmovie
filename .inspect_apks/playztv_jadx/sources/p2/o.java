package p2;

import o2.b1;
import p1.q;
import v1.c0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends a {
    public final int I;
    public final q J;
    public long K;
    public boolean L;

    public o(v1.h hVar, v1.m mVar, q qVar, int i, Object obj, long j5, long j8, long j10, int i10, q qVar2) {
        super(hVar, mVar, qVar, i, obj, j5, j8, -9223372036854775807L, -9223372036854775807L, j10);
        this.I = i10;
        this.J = qVar2;
    }

    @Override // s2.j
    public final void b() {
        c0 c0Var = this.C;
        c cVar = this.G;
        s1.d.h(cVar);
        for (b1 b1Var : (b1[]) cVar.f10131w) {
            if (b1Var.F != 0) {
                b1Var.F = 0L;
                b1Var.f9080z = true;
            }
        }
        h0 h0VarW = cVar.w(this.I);
        h0VarW.d(this.J);
        try {
            long jH = c0Var.h(this.f10144v.c(this.K));
            if (jH != -1) {
                jH += this.K;
            }
            w2.l lVar = new w2.l(this.C, this.K, jH);
            for (int iC = 0; iC != -1; iC = h0VarW.c(lVar, Integer.MAX_VALUE, true)) {
                this.K += (long) iC;
            }
            h0VarW.a(this.A, 1, (int) this.K, 0, null);
            com.bumptech.glide.c.f(c0Var);
            this.L = true;
        } catch (Throwable th) {
            com.bumptech.glide.c.f(c0Var);
            throw th;
        }
    }

    @Override // p2.m
    public final boolean d() {
        return this.L;
    }

    @Override // s2.j
    public final void c() {
    }
}
