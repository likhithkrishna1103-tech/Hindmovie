package aa;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f729u = 2;

    public static int a(int i) {
        if (i < 3) {
            c("expectedSize", i);
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
                throw new NullPointerException(e6.j.l("at index ", i10));
            }
        }
    }

    public static void c(String str, int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static Object d(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            throw new IllegalArgumentException(e6.j.l("must be power of 2 between 2^1 and 2^30: ", i));
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

    public static boolean h(Set set, Object obj) {
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

    public static l1 i(Set set, z9.h hVar) {
        if (set instanceof SortedSet) {
            Set set2 = (SortedSet) set;
            if (!(set2 instanceof l1)) {
                return new m1(set2, hVar);
            }
            l1 l1Var = (l1) set2;
            z9.h hVar2 = l1Var.f709v;
            hVar2.getClass();
            return new m1((SortedSet) l1Var.f708u, new z9.i(Arrays.asList(hVar2, hVar)));
        }
        if (!(set instanceof l1)) {
            set.getClass();
            return new l1(set, hVar);
        }
        l1 l1Var2 = (l1) set;
        z9.h hVar3 = l1Var2.f709v;
        hVar3.getClass();
        return new l1(l1Var2.f708u, new z9.i(Arrays.asList(hVar3, hVar)));
    }

    public static Object j(AbstractCollection abstractCollection, String str) {
        Iterator it = abstractCollection.iterator();
        return it.hasNext() ? it.next() : str;
    }

    public static Object k(Iterable iterable) {
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

    public static int l(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static k1 m(Set set, o0 o0Var) {
        q1.c.j(set, "set1");
        q1.c.j(o0Var, "set2");
        return new k1(set, o0Var);
    }

    public static int n(int i, int i10, int i11) {
        return (i & (~i11)) | (i10 & i11);
    }

    public static ArrayList o(Object... objArr) {
        int length = objArr.length;
        c("arraySize", length);
        ArrayList arrayList = new ArrayList(q1.c.M(((long) length) + 5 + ((long) (length / 10))));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    public static int p(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i10;
        int i11;
        int iS = s(obj);
        int i12 = iS & i;
        int iT = t(i12, obj3);
        if (iT != 0) {
            int i13 = ~i;
            int i14 = iS & i13;
            int i15 = -1;
            while (true) {
                i10 = iT - 1;
                i11 = iArr[i10];
                if ((i11 & i13) == i14 && i5.a.o(obj, objArr[i10]) && (objArr2 == null || i5.a.o(obj2, objArr2[i10]))) {
                    break;
                }
                int i16 = i11 & i;
                if (i16 == 0) {
                    break;
                }
                i15 = i10;
                iT = i16;
            }
            int i17 = i11 & i;
            if (i15 == -1) {
                u(i12, i17, obj3);
                return i10;
            }
            iArr[i15] = n(iArr[i15], i17, i);
            return i10;
        }
        return -1;
    }

    public static void q(List list, z9.h hVar, int i, int i10) {
        for (int size = list.size() - 1; size > i10; size--) {
            if (hVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i11 = i10 - 1; i11 >= i; i11--) {
            list.remove(i11);
        }
    }

    public static int r(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    public static int s(Object obj) {
        return r(obj == null ? 0 : obj.hashCode());
    }

    public static int t(int i, Object obj) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & 255 : obj instanceof short[] ? ((short[]) obj)[i] & 65535 : ((int[]) obj)[i];
    }

    public static void u(int i, int i10, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i10;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i10;
        } else {
            ((int[]) obj)[i] = i10;
        }
    }

    public static AbstractList v(List list, z9.f fVar) {
        return l4.a.v(list) ? new t0(list, fVar) : new u0(list, fVar);
    }

    public abstract Object e();

    public String toString() {
        switch (this.f729u) {
            case 2:
                return e().toString();
            default:
                return super.toString();
        }
    }
}
