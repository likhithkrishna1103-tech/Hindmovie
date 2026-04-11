package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends g {
    public final m C;

    public a1(rd.c cVar, m mVar) {
        super(1, cVar);
        this.C = mVar;
    }

    @Override // ke.g
    public final String B() {
        return "AwaitContinuation";
    }

    @Override // ke.g
    public final Throwable t(d1 d1Var) {
        Throwable thC;
        m mVar = this.C;
        mVar.getClass();
        Object obj = d1.f7686u.get(mVar);
        return (!(obj instanceof c1) || (thC = ((c1) obj).c()) == null) ? obj instanceof o ? ((o) obj).f7717a : d1Var.s() : thC;
    }
}
