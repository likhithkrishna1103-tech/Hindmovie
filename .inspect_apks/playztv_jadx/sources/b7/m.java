package b7;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1891a;

    public m(ArrayList arrayList) {
        this.f1891a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        return this.f1891a.equals(((m) ((x) obj)).f1891a);
    }

    public final int hashCode() {
        return this.f1891a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f1891a + "}";
    }
}
