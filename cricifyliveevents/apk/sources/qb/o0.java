package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d2 f10685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e2 f10686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f2 f10687e;
    public i2 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f10688g;

    public final p0 a() {
        String str;
        d2 d2Var;
        e2 e2Var;
        if (this.f10688g == 1 && (str = this.f10684b) != null && (d2Var = this.f10685c) != null && (e2Var = this.f10686d) != null) {
            return new p0(this.f10683a, str, d2Var, e2Var, this.f10687e, this.f);
        }
        StringBuilder sb = new StringBuilder();
        if ((1 & this.f10688g) == 0) {
            sb.append(" timestamp");
        }
        if (this.f10684b == null) {
            sb.append(" type");
        }
        if (this.f10685c == null) {
            sb.append(" app");
        }
        if (this.f10686d == null) {
            sb.append(" device");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
