package ue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Iterable, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String[] f12999u;

    public m(String[] strArr) {
        this.f12999u = strArr;
    }

    public final String b(String str) {
        be.h.e(str, "name");
        String[] strArr = this.f12999u;
        int length = strArr.length - 2;
        int iO = cf.d.o(length, 0, -2);
        if (iO > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == iO) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final String d(int i) {
        return this.f12999u[i * 2];
    }

    public final q2.d e() {
        q2.d dVar = new q2.d(2);
        ArrayList arrayList = dVar.f10591a;
        be.h.e(arrayList, "<this>");
        String[] strArr = this.f12999u;
        be.h.e(strArr, "elements");
        arrayList.addAll(od.h.Q(strArr));
        return dVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return Arrays.equals(this.f12999u, ((m) obj).f12999u);
        }
        return false;
    }

    public final TreeMap f() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        be.h.d(comparator, "CASE_INSENSITIVE_ORDER");
        TreeMap treeMap = new TreeMap(comparator);
        int size = size();
        for (int i = 0; i < size; i++) {
            String strD = d(i);
            Locale locale = Locale.US;
            be.h.d(locale, "US");
            String lowerCase = strD.toLowerCase(locale);
            be.h.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(h(i));
        }
        return treeMap;
    }

    public final String h(int i) {
        return this.f12999u[(i * 2) + 1];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12999u);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        nd.f[] fVarArr = new nd.f[size];
        for (int i = 0; i < size; i++) {
            fVarArr[i] = new nd.f(d(i), h(i));
        }
        return new be.a(fVarArr);
    }

    public final int size() {
        return this.f12999u.length / 2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strD = d(i);
            String strH = h(i);
            sb2.append(strD);
            sb2.append(": ");
            if (ve.b.o(strD)) {
                strH = "██";
            }
            sb2.append(strH);
            sb2.append("\n");
        }
        String string = sb2.toString();
        be.h.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
