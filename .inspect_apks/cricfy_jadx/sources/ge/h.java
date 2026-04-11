package ge;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends d implements g, le.a, rd.a {
    public final int B;
    public final int C;

    public h(int i, Class cls, String str, String str2, int i10) {
        this(i, c.f5241v, cls, str, str2, i10, 0);
    }

    @Override // ge.d
    public final le.a c() {
        q.f5255a.getClass();
        return this;
    }

    @Override // ge.g
    public final int e() {
        return this.B;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.f5245y.equals(hVar.f5245y) && this.f5246z.equals(hVar.f5246z) && this.C == hVar.C && this.B == hVar.B && i.a(this.f5243w, hVar.f5243w) && d().equals(hVar.d());
        }
        if (!(obj instanceof h)) {
            return false;
        }
        le.a aVar = this.f5242v;
        if (aVar == null) {
            c();
            this.f5242v = this;
            aVar = this;
        }
        return obj.equals(aVar);
    }

    public final int hashCode() {
        d();
        return this.f5246z.hashCode() + l0.e.e(d().hashCode() * 31, 31, this.f5245y);
    }

    public final String toString() {
        le.a aVar = this.f5242v;
        if (aVar == null) {
            c();
            this.f5242v = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f5245y;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : l0.e.k("function ", str, " (Kotlin reflection is not available)");
    }

    public h(int i, Object obj, Class cls, String str, String str2, int i10, int i11) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.B = i;
        this.C = 0;
    }
}
