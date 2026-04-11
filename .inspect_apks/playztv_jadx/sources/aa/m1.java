package aa;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m1 extends l1 implements SortedSet {
    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.f708u).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Iterator it = this.f708u.iterator();
        it.getClass();
        z9.h hVar = this.f709v;
        hVar.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (hVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new m1(((SortedSet) this.f708u).headSet(obj), this.f709v);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        SortedSet sortedSetHeadSet = (SortedSet) this.f708u;
        while (true) {
            Object objLast = sortedSetHeadSet.last();
            if (this.f709v.apply(objLast)) {
                return objLast;
            }
            sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
        }
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new m1(((SortedSet) this.f708u).subSet(obj, obj2), this.f709v);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new m1(((SortedSet) this.f708u).tailSet(obj), this.f709v);
    }
}
