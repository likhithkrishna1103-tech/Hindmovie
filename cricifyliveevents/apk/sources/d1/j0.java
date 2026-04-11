package d1;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class j0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f3253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f3254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f3255c;

    public j0(File file, f1 f1Var) {
        ge.i.e(f1Var, "serializer");
        this.f3253a = file;
        this.f3254b = f1Var;
        this.f3255c = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [d1.j0] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [d1.j0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [d1.j0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object a(d1.j0 r7, xd.c r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof d1.i0
            if (r0 == 0) goto L13
            r0 = r8
            d1.i0 r0 = (d1.i0) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            d1.i0 r0 = new d1.i0
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.A
            int r1 = r0.C
            r2 = 2
            r3 = 1
            r4 = 0
            wd.a r5 = wd.a.f14143v
            if (r1 == 0) goto L47
            if (r1 == r3) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r7 = r0.f3247y
            java.io.Closeable r7 = (java.io.Closeable) r7
            com.bumptech.glide.c.C(r8)     // Catch: java.lang.Throwable -> L30
            goto L9e
        L30:
            r8 = move-exception
            goto La6
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.io.FileInputStream r7 = r0.f3248z
            java.lang.Object r1 = r0.f3247y
            d1.j0 r1 = (d1.j0) r1
            com.bumptech.glide.c.C(r8)     // Catch: java.lang.Throwable -> L45
            goto L6c
        L45:
            r8 = move-exception
            goto L77
        L47:
            com.bumptech.glide.c.C(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f3255c
            boolean r8 = r8.get()
            if (r8 != 0) goto Lb1
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7d
            java.io.File r1 = r7.f3253a     // Catch: java.io.FileNotFoundException -> L7d
            r8.<init>(r1)     // Catch: java.io.FileNotFoundException -> L7d
            d1.f1 r1 = r7.f3254b     // Catch: java.lang.Throwable -> L72
            r0.f3247y = r7     // Catch: java.lang.Throwable -> L72
            r0.f3248z = r8     // Catch: java.lang.Throwable -> L72
            r0.C = r3     // Catch: java.lang.Throwable -> L72
            java.lang.Object r1 = r1.c(r8)     // Catch: java.lang.Throwable -> L72
            if (r1 != r5) goto L68
            goto L9a
        L68:
            r6 = r1
            r1 = r7
            r7 = r8
            r8 = r6
        L6c:
            com.bumptech.glide.e.b(r7, r4)     // Catch: java.io.FileNotFoundException -> L70
            return r8
        L70:
            r7 = r1
            goto L7d
        L72:
            r1 = move-exception
            r6 = r1
            r1 = r7
            r7 = r8
            r8 = r6
        L77:
            throw r8     // Catch: java.lang.Throwable -> L78
        L78:
            r3 = move-exception
            com.bumptech.glide.e.b(r7, r8)     // Catch: java.io.FileNotFoundException -> L70
            throw r3     // Catch: java.io.FileNotFoundException -> L70
        L7d:
            java.io.File r8 = r7.f3253a
            d1.f1 r1 = r7.f3254b
            boolean r8 = r8.exists()
            if (r8 == 0) goto Lac
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r7 = r7.f3253a
            r8.<init>(r7)
            r0.f3247y = r8     // Catch: java.lang.Throwable -> La2
            r0.f3248z = r4     // Catch: java.lang.Throwable -> La2
            r0.C = r2     // Catch: java.lang.Throwable -> La2
            java.lang.Object r7 = r1.c(r8)     // Catch: java.lang.Throwable -> La2
            if (r7 != r5) goto L9b
        L9a:
            return r5
        L9b:
            r6 = r8
            r8 = r7
            r7 = r6
        L9e:
            com.bumptech.glide.e.b(r7, r4)
            return r8
        La2:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        La6:
            throw r8     // Catch: java.lang.Throwable -> La7
        La7:
            r0 = move-exception
            com.bumptech.glide.e.b(r7, r8)
            throw r0
        Lac:
            java.lang.Object r7 = r1.a()
            return r7
        Lb1:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "This scope has already been closed."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.j0.a(d1.j0, xd.c):java.lang.Object");
    }

    @Override // d1.b
    public final void close() {
        this.f3255c.set(true);
    }
}
