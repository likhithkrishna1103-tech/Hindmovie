package z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends be.i implements ae.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ a0 f14771v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(a0 a0Var) {
        super(1);
        this.f14771v = a0Var;
    }

    @Override // ae.l
    public final Object a(Object obj) {
        Throwable th = (Throwable) obj;
        if (th != null) {
            ne.n nVar = this.f14771v.f14749z;
            g gVar = new g(th);
            nVar.getClass();
            nVar.f(null, gVar);
        }
        Object obj2 = a0.D;
        a0 a0Var = this.f14771v;
        synchronized (obj2) {
            a0.C.remove(a0Var.b().getAbsolutePath());
        }
        return nd.k.f8990a;
    }
}
