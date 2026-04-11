package v1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j1 f12789d = new j1(new i1());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12790e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12791g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12794c;

    static {
        int i = y1.a0.f14551a;
        f12790e = Integer.toString(1, 36);
        f = Integer.toString(2, 36);
        f12791g = Integer.toString(3, 36);
    }

    public j1(i1 i1Var) {
        this.f12792a = i1Var.f12742a;
        this.f12793b = i1Var.f12743b;
        this.f12794c = i1Var.f12744c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j1.class == obj.getClass()) {
            j1 j1Var = (j1) obj;
            if (this.f12792a == j1Var.f12792a && this.f12793b == j1Var.f12793b && this.f12794c == j1Var.f12794c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f12792a + 31) * 31) + (this.f12793b ? 1 : 0)) * 31) + (this.f12794c ? 1 : 0);
    }
}
