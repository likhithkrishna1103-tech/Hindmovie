package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10656e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10658h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f10659j;

    public final n0 a() {
        String str;
        String str2;
        String str3;
        if (this.f10659j == 63 && (str = this.f10653b) != null && (str2 = this.f10658h) != null && (str3 = this.i) != null) {
            return new n0(this.f10652a, str, this.f10654c, this.f10655d, this.f10656e, this.f, this.f10657g, str2, str3);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f10659j & 1) == 0) {
            sb.append(" arch");
        }
        if (this.f10653b == null) {
            sb.append(" model");
        }
        if ((this.f10659j & 2) == 0) {
            sb.append(" cores");
        }
        if ((this.f10659j & 4) == 0) {
            sb.append(" ram");
        }
        if ((this.f10659j & 8) == 0) {
            sb.append(" diskSpace");
        }
        if ((this.f10659j & 16) == 0) {
            sb.append(" simulator");
        }
        if ((this.f10659j & 32) == 0) {
            sb.append(" state");
        }
        if (this.f10658h == null) {
            sb.append(" manufacturer");
        }
        if (this.i == null) {
            sb.append(" modelClass");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
