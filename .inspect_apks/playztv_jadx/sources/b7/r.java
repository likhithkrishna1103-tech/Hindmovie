package b7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f1897a;

    public r(q qVar) {
        this.f1897a = qVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        return this.f1897a.equals(((r) ((e0) obj)).f1897a);
    }

    public final int hashCode() {
        return this.f1897a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f1897a + "}";
    }
}
