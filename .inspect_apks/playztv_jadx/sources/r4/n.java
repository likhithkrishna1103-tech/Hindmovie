package r4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends t1.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f11466c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(p pVar, int i) {
        super(i, 1);
        this.f11466c = pVar;
    }

    @Override // t1.e
    public final void i(a5.d dVar) throws Exception {
        this.f11466c.d(new u4.a(dVar));
    }

    @Override // t1.e
    public final void j(a5.d dVar, int i, int i10) throws Exception {
        l(dVar, i, i10);
    }

    @Override // t1.e
    public final void k(a5.d dVar) throws Exception {
        u4.a aVar = new u4.a(dVar);
        p pVar = this.f11466c;
        pVar.f(aVar);
        pVar.f11473g = dVar;
    }

    @Override // t1.e
    public final void l(a5.d dVar, int i, int i10) throws Exception {
        this.f11466c.e(new u4.a(dVar), i, i10);
    }
}
