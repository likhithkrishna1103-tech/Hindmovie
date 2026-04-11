package b2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ua.i1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends ua.q implements Map {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map f1730w;

    public s(Map map) {
        this.f1730w = map;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f1730w.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return obj != null && this.f1730w.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        Iterator it = ((i1) entrySet()).iterator();
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

    @Override // java.util.Map
    public final Set entrySet() {
        return ua.q.j(this.f1730w.entrySet(), new r(0));
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj != null && ua.q.g(this, obj);
    }

    @Override // ua.q
    public final Object f() {
        return this.f1730w;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.f1730w.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return ua.q.m(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        Map map = this.f1730w;
        return map.isEmpty() || (map.size() == 1 && map.containsKey(null));
    }

    @Override // java.util.Map
    public final Set keySet() {
        return ua.q.j(this.f1730w.keySet(), new r(1));
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f1730w.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.f1730w.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f1730w.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        Map map = this.f1730w;
        return map.size() - (map.containsKey(null) ? 1 : 0);
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f1730w.values();
    }
}
