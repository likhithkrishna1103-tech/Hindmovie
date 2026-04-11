package of;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f9810a;

    public i(Throwable th) {
        this.f9810a = new r(this, th, 2);
    }

    @Override // of.s
    public final boolean b() {
        return false;
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
        return this.f9810a;
    }

    @Override // of.s
    public final o e() {
        throw new IllegalStateException("unexpected call");
    }

    @Override // of.s
    public final r g() {
        return this.f9810a;
    }
}
