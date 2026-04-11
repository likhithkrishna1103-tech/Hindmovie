package i2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ k f6070v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ boolean f6071w;

    public /* synthetic */ j(k kVar, boolean z10) {
        this.f6070v = kVar;
        this.f6071w = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = (l) this.f6070v.f6086w;
        int i = y1.a0.f14551a;
        g2.g0 g0Var = ((g2.d0) lVar).f4651v;
        boolean z10 = g0Var.f4709v0;
        boolean z11 = this.f6071w;
        if (z10 == z11) {
            return;
        }
        g0Var.f4709v0 = z11;
        g0Var.I.e(23, new g2.y(1, z11));
    }
}
