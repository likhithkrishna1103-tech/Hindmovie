package ua;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f12377v = 2;

    public static int a(int i) {
        if (i < 3) {
            d(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) Math.ceil(((double) i) / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    public static void b(int i, Object[] objArr) {
        for (int i10 = 0; i10 < i; i10++) {
            if (objArr[i10] == null) {
                throw new NullPointerException(l0.e.g(i10, "at index "));
            }
        }
    }

    public static void c(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static void d(int i, String str) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static Object e(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            throw new IllegalArgumentException(l0.e.g(i, "must be power of 2 between 2^1 and 2^30: "));
        }
        return i <= 256 ? new byte[i] : i <= 65536 ? new short[i] : new int[i];
    }

    public static boolean g(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static boolean i(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
                return set.containsAll(set2);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static i1 j(Set set, ta.h hVar) {
        if (set instanceof SortedSet) {
            Set set2 = (SortedSet) set;
            if (!(set2 instanceof i1)) {
                return new j1(set2, hVar);
            }
            i1 i1Var = (i1) set2;
            ta.h hVar2 = i1Var.f12343w;
            hVar2.getClass();
            return new j1((SortedSet) i1Var.f12342v, new ta.i(Arrays.asList(hVar2, hVar)));
        }
        if (!(set instanceof i1)) {
            set.getClass();
            return new i1(set, hVar);
        }
        i1 i1Var2 = (i1) set;
        ta.h hVar3 = i1Var2.f12343w;
        hVar3.getClass();
        return new i1(i1Var2.f12342v, new ta.i(Arrays.asList(hVar3, hVar)));
    }

    public static Object k(AbstractCollection abstractCollection, String str) {
        Iterator it = abstractCollection.iterator();
        return it.hasNext() ? it.next() : str;
    }

    public static Object l(Iterable iterable) {
        Object next;
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return list.get(list.size() - 1);
        }
        Iterator it = iterable.iterator();
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static int m(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static h1 n(Set set, m0 m0Var) {
        com.bumptech.glide.d.h(set, "set1");
        com.bumptech.glide.d.h(m0Var, "set2");
        return new h1(set, m0Var);
    }

    public static int o(int i, int i10, int i11) {
        return (i & (~i11)) | (i10 & i11);
    }

    public static ArrayList p(Object... objArr) {
        int length = objArr.length;
        d(length, "arraySize");
        ArrayList arrayList = new ArrayList(com.bumptech.glide.d.B(((long) length) + 5 + ((long) (length / 10))));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    public static int q(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i10;
        int i11;
        int iT = t(obj);
        int i12 = iT & i;
        int iU = u(i12, obj3);
        if (iU != 0) {
            int i13 = ~i;
            int i14 = iT & i13;
            int i15 = -1;
            while (true) {
                i10 = iU - 1;
                i11 = iArr[i10];
                if ((i11 & i13) == i14 && com.bumptech.glide.c.h(obj, objArr[i10]) && (objArr2 == null || com.bumptech.glide.c.h(obj2, objArr2[i10]))) {
                    break;
                }
                int i16 = i11 & i;
                if (i16 == 0) {
                    break;
                }
                i15 = i10;
                iU = i16;
            }
            int i17 = i11 & i;
            if (i15 == -1) {
                v(i12, i17, obj3);
                return i10;
            }
            iArr[i15] = o(iArr[i15], i17, i);
            return i10;
        }
        return -1;
    }

    public static void r(List list, ta.h hVar, int i, int i10) {
        for (int size = list.size() - 1; size > i10; size--) {
            if (hVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i11 = i10 - 1; i11 >= i; i11--) {
            list.remove(i11);
        }
    }

    public static int s(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static int t(Object obj) {
        return s(obj == null ? 0 : obj.hashCode());
    }

    public static int u(int i, Object obj) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & 255 : obj instanceof short[] ? ((short[]) obj)[i] & 65535 : ((int[]) obj)[i];
    }

    public static void v(int i, int i10, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i10;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i10;
        } else {
            ((int[]) obj)[i] = i10;
        }
    }

    public static AbstractList w(List list, ta.f fVar) {
        return q4.a.v(list) ? new r0(list, fVar) : new s0(list, fVar);
    }

    public abstract Object f();

    public String toString() {
        switch (this.f12377v) {
            case 2:
                return f().toString();
            default:
                return super.toString();
        }
    }
}
