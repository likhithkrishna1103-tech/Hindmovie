package xe;

import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f14358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14359d;

    public a(String str, boolean z2) {
        h.e(str, "name");
        this.f14356a = str;
        this.f14357b = z2;
        this.f14359d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f14356a;
    }
}
