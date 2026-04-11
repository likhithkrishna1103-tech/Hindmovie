package df;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long[] f3697e = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf.d f3698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ff.e f3699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f3701d;

    public d(bf.d dVar, ff.e eVar) {
        ge.i.e(dVar, "descriptor");
        this.f3698a = dVar;
        this.f3699b = eVar;
        int iD = dVar.d();
        if (iD <= 64) {
            this.f3700c = iD != 64 ? (-1) << iD : 0L;
            this.f3701d = f3697e;
            return;
        }
        this.f3700c = 0L;
        int i = (iD - 1) >>> 6;
        long[] jArr = new long[i];
        if ((iD & 63) != 0) {
            jArr[i - 1] = (-1) << iD;
        }
        this.f3701d = jArr;
    }
}
