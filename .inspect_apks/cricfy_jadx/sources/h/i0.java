package h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static i0 f5356e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5357a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5360d;

    public /* synthetic */ i0() {
    }

    public static void c(i0 i0Var, long j4, long j7, int i) {
        if ((i & 1) != 0) {
            j4 = 0;
        }
        if ((i & 2) != 0) {
            j7 = 0;
        }
        synchronized (i0Var) {
            try {
                if (j4 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                if (j7 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                long j10 = i0Var.f5359c + j4;
                i0Var.f5359c = j10;
                long j11 = i0Var.f5360d + j7;
                i0Var.f5360d = j11;
                if (j11 > j10) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(double d10, double d11, long j4) {
        double d12 = (0.01720197f * ((j4 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(r3 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * r3) * 3.4906598739326E-4d) + (Math.sin(d12) * 0.03341960161924362d) + d12 + 1.796593063d + 3.141592653589793d;
        double dSin2 = (Math.sin(2.0d * dSin) * (-0.0069d)) + (Math.sin(d12) * 0.0053d) + ((double) (Math.round(((double) (r2 - 9.0E-4f)) - r6) + 9.0E-4f)) + ((-d11) / 360.0d);
        double dAsin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(dSin));
        double d13 = 0.01745329238474369d * d10;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(dAsin) * Math.sin(d13))) / (Math.cos(dAsin) * Math.cos(d13));
        if (dSin3 >= 1.0d) {
            this.f5358b = 1;
            this.f5359c = -1L;
            this.f5360d = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.f5358b = 0;
                this.f5359c = -1L;
                this.f5360d = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.f5359c = Math.round((dSin2 + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dSin2 - dAcos) * 8.64E7d) + 946728000000L;
            this.f5360d = jRound;
            if (jRound >= j4 || this.f5359c <= j4) {
                this.f5358b = 1;
            } else {
                this.f5358b = 0;
            }
        }
    }

    public synchronized long b() {
        return this.f5359c - this.f5360d;
    }

    public String toString() {
        switch (this.f5357a) {
            case 1:
                return "WindowCounter(streamId=" + this.f5358b + ", total=" + this.f5359c + ", acknowledged=" + this.f5360d + ", unacknowledged=" + b() + ')';
            default:
                return super.toString();
        }
    }

    public i0(int i) {
        this.f5358b = i;
    }
}
