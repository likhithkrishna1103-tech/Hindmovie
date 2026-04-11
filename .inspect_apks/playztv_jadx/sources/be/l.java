package be;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends c implements ge.c {
    public final boolean A;

    public l(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.A = false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return e().equals(lVar.e()) && this.f2035x.equals(lVar.f2035x) && this.f2036y.equals(lVar.f2036y) && h.a(this.f2033v, lVar.f2033v);
        }
        if (obj instanceof ge.c) {
            return obj.equals(f());
        }
        return false;
    }

    public final ge.a f() {
        if (this.A) {
            return this;
        }
        ge.a aVar = this.f2032u;
        if (aVar != null) {
            return aVar;
        }
        ge.a aVarC = c();
        this.f2032u = aVarC;
        return aVarC;
    }

    public final int hashCode() {
        return this.f2036y.hashCode() + e6.j.h(e().hashCode() * 31, 31, this.f2035x);
    }

    public final String toString() {
        ge.a aVarF = f();
        return aVarF != this ? aVarF.toString() : l4.a.o(new StringBuilder("property "), this.f2035x, " (Kotlin reflection is not available)");
    }
}
