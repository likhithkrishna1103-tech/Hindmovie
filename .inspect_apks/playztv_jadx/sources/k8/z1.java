package k8;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z1 f7569c = new z1(100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap f7570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7571b;

    public z1(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(y1.class);
        this.f7570a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f7571b = i;
    }

    public static char a(b2 b2Var) {
        if (b2Var == null) {
            return '-';
        }
        int iOrdinal = b2Var.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static String b(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static z1 c(int i, Bundle bundle) {
        if (bundle == null) {
            return new z1(i);
        }
        EnumMap enumMap = new EnumMap(y1.class);
        for (y1 y1Var : a2.STORAGE.f7074u) {
            enumMap.put(y1Var, g(bundle.getString(y1Var.f7559u)));
        }
        return new z1(enumMap, i);
    }

    public static z1 d(String str, int i) {
        EnumMap enumMap = new EnumMap(y1.class);
        if (str == null) {
            str = "";
        }
        y1[] y1VarArr = a2.STORAGE.f7074u;
        for (int i10 = 0; i10 < y1VarArr.length; i10++) {
            y1 y1Var = y1VarArr[i10];
            int i11 = i10 + 2;
            if (i11 < str.length()) {
                enumMap.put(y1Var, f(str.charAt(i11)));
            } else {
                enumMap.put(y1Var, b2.f7089v);
            }
        }
        return new z1(enumMap, i);
    }

    public static b2 f(char c9) {
        return c9 != '+' ? c9 != '0' ? c9 != '1' ? b2.f7089v : b2.f7092y : b2.f7091x : b2.f7090w;
    }

    public static b2 g(String str) {
        b2 b2Var = b2.f7089v;
        return str == null ? b2Var : str.equals("granted") ? b2.f7092y : str.equals("denied") ? b2.f7091x : b2Var;
    }

    public static boolean h(int i, int i10) {
        if (i == -20 && i10 == -30) {
            return true;
        }
        return (i == -30 && i10 == -20) || i == i10 || i < i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.z1 e(k8.z1 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<k8.y1> r1 = k8.y1.class
            r0.<init>(r1)
            k8.a2 r1 = k8.a2.STORAGE
            k8.y1[] r1 = r1.f7074u
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L4b
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f7570a
            java.lang.Object r5 = r5.get(r4)
            k8.b2 r5 = (k8.b2) r5
            java.util.EnumMap r6 = r9.f7570a
            java.lang.Object r6 = r6.get(r4)
            k8.b2 r6 = (k8.b2) r6
            if (r5 != 0) goto L24
            goto L33
        L24:
            if (r6 != 0) goto L27
            goto L43
        L27:
            k8.b2 r7 = k8.b2.f7089v
            if (r5 != r7) goto L2c
            goto L33
        L2c:
            if (r6 != r7) goto L2f
            goto L43
        L2f:
            k8.b2 r7 = k8.b2.f7090w
            if (r5 != r7) goto L35
        L33:
            r5 = r6
            goto L43
        L35:
            if (r6 != r7) goto L38
            goto L43
        L38:
            k8.b2 r7 = k8.b2.f7091x
            if (r5 == r7) goto L42
            if (r6 != r7) goto L3f
            goto L42
        L3f:
            k8.b2 r5 = k8.b2.f7092y
            goto L43
        L42:
            r5 = r7
        L43:
            if (r5 == 0) goto L48
            r0.put(r4, r5)
        L48:
            int r3 = r3 + 1
            goto Ld
        L4b:
            k8.z1 r9 = new k8.z1
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.z1.e(k8.z1):k8.z1");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        for (y1 y1Var : a2.STORAGE.f7074u) {
            if (this.f7570a.get(y1Var) != z1Var.f7570a.get(y1Var)) {
                return false;
            }
        }
        return this.f7571b == z1Var.f7571b;
    }

    public final int hashCode() {
        int iHashCode = this.f7571b * 17;
        Iterator it = this.f7570a.values().iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((b2) it.next()).hashCode();
        }
        return iHashCode;
    }

    public final boolean i(y1 y1Var) {
        return ((b2) this.f7570a.get(y1Var)) != b2.f7091x;
    }

    public final z1 j(z1 z1Var) {
        EnumMap enumMap = new EnumMap(y1.class);
        for (y1 y1Var : a2.STORAGE.f7074u) {
            b2 b2Var = (b2) this.f7570a.get(y1Var);
            if (b2Var == b2.f7089v) {
                b2Var = (b2) z1Var.f7570a.get(y1Var);
            }
            if (b2Var != null) {
                enumMap.put(y1Var, b2Var);
            }
        }
        return new z1(enumMap, this.f7571b);
    }

    public final boolean k(z1 z1Var, y1... y1VarArr) {
        for (y1 y1Var : y1VarArr) {
            b2 b2Var = (b2) this.f7570a.get(y1Var);
            b2 b2Var2 = (b2) z1Var.f7570a.get(y1Var);
            b2 b2Var3 = b2.f7091x;
            if (b2Var == b2Var3 && b2Var2 != b2Var3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String l() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            k8.a2 r1 = k8.a2.STORAGE
            k8.y1[] r1 = r1.f7074u
            int r2 = r1.length
            r3 = 0
        Ld:
            if (r3 >= r2) goto L38
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f7570a
            java.lang.Object r4 = r5.get(r4)
            k8.b2 r4 = (k8.b2) r4
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
        throw new UnsupportedOperationException("Method not decompiled: k8.z1.l():java.lang.String");
    }

    public final String m() {
        StringBuilder sb2 = new StringBuilder("G1");
        for (y1 y1Var : a2.STORAGE.f7074u) {
            sb2.append(a((b2) this.f7570a.get(y1Var)));
        }
        return sb2.toString();
    }

    public final boolean n() {
        return i(y1.f7555w);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(b(this.f7571b));
        for (y1 y1Var : a2.STORAGE.f7074u) {
            sb2.append(",");
            sb2.append(y1Var.f7559u);
            sb2.append("=");
            b2 b2Var = (b2) this.f7570a.get(y1Var);
            if (b2Var == null) {
                b2Var = b2.f7089v;
            }
            sb2.append(b2Var);
        }
        return sb2.toString();
    }

    public z1(int i) {
        EnumMap enumMap = new EnumMap(y1.class);
        this.f7570a = enumMap;
        y1 y1Var = y1.f7554v;
        b2 b2Var = b2.f7089v;
        enumMap.put(y1Var, b2Var);
        enumMap.put(y1.f7555w, b2Var);
        this.f7571b = i;
    }
}
