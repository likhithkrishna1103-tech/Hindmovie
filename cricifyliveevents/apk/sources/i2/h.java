package i2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f6044d = new g().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6047c;

    public h(g gVar) {
        this.f6045a = gVar.f6039a;
        this.f6046b = gVar.f6040b;
        this.f6047c = gVar.f6041c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f6045a == hVar.f6045a && this.f6046b == hVar.f6046b && this.f6047c == hVar.f6047c;
    }

    public final int hashCode() {
        return ((this.f6045a ? 1 : 0) << 2) + ((this.f6046b ? 1 : 0) << 1) + (this.f6047c ? 1 : 0);
    }
}
