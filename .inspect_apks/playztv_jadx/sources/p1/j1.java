package p1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j1 f9860d = new j1(new i1());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9861e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9862g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9865c;

    static {
        int i = s1.b0.f11647a;
        f9861e = Integer.toString(1, 36);
        f = Integer.toString(2, 36);
        f9862g = Integer.toString(3, 36);
    }

    public j1(i1 i1Var) {
        this.f9863a = i1Var.f9809a;
        this.f9864b = i1Var.f9810b;
        this.f9865c = i1Var.f9811c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j1.class == obj.getClass()) {
            j1 j1Var = (j1) obj;
            if (this.f9863a == j1Var.f9863a && this.f9864b == j1Var.f9864b && this.f9865c == j1Var.f9865c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f9863a + 31) * 31) + (this.f9864b ? 1 : 0)) * 31) + (this.f9865c ? 1 : 0);
    }
}
