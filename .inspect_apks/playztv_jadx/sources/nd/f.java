package nd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f8983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f8984v;

    public f(Object obj, Object obj2) {
        this.f8983u = obj;
        this.f8984v = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return be.h.a(this.f8983u, fVar.f8983u) && be.h.a(this.f8984v, fVar.f8984v);
    }

    public final int hashCode() {
        Object obj = this.f8983u;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f8984v;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f8983u + ", " + this.f8984v + ')';
    }
}
