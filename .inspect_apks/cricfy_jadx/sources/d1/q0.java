package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends j0 {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r6, xd.c r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof d1.p0
            if (r0 == 0) goto L13
            r0 = r7
            d1.p0 r0 = (d1.p0) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            d1.p0 r0 = new d1.p0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.A
            int r1 = r0.C
            rd.l r2 = rd.l.f11003a
            r3 = 1
            if (r1 == 0) goto L35
            if (r1 != r3) goto L2d
            java.io.FileOutputStream r6 = r0.f3290z
            java.io.FileOutputStream r0 = r0.f3289y
            com.bumptech.glide.c.C(r7)     // Catch: java.lang.Throwable -> L2b
            goto L5e
        L2b:
            r6 = move-exception
            goto L6c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            com.bumptech.glide.c.C(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.f3255c
            boolean r7 = r7.get()
            if (r7 != 0) goto L72
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r1 = r5.f3253a
            r7.<init>(r1)
            d1.f1 r1 = r5.f3254b     // Catch: java.lang.Throwable -> L6a
            d1.n1 r4 = new d1.n1     // Catch: java.lang.Throwable -> L6a
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L6a
            r0.f3289y = r7     // Catch: java.lang.Throwable -> L6a
            r0.f3290z = r7     // Catch: java.lang.Throwable -> L6a
            r0.C = r3     // Catch: java.lang.Throwable -> L6a
            r1.b(r6, r4)     // Catch: java.lang.Throwable -> L6a
            wd.a r6 = wd.a.f14143v
            if (r2 != r6) goto L5c
            return r6
        L5c:
            r6 = r7
            r0 = r6
        L5e:
            java.io.FileDescriptor r6 = r6.getFD()     // Catch: java.lang.Throwable -> L2b
            r6.sync()     // Catch: java.lang.Throwable -> L2b
            r6 = 0
            com.bumptech.glide.e.b(r0, r6)
            return r2
        L6a:
            r6 = move-exception
            r0 = r7
        L6c:
            throw r6     // Catch: java.lang.Throwable -> L6d
        L6d:
            r7 = move-exception
            com.bumptech.glide.e.b(r0, r6)
            throw r7
        L72:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "This scope has already been closed."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.q0.b(java.lang.Object, xd.c):java.lang.Object");
    }
}
