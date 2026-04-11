package rd;

import java.io.Serializable;
import ke.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements h, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f11569u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f11570v;

    public b(f fVar, h hVar) {
        be.h.e(hVar, "left");
        be.h.e(fVar, "element");
        this.f11569u = hVar;
        this.f11570v = fVar;
    }

    @Override // rd.h
    public final h G(g gVar) {
        be.h.e(gVar, "key");
        f fVar = this.f11570v;
        f fVarV = fVar.v(gVar);
        h hVar = this.f11569u;
        if (fVarV != null) {
            return hVar;
        }
        h hVarG = hVar.G(gVar);
        return hVarG == hVar ? this : hVarG == i.f11572u ? fVar : new b(fVar, hVarG);
    }

    @Override // rd.h
    public final h K(h hVar) {
        be.h.e(hVar, "context");
        return hVar == i.f11572u ? this : (h) hVar.d(this, new p(8));
    }

    @Override // rd.h
    public final Object d(Object obj, ae.p pVar) {
        return pVar.i(this.f11569u.d(obj, pVar), this.f11570v);
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int i = 2;
            b bVar2 = bVar;
            int i10 = 2;
            while (true) {
                h hVar = bVar2.f11569u;
                bVar2 = hVar instanceof b ? (b) hVar : null;
                if (bVar2 == null) {
                    break;
                }
                i10++;
            }
            b bVar3 = this;
            while (true) {
                h hVar2 = bVar3.f11569u;
                bVar3 = hVar2 instanceof b ? (b) hVar2 : null;
                if (bVar3 == null) {
                    break;
                }
                i++;
            }
            if (i10 == i) {
                b bVar4 = this;
                while (true) {
                    f fVar = bVar4.f11570v;
                    if (!be.h.a(bVar.v(fVar.getKey()), fVar)) {
                        zA = false;
                        break;
                    }
                    h hVar3 = bVar4.f11569u;
                    if (!(hVar3 instanceof b)) {
                        be.h.c(hVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        f fVar2 = (f) hVar3;
                        zA = be.h.a(bVar.v(fVar2.getKey()), fVar2);
                        break;
                    }
                    bVar4 = (b) hVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f11570v.hashCode() + this.f11569u.hashCode();
    }

    public final String toString() {
        return "[" + ((String) d("", new p(7))) + ']';
    }

    @Override // rd.h
    public final f v(g gVar) {
        be.h.e(gVar, "key");
        b bVar = this;
        while (true) {
            f fVarV = bVar.f11570v.v(gVar);
            if (fVarV != null) {
                return fVarV;
            }
            h hVar = bVar.f11569u;
            if (!(hVar instanceof b)) {
                return hVar.v(gVar);
            }
            bVar = (b) hVar;
        }
    }
}
