package ua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i0 extends d0 implements List, RandomAccess {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final g0 f12341w = new g0(z0.f12413z, 0);

    public static z0 i(int i, Object[] objArr) {
        return i == 0 ? z0.f12413z : new z0(i, objArr);
    }

    public static f0 j() {
        return new f0(4);
    }

    public static i0 k(Collection collection) {
        if (!(collection instanceof d0)) {
            Object[] array = collection.toArray();
            q.b(array.length, array);
            return i(array.length, array);
        }
        i0 i0VarA = ((d0) collection).a();
        if (!i0VarA.g()) {
            return i0VarA;
        }
        Object[] array2 = i0VarA.toArray(d0.f12318v);
        return i(array2.length, array2);
    }

    public static z0 l(Object[] objArr) {
        if (objArr.length == 0) {
            return z0.f12413z;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        q.b(objArr2.length, objArr2);
        return i(objArr2.length, objArr2);
    }

    public static z0 n(Long l10, Long l11, Long l12, Long l13, Long l14) {
        Object[] objArr = {l10, l11, l12, l13, l14};
        q.b(5, objArr);
        return i(5, objArr);
    }

    public static z0 o(Object obj) {
        Object[] objArr = {obj};
        q.b(1, objArr);
        return i(1, objArr);
    }

    public static z0 p(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        q.b(2, objArr);
        return i(2, objArr);
    }

    public static z0 q(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Object... objArr) {
        com.bumptech.glide.d.f("the total number of elements must fit in an int", objArr.length <= 2147483635);
        int length = objArr.length + 12;
        Object[] objArr2 = new Object[length];
        objArr2[0] = str;
        objArr2[1] = str2;
        objArr2[2] = str3;
        objArr2[3] = str4;
        objArr2[4] = str5;
        objArr2[5] = str6;
        objArr2[6] = str7;
        objArr2[7] = str8;
        objArr2[8] = str9;
        objArr2[9] = str10;
        objArr2[10] = str11;
        objArr2[11] = str12;
        System.arraycopy(objArr, 0, objArr2, 12, objArr.length);
        q.b(length, objArr2);
        return i(length, objArr2);
    }

    public static z0 r(Comparator comparator, List list) {
        comparator.getClass();
        if (!q4.a.v(list)) {
            Iterator it = list.iterator();
            ArrayList arrayList = new ArrayList();
            it.getClass();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            list = arrayList;
        }
        Object[] array = list.toArray();
        q.b(array.length, array);
        Arrays.sort(array, comparator);
        return i(array.length, array);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // ua.d0
    public int b(int i, Object[] objArr) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            objArr[i + i10] = get(i10);
        }
        return i + size;
    }

    @Override // ua.d0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
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
                            if (it2.hasNext() && com.bumptech.glide.c.h(it.next(), it2.next())) {
                            }
                        }
                        return !it2.hasNext();
                    }
                    for (int i = 0; i < size; i++) {
                        if (com.bumptech.glide.c.h(get(i), list.get(i))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // ua.d0
    /* JADX INFO: renamed from: h */
    public final n1 iterator() {
        return listIterator(0);
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
    public final int indexOf(Object obj) {
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

    @Override // ua.d0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
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
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final g0 listIterator(int i) {
        com.bumptech.glide.d.i(i, size());
        return isEmpty() ? f12341w : new g0(this, i);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public i0 subList(int i, int i10) {
        com.bumptech.glide.d.j(i, i10, size());
        int i11 = i10 - i;
        return i11 == size() ? this : i11 == 0 ? z0.f12413z : new h0(this, i, i11);
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // ua.d0
    public final i0 a() {
        return this;
    }
}
