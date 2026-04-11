package aa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j0 extends e0 implements List, RandomAccess {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h0 f690v = new h0(c1.f650y, 0);

    public static c1 l(int i, Object[] objArr) {
        return i == 0 ? c1.f650y : new c1(i, objArr);
    }

    public static g0 n() {
        return new g0(4);
    }

    public static j0 r(Collection collection) {
        if (!(collection instanceof e0)) {
            Object[] array = collection.toArray();
            q.b(array.length, array);
            return l(array.length, array);
        }
        j0 j0VarB = ((e0) collection).b();
        if (!j0VarB.i()) {
            return j0VarB;
        }
        Object[] array2 = j0VarB.toArray(e0.f663u);
        return l(array2.length, array2);
    }

    public static c1 s(Object[] objArr) {
        if (objArr.length == 0) {
            return c1.f650y;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        q.b(objArr2.length, objArr2);
        return l(objArr2.length, objArr2);
    }

    public static c1 u(Long l10, Long l11, Long l12, Long l13, Long l14) {
        Object[] objArr = {l10, l11, l12, l13, l14};
        q.b(5, objArr);
        return l(5, objArr);
    }

    public static c1 v(Object obj) {
        Object[] objArr = {obj};
        q.b(1, objArr);
        return l(1, objArr);
    }

    public static c1 w(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        q.b(2, objArr);
        return l(2, objArr);
    }

    public static c1 x(Comparator comparator, List list) {
        List list2;
        comparator.getClass();
        if (list instanceof Collection) {
            list2 = list;
        } else {
            Iterator it = list.iterator();
            ArrayList arrayList = new ArrayList();
            it.getClass();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            list2 = arrayList;
        }
        Object[] array = list2.toArray();
        q.b(array.length, array);
        Arrays.sort(array, comparator);
        return l(array.length, array);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // aa.e0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // aa.e0
    public int d(int i, Object[] objArr) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            objArr[i + i10] = get(i10);
        }
        return i + size;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if (!(list instanceof RandomAccess)) {
                        Iterator it = iterator();
                        Iterator it2 = list.iterator();
                        while (it.hasNext()) {
                            if (it2.hasNext() && i5.a.o(it.next(), it2.next())) {
                            }
                        }
                        return !it2.hasNext();
                    }
                    for (int i = 0; i < size; i++) {
                        if (i5.a.o(get(i), list.get(i))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i10 = 0; i10 < size; i10++) {
            i = ~(~(get(i10).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // aa.e0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // aa.e0
    /* JADX INFO: renamed from: j */
    public final q1 iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final h0 listIterator(int i) {
        q1.c.k(i, size());
        return isEmpty() ? f690v : new h0(this, i);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public j0 subList(int i, int i10) {
        q1.c.l(i, i10, size());
        int i11 = i10 - i;
        return i11 == size() ? this : i11 == 0 ? c1.f650y : new i0(this, i, i11);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // aa.e0
    public final j0 b() {
        return this;
    }
}
