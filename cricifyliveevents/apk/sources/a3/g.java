package a3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f184d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f185e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f187h;

    public g(long j4, long j7, long j10, long j11, long j12, long j13) {
        this.f181a = j4;
        this.f182b = j7;
        this.f185e = j10;
        this.f = j11;
        this.f186g = j12;
        this.f183c = j13;
        this.f187h = a(j7, 0L, j10, j11, j12, j13);
    }

    public static long a(long j4, long j7, long j10, long j11, long j12, long j13) {
        if (j11 + 1 >= j12 || j7 + 1 >= j10) {
            return j11;
        }
        long j14 = (long) ((j4 - j7) * ((j12 - j11) / (j10 - j7)));
        return y1.a0.j(((j14 + j11) - j13) - (j14 / 20), j11, j12 - 1);
    }
}
