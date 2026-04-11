package r3;

import java.math.BigInteger;
import w2.a0;
import w2.b0;
import w2.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f11362a;

    public a(b bVar) {
        this.f11362a = bVar;
    }

    @Override // w2.b0
    public final boolean h() {
        return true;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        b bVar = this.f11362a;
        long j8 = (((long) bVar.f11366x.i) * j5) / 1000000;
        long j10 = bVar.f11364v;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j8);
        long j11 = bVar.f11365w;
        c0 c0Var = new c0(j5, s1.b0.j((bigIntegerValueOf.multiply(BigInteger.valueOf(j11 - j10)).divide(BigInteger.valueOf(bVar.f11368z)).longValue() + j10) - 30000, bVar.f11364v, j11 - 1));
        return new a0(c0Var, c0Var);
    }

    @Override // w2.b0
    public final long k() {
        b bVar = this.f11362a;
        return (bVar.f11368z * 1000000) / ((long) bVar.f11366x.i);
    }
}
