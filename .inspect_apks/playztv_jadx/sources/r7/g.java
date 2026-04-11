package r7;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends UnsupportedOperationException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final q7.d f11531u;

    public g(q7.d dVar) {
        this.f11531u = dVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f11531u));
    }
}
