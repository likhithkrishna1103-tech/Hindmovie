package aa;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class j extends e implements SortedSet {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ x0 f689w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(x0 x0Var, SortedMap sortedMap) {
        super(x0Var, sortedMap);
        this.f689w = x0Var;
    }

    public SortedMap b() {
        return (SortedMap) this.f661u;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return b().comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return b().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new j(this.f689w, b().headMap(obj));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return b().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new j(this.f689w, b().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new j(this.f689w, b().tailMap(obj));
    }
}
