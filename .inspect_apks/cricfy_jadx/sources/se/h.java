package se;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ p6.c f11686v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d1.r f11687w;

    public h(p6.c cVar, d1.r rVar) {
        this.f11686v = cVar;
        this.f11687w = rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // se.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(se.d r9, xd.c r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof se.g
            if (r0 == 0) goto L13
            r0 = r10
            se.g r0 = (se.g) r0
            int r1 = r0.f11685z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11685z = r1
            goto L18
        L13:
            se.g r0 = new se.g
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f11684y
            int r1 = r0.f11685z
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            wd.a r6 = wd.a.f14143v
            if (r1 == 0) goto L50
            if (r1 == r4) goto L44
            if (r1 == r3) goto L3c
            if (r1 != r2) goto L34
            java.lang.Object r9 = r0.B
            te.g r9 = (te.g) r9
            com.bumptech.glide.c.C(r10)     // Catch: java.lang.Throwable -> L32
            goto L7d
        L32:
            r10 = move-exception
            goto L87
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            java.lang.Object r9 = r0.B
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            com.bumptech.glide.c.C(r10)
            goto La1
        L44:
            se.d r9 = r0.C
            java.lang.Object r1 = r0.B
            se.h r1 = (se.h) r1
            com.bumptech.glide.c.C(r10)     // Catch: java.lang.Throwable -> L4e
            goto L63
        L4e:
            r9 = move-exception
            goto L8d
        L50:
            com.bumptech.glide.c.C(r10)
            p6.c r10 = r8.f11686v     // Catch: java.lang.Throwable -> L8b
            r0.B = r8     // Catch: java.lang.Throwable -> L8b
            r0.C = r9     // Catch: java.lang.Throwable -> L8b
            r0.f11685z = r4     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r10 = r10.z(r9, r0)     // Catch: java.lang.Throwable -> L8b
            if (r10 != r6) goto L62
            goto La0
        L62:
            r1 = r8
        L63:
            te.g r10 = new te.g
            vd.h r3 = r0.f14484w
            ge.i.b(r3)
            r10.<init>(r9, r3)
            d1.r r9 = r1.f11687w     // Catch: java.lang.Throwable -> L83
            r0.B = r10     // Catch: java.lang.Throwable -> L83
            r0.C = r5     // Catch: java.lang.Throwable -> L83
            r0.f11685z = r2     // Catch: java.lang.Throwable -> L83
            java.lang.Object r9 = r9.g(r10, r5, r0)     // Catch: java.lang.Throwable -> L83
            if (r9 != r6) goto L7c
            goto La0
        L7c:
            r9 = r10
        L7d:
            r9.p()
            rd.l r9 = rd.l.f11003a
            return r9
        L83:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L87:
            r9.p()
            throw r10
        L8b:
            r9 = move-exception
            r1 = r8
        L8d:
            se.a0 r10 = new se.a0
            r10.<init>(r9)
            d1.r r1 = r1.f11687w
            r0.B = r9
            r0.C = r5
            r0.f11685z = r3
            java.lang.Object r10 = se.y.a(r10, r1, r9, r0)
            if (r10 != r6) goto La1
        La0:
            return r6
        La1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: se.h.z(se.d, xd.c):java.lang.Object");
    }
}
