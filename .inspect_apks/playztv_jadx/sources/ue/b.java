package ue;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12934a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f12935b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f12936c = new b();

    public static final h a(b bVar, String str) {
        h hVar = new h(str);
        h.f12960d.put(str, hVar);
        return hVar;
    }

    public static String b(String str, int i, int i10, String str2, int i11) {
        int i12 = (i11 & 1) != 0 ? 0 : i;
        int length = (i11 & 2) != 0 ? str.length() : i10;
        boolean z2 = (i11 & 8) == 0;
        boolean z10 = (i11 & 16) == 0;
        boolean z11 = (i11 & 32) == 0;
        boolean z12 = (i11 & 64) == 0;
        be.h.e(str, "<this>");
        int iCharCount = i12;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i13 = 128;
            int i14 = 32;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z12) || ie.e.O(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z2 || (z10 && !d(iCharCount, length, str)))) || (iCodePointAt == 43 && z11)))) {
                hf.f fVar = new hf.f();
                fVar.n0(i12, iCharCount, str);
                hf.f fVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z11) {
                            fVar.o0(z2 ? "+" : "%2B");
                        } else if (iCodePointAt2 < i14 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i13 && !z12) || ie.e.O(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z2 || (z10 && !d(iCharCount, length, str)))))) {
                            if (fVar2 == null) {
                                fVar2 = new hf.f();
                            }
                            fVar2.p0(iCodePointAt2);
                            while (!fVar2.v()) {
                                byte b10 = fVar2.readByte();
                                fVar.j0(37);
                                char[] cArr = o.f13007j;
                                fVar.j0(cArr[((b10 & 255) >> 4) & 15]);
                                fVar.j0(cArr[b10 & 15]);
                            }
                        } else {
                            fVar.p0(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i13 = 128;
                    i14 = 32;
                }
                return fVar.J();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i12, length);
        be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static boolean d(int i, int i10, String str) {
        int i11 = i + 2;
        return i11 < i10 && str.charAt(i) == '%' && ve.b.p(str.charAt(i + 1)) != -1 && ve.b.p(str.charAt(i11)) != -1;
    }

    public static String e(String str, int i, int i10, int i11) {
        int i12;
        if ((i11 & 1) != 0) {
            i = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = str.length();
        }
        boolean z2 = (i11 & 4) == 0;
        be.h.e(str, "<this>");
        int iCharCount = i;
        while (iCharCount < i10) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                hf.f fVar = new hf.f();
                fVar.n0(i, iCharCount, str);
                while (iCharCount < i10) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i12 = iCharCount + 2) < i10) {
                        int iP = ve.b.p(str.charAt(iCharCount + 1));
                        int iP2 = ve.b.p(str.charAt(i12));
                        if (iP == -1 || iP2 == -1) {
                            fVar.p0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            fVar.j0((iP << 4) + iP2);
                            iCharCount = Character.charCount(iCodePointAt) + i12;
                        }
                    } else if (iCodePointAt == 43 && z2) {
                        fVar.j0(32);
                        iCharCount++;
                    } else {
                        fVar.p0(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return fVar.J();
            }
            iCharCount++;
        }
        String strSubstring = str.substring(i, i10);
        be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static ArrayList f(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iS = ie.e.S(str, '&', i, 4);
            if (iS == -1) {
                iS = str.length();
            }
            int iS2 = ie.e.S(str, '=', i, 4);
            if (iS2 == -1 || iS2 > iS) {
                String strSubstring = str.substring(i, iS);
                be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = str.substring(i, iS2);
                be.h.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring2);
                String strSubstring3 = str.substring(iS2 + 1, iS);
                be.h.d(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring3);
            }
            i = iS + 1;
        }
        return arrayList;
    }

    public synchronized h c(String str) {
        h hVar;
        String strConcat;
        try {
            be.h.e(str, "javaName");
            LinkedHashMap linkedHashMap = h.f12960d;
            hVar = (h) linkedHashMap.get(str);
            if (hVar == null) {
                if (ie.n.M(str, "TLS_", false)) {
                    String strSubstring = str.substring(4);
                    be.h.d(strSubstring, "this as java.lang.String).substring(startIndex)");
                    strConcat = "SSL_".concat(strSubstring);
                } else if (ie.n.M(str, "SSL_", false)) {
                    String strSubstring2 = str.substring(4);
                    be.h.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    strConcat = "TLS_".concat(strSubstring2);
                } else {
                    strConcat = str;
                }
                hVar = (h) linkedHashMap.get(strConcat);
                if (hVar == null) {
                    hVar = new h(str);
                }
                linkedHashMap.put(str, hVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return hVar;
    }
}
