package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14050c;

    public v0(String str, int i, List list) {
        this.f14048a = str;
        this.f14049b = i;
        this.f14050c = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a2) {
            v0 v0Var = (v0) ((a2) obj);
            if (this.f14048a.equals(v0Var.f14048a) && this.f14049b == v0Var.f14049b && this.f14050c.equals(v0Var.f14050c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f14048a.hashCode() ^ 1000003) * 1000003) ^ this.f14049b) * 1000003) ^ this.f14050c.hashCode();
    }

    public final String toString() {
        return "Thread{name=" + this.f14048a + ", importance=" + this.f14049b + ", frames=" + this.f14050c + "}";
    }
}
