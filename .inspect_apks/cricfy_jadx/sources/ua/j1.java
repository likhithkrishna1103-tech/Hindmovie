package ua;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends i1 implements SortedSet {
    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.f12342v).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Iterator it = this.f12342v.iterator();
        it.getClass();
        ta.h hVar = this.f12343w;
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
        return new j1(((SortedSet) this.f12342v).headSet(obj), this.f12343w);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        SortedSet sortedSetHeadSet = (SortedSet) this.f12342v;
        while (true) {
            Object objLast = sortedSetHeadSet.last();
            if (this.f12343w.apply(objLast)) {
                return objLast;
            }
            sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
        }
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new j1(((SortedSet) this.f12342v).subSet(obj, obj2), this.f12343w);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new j1(((SortedSet) this.f12342v).tailSet(obj), this.f12343w);
    }
}
