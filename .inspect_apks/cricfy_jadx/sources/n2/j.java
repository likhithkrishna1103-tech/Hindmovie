package n2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements Comparable {
    public final v1.l A;
    public final String B;
    public final String C;
    public final long D;
    public final long E;
    public final boolean F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f8679v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f8680w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f8681x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f8682y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f8683z;

    public j(String str, i iVar, long j4, int i, long j7, v1.l lVar, String str2, String str3, long j10, long j11, boolean z10) {
        this.f8679v = str;
        this.f8680w = iVar;
        this.f8681x = j4;
        this.f8682y = i;
        this.f8683z = j7;
        this.A = lVar;
        this.B = str2;
        this.C = str3;
        this.D = j10;
        this.E = j11;
        this.F = z10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Long l10 = (Long) obj;
        long jLongValue = l10.longValue();
        long j4 = this.f8683z;
        if (j4 > jLongValue) {
            return 1;
        }
        return j4 < l10.longValue() ? -1 : 0;
    }
}
