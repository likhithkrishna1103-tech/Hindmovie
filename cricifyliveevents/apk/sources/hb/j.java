package hb;

import com.google.android.gms.internal.measurement.z3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f5895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5897c;

    public j(int i, int i10, Class cls) {
        this(r.a(cls), i, i10);
    }

    public static j a(r rVar) {
        return new j(rVar, 1, 0);
    }

    public static j b(Class cls) {
        return new j(1, 0, cls);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f5895a.equals(jVar.f5895a) && this.f5896b == jVar.f5896b && this.f5897c == jVar.f5897c;
    }

    public final int hashCode() {
        return ((((this.f5895a.hashCode() ^ 1000003) * 1000003) ^ this.f5896b) * 1000003) ^ this.f5897c;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f5895a);
        sb.append(", type=");
        int i = this.f5896b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        int i10 = this.f5897c;
        if (i10 == 0) {
            str = "direct";
        } else if (i10 == 1) {
            str = "provider";
        } else {
            if (i10 != 2) {
                throw new AssertionError(l0.e.g(i10, "Unsupported injection: "));
            }
            str = "deferred";
        }
        return q4.a.q(sb, str, "}");
    }

    public j(r rVar, int i, int i10) {
        z3.h(rVar, "Null dependency anInterface.");
        this.f5895a = rVar;
        this.f5896b = i;
        this.f5897c = i10;
    }
}
