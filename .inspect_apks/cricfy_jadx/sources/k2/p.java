package k2;

import androidx.emoji2.text.v;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends n {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v f6882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v f6883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f6884l;

    public p(j jVar, long j4, long j7, long j10, long j11, long j12, List list, long j13, v vVar, v vVar2, long j14, long j15) {
        super(jVar, j4, j7, j10, j12, list, j13, j14, j15);
        this.f6882j = vVar;
        this.f6883k = vVar2;
        this.f6884l = j11;
    }

    @Override // k2.s
    public final j a(m mVar) {
        v vVar = this.f6882j;
        if (vVar == null) {
            return this.f6889a;
        }
        v1.p pVar = mVar.f6872v;
        return new j(0L, -1L, vVar.g(pVar.f12935a, 0L, pVar.f12942j, 0L));
    }

    @Override // k2.n
    public final long d(long j4) {
        if (this.f != null) {
            return r0.size();
        }
        long j7 = this.f6884l;
        if (j7 != -1) {
            return (j7 - this.f6877d) + 1;
        }
        if (j4 == -9223372036854775807L) {
            return -1L;
        }
        BigInteger bigIntegerMultiply = BigInteger.valueOf(j4).multiply(BigInteger.valueOf(this.f6890b));
        BigInteger bigIntegerMultiply2 = BigInteger.valueOf(this.f6878e).multiply(BigInteger.valueOf(1000000L));
        RoundingMode roundingMode = RoundingMode.CEILING;
        int i = wa.a.f14128a;
        return new BigDecimal(bigIntegerMultiply).divide(new BigDecimal(bigIntegerMultiply2), 0, roundingMode).toBigIntegerExact().longValue();
    }

    @Override // k2.n
    public final j h(k kVar, long j4) {
        long j7 = this.f6877d;
        List list = this.f;
        long j10 = list != null ? ((q) list.get((int) (j4 - j7))).f6885a : (j4 - j7) * this.f6878e;
        v1.p pVar = kVar.f6872v;
        return new j(0L, -1L, this.f6883k.g(pVar.f12935a, j4, pVar.f12942j, j10));
    }
}
