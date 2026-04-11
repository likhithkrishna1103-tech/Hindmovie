package f9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4384e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f4386h;
    public final Long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f4387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f4388k;

    public s(String str, String str2, long j4, long j7, long j10, long j11, long j12, Long l10, Long l11, Long l12, Boolean bool) {
        o8.u.d(str);
        o8.u.d(str2);
        o8.u.b(j4 >= 0);
        o8.u.b(j7 >= 0);
        o8.u.b(j10 >= 0);
        o8.u.b(j12 >= 0);
        this.f4380a = str;
        this.f4381b = str2;
        this.f4382c = j4;
        this.f4383d = j7;
        this.f4384e = j10;
        this.f = j11;
        this.f4385g = j12;
        this.f4386h = l10;
        this.i = l11;
        this.f4387j = l12;
        this.f4388k = bool;
    }

    public final s a(long j4) {
        return new s(this.f4380a, this.f4381b, this.f4382c, this.f4383d, this.f4384e, j4, this.f4385g, this.f4386h, this.i, this.f4387j, this.f4388k);
    }

    public final s b(Long l10, Long l11, Boolean bool) {
        return new s(this.f4380a, this.f4381b, this.f4382c, this.f4383d, this.f4384e, this.f, this.f4385g, this.f4386h, l10, l11, bool);
    }
}
