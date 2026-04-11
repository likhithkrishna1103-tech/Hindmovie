package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends h {
    public final n D;

    public z0(vd.c cVar, n nVar) {
        super(1, cVar);
        this.D = nVar;
    }

    @Override // pe.h
    public final String D() {
        return "AwaitContinuation";
    }

    @Override // pe.h
    public final Throwable u(c1 c1Var) {
        Throwable thC;
        n nVar = this.D;
        nVar.getClass();
        Object obj = c1.f10226v.get(nVar);
        return (!(obj instanceof b1) || (thC = ((b1) obj).c()) == null) ? obj instanceof p ? ((p) obj).f10263a : c1Var.x() : thC;
    }
}
