package ua;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class l extends AbstractCollection implements List {
    public final /* synthetic */ v0 A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f12352v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Collection f12353w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l f12354x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Collection f12355y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ v0 f12356z;

    public l(v0 v0Var, Object obj, List list, l lVar) {
        this.A = v0Var;
        this.f12356z = v0Var;
        this.f12352v = obj;
        this.f12353w = list;
        this.f12354x = lVar;
        this.f12355y = lVar == null ? null : lVar.f12353w;
    }

    public final void a() {
        l lVar = this.f12354x;
        if (lVar != null) {
            lVar.a();
        } else {
            this.f12356z.f12401y.put(this.f12352v, this.f12353w);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        boolean zIsEmpty = this.f12353w.isEmpty();
        boolean zAdd = this.f12353w.add(obj);
        if (zAdd) {
            this.f12356z.f12402z++;
            if (zIsEmpty) {
                a();
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.f12353w.addAll(collection);
        if (zAddAll) {
            this.f12356z.f12402z += this.f12353w.size() - size;
            if (size == 0) {
                a();
            }
        }
        return zAddAll;
    }

    public final void b() {
        Collection collection;
        l lVar = this.f12354x;
        if (lVar != null) {
            lVar.b();
            if (lVar.f12353w != this.f12355y) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f12353w.isEmpty() || (collection = (Collection) this.f12356z.f12401y.get(this.f12352v)) == null) {
                return;
            }
            this.f12353w = collection;
        }
    }

    public final void c() {
        l lVar = this.f12354x;
        if (lVar != null) {
            lVar.c();
        } else if (this.f12353w.isEmpty()) {
            this.f12356z.f12401y.remove(this.f12352v);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f12353w.clear();
        this.f12356z.f12402z -= size;
        c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        b();
        return this.f12353w.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean containsAll(Collection collection) {
        b();
        return this.f12353w.containsAll(collection);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        b();
        return this.f12353w.equals(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        b();
        return ((List) this.f12353w).get(i);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        b();
        return this.f12353w.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        b();
        return ((List) this.f12353w).indexOf(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        b();
        return new c(this);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        b();
        return ((List) this.f12353w).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        b();
        return new k(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        b();
        boolean zRemove = this.f12353w.remove(obj);
        if (zRemove) {
            v0 v0Var = this.f12356z;
            v0Var.f12402z--;
            c();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.f12353w.removeAll(collection);
        if (zRemoveAll) {
            this.f12356z.f12402z += this.f12353w.size() - size;
            c();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.f12353w.retainAll(collection);
        if (zRetainAll) {
            this.f12356z.f12402z += this.f12353w.size() - size;
            c();
        }
        return zRetainAll;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        b();
        return ((List) this.f12353w).set(i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        b();
        return this.f12353w.size();
    }

    @Override // java.util.List
    public final List subList(int i, int i10) {
        b();
        List listSubList = ((List) this.f12353w).subList(i, i10);
        l lVar = this.f12354x;
        if (lVar == null) {
            lVar = this;
        }
        boolean z10 = listSubList instanceof RandomAccess;
        v0 v0Var = this.A;
        Object obj = this.f12352v;
        return z10 ? new h(v0Var, obj, listSubList, lVar) : new l(v0Var, obj, listSubList, lVar);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        b();
        return this.f12353w.toString();
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        b();
        return new k(this, i);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        b();
        Object objRemove = ((List) this.f12353w).remove(i);
        v0 v0Var = this.A;
        v0Var.f12402z--;
        c();
        return objRemove;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        b();
        boolean zIsEmpty = this.f12353w.isEmpty();
        ((List) this.f12353w).add(i, obj);
        this.A.f12402z++;
        if (zIsEmpty) {
            a();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.f12353w).addAll(i, collection);
        if (zAddAll) {
            this.A.f12402z += this.f12353w.size() - size;
            if (size == 0) {
                a();
            }
        }
        return zAddAll;
    }
}
