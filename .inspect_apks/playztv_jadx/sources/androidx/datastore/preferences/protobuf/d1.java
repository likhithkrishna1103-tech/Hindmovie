package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends AbstractMap {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f1031u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f1032v = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map f1033w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1034x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile i1 f1035y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Map f1036z;

    public d1(int i) {
        this.f1031u = i;
        Map map = Collections.EMPTY_MAP;
        this.f1033w = map;
        this.f1036z = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f1032v
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f1032v
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.g1 r2 = (androidx.datastore.preferences.protobuf.g1) r2
            java.lang.Comparable r2 = r2.f1047u
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r5 = -r0
            return r5
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f1032v
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.g1 r3 = (androidx.datastore.preferences.protobuf.g1) r3
            java.lang.Comparable r3 = r3.f1047u
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.d1.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f1034x) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i) {
        return (Map.Entry) this.f1032v.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f1032v.isEmpty()) {
            this.f1032v.clear();
        }
        if (this.f1033w.isEmpty()) {
            return;
        }
        this.f1033w.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f1033w.containsKey(comparable);
    }

    public final Iterable d() {
        return this.f1033w.isEmpty() ? r0.f1109b : this.f1033w.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f1033w.isEmpty() && !(this.f1033w instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f1033w = treeMap;
            this.f1036z = treeMap.descendingMap();
        }
        return (SortedMap) this.f1033w;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f1035y == null) {
            this.f1035y = new i1(this, 0);
        }
        return this.f1035y;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return super.equals(obj);
        }
        d1 d1Var = (d1) obj;
        int size = size();
        if (size == d1Var.size()) {
            int size2 = this.f1032v.size();
            if (size2 != d1Var.f1032v.size()) {
                return ((AbstractSet) entrySet()).equals(d1Var.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (c(i).equals(d1Var.c(i))) {
                }
            }
            if (size2 != size) {
                return this.f1033w.equals(d1Var.f1033w);
            }
            return true;
        }
        return false;
    }

    public final Object f(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((g1) this.f1032v.get(iA)).setValue(obj);
        }
        b();
        boolean zIsEmpty = this.f1032v.isEmpty();
        int i = this.f1031u;
        if (zIsEmpty && !(this.f1032v instanceof ArrayList)) {
            this.f1032v = new ArrayList(i);
        }
        int i10 = -(iA + 1);
        if (i10 >= i) {
            return e().put(comparable, obj);
        }
        if (this.f1032v.size() == i) {
            g1 g1Var = (g1) this.f1032v.remove(i - 1);
            e().put(g1Var.f1047u, g1Var.f1048v);
        }
        this.f1032v.add(i10, new g1(this, comparable, obj));
        return null;
    }

    public final Object g(int i) {
        b();
        Object obj = ((g1) this.f1032v.remove(i)).f1048v;
        if (!this.f1033w.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f1032v;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new g1(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((g1) this.f1032v.get(iA)).f1048v : this.f1033w.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f1032v.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((g1) this.f1032v.get(i)).hashCode();
        }
        return this.f1033w.size() > 0 ? this.f1033w.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* synthetic */ Object put(Object obj, Object obj2) {
        if (obj == null) {
            return f(null, obj2);
        }
        throw new ClassCastException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return g(iA);
        }
        if (this.f1033w.isEmpty()) {
            return null;
        }
        return this.f1033w.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f1033w.size() + this.f1032v.size();
    }
}
