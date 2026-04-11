package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f10576e;

    public final i1 a() {
        String str;
        String str2;
        if (this.f10576e == 3 && (str = this.f10573b) != null && (str2 = this.f10574c) != null) {
            return new i1(this.f10572a, str, str2, this.f10575d);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f10576e & 1) == 0) {
            sb.append(" platform");
        }
        if (this.f10573b == null) {
            sb.append(" version");
        }
        if (this.f10574c == null) {
            sb.append(" buildVersion");
        }
        if ((this.f10576e & 2) == 0) {
            sb.append(" jailbroken");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
