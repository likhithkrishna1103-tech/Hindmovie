package kf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f7440n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f7445e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7447h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f7448j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f7449k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f7450l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f7451m;

    static {
        int i = oe.a.f9767y;
        oe.c cVar = oe.c.SECONDS;
        long jE = oe.a.e(com.bumptech.glide.d.D(Integer.MAX_VALUE, cVar), cVar);
        if (jE >= 0) {
            return;
        }
        throw new IllegalArgumentException(("maxStale < 0: " + jE).toString());
    }

    public c(boolean z10, boolean z11, int i, int i10, boolean z12, boolean z13, boolean z14, int i11, int i12, boolean z15, boolean z16, boolean z17, String str) {
        this.f7441a = z10;
        this.f7442b = z11;
        this.f7443c = i;
        this.f7444d = i10;
        this.f7445e = z12;
        this.f = z13;
        this.f7446g = z14;
        this.f7447h = i11;
        this.i = i12;
        this.f7448j = z15;
        this.f7449k = z16;
        this.f7450l = z17;
        this.f7451m = str;
    }

    public final String toString() {
        String str = this.f7451m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f7441a) {
            sb.append("no-cache, ");
        }
        if (this.f7442b) {
            sb.append("no-store, ");
        }
        int i = this.f7443c;
        if (i != -1) {
            sb.append("max-age=");
            sb.append(i);
            sb.append(", ");
        }
        int i10 = this.f7444d;
        if (i10 != -1) {
            sb.append("s-maxage=");
            sb.append(i10);
            sb.append(", ");
        }
        if (this.f7445e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.f7446g) {
            sb.append("must-revalidate, ");
        }
        int i11 = this.f7447h;
        if (i11 != -1) {
            sb.append("max-stale=");
            sb.append(i11);
            sb.append(", ");
        }
        int i12 = this.i;
        if (i12 != -1) {
            sb.append("min-fresh=");
            sb.append(i12);
            sb.append(", ");
        }
        if (this.f7448j) {
            sb.append("only-if-cached, ");
        }
        if (this.f7449k) {
            sb.append("no-transform, ");
        }
        if (this.f7450l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        ge.i.d(sb.delete(sb.length() - 2, sb.length()), "delete(...)");
        String string = sb.toString();
        this.f7451m = string;
        return string;
    }
}
