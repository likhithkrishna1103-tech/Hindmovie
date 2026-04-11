package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Comparable f810v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f811w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ w0 f812x;

    public x0(w0 w0Var, Comparable comparable, Object obj) {
        this.f812x = w0Var;
        this.f810v = comparable;
        this.f811w = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f810v.compareTo(((x0) obj).f810v);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f810v;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f811w;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f810v;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f811w;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f810v;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f811w;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f812x.b();
        Object obj2 = this.f811w;
        this.f811w = obj;
        return obj2;
    }

    public final String toString() {
        return this.f810v + "=" + this.f811w;
    }
}
