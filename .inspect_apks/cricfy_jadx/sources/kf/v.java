package kf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public enum v {
    f7573x("http/1.0"),
    f7574y("http/1.1"),
    f7575z("spdy/3.1"),
    A("h2"),
    B("h2_prior_knowledge"),
    C("quic"),
    D("h3");


    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final b f7572w = new b();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7576v;

    v(String str) {
        this.f7576v = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f7576v;
    }
}
