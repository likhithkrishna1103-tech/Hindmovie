package z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends td.g implements ae.l {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14756y;

    @Override // ae.l
    public final Object a(Object obj) throws Throwable {
        d dVar = new d(1, (rd.c) obj);
        nd.k kVar = nd.k.f8990a;
        dVar.o(kVar);
        return kVar;
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f14756y;
        if (i == 0) {
            i5.a.Q(obj);
            this.f14756y = 1;
            throw null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i5.a.Q(obj);
        return nd.k.f8990a;
    }
}
