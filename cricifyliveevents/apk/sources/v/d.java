package v;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Collection {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e f12518v;

    public d(e eVar) {
        this.f12518v = eVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f12518v.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f12518v.a(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f12518v.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f12518v, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        e eVar = this.f12518v;
        int iA = eVar.a(obj);
        if (iA < 0) {
            return false;
        }
        eVar.h(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        e eVar = this.f12518v;
        int i = eVar.f12542x;
        int i10 = 0;
        boolean z10 = false;
        while (i10 < i) {
            if (collection.contains(eVar.j(i10))) {
                eVar.h(i10);
                i10--;
                i--;
                z10 = true;
            }
            i10++;
        }
        return z10;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f12518v;
        int i = eVar.f12542x;
        int i10 = 0;
        boolean z10 = false;
        while (i10 < i) {
            if (!collection.contains(eVar.j(i10))) {
                eVar.h(i10);
                i10--;
                i--;
                z10 = true;
            }
            i10++;
        }
        return z10;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f12518v.f12542x;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        e eVar = this.f12518v;
        int i = eVar.f12542x;
        Object[] objArr = new Object[i];
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = eVar.j(i10);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e eVar = this.f12518v;
        int i = eVar.f12542x;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = eVar.j(i10);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
