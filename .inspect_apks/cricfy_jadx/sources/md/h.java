package md;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8438e;

    public h(int i, int i10, long j4, long j7, long j10) {
        this.f8434a = i;
        this.f8435b = i10;
        this.f8436c = j4;
        this.f8437d = j7;
        this.f8438e = j10;
    }

    public final long a() {
        return this.f8437d;
    }

    public final int b() {
        return this.f8434a;
    }

    public final int c() {
        return this.f8435b;
    }

    public final long d() {
        return this.f8436c;
    }

    public final boolean e() {
        return this.f8436c + this.f8438e == this.f8437d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f8434a == hVar.f8434a && this.f8435b == hVar.f8435b && this.f8436c == hVar.f8436c && this.f8437d == hVar.f8437d && this.f8438e == hVar.f8438e;
    }

    public final int hashCode() {
        int i = ((this.f8434a * 31) + this.f8435b) * 31;
        long j4 = this.f8436c;
        int i10 = (i + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j7 = this.f8437d;
        int i11 = (i10 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j10 = this.f8438e;
        return i11 + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        long j4 = this.f8438e;
        StringBuilder sbR = q4.a.r(this.f8434a, this.f8435b, "FileSlice(id=", ", position=", ", startBytes=");
        sbR.append(this.f8436c);
        sbR.append(", endBytes=");
        sbR.append(this.f8437d);
        sbR.append(", downloaded=");
        return q4.a.p(sbR, j4, ")");
    }
}
