package a5;

import fe.l;
import fe.p;
import pe.v;
import w4.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends xd.h implements p {
    public final /* synthetic */ t A;
    public final /* synthetic */ boolean B;
    public final /* synthetic */ boolean C;
    public final /* synthetic */ l D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f270z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(l lVar, vd.c cVar, t tVar, boolean z10, boolean z11) {
        super(2, cVar);
        this.A = tVar;
        this.B = z10;
        this.C = z11;
        this.D = lVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        return ((c) m((v) obj, (vd.c) obj2)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        return new c(this.D, cVar, this.A, this.B, this.C);
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f270z;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.bumptech.glide.c.C(obj);
            return obj;
        }
        com.bumptech.glide.c.C(obj);
        t tVar = this.A;
        boolean z10 = !(tVar.m() && tVar.n()) && this.B;
        l lVar = this.D;
        t tVar2 = this.A;
        boolean z11 = this.C;
        b bVar = new b(lVar, null, tVar2, z10, z11);
        this.f270z = 1;
        b0.e eVar = tVar2.f13993d;
        if (eVar == null) {
            ge.i.i("connectionManager");
            throw null;
        }
        Object objT = ((y4.b) eVar.f).T(z11, bVar, this);
        wd.a aVar = wd.a.f14143v;
        return objT == aVar ? aVar : objT;
    }
}
