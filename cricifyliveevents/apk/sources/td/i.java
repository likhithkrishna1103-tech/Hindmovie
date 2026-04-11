package td;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends sd.f implements Serializable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final i f12014w;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f12015v;

    static {
        f fVar = f.I;
        f12014w = new i(f.I);
    }

    public i(f fVar) {
        ge.i.e(fVar, "backing");
        this.f12015v = fVar;
    }

    @Override // sd.f
    public final int a() {
        return this.f12015v.D;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.f12015v.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        ge.i.e(collection, "elements");
        this.f12015v.c();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f12015v.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f12015v.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f12015v.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        f fVar = this.f12015v;
        fVar.getClass();
        return new d(fVar, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        f fVar = this.f12015v;
        fVar.c();
        int iH = fVar.h(obj);
        if (iH < 0) {
            return false;
        }
        fVar.l(iH);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        ge.i.e(collection, "elements");
        this.f12015v.c();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        ge.i.e(collection, "elements");
        this.f12015v.c();
        return super.retainAll(collection);
    }

    public i() {
        this(new f());
    }
}
