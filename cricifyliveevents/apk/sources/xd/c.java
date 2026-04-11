package xd;

import ge.i;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final vd.h f14484w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient vd.c f14485x;

    public c(vd.c cVar, vd.h hVar) {
        super(cVar);
        this.f14484w = hVar;
    }

    @Override // vd.c
    public vd.h h() {
        vd.h hVar = this.f14484w;
        i.b(hVar);
        return hVar;
    }

    @Override // xd.a
    public void p() {
        vd.c cVar = this.f14485x;
        if (cVar != null && cVar != this) {
            vd.f fVarC = h().C(vd.d.f13721v);
            i.b(fVarC);
            ue.f fVar = (ue.f) cVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ue.f.C;
            while (atomicReferenceFieldUpdater.get(fVar) == ue.a.f12455c) {
            }
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            pe.h hVar = obj instanceof pe.h ? (pe.h) obj : null;
            if (hVar != null) {
                hVar.r();
            }
        }
        this.f14485x = b.f14483v;
    }

    public c(vd.c cVar) {
        this(cVar, cVar != null ? cVar.h() : null);
    }
}
