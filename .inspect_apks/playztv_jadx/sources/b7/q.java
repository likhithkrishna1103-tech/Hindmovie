package b7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f1896a;

    public q(Integer num) {
        this.f1896a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        Integer num = this.f1896a;
        q qVar = (q) ((d0) obj);
        return num == null ? qVar.f1896a == null : num.equals(qVar.f1896a);
    }

    public final int hashCode() {
        Integer num = this.f1896a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f1896a + "}";
    }
}
