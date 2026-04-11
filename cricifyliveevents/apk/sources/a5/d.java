package a5;

import fe.l;
import fe.p;
import pe.v;
import pe.x;
import w4.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends xd.h implements p {
    public final /* synthetic */ vd.h A;
    public final /* synthetic */ t B;
    public final /* synthetic */ boolean C;
    public final /* synthetic */ boolean D;
    public final /* synthetic */ l E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f271z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(vd.h hVar, t tVar, boolean z10, boolean z11, l lVar, vd.c cVar) {
        super(2, cVar);
        this.A = hVar;
        this.B = tVar;
        this.C = z10;
        this.D = z11;
        this.E = lVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        return ((d) m((v) obj, (vd.c) obj2)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        return new d(this.A, this.B, this.C, this.D, this.E, cVar);
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f271z;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.bumptech.glide.c.C(obj);
            return obj;
        }
        com.bumptech.glide.c.C(obj);
        c cVar = new c(this.E, null, this.B, this.C, this.D);
        this.f271z = 1;
        Object objS = x.s(this.A, cVar, this);
        wd.a aVar = wd.a.f14143v;
        return objS == aVar ? aVar : objS;
    }
}
