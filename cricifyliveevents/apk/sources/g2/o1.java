package g2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o1 f4851c = new o1(0, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4853b;

    public o1(int i, boolean z10) {
        this.f4852a = i;
        this.f4853b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o1.class == obj.getClass()) {
            o1 o1Var = (o1) obj;
            if (this.f4852a == o1Var.f4852a && this.f4853b == o1Var.f4853b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f4852a << 1) + (this.f4853b ? 1 : 0);
    }
}
