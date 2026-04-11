package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends xd.h implements fe.p {
    public int A;
    public /* synthetic */ Object B;
    public final /* synthetic */ ge.o C;
    public final /* synthetic */ h0 D;
    public final /* synthetic */ Object E;
    public final /* synthetic */ boolean F;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ge.o f3231z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(ge.o oVar, h0 h0Var, Object obj, boolean z10, vd.c cVar) {
        super(2, cVar);
        this.C = oVar;
        this.D = h0Var;
        this.E = obj;
        this.F = z10;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        return ((g0) m((q0) obj, (vd.c) obj2)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        g0 g0Var = new g0(this.C, this.D, this.E, this.F, cVar);
        g0Var.B = obj;
        return g0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        if (r5.b(r1, r7) == r6) goto L16;
     */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            int r0 = r7.A
            java.lang.Object r1 = r7.E
            d1.h0 r2 = r7.D
            ge.o r3 = r7.C
            r4 = 2
            r5 = 1
            wd.a r6 = wd.a.f14143v
            if (r0 == 0) goto L28
            if (r0 == r5) goto L1e
            if (r0 != r4) goto L16
            com.bumptech.glide.c.C(r8)
            goto L59
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            ge.o r0 = r7.f3231z
            java.lang.Object r5 = r7.B
            d1.q0 r5 = (d1.q0) r5
            com.bumptech.glide.c.C(r8)
            goto L43
        L28:
            com.bumptech.glide.c.C(r8)
            java.lang.Object r8 = r7.B
            d1.q0 r8 = (d1.q0) r8
            d1.s0 r0 = r2.h()
            r7.B = r8
            r7.f3231z = r3
            r7.A = r5
            java.lang.Object r0 = r0.e(r7)
            if (r0 != r6) goto L40
            goto L58
        L40:
            r5 = r8
            r8 = r0
            r0 = r3
        L43:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r0.f5253v = r8
            r8 = 0
            r7.B = r8
            r7.f3231z = r8
            r7.A = r4
            java.lang.Object r8 = r5.b(r1, r7)
            if (r8 != r6) goto L59
        L58:
            return r6
        L59:
            boolean r8 = r7.F
            if (r8 == 0) goto L71
            p6.d r8 = r2.f3241h
            d1.d r0 = new d1.d
            if (r1 == 0) goto L68
            int r2 = r1.hashCode()
            goto L69
        L68:
            r2 = 0
        L69:
            int r3 = r3.f5253v
            r0.<init>(r2, r3, r1)
            r8.v(r0)
        L71:
            rd.l r8 = rd.l.f11003a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.g0.o(java.lang.Object):java.lang.Object");
    }
}
