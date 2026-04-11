package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 extends ue.q implements Runnable {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f10246z;

    /* JADX WARN: Illegal instructions before constructor call */
    public k1(long j4, y4.r rVar) {
        vd.h hVar = rVar.f14484w;
        ge.i.b(hVar);
        super(rVar, hVar);
        this.f10246z = j4;
    }

    @Override // pe.c1
    public final String R() {
        return super.R() + "(timeMillis=" + this.f10246z + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.f(this.f10215x);
        n(new j1("Timed out waiting for " + this.f10246z + " ms", this));
    }
}
