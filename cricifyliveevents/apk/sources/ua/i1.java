package ua;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class i1 extends AbstractCollection implements Set {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Set f12342v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ta.h f12343w;

    public i1(Set set, ta.h hVar) {
        this.f12342v = set;
        this.f12343w = hVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        if (this.f12343w.apply(obj)) {
            return this.f12342v.add(obj);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.f12343w.apply(it.next())) {
                throw new IllegalArgumentException();
            }
        }
        return this.f12342v.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        Set set = this.f12342v;
        boolean z10 = set instanceof RandomAccess;
        ta.h hVar = this.f12343w;
        if (!z10 || !(set instanceof List)) {
            Iterator it = set.iterator();
            hVar.getClass();
            while (it.hasNext()) {
                if (hVar.apply(it.next())) {
                    it.remove();
                }
            }
            return;
        }
        List list = (List) set;
        hVar.getClass();
        int i = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            Object obj = list.get(i10);
            if (!hVar.apply(obj)) {
                if (i10 > i) {
                    try {
                        list.set(i, obj);
                    } catch (IllegalArgumentException unused) {
                        q.r(list, hVar, i, i10);
                        return;
                    } catch (UnsupportedOperationException unused2) {
                        q.r(list, hVar, i, i10);
                        return;
                    }
                }
                i++;
            }
        }
        list.subList(i, list.size()).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        boolean zContains;
        Set set = this.f12342v;
        set.getClass();
        try {
            zContains = set.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            zContains = false;
        }
        if (zContains) {
            return this.f12343w.apply(obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return q.i(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return q.m(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        Iterator it = this.f12342v.iterator();
        ta.h hVar = this.f12343w;
        com.bumptech.glide.d.h(hVar, "predicate");
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (hVar.apply(it.next())) {
                break;
            }
            i++;
        }
        return true ^ (i != -1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        Iterator it = this.f12342v.iterator();
        it.getClass();
        ta.h hVar = this.f12343w;
        hVar.getClass();
        return new n0(it, hVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        return contains(obj) && this.f12342v.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = this.f12342v.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f12343w.apply(next) && collection.contains(next)) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        Iterator it = this.f12342v.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f12343w.apply(next) && !collection.contains(next)) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator it = this.f12342v.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.f12343w.apply(it.next())) {
                i++;
            }
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Iterator it = iterator();
        ArrayList arrayList = new ArrayList();
        while (true) {
            n0 n0Var = (n0) it;
            if (!n0Var.hasNext()) {
                return arrayList.toArray();
            }
            arrayList.add(n0Var.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        Iterator it = iterator();
        ArrayList arrayList = new ArrayList();
        while (true) {
            n0 n0Var = (n0) it;
            if (n0Var.hasNext()) {
                arrayList.add(n0Var.next());
            } else {
                return arrayList.toArray(objArr);
            }
        }
    }
}
