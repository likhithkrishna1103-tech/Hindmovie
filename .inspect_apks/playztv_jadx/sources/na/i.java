package na;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f8897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8898b;

    public i(r rVar, boolean z2) {
        this.f8897a = rVar;
        this.f8898b = z2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.f8897a.equals(this.f8897a) && iVar.f8898b == this.f8898b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f8897a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f8898b).hashCode();
    }
}
