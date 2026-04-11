package e4;

import java.math.RoundingMode;
import w2.a0;
import w2.b0;
import w2.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4427e;

    public h(e eVar, int i, long j5, long j8) {
        this.f4423a = eVar;
        this.f4424b = i;
        this.f4425c = j5;
        long j10 = (j8 - j5) / ((long) eVar.f4416w);
        this.f4426d = j10;
        this.f4427e = a(j10);
    }

    public final long a(long j5) {
        long j8 = j5 * ((long) this.f4424b);
        long j10 = this.f4423a.f4415v;
        int i = s1.b0.f11647a;
        return s1.b0.W(j8, 1000000L, j10, RoundingMode.DOWN);
    }

    @Override // w2.b0
    public final boolean h() {
        return true;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        e eVar = this.f4423a;
        long j8 = (((long) eVar.f4415v) * j5) / (((long) this.f4424b) * 1000000);
        long j10 = this.f4426d;
        long j11 = s1.b0.j(j8, 0L, j10 - 1);
        long j12 = ((long) eVar.f4416w) * j11;
        long j13 = this.f4425c;
        long jA = a(j11);
        c0 c0Var = new c0(jA, j12 + j13);
        if (jA >= j5 || j11 == j10 - 1) {
            return new a0(c0Var, c0Var);
        }
        long j14 = j11 + 1;
        return new a0(c0Var, new c0(a(j14), (((long) eVar.f4416w) * j14) + j13));
    }

    @Override // w2.b0
    public final long k() {
        return this.f4427e;
    }
}
