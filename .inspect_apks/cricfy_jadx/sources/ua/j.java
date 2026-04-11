package ua;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class j extends e implements SortedSet {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ v0 f12344x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(v0 v0Var, SortedMap sortedMap) {
        super(v0Var, sortedMap);
        this.f12344x = v0Var;
    }

    public SortedMap a() {
        return (SortedMap) this.f12322v;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return a().comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return a().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new j(this.f12344x, a().headMap(obj));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return a().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new j(this.f12344x, a().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new j(this.f12344x, a().tailMap(obj));
    }
}
