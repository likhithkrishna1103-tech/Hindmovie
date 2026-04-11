package k2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6871d;

    public j(long j4, long j7, String str) {
        this.f6870c = str == null ? "" : str;
        this.f6868a = j4;
        this.f6869b = j7;
    }

    public final j a(j jVar, String str) {
        j jVar2;
        long j4;
        String strN = y1.b.n(str, this.f6870c);
        if (jVar != null) {
            long j7 = jVar.f6869b;
            if (strN.equals(y1.b.n(str, jVar.f6870c))) {
                long j10 = this.f6869b;
                if (j10 != -1) {
                    j4 = j7;
                    long j11 = this.f6868a;
                    jVar2 = null;
                    if (j11 + j10 == jVar.f6868a) {
                        return new j(j11, j4 != -1 ? j10 + j4 : -1L, strN);
                    }
                } else {
                    jVar2 = null;
                    j4 = j7;
                }
                if (j4 == -1) {
                    return jVar2;
                }
                long j12 = jVar.f6868a;
                if (j12 + j4 == this.f6868a) {
                    return new j(j12, j10 != -1 ? j4 + j10 : -1L, strN);
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
            if (this.f6868a == jVar.f6868a && this.f6869b == jVar.f6869b && this.f6870c.equals(jVar.f6870c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f6871d == 0) {
            this.f6871d = this.f6870c.hashCode() + ((((527 + ((int) this.f6868a)) * 31) + ((int) this.f6869b)) * 31);
        }
        return this.f6871d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RangedUri(referenceUri=");
        sb.append(this.f6870c);
        sb.append(", start=");
        sb.append(this.f6868a);
        sb.append(", length=");
        return q4.a.p(sb, this.f6869b, ")");
    }
}
