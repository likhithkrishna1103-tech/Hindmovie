package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class r extends rd.a implements rd.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final q f7727v = new q(rd.d.f11571u, new c.e0(1));

    public r() {
        super(rd.d.f11571u);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (((rd.f) r3.f7724u.a(r2)) == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
    
        if (rd.d.f11571u == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        return rd.i.f11572u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        return r2;
     */
    @Override // rd.a, rd.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final rd.h G(rd.g r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            be.h.e(r3, r0)
            boolean r0 = r3 instanceof ke.q
            if (r0 == 0) goto L20
            ke.q r3 = (ke.q) r3
            rd.g r0 = r2.f11568u
            if (r0 == r3) goto L15
            rd.g r1 = r3.f7725v
            if (r1 != r0) goto L14
            goto L15
        L14:
            return r2
        L15:
            ae.l r3 = r3.f7724u
            java.lang.Object r3 = r3.a(r2)
            rd.f r3 = (rd.f) r3
            if (r3 == 0) goto L27
            goto L24
        L20:
            rd.d r0 = rd.d.f11571u
            if (r0 != r3) goto L27
        L24:
            rd.i r3 = rd.i.f11572u
            return r3
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ke.r.G(rd.g):rd.h");
    }

    public abstract void h0(rd.h hVar, Runnable runnable);

    public boolean i0(rd.h hVar) {
        return !(this instanceof m1);
    }

    public r j0(int i) {
        pe.a.a(i);
        return new pe.g(this, i);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + x.f(this);
    }

    @Override // rd.a, rd.h
    public final rd.f v(rd.g gVar) {
        rd.f fVar;
        be.h.e(gVar, "key");
        if (!(gVar instanceof q)) {
            if (rd.d.f11571u == gVar) {
                return this;
            }
            return null;
        }
        q qVar = (q) gVar;
        rd.g gVar2 = this.f11568u;
        if ((gVar2 == qVar || qVar.f7725v == gVar2) && (fVar = (rd.f) qVar.f7724u.a(this)) != null) {
            return fVar;
        }
        return null;
    }
}
