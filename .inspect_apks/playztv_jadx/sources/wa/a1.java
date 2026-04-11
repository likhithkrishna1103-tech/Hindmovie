package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Double f13775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13779e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f13780g;

    public final b1 a() {
        if (this.f13780g == 31) {
            return new b1(this.f13775a, this.f13776b, this.f13777c, this.f13778d, this.f13779e, this.f);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f13780g & 1) == 0) {
            sb2.append(" batteryVelocity");
        }
        if ((this.f13780g & 2) == 0) {
            sb2.append(" proximityOn");
        }
        if ((this.f13780g & 4) == 0) {
            sb2.append(" orientation");
        }
        if ((this.f13780g & 8) == 0) {
            sb2.append(" ramUsed");
        }
        if ((this.f13780g & 16) == 0) {
            sb2.append(" diskUsed");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
