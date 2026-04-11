package xb;

import fe.p;
import h1.e;
import rd.l;
import xd.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends h implements p {
    public final /* synthetic */ e A;
    public final /* synthetic */ Long B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ Object f14474z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, Long l10, vd.c cVar) {
        super(2, cVar);
        this.A = eVar;
        this.B = l10;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) throws Throwable {
        b bVar = (b) m((h1.b) obj, (vd.c) obj2);
        l lVar = l.f11003a;
        bVar.o(lVar);
        return lVar;
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        b bVar = new b(this.A, this.B, cVar);
        bVar.f14474z = obj;
        return bVar;
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        com.bumptech.glide.c.C(obj);
        ((h1.b) this.f14474z).d(this.A, this.B);
        return l.f11003a;
    }
}
