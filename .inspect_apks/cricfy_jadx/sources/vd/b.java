package vd;

import fe.p;
import java.io.Serializable;
import pe.q;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements h, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f13719v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f13720w;

    public b(f fVar, h hVar) {
        ge.i.e(hVar, "left");
        ge.i.e(fVar, "element");
        this.f13719v = hVar;
        this.f13720w = fVar;
    }

    @Override // vd.h
    public final f C(g gVar) {
        ge.i.e(gVar, "key");
        b bVar = this;
        while (true) {
            f fVarC = bVar.f13720w.C(gVar);
            if (fVarC != null) {
                return fVarC;
            }
            h hVar = bVar.f13719v;
            if (!(hVar instanceof b)) {
                return hVar.C(gVar);
            }
            bVar = (b) hVar;
        }
    }

    @Override // vd.h
    public final Object J(Object obj, p pVar) {
        return pVar.j(this.f13719v.J(obj, pVar), this.f13720w);
    }

    @Override // vd.h
    public final h O(g gVar) {
        ge.i.e(gVar, "key");
        f fVar = this.f13720w;
        f fVarC = fVar.C(gVar);
        h hVar = this.f13719v;
        if (fVarC != null) {
            return hVar;
        }
        h hVarO = hVar.O(gVar);
        return hVarO == hVar ? this : hVarO == i.f13722v ? fVar : new b(fVar, hVarO);
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
                h hVar = bVar2.f13719v;
                bVar2 = hVar instanceof b ? (b) hVar : null;
                if (bVar2 == null) {
                    break;
                }
                i10++;
            }
            b bVar3 = this;
            while (true) {
                h hVar2 = bVar3.f13719v;
                bVar3 = hVar2 instanceof b ? (b) hVar2 : null;
                if (bVar3 == null) {
                    break;
                }
                i++;
            }
            if (i10 == i) {
                b bVar4 = this;
                while (true) {
                    f fVar = bVar4.f13720w;
                    if (!ge.i.a(bVar.C(fVar.getKey()), fVar)) {
                        zA = false;
                        break;
                    }
                    h hVar3 = bVar4.f13719v;
                    if (!(hVar3 instanceof b)) {
                        ge.i.c(hVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        f fVar2 = (f) hVar3;
                        zA = ge.i.a(bVar.C(fVar2.getKey()), fVar2);
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
        return this.f13720w.hashCode() + this.f13719v.hashCode();
    }

    @Override // vd.h
    public final h q(h hVar) {
        ge.i.e(hVar, "context");
        return hVar == i.f13722v ? this : (h) hVar.J(this, new q(8));
    }

    public final String toString() {
        return "[" + ((String) J("", new q(7))) + ']';
    }
}
