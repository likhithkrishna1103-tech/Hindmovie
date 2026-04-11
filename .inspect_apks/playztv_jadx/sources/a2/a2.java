package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a2 f155c = new a2(0, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f157b;

    public a2(int i, boolean z2) {
        this.f156a = i;
        this.f157b = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a2.class == obj.getClass()) {
            a2 a2Var = (a2) obj;
            if (this.f156a == a2Var.f156a && this.f157b == a2Var.f157b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f156a << 1) + (this.f157b ? 1 : 0);
    }
}
