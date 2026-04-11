package qb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Double f10478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10482e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f10483g;

    public final b1 a() {
        if (this.f10483g == 31) {
            return new b1(this.f10478a, this.f10479b, this.f10480c, this.f10481d, this.f10482e, this.f);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f10483g & 1) == 0) {
            sb.append(" batteryVelocity");
        }
        if ((this.f10483g & 2) == 0) {
            sb.append(" proximityOn");
        }
        if ((this.f10483g & 4) == 0) {
            sb.append(" orientation");
        }
        if ((this.f10483g & 8) == 0) {
            sb.append(" ramUsed");
        }
        if ((this.f10483g & 16) == 0) {
            sb.append(" diskUsed");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
