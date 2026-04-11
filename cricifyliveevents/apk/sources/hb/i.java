package hb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f5893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5894b;

    public i(r rVar, boolean z10) {
        this.f5893a = rVar;
        this.f5894b = z10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.f5893a.equals(this.f5893a) && iVar.f5894b == this.f5894b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f5893a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f5894b).hashCode();
    }
}
