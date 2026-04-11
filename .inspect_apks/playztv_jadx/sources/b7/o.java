package b7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f1893a;

    public o(r rVar) {
        a0 a0Var = a0.f1829u;
        this.f1893a = rVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        if (!this.f1893a.equals(((o) ((b0) obj)).f1893a)) {
            return false;
        }
        Object obj2 = a0.f1829u;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return ((this.f1893a.hashCode() ^ 1000003) * 1000003) ^ a0.f1829u.hashCode();
    }

    public final String toString() {
        return "ComplianceData{privacyContext=" + this.f1893a + ", productIdOrigin=" + a0.f1829u + "}";
    }
}
