package se;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11701v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f11702w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f11703x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final xd.h f11704y;

    public o(ge.n nVar, d dVar, d1.q qVar) {
        this.f11702w = nVar;
        this.f11703x = dVar;
        this.f11704y = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    @Override // se.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.Object r8, vd.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            int r0 = r7.f11701v
            switch(r0) {
                case 0: goto L1b;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r7.f11702w
            vd.h r0 = (vd.h) r0
            xd.h r1 = r7.f11704y
            d1.e r1 = (d1.e) r1
            java.lang.Object r2 = r7.f11703x
            java.lang.Object r8 = te.c.a(r0, r8, r2, r1, r9)
            wd.a r9 = wd.a.f14143v
            if (r8 != r9) goto L18
            goto L1a
        L18:
            rd.l r8 = rd.l.f11003a
        L1a:
            return r8
        L1b:
            boolean r0 = r9 instanceof se.n
            if (r0 == 0) goto L2e
            r0 = r9
            se.n r0 = (se.n) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L2e
            int r1 = r1 - r2
            r0.C = r1
            goto L33
        L2e:
            se.n r0 = new se.n
            r0.<init>(r7, r9)
        L33:
            java.lang.Object r9 = r0.A
            int r1 = r0.C
            r2 = 3
            r3 = 2
            rd.l r4 = rd.l.f11003a
            r5 = 1
            wd.a r6 = wd.a.f14143v
            if (r1 == 0) goto L5a
            if (r1 == r5) goto L46
            if (r1 == r3) goto L52
            if (r1 != r2) goto L4a
        L46:
            com.bumptech.glide.c.C(r9)
            goto La4
        L4a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L52:
            java.lang.Object r8 = r0.f11700z
            se.o r1 = r0.f11699y
            com.bumptech.glide.c.C(r9)
            goto L84
        L5a:
            com.bumptech.glide.c.C(r9)
            java.lang.Object r9 = r7.f11702w
            ge.n r9 = (ge.n) r9
            boolean r9 = r9.f5252v
            if (r9 == 0) goto L72
            java.lang.Object r9 = r7.f11703x
            se.d r9 = (se.d) r9
            r0.C = r5
            java.lang.Object r8 = r9.f(r8, r0)
            if (r8 != r6) goto La4
            goto La3
        L72:
            xd.h r9 = r7.f11704y
            d1.q r9 = (d1.q) r9
            r0.f11699y = r7
            r0.f11700z = r8
            r0.C = r3
            java.lang.Object r9 = r9.j(r8, r0)
            if (r9 != r6) goto L83
            goto La3
        L83:
            r1 = r7
        L84:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto La4
            java.lang.Object r9 = r1.f11702w
            ge.n r9 = (ge.n) r9
            r9.f5252v = r5
            java.lang.Object r9 = r1.f11703x
            se.d r9 = (se.d) r9
            r1 = 0
            r0.f11699y = r1
            r0.f11700z = r1
            r0.C = r2
            java.lang.Object r8 = r9.f(r8, r0)
            if (r8 != r6) goto La4
        La3:
            r4 = r6
        La4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: se.o.f(java.lang.Object, vd.c):java.lang.Object");
    }

    public o(d dVar, vd.h hVar) {
        this.f11702w = hVar;
        this.f11703x = ue.a.k(hVar);
        this.f11704y = new d1.e(dVar, (vd.c) null, 8);
    }
}
