package d4;

import android.text.SpannableStringBuilder;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3346e;
    public final h f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f3347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3348h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f3349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap f3350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap f3351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f3352m;

    public c(String str, String str2, long j4, long j7, h hVar, String[] strArr, String str3, String str4, c cVar) {
        this.f3342a = str;
        this.f3343b = str2;
        this.i = str4;
        this.f = hVar;
        this.f3347g = strArr;
        this.f3344c = str2 != null;
        this.f3345d = j4;
        this.f3346e = j7;
        str3.getClass();
        this.f3348h = str3;
        this.f3349j = cVar;
        this.f3350k = new HashMap();
        this.f3351l = new HashMap();
    }

    public static c a(String str) {
        return new c(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static SpannableStringBuilder e(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            x1.a aVar = new x1.a();
            aVar.f14225a = new SpannableStringBuilder();
            aVar.f14226b = null;
            treeMap.put(str, aVar);
        }
        CharSequence charSequence = ((x1.a) treeMap.get(str)).f14225a;
        charSequence.getClass();
        return (SpannableStringBuilder) charSequence;
    }

    public final c b(int i) {
        ArrayList arrayList = this.f3352m;
        if (arrayList != null) {
            return (c) arrayList.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int c() {
        ArrayList arrayList = this.f3352m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void d(TreeSet treeSet, boolean z10) {
        String str = this.f3342a;
        boolean zEquals = "p".equals(str);
        boolean zEquals2 = "div".equals(str);
        if (z10 || zEquals || (zEquals2 && this.i != null)) {
            long j4 = this.f3345d;
            if (j4 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j4));
            }
            long j7 = this.f3346e;
            if (j7 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j7));
            }
        }
        if (this.f3352m == null) {
            return;
        }
        for (int i = 0; i < this.f3352m.size(); i++) {
            ((c) this.f3352m.get(i)).d(treeSet, z10 || zEquals);
        }
    }

    public final boolean f(long j4) {
        long j7 = this.f3345d;
        long j10 = this.f3346e;
        if (j7 == -9223372036854775807L && j10 == -9223372036854775807L) {
            return true;
        }
        if (j7 <= j4 && j10 == -9223372036854775807L) {
            return true;
        }
        if (j7 != -9223372036854775807L || j4 >= j10) {
            return j7 <= j4 && j4 < j10;
        }
        return true;
    }

    public final void g(long j4, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.f3348h;
        if (!"".equals(str3)) {
            str = str3;
        }
        if (f(j4) && "div".equals(this.f3342a) && (str2 = this.i) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < c(); i++) {
            b(i).g(j4, str, arrayList);
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
        throw new UnsupportedOperationException("Method not decompiled: d4.c.h(long, java.util.Map, java.util.HashMap, java.lang.String, java.util.TreeMap):void");
    }

    public final void i(long j4, boolean z10, String str, TreeMap treeMap) {
        boolean z11;
        TreeMap treeMap2;
        long j7;
        HashMap map = this.f3350k;
        map.clear();
        HashMap map2 = this.f3351l;
        map2.clear();
        String str2 = this.f3342a;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.f3348h;
        String str4 = "".equals(str3) ? str : str3;
        if (this.f3344c && z10) {
            SpannableStringBuilder spannableStringBuilderE = e(str4, treeMap);
            String str5 = this.f3343b;
            str5.getClass();
            spannableStringBuilderE.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z10) {
            e(str4, treeMap).append('\n');
            return;
        }
        if (f(j4)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequence = ((x1.a) entry.getValue()).f14225a;
                charSequence.getClass();
                map.put(str6, Integer.valueOf(charSequence.length()));
            }
            boolean zEquals = "p".equals(str2);
            for (int i = 0; i < c(); i++) {
                c cVarB = b(i);
                if (z10 || zEquals) {
                    z11 = true;
                    treeMap2 = treeMap;
                    j7 = j4;
                } else {
                    z11 = false;
                    j7 = j4;
                    treeMap2 = treeMap;
                }
                cVarB.i(j7, z11, str4, treeMap2);
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
                CharSequence charSequence2 = ((x1.a) entry2.getValue()).f14225a;
                charSequence2.getClass();
                map2.put(str7, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
