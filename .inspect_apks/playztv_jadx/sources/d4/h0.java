package d4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3889e;

    public h0(int i, int i10) {
        this(Integer.MIN_VALUE, i, i10);
    }

    public final void a() {
        int i = this.f3888d;
        this.f3888d = i == Integer.MIN_VALUE ? this.f3886b : i + this.f3887c;
        this.f3889e = this.f3885a + this.f3888d;
    }

    public final void b() {
        if (this.f3888d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public h0(int i, int i10, int i11) {
        String str;
        if (i != Integer.MIN_VALUE) {
            str = i + "/";
        } else {
            str = "";
        }
        this.f3885a = str;
        this.f3886b = i10;
        this.f3887c = i11;
        this.f3888d = Integer.MIN_VALUE;
        this.f3889e = "";
    }
}
