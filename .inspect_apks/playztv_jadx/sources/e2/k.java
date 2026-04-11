package e2;

import aa.j0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends m implements d2.h {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final n f4341z;

    public k(p1.q qVar, j0 j0Var, n nVar, ArrayList arrayList) {
        super(qVar, j0Var, nVar, arrayList);
        this.f4341z = nVar;
    }

    @Override // d2.h
    public final long A(long j5, long j8) {
        return this.f4341z.b(j5, j8);
    }

    @Override // e2.m
    public final String a() {
        return null;
    }

    @Override // d2.h
    public final long b(long j5) {
        return this.f4341z.g(j5);
    }

    @Override // d2.h
    public final long c(long j5, long j8) {
        return this.f4341z.f(j5, j8);
    }

    @Override // d2.h
    public final long d(long j5, long j8) {
        return this.f4341z.e(j5, j8);
    }

    @Override // e2.m
    public final j f() {
        return null;
    }

    @Override // d2.h
    public final long p(long j5, long j8) {
        return this.f4341z.c(j5, j8);
    }

    @Override // d2.h
    public final long u(long j5, long j8) {
        n nVar = this.f4341z;
        if (nVar.f != null) {
            return -9223372036854775807L;
        }
        long jB = nVar.b(j5, j8) + nVar.c(j5, j8);
        return (nVar.e(jB, j5) + nVar.g(jB)) - nVar.i;
    }

    @Override // d2.h
    public final j v(long j5) {
        return this.f4341z.h(this, j5);
    }

    @Override // d2.h
    public final boolean x() {
        return this.f4341z.i();
    }

    @Override // d2.h
    public final long y() {
        return this.f4341z.f4348d;
    }

    @Override // d2.h
    public final long z(long j5) {
        return this.f4341z.d(j5);
    }

    @Override // e2.m
    public final d2.h e() {
        return this;
    }
}
