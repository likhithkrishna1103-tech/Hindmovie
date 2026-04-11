package y1;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal f14622d = new ThreadLocal();

    public y(long j4) {
        g(j4);
    }

    public final synchronized long a(long j4) {
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!f()) {
                long jLongValue = this.f14619a;
                if (jLongValue == 9223372036854775806L) {
                    Long l10 = (Long) this.f14622d.get();
                    l10.getClass();
                    jLongValue = l10.longValue();
                }
                this.f14620b = jLongValue - j4;
                notifyAll();
            }
            this.f14621c = j4;
            return j4 + this.f14620b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long b(long j4) {
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j7 = this.f14621c;
            if (j7 != -9223372036854775807L) {
                int i = a0.f14551a;
                long jW = a0.W(j7, 90000L, 1000000L, RoundingMode.DOWN);
                long j10 = (4294967296L + jW) / 8589934592L;
                long j11 = ((j10 - 1) * 8589934592L) + j4;
                long j12 = (j10 * 8589934592L) + j4;
                j4 = Math.abs(j11 - jW) < Math.abs(j12 - jW) ? j11 : j12;
            }
            long j13 = j4;
            int i10 = a0.f14551a;
            return a(a0.W(j13, 1000000L, 90000L, RoundingMode.DOWN));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long c(long j4) {
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j7 = this.f14621c;
        if (j7 != -9223372036854775807L) {
            int i = a0.f14551a;
            long jW = a0.W(j7, 90000L, 1000000L, RoundingMode.DOWN);
            long j10 = jW / 8589934592L;
            Long.signum(j10);
            long j11 = (j10 * 8589934592L) + j4;
            j4 = j11 >= jW ? j11 : ((j10 + 1) * 8589934592L) + j4;
        }
        long j12 = j4;
        int i10 = a0.f14551a;
        return a(a0.W(j12, 1000000L, 90000L, RoundingMode.DOWN));
    }

    public final synchronized long d() {
        long j4;
        j4 = this.f14619a;
        if (j4 == Long.MAX_VALUE || j4 == 9223372036854775806L) {
            j4 = -9223372036854775807L;
        }
        return j4;
    }

    public final synchronized long e() {
        return this.f14620b;
    }

    public final synchronized boolean f() {
        return this.f14620b != -9223372036854775807L;
    }

    public final synchronized void g(long j4) {
        this.f14619a = j4;
        this.f14620b = j4 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f14621c = -9223372036854775807L;
    }

    public final synchronized void h(boolean z10, long j4) {
        try {
            d.g(this.f14619a == 9223372036854775806L);
            if (f()) {
                return;
            }
            if (z10) {
                this.f14622d.set(Long.valueOf(j4));
            } else {
                while (!f()) {
                    wait();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
