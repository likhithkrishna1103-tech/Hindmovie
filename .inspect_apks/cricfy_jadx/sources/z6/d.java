package z6;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements x6.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x6.e f15242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x6.e f15243c;

    public d(x6.e eVar, x6.e eVar2) {
        this.f15242b = eVar;
        this.f15243c = eVar2;
    }

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        this.f15242b.a(messageDigest);
        this.f15243c.a(messageDigest);
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f15242b.equals(dVar.f15242b) && this.f15243c.equals(dVar.f15243c)) {
                return true;
            }
        }
        return false;
    }

    @Override // x6.e
    public final int hashCode() {
        return this.f15243c.hashCode() + (this.f15242b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f15242b + ", signature=" + this.f15243c + '}';
    }
}
