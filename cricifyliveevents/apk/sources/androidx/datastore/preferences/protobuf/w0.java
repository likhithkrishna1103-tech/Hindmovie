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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends AbstractMap {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f803v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map f804w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f805x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile z0 f806y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Map f807z;

    public static w0 f() {
        w0 w0Var = new w0();
        w0Var.f803v = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        w0Var.f804w = map;
        w0Var.f807z = map;
        return w0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f803v
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f803v
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.x0 r2 = (androidx.datastore.preferences.protobuf.x0) r2
            java.lang.Comparable r2 = r2.f810v
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
            java.util.List r3 = r4.f803v
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.x0 r3 = (androidx.datastore.preferences.protobuf.x0) r3
            java.lang.Comparable r3 = r3.f810v
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.w0.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f805x) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i) {
        return (Map.Entry) this.f803v.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f803v.isEmpty()) {
            this.f803v.clear();
        }
        if (this.f804w.isEmpty()) {
            return;
        }
        this.f804w.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f804w.containsKey(comparable);
    }

    public final Set d() {
        return this.f804w.isEmpty() ? Collections.EMPTY_SET : this.f804w.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f804w.isEmpty() && !(this.f804w instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f804w = treeMap;
            this.f807z = treeMap.descendingMap();
        }
        return (SortedMap) this.f804w;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f806y == null) {
            this.f806y = new z0(this, 0);
        }
        return this.f806y;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return super.equals(obj);
        }
        w0 w0Var = (w0) obj;
        int size = size();
        if (size == w0Var.size()) {
            int size2 = this.f803v.size();
            if (size2 != w0Var.f803v.size()) {
                return ((AbstractSet) entrySet()).equals(w0Var.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (c(i).equals(w0Var.c(i))) {
                }
            }
            if (size2 != size) {
                return this.f804w.equals(w0Var.f804w);
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((x0) this.f803v.get(iA)).setValue(obj);
        }
        b();
        if (this.f803v.isEmpty() && !(this.f803v instanceof ArrayList)) {
            this.f803v = new ArrayList(16);
        }
        int i = -(iA + 1);
        if (i >= 16) {
            return e().put(comparable, obj);
        }
        if (this.f803v.size() == 16) {
            x0 x0Var = (x0) this.f803v.remove(15);
            e().put(x0Var.f810v, x0Var.f811w);
        }
        this.f803v.add(i, new x0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((x0) this.f803v.get(iA)).f811w : this.f804w.get(comparable);
    }

    public final Object h(int i) {
        b();
        Object obj = ((x0) this.f803v.remove(i)).f811w;
        if (!this.f804w.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f803v;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new x0(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f803v.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((x0) this.f803v.get(i)).hashCode();
        }
        return this.f804w.size() > 0 ? this.f804w.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.f804w.isEmpty()) {
            return null;
        }
        return this.f804w.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f804w.size() + this.f803v.size();
    }
}
