package d1;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f3282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f3283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s0 f3284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.lifecycle.j0 f3285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f3286e;
    public final xe.c f;

    public o0(File file, f1 f1Var, s0 s0Var, androidx.lifecycle.j0 j0Var) {
        ge.i.e(f1Var, "serializer");
        ge.i.e(s0Var, "coordinator");
        this.f3282a = file;
        this.f3283b = f1Var;
        this.f3284c = s0Var;
        this.f3285d = j0Var;
        this.f3286e = new AtomicBoolean(false);
        this.f = xe.d.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[Catch: all -> 0x007a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x007a, blocks: (B:34:0x0079, B:43:0x0089, B:42:0x0086, B:39:0x0081), top: B:55:0x001e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [d1.o0] */
    /* JADX WARN: Type inference failed for: r0v14, types: [d1.o0] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [d1.m0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [d1.o0] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [d1.r] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(d1.r r7, xd.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof d1.m0
            if (r0 == 0) goto L13
            r0 = r8
            d1.m0 r0 = (d1.m0) r0
            int r1 = r0.D
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.D = r1
            goto L18
        L13:
            d1.m0 r0 = new d1.m0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.B
            int r1 = r0.D
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            boolean r7 = r0.A
            d1.j0 r1 = r0.f3274z
            d1.o0 r0 = r0.f3273y
            com.bumptech.glide.c.C(r8)     // Catch: java.lang.Throwable -> L2c
            goto L69
        L2c:
            r8 = move-exception
            goto L81
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            com.bumptech.glide.c.C(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r6.f3286e
            boolean r8 = r8.get()
            if (r8 != 0) goto L97
            xe.c r8 = r6.f
            boolean r8 = r8.e()
            d1.j0 r1 = new d1.j0     // Catch: java.lang.Throwable -> L8a
            java.io.File r4 = r6.f3282a     // Catch: java.lang.Throwable -> L8a
            d1.f1 r5 = r6.f3283b     // Catch: java.lang.Throwable -> L8a
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L8a
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L7c
            r0.f3273y = r6     // Catch: java.lang.Throwable -> L7c
            r0.f3274z = r1     // Catch: java.lang.Throwable -> L7c
            r0.A = r8     // Catch: java.lang.Throwable -> L7c
            r0.D = r2     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r7 = r7.g(r1, r4, r0)     // Catch: java.lang.Throwable -> L7c
            wd.a r0 = wd.a.f14143v
            if (r7 != r0) goto L65
            return r0
        L65:
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L69:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            r1 = r3
            goto L6f
        L6e:
            r1 = move-exception
        L6f:
            if (r1 != 0) goto L79
            if (r7 == 0) goto L78
            xe.c r7 = r0.f
            r7.a(r3)
        L78:
            return r8
        L79:
            throw r1     // Catch: java.lang.Throwable -> L7a
        L7a:
            r8 = move-exception
            goto L8f
        L7c:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L81:
            r1.close()     // Catch: java.lang.Throwable -> L85
            goto L89
        L85:
            r1 = move-exception
            ab.b.c(r8, r1)     // Catch: java.lang.Throwable -> L7a
        L89:
            throw r8     // Catch: java.lang.Throwable -> L7a
        L8a:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L8f:
            if (r7 == 0) goto L96
            xe.c r7 = r0.f
            r7.a(r3)
        L96:
            throw r8
        L97:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "StorageConnection has already been disposed."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.o0.a(d1.r, xd.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e0 A[Catch: all -> 0x011b, IOException -> 0x011e, TRY_ENTER, TryCatch #8 {IOException -> 0x011e, all -> 0x011b, blocks: (B:43:0x00e0, B:45:0x00e6, B:47:0x00ee, B:51:0x00fa, B:52:0x011a, B:48:0x00f3, B:59:0x0127, B:66:0x0134, B:65:0x0131, B:62:0x012c), top: B:90:0x0023, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0127 A[Catch: all -> 0x011b, IOException -> 0x011e, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x011e, all -> 0x011b, blocks: (B:43:0x00e0, B:45:0x00e6, B:47:0x00ee, B:51:0x00fa, B:52:0x011a, B:48:0x00f3, B:59:0x0127, B:66:0x0134, B:65:0x0131, B:62:0x012c), top: B:90:0x0023, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013e A[Catch: all -> 0x0135, TryCatch #2 {all -> 0x0135, blocks: (B:70:0x0138, B:72:0x013e, B:73:0x0141, B:33:0x009c, B:34:0x00b8), top: B:82:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [xe.a] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [xe.a] */
    /* JADX WARN: Type inference failed for: r3v8, types: [xe.a] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(d1.g0 r11, xd.c r12) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.o0.b(d1.g0, xd.c):java.lang.Object");
    }

    @Override // d1.b
    public final void close() {
        this.f3286e.set(true);
        this.f3285d.b();
    }
}
