package lf;

import ag.g;
import ag.h;
import ag.m;
import ge.i;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f7960a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f7961b;

    static {
        h hVar = h.f430y;
        f7961b = w1.d.o(ka.f.c("efbbbf"), ka.f.c("feff"), ka.f.c("fffe0000"), ka.f.c("fffe"), ka.f.c("0000feff"));
    }

    public static final void a(long j4, long j7, long j10) {
        if ((j7 | j10) < 0 || j7 > j4 || j4 - j7 < j10) {
            throw new ArrayIndexOutOfBoundsException("length=" + j4 + ", offset=" + j7 + ", count=" + j7);
        }
    }

    public static final void b(Closeable closeable) {
        i.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e9) {
            throw e9;
        } catch (Exception unused) {
        }
    }

    public static final int c(int i, int i10, String str, String str2) {
        i.e(str, "<this>");
        while (i < i10) {
            if (ne.h.d0(str2, str.charAt(i))) {
                return i;
            }
            i++;
        }
        return i10;
    }

    public static final int d(String str, char c9, int i, int i10) {
        i.e(str, "<this>");
        while (i < i10) {
            if (str.charAt(i) == c9) {
                return i;
            }
            i++;
        }
        return i10;
    }

    public static final boolean e(String[] strArr, String[] strArr2, Comparator comparator) {
        i.e(strArr, "<this>");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final int f(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (i.f(cCharAt, 31) <= 0 || i.f(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int g(int i, int i10, String str) {
        while (i < i10) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i10;
    }

    public static final int h(int i, int i10, String str) {
        int i11 = i10 - 1;
        if (i <= i11) {
            while (true) {
                char cCharAt = str.charAt(i11);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i11 + 1;
                }
                if (i11 == i) {
                    break;
                }
                i11--;
            }
        }
        return i;
    }

    public static final String[] i(String[] strArr, String[] strArr2, Comparator comparator) {
        i.e(strArr, "<this>");
        i.e(strArr2, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean j(String str) {
        i.e(str, "name");
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final int k(char c9) {
        if ('0' <= c9 && c9 < ':') {
            return c9 - '0';
        }
        if ('a' <= c9 && c9 < 'g') {
            return c9 - 'W';
        }
        if ('A' > c9 || c9 >= 'G') {
            return -1;
        }
        return c9 - '7';
    }

    public static final int l(g gVar) {
        i.e(gVar, "<this>");
        return (gVar.readByte() & 255) | ((gVar.readByte() & 255) << 16) | ((gVar.readByte() & 255) << 8);
    }

    public static final int m(int i, String str) {
        if (str == null) {
            return i;
        }
        try {
            long j4 = Long.parseLong(str);
            if (j4 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j4 < 0) {
                return 0;
            }
            return (int) j4;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static final String n(int i, int i10, String str) {
        int iG = g(i, i10, str);
        String strSubstring = str.substring(iG, h(iG, i10, str));
        i.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
