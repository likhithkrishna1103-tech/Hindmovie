package ie;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends m {
    public static boolean H(String str, String str2) {
        be.h.e(str, "<this>");
        be.h.e(str2, "suffix");
        return str.endsWith(str2);
    }

    public static boolean I(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final boolean J(int i, int i10, int i11, String str, String str2, boolean z2) {
        be.h.e(str, "<this>");
        be.h.e(str2, "other");
        return !z2 ? str.regionMatches(i, str2, i10, i11) : str.regionMatches(z2, i, str2, i10, i11);
    }

    public static String K(String str, String str2, String str3) {
        be.h.e(str, "<this>");
        int iQ = e.Q(0, str, str2, false);
        if (iQ < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        int i10 = 0;
        do {
            sb2.append((CharSequence) str, i10, iQ);
            sb2.append(str3);
            i10 = iQ + length;
            if (iQ >= str.length()) {
                break;
            }
            iQ = e.Q(iQ + i, str, str2, false);
        } while (iQ > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        be.h.d(string, "toString(...)");
        return string;
    }

    public static boolean L(int i, String str, String str2, boolean z2) {
        be.h.e(str, "<this>");
        return !z2 ? str.startsWith(str2, i) : J(i, 0, str2.length(), str, str2, z2);
    }

    public static boolean M(String str, String str2, boolean z2) {
        be.h.e(str, "<this>");
        be.h.e(str2, "prefix");
        return !z2 ? str.startsWith(str2) : J(0, 0, str2.length(), str, str2, z2);
    }
}
