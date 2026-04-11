package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class u4 {
    protected int zza;

    public static void b(Iterable iterable, List list) {
        Charset charset = l5.f3086a;
        iterable.getClass();
        if (iterable instanceof v5) {
            List listM0a = ((v5) iterable).m0a();
            v5 v5Var = (v5) list;
            int size = list.size();
            for (Object obj : listM0a) {
                if (obj == null) {
                    String strJ = e6.j.j(v5Var.size() - size, "Element at index ", " is null.");
                    for (int size2 = v5Var.size() - 1; size2 >= size; size2--) {
                        v5Var.remove(size2);
                    }
                    throw new NullPointerException(strJ);
                }
                if (obj instanceof a5) {
                    v5Var.m1a();
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    a5.e(bArr, 0, bArr.length);
                    v5Var.m1a();
                } else {
                    v5Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof f6) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size3 = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size3);
            }
            if (list instanceof g6) {
                g6 g6Var = (g6) list;
                int i = g6Var.f3019w + size3;
                Object[] objArr = g6Var.f3018v;
                if (i > objArr.length) {
                    if (objArr.length == 0) {
                        g6Var.f3018v = new Object[Math.max(i, 10)];
                    } else {
                        int length = objArr.length;
                        while (length < i) {
                            length = Math.max(((length * 3) / 2) + 1, 10);
                        }
                        g6Var.f3018v = Arrays.copyOf(g6Var.f3018v, length);
                    }
                }
            }
        }
        int size4 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    i5.b(size4, list);
                    throw null;
                }
                list.add(obj2);
            }
            return;
        }
        List list2 = (List) iterable;
        int size5 = list2.size();
        for (int i10 = 0; i10 < size5; i10++) {
            Object obj3 = list2.get(i10);
            if (obj3 == null) {
                i5.b(size4, list);
                throw null;
            }
            list.add(obj3);
        }
    }

    public abstract int a(j6 j6Var);

    public final byte[] c() {
        try {
            int iA = ((j5) this).a(null);
            byte[] bArr = new byte[iA];
            b5 b5Var = new b5(iA, bArr);
            j5 j5Var = (j5) this;
            h6 h6Var = h6.f3037c;
            h6Var.getClass();
            j6 j6VarA = h6Var.a(j5Var.getClass());
            x5 x5Var = b5Var.f2899b;
            if (x5Var == null) {
                x5Var = new x5();
                Charset charset = l5.f3086a;
                x5Var.f3235a = b5Var;
                b5Var.f2899b = x5Var;
            }
            j6VarA.i(j5Var, x5Var);
            if (b5Var.i() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e10) {
            throw new RuntimeException(e6.j.n("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e10);
        }
    }
}
