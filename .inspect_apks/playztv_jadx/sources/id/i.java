package id;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6583e;

    public i(int i, int i10, long j5, long j8, long j10) {
        this.f6579a = i;
        this.f6580b = i10;
        this.f6581c = j5;
        this.f6582d = j8;
        this.f6583e = j10;
    }

    public final long a() {
        return this.f6582d;
    }

    public final int b() {
        return this.f6579a;
    }

    public final int c() {
        return this.f6580b;
    }

    public final long d() {
        return this.f6581c;
    }

    public final boolean e() {
        return this.f6581c + this.f6583e == this.f6582d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f6579a == iVar.f6579a && this.f6580b == iVar.f6580b && this.f6581c == iVar.f6581c && this.f6582d == iVar.f6582d && this.f6583e == iVar.f6583e;
    }

    public final int hashCode() {
        int i = ((this.f6579a * 31) + this.f6580b) * 31;
        long j5 = this.f6581c;
        int i10 = (i + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j8 = this.f6582d;
        int i11 = (i10 + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        long j10 = this.f6583e;
        return i11 + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        long j5 = this.f6583e;
        StringBuilder sbP = l4.a.p(this.f6579a, this.f6580b, "FileSlice(id=", ", position=", ", startBytes=");
        sbP.append(this.f6581c);
        sbP.append(", endBytes=");
        sbP.append(this.f6582d);
        sbP.append(", downloaded=");
        return l4.a.n(sbP, j5, ")");
    }
}
