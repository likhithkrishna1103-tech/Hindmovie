package bf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final hf.i f2048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final hf.i f2049e;
    public static final hf.i f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final hf.i f2050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final hf.i f2051h;
    public static final hf.i i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hf.i f2052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hf.i f2053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2054c;

    static {
        hf.i iVar = hf.i.f6114x;
        f2048d = lb.e.h(":");
        f2049e = lb.e.h(":status");
        f = lb.e.h(":method");
        f2050g = lb.e.h(":path");
        f2051h = lb.e.h(":scheme");
        i = lb.e.h(":authority");
    }

    public b(hf.i iVar, hf.i iVar2) {
        be.h.e(iVar, "name");
        be.h.e(iVar2, "value");
        this.f2052a = iVar;
        this.f2053b = iVar2;
        this.f2054c = iVar2.a() + iVar.a() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return be.h.a(this.f2052a, bVar.f2052a) && be.h.a(this.f2053b, bVar.f2053b);
    }

    public final int hashCode() {
        return this.f2053b.hashCode() + (this.f2052a.hashCode() * 31);
    }

    public final String toString() {
        return this.f2052a.h() + ": " + this.f2053b.h();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(lb.e.h(str), lb.e.h(str2));
        be.h.e(str, "name");
        be.h.e(str2, "value");
        hf.i iVar = hf.i.f6114x;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(hf.i iVar, String str) {
        this(iVar, lb.e.h(str));
        be.h.e(iVar, "name");
        be.h.e(str, "value");
        hf.i iVar2 = hf.i.f6114x;
    }
}
