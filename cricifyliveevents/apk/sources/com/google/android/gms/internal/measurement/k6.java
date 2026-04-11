package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g5 f2510a;

    static {
        g6 g6Var = g6.f2460c;
        f2510a = new g5(6);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
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
    public static void b(Object obj, Object obj2) {
        i5 i5Var = (i5) obj;
        n6 n6Var = i5Var.zzc;
        n6 n6Var2 = ((i5) obj2).zzc;
        n6 n6Var3 = n6.f;
        if (!n6Var3.equals(n6Var2)) {
            if (n6Var3.equals(n6Var)) {
                int i = n6Var.f2550a + n6Var2.f2550a;
                int[] iArrCopyOf = Arrays.copyOf(n6Var.f2551b, i);
                System.arraycopy(n6Var2.f2551b, 0, iArrCopyOf, n6Var.f2550a, n6Var2.f2550a);
                Object[] objArrCopyOf = Arrays.copyOf(n6Var.f2552c, i);
                System.arraycopy(n6Var2.f2552c, 0, objArrCopyOf, n6Var.f2550a, n6Var2.f2550a);
                n6Var = new n6(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                n6Var.getClass();
                if (!n6Var2.equals(n6Var3)) {
                    if (!n6Var.f2554e) {
                        throw new UnsupportedOperationException();
                    }
                    int i10 = n6Var.f2550a + n6Var2.f2550a;
                    n6Var.e(i10);
                    System.arraycopy(n6Var2.f2551b, 0, n6Var.f2551b, n6Var.f2550a, n6Var2.f2550a);
                    System.arraycopy(n6Var2.f2552c, 0, n6Var.f2552c, n6Var.f2550a, n6Var2.f2550a);
                    n6Var.f2550a = i10;
                }
            }
        }
        i5Var.zzc = n6Var;
    }

    public static void c(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                b5Var.l0(i, Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            i11 += 8;
        }
        b5Var.p0(i11);
        while (i10 < list.size()) {
            b5Var.s0(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void d(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                b5Var.j0(i, Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Float) list.get(i12)).getClass();
            i11 += 4;
        }
        b5Var.p0(i11);
        while (i10 < list.size()) {
            b5Var.q0(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
            i10++;
        }
    }

    public static void e(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof v5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.k0(i, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int iE0 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iE0 += b5.e0(((Long) list.get(i11)).longValue());
            }
            b5Var.p0(iE0);
            while (i10 < list.size()) {
                b5Var.r0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        v5 v5Var = (v5) list;
        if (!z10) {
            while (i10 < v5Var.f2665x) {
                b5Var.k0(i, v5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int iE02 = 0;
        for (int i12 = 0; i12 < v5Var.f2665x; i12++) {
            iE02 += b5.e0(v5Var.b(i12));
        }
        b5Var.p0(iE02);
        while (i10 < v5Var.f2665x) {
            b5Var.r0(v5Var.b(i10));
            i10++;
        }
    }

    public static void f(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof v5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.k0(i, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int iE0 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iE0 += b5.e0(((Long) list.get(i11)).longValue());
            }
            b5Var.p0(iE0);
            while (i10 < list.size()) {
                b5Var.r0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        v5 v5Var = (v5) list;
        if (!z10) {
            while (i10 < v5Var.f2665x) {
                b5Var.k0(i, v5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int iE02 = 0;
        for (int i12 = 0; i12 < v5Var.f2665x; i12++) {
            iE02 += b5.e0(v5Var.b(i12));
        }
        b5Var.p0(iE02);
        while (i10 < v5Var.f2665x) {
            b5Var.r0(v5Var.b(i10));
            i10++;
        }
    }

    public static void g(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof v5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    long jLongValue = ((Long) list.get(i10)).longValue();
                    b5Var.k0(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int iE0 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                long jLongValue2 = ((Long) list.get(i11)).longValue();
                iE0 += b5.e0((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            b5Var.p0(iE0);
            while (i10 < list.size()) {
                long jLongValue3 = ((Long) list.get(i10)).longValue();
                b5Var.r0((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i10++;
            }
            return;
        }
        v5 v5Var = (v5) list;
        if (!z10) {
            while (i10 < v5Var.f2665x) {
                long jB = v5Var.b(i10);
                b5Var.k0(i, (jB >> 63) ^ (jB + jB));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int iE02 = 0;
        for (int i12 = 0; i12 < v5Var.f2665x; i12++) {
            long jB2 = v5Var.b(i12);
            iE02 += b5.e0((jB2 >> 63) ^ (jB2 + jB2));
        }
        b5Var.p0(iE02);
        while (i10 < v5Var.f2665x) {
            long jB3 = v5Var.b(i10);
            b5Var.r0((jB3 >> 63) ^ (jB3 + jB3));
            i10++;
        }
    }

    public static void h(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof v5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.l0(i, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Long) list.get(i12)).getClass();
                i11 += 8;
            }
            b5Var.p0(i11);
            while (i10 < list.size()) {
                b5Var.s0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        v5 v5Var = (v5) list;
        if (!z10) {
            while (i10 < v5Var.f2665x) {
                b5Var.l0(i, v5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < v5Var.f2665x; i14++) {
            v5Var.b(i14);
            i13 += 8;
        }
        b5Var.p0(i13);
        while (i10 < v5Var.f2665x) {
            b5Var.s0(v5Var.b(i10));
            i10++;
        }
    }

    public static void i(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof v5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.l0(i, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Long) list.get(i12)).getClass();
                i11 += 8;
            }
            b5Var.p0(i11);
            while (i10 < list.size()) {
                b5Var.s0(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        v5 v5Var = (v5) list;
        if (!z10) {
            while (i10 < v5Var.f2665x) {
                b5Var.l0(i, v5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < v5Var.f2665x; i14++) {
            v5Var.b(i14);
            i13 += 8;
        }
        b5Var.p0(i13);
        while (i10 < v5Var.f2665x) {
            b5Var.s0(v5Var.b(i10));
            i10++;
        }
    }

    public static void j(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof j5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.h0(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int iE0 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iE0 += b5.e0(((Integer) list.get(i11)).intValue());
            }
            b5Var.p0(iE0);
            while (i10 < list.size()) {
                b5Var.o0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j5 j5Var = (j5) list;
        if (!z10) {
            while (i10 < j5Var.f2497x) {
                b5Var.h0(i, j5Var.c(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int iE02 = 0;
        for (int i12 = 0; i12 < j5Var.f2497x; i12++) {
            iE02 += b5.e0(j5Var.c(i12));
        }
        b5Var.p0(iE02);
        while (i10 < j5Var.f2497x) {
            b5Var.o0(j5Var.c(i10));
            i10++;
        }
    }

    public static void k(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof j5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.i0(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int iV0 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iV0 += b5.v0(((Integer) list.get(i11)).intValue());
            }
            b5Var.p0(iV0);
            while (i10 < list.size()) {
                b5Var.p0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j5 j5Var = (j5) list;
        if (!z10) {
            while (i10 < j5Var.f2497x) {
                b5Var.i0(i, j5Var.c(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int iV02 = 0;
        for (int i12 = 0; i12 < j5Var.f2497x; i12++) {
            iV02 += b5.v0(j5Var.c(i12));
        }
        b5Var.p0(iV02);
        while (i10 < j5Var.f2497x) {
            b5Var.p0(j5Var.c(i10));
            i10++;
        }
    }

    public static void l(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof j5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    int iIntValue = ((Integer) list.get(i10)).intValue();
                    b5Var.i0(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int iV0 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                int iIntValue2 = ((Integer) list.get(i11)).intValue();
                iV0 += b5.v0((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            b5Var.p0(iV0);
            while (i10 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i10)).intValue();
                b5Var.p0((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i10++;
            }
            return;
        }
        j5 j5Var = (j5) list;
        if (!z10) {
            while (i10 < j5Var.f2497x) {
                int iC = j5Var.c(i10);
                b5Var.i0(i, (iC >> 31) ^ (iC + iC));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int iV02 = 0;
        for (int i12 = 0; i12 < j5Var.f2497x; i12++) {
            int iC2 = j5Var.c(i12);
            iV02 += b5.v0((iC2 >> 31) ^ (iC2 + iC2));
        }
        b5Var.p0(iV02);
        while (i10 < j5Var.f2497x) {
            int iC3 = j5Var.c(i10);
            b5Var.p0((iC3 >> 31) ^ (iC3 + iC3));
            i10++;
        }
    }

    public static void m(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof j5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.j0(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                i11 += 4;
            }
            b5Var.p0(i11);
            while (i10 < list.size()) {
                b5Var.q0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j5 j5Var = (j5) list;
        if (!z10) {
            while (i10 < j5Var.f2497x) {
                b5Var.j0(i, j5Var.c(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < j5Var.f2497x; i14++) {
            j5Var.c(i14);
            i13 += 4;
        }
        b5Var.p0(i13);
        while (i10 < j5Var.f2497x) {
            b5Var.q0(j5Var.c(i10));
            i10++;
        }
    }

    public static void n(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof j5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.j0(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                i11 += 4;
            }
            b5Var.p0(i11);
            while (i10 < list.size()) {
                b5Var.q0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j5 j5Var = (j5) list;
        if (!z10) {
            while (i10 < j5Var.f2497x) {
                b5Var.j0(i, j5Var.c(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < j5Var.f2497x; i14++) {
            j5Var.c(i14);
            i13 += 4;
        }
        b5Var.p0(i13);
        while (i10 < j5Var.f2497x) {
            b5Var.q0(j5Var.c(i10));
            i10++;
        }
    }

    public static void o(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!(list instanceof j5)) {
            if (!z10) {
                while (i10 < list.size()) {
                    b5Var.h0(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.g0(i, 2);
            int iE0 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iE0 += b5.e0(((Integer) list.get(i11)).intValue());
            }
            b5Var.p0(iE0);
            while (i10 < list.size()) {
                b5Var.o0(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        j5 j5Var = (j5) list;
        if (!z10) {
            while (i10 < j5Var.f2497x) {
                b5Var.h0(i, j5Var.c(i10));
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int iE02 = 0;
        for (int i12 = 0; i12 < j5Var.f2497x; i12++) {
            iE02 += b5.e0(j5Var.c(i12));
        }
        b5Var.p0(iE02);
        while (i10 < j5Var.f2497x) {
            b5Var.o0(j5Var.c(i10));
            i10++;
        }
    }

    public static void p(int i, List list, w5 w5Var, boolean z10) throws a2.a {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) w5Var.f2709a;
        int i10 = 0;
        if (!z10) {
            while (i10 < list.size()) {
                boolean zBooleanValue = ((Boolean) list.get(i10)).booleanValue();
                b5Var.p0(i << 3);
                b5Var.n0(zBooleanValue ? (byte) 1 : (byte) 0);
                i10++;
            }
            return;
        }
        b5Var.g0(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Boolean) list.get(i12)).getClass();
            i11++;
        }
        b5Var.p0(i11);
        while (i10 < list.size()) {
            b5Var.n0(((Boolean) list.get(i10)).booleanValue() ? (byte) 1 : (byte) 0);
            i10++;
        }
    }

    public static int q(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof v5)) {
            int iE0 = 0;
            while (i < size) {
                iE0 += b5.e0(((Long) list.get(i)).longValue());
                i++;
            }
            return iE0;
        }
        v5 v5Var = (v5) list;
        int iE02 = 0;
        while (i < size) {
            iE02 += b5.e0(v5Var.b(i));
            i++;
        }
        return iE02;
    }

    public static int r(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof v5)) {
            int iE0 = 0;
            while (i < size) {
                iE0 += b5.e0(((Long) list.get(i)).longValue());
                i++;
            }
            return iE0;
        }
        v5 v5Var = (v5) list;
        int iE02 = 0;
        while (i < size) {
            iE02 += b5.e0(v5Var.b(i));
            i++;
        }
        return iE02;
    }

    public static int s(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof v5)) {
            int iE0 = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iE0 += b5.e0((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iE0;
        }
        v5 v5Var = (v5) list;
        int iE02 = 0;
        while (i < size) {
            long jB = v5Var.b(i);
            iE02 += b5.e0((jB >> 63) ^ (jB + jB));
            i++;
        }
        return iE02;
    }

    public static int t(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof j5)) {
            int iE0 = 0;
            while (i < size) {
                iE0 += b5.e0(((Integer) list.get(i)).intValue());
                i++;
            }
            return iE0;
        }
        j5 j5Var = (j5) list;
        int iE02 = 0;
        while (i < size) {
            iE02 += b5.e0(j5Var.c(i));
            i++;
        }
        return iE02;
    }

    public static int u(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof j5)) {
            int iE0 = 0;
            while (i < size) {
                iE0 += b5.e0(((Integer) list.get(i)).intValue());
                i++;
            }
            return iE0;
        }
        j5 j5Var = (j5) list;
        int iE02 = 0;
        while (i < size) {
            iE02 += b5.e0(j5Var.c(i));
            i++;
        }
        return iE02;
    }

    public static int v(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof j5)) {
            int iV0 = 0;
            while (i < size) {
                iV0 += b5.v0(((Integer) list.get(i)).intValue());
                i++;
            }
            return iV0;
        }
        j5 j5Var = (j5) list;
        int iV02 = 0;
        while (i < size) {
            iV02 += b5.v0(j5Var.c(i));
            i++;
        }
        return iV02;
    }

    public static int w(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof j5)) {
            int iV0 = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iV0 += b5.v0((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iV0;
        }
        j5 j5Var = (j5) list;
        int iV02 = 0;
        while (i < size) {
            int iC = j5Var.c(i);
            iV02 += b5.v0((iC >> 31) ^ (iC + iC));
            i++;
        }
        return iV02;
    }

    public static int x(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b5.v0(i << 3) + 4) * size;
    }

    public static int y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b5.v0(i << 3) + 8) * size;
    }
}
