package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends c1 implements vd.c, v {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final vd.h f10215x;

    public a(vd.h hVar, boolean z10) {
        super(z10);
        I((v0) hVar.C(t.f10271w));
        this.f10215x = hVar.q(this);
    }

    @Override // pe.c1
    public final void H(a9.l lVar) {
        x.i(lVar, this.f10215x);
    }

    @Override // pe.c1
    public final void U(Object obj) {
        if (!(obj instanceof p)) {
            d0(obj);
        } else {
            p pVar = (p) obj;
            c0(pVar.f10263a, p.f10262b.get(pVar) != 0);
        }
    }

    @Override // pe.v
    public final vd.h b() {
        return this.f10215x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f0(w wVar, a aVar, fe.p pVar) {
        int iOrdinal = wVar.ordinal();
        rd.l lVar = rd.l.f11003a;
        if (iOrdinal == 0) {
            try {
                ue.a.h(lVar, u8.a.t(((xd.a) pVar).m(aVar, this)));
                return;
            } finally {
                i(com.bumptech.glide.c.e(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                u8.a.t(((xd.a) pVar).m(aVar, this)).i(lVar);
                return;
            }
            if (iOrdinal != 3) {
                throw new a9.l();
            }
            try {
                vd.h hVar = this.f10215x;
                Object objL = ue.a.l(hVar, null);
                try {
                    ge.s.a(2, pVar);
                    Object objJ = pVar.j(aVar, this);
                    if (objJ != wd.a.f14143v) {
                        i(objJ);
                    }
                } finally {
                    ue.a.g(hVar, objL);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // vd.c
    public final vd.h h() {
        return this.f10215x;
    }

    @Override // vd.c
    public final void i(Object obj) {
        Throwable thA = rd.h.a(obj);
        if (thA != null) {
            obj = new p(thA, false);
        }
        Object objP = P(obj);
        if (objP == x.f10285e) {
            return;
        }
        m(objP);
    }

    @Override // pe.c1
    public final String r() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public void d0(Object obj) {
    }

    public void c0(Throwable th, boolean z10) {
    }
}
