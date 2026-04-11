package w4;

import ae.l;
import ae.p;
import be.h;
import ke.u;
import nd.k;
import r4.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends td.g implements p {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ boolean B;
    public final /* synthetic */ l C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13713y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ t f13714z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(l lVar, t tVar, rd.c cVar, boolean z2, boolean z10) {
        super(2, cVar);
        this.f13714z = tVar;
        this.A = z2;
        this.B = z10;
        this.C = lVar;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        return ((b) m((u) obj, (rd.c) obj2)).o(k.f8990a);
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        return new b(this.C, this.f13714z, cVar, this.A, this.B);
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f13713y;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5.a.Q(obj);
            return obj;
        }
        i5.a.Q(obj);
        t tVar = this.f13714z;
        boolean z2 = !(tVar.k() && tVar.l()) && this.A;
        l lVar = this.C;
        t tVar2 = this.f13714z;
        boolean z10 = this.B;
        a aVar = new a(lVar, tVar2, null, z2, z10);
        this.f13713y = 1;
        r4.p pVar = tVar2.f11495d;
        if (pVar == null) {
            h.i("connectionManager");
            throw null;
        }
        Object objI = pVar.f.I(z10, aVar, this);
        sd.a aVar2 = sd.a.f11942u;
        return objI == aVar2 ? aVar2 : objI;
    }
}
