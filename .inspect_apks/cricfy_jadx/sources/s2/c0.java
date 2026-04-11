package s2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11160e;

    public c0(Object obj) {
        this(-1L, obj);
    }

    public final c0 a(Object obj) {
        if (this.f11156a.equals(obj)) {
            return this;
        }
        return new c0(obj, this.f11157b, this.f11158c, this.f11159d, this.f11160e);
    }

    public final boolean b() {
        return this.f11157b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f11156a.equals(c0Var.f11156a) && this.f11157b == c0Var.f11157b && this.f11158c == c0Var.f11158c && this.f11159d == c0Var.f11159d && this.f11160e == c0Var.f11160e;
    }

    public final int hashCode() {
        return ((((((((this.f11156a.hashCode() + 527) * 31) + this.f11157b) * 31) + this.f11158c) * 31) + ((int) this.f11159d)) * 31) + this.f11160e;
    }

    public c0(long j4, Object obj) {
        this(obj, -1, -1, j4, -1);
    }

    public c0(Object obj, long j4, int i) {
        this(obj, -1, -1, j4, i);
    }

    public c0(Object obj, int i, int i10, long j4, int i11) {
        this.f11156a = obj;
        this.f11157b = i;
        this.f11158c = i10;
        this.f11159d = j4;
        this.f11160e = i11;
    }
}
