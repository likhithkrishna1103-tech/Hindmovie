package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f14054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14058e;
    public byte f;

    public final x0 a() {
        String str;
        if (this.f == 7 && (str = this.f14055b) != null) {
            return new x0(this.f14054a, str, this.f14056c, this.f14057d, this.f14058e);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((this.f & 1) == 0) {
            sb2.append(" pc");
        }
        if (this.f14055b == null) {
            sb2.append(" symbol");
        }
        if ((this.f & 2) == 0) {
            sb2.append(" offset");
        }
        if ((this.f & 4) == 0) {
            sb2.append(" importance");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }
}
