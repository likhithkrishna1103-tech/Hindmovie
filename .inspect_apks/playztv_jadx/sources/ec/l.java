package ec;

import ae.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends td.g implements p {
    public final /* synthetic */ c1.d A;
    public final /* synthetic */ m B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f4668y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f4669z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Object obj, c1.d dVar, m mVar, rd.c cVar) {
        super(2, cVar);
        this.f4669z = obj;
        this.A = dVar;
        this.B = mVar;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) throws Throwable {
        l lVar = (l) m((c1.b) obj, (rd.c) obj2);
        nd.k kVar = nd.k.f8990a;
        lVar.o(kVar);
        return kVar;
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        l lVar = new l(this.f4669z, this.A, this.B, cVar);
        lVar.f4668y = obj;
        return lVar;
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        i5.a.Q(obj);
        c1.b bVar = (c1.b) this.f4668y;
        c1.d dVar = this.A;
        Object obj2 = this.f4669z;
        if (obj2 != null) {
            bVar.getClass();
            be.h.e(dVar, "key");
            bVar.b(dVar, obj2);
        } else {
            bVar.getClass();
            be.h.e(dVar, "key");
            if (bVar.f2232b.get()) {
                throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
            }
            bVar.f2231a.remove(dVar);
        }
        m.a(this.B, bVar);
        return nd.k.f8990a;
    }
}
