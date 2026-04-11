package r4;

import ke.d1;
import ke.v0;
import ke.w0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s extends be.g implements ae.a {
    @Override // ae.a
    public final Object b() {
        t tVar = (t) this.f2033v;
        pe.c cVar = tVar.f11492a;
        if (cVar == null) {
            be.h.i("coroutineScope");
            throw null;
        }
        v0 v0Var = (v0) cVar.f10373u.v(ke.s.f7730v);
        if (v0Var == null) {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + cVar).toString());
        }
        d1 d1Var = (d1) v0Var;
        d1Var.j(new w0(d1Var.n(), null, d1Var));
        tVar.g();
        p pVar = tVar.f11495d;
        if (pVar != null) {
            pVar.f.close();
            return nd.k.f8990a;
        }
        be.h.i("connectionManager");
        throw null;
    }
}
