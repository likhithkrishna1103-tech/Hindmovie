package x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f14210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14211e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14213h;
    public int i;

    public final float a(long j4) {
        if (j4 < this.f14211e) {
            return 0.0f;
        }
        long j7 = this.f14212g;
        if (j7 < 0 || j4 < j7) {
            return d.b((j4 - r0) / this.f14207a, 0.0f, 1.0f) * 0.5f;
        }
        float f = this.f14213h;
        return (d.b((j4 - j7) / this.i, 0.0f, 1.0f) * f) + (1.0f - f);
    }
}
