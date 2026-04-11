package w7;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f14091a;

    public q(Integer num) {
        this.f14091a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        Integer num = this.f14091a;
        q qVar = (q) ((c0) obj);
        return num == null ? qVar.f14091a == null : num.equals(qVar.f14091a);
    }

    public final int hashCode() {
        Integer num = this.f14091a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f14091a + "}";
    }
}
