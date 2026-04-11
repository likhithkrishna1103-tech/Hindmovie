package wa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13971e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13973h;
    public final String i;

    public n0(int i, String str, int i10, long j5, long j8, boolean z2, int i11, String str2, String str3) {
        this.f13967a = i;
        this.f13968b = str;
        this.f13969c = i10;
        this.f13970d = j5;
        this.f13971e = j8;
        this.f = z2;
        this.f13972g = i11;
        this.f13973h = str2;
        this.i = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v1) {
            n0 n0Var = (n0) ((v1) obj);
            if (this.f13967a == n0Var.f13967a && this.f13968b.equals(n0Var.f13968b) && this.f13969c == n0Var.f13969c && this.f13970d == n0Var.f13970d && this.f13971e == n0Var.f13971e && this.f == n0Var.f && this.f13972g == n0Var.f13972g && this.f13973h.equals(n0Var.f13973h) && this.i.equals(n0Var.i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f13967a ^ 1000003) * 1000003) ^ this.f13968b.hashCode()) * 1000003) ^ this.f13969c) * 1000003;
        long j5 = this.f13970d;
        int i = (iHashCode ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j8 = this.f13971e;
        return ((((((((i ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.f13972g) * 1000003) ^ this.f13973h.hashCode()) * 1000003) ^ this.i.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Device{arch=");
        sb2.append(this.f13967a);
        sb2.append(", model=");
        sb2.append(this.f13968b);
        sb2.append(", cores=");
        sb2.append(this.f13969c);
        sb2.append(", ram=");
        sb2.append(this.f13970d);
        sb2.append(", diskSpace=");
        sb2.append(this.f13971e);
        sb2.append(", simulator=");
        sb2.append(this.f);
        sb2.append(", state=");
        sb2.append(this.f13972g);
        sb2.append(", manufacturer=");
        sb2.append(this.f13973h);
        sb2.append(", modelClass=");
        return l4.a.o(sb2, this.i, "}");
    }
}
