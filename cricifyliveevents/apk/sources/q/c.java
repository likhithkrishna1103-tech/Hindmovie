package q;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Map.Entry {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f10310v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f10311w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f10312x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c f10313y;

    public c(Object obj, Object obj2) {
        this.f10310v = obj;
        this.f10311w = obj2;
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
        return this.f10310v.equals(cVar.f10310v) && this.f10311w.equals(cVar.f10311w);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f10310v;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f10311w;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f10310v.hashCode() ^ this.f10311w.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f10310v + "=" + this.f10311w;
    }
}
