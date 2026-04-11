package h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static j0 f5508d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5511c;

    public final void a(long j5, double d10, double d11) {
        double d12 = (0.01720197f * ((j5 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(r3 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * r3) * 3.4906598739326E-4d) + (Math.sin(d12) * 0.03341960161924362d) + d12 + 1.796593063d + 3.141592653589793d;
        double dSin2 = (Math.sin(2.0d * dSin) * (-0.0069d)) + (Math.sin(d12) * 0.0053d) + ((double) (Math.round(((double) (r2 - 9.0E-4f)) - r6) + 9.0E-4f)) + ((-d11) / 360.0d);
        double dAsin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(dSin));
        double d13 = 0.01745329238474369d * d10;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(dAsin) * Math.sin(d13))) / (Math.cos(dAsin) * Math.cos(d13));
        if (dSin3 >= 1.0d) {
            this.f5511c = 1;
            this.f5509a = -1L;
            this.f5510b = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.f5511c = 0;
                this.f5509a = -1L;
                this.f5510b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.f5509a = Math.round((dSin2 + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dSin2 - dAcos) * 8.64E7d) + 946728000000L;
            this.f5510b = jRound;
            if (jRound >= j5 || this.f5509a <= j5) {
                this.f5511c = 1;
            } else {
                this.f5511c = 0;
            }
        }
    }
}
