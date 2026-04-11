package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 implements vd.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final o1 f3287v = new o1();

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a0, code lost:
    
        if (r0 != r1) goto L36;
     */
    /* JADX WARN: Path cross not found for [B:33:0x009a, B:27:0x0075], limit reached: 42 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.io.FileOutputStream r11, xd.c r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof d1.u0
            if (r0 == 0) goto L13
            r0 = r12
            d1.u0 r0 = (d1.u0) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            d1.u0 r0 = new d1.u0
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.A
            int r1 = r0.B
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            long r3 = r0.f3306z
            java.io.FileOutputStream r11 = r0.f3305y
            com.bumptech.glide.c.C(r12)
            r12 = r0
            goto La0
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L33:
            com.bumptech.glide.c.C(r12)
            r3 = 10
            r12 = r0
        L39:
            r0 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
        */
        //  java.lang.String r1 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
        /*
            if (r0 > 0) goto La5
            java.nio.channels.FileChannel r5 = r11.getChannel()     // Catch: java.io.IOException -> L56
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = 0
            r6 = 0
            java.nio.channels.FileLock r0 = r5.lock(r6, r8, r10)     // Catch: java.io.IOException -> L56
            ge.i.d(r0, r1)     // Catch: java.io.IOException -> L56
            goto Lb8
        L56:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto La4
            java.lang.String r5 = "Resource deadlock would occur"
            r6 = 0
            boolean r1 = ne.h.c0(r1, r5, r6)
            if (r1 != r2) goto La4
            r12.f3305y = r11
            r12.f3306z = r3
            r12.B = r2
            r0 = 0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            wd.a r1 = wd.a.f14143v
            if (r0 > 0) goto L75
            goto L9a
        L75:
            pe.h r0 = new pe.h
            vd.c r5 = u8.a.t(r12)
            r0.<init>(r2, r5)
            r0.w()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L93
            vd.h r5 = r0.f10237z
            pe.b0 r5 = pe.x.f(r5)
            r5.g0(r3, r0)
        L93:
            java.lang.Object r0 = r0.v()
            if (r0 != r1) goto L9a
            goto L9c
        L9a:
            rd.l r0 = rd.l.f11003a
        L9c:
            if (r0 != r1) goto La0
            r0 = r1
            goto Lb8
        La0:
            r0 = 2
            long r0 = (long) r0
            long r3 = r3 * r0
            goto L39
        La4:
            throw r0
        La5:
            java.nio.channels.FileChannel r5 = r11.getChannel()
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = 0
            r6 = 0
            java.nio.channels.FileLock r0 = r5.lock(r6, r8, r10)
            ge.i.d(r0, r1)
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.o1.a(java.io.FileOutputStream, xd.c):java.lang.Object");
    }
}
