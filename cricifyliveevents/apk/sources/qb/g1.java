package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10568a;

    public g1(List list) {
        this.f10568a = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        return this.f10568a.equals(((g1) ((i2) obj)).f10568a);
    }

    public final int hashCode() {
        return this.f10568a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f10568a + "}";
    }
}
