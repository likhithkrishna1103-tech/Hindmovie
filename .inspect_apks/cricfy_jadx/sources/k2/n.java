package k2;

import java.math.RoundingMode;
import java.util.List;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6878e;
    public final List f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f6879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f6880h;
    public final long i;

    public n(j jVar, long j4, long j7, long j10, long j11, List list, long j12, long j13, long j14) {
        super(jVar, j4, j7);
        this.f6877d = j10;
        this.f6878e = j11;
        this.f = list;
        this.i = j12;
        this.f6879g = j13;
        this.f6880h = j14;
    }

    public final long b(long j4, long j7) {
        long jD = d(j4);
        return jD != -1 ? jD : (int) (f((j7 - this.f6880h) + this.i, j4) - c(j4, j7));
    }

    public final long c(long j4, long j7) {
        long jD = d(j4);
        long j10 = this.f6877d;
        if (jD == -1) {
            long j11 = this.f6879g;
            if (j11 != -9223372036854775807L) {
                return Math.max(j10, f((j7 - this.f6880h) - j11, j4));
            }
        }
        return j10;
    }

    public abstract long d(long j4);

    public final long e(long j4, long j7) {
        long j10 = this.f6890b;
        long j11 = this.f6877d;
        List list = this.f;
        if (list != null) {
            return (((q) list.get((int) (j4 - j11))).f6886b * 1000000) / j10;
        }
        long jD = d(j7);
        return (jD == -1 || j4 != (j11 + jD) - 1) ? (this.f6878e * 1000000) / j10 : j7 - g(j4);
    }

    public final long f(long j4, long j7) {
        long jD = d(j7);
        long j10 = this.f6877d;
        if (jD != 0) {
            if (this.f != null) {
                long j11 = (jD + j10) - 1;
                long j12 = j10;
                while (j12 <= j11) {
                    long j13 = ((j11 - j12) / 2) + j12;
                    long jG = g(j13);
                    if (jG < j4) {
                        j12 = j13 + 1;
                    } else {
                        if (jG <= j4) {
                            return j13;
                        }
                        j11 = j13 - 1;
                    }
                }
                return j12 == j10 ? j12 : j11;
            }
            long j14 = (j4 / ((this.f6878e * 1000000) / this.f6890b)) + j10;
            if (j14 >= j10) {
                return jD == -1 ? j14 : Math.min(j14, (j10 + jD) - 1);
            }
        }
        return j10;
    }

    public final long g(long j4) {
        long j7 = this.f6877d;
        List list = this.f;
        long j10 = list != null ? ((q) list.get((int) (j4 - j7))).f6885a - this.f6891c : (j4 - j7) * this.f6878e;
        int i = a0.f14551a;
        return a0.W(j10, 1000000L, this.f6890b, RoundingMode.DOWN);
    }

    public abstract j h(k kVar, long j4);

    public boolean i() {
        return this.f != null;
    }
}
