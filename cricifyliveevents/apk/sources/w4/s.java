package w4;

import pe.v0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s extends ge.h implements fe.a {
    @Override // fe.a
    public final Object b() {
        t tVar = (t) this.f5243w;
        ue.c cVar = tVar.f13990a;
        if (cVar == null) {
            ge.i.i("coroutineScope");
            throw null;
        }
        v0 v0Var = (v0) cVar.f12461v.C(pe.t.f10271w);
        if (v0Var == null) {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + cVar).toString());
        }
        v0Var.g(null);
        tVar.i();
        b0.e eVar = tVar.f13993d;
        if (eVar == null) {
            ge.i.i("connectionManager");
            throw null;
        }
        ((y4.b) eVar.f).close();
        d5.d dVar = (d5.d) eVar.f1600g;
        if (dVar != null) {
            dVar.close();
        }
        return rd.l.f11003a;
    }
}
