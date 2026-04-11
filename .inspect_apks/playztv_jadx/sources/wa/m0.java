package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13953e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f13955h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f13956j;

    public final n0 a() {
        String str;
        String str2;
        String str3;
        if (this.f13956j == 63 && (str = this.f13950b) != null && (str2 = this.f13955h) != null && (str3 = this.i) != null) {
            return new n0(this.f13949a, str, this.f13951c, this.f13952d, this.f13953e, this.f, this.f13954g, str2, str3);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f13956j & 1) == 0) {
            sb2.append(" arch");
        }
        if (this.f13950b == null) {
            sb2.append(" model");
        }
        if ((this.f13956j & 2) == 0) {
            sb2.append(" cores");
        }
        if ((this.f13956j & 4) == 0) {
            sb2.append(" ram");
        }
        if ((this.f13956j & 8) == 0) {
            sb2.append(" diskSpace");
        }
        if ((this.f13956j & 16) == 0) {
            sb2.append(" simulator");
        }
        if ((this.f13956j & 32) == 0) {
            sb2.append(" state");
        }
        if (this.f13955h == null) {
            sb2.append(" manufacturer");
        }
        if (this.i == null) {
            sb2.append(" modelClass");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
