package p1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f9767h = new h(1, 2, 3, null, -1, -1);
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9770l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9771m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9772n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f9776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9777e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9778g;

    static {
        int i10 = s1.b0.f11647a;
        i = Integer.toString(0, 36);
        f9768j = Integer.toString(1, 36);
        f9769k = Integer.toString(2, 36);
        f9770l = Integer.toString(3, 36);
        f9771m = Integer.toString(4, 36);
        f9772n = Integer.toString(5, 36);
    }

    public h(int i10, int i11, int i12, byte[] bArr, int i13, int i14) {
        this.f9773a = i10;
        this.f9774b = i11;
        this.f9775c = i12;
        this.f9776d = bArr;
        this.f9777e = i13;
        this.f = i14;
    }

    public static String a(int i10) {
        return i10 != -1 ? i10 != 1 ? i10 != 2 ? e6.j.l("Undefined color range ", i10) : "Limited range" : "Full range" : "Unset color range";
    }

    public static String b(int i10) {
        return i10 != -1 ? i10 != 6 ? i10 != 1 ? i10 != 2 ? e6.j.l("Undefined color space ", i10) : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    public static String c(int i10) {
        return i10 != -1 ? i10 != 10 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 6 ? i10 != 7 ? e6.j.l("Undefined color transfer ", i10) : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public static boolean e(h hVar) {
        if (hVar == null) {
            return true;
        }
        int i10 = hVar.f9773a;
        if (i10 != -1 && i10 != 1 && i10 != 2) {
            return false;
        }
        int i11 = hVar.f9774b;
        if (i11 != -1 && i11 != 2) {
            return false;
        }
        int i12 = hVar.f9775c;
        if ((i12 != -1 && i12 != 3) || hVar.f9776d != null) {
            return false;
        }
        int i13 = hVar.f;
        if (i13 != -1 && i13 != 8) {
            return false;
        }
        int i14 = hVar.f9777e;
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
        return (this.f9773a == -1 || this.f9774b == -1 || this.f9775c == -1) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            if (this.f9773a == hVar.f9773a && this.f9774b == hVar.f9774b && this.f9775c == hVar.f9775c && Arrays.equals(this.f9776d, hVar.f9776d) && this.f9777e == hVar.f9777e && this.f == hVar.f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9778g == 0) {
            this.f9778g = ((((Arrays.hashCode(this.f9776d) + ((((((527 + this.f9773a) * 31) + this.f9774b) * 31) + this.f9775c) * 31)) * 31) + this.f9777e) * 31) + this.f;
        }
        return this.f9778g;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("ColorInfo(");
        sb2.append(b(this.f9773a));
        sb2.append(", ");
        sb2.append(a(this.f9774b));
        sb2.append(", ");
        sb2.append(c(this.f9775c));
        sb2.append(", ");
        sb2.append(this.f9776d != null);
        sb2.append(", ");
        String str2 = "NA";
        int i10 = this.f9777e;
        if (i10 != -1) {
            str = i10 + "bit Luma";
        } else {
            str = "NA";
        }
        sb2.append(str);
        sb2.append(", ");
        int i11 = this.f;
        if (i11 != -1) {
            str2 = i11 + "bit Chroma";
        }
        return l4.a.o(sb2, str2, ")");
    }
}
