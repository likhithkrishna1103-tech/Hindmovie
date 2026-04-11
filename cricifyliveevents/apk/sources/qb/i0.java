package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f10589e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u1 f10590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l2 f10591h;
    public k2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v1 f10592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f10593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte f10595m;

    public final j0 a() {
        String str;
        String str2;
        u1 u1Var;
        if (this.f10595m == 7 && (str = this.f10585a) != null && (str2 = this.f10586b) != null && (u1Var = this.f10590g) != null) {
            return new j0(str, str2, this.f10587c, this.f10588d, this.f10589e, this.f, u1Var, this.f10591h, this.i, this.f10592j, this.f10593k, this.f10594l);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10585a == null) {
            sb.append(" generator");
        }
        if (this.f10586b == null) {
            sb.append(" identifier");
        }
        if ((this.f10595m & 1) == 0) {
            sb.append(" startedAt");
        }
        if ((this.f10595m & 2) == 0) {
            sb.append(" crashed");
        }
        if (this.f10590g == null) {
            sb.append(" app");
        }
        if ((this.f10595m & 4) == 0) {
            sb.append(" generatorType");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
