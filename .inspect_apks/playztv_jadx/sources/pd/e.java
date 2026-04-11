package pd;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Map.Entry, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f10351u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10352v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f10353w;

    public e(f fVar, int i) {
        be.h.e(fVar, "map");
        this.f10351u = fVar;
        this.f10352v = i;
        this.f10353w = fVar.B;
    }

    public final void a() {
        if (this.f10351u.B != this.f10353w) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return be.h.a(entry.getKey(), getKey()) && be.h.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f10351u.f10354u[this.f10352v];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f10351u.f10355v;
        be.h.b(objArr);
        return objArr[this.f10352v];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        f fVar = this.f10351u;
        fVar.b();
        Object[] objArr = fVar.f10355v;
        if (objArr == null) {
            int length = fVar.f10354u.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            fVar.f10355v = objArr;
        }
        int i = this.f10352v;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getKey());
        sb2.append('=');
        sb2.append(getValue());
        return sb2.toString();
    }
}
