package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends d1 implements rd.c, u {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final rd.h f7673w;

    public a(rd.h hVar, boolean z2) {
        super(z2);
        C((v0) hVar.v(s.f7730v));
        this.f7673w = hVar.K(this);
    }

    @Override // ke.d1
    public final void B(a2.y0 y0Var) {
        x.h(y0Var, this.f7673w);
    }

    @Override // ke.d1
    public final void P(Object obj) {
        if (obj instanceof o) {
            o.f7716b.get((o) obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X(v vVar, a aVar, ae.p pVar) {
        int iOrdinal = vVar.ordinal();
        nd.k kVar = nd.k.f8990a;
        if (iOrdinal == 0) {
            try {
                pe.a.h(kVar, a.a.w(((td.a) pVar).m(aVar, this)));
                return;
            } finally {
                g(i5.a.h(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                a.a.w(((td.a) pVar).m(aVar, this)).g(kVar);
                return;
            }
            if (iOrdinal != 3) {
                throw new a2.y0();
            }
            try {
                rd.h hVar = this.f7673w;
                Object objK = pe.a.k(hVar, null);
                try {
                    be.q.a(2, pVar);
                    Object objI = pVar.i(aVar, this);
                    if (objI != sd.a.f11942u) {
                        g(objI);
                    }
                } finally {
                    pe.a.g(hVar, objK);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // ke.u
    public final rd.h b() {
        return this.f7673w;
    }

    @Override // rd.c
    public final rd.h f() {
        return this.f7673w;
    }

    @Override // rd.c
    public final void g(Object obj) {
        Throwable thA = nd.h.a(obj);
        if (thA != null) {
            obj = new o(thA, false);
        }
        Object objL = L(obj);
        if (objL == x.f7744e) {
            return;
        }
        i(objL);
    }

    @Override // ke.d1
    public final String n() {
        return getClass().getSimpleName().concat(" was cancelled");
    }
}
