package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends l0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k1 f10245x;

    public k0(long j4, k1 k1Var) {
        super(j4);
        this.f10245x = k1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10245x.run();
    }

    @Override // pe.l0
    public final String toString() {
        return super.toString() + this.f10245x;
    }
}
