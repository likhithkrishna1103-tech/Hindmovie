package aa;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v extends a1 implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c4.d f757u;

    public v(c4.d dVar) {
        this.f757u = dVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f757u.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            return this.f757u.equals(((v) obj).f757u);
        }
        return false;
    }

    public final int hashCode() {
        return this.f757u.hashCode();
    }

    public final String toString() {
        return this.f757u.toString();
    }
}
