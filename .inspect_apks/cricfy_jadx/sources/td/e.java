package td;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Map.Entry, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f12003v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f12004w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f12005x;

    public e(f fVar, int i) {
        ge.i.e(fVar, "map");
        this.f12003v = fVar;
        this.f12004w = i;
        this.f12005x = fVar.C;
    }

    public final void a() {
        if (this.f12003v.C != this.f12005x) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return ge.i.a(entry.getKey(), getKey()) && ge.i.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f12003v.f12006v[this.f12004w];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f12003v.f12007w;
        ge.i.b(objArr);
        return objArr[this.f12004w];
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
        f fVar = this.f12003v;
        fVar.c();
        Object[] objArr = fVar.f12007w;
        if (objArr == null) {
            int length = fVar.f12006v.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            fVar.f12007w = objArr;
        }
        int i = this.f12004w;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
