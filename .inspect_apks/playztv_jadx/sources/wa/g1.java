package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13865a;

    public g1(List list) {
        this.f13865a = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        return this.f13865a.equals(((g1) ((i2) obj)).f13865a);
    }

    public final int hashCode() {
        return this.f13865a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f13865a + "}";
    }
}
