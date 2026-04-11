package w4;

import be.h;
import cf.l;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13723e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13724g;

    public d(int i, int i10, String str, String str2, String str3, boolean z2) {
        h.e(str, "name");
        h.e(str2, "type");
        this.f13719a = str;
        this.f13720b = str2;
        this.f13721c = z2;
        this.f13722d = i;
        this.f13723e = str3;
        this.f = i10;
        String upperCase = str2.toUpperCase(Locale.ROOT);
        h.d(upperCase, "toUpperCase(...)");
        this.f13724g = ie.e.N(upperCase, "INT", false) ? 3 : (ie.e.N(upperCase, "CHAR", false) || ie.e.N(upperCase, "CLOB", false) || ie.e.N(upperCase, "TEXT", false)) ? 2 : ie.e.N(upperCase, "BLOB", false) ? 5 : (ie.e.N(upperCase, "REAL", false) || ie.e.N(upperCase, "FLOA", false) || ie.e.N(upperCase, "DOUB", false)) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                boolean z2 = this.f13722d > 0;
                d dVar = (d) obj;
                int i = dVar.f;
                if (z2 == (dVar.f13722d > 0) && h.a(this.f13719a, dVar.f13719a) && this.f13721c == dVar.f13721c) {
                    String str = dVar.f13723e;
                    int i10 = this.f;
                    String str2 = this.f13723e;
                    if ((i10 != 1 || i != 2 || str2 == null || l.n(str2, str)) && ((i10 != 2 || i != 1 || str == null || l.n(str, str2)) && ((i10 == 0 || i10 != i || (str2 == null ? str == null : l.n(str2, str))) && this.f13724g == dVar.f13724g))) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.f13719a.hashCode() * 31) + this.f13724g) * 31) + (this.f13721c ? 1231 : 1237)) * 31) + this.f13722d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n            |Column {\n            |   name = '");
        sb2.append(this.f13719a);
        sb2.append("',\n            |   type = '");
        sb2.append(this.f13720b);
        sb2.append("',\n            |   affinity = '");
        sb2.append(this.f13724g);
        sb2.append("',\n            |   notNull = '");
        sb2.append(this.f13721c);
        sb2.append("',\n            |   primaryKeyPosition = '");
        sb2.append(this.f13722d);
        sb2.append("',\n            |   defaultValue = '");
        String str = this.f13723e;
        if (str == null) {
            str = "undefined";
        }
        sb2.append(str);
        sb2.append("'\n            |}\n        ");
        return ie.g.D(ie.g.E(sb2.toString()));
    }
}
