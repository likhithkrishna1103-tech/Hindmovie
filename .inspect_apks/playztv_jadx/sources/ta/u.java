package ta;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12431b;

    public u(String str, String str2) {
        this.f12430a = str;
        this.f12431b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return be.h.a(this.f12430a, uVar.f12430a) && be.h.a(this.f12431b, uVar.f12431b);
    }

    public final int hashCode() {
        String str = this.f12430a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f12431b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "FirebaseInstallationId(fid=" + this.f12430a + ", authToken=" + this.f12431b + ')';
    }
}
