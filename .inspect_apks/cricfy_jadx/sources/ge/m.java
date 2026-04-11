package ge;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends d implements le.c {
    public final boolean B;

    public m(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.B = false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            return d().equals(mVar.d()) && this.f5245y.equals(mVar.f5245y) && this.f5246z.equals(mVar.f5246z) && i.a(this.f5243w, mVar.f5243w);
        }
        if (obj instanceof le.c) {
            return obj.equals(f());
        }
        return false;
    }

    public final le.a f() {
        if (this.B) {
            return this;
        }
        le.a aVar = this.f5242v;
        if (aVar != null) {
            return aVar;
        }
        le.a aVarC = c();
        this.f5242v = aVarC;
        return aVarC;
    }

    public final int hashCode() {
        return this.f5246z.hashCode() + l0.e.e(d().hashCode() * 31, 31, this.f5245y);
    }

    public final String toString() {
        le.a aVarF = f();
        return aVarF != this ? aVarF.toString() : q4.a.q(new StringBuilder("property "), this.f5245y, " (Kotlin reflection is not available)");
    }
}
