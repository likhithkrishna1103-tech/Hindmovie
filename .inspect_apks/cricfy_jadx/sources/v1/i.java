package v1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f12713c = new i(new o1());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12715e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12716a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12717b = 0;

    static {
        int i = y1.a0.f14551a;
        Integer.toString(0, 36);
        f12714d = Integer.toString(1, 36);
        f12715e = Integer.toString(2, 36);
        Integer.toString(3, 36);
    }

    public i(o1 o1Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f12716a == iVar.f12716a && this.f12717b == iVar.f12717b;
    }

    public final int hashCode() {
        return (((16337 + this.f12716a) * 31) + this.f12717b) * 31;
    }
}
