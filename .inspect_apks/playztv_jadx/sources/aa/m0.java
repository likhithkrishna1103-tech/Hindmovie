package aa;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 implements Map, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public transient o0 f710u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient o0 f711v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient e0 f712w;

    public static m0 a(Map map) {
        if ((map instanceof m0) && !(map instanceof SortedMap)) {
            return (m0) map;
        }
        Set<Map.Entry> setEntrySet = map.entrySet();
        l0 l0Var = new l0(setEntrySet != null ? setEntrySet.size() : 4);
        if (l4.a.v(setEntrySet)) {
            int size = (setEntrySet.size() + l0Var.f705v) * 2;
            Object[] objArr = (Object[]) l0Var.f706w;
            if (size > objArr.length) {
                l0Var.f706w = Arrays.copyOf(objArr, d0.f(objArr.length, size));
            }
        }
        for (Map.Entry entry : setEntrySet) {
            l0Var.v(entry.getKey(), entry.getValue());
        }
        return l0Var.d();
    }

    public abstract e1 b();

    public abstract f1 c();

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

    public abstract e0 d();

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e0 values() {
        e0 e0Var = this.f712w;
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0VarD = d();
        this.f712w = e0VarD;
        return e0VarD;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        o0 o0Var = this.f710u;
        if (o0Var != null) {
            return o0Var;
        }
        e1 e1VarB = b();
        this.f710u = e1VarB;
        return e1VarB;
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
        o0 o0VarB = this.f710u;
        if (o0VarB == null) {
            o0VarB = b();
            this.f710u = o0VarB;
        }
        return q.l(o0VarB);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        o0 o0Var = this.f711v;
        if (o0Var != null) {
            return o0Var;
        }
        f1 f1VarC = c();
        this.f711v = f1VarC;
        return f1VarC;
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
        q.c("size", size);
        StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb2.append('{');
        boolean z2 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z2) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z2 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }
}
