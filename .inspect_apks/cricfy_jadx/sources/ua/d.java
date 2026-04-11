package ua;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class d extends AbstractMap {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient b f12314v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient n f12315w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Map f12316x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ v0 f12317y;

    public d(v0 v0Var, Map map) {
        this.f12317y = v0Var;
        this.f12316x = map;
    }

    public final e0 a(Map.Entry entry) {
        Object key = entry.getKey();
        List list = (List) ((Collection) entry.getValue());
        boolean z10 = list instanceof RandomAccess;
        v0 v0Var = this.f12317y;
        return new e0(key, z10 ? new h(v0Var, key, list, null) : new l(v0Var, key, list, null));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        v0 v0Var = this.f12317y;
        if (this.f12316x == v0Var.f12401y) {
            v0Var.b();
            return;
        }
        c cVar = new c(this);
        while (cVar.hasNext()) {
            cVar.next();
            cVar.remove();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.f12316x;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        b bVar = this.f12314v;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f12314v = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f12316x.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Map map = this.f12316x;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        List list = (List) collection;
        boolean z10 = list instanceof RandomAccess;
        v0 v0Var = this.f12317y;
        return z10 ? new h(v0Var, obj, list, null) : new l(v0Var, obj, list, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f12316x.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        v0 v0Var = this.f12317y;
        Set set = v0Var.f12368v;
        if (set != null) {
            return set;
        }
        Map map = v0Var.f12401y;
        Set gVar = map instanceof NavigableMap ? new g(v0Var, (NavigableMap) map) : map instanceof SortedMap ? new j(v0Var, (SortedMap) map) : new e(v0Var, map);
        v0Var.f12368v = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Collection collection = (Collection) this.f12316x.remove(obj);
        if (collection == null) {
            return null;
        }
        v0 v0Var = this.f12317y;
        Collection collectionC = v0Var.c();
        collectionC.addAll(collection);
        v0Var.f12402z -= collection.size();
        collection.clear();
        return collectionC;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f12316x.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f12316x.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        n nVar = this.f12315w;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this);
        this.f12315w = nVar2;
        return nVar2;
    }
}
