package androidx.navigation;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1395b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.f1394a == rVar.f1394a && this.f1395b == rVar.f1395b;
    }

    public final int hashCode() {
        return (((((this.f1394a * 31) + (this.f1395b ? 1 : 0)) * 29791) - 1) * 31) - 1;
    }
}
