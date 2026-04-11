package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l6 extends AbstractMap {
    public Map A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object[] f2516v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2517w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Map f2518x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2519y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile androidx.datastore.preferences.protobuf.z0 f2520z;

    public l6() {
        Map map = Collections.EMPTY_MAP;
        this.f2518x = map;
        this.A = map;
    }

    public final m6 a(int i) {
        if (i < this.f2517w) {
            return (m6) this.f2516v[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public final Set b() {
        return this.f2518x.isEmpty() ? Collections.EMPTY_SET : this.f2518x.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        f();
        int iE = e(comparable);
        if (iE >= 0) {
            return ((m6) this.f2516v[iE]).setValue(obj);
        }
        f();
        if (this.f2516v == null) {
            this.f2516v = new Object[16];
        }
        int i = -(iE + 1);
        if (i >= 16) {
            return g().put(comparable, obj);
        }
        if (this.f2517w == 16) {
            m6 m6Var = (m6) this.f2516v[15];
            this.f2517w = 15;
            g().put(m6Var.f2530v, m6Var.f2531w);
        }
        Object[] objArr = this.f2516v;
        int length = objArr.length;
        System.arraycopy(objArr, i, objArr, i + 1, 15 - i);
        this.f2516v[i] = new m6(this, comparable, obj);
        this.f2517w++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        f();
        if (this.f2517w != 0) {
            this.f2516v = null;
            this.f2517w = 0;
        }
        if (this.f2518x.isEmpty()) {
            return;
        }
        this.f2518x.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f2518x.containsKey(comparable);
    }

    public final Object d(int i) {
        f();
        Object[] objArr = this.f2516v;
        Object obj = ((m6) objArr[i]).f2531w;
        System.arraycopy(objArr, i + 1, objArr, i, (this.f2517w - i) - 1);
        this.f2517w--;
        if (!this.f2518x.isEmpty()) {
            Iterator it = g().entrySet().iterator();
            Object[] objArr2 = this.f2516v;
            int i10 = this.f2517w;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i10] = new m6(this, (Comparable) entry.getKey(), entry.getValue());
            this.f2517w++;
            it.remove();
        }
        return obj;
    }

    public final int e(Comparable comparable) {
        int i = this.f2517w;
        int i10 = i - 1;
        int i11 = 0;
        if (i10 >= 0) {
            int iCompareTo = comparable.compareTo(((m6) this.f2516v[i10]).f2530v);
            if (iCompareTo > 0) {
                return -(i + 1);
            }
            if (iCompareTo == 0) {
                return i10;
            }
        }
        while (i11 <= i10) {
            int i12 = (i11 + i10) / 2;
            int iCompareTo2 = comparable.compareTo(((m6) this.f2516v[i12]).f2530v);
            if (iCompareTo2 < 0) {
                i10 = i12 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i12;
                }
                i11 = i12 + 1;
            }
        }
        return -(i11 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f2520z == null) {
            this.f2520z = new androidx.datastore.preferences.protobuf.z0(this, 1);
        }
        return this.f2520z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l6)) {
            return super.equals(obj);
        }
        l6 l6Var = (l6) obj;
        int size = size();
        if (size == l6Var.size()) {
            int i = this.f2517w;
            if (i != l6Var.f2517w) {
                return entrySet().equals(l6Var.entrySet());
            }
            for (int i10 = 0; i10 < i; i10++) {
                if (a(i10).equals(l6Var.a(i10))) {
                }
            }
            if (i != size) {
                return this.f2518x.equals(l6Var.f2518x);
            }
            return true;
        }
        return false;
    }

    public final void f() {
        if (this.f2519y) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap g() {
        f();
        if (this.f2518x.isEmpty() && !(this.f2518x instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2518x = treeMap;
            this.A = treeMap.descendingMap();
        }
        return (SortedMap) this.f2518x;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        return iE >= 0 ? ((m6) this.f2516v[iE]).f2531w : this.f2518x.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = this.f2517w;
        int iHashCode = 0;
        for (int i10 = 0; i10 < i; i10++) {
            iHashCode += this.f2516v[i10].hashCode();
        }
        return this.f2518x.size() > 0 ? this.f2518x.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        if (iE >= 0) {
            return d(iE);
        }
        if (this.f2518x.isEmpty()) {
            return null;
        }
        return this.f2518x.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f2518x.size() + this.f2517w;
    }
}
