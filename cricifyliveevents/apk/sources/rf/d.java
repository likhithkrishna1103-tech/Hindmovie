package rf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ag.h f11057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ag.h f11058e;
    public static final ag.h f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ag.h f11059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ag.h f11060h;
    public static final ag.h i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ag.h f11061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ag.h f11062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11063c;

    static {
        ag.h hVar = ag.h.f430y;
        f11057d = ka.f.d(":");
        f11058e = ka.f.d(":status");
        f = ka.f.d(":method");
        f11059g = ka.f.d(":path");
        f11060h = ka.f.d(":scheme");
        i = ka.f.d(":authority");
    }

    public d(ag.h hVar, ag.h hVar2) {
        ge.i.e(hVar, "name");
        ge.i.e(hVar2, "value");
        this.f11061a = hVar;
        this.f11062b = hVar2;
        this.f11063c = hVar2.a() + hVar.a() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return ge.i.a(this.f11061a, dVar.f11061a) && ge.i.a(this.f11062b, dVar.f11062b);
    }

    public final int hashCode() {
        return this.f11062b.hashCode() + (this.f11061a.hashCode() * 31);
    }

    public final String toString() {
        return this.f11061a.j() + ": " + this.f11062b.j();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String str, String str2) {
        this(ka.f.d(str), ka.f.d(str2));
        ag.h hVar = ag.h.f430y;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(ag.h hVar, String str) {
        this(hVar, ka.f.d(str));
        ge.i.e(hVar, "name");
        ge.i.e(str, "value");
        ag.h hVar2 = ag.h.f430y;
    }
}
