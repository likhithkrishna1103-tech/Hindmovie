package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f10778e;

    public final z0 a() {
        String str;
        if (this.f10778e == 7 && (str = this.f10774a) != null) {
            return new z0(str, this.f10775b, this.f10776c, this.f10777d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10774a == null) {
            sb.append(" processName");
        }
        if ((this.f10778e & 1) == 0) {
            sb.append(" pid");
        }
        if ((this.f10778e & 2) == 0) {
            sb.append(" importance");
        }
        if ((this.f10778e & 4) == 0) {
            sb.append(" defaultProcess");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
