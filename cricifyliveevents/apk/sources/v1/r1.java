package v1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r1 f12978d = new r1(0, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12979e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12980g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f12983c;

    static {
        int i = y1.a0.f14551a;
        f12979e = Integer.toString(0, 36);
        f = Integer.toString(1, 36);
        f12980g = Integer.toString(3, 36);
    }

    public r1(int i, int i10) {
        this(1.0f, i, i10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            if (this.f12981a == r1Var.f12981a && this.f12982b == r1Var.f12982b && this.f12983c == r1Var.f12983c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f12983c) + ((((217 + this.f12981a) * 31) + this.f12982b) * 31);
    }

    public r1(float f10, int i, int i10) {
        this.f12981a = i;
        this.f12982b = i10;
        this.f12983c = f10;
    }
}
