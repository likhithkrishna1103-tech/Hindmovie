package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10761e;
    public byte f;

    public final x0 a() {
        String str;
        if (this.f == 7 && (str = this.f10758b) != null) {
            return new x0(this.f10757a, str, this.f10759c, this.f10760d, this.f10761e);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f & 1) == 0) {
            sb.append(" pc");
        }
        if (this.f10758b == null) {
            sb.append(" symbol");
        }
        if ((this.f & 2) == 0) {
            sb.append(" offset");
        }
        if ((this.f & 4) == 0) {
            sb.append(" importance");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
