package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte f14075e;

    public final z0 a() {
        String str;
        if (this.f14075e == 7 && (str = this.f14071a) != null) {
            return new z0(this.f14072b, this.f14073c, str, this.f14074d);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f14071a == null) {
            sb2.append(" processName");
        }
        if ((this.f14075e & 1) == 0) {
            sb2.append(" pid");
        }
        if ((this.f14075e & 2) == 0) {
            sb2.append(" importance");
        }
        if ((this.f14075e & 4) == 0) {
            sb2.append(" defaultProcess");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
