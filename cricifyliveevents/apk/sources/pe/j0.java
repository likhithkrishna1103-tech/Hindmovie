package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends l0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h f10242x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ n0 f10243y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(n0 n0Var, long j4, h hVar) {
        super(j4);
        this.f10243y = n0Var;
        this.f10242x = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10242x.G(this.f10243y);
    }

    @Override // pe.l0
    public final String toString() {
        return super.toString() + this.f10242x;
    }
}
