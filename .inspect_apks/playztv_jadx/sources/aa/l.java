package aa;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class l extends AbstractCollection implements List {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f698u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Collection f699v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l f700w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Collection f701x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ x0 f702y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ x0 f703z;

    public l(x0 x0Var, Object obj, List list, l lVar) {
        this.f703z = x0Var;
        this.f702y = x0Var;
        this.f698u = obj;
        this.f699v = list;
        this.f700w = lVar;
        this.f701x = lVar == null ? null : lVar.f699v;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d();
        boolean zIsEmpty = this.f699v.isEmpty();
        boolean zAdd = this.f699v.add(obj);
        if (zAdd) {
            this.f702y.f761y++;
            if (zIsEmpty) {
                b();
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
        boolean zAddAll = this.f699v.addAll(collection);
        if (zAddAll) {
            this.f702y.f761y += this.f699v.size() - size;
            if (size == 0) {
                b();
            }
        }
        return zAddAll;
    }

    public final void b() {
        l lVar = this.f700w;
        if (lVar != null) {
            lVar.b();
        } else {
            this.f702y.f760x.put(this.f698u, this.f699v);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f699v.clear();
        this.f702y.f761y -= size;
        e();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        d();
        return this.f699v.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean containsAll(Collection collection) {
        d();
        return this.f699v.containsAll(collection);
    }

    public final void d() {
        Collection collection;
        l lVar = this.f700w;
        if (lVar != null) {
            lVar.d();
            if (lVar.f699v != this.f701x) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f699v.isEmpty() || (collection = (Collection) this.f702y.f760x.get(this.f698u)) == null) {
                return;
            }
            this.f699v = collection;
        }
    }

    public final void e() {
        l lVar = this.f700w;
        if (lVar != null) {
            lVar.e();
        } else if (this.f699v.isEmpty()) {
            this.f702y.f760x.remove(this.f698u);
        }
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        d();
        return this.f699v.equals(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        d();
        return ((List) this.f699v).get(i);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        d();
        return this.f699v.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        d();
        return ((List) this.f699v).indexOf(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        d();
        return new c(this);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        d();
        return ((List) this.f699v).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        d();
        return new k(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        d();
        boolean zRemove = this.f699v.remove(obj);
        if (zRemove) {
            x0 x0Var = this.f702y;
            x0Var.f761y--;
            e();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.f699v.removeAll(collection);
        if (zRemoveAll) {
            this.f702y.f761y += this.f699v.size() - size;
            e();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.f699v.retainAll(collection);
        if (zRetainAll) {
            this.f702y.f761y += this.f699v.size() - size;
            e();
        }
        return zRetainAll;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        d();
        return ((List) this.f699v).set(i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        d();
        return this.f699v.size();
    }

    @Override // java.util.List
    public final List subList(int i, int i10) {
        d();
        List listSubList = ((List) this.f699v).subList(i, i10);
        l lVar = this.f700w;
        if (lVar == null) {
            lVar = this;
        }
        boolean z2 = listSubList instanceof RandomAccess;
        x0 x0Var = this.f703z;
        Object obj = this.f698u;
        return z2 ? new h(x0Var, obj, listSubList, lVar) : new l(x0Var, obj, listSubList, lVar);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        d();
        return this.f699v.toString();
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        d();
        return new k(this, i);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        d();
        Object objRemove = ((List) this.f699v).remove(i);
        x0 x0Var = this.f703z;
        x0Var.f761y--;
        e();
        return objRemove;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        d();
        boolean zIsEmpty = this.f699v.isEmpty();
        ((List) this.f699v).add(i, obj);
        this.f703z.f761y++;
        if (zIsEmpty) {
            b();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.f699v).addAll(i, collection);
        if (zAddAll) {
            this.f703z.f761y += this.f699v.size() - size;
            if (size == 0) {
                b();
            }
        }
        return zAddAll;
    }
}
