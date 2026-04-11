package aa;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class d extends AbstractMap {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public transient b f653u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient n f654v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final transient Map f655w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ x0 f656x;

    public d(x0 x0Var, Map map) {
        this.f656x = x0Var;
        this.f655w = map;
    }

    public final f0 a(Map.Entry entry) {
        Object key = entry.getKey();
        List list = (List) ((Collection) entry.getValue());
        boolean z2 = list instanceof RandomAccess;
        x0 x0Var = this.f656x;
        return new f0(key, z2 ? new h(x0Var, key, list, null) : new l(x0Var, key, list, null));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        x0 x0Var = this.f656x;
        if (this.f655w == x0Var.f760x) {
            x0Var.b();
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
        Map map = this.f655w;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        b bVar = this.f653u;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f653u = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f655w.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Map map = this.f655w;
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
        boolean z2 = list instanceof RandomAccess;
        x0 x0Var = this.f656x;
        return z2 ? new h(x0Var, obj, list, null) : new l(x0Var, obj, list, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f655w.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        x0 x0Var = this.f656x;
        Set set = x0Var.f715u;
        if (set != null) {
            return set;
        }
        Map map = x0Var.f760x;
        Set gVar = map instanceof NavigableMap ? new g(x0Var, (NavigableMap) map) : map instanceof SortedMap ? new j(x0Var, (SortedMap) map) : new e(x0Var, map);
        x0Var.f715u = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Collection collection = (Collection) this.f655w.remove(obj);
        if (collection == null) {
            return null;
        }
        x0 x0Var = this.f656x;
        Collection collectionC = x0Var.c();
        collectionC.addAll(collection);
        x0Var.f761y -= collection.size();
        collection.clear();
        return collectionC;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f655w.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f655w.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        n nVar = this.f654v;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this);
        this.f654v = nVar2;
        return nVar2;
    }
}
