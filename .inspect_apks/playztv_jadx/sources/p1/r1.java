package p1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r1 f10046d = new r1(0, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10047e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10048g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10051c;

    static {
        int i = s1.b0.f11647a;
        f10047e = Integer.toString(0, 36);
        f = Integer.toString(1, 36);
        f10048g = Integer.toString(3, 36);
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
            if (this.f10049a == r1Var.f10049a && this.f10050b == r1Var.f10050b && this.f10051c == r1Var.f10051c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f10051c) + ((((217 + this.f10049a) * 31) + this.f10050b) * 31);
    }

    public r1(float f4, int i, int i10) {
        this.f10049a = i;
        this.f10050b = i10;
        this.f10051c = f4;
    }
}
