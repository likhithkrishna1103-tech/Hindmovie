package v1;

import aa.l1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends aa.q implements Map {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map f13171v;

    public p(Map map) {
        this.f13171v = map;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f13171v.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return obj != null && this.f13171v.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        Iterator it = ((l1) entrySet()).iterator();
        it.getClass();
        if (obj == null) {
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getValue() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(((Map.Entry) it.next()).getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // aa.q
    public final Object e() {
        return this.f13171v;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return aa.q.i(this.f13171v.entrySet(), new o(0));
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj != null && aa.q.g(this, obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.f13171v.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return aa.q.l(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        Map map = this.f13171v;
        return map.isEmpty() || (map.size() == 1 && map.containsKey(null));
    }

    @Override // java.util.Map
    public final Set keySet() {
        return aa.q.i(this.f13171v.keySet(), new o(1));
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f13171v.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.f13171v.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f13171v.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        Map map = this.f13171v;
        return map.size() - (map.containsKey(null) ? 1 : 0);
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f13171v.values();
    }
}
