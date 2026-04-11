package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f13886e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u1 f13887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l2 f13888h;
    public k2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v1 f13889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f13890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte f13892m;

    public final j0 a() {
        String str;
        String str2;
        u1 u1Var;
        if (this.f13892m == 7 && (str = this.f13882a) != null && (str2 = this.f13883b) != null && (u1Var = this.f13887g) != null) {
            return new j0(str, str2, this.f13884c, this.f13885d, this.f13886e, this.f, u1Var, this.f13888h, this.i, this.f13889j, this.f13890k, this.f13891l);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f13882a == null) {
            sb2.append(" generator");
        }
        if (this.f13883b == null) {
            sb2.append(" identifier");
        }
        if ((this.f13892m & 1) == 0) {
            sb2.append(" startedAt");
        }
        if ((this.f13892m & 2) == 0) {
            sb2.append(" crashed");
        }
        if (this.f13887g == null) {
            sb2.append(" app");
        }
        if ((this.f13892m & 4) == 0) {
            sb2.append(" generatorType");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
