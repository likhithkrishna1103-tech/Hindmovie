package v1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n1 f12880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12881c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ua.i0 f12882a;

    static {
        ua.g0 g0Var = ua.i0.f12341w;
        f12880b = new n1(ua.z0.f12413z);
        int i = y1.a0.f14551a;
        f12881c = Integer.toString(0, 36);
    }

    public n1(ua.z0 z0Var) {
        this.f12882a = ua.i0.k(z0Var);
    }

    public final boolean a(int i) {
        int i10 = 0;
        while (true) {
            ua.i0 i0Var = this.f12882a;
            if (i10 >= i0Var.size()) {
                return false;
            }
            m1 m1Var = (m1) i0Var.get(i10);
            boolean[] zArr = m1Var.f12876e;
            int length = zArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (!zArr[i11]) {
                    i11++;
                } else if (m1Var.f12873b.f12704c == i) {
                    return true;
                }
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n1.class != obj.getClass()) {
            return false;
        }
        return this.f12882a.equals(((n1) obj).f12882a);
    }

    public final int hashCode() {
        return this.f12882a.hashCode();
    }
}
