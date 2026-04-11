package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f284c = -9223372036854775807L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f285d = -9223372036854775807L;
    public long f = -9223372036854775807L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f287g = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f289j = 0.97f;
    public float i = 1.03f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f290k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f291l = -9223372036854775807L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f286e = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f288h = -9223372036854775807L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f292m = -9223372036854775807L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f293n = -9223372036854775807L;

    public j(long j5, long j8) {
        this.f282a = j5;
        this.f283b = j8;
    }

    public final void a() {
        long j5;
        long j8 = this.f284c;
        if (j8 != -9223372036854775807L) {
            j5 = this.f285d;
            if (j5 == -9223372036854775807L) {
                long j10 = this.f;
                if (j10 != -9223372036854775807L && j8 < j10) {
                    j8 = j10;
                }
                j5 = this.f287g;
                if (j5 == -9223372036854775807L || j8 <= j5) {
                    j5 = j8;
                }
            }
        } else {
            j5 = -9223372036854775807L;
        }
        if (this.f286e == j5) {
            return;
        }
        this.f286e = j5;
        this.f288h = j5;
        this.f292m = -9223372036854775807L;
        this.f293n = -9223372036854775807L;
        this.f291l = -9223372036854775807L;
    }
}
