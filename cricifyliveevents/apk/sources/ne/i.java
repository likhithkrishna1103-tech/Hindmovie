package ne;

import java.util.ArrayList;
import java.util.List;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i extends u8.a {
    public static String T(String str) {
        ge.i.e(str, "<this>");
        int i = 1;
        return me.g.H(new me.d(new me.h(i, str), new b6.b(i, "    "), 1), "\n");
    }

    public static String U(String str) {
        List listX;
        ge.i.e(str, "<this>");
        if (h.k0("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        c cVar = new c(str);
        if (cVar.hasNext()) {
            Object next = cVar.next();
            if (cVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (cVar.hasNext()) {
                    arrayList.add(cVar.next());
                }
                listX = arrayList;
            } else {
                listX = n5.a.x(next);
            }
        } else {
            listX = sd.p.f11669v;
        }
        int length = str.length();
        listX.size();
        int iD0 = sd.k.d0(listX);
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (Object obj : listX) {
            int i10 = i + 1;
            String strSubstring = null;
            if (i < 0) {
                sd.k.e0();
                throw null;
            }
            String str2 = (String) obj;
            if ((i != 0 && i != iD0) || !h.k0(str2)) {
                int length2 = str2.length();
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        i11 = -1;
                        break;
                    }
                    if (!t1.k(str2.charAt(i11))) {
                        break;
                    }
                    i11++;
                }
                if (i11 != -1 && o.Y(i11, str2, "|", false)) {
                    strSubstring = str2.substring("|".length() + i11);
                    ge.i.d(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList2.add(strSubstring);
            }
            i = i10;
        }
        StringBuilder sb = new StringBuilder(length);
        sd.j.j0(arrayList2, sb, "\n", "", "", "...", null);
        return sb.toString();
    }
}
