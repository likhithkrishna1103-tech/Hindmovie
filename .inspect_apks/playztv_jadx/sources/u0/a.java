package u0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f12527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12528e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12530h;
    public int i;

    public final float a(long j5) {
        if (j5 < this.f12528e) {
            return 0.0f;
        }
        long j8 = this.f12529g;
        if (j8 < 0 || j5 < j8) {
            return d.b((j5 - r0) / this.f12524a, 0.0f, 1.0f) * 0.5f;
        }
        float f = this.f12530h;
        return (d.b((j5 - j8) / this.i, 0.0f, 1.0f) * f) + (1.0f - f);
    }
}
