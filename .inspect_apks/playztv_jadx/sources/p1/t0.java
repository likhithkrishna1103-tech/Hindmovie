package p1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f10063a;

    public t0(o oVar) {
        this.f10063a = oVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t0) {
            return this.f10063a.equals(((t0) obj).f10063a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10063a.hashCode();
    }
}
