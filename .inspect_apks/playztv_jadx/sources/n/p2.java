package n;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8488e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8490h;

    public final void a(int i, int i10) {
        this.f8486c = i;
        this.f8487d = i10;
        this.f8490h = true;
        if (this.f8489g) {
            if (i10 != Integer.MIN_VALUE) {
                this.f8484a = i10;
            }
            if (i != Integer.MIN_VALUE) {
                this.f8485b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f8484a = i;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f8485b = i10;
        }
    }
}
