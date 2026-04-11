package zf;

import ag.e;
import ge.i;
import lf.d;
import ne.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f15343a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str, int i, int i10, String str2, int i11) {
        int i12 = (i11 & 1) != 0 ? 0 : i;
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        int i13 = i10;
        boolean z10 = (i11 & 8) == 0;
        boolean z11 = (i11 & 16) == 0;
        boolean z12 = (i11 & 32) == 0;
        boolean z13 = (i11 & 64) == 0;
        i.e(str, "<this>");
        return b(str, i12, i13, str2, z10, z11, z12, z13, 128);
    }

    public static String b(String str, int i, int i10, String str2, boolean z10, boolean z11, boolean z12, boolean z13, int i11) {
        int i12 = (i11 & 1) != 0 ? 0 : i;
        int length = (i11 & 2) != 0 ? str.length() : i10;
        boolean z14 = (i11 & 8) != 0 ? false : z10;
        boolean z15 = (i11 & 16) != 0 ? false : z11;
        boolean z16 = (i11 & 64) == 0 ? z13 : false;
        i.e(str, "<this>");
        int iCharCount = i12;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i13 = 128;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z16) || h.d0(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z14 || (z15 && !c(iCharCount, length, str)))) || (iCodePointAt == 43 && z12)))) {
                e eVar = new e();
                eVar.n0(i12, iCharCount, str);
                e eVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z14 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 32 && str2 == " !\"#$&'()+,/:;<=>?@[\\]^`{|}~") {
                            eVar.o0("+");
                        } else if (iCodePointAt2 == 43 && z12) {
                            eVar.o0(z14 ? "+" : "%2B");
                        } else if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i13 && !z16) || h.d0(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z14 || (z15 && !c(iCharCount, length, str)))))) {
                            if (eVar2 == null) {
                                eVar2 = new e();
                            }
                            eVar2.p0(iCodePointAt2);
                            while (!eVar2.q()) {
                                byte b8 = eVar2.readByte();
                                eVar.i0(37);
                                char[] cArr = f15343a;
                                eVar.i0(cArr[((b8 & 255) >> 4) & 15]);
                                eVar.i0(cArr[b8 & 15]);
                            }
                        } else {
                            eVar.p0(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i13 = 128;
                }
                return eVar.O();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i12, length);
        i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean c(int i, int i10, String str) {
        i.e(str, "<this>");
        int i11 = i + 2;
        return i11 < i10 && str.charAt(i) == '%' && d.k(str.charAt(i + 1)) != -1 && d.k(str.charAt(i11)) != -1;
    }

    public static String d(String str, int i, int i10, int i11) {
        int i12;
        if ((i11 & 1) != 0) {
            i = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        boolean z10 = (i11 & 4) == 0;
        i.e(str, "<this>");
        int iCharCount = i;
        while (iCharCount < i10) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                e eVar = new e();
                eVar.n0(i, iCharCount, str);
                while (iCharCount < i10) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i12 = iCharCount + 2) < i10) {
                        int iK = d.k(str.charAt(iCharCount + 1));
                        int iK2 = d.k(str.charAt(i12));
                        if (iK == -1 || iK2 == -1) {
                            eVar.p0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            eVar.i0((iK << 4) + iK2);
                            iCharCount = Character.charCount(iCodePointAt) + i12;
                        }
                    } else if (iCodePointAt == 43 && z10) {
                        eVar.i0(32);
                        iCharCount++;
                    } else {
                        eVar.p0(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return eVar.O();
            }
            iCharCount++;
        }
        String strSubstring = str.substring(i, i10);
        i.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
