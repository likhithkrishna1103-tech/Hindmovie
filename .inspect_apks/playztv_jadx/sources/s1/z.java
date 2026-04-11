package s1;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal f11722d = new ThreadLocal();

    public z(long j5) {
        g(j5);
    }

    public final synchronized long a(long j5) {
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!f()) {
                long jLongValue = this.f11719a;
                if (jLongValue == 9223372036854775806L) {
                    Long l10 = (Long) this.f11722d.get();
                    l10.getClass();
                    jLongValue = l10.longValue();
                }
                this.f11720b = jLongValue - j5;
                notifyAll();
            }
            this.f11721c = j5;
            return j5 + this.f11720b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long b(long j5) {
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j8 = this.f11721c;
            if (j8 != -9223372036854775807L) {
                int i = b0.f11647a;
                long jW = b0.W(j8, 90000L, 1000000L, RoundingMode.DOWN);
                long j10 = (4294967296L + jW) / 8589934592L;
                long j11 = ((j10 - 1) * 8589934592L) + j5;
                long j12 = (j10 * 8589934592L) + j5;
                j5 = Math.abs(j11 - jW) < Math.abs(j12 - jW) ? j11 : j12;
            }
            long j13 = j5;
            int i10 = b0.f11647a;
            return a(b0.W(j13, 1000000L, 90000L, RoundingMode.DOWN));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long c(long j5) {
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j8 = this.f11721c;
        if (j8 != -9223372036854775807L) {
            int i = b0.f11647a;
            long jW = b0.W(j8, 90000L, 1000000L, RoundingMode.DOWN);
            long j10 = jW / 8589934592L;
            Long.signum(j10);
            long j11 = (j10 * 8589934592L) + j5;
            j5 = j11 >= jW ? j11 : ((j10 + 1) * 8589934592L) + j5;
        }
        long j12 = j5;
        int i10 = b0.f11647a;
        return a(b0.W(j12, 1000000L, 90000L, RoundingMode.DOWN));
    }

    public final synchronized long d() {
        long j5;
        j5 = this.f11719a;
        if (j5 == Long.MAX_VALUE || j5 == 9223372036854775806L) {
            j5 = -9223372036854775807L;
        }
        return j5;
    }

    public final synchronized long e() {
        return this.f11720b;
    }

    public final synchronized boolean f() {
        return this.f11720b != -9223372036854775807L;
    }

    public final synchronized void g(long j5) {
        this.f11719a = j5;
        this.f11720b = j5 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f11721c = -9223372036854775807L;
    }

    public final synchronized void h(boolean z2, long j5) {
        try {
            d.g(this.f11719a == 9223372036854775806L);
            if (f()) {
                return;
            }
            if (z2) {
                this.f11722d.set(Long.valueOf(j5));
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
