package kf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Iterable, he.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final p f7513w = new p(new String[0]);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String[] f7514v;

    public p(String[] strArr) {
        ge.i.e(strArr, "namesAndValues");
        this.f7514v = strArr;
    }

    public final String a(String str) {
        String[] strArr = this.f7514v;
        ge.i.e(strArr, "namesAndValues");
        int length = strArr.length - 2;
        int iR = com.bumptech.glide.c.r(length, 0, -2);
        if (iR > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == iR) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final String b(int i) {
        String str = (String) sd.i.u(i * 2, this.f7514v);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i + ']');
    }

    public final o c() {
        o oVar = new o(0);
        ArrayList arrayList = oVar.f7512a;
        ge.i.e(arrayList, "<this>");
        String[] strArr = this.f7514v;
        ge.i.e(strArr, "elements");
        arrayList.addAll(sd.i.a(strArr));
        return oVar;
    }

    public final TreeMap d() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        ge.i.d(comparator, "CASE_INSENSITIVE_ORDER");
        TreeMap treeMap = new TreeMap(comparator);
        int size = size();
        for (int i = 0; i < size; i++) {
            String strB = b(i);
            Locale locale = Locale.US;
            ge.i.d(locale, "US");
            String lowerCase = strB.toLowerCase(locale);
            ge.i.d(lowerCase, "toLowerCase(...)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(f(i));
        }
        return treeMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return Arrays.equals(this.f7514v, ((p) obj).f7514v);
        }
        return false;
    }

    public final String f(int i) {
        String str = (String) sd.i.u((i * 2) + 1, this.f7514v);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i + ']');
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f7514v);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        rd.f[] fVarArr = new rd.f[size];
        for (int i = 0; i < size; i++) {
            fVarArr[i] = new rd.f(b(i), f(i));
        }
        return new ge.b(fVarArr);
    }

    public final int size() {
        return this.f7514v.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strB = b(i);
            String strF = f(i);
            sb.append(strB);
            sb.append(": ");
            if (lf.d.j(strB)) {
                strF = "██";
            }
            sb.append(strF);
            sb.append("\n");
        }
        return sb.toString();
    }
}
