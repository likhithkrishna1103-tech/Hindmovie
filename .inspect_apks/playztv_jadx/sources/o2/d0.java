package o2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9094e;

    public d0(Object obj) {
        this(-1L, obj);
    }

    public final d0 a(Object obj) {
        if (this.f9090a.equals(obj)) {
            return this;
        }
        return new d0(obj, this.f9091b, this.f9092c, this.f9093d, this.f9094e);
    }

    public final boolean b() {
        return this.f9091b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f9090a.equals(d0Var.f9090a) && this.f9091b == d0Var.f9091b && this.f9092c == d0Var.f9092c && this.f9093d == d0Var.f9093d && this.f9094e == d0Var.f9094e;
    }

    public final int hashCode() {
        return ((((((((this.f9090a.hashCode() + 527) * 31) + this.f9091b) * 31) + this.f9092c) * 31) + ((int) this.f9093d)) * 31) + this.f9094e;
    }

    public d0(long j5, Object obj) {
        this(obj, -1, -1, j5, -1);
    }

    public d0(int i, long j5, Object obj) {
        this(obj, -1, -1, j5, i);
    }

    public d0(Object obj, int i, int i10, long j5, int i11) {
        this.f9090a = obj;
        this.f9091b = i;
        this.f9092c = i10;
        this.f9093d = j5;
        this.f9094e = i11;
    }
}
