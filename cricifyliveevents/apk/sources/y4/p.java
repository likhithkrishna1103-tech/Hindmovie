package y4;

import c.d0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c5.b f14872v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f14873w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ge.h f14874x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final rd.j f14875y = new rd.j(new d0(12, this));

    /* JADX WARN: Multi-variable type inference failed */
    public p(c5.b bVar, String str, fe.p pVar) {
        this.f14872v = bVar;
        this.f14873w = str;
        this.f14874x = (ge.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [fe.p, ge.h] */
    @Override // y4.b
    public final Object T(boolean z10, fe.p pVar, xd.c cVar) {
        o oVar = (o) cVar.h().C(o.f14870w);
        n nVar = oVar != null ? oVar.f14871v : null;
        if (nVar != null) {
            return pVar.j(nVar, cVar);
        }
        n nVar2 = new n(this.f14874x, (c5.a) this.f14875y.getValue());
        return pe.x.s(new o(nVar2), new d1.e(pVar, nVar2, (vd.c) null), cVar);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        rd.j jVar = this.f14875y;
        if (jVar.a()) {
            ((c5.a) jVar.getValue()).close();
        }
    }
}
