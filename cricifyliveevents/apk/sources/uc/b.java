package uc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12443e;
    public byte f;

    public final c a() {
        if (this.f == 1 && this.f12439a != null && this.f12440b != null && this.f12441c != null && this.f12442d != null) {
            return new c(this.f12439a, this.f12440b, this.f12441c, this.f12442d, this.f12443e);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f12439a == null) {
            sb.append(" rolloutId");
        }
        if (this.f12440b == null) {
            sb.append(" variantId");
        }
        if (this.f12441c == null) {
            sb.append(" parameterKey");
        }
        if (this.f12442d == null) {
            sb.append(" parameterValue");
        }
        if ((1 & this.f) == 0) {
            sb.append(" templateVersion");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }
}
