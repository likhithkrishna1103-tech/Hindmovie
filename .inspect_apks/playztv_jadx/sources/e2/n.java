package e2;

import java.math.RoundingMode;
import java.util.List;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4349e;
    public final List f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4351h;
    public final long i;

    public n(j jVar, long j5, long j8, long j10, long j11, List list, long j12, long j13, long j14) {
        super(jVar, j5, j8);
        this.f4348d = j10;
        this.f4349e = j11;
        this.f = list;
        this.i = j12;
        this.f4350g = j13;
        this.f4351h = j14;
    }

    public final long b(long j5, long j8) {
        long jD = d(j5);
        return jD != -1 ? jD : (int) (f((j8 - this.f4351h) + this.i, j5) - c(j5, j8));
    }

    public final long c(long j5, long j8) {
        long jD = d(j5);
        long j10 = this.f4348d;
        if (jD == -1) {
            long j11 = this.f4350g;
            if (j11 != -9223372036854775807L) {
                return Math.max(j10, f((j8 - this.f4351h) - j11, j5));
            }
        }
        return j10;
    }

    public abstract long d(long j5);

    public final long e(long j5, long j8) {
        long j10 = this.f4361b;
        long j11 = this.f4348d;
        List list = this.f;
        if (list != null) {
            return (((q) list.get((int) (j5 - j11))).f4357b * 1000000) / j10;
        }
        long jD = d(j8);
        return (jD == -1 || j5 != (j11 + jD) - 1) ? (this.f4349e * 1000000) / j10 : j8 - g(j5);
    }

    public final long f(long j5, long j8) {
        long jD = d(j8);
        long j10 = this.f4348d;
        if (jD != 0) {
            if (this.f != null) {
                long j11 = (jD + j10) - 1;
                long j12 = j10;
                while (j12 <= j11) {
                    long j13 = ((j11 - j12) / 2) + j12;
                    long jG = g(j13);
                    if (jG < j5) {
                        j12 = j13 + 1;
                    } else {
                        if (jG <= j5) {
                            return j13;
                        }
                        j11 = j13 - 1;
                    }
                }
                return j12 == j10 ? j12 : j11;
            }
            long j14 = (j5 / ((this.f4349e * 1000000) / this.f4361b)) + j10;
            if (j14 >= j10) {
                return jD == -1 ? j14 : Math.min(j14, (j10 + jD) - 1);
            }
        }
        return j10;
    }

    public final long g(long j5) {
        long j8 = this.f4348d;
        List list = this.f;
        long j10 = list != null ? ((q) list.get((int) (j5 - j8))).f4356a - this.f4362c : (j5 - j8) * this.f4349e;
        int i = b0.f11647a;
        return b0.W(j10, 1000000L, this.f4361b, RoundingMode.DOWN);
    }

    public abstract j h(k kVar, long j5);

    public boolean i() {
        return this.f != null;
    }
}
