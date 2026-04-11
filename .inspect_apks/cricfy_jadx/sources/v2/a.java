package v2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13068b;

    public a(long j4, long j7) {
        this.f13067a = j4;
        this.f13068b = j7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f13067a == aVar.f13067a && this.f13068b == aVar.f13068b;
    }

    public final int hashCode() {
        return (((int) this.f13067a) * 31) + ((int) this.f13068b);
    }
}
