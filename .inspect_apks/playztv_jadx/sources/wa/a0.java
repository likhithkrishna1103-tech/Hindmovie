package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13768e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f13769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f13770h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m2 f13771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s1 f13772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p1 f13773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte f13774m;

    public final b0 a() {
        if (this.f13774m == 1 && this.f13764a != null && this.f13765b != null && this.f13767d != null && this.f13770h != null && this.i != null) {
            return new b0(this.f13764a, this.f13765b, this.f13766c, this.f13767d, this.f13768e, this.f, this.f13769g, this.f13770h, this.i, this.f13771j, this.f13772k, this.f13773l);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f13764a == null) {
            sb2.append(" sdkVersion");
        }
        if (this.f13765b == null) {
            sb2.append(" gmpAppId");
        }
        if ((1 & this.f13774m) == 0) {
            sb2.append(" platform");
        }
        if (this.f13767d == null) {
            sb2.append(" installationUuid");
        }
        if (this.f13770h == null) {
            sb2.append(" buildVersion");
        }
        if (this.i == null) {
            sb2.append(" displayVersion");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
