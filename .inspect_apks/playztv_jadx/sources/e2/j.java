package e2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4340d;

    public j(long j5, long j8, String str) {
        this.f4339c = str == null ? "" : str;
        this.f4337a = j5;
        this.f4338b = j8;
    }

    public final j a(j jVar, String str) {
        j jVar2;
        long j5;
        String strN = s1.b.n(str, this.f4339c);
        if (jVar != null) {
            long j8 = jVar.f4338b;
            if (strN.equals(s1.b.n(str, jVar.f4339c))) {
                long j10 = this.f4338b;
                if (j10 != -1) {
                    j5 = j8;
                    long j11 = this.f4337a;
                    jVar2 = null;
                    if (j11 + j10 == jVar.f4337a) {
                        return new j(j11, j5 != -1 ? j10 + j5 : -1L, strN);
                    }
                } else {
                    jVar2 = null;
                    j5 = j8;
                }
                if (j5 == -1) {
                    return jVar2;
                }
                long j12 = jVar.f4337a;
                if (j12 + j5 == this.f4337a) {
                    return new j(j12, j10 != -1 ? j5 + j10 : -1L, strN);
                }
                return jVar2;
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            j jVar = (j) obj;
            if (this.f4337a == jVar.f4337a && this.f4338b == jVar.f4338b && this.f4339c.equals(jVar.f4339c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f4340d == 0) {
            this.f4340d = this.f4339c.hashCode() + ((((527 + ((int) this.f4337a)) * 31) + ((int) this.f4338b)) * 31);
        }
        return this.f4340d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RangedUri(referenceUri=");
        sb2.append(this.f4339c);
        sb2.append(", start=");
        sb2.append(this.f4337a);
        sb2.append(", length=");
        return l4.a.n(sb2, this.f4338b, ")");
    }
}
