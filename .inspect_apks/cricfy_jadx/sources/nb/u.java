package nb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9007b;

    public u(String str, String str2) {
        this.f9006a = str;
        this.f9007b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return ge.i.a(this.f9006a, uVar.f9006a) && ge.i.a(this.f9007b, uVar.f9007b);
    }

    public final int hashCode() {
        String str = this.f9006a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f9007b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "FirebaseInstallationId(fid=" + this.f9006a + ", authToken=" + this.f9007b + ')';
    }
}
