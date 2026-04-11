package w4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends d5.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0.e f13970c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(b0.e eVar, int i) {
        super(i, 0);
        this.f13970c = eVar;
    }

    @Override // d5.c
    public final void i(e5.c cVar) throws Exception {
        this.f13970c.j(new f5.a(cVar));
    }

    @Override // d5.c
    public final void j(e5.c cVar, int i, int i10) throws Exception {
        l(cVar, i, i10);
    }

    @Override // d5.c
    public final void k(e5.c cVar) throws Exception {
        f5.a aVar = new f5.a(cVar);
        b0.e eVar = this.f13970c;
        eVar.l(aVar);
        eVar.f1601h = cVar;
    }

    @Override // d5.c
    public final void l(e5.c cVar, int i, int i10) throws Exception {
        this.f13970c.k(new f5.a(cVar), i, i10);
    }
}
