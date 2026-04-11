package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g1 implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Comparable f1047u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f1048v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d1 f1049w;

    public g1(d1 d1Var, Comparable comparable, Object obj) {
        this.f1049w = d1Var;
        this.f1047u = comparable;
        this.f1048v = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1047u.compareTo(((g1) obj).f1047u);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f1047u;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f1048v;
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
        return this.f1047u;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1048v;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f1047u;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f1048v;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f1049w.b();
        Object obj2 = this.f1048v;
        this.f1048v = obj;
        return obj2;
    }

    public final String toString() {
        return this.f1047u + "=" + this.f1048v;
    }
}
