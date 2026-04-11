package ie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends n {
    public static boolean N(CharSequence charSequence, String str, boolean z2) {
        be.h.e(charSequence, "<this>");
        return R(2, charSequence, str, z2) >= 0;
    }

    public static boolean O(CharSequence charSequence, char c9) {
        be.h.e(charSequence, "<this>");
        return S(charSequence, c9, 0, 2) >= 0;
    }

    public static final int P(CharSequence charSequence) {
        be.h.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int Q(int i, CharSequence charSequence, String str, boolean z2) {
        be.h.e(charSequence, "<this>");
        be.h.e(str, "string");
        if (!z2 && (charSequence instanceof String)) {
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
        fe.c cVar = new fe.c(i, length, 1);
        boolean z10 = charSequence instanceof String;
        int i10 = cVar.f4819w;
        int i11 = cVar.f4818v;
        int i12 = cVar.f4817u;
        if (z10 && (str instanceof String)) {
            if ((i10 <= 0 || i12 > i11) && (i10 >= 0 || i11 > i12)) {
                return -1;
            }
            int i13 = i12;
            while (true) {
                String str2 = str;
                boolean z11 = z2;
                if (n.J(0, i13, str.length(), str2, (String) charSequence, z11)) {
                    return i13;
                }
                if (i13 == i11) {
                    return -1;
                }
                i13 += i10;
                str = str2;
                z2 = z11;
            }
        } else {
            if ((i10 <= 0 || i12 > i11) && (i10 >= 0 || i11 > i12)) {
                return -1;
            }
            while (true) {
                int length3 = str.length();
                be.h.e(str, "<this>");
                be.h.e(charSequence, "other");
                boolean z12 = false;
                if (i12 >= 0 && str.length() - length3 >= 0 && i12 <= charSequence.length() - length3) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length3) {
                            z12 = true;
                            break;
                        }
                        if (!cf.d.n(str.charAt(0 + i14), charSequence.charAt(i12 + i14), z2)) {
                            break;
                        }
                        i14++;
                    }
                }
                if (z12) {
                    return i12;
                }
                if (i12 == i11) {
                    return -1;
                }
                i12 += i10;
            }
        }
    }

    public static /* synthetic */ int R(int i, CharSequence charSequence, String str, boolean z2) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return Q(0, charSequence, str, z2);
    }

    public static int S(CharSequence charSequence, char c9, int i, int i10) {
        if ((i10 & 2) != 0) {
            i = 0;
        }
        be.h.e(charSequence, "<this>");
        return !(charSequence instanceof String) ? T(charSequence, new char[]{c9}, i, false) : ((String) charSequence).indexOf(c9, i);
    }

    public static final int T(CharSequence charSequence, char[] cArr, int i, boolean z2) {
        be.h.e(charSequence, "<this>");
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
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
        int iP = P(charSequence);
        if (i > iP) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c9 : cArr) {
                if (cf.d.n(c9, cCharAt, z2)) {
                    return i;
                }
            }
            if (i == iP) {
                return -1;
            }
            i++;
        }
    }

    public static boolean U(String str) {
        be.h.e(str, "<this>");
        for (int i = 0; i < str.length(); i++) {
            if (!cf.d.r(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int V(String str, char c9, int i, int i10) {
        if ((i10 & 2) != 0) {
            i = P(str);
        }
        return str.lastIndexOf(c9, i);
    }

    public static int W(String str, String str2) {
        int iP = P(str);
        be.h.e(str, "<this>");
        return str.lastIndexOf(str2, iP);
    }

    public static String X(String str, String str2) {
        if (!n.M(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        be.h.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static List Y(String str, char[] cArr) {
        be.h.e(str, "<this>");
        if (cArr.length == 1) {
            String strValueOf = String.valueOf(cArr[0]);
            int iQ = Q(0, str, strValueOf, false);
            if (iQ == -1) {
                return android.support.v4.media.session.b.G(str.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iQ).toString());
                length = strValueOf.length() + iQ;
                iQ = Q(length, str, strValueOf, false);
            } while (iQ != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            return arrayList;
        }
        he.k kVar = new he.k(new he.d(str, new o(0, cArr)));
        ArrayList arrayList2 = new ArrayList(od.k.U(kVar));
        Iterator it = kVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList2;
            }
            fe.c cVar = (fe.c) bVar.next();
            be.h.e(cVar, "range");
            arrayList2.add(str.subSequence(cVar.f4817u, cVar.f4818v + 1).toString());
        }
    }

    public static String Z(String str, String str2) {
        int iV = V(str, '.', 0, 6);
        if (iV == -1) {
            return str2;
        }
        String strSubstring = str.substring(iV + 1, str.length());
        be.h.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String a0(String str, int i) {
        if (i < 0) {
            throw new IllegalArgumentException(e6.j.j(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(0, i);
        be.h.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence b0(String str) {
        be.h.e(str, "<this>");
        int length = str.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean zR = cf.d.r(str.charAt(!z2 ? i : length));
            if (z2) {
                if (!zR) {
                    break;
                }
                length--;
            } else if (zR) {
                i++;
            } else {
                z2 = true;
            }
        }
        return str.subSequence(i, length + 1);
    }
}
