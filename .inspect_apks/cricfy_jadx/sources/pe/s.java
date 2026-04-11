package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s extends vd.a implements vd.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final r f10269w = new r(vd.d.f13721v, new b6.a(5));

    public s() {
        super(vd.d.f13721v);
    }

    @Override // vd.a, vd.h
    public final vd.f C(vd.g gVar) {
        vd.f fVar;
        ge.i.e(gVar, "key");
        if (!(gVar instanceof r)) {
            if (vd.d.f13721v == gVar) {
                return this;
            }
            return null;
        }
        r rVar = (r) gVar;
        vd.g gVar2 = this.f13718v;
        if ((gVar2 == rVar || rVar.f10267w == gVar2) && (fVar = (vd.f) rVar.f10266v.a(this)) != null) {
            return fVar;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (((vd.f) r3.f10266v.a(r2)) == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
    
        if (vd.d.f13721v == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        return vd.i.f13722v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        return r2;
     */
    @Override // vd.a, vd.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final vd.h O(vd.g r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            ge.i.e(r3, r0)
            boolean r0 = r3 instanceof pe.r
            if (r0 == 0) goto L20
            pe.r r3 = (pe.r) r3
            vd.g r0 = r2.f13718v
            if (r0 == r3) goto L15
            vd.g r1 = r3.f10267w
            if (r1 != r0) goto L14
            goto L15
        L14:
            return r2
        L15:
            fe.l r3 = r3.f10266v
            java.lang.Object r3 = r3.a(r2)
            vd.f r3 = (vd.f) r3
            if (r3 == 0) goto L27
            goto L24
        L20:
            vd.d r0 = vd.d.f13721v
            if (r0 != r3) goto L27
        L24:
            vd.i r3 = vd.i.f13722v
            return r3
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: pe.s.O(vd.g):vd.h");
    }

    public abstract void h0(vd.h hVar, Runnable runnable);

    public boolean i0(vd.h hVar) {
        return !(this instanceof l1);
    }

    public s j0(int i) {
        ue.a.a(i);
        return new ue.g(this, i);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + x.g(this);
    }
}
