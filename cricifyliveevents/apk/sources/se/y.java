package se;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d5.a f11720a = new d5.a(3, "NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d5.a f11721b = new d5.a(3, "PENDING");

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(se.a0 r4, d1.r r5, java.lang.Throwable r6, xd.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof se.f
            if (r0 == 0) goto L13
            r0 = r7
            se.f r0 = (se.f) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            se.f r0 = new se.f
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f11683z
            int r1 = r0.A
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            java.lang.Throwable r6 = r0.f11682y
            com.bumptech.glide.c.C(r7)     // Catch: java.lang.Throwable -> L27
            goto L41
        L27:
            r4 = move-exception
            goto L44
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            com.bumptech.glide.c.C(r7)
            r0.f11682y = r6     // Catch: java.lang.Throwable -> L27
            r0.A = r2     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r5.g(r4, r6, r0)     // Catch: java.lang.Throwable -> L27
            wd.a r5 = wd.a.f14143v
            if (r4 != r5) goto L41
            return r5
        L41:
            rd.l r4 = rd.l.f11003a
            return r4
        L44:
            if (r6 == 0) goto L4b
            if (r6 == r4) goto L4b
            ab.b.c(r4, r6)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: se.y.a(se.a0, d1.r, java.lang.Throwable, xd.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        if (r6.x().equals(r5) == false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable b(se.c r4, se.d r5, xd.c r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof se.k
            if (r0 == 0) goto L13
            r0 = r6
            se.k r0 = (se.k) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            se.k r0 = new se.k
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f11693z
            int r1 = r0.A
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            ge.p r4 = r0.f11692y
            com.bumptech.glide.c.C(r6)     // Catch: java.lang.Throwable -> L27
            goto L4b
        L27:
            r5 = move-exception
            goto L4f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            com.bumptech.glide.c.C(r6)
            ge.p r6 = new ge.p
            r6.<init>()
            se.m r1 = new se.m     // Catch: java.lang.Throwable -> L4d
            r1.<init>(r5, r6)     // Catch: java.lang.Throwable -> L4d
            r0.f11692y = r6     // Catch: java.lang.Throwable -> L4d
            r0.A = r2     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r4 = r4.z(r1, r0)     // Catch: java.lang.Throwable -> L4d
            wd.a r5 = wd.a.f14143v
            if (r4 != r5) goto L4b
            return r5
        L4b:
            r4 = 0
            return r4
        L4d:
            r5 = move-exception
            r4 = r6
        L4f:
            java.lang.Object r4 = r4.f5254v
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L5b
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L8d
        L5b:
            vd.h r6 = r0.f14484w
            ge.i.b(r6)
            pe.t r0 = pe.t.f10271w
            vd.f r6 = r6.C(r0)
            pe.v0 r6 = (pe.v0) r6
            if (r6 == 0) goto L8e
            pe.c1 r6 = (pe.c1) r6
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = pe.c1.f10226v
            java.lang.Object r0 = r0.get(r6)
            boolean r1 = r0 instanceof pe.p
            if (r1 != 0) goto L82
            boolean r1 = r0 instanceof pe.b1
            if (r1 == 0) goto L8e
            pe.b1 r0 = (pe.b1) r0
            boolean r0 = r0.e()
            if (r0 == 0) goto L8e
        L82:
            java.util.concurrent.CancellationException r6 = r6.x()
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L8d
            goto L8e
        L8d:
            throw r5
        L8e:
            if (r4 != 0) goto L91
            return r5
        L91:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L99
            ab.b.c(r4, r5)
            throw r4
        L99:
            ab.b.c(r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: se.y.b(se.c, se.d, xd.c):java.io.Serializable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
    
        if (r1.f(r11, r0) == r5) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x002f, B:25:0x005e, B:29:0x0072, B:31:0x007a, B:33:0x0080, B:35:0x0086, B:38:0x0097, B:39:0x009f, B:40:0x00a0, B:41:0x00a7, B:20:0x0049, B:24:0x0054), top: B:60:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0094 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(se.d r8, re.p r9, boolean r10, xd.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.y.c(se.d, re.p, boolean, xd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(se.c r5, xd.c r6) throws java.lang.Throwable {
        /*
            d5.a r0 = te.c.f12021b
            boolean r1 = r6 instanceof se.s
            if (r1 == 0) goto L15
            r1 = r6
            se.s r1 = (se.s) r1
            int r2 = r1.B
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.B = r2
            goto L1a
        L15:
            se.s r1 = new se.s
            r1.<init>(r6)
        L1a:
            java.lang.Object r6 = r1.A
            int r2 = r1.B
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            se.r r5 = r1.f11712z
            ge.p r1 = r1.f11711y
            com.bumptech.glide.c.C(r6)     // Catch: te.a -> L2b
            goto L5e
        L2b:
            r6 = move-exception
            goto L5a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            com.bumptech.glide.c.C(r6)
            ge.p r6 = new ge.p
            r6.<init>()
            r6.f5254v = r0
            se.r r2 = new se.r
            r4 = 0
            r2.<init>(r6, r4)
            r1.f11711y = r6     // Catch: te.a -> L56
            r1.f11712z = r2     // Catch: te.a -> L56
            r1.B = r3     // Catch: te.a -> L56
            java.lang.Object r5 = r5.z(r2, r1)     // Catch: te.a -> L56
            wd.a r1 = wd.a.f14143v
            if (r5 != r1) goto L54
            return r1
        L54:
            r1 = r6
            goto L5e
        L56:
            r5 = move-exception
            r1 = r6
            r6 = r5
            r5 = r2
        L5a:
            java.lang.Object r2 = r6.f12016v
            if (r2 != r5) goto L6b
        L5e:
            java.lang.Object r5 = r1.f5254v
            if (r5 == r0) goto L63
            return r5
        L63:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element"
            r5.<init>(r6)
            throw r5
        L6b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: se.y.d(se.c, xd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(se.c r4, xd.c r5) {
        /*
            boolean r0 = r5 instanceof se.t
            if (r0 == 0) goto L13
            r0 = r5
            se.t r0 = (se.t) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            se.t r0 = new se.t
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.A
            int r1 = r0.B
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            se.r r4 = r0.f11714z
            ge.p r0 = r0.f11713y
            com.bumptech.glide.c.C(r5)     // Catch: te.a -> L29
            goto L5a
        L29:
            r5 = move-exception
            goto L56
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            com.bumptech.glide.c.C(r5)
            ge.p r5 = new ge.p
            r5.<init>()
            se.r r1 = new se.r
            r3 = 1
            r1.<init>(r5, r3)
            r0.f11713y = r5     // Catch: te.a -> L52
            r0.f11714z = r1     // Catch: te.a -> L52
            r0.B = r2     // Catch: te.a -> L52
            java.lang.Object r4 = r4.z(r1, r0)     // Catch: te.a -> L52
            wd.a r0 = wd.a.f14143v
            if (r4 != r0) goto L50
            return r0
        L50:
            r0 = r5
            goto L5a
        L52:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r1
        L56:
            java.lang.Object r1 = r5.f12016v
            if (r1 != r4) goto L5d
        L5a:
            java.lang.Object r4 = r0.f5254v
            return r4
        L5d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: se.y.e(se.c, xd.c):java.lang.Object");
    }
}
