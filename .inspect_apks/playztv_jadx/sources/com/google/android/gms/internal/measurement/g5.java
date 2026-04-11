package com.google.android.gms.internal.measurement;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g5 {
    public static int a(int i, byte[] bArr, int i10, int i11, s5 s5Var, y4 y4Var) {
        m5 m5Var = (m5) s5Var;
        int iL = l(bArr, i10, y4Var);
        m5Var.e(y4Var.f3244a);
        while (iL < i11) {
            int iL2 = l(bArr, iL, y4Var);
            if (i != y4Var.f3244a) {
                break;
            }
            iL = l(bArr, iL2, y4Var);
            m5Var.e(y4Var.f3244a);
        }
        return iL;
    }

    public static int b(int i, byte[] bArr, int i10, int i11, k6 k6Var, y4 y4Var) throws r5 {
        if ((i >>> 3) == 0) {
            throw new r5("Protocol message contained an invalid tag (zero).");
        }
        int i12 = i & 7;
        if (i12 == 0) {
            int iM = m(bArr, i10, y4Var);
            k6Var.c(i, Long.valueOf(y4Var.f3245b));
            return iM;
        }
        if (i12 == 1) {
            k6Var.c(i, Long.valueOf(n(i10, bArr)));
            return i10 + 8;
        }
        if (i12 == 2) {
            int iL = l(bArr, i10, y4Var);
            int i13 = y4Var.f3244a;
            if (i13 < 0) {
                throw r5.b();
            }
            if (i13 > bArr.length - iL) {
                throw r5.d();
            }
            if (i13 == 0) {
                k6Var.c(i, a5.f2884w);
            } else {
                k6Var.c(i, a5.e(bArr, iL, i13));
            }
            return iL + i13;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw new r5("Protocol message contained an invalid tag (zero).");
            }
            k6Var.c(i, Integer.valueOf(k(i10, bArr)));
            return i10 + 4;
        }
        k6 k6VarE = k6.e();
        int i14 = (i & (-8)) | 4;
        int i15 = y4Var.f3247d + 1;
        y4Var.f3247d = i15;
        if (i15 >= 100) {
            throw new r5("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i16 = 0;
        while (true) {
            if (i10 >= i11) {
                break;
            }
            int iL2 = l(bArr, i10, y4Var);
            int i17 = y4Var.f3244a;
            if (i17 == i14) {
                i16 = i17;
                i10 = iL2;
                break;
            }
            i10 = b(i17, bArr, iL2, i11, k6VarE, y4Var);
            i16 = i17;
        }
        y4Var.f3247d--;
        if (i10 > i11 || i16 != i14) {
            throw r5.c();
        }
        k6Var.c(i, k6VarE);
        return i10;
    }

    public static int c(int i, byte[] bArr, int i10, y4 y4Var) {
        int i11 = i & ModuleDescriptor.MODULE_VERSION;
        int i12 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 >= 0) {
            y4Var.f3244a = i11 | (b10 << 7);
            return i12;
        }
        int i13 = i11 | ((b10 & 127) << 7);
        int i14 = i10 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            y4Var.f3244a = i13 | (b11 << 14);
            return i14;
        }
        int i15 = i13 | ((b11 & 127) << 14);
        int i16 = i10 + 3;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            y4Var.f3244a = i15 | (b12 << 21);
            return i16;
        }
        int i17 = i15 | ((b12 & 127) << 21);
        int i18 = i10 + 4;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            y4Var.f3244a = i17 | (b13 << 28);
            return i18;
        }
        int i19 = i17 | ((b13 & 127) << 28);
        while (true) {
            int i20 = i18 + 1;
            if (bArr[i18] >= 0) {
                y4Var.f3244a = i19;
                return i20;
            }
            i18 = i20;
        }
    }

    public static int d(Object obj, j6 j6Var, byte[] bArr, int i, int i10, int i11, y4 y4Var) throws r5 {
        c6 c6Var = (c6) j6Var;
        int i12 = y4Var.f3247d + 1;
        y4Var.f3247d = i12;
        if (i12 >= 100) {
            throw new r5("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iK = c6Var.k(obj, bArr, i, i10, i11, y4Var);
        y4Var.f3247d--;
        y4Var.f3246c = obj;
        return iK;
    }

    public static int e(Object obj, j6 j6Var, byte[] bArr, int i, int i10, y4 y4Var) throws r5 {
        int iC = i + 1;
        int i11 = bArr[i];
        if (i11 < 0) {
            iC = c(i11, bArr, iC, y4Var);
            i11 = y4Var.f3244a;
        }
        int i12 = iC;
        if (i11 < 0 || i11 > i10 - i12) {
            throw r5.d();
        }
        int i13 = y4Var.f3247d + 1;
        y4Var.f3247d = i13;
        if (i13 >= 100) {
            throw new r5("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i14 = i12 + i11;
        j6Var.h(obj, bArr, i12, i14, y4Var);
        y4Var.f3247d--;
        y4Var.f3246c = obj;
        return i14;
    }

    public static int f(byte[] bArr, int i, y4 y4Var) throws r5 {
        int iL = l(bArr, i, y4Var);
        int i10 = y4Var.f3244a;
        if (i10 < 0) {
            throw r5.b();
        }
        if (i10 > bArr.length - iL) {
            throw r5.d();
        }
        if (i10 == 0) {
            y4Var.f3246c = a5.f2884w;
            return iL;
        }
        y4Var.f3246c = a5.e(bArr, iL, i10);
        return iL + i10;
    }

    public static n g(i iVar, p pVar, ub.o oVar, ArrayList arrayList) {
        String str = pVar.f3145u;
        if (iVar.e(str)) {
            n nVarD = iVar.d(str);
            if (nVarD instanceof j) {
                return ((j) nVarD).a(oVar, arrayList);
            }
            throw new IllegalArgumentException(e6.j.m(str, " is not a function"));
        }
        if (!"hasOwnProperty".equals(str)) {
            throw new IllegalArgumentException(l4.a.m("Object has no function ", str));
        }
        c4.i("hasOwnProperty", 1, arrayList);
        return iVar.e(((h4.z) oVar.f12869w).l0(oVar, (n) arrayList.get(0)).i()) ? n.f : n.f3111g;
    }

    public static d5 h() {
        String str;
        ClassLoader classLoader = g5.class.getClassLoader();
        if (d5.class.equals(d5.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!d5.class.getPackage().equals(g5.class.getPackage())) {
                throw new IllegalArgumentException(d5.class.getName());
            }
            str = d5.class.getPackage().getName() + ".BlazeGenerated" + d5.class.getSimpleName() + "Loader";
        }
        try {
            try {
                try {
                    l4.a.t(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                    throw null;
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException(e10);
                } catch (InvocationTargetException e11) {
                    throw new IllegalStateException(e11);
                }
            } catch (InstantiationException e12) {
                throw new IllegalStateException(e12);
            } catch (NoSuchMethodException e13) {
                throw new IllegalStateException(e13);
            }
        } catch (ClassNotFoundException unused) {
            try {
                Iterator it = Arrays.asList(new g5[0]).iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    try {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    } catch (ServiceConfigurationError e14) {
                        Logger.getLogger(b5.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(d5.class.getSimpleName()), (Throwable) e14);
                    }
                }
                if (arrayList.size() == 1) {
                    return (d5) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (d5) d5.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e15) {
                    throw new IllegalStateException(e15);
                } catch (NoSuchMethodException e16) {
                    throw new IllegalStateException(e16);
                } catch (InvocationTargetException e17) {
                    throw new IllegalStateException(e17);
                }
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static z5 i(Object obj, Object obj2) {
        z5 z5Var = (z5) obj;
        z5 z5Var2 = (z5) obj2;
        if (!z5Var2.isEmpty()) {
            if (!z5Var.f3260u) {
                if (z5Var.isEmpty()) {
                    z5Var = new z5();
                } else {
                    z5 z5Var3 = new z5(z5Var);
                    z5Var3.f3260u = true;
                    z5Var = z5Var3;
                }
            }
            z5Var.b();
            if (!z5Var2.isEmpty()) {
                z5Var.putAll(z5Var2);
            }
        }
        return z5Var;
    }

    public static int j(j6 j6Var, int i, byte[] bArr, int i10, int i11, s5 s5Var, y4 y4Var) throws r5 {
        j5 j5VarA = j6Var.a();
        j6 j6Var2 = j6Var;
        byte[] bArr2 = bArr;
        int i12 = i11;
        y4 y4Var2 = y4Var;
        int iE = e(j5VarA, j6Var2, bArr2, i10, i12, y4Var2);
        j6Var2.d(j5VarA);
        y4Var2.f3246c = j5VarA;
        s5Var.add(j5VarA);
        while (iE < i12) {
            y4 y4Var3 = y4Var2;
            int i13 = i12;
            int iL = l(bArr2, iE, y4Var3);
            if (i != y4Var3.f3244a) {
                break;
            }
            byte[] bArr3 = bArr2;
            j6 j6Var3 = j6Var2;
            j5 j5VarA2 = j6Var3.a();
            iE = e(j5VarA2, j6Var3, bArr3, iL, i13, y4Var3);
            j6Var2 = j6Var3;
            bArr2 = bArr3;
            i12 = i13;
            y4Var2 = y4Var3;
            j6Var2.d(j5VarA2);
            y4Var2.f3246c = j5VarA2;
            s5Var.add(j5VarA2);
        }
        return iE;
    }

    public static int k(int i, byte[] bArr) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int l(byte[] bArr, int i, y4 y4Var) {
        int i10 = i + 1;
        byte b10 = bArr[i];
        if (b10 < 0) {
            return c(b10, bArr, i10, y4Var);
        }
        y4Var.f3244a = b10;
        return i10;
    }

    public static int m(byte[] bArr, int i, y4 y4Var) {
        int i10 = i + 1;
        long j5 = bArr[i];
        if (j5 >= 0) {
            y4Var.f3245b = j5;
            return i10;
        }
        int i11 = i + 2;
        byte b10 = bArr[i10];
        long j8 = (j5 & 127) | (((long) (b10 & 127)) << 7);
        int i12 = 7;
        while (b10 < 0) {
            int i13 = i11 + 1;
            byte b11 = bArr[i11];
            i12 += 7;
            j8 |= ((long) (b11 & 127)) << i12;
            b10 = b11;
            i11 = i13;
        }
        y4Var.f3245b = j8;
        return i11;
    }

    public static long n(int i, byte[] bArr) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
