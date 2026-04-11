package v1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f12993a;

    public t0(n nVar) {
        this.f12993a = nVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t0) {
            return this.f12993a.equals(((t0) obj).f12993a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12993a.hashCode();
    }
}
