package pc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10176b;

    public a(String str, String str2) {
        this.f10175a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f10176b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f10175a.equals(aVar.f10175a) && this.f10176b.equals(aVar.f10176b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f10175a.hashCode() ^ 1000003) * 1000003) ^ this.f10176b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.f10175a);
        sb.append(", version=");
        return q4.a.q(sb, this.f10176b, "}");
    }
}
