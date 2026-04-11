package k8;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f7410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f7411e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f7412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f7413h;
    public final Long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f7414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f7415k;

    public s(long j5, String str, String str2) {
        this(str, str2, 0L, 0L, 0L, j5, 0L, null, null, null, null);
    }

    public final s a(long j5) {
        return new s(this.f7407a, this.f7408b, this.f7409c, this.f7410d, this.f7411e, j5, this.f7412g, this.f7413h, this.i, this.f7414j, this.f7415k);
    }

    public final s b(Long l10, Long l11, Boolean bool) {
        return new s(this.f7407a, this.f7408b, this.f7409c, this.f7410d, this.f7411e, this.f, this.f7412g, this.f7413h, l10, l11, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public s(String str, String str2, long j5, long j8, long j10, long j11, long j12, Long l10, Long l11, Long l12, Boolean bool) {
        t7.v.d(str);
        t7.v.d(str2);
        t7.v.a(j5 >= 0);
        t7.v.a(j8 >= 0);
        t7.v.a(j10 >= 0);
        t7.v.a(j12 >= 0);
        this.f7407a = str;
        this.f7408b = str2;
        this.f7409c = j5;
        this.f7410d = j8;
        this.f7411e = j10;
        this.f = j11;
        this.f7412g = j12;
        this.f7413h = l10;
        this.i = l11;
        this.f7414j = l12;
        this.f7415k = bool;
    }
}
