package of;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f9850a;

    public q(o oVar) {
        ge.i.e(oVar, "connection");
        this.f9850a = oVar;
    }

    @Override // of.s
    public final boolean b() {
        return true;
    }

    @Override // of.s
    public final s c() {
        throw new IllegalStateException("unexpected retry");
    }

    @Override // of.s, pf.e
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // of.s
    public final r d() {
        throw new IllegalStateException("already connected");
    }

    @Override // of.s
    public final o e() {
        return this.f9850a;
    }

    @Override // of.s
    public final r g() {
        throw new IllegalStateException("already connected");
    }
}
