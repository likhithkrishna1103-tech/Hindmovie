package w2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13627d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13628e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f13629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13630h;

    public g(long j5, long j8, long j10, long j11, long j12, long j13) {
        this.f13624a = j5;
        this.f13625b = j8;
        this.f13628e = j10;
        this.f = j11;
        this.f13629g = j12;
        this.f13626c = j13;
        this.f13630h = a(j8, 0L, j10, j11, j12, j13);
    }

    public static long a(long j5, long j8, long j10, long j11, long j12, long j13) {
        if (j11 + 1 >= j12 || j8 + 1 >= j10) {
            return j11;
        }
        long j14 = (long) ((j5 - j8) * ((j12 - j11) / (j10 - j8)));
        return s1.b0.j(((j14 + j11) - j13) - (j14 / 20), j11, j12 - 1);
    }
}
