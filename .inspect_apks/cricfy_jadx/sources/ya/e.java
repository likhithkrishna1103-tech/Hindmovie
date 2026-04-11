package ya;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c0 f14995v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final w f14996w;

    public e(c0 c0Var, w wVar) {
        this.f14995v = c0Var;
        this.f14996w = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f14995v.f15006v != this) {
            return;
        }
        if (o.A.i(this.f14995v, this, o.g(this.f14996w))) {
            o.d(this.f14995v, false);
        }
    }
}
