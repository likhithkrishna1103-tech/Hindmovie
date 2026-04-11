package ue;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b2.g f13055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f13056b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f13059e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z f13060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public x f13061h;
    public x i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public x f13062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f13063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f13064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public w1.m f13065m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13057c = -1;
    public q2.d f = new q2.d(2);

    public static void b(String str, x xVar) {
        if (xVar != null) {
            if (xVar.A != null) {
                throw new IllegalArgumentException(str.concat(".body != null").toString());
            }
            if (xVar.B != null) {
                throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
            }
            if (xVar.C != null) {
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            if (xVar.D != null) {
                throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
            }
        }
    }

    public final x a() {
        int i = this.f13057c;
        if (i < 0) {
            throw new IllegalStateException(("code < 0: " + this.f13057c).toString());
        }
        b2.g gVar = this.f13055a;
        if (gVar == null) {
            throw new IllegalStateException("request == null");
        }
        t tVar = this.f13056b;
        if (tVar == null) {
            throw new IllegalStateException("protocol == null");
        }
        String str = this.f13058d;
        if (str != null) {
            return new x(gVar, tVar, str, i, this.f13059e, this.f.g(), this.f13060g, this.f13061h, this.i, this.f13062j, this.f13063k, this.f13064l, this.f13065m);
        }
        throw new IllegalStateException("message == null");
    }
}
