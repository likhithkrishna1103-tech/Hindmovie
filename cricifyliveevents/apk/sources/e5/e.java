package e5;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f3789v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Throwable f3790w;

    public e(f fVar, Throwable th) {
        super(th);
        this.f3789v = fVar;
        this.f3790w = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f3790w;
    }
}
