package v1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f12678h = new g(1, 2, 3, null, -1, -1);
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12682m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12683n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f12687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12688e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12689g;

    static {
        int i10 = y1.a0.f14551a;
        i = Integer.toString(0, 36);
        f12679j = Integer.toString(1, 36);
        f12680k = Integer.toString(2, 36);
        f12681l = Integer.toString(3, 36);
        f12682m = Integer.toString(4, 36);
        f12683n = Integer.toString(5, 36);
    }

    public g(int i10, int i11, int i12, byte[] bArr, int i13, int i14) {
        this.f12684a = i10;
        this.f12685b = i11;
        this.f12686c = i12;
        this.f12687d = bArr;
        this.f12688e = i13;
        this.f = i14;
    }

    public static String a(int i10) {
        return i10 != -1 ? i10 != 1 ? i10 != 2 ? l0.e.g(i10, "Undefined color range ") : "Limited range" : "Full range" : "Unset color range";
    }

    public static String b(int i10) {
        return i10 != -1 ? i10 != 6 ? i10 != 1 ? i10 != 2 ? l0.e.g(i10, "Undefined color space ") : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    public static String c(int i10) {
        return i10 != -1 ? i10 != 10 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 6 ? i10 != 7 ? l0.e.g(i10, "Undefined color transfer ") : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public static boolean e(g gVar) {
        if (gVar == null) {
            return true;
        }
        int i10 = gVar.f12684a;
        if (i10 != -1 && i10 != 1 && i10 != 2) {
            return false;
        }
        int i11 = gVar.f12685b;
        if (i11 != -1 && i11 != 2) {
            return false;
        }
        int i12 = gVar.f12686c;
        if ((i12 != -1 && i12 != 3) || gVar.f12687d != null) {
            return false;
        }
        int i13 = gVar.f;
        if (i13 != -1 && i13 != 8) {
            return false;
        }
        int i14 = gVar.f12688e;
        return i14 == -1 || i14 == 8;
    }

    public static int f(int i10) {
        if (i10 == 1) {
            return 1;
        }
        if (i10 != 9) {
            return (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int g(int i10) {
        if (i10 == 1) {
            return 3;
        }
        if (i10 == 4) {
            return 10;
        }
        if (i10 == 13) {
            return 2;
        }
        if (i10 == 16) {
            return 6;
        }
        if (i10 != 18) {
            return (i10 == 6 || i10 == 7) ? 3 : -1;
        }
        return 7;
    }

    public final boolean d() {
        return (this.f12684a == -1 || this.f12685b == -1 || this.f12686c == -1) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f12684a == gVar.f12684a && this.f12685b == gVar.f12685b && this.f12686c == gVar.f12686c && Arrays.equals(this.f12687d, gVar.f12687d) && this.f12688e == gVar.f12688e && this.f == gVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f12689g == 0) {
            this.f12689g = ((((Arrays.hashCode(this.f12687d) + ((((((527 + this.f12684a) * 31) + this.f12685b) * 31) + this.f12686c) * 31)) * 31) + this.f12688e) * 31) + this.f;
        }
        return this.f12689g;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(b(this.f12684a));
        sb.append(", ");
        sb.append(a(this.f12685b));
        sb.append(", ");
        sb.append(c(this.f12686c));
        sb.append(", ");
        sb.append(this.f12687d != null);
        sb.append(", ");
        String str2 = "NA";
        int i10 = this.f12688e;
        if (i10 != -1) {
            str = i10 + "bit Luma";
        } else {
            str = "NA";
        }
        sb.append(str);
        sb.append(", ");
        int i11 = this.f;
        if (i11 != -1) {
            str2 = i11 + "bit Chroma";
        }
        return q4.a.q(sb, str2, ")");
    }
}
