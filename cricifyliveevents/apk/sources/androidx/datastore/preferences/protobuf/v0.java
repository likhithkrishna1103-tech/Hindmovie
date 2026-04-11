package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c1 f801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c1 f802c;

    static {
        Class<?> cls;
        Class<?> cls2;
        r0 r0Var = r0.f786c;
        c1 c1Var = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f800a = cls;
        try {
            r0 r0Var2 = r0.f786c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                c1Var = (c1) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        f801b = c1Var;
        f802c = new c1();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int I = 0;
        for (int i = 0; i < size; i++) {
            I += l.I(((Integer) list.get(i)).intValue());
        }
        return I;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.G(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (l.G(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int I = 0;
        for (int i = 0; i < size; i++) {
            I += l.I(((Integer) list.get(i)).intValue());
        }
        return I;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int I = 0;
        for (int i = 0; i < size; i++) {
            I += l.I(((Long) list.get(i)).longValue());
        }
        return I;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iH = 0;
        for (int i = 0; i < size; i++) {
            int iIntValue = ((Integer) list.get(i)).intValue();
            iH += l.H((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iH;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int I = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            I += l.I((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return I;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iH = 0;
        for (int i = 0; i < size; i++) {
            iH += l.H(((Integer) list.get(i)).intValue());
        }
        return iH;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int I = 0;
        for (int i = 0; i < size; i++) {
            I += l.I(((Long) list.get(i)).longValue());
        }
        return I;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void k(c1 c1Var, Object obj, Object obj2) {
        c1Var.getClass();
        v vVar = (v) obj;
        b1 b1Var = vVar.unknownFields;
        b1 b1Var2 = ((v) obj2).unknownFields;
        b1 b1Var3 = b1.f;
        if (!b1Var3.equals(b1Var2)) {
            if (b1Var3.equals(b1Var)) {
                int i = b1Var.f681a + b1Var2.f681a;
                int[] iArrCopyOf = Arrays.copyOf(b1Var.f682b, i);
                System.arraycopy(b1Var2.f682b, 0, iArrCopyOf, b1Var.f681a, b1Var2.f681a);
                Object[] objArrCopyOf = Arrays.copyOf(b1Var.f683c, i);
                System.arraycopy(b1Var2.f683c, 0, objArrCopyOf, b1Var.f681a, b1Var2.f681a);
                b1Var = new b1(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                b1Var.getClass();
                if (!b1Var2.equals(b1Var3)) {
                    if (!b1Var.f685e) {
                        throw new UnsupportedOperationException();
                    }
                    int i10 = b1Var.f681a + b1Var2.f681a;
                    b1Var.a(i10);
                    System.arraycopy(b1Var2.f682b, 0, b1Var.f682b, b1Var.f681a, b1Var2.f681a);
                    System.arraycopy(b1Var2.f683c, 0, b1Var.f683c, b1Var.f681a, b1Var2.f681a);
                    b1Var.f681a = i10;
                }
            }
        }
        vVar.unknownFields = b1Var;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void m(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.N(i, ((Boolean) list.get(i10)).booleanValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Boolean) list.get(i12)).getClass();
            Logger logger = l.f738n;
            i11++;
        }
        lVar.b0(i11);
        while (i10 < list.size()) {
            lVar.L(((Boolean) list.get(i10)).booleanValue() ? (byte) 1 : (byte) 0);
            i10++;
        }
    }

    public static void n(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                double dDoubleValue = ((Double) list.get(i10)).doubleValue();
                lVar.getClass();
                lVar.S(i, Double.doubleToRawLongBits(dDoubleValue));
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            Logger logger = l.f738n;
            i11 += 8;
        }
        lVar.b0(i11);
        while (i10 < list.size()) {
            lVar.T(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void o(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.U(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int I = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            I += l.I(((Integer) list.get(i11)).intValue());
        }
        lVar.b0(I);
        while (i10 < list.size()) {
            lVar.V(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void p(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.Q(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = l.f738n;
            i11 += 4;
        }
        lVar.b0(i11);
        while (i10 < list.size()) {
            lVar.R(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void q(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.S(i, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = l.f738n;
            i11 += 8;
        }
        lVar.b0(i11);
        while (i10 < list.size()) {
            lVar.T(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void r(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                float fFloatValue = ((Float) list.get(i10)).floatValue();
                lVar.getClass();
                lVar.Q(i, Float.floatToRawIntBits(fFloatValue));
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Float) list.get(i12)).getClass();
            Logger logger = l.f738n;
            i11 += 4;
        }
        lVar.b0(i11);
        while (i10 < list.size()) {
            lVar.R(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
            i10++;
        }
    }

    public static void s(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.U(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int I = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            I += l.I(((Integer) list.get(i11)).intValue());
        }
        lVar.b0(I);
        while (i10 < list.size()) {
            lVar.V(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void t(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.c0(i, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int I = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            I += l.I(((Long) list.get(i11)).longValue());
        }
        lVar.b0(I);
        while (i10 < list.size()) {
            lVar.d0(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void u(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.Q(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Integer) list.get(i12)).getClass();
            Logger logger = l.f738n;
            i11 += 4;
        }
        lVar.b0(i11);
        while (i10 < list.size()) {
            lVar.R(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void v(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.S(i, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Long) list.get(i12)).getClass();
            Logger logger = l.f738n;
            i11 += 8;
        }
        lVar.b0(i11);
        while (i10 < list.size()) {
            lVar.T(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static void w(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                lVar.a0(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int iH = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iIntValue2 = ((Integer) list.get(i11)).intValue();
            iH += l.H((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        lVar.b0(iH);
        while (i10 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i10)).intValue();
            lVar.b0((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i10++;
        }
    }

    public static void x(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                lVar.c0(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int I = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            long jLongValue2 = ((Long) list.get(i11)).longValue();
            I += l.I((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        lVar.b0(I);
        while (i10 < list.size()) {
            long jLongValue3 = ((Long) list.get(i10)).longValue();
            lVar.d0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i10++;
        }
    }

    public static void y(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.a0(i, ((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int iH = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            iH += l.H(((Integer) list.get(i11)).intValue());
        }
        lVar.b0(iH);
        while (i10 < list.size()) {
            lVar.b0(((Integer) list.get(i10)).intValue());
            i10++;
        }
    }

    public static void z(int i, List list, e0 e0Var, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        l lVar = (l) e0Var.f697a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                lVar.c0(i, ((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        lVar.Z(i, 2);
        int I = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            I += l.I(((Long) list.get(i11)).longValue());
        }
        lVar.b0(I);
        while (i10 < list.size()) {
            lVar.d0(((Long) list.get(i10)).longValue());
            i10++;
        }
    }

    public static Object j(Object obj, int i, w wVar, Object obj2, c1 c1Var) {
        return obj2;
    }
}
