package k2;

import java.util.ArrayList;
import ua.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends m implements j2.i {
    public final n A;

    public k(v1.p pVar, i0 i0Var, n nVar, ArrayList arrayList) {
        super(pVar, i0Var, nVar, arrayList);
        this.A = nVar;
    }

    @Override // k2.m
    public final String a() {
        return null;
    }

    @Override // j2.i
    public final long b(long j4) {
        return this.A.g(j4);
    }

    @Override // j2.i
    public final long c(long j4, long j7) {
        return this.A.f(j4, j7);
    }

    @Override // k2.m
    public final j e() {
        return null;
    }

    @Override // j2.i
    public final long f(long j4, long j7) {
        return this.A.e(j4, j7);
    }

    @Override // j2.i
    public final long h(long j4, long j7) {
        return this.A.c(j4, j7);
    }

    @Override // j2.i
    public final long l(long j4, long j7) {
        n nVar = this.A;
        if (nVar.f != null) {
            return -9223372036854775807L;
        }
        long jB = nVar.b(j4, j7) + nVar.c(j4, j7);
        return (nVar.e(jB, j4) + nVar.g(jB)) - nVar.i;
    }

    @Override // j2.i
    public final j m(long j4) {
        return this.A.h(this, j4);
    }

    @Override // j2.i
    public final boolean o() {
        return this.A.i();
    }

    @Override // j2.i
    public final long q() {
        return this.A.f6877d;
    }

    @Override // j2.i
    public final long u(long j4) {
        return this.A.d(j4);
    }

    @Override // j2.i
    public final long w(long j4, long j7) {
        return this.A.b(j4, j7);
    }

    @Override // k2.m
    public final j2.i d() {
        return this;
    }
}
