package h4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5646e;

    public g0(int i, int i10) {
        this(Integer.MIN_VALUE, i, i10);
    }

    public final void a() {
        int i = this.f5645d;
        this.f5645d = i == Integer.MIN_VALUE ? this.f5643b : i + this.f5644c;
        this.f5646e = this.f5642a + this.f5645d;
    }

    public final void b() {
        if (this.f5645d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public g0(int i, int i10, int i11) {
        String str;
        if (i != Integer.MIN_VALUE) {
            str = i + "/";
        } else {
            str = "";
        }
        this.f5642a = str;
        this.f5643b = i10;
        this.f5644c = i11;
        this.f5645d = Integer.MIN_VALUE;
        this.f5646e = "";
    }
}
