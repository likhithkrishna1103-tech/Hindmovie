package pd;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends od.e implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final i f10363v;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f10364u;

    static {
        f fVar = f.H;
        f10363v = new i(f.H);
    }

    public i(f fVar) {
        be.h.e(fVar, "backing");
        this.f10364u = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.f10364u.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        be.h.e(collection, "elements");
        this.f10364u.b();
        return super.addAll(collection);
    }

    @Override // od.e
    public final int b() {
        return this.f10364u.C;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f10364u.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f10364u.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f10364u.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        f fVar = this.f10364u;
        fVar.getClass();
        return new d(fVar, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        f fVar = this.f10364u;
        fVar.b();
        int iG = fVar.g(obj);
        if (iG < 0) {
            return false;
        }
        fVar.k(iG);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        be.h.e(collection, "elements");
        this.f10364u.b();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        be.h.e(collection, "elements");
        this.f10364u.b();
        return super.retainAll(collection);
    }

    public i() {
        this(new f());
    }
}
