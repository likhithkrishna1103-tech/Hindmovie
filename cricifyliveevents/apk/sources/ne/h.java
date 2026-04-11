package ne;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import qb.t1;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends o {
    public static boolean c0(CharSequence charSequence, String str, boolean z10) {
        ge.i.e(charSequence, "<this>");
        return i0(charSequence, str, 0, z10, 2) >= 0;
    }

    public static boolean d0(CharSequence charSequence, char c9) {
        ge.i.e(charSequence, "<this>");
        return h0(charSequence, c9, 0, 2) >= 0;
    }

    public static String e0(String str) {
        ge.i.e(str, "<this>");
        int length = str.length() - 1;
        if (length < 0) {
            length = 0;
        }
        return s0(length, str);
    }

    public static final int f0(CharSequence charSequence) {
        ge.i.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int g0(CharSequence charSequence, String str, int i, boolean z10) {
        ge.i.e(charSequence, "<this>");
        ge.i.e(str, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        ke.c cVar = new ke.c(i, length, 1);
        boolean z11 = charSequence instanceof String;
        int i10 = cVar.f7420x;
        int i11 = cVar.f7419w;
        int i12 = cVar.f7418v;
        if (z11 && (str instanceof String)) {
            if ((i10 <= 0 || i12 > i11) && (i10 >= 0 || i11 > i12)) {
                return -1;
            }
            int i13 = i12;
            while (true) {
                String str2 = str;
                boolean z12 = z10;
                if (o.W(0, i13, str.length(), str2, (String) charSequence, z12)) {
                    return i13;
                }
                if (i13 == i11) {
                    return -1;
                }
                i13 += i10;
                str = str2;
                z10 = z12;
            }
        } else {
            if ((i10 <= 0 || i12 > i11) && (i10 >= 0 || i11 > i12)) {
                return -1;
            }
            while (true) {
                int length3 = str.length();
                ge.i.e(str, "<this>");
                ge.i.e(charSequence, "other");
                boolean z13 = false;
                if (i12 >= 0 && str.length() - length3 >= 0 && i12 <= charSequence.length() - length3) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length3) {
                            z13 = true;
                            break;
                        }
                        if (!t1.f(str.charAt(0 + i14), charSequence.charAt(i12 + i14), z10)) {
                            break;
                        }
                        i14++;
                    }
                }
                if (z13) {
                    return i12;
                }
                if (i12 == i11) {
                    return -1;
                }
                i12 += i10;
            }
        }
    }

    public static int h0(CharSequence charSequence, char c9, int i, int i10) {
        if ((i10 & 2) != 0) {
            i = 0;
        }
        ge.i.e(charSequence, "<this>");
        return !(charSequence instanceof String) ? j0(charSequence, new char[]{c9}, i, false) : ((String) charSequence).indexOf(c9, i);
    }

    public static /* synthetic */ int i0(CharSequence charSequence, String str, int i, boolean z10, int i10) {
        if ((i10 & 2) != 0) {
            i = 0;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return g0(charSequence, str, i, z10);
    }

    public static final int j0(CharSequence charSequence, char[] cArr, int i, boolean z10) {
        ge.i.e(charSequence, "<this>");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        if (i < 0) {
            i = 0;
        }
        int iF0 = f0(charSequence);
        if (i > iF0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c9 : cArr) {
                if (t1.f(c9, cCharAt, z10)) {
                    return i;
                }
            }
            if (i == iF0) {
                return -1;
            }
            i++;
        }
    }

    public static boolean k0(String str) {
        ge.i.e(str, "<this>");
        for (int i = 0; i < str.length(); i++) {
            if (!t1.k(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int l0(String str, char c9, int i, int i10) {
        if ((i10 & 2) != 0) {
            i = f0(str);
        }
        ge.i.e(str, "<this>");
        return str.lastIndexOf(c9, i);
    }

    public static int m0(String str, String str2) {
        int iF0 = f0(str);
        ge.i.e(str, "<this>");
        return str.lastIndexOf(str2, iF0);
    }

    public static String n0(int i, String str) {
        CharSequence charSequenceSubSequence;
        ge.i.e(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(l0.e.h(i, "Desired length ", " is less than zero."));
        }
        if (i <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - str.length();
            int i10 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i10 == length) {
                        break;
                    }
                    i10++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static String o0(String str, String str2) {
        if (!o.Z(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static List p0(String str, char[] cArr) {
        ge.i.e(str, "<this>");
        if (cArr.length == 1) {
            String strValueOf = String.valueOf(cArr[0]);
            int iG0 = g0(str, strValueOf, 0, false);
            if (iG0 == -1) {
                return n5.a.x(str.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iG0).toString());
                length = strValueOf.length() + iG0;
                iG0 = g0(str, strValueOf, length, false);
            } while (iG0 != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            return arrayList;
        }
        me.i iVar = new me.i(new me.d(str, new p(0, cArr)));
        ArrayList arrayList2 = new ArrayList(sd.l.f0(iVar, 10));
        Iterator it = iVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList2;
            }
            ke.c cVar = (ke.c) bVar.next();
            ge.i.e(cVar, "range");
            arrayList2.add(str.subSequence(cVar.f7418v, cVar.f7419w + 1).toString());
        }
    }

    public static String q0(String str, String str2, String str3) {
        ge.i.e(str2, "delimiter");
        int iI0 = i0(str, str2, 0, false, 6);
        if (iI0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iI0, str.length());
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String r0(char c9, String str, String str2) {
        ge.i.e(str, "<this>");
        ge.i.e(str2, "missingDelimiterValue");
        int iL0 = l0(str, c9, 0, 6);
        if (iL0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iL0 + 1, str.length());
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String s0(int i, String str) {
        ge.i.e(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(l0.e.h(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(0, i);
        ge.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence t0(String str) {
        ge.i.e(str, "<this>");
        int length = str.length() - 1;
        int i = 0;
        boolean z10 = false;
        while (i <= length) {
            boolean zK = t1.k(str.charAt(!z10 ? i : length));
            if (z10) {
                if (!zK) {
                    break;
                }
                length--;
            } else if (zK) {
                i++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i, length + 1);
    }
}
