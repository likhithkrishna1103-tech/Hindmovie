package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends xd.h implements fe.l {
    public int A;
    public final /* synthetic */ h0 B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Throwable f3204z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(h0 h0Var, vd.c cVar) {
        super(1, cVar);
        this.B = h0Var;
    }

    @Override // fe.l
    public final Object a(Object obj) {
        return new a0(this.B, (vd.c) obj).o(rd.l.f11003a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r6 != r4) goto L22;
     */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            int r0 = r5.A
            d1.h0 r1 = r5.B
            r2 = 2
            r3 = 1
            wd.a r4 = wd.a.f14143v
            if (r0 == 0) goto L23
            if (r0 == r3) goto L1c
            if (r0 != r2) goto L14
            java.lang.Throwable r0 = r5.f3204z
            com.bumptech.glide.c.C(r6)
            goto L41
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1c:
            com.bumptech.glide.c.C(r6)     // Catch: java.lang.Throwable -> L20
            goto L2f
        L20:
            r6 = move-exception
            r0 = r6
            goto L32
        L23:
            com.bumptech.glide.c.C(r6)
            r5.A = r3     // Catch: java.lang.Throwable -> L20
            java.lang.Object r6 = d1.h0.g(r1, r3, r5)     // Catch: java.lang.Throwable -> L20
            if (r6 != r4) goto L2f
            goto L40
        L2f:
            d1.l1 r6 = (d1.l1) r6     // Catch: java.lang.Throwable -> L20
            goto L4d
        L32:
            d1.s0 r6 = r1.h()
            r5.f3204z = r0
            r5.A = r2
            java.lang.Object r6 = r6.a(r5)
            if (r6 != r4) goto L41
        L40:
            return r4
        L41:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            d1.d1 r1 = new d1.d1
            r1.<init>(r0, r6)
            r6 = r1
        L4d:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            rd.f r1 = new rd.f
            r1.<init>(r6, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.a0.o(java.lang.Object):java.lang.Object");
    }
}
