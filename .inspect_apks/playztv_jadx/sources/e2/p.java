package e2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends n {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a7.b f4353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a7.b f4354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f4355l;

    public p(j jVar, long j5, long j8, long j10, long j11, long j12, List list, long j13, a7.b bVar, a7.b bVar2, long j14, long j15) {
        super(jVar, j5, j8, j10, j12, list, j13, j14, j15);
        this.f4353j = bVar;
        this.f4354k = bVar2;
        this.f4355l = j11;
    }

    @Override // e2.s
    public final j a(m mVar) {
        a7.b bVar = this.f4353j;
        if (bVar == null) {
            return this.f4360a;
        }
        p1.q qVar = mVar.f4343u;
        return new j(0L, -1L, bVar.l(qVar.f10012a, 0L, qVar.f10019j, 0L));
    }

    @Override // e2.n
    public final long d(long j5) {
        if (this.f != null) {
            return r0.size();
        }
        long j8 = this.f4355l;
        if (j8 != -1) {
            return (j8 - this.f4348d) + 1;
        }
        if (j5 == -9223372036854775807L) {
            return -1L;
        }
        BigInteger bigIntegerMultiply = BigInteger.valueOf(j5).multiply(BigInteger.valueOf(this.f4361b));
        BigInteger bigIntegerMultiply2 = BigInteger.valueOf(this.f4349e).multiply(BigInteger.valueOf(1000000L));
        RoundingMode roundingMode = RoundingMode.CEILING;
        int i = ca.a.f2589a;
        return new BigDecimal(bigIntegerMultiply).divide(new BigDecimal(bigIntegerMultiply2), 0, roundingMode).toBigIntegerExact().longValue();
    }

    @Override // e2.n
    public final j h(k kVar, long j5) {
        long j8 = this.f4348d;
        List list = this.f;
        long j10 = list != null ? ((q) list.get((int) (j5 - j8))).f4356a : (j5 - j8) * this.f4349e;
        p1.q qVar = kVar.f4343u;
        return new j(0L, -1L, this.f4354k.l(qVar.f10012a, j5, qVar.f10019j, j10));
    }
}
