package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d2 f13982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e2 f13983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f2 f13984e;
    public i2 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f13985g;

    public final p0 a() {
        String str;
        d2 d2Var;
        e2 e2Var;
        if (this.f13985g == 1 && (str = this.f13981b) != null && (d2Var = this.f13982c) != null && (e2Var = this.f13983d) != null) {
            return new p0(this.f13980a, str, d2Var, e2Var, this.f13984e, this.f);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((1 & this.f13985g) == 0) {
            sb2.append(" timestamp");
        }
        if (this.f13981b == null) {
            sb2.append(" type");
        }
        if (this.f13982c == null) {
            sb2.append(" app");
        }
        if (this.f13983d == null) {
            sb2.append(" device");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
