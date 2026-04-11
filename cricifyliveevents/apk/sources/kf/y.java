package kf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c2.o f7581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f7582b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f7585e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ag.v f7587h;
    public z i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z f7588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z f7589k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f7590l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f7591m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bumptech.glide.l f7592n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7583c = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b0 f7586g = b0.f7439v;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e0 f7593o = e0.f7460a;
    public o f = new o(0);

    public static void b(String str, z zVar) {
        if (zVar != null) {
            if (zVar.D != null) {
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            if (zVar.E != null) {
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            if (zVar.F != null) {
                throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
            }
        }
    }

    public final z a() {
        int i = this.f7583c;
        if (i < 0) {
            throw new IllegalStateException(("code < 0: " + this.f7583c).toString());
        }
        c2.o oVar = this.f7581a;
        if (oVar == null) {
            throw new IllegalStateException("request == null");
        }
        v vVar = this.f7582b;
        if (vVar == null) {
            throw new IllegalStateException("protocol == null");
        }
        String str = this.f7584d;
        if (str != null) {
            return new z(oVar, vVar, str, i, this.f7585e, this.f.b(), this.f7586g, this.f7587h, this.i, this.f7588j, this.f7589k, this.f7590l, this.f7591m, this.f7592n, this.f7593o);
        }
        throw new IllegalStateException("message == null");
    }
}
