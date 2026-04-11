package s1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f11712c = new v(-1, -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11714b;

    static {
        new v(0, 0);
    }

    public v(int i, int i10) {
        d.b((i == -1 || i >= 0) && (i10 == -1 || i10 >= 0));
        this.f11713a = i;
        this.f11714b = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (this.f11713a == vVar.f11713a && this.f11714b == vVar.f11714b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f11713a;
        return ((i >>> 16) | (i << 16)) ^ this.f11714b;
    }

    public final String toString() {
        return this.f11713a + "x" + this.f11714b;
    }
}
