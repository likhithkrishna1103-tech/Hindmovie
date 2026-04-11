package td;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rd.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f12489v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient rd.c f12490w;

    public c(rd.c cVar, h hVar) {
        super(cVar);
        this.f12489v = hVar;
    }

    @Override // rd.c
    public h f() {
        h hVar = this.f12489v;
        be.h.b(hVar);
        return hVar;
    }

    @Override // td.a
    public void p() {
        rd.c cVar = this.f12490w;
        if (cVar != null && cVar != this) {
            rd.f fVarV = f().v(rd.d.f11571u);
            be.h.b(fVarV);
            pe.f fVar = (pe.f) cVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pe.f.B;
            while (atomicReferenceFieldUpdater.get(fVar) == pe.a.f10367c) {
            }
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            ke.g gVar = obj instanceof ke.g ? (ke.g) obj : null;
            if (gVar != null) {
                gVar.r();
            }
        }
        this.f12490w = b.f12488u;
    }

    public c(rd.c cVar) {
        this(cVar, cVar != null ? cVar.f() : null);
    }
}
