package bb;

import c2.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1979c;

    public /* synthetic */ b(boolean z2, boolean z10, boolean z11) {
        this.f1977a = z2;
        this.f1978b = z10;
        this.f1979c = z11;
    }

    public g a() {
        if (this.f1977a || !(this.f1978b || this.f1979c)) {
            return new g(this);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }

    public boolean b() {
        return (this.f1979c || this.f1978b) && this.f1977a;
    }
}
