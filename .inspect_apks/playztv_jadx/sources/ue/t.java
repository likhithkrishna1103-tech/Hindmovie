package ue;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public enum t {
    f13046v("http/1.0"),
    f13047w("http/1.1"),
    f13048x("spdy/3.1"),
    f13049y("h2"),
    f13050z("h2_prior_knowledge"),
    A("quic");


    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f13051u;

    t(String str) {
        this.f13051u = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f13051u;
    }
}
