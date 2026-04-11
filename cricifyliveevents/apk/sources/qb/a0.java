package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10471e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10473h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m2 f10474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s1 f10475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p1 f10476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte f10477m;

    public final b0 a() {
        if (this.f10477m == 1 && this.f10467a != null && this.f10468b != null && this.f10470d != null && this.f10473h != null && this.i != null) {
            return new b0(this.f10467a, this.f10468b, this.f10469c, this.f10470d, this.f10471e, this.f, this.f10472g, this.f10473h, this.i, this.f10474j, this.f10475k, this.f10476l);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10467a == null) {
            sb.append(" sdkVersion");
        }
        if (this.f10468b == null) {
            sb.append(" gmpAppId");
        }
        if ((1 & this.f10477m) == 0) {
            sb.append(" platform");
        }
        if (this.f10470d == null) {
            sb.append(" installationUuid");
        }
        if (this.f10473h == null) {
            sb.append(" buildVersion");
        }
        if (this.i == null) {
            sb.append(" displayVersion");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
