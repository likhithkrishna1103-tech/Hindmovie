package xe;

import fe.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.o1;
import rd.l;
import ue.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements pe.f, o1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final pe.h f14489v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ c f14490w;

    public b(c cVar, pe.h hVar) {
        this.f14490w = cVar;
        this.f14489v = hVar;
    }

    @Override // pe.o1
    public final void a(r rVar, int i) {
        this.f14489v.a(rVar, i);
    }

    @Override // pe.f
    public final d5.a c(Object obj, q qVar) {
        c cVar = this.f14490w;
        pe.g gVar = new pe.g(cVar, this);
        d5.a aVarC = this.f14489v.c((l) obj, gVar);
        if (aVarC != null) {
            c.C.set(cVar, null);
        }
        return aVarC;
    }

    @Override // vd.c
    public final vd.h h() {
        return this.f14489v.f10237z;
    }

    @Override // vd.c
    public final void i(Object obj) {
        this.f14489v.i(obj);
    }

    @Override // pe.f
    public final void k(Object obj, q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.C;
        c cVar = this.f14490w;
        atomicReferenceFieldUpdater.set(cVar, null);
        df.l lVar = new df.l(cVar, this);
        pe.h hVar = this.f14489v;
        hVar.F(l.f11003a, hVar.f10228x, new pe.g(0, lVar));
    }

    @Override // pe.f
    public final void l(Object obj) {
        this.f14489v.l(obj);
    }
}
