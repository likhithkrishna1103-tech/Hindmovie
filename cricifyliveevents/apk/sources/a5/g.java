package a5;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f282e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f283g;

    public g(int i, int i10, String str, String str2, String str3, boolean z10) {
        ge.i.e(str, "name");
        ge.i.e(str2, "type");
        this.f278a = str;
        this.f279b = str2;
        this.f280c = z10;
        this.f281d = i;
        this.f282e = str3;
        this.f = i10;
        String upperCase = str2.toUpperCase(Locale.ROOT);
        ge.i.d(upperCase, "toUpperCase(...)");
        this.f283g = ne.h.c0(upperCase, "INT", false) ? 3 : (ne.h.c0(upperCase, "CHAR", false) || ne.h.c0(upperCase, "CLOB", false) || ne.h.c0(upperCase, "TEXT", false)) ? 2 : ne.h.c0(upperCase, "BLOB", false) ? 5 : (ne.h.c0(upperCase, "REAL", false) || ne.h.c0(upperCase, "FLOA", false) || ne.h.c0(upperCase, "DOUB", false)) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                boolean z10 = this.f281d > 0;
                g gVar = (g) obj;
                int i = gVar.f;
                if (z10 == (gVar.f281d > 0) && ge.i.a(this.f278a, gVar.f278a) && this.f280c == gVar.f280c) {
                    String str = gVar.f282e;
                    int i10 = this.f;
                    String str2 = this.f282e;
                    if ((i10 != 1 || i != 2 || str2 == null || com.bumptech.glide.f.j(str2, str)) && ((i10 != 2 || i != 1 || str == null || com.bumptech.glide.f.j(str, str2)) && ((i10 == 0 || i10 != i || (str2 == null ? str == null : com.bumptech.glide.f.j(str2, str))) && this.f283g == gVar.f283g))) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.f278a.hashCode() * 31) + this.f283g) * 31) + (this.f280c ? 1231 : 1237)) * 31) + this.f281d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n            |Column {\n            |   name = '");
        sb.append(this.f278a);
        sb.append("',\n            |   type = '");
        sb.append(this.f279b);
        sb.append("',\n            |   affinity = '");
        sb.append(this.f283g);
        sb.append("',\n            |   notNull = '");
        sb.append(this.f280c);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(this.f281d);
        sb.append("',\n            |   defaultValue = '");
        String str = this.f282e;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return ne.i.T(ne.i.U(sb.toString()));
    }
}
