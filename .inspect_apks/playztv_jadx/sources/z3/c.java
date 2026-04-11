package z3;

import android.text.SpannableStringBuilder;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f14824e;
    public final g f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f14825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14826h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f14827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap f14828k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap f14829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f14830m;

    public c(String str, String str2, long j5, long j8, g gVar, String[] strArr, String str3, String str4, c cVar) {
        this.f14820a = str;
        this.f14821b = str2;
        this.i = str4;
        this.f = gVar;
        this.f14825g = strArr;
        this.f14822c = str2 != null;
        this.f14823d = j5;
        this.f14824e = j8;
        str3.getClass();
        this.f14826h = str3;
        this.f14827j = cVar;
        this.f14828k = new HashMap();
        this.f14829l = new HashMap();
    }

    public static c a(String str) {
        return new c(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static SpannableStringBuilder e(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            r1.a aVar = new r1.a();
            aVar.f11229a = new SpannableStringBuilder();
            aVar.f11230b = null;
            treeMap.put(str, aVar);
        }
        CharSequence charSequence = ((r1.a) treeMap.get(str)).f11229a;
        charSequence.getClass();
        return (SpannableStringBuilder) charSequence;
    }

    public final c b(int i) {
        ArrayList arrayList = this.f14830m;
        if (arrayList != null) {
            return (c) arrayList.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int c() {
        ArrayList arrayList = this.f14830m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void d(TreeSet treeSet, boolean z2) {
        String str = this.f14820a;
        boolean zEquals = "p".equals(str);
        boolean zEquals2 = "div".equals(str);
        if (z2 || zEquals || (zEquals2 && this.i != null)) {
            long j5 = this.f14823d;
            if (j5 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j5));
            }
            long j8 = this.f14824e;
            if (j8 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j8));
            }
        }
        if (this.f14830m == null) {
            return;
        }
        for (int i = 0; i < this.f14830m.size(); i++) {
            ((c) this.f14830m.get(i)).d(treeSet, z2 || zEquals);
        }
    }

    public final boolean f(long j5) {
        long j8 = this.f14823d;
        long j10 = this.f14824e;
        if (j8 == -9223372036854775807L && j10 == -9223372036854775807L) {
            return true;
        }
        if (j8 <= j5 && j10 == -9223372036854775807L) {
            return true;
        }
        if (j8 != -9223372036854775807L || j5 >= j10) {
            return j8 <= j5 && j5 < j10;
        }
        return true;
    }

    public final void g(long j5, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.f14826h;
        if (!"".equals(str3)) {
            str = str3;
        }
        if (f(j5) && "div".equals(this.f14820a) && (str2 = this.i) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < c(); i++) {
            b(i).g(j5, str, arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(long r21, java.util.Map r23, java.util.HashMap r24, java.lang.String r25, java.util.TreeMap r26) {
        /*
            Method dump skipped, instruction units count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.c.h(long, java.util.Map, java.util.HashMap, java.lang.String, java.util.TreeMap):void");
    }

    public final void i(long j5, boolean z2, String str, TreeMap treeMap) {
        boolean z10;
        TreeMap treeMap2;
        long j8;
        HashMap map = this.f14828k;
        map.clear();
        HashMap map2 = this.f14829l;
        map2.clear();
        String str2 = this.f14820a;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.f14826h;
        String str4 = "".equals(str3) ? str : str3;
        if (this.f14822c && z2) {
            SpannableStringBuilder spannableStringBuilderE = e(str4, treeMap);
            String str5 = this.f14821b;
            str5.getClass();
            spannableStringBuilderE.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z2) {
            e(str4, treeMap).append('\n');
            return;
        }
        if (f(j5)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequence = ((r1.a) entry.getValue()).f11229a;
                charSequence.getClass();
                map.put(str6, Integer.valueOf(charSequence.length()));
            }
            boolean zEquals = "p".equals(str2);
            for (int i = 0; i < c(); i++) {
                c cVarB = b(i);
                if (z2 || zEquals) {
                    z10 = true;
                    treeMap2 = treeMap;
                    j8 = j5;
                } else {
                    z10 = false;
                    j8 = j5;
                    treeMap2 = treeMap;
                }
                cVarB.i(j8, z10, str4, treeMap2);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderE2 = e(str4, treeMap);
                int length = spannableStringBuilderE2.length() - 1;
                while (length >= 0 && spannableStringBuilderE2.charAt(length) == ' ') {
                    length--;
                }
                if (length >= 0 && spannableStringBuilderE2.charAt(length) != '\n') {
                    spannableStringBuilderE2.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequence2 = ((r1.a) entry2.getValue()).f11229a;
                charSequence2.getClass();
                map2.put(str7, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
