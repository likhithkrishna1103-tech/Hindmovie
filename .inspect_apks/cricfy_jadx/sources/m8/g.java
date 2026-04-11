package m8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends UnsupportedOperationException {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l8.d f8389v;

    public g(l8.d dVar) {
        this.f8389v = dVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f8389v));
    }
}
