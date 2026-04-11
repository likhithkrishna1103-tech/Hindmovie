package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f13873e;

    public final i1 a() {
        String str;
        String str2;
        if (this.f13873e == 3 && (str = this.f13870b) != null && (str2 = this.f13871c) != null) {
            return new i1(this.f13869a, str, str2, this.f13872d);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f13873e & 1) == 0) {
            sb2.append(" platform");
        }
        if (this.f13870b == null) {
            sb2.append(" version");
        }
        if (this.f13871c == null) {
            sb2.append(" buildVersion");
        }
        if ((this.f13873e & 2) == 0) {
            sb2.append(" jailbroken");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
