package p1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f9812c = new j(new o1());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9814e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9815a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9816b = 0;

    static {
        int i = s1.b0.f11647a;
        Integer.toString(0, 36);
        f9813d = Integer.toString(1, 36);
        f9814e = Integer.toString(2, 36);
        Integer.toString(3, 36);
    }

    public j(o1 o1Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f9815a == jVar.f9815a && this.f9816b == jVar.f9816b;
    }

    public final int hashCode() {
        return (((16337 + this.f9815a) * 31) + this.f9816b) * 31;
    }
}
