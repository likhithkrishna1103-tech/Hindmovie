package aa;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends a1 implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a1 f691u;

    public j1(a1 a1Var) {
        this.f691u = a1Var;
    }

    @Override // aa.a1
    public final a1 a() {
        return this.f691u;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f691u.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j1) {
            return this.f691u.equals(((j1) obj).f691u);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f691u.hashCode();
    }

    public final String toString() {
        return this.f691u + ".reverse()";
    }
}
