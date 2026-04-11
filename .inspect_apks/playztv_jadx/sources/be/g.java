package be;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends c implements f, ge.a, nd.a {
    public final int A;
    public final int B;

    public g(int i, Class cls, String str, String str2, int i10) {
        this(i, b.f2031u, cls, str, str2, i10, 0);
    }

    @Override // be.c
    public final ge.a c() {
        o.f2046a.getClass();
        return this;
    }

    @Override // be.f
    public final int d() {
        return this.A;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f2035x.equals(gVar.f2035x) && this.f2036y.equals(gVar.f2036y) && this.B == gVar.B && this.A == gVar.A && h.a(this.f2033v, gVar.f2033v) && e().equals(gVar.e());
        }
        if (!(obj instanceof g)) {
            return false;
        }
        ge.a aVar = this.f2032u;
        if (aVar == null) {
            c();
            this.f2032u = this;
            aVar = this;
        }
        return obj.equals(aVar);
    }

    public final int hashCode() {
        e();
        return this.f2036y.hashCode() + e6.j.h(e().hashCode() * 31, 31, this.f2035x);
    }

    public final String toString() {
        ge.a aVar = this.f2032u;
        if (aVar == null) {
            c();
            this.f2032u = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f2035x;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : e6.j.n("function ", str, " (Kotlin reflection is not available)");
    }

    public g(int i, Object obj, Class cls, String str, String str2, int i10, int i11) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.A = i;
        this.B = 0;
    }
}
