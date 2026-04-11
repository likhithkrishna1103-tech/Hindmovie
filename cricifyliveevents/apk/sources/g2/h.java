package g2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4724c = -9223372036854775807L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4725d = -9223372036854775807L;
    public long f = -9223372036854775807L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4727g = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f4729j = 0.97f;
    public float i = 1.03f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f4730k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f4731l = -9223372036854775807L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4726e = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4728h = -9223372036854775807L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4732m = -9223372036854775807L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4733n = -9223372036854775807L;

    public h(long j4, long j7) {
        this.f4722a = j4;
        this.f4723b = j7;
    }

    public final void a() {
        long j4;
        long j7 = this.f4724c;
        if (j7 != -9223372036854775807L) {
            j4 = this.f4725d;
            if (j4 == -9223372036854775807L) {
                long j10 = this.f;
                if (j10 != -9223372036854775807L && j7 < j10) {
                    j7 = j10;
                }
                j4 = this.f4727g;
                if (j4 == -9223372036854775807L || j7 <= j4) {
                    j4 = j7;
                }
            }
        } else {
            j4 = -9223372036854775807L;
        }
        if (this.f4726e == j4) {
            return;
        }
        this.f4726e = j4;
        this.f4728h = j4;
        this.f4732m = -9223372036854775807L;
        this.f4733n = -9223372036854775807L;
        this.f4731l = -9223372036854775807L;
    }
}
