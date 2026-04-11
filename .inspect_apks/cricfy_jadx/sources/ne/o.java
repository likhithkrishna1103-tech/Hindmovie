package ne;

import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o extends n {
    public static boolean V(String str, String str2) {
        ge.i.e(str, "<this>");
        ge.i.e(str2, "suffix");
        return str.endsWith(str2);
    }

    public static boolean W(int i, int i10, int i11, String str, String str2, boolean z10) {
        ge.i.e(str, "<this>");
        ge.i.e(str2, "other");
        return !z10 ? str.regionMatches(i, str2, i10, i11) : str.regionMatches(z10, i, str2, i10, i11);
    }

    public static String X(String str, String str2, String str3) {
        ge.i.e(str, "<this>");
        int iG0 = h.g0(str, str2, 0, false);
        if (iG0 < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i10 = 0;
        do {
            sb.append((CharSequence) str, i10, iG0);
            sb.append(str3);
            i10 = iG0 + length;
            if (iG0 >= str.length()) {
                break;
            }
            iG0 = h.g0(str, str2, iG0 + i, false);
        } while (iG0 > 0);
        sb.append((CharSequence) str, i10, str.length());
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }

    public static boolean Y(int i, String str, String str2, boolean z10) {
        ge.i.e(str, "<this>");
        return !z10 ? str.startsWith(str2, i) : W(i, 0, str2.length(), str, str2, z10);
    }

    public static boolean Z(String str, String str2, boolean z10) {
        ge.i.e(str, "<this>");
        ge.i.e(str2, "prefix");
        return !z10 ? str.startsWith(str2) : W(0, 0, str2.length(), str, str2, z10);
    }

    public static Integer a0(String str) {
        boolean z10;
        int i;
        int i10;
        ge.i.e(str, "<this>");
        t1.b(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        int i12 = -2147483647;
        if (ge.i.f(cCharAt, 48) < 0) {
            i = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z10 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i12 = Integer.MIN_VALUE;
                z10 = true;
            }
        } else {
            z10 = false;
            i = 0;
        }
        int i13 = -59652323;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i11 < i13 && (i13 != -59652323 || i11 < (i13 = i12 / 10))) || (i10 = i11 * 10) < i12 + iDigit) {
                return null;
            }
            i11 = i10 - iDigit;
            i++;
        }
        return z10 ? Integer.valueOf(i11) : Integer.valueOf(-i11);
    }

    public static Long b0(String str) {
        boolean z10;
        ge.i.e(str, "<this>");
        t1.b(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i = 0;
        char cCharAt = str.charAt(0);
        long j4 = -9223372036854775807L;
        if (ge.i.f(cCharAt, 48) < 0) {
            z10 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z10 = false;
                i = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j4 = Long.MIN_VALUE;
                i = 1;
            }
        } else {
            z10 = false;
        }
        long j7 = 0;
        long j10 = -256204778801521550L;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j7 < j10) {
                if (j10 != -256204778801521550L) {
                    return null;
                }
                j10 = j4 / ((long) 10);
                if (j7 < j10) {
                    return null;
                }
            }
            long j11 = j7 * ((long) 10);
            long j12 = iDigit;
            if (j11 < j4 + j12) {
                return null;
            }
            j7 = j11 - j12;
            i++;
        }
        return z10 ? Long.valueOf(j7) : Long.valueOf(-j7);
    }
}
