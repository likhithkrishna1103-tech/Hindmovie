package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements s0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f7700u;

    public j0(boolean z2) {
        this.f7700u = z2;
    }

    @Override // ke.s0
    public final boolean a() {
        return this.f7700u;
    }

    @Override // ke.s0
    public final e1 d() {
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Empty{");
        sb2.append(this.f7700u ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
