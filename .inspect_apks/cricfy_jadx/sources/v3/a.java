package v3;

import a3.b0;
import a3.c0;
import a3.d0;
import java.math.BigInteger;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f13133a;

    public a(b bVar) {
        this.f13133a = bVar;
    }

    @Override // a3.c0
    public final boolean g() {
        return true;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        b bVar = this.f13133a;
        long j7 = (((long) bVar.f13137y.i) * j4) / 1000000;
        long j10 = bVar.f13135w;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j7);
        long j11 = bVar.f13136x;
        d0 d0Var = new d0(j4, a0.j((bigIntegerValueOf.multiply(BigInteger.valueOf(j11 - j10)).divide(BigInteger.valueOf(bVar.A)).longValue() + j10) - 30000, bVar.f13135w, j11 - 1));
        return new b0(d0Var, d0Var);
    }

    @Override // a3.c0
    public final long l() {
        b bVar = this.f13133a;
        return (bVar.A * 1000000) / ((long) bVar.f13137y.i);
    }
}
