package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f1 f10537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f10541e;

    public final e1 a() {
        f1 f1Var;
        String str;
        String str2;
        if (this.f10541e == 1 && (f1Var = this.f10537a) != null && (str = this.f10538b) != null && (str2 = this.f10539c) != null) {
            return new e1(f1Var, str, str2, this.f10540d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10537a == null) {
            sb.append(" rolloutVariant");
        }
        if (this.f10538b == null) {
            sb.append(" parameterKey");
        }
        if (this.f10539c == null) {
            sb.append(" parameterValue");
        }
        if ((1 & this.f10541e) == 0) {
            sb.append(" templateVersion");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
