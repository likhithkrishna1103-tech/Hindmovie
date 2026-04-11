package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f1026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k1 f1027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k1 f1028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k1 f1029d;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f1026a = cls;
        f1027b = v(false);
        f1028c = v(true);
        f1029d = new k1();
    }

    public static void A(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                double dDoubleValue = ((Double) list.get(i10)).doubleValue();
                kVar.getClass();
                kVar.K(i, Double.doubleToRawLongBits(dDoubleValue));
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            Logger logger = k.f1076h;
            i11 += 8;
        }
        kVar.T(i11);
        while (i10 < list.size()) {
            kVar.L(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void B(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.M(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int iW = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iW += k.w(((Integer) list.get(i11)).intValue());
        }
        kVar.T(iW);
        while (i10 < list.size()) {
            kVar.N(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void C(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.I(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = k.f1076h;
            i11 += 4;
        }
        kVar.T(i11);
        while (i10 < list.size()) {
            kVar.J(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void D(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.K(i, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = k.f1076h;
            i11 += 8;
        }
        kVar.T(i11);
        while (i10 < list.size()) {
            kVar.L(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void E(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                float fFloatValue = ((Float) list.get(i10)).floatValue();
                kVar.getClass();
                kVar.I(i, Float.floatToRawIntBits(fFloatValue));
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Float) list.get(i12)).getClass();
            Logger logger = k.f1076h;
            i11 += 4;
        }
        kVar.T(i11);
        while (i10 < list.size()) {
            kVar.J(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
            i10++;
        }
    }

    public static void F(int i, List list, k0 k0Var, b1 b1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            k0Var.b(i, list.get(i10), b1Var);
        }
    }

    public static void G(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.M(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int iW = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iW += k.w(((Integer) list.get(i11)).intValue());
        }
        kVar.T(iW);
        while (i10 < list.size()) {
            kVar.N(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void H(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.U(i, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int iA = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iA += k.A(((Long) list.get(i11)).longValue());
        }
        kVar.T(iA);
        while (i10 < list.size()) {
            kVar.V(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void I(int i, List list, k0 k0Var, b1 b1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            ((k) k0Var.f1082a).O(i, (a) list.get(i10), b1Var);
        }
    }

    public static void J(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.I(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = k.f1076h;
            i11 += 4;
        }
        kVar.T(i11);
        while (i10 < list.size()) {
            kVar.J(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void K(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.K(i, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = k.f1076h;
            i11 += 8;
        }
        kVar.T(i11);
        while (i10 < list.size()) {
            kVar.L(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void L(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                kVar.S(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int iZ = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue2 = ((Integer) list.get(i11)).intValue();
            iZ += k.z((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        kVar.T(iZ);
        while (i10 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i10)).intValue();
            kVar.T((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i10++;
        }
    }

    public static void M(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                kVar.U(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int iA = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            long jLongValue2 = ((Long) list.get(i11)).longValue();
            iA += k.A((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        kVar.T(iA);
        while (i10 < list.size()) {
            long jLongValue3 = ((Long) list.get(i10)).longValue();
            kVar.V((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i10++;
        }
    }

    public static void N(int i, List list, k0 k0Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!(list instanceof e0)) {
            while (i10 < list.size()) {
                kVar.P((String) list.get(i10), i);
                i10++;
            }
            return;
        }
        e0 e0Var = (e0) list;
        while (i10 < list.size()) {
            Object objP = e0Var.p(i10);
            if (objP instanceof String) {
                kVar.P((String) objP, i);
            } else {
                kVar.G(i, (g) objP);
            }
            i10++;
        }
    }

    public static void O(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.S(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int iZ = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iZ += k.z(((Integer) list.get(i11)).intValue());
        }
        kVar.T(iZ);
        while (i10 < list.size()) {
            kVar.T(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void P(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.U(i, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int iA = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iA += k.A(((Long) list.get(i11)).longValue());
        }
        kVar.T(iA);
        while (i10 < list.size()) {
            kVar.V(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static int a(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = k.y(i) * size;
        for (int i10 = 0; i10 < list.size(); i10++) {
            iY += k.s((g) list.get(i10));
        }
        return iY;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.y(i) * size) + c(list);
    }

    public static int c(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iW = 0;
        for (int i = 0; i < size; i++) {
            iW += k.w(((Integer) list.get(i)).intValue());
        }
        return iW;
    }

    public static int d(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return k.t(i) * size;
    }

    public static int e(List list) {
        return list.size() * 4;
    }

    public static int f(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return k.u(i) * size;
    }

    public static int g(List list) {
        return list.size() * 8;
    }

    public static int h(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.y(i) * size) + i(list);
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iW = 0;
        for (int i = 0; i < size; i++) {
            iW += k.w(((Integer) list.get(i)).intValue());
        }
        return iW;
    }

    public static int j(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (k.y(i) * list.size()) + k(list);
    }

    public static int k(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iA = 0;
        for (int i = 0; i < size; i++) {
            iA += k.A(((Long) list.get(i)).longValue());
        }
        return iA;
    }

    public static int l(int i, List list, b1 b1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = k.y(i) * size;
        for (int i10 = 0; i10 < size; i10++) {
            int iB = ((a) list.get(i10)).b(b1Var);
            iY += k.z(iB) + iB;
        }
        return iY;
    }

    public static int m(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.y(i) * size) + n(list);
    }

    public static int n(List list) {
        int size = list.size();
        if (size != 0) {
            if (!(list instanceof x)) {
                int iZ = 0;
                for (int i = 0; i < size; i++) {
                    int iIntValue = ((Integer) list.get(i)).intValue();
                    iZ += k.z((iIntValue >> 31) ^ (iIntValue << 1));
                }
                return iZ;
            }
            if (size > 0) {
                throw null;
            }
        }
        return 0;
    }

    public static int o(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.y(i) * size) + p(list);
    }

    public static int p(List list) {
        int size = list.size();
        if (size != 0) {
            if (!(list instanceof i0)) {
                int iA = 0;
                for (int i = 0; i < size; i++) {
                    long jLongValue = ((Long) list.get(i)).longValue();
                    iA += k.A((jLongValue >> 63) ^ (jLongValue << 1));
                }
                return iA;
            }
            if (size > 0) {
                throw null;
            }
        }
        return 0;
    }

    public static int q(int i, List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        int iY = k.y(i) * size;
        if (!(list instanceof e0)) {
            while (i10 < size) {
                Object obj = list.get(i10);
                if (obj instanceof g) {
                    int size2 = ((g) obj).size();
                    iY = k.z(size2) + size2 + iY;
                } else {
                    iY = k.x((String) obj) + iY;
                }
                i10++;
            }
            return iY;
        }
        e0 e0Var = (e0) list;
        while (i10 < size) {
            Object objP = e0Var.p(i10);
            if (objP instanceof g) {
                int size3 = ((g) objP).size();
                iY = k.z(size3) + size3 + iY;
            } else {
                iY = k.x((String) objP) + iY;
            }
            i10++;
        }
        return iY;
    }

    public static int r(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.y(i) * size) + s(list);
    }

    public static int s(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZ = 0;
        for (int i = 0; i < size; i++) {
            iZ += k.z(((Integer) list.get(i)).intValue());
        }
        return iZ;
    }

    public static int t(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (k.y(i) * size) + u(list);
    }

    public static int u(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iA = 0;
        for (int i = 0; i < size; i++) {
            iA += k.A(((Long) list.get(i)).longValue());
        }
        return iA;
    }

    public static k1 v(boolean z2) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (k1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z2));
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static void w(k1 k1Var, Object obj, Object obj2) {
        k1Var.getClass();
        w wVar = (w) obj;
        j1 j1Var = wVar.unknownFields;
        j1 j1Var2 = ((w) obj2).unknownFields;
        if (!j1Var2.equals(j1.f)) {
            int i = j1Var.f1071a + j1Var2.f1071a;
            int[] iArrCopyOf = Arrays.copyOf(j1Var.f1072b, i);
            System.arraycopy(j1Var2.f1072b, 0, iArrCopyOf, j1Var.f1071a, j1Var2.f1071a);
            Object[] objArrCopyOf = Arrays.copyOf(j1Var.f1073c, i);
            System.arraycopy(j1Var2.f1073c, 0, objArrCopyOf, j1Var.f1071a, j1Var2.f1071a);
            j1Var = new j1(i, iArrCopyOf, objArrCopyOf, true);
        }
        wVar.unknownFields = j1Var;
    }

    public static boolean x(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void y(int i, List list, k0 k0Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k kVar = (k) k0Var.f1082a;
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                kVar.F(i, ((Boolean) list.get(i10)).booleanValue());
                i10++;
            }
            return;
        }
        kVar.R(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Boolean) list.get(i12)).getClass();
            Logger logger = k.f1076h;
            i11++;
        }
        kVar.T(i11);
        while (i10 < list.size()) {
            kVar.D(((Boolean) list.get(i10)).booleanValue() ? (byte) 1 : (byte) 0);
            i10++;
        }
    }

    public static void z(int i, List list, k0 k0Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        k0Var.getClass();
        for (int i10 = 0; i10 < list.size(); i10++) {
            ((k) k0Var.f1082a).G(i, (g) list.get(i10));
        }
    }
}
