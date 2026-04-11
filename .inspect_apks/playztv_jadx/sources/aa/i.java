package aa;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class i extends d implements SortedMap {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SortedSet f681y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ x0 f682z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(x0 x0Var, SortedMap sortedMap) {
        super(x0Var, sortedMap);
        this.f682z = x0Var;
    }

    public SortedSet b() {
        return new j(this.f682z, d());
    }

    @Override // aa.d, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.f681y;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetB = b();
        this.f681y = sortedSetB;
        return sortedSetB;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return d().comparator();
    }

    public SortedMap d() {
        return (SortedMap) this.f655w;
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return d().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new i(this.f682z, d().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return d().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new i(this.f682z, d().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new i(this.f682z, d().tailMap(obj));
    }
}
