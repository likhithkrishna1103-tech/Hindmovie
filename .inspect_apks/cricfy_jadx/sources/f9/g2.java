package f9;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g2 f4188c = new g2(100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f4189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4190b;

    public g2(int i) {
        EnumMap enumMap = new EnumMap(f2.class);
        this.f4189a = enumMap;
        f2 f2Var = f2.f4170w;
        d2 d2Var = d2.f4070w;
        enumMap.put(f2Var, d2Var);
        enumMap.put(f2.f4171x, d2Var);
        this.f4190b = i;
    }

    public static String a(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static g2 b(int i, Bundle bundle) {
        if (bundle == null) {
            return new g2(i);
        }
        EnumMap enumMap = new EnumMap(f2.class);
        for (f2 f2Var : e2.STORAGE.f4101v) {
            enumMap.put(f2Var, d(bundle.getString(f2Var.f4174v)));
        }
        return new g2(enumMap, i);
    }

    public static g2 c(int i, String str) {
        EnumMap enumMap = new EnumMap(f2.class);
        f2[] f2VarArr = e2.STORAGE.f4101v;
        for (int i10 = 0; i10 < f2VarArr.length; i10++) {
            String str2 = str == null ? "" : str;
            f2 f2Var = f2VarArr[i10];
            int i11 = i10 + 2;
            if (i11 < str2.length()) {
                enumMap.put(f2Var, e(str2.charAt(i11)));
            } else {
                enumMap.put(f2Var, d2.f4070w);
            }
        }
        return new g2(enumMap, i);
    }

    public static d2 d(String str) {
        d2 d2Var = d2.f4070w;
        return str == null ? d2Var : str.equals("granted") ? d2.f4073z : str.equals("denied") ? d2.f4072y : d2Var;
    }

    public static d2 e(char c9) {
        return c9 != '+' ? c9 != '0' ? c9 != '1' ? d2.f4070w : d2.f4073z : d2.f4072y : d2.f4071x;
    }

    public static char h(d2 d2Var) {
        if (d2Var == null) {
            return '-';
        }
        int iOrdinal = d2Var.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static boolean l(int i, int i10) {
        int i11 = -30;
        if (i == -20) {
            if (i10 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i11 = i;
        } else if (i10 == -20) {
            return true;
        }
        return i11 == i10 || i < i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g2)) {
            return false;
        }
        g2 g2Var = (g2) obj;
        for (f2 f2Var : e2.STORAGE.f4101v) {
            if (this.f4189a.get(f2Var) != g2Var.f4189a.get(f2Var)) {
                return false;
            }
        }
        return this.f4190b == g2Var.f4190b;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            f9.e2 r1 = f9.e2.STORAGE
            f9.f2[] r1 = r1.f4101v
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L38
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f4189a
            java.lang.Object r4 = r5.get(r4)
            f9.d2 r4 = (f9.d2) r4
            r5 = 45
            if (r4 == 0) goto L32
            int r4 = r4.ordinal()
            if (r4 == 0) goto L32
            r6 = 1
            if (r4 == r6) goto L30
            r6 = 2
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L30
            goto L32
        L2d:
            r5 = 48
            goto L32
        L30:
            r5 = 49
        L32:
            r0.append(r5)
            int r3 = r3 + 1
            goto Ld
        L38:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.g2.f():java.lang.String");
    }

    public final String g() {
        StringBuilder sb = new StringBuilder("G1");
        for (f2 f2Var : e2.STORAGE.f4101v) {
            sb.append(h((d2) this.f4189a.get(f2Var)));
        }
        return sb.toString();
    }

    public final int hashCode() {
        Iterator it = this.f4189a.values().iterator();
        int iHashCode = this.f4190b * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((d2) it.next()).hashCode();
        }
        return iHashCode;
    }

    public final boolean i(f2 f2Var) {
        return ((d2) this.f4189a.get(f2Var)) != d2.f4072y;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.g2 j(f9.g2 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<f9.f2> r1 = f9.f2.class
            r0.<init>(r1)
            f9.e2 r1 = f9.e2.STORAGE
            f9.f2[] r1 = r1.f4101v
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L48
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f4189a
            java.lang.Object r5 = r5.get(r4)
            f9.d2 r5 = (f9.d2) r5
            java.util.EnumMap r6 = r9.f4189a
            java.lang.Object r6 = r6.get(r4)
            f9.d2 r6 = (f9.d2) r6
            if (r5 != 0) goto L24
            goto L31
        L24:
            if (r6 == 0) goto L40
            f9.d2 r7 = f9.d2.f4070w
            if (r5 != r7) goto L2b
            goto L31
        L2b:
            if (r6 == r7) goto L40
            f9.d2 r7 = f9.d2.f4071x
            if (r5 != r7) goto L33
        L31:
            r5 = r6
            goto L40
        L33:
            if (r6 == r7) goto L40
            f9.d2 r7 = f9.d2.f4072y
            if (r5 == r7) goto L3f
            if (r6 != r7) goto L3c
            goto L3f
        L3c:
            f9.d2 r5 = f9.d2.f4073z
            goto L40
        L3f:
            r5 = r7
        L40:
            if (r5 == 0) goto L45
            r0.put(r4, r5)
        L45:
            int r3 = r3 + 1
            goto Ld
        L48:
            f9.g2 r9 = new f9.g2
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.g2.j(f9.g2):f9.g2");
    }

    public final g2 k(g2 g2Var) {
        EnumMap enumMap = new EnumMap(f2.class);
        for (f2 f2Var : e2.STORAGE.f4101v) {
            d2 d2Var = (d2) this.f4189a.get(f2Var);
            if (d2Var == d2.f4070w) {
                d2Var = (d2) g2Var.f4189a.get(f2Var);
            }
            if (d2Var != null) {
                enumMap.put(f2Var, d2Var);
            }
        }
        return new g2(enumMap, this.f4190b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(a(this.f4190b));
        for (f2 f2Var : e2.STORAGE.f4101v) {
            sb.append(",");
            sb.append(f2Var.f4174v);
            sb.append("=");
            d2 d2Var = (d2) this.f4189a.get(f2Var);
            if (d2Var == null) {
                d2Var = d2.f4070w;
            }
            sb.append(d2Var);
        }
        return sb.toString();
    }

    public g2(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(f2.class);
        this.f4189a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f4190b = i;
    }
}
