package ua;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k0 implements Map, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient m0 f12349v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient m0 f12350w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient d0 f12351x;

    public static k0 a(Map map) {
        if ((map instanceof k0) && !(map instanceof SortedMap)) {
            return (k0) map;
        }
        Set setEntrySet = map.entrySet();
        f3.a aVar = new f3.a(q4.a.v(setEntrySet) ? setEntrySet.size() : 4);
        aVar.v(setEntrySet);
        return (e1) aVar.c();
    }

    public abstract b1 b();

    public abstract c1 c();

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract d0 d();

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d0 values() {
        d0 d0Var = this.f12351x;
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0VarD = d();
        this.f12351x = d0VarD;
        return d0VarD;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        m0 m0Var = this.f12349v;
        if (m0Var != null) {
            return m0Var;
        }
        b1 b1VarB = b();
        this.f12349v = b1VarB;
        return b1VarB;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return q.g(this, obj);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        m0 m0VarB = this.f12349v;
        if (m0VarB == null) {
            m0VarB = b();
            this.f12349v = m0VarB;
        }
        return q.m(m0VarB);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        m0 m0Var = this.f12350w;
        if (m0Var != null) {
            return m0Var;
        }
        c1 c1VarC = c();
        this.f12350w = c1VarC;
        return c1VarC;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        q.d(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z10 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z10) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z10 = false;
        }
        sb.append('}');
        return sb.toString();
    }
}
