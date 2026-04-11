package wb;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14083b;

    public a(String str, String str2) {
        this.f14082a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f14083b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f14082a.equals(aVar.f14082a) && this.f14083b.equals(aVar.f14083b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f14082a.hashCode() ^ 1000003) * 1000003) ^ this.f14083b.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("LibraryVersion{libraryName=");
        sb2.append(this.f14082a);
        sb2.append(", version=");
        return l4.a.o(sb2, this.f14083b, "}");
    }
}
