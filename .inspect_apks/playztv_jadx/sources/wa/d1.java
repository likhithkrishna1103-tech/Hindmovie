package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f1 f13834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f13838e;

    public final e1 a() {
        f1 f1Var;
        String str;
        String str2;
        if (this.f13838e == 1 && (f1Var = this.f13834a) != null && (str = this.f13835b) != null && (str2 = this.f13836c) != null) {
            return new e1(f1Var, str, str2, this.f13837d);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f13834a == null) {
            sb2.append(" rolloutVariant");
        }
        if (this.f13835b == null) {
            sb2.append(" parameterKey");
        }
        if (this.f13836c == null) {
            sb2.append(" parameterValue");
        }
        if ((1 & this.f13838e) == 0) {
            sb2.append(" templateVersion");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
