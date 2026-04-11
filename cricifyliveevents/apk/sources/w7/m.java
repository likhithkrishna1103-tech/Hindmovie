package w7;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f14086a;

    public m(ArrayList arrayList) {
        this.f14086a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        return this.f14086a.equals(((m) ((w) obj)).f14086a);
    }

    public final int hashCode() {
        return this.f14086a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f14086a + "}";
    }
}
