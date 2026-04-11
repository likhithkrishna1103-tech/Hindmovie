package p;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Map.Entry {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f9596u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f9597v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f9598w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f9599x;

    public c(Object obj, Object obj2) {
        this.f9596u = obj;
        this.f9597v = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f9596u.equals(cVar.f9596u) && this.f9597v.equals(cVar.f9597v);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9596u;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9597v;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f9596u.hashCode() ^ this.f9597v.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f9596u + "=" + this.f9597v;
    }
}
