package h2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements Comparable {
    public final String A;
    public final String B;
    public final long C;
    public final long D;
    public final boolean E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f5703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i f5704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f5705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f5706x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f5707y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final p1.m f5708z;

    public j(String str, i iVar, long j5, int i, long j8, p1.m mVar, String str2, String str3, long j10, long j11, boolean z2) {
        this.f5703u = str;
        this.f5704v = iVar;
        this.f5705w = j5;
        this.f5706x = i;
        this.f5707y = j8;
        this.f5708z = mVar;
        this.A = str2;
        this.B = str3;
        this.C = j10;
        this.D = j11;
        this.E = z2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Long l10 = (Long) obj;
        long jLongValue = l10.longValue();
        long j5 = this.f5707y;
        if (j5 > jLongValue) {
            return 1;
        }
        return j5 < l10.longValue() ? -1 : 0;
    }
}
