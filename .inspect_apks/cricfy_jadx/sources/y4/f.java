package y4;

import androidx.media3.decoder.DecoderInputBuffer;
import c.d0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements b {
    public final long A;
    public final int B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s f14847v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s f14848w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final x2.b f14849x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ThreadLocal f14850y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f14851z;

    public f(vb.b bVar) {
        this.f14849x = new x2.b();
        this.f14850y = new ThreadLocal();
        int i = oe.a.f9767y;
        this.A = com.bumptech.glide.d.D(30, oe.c.SECONDS);
        this.B = 2;
        s sVar = new s(1, new d0(11, bVar));
        this.f14847v = sVar;
        this.f14848w = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151 A[Catch: all -> 0x01ae, TRY_LEAVE, TryCatch #4 {all -> 0x01ae, blocks: (B:64:0x0128, B:69:0x0146, B:71:0x0151, B:86:0x01b2, B:87:0x01b9), top: B:115:0x0128 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b2 A[Catch: all -> 0x01ae, TRY_ENTER, TryCatch #4 {all -> 0x01ae, blocks: (B:64:0x0128, B:69:0x0146, B:71:0x0151, B:86:0x01b2, B:87:0x01b9), top: B:115:0x0128 }] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v1, types: [y4.d] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object, y4.s] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [y4.s] */
    /* JADX WARN: Type inference failed for: r4v7, types: [y4.s] */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T(boolean r18, fe.p r19, xd.c r20) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.f.T(boolean, fe.p, xd.c):java.lang.Object");
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f14851z) {
            return;
        }
        this.f14851z = true;
        this.f14847v.c();
        this.f14848w.c();
    }

    public f(final vb.b bVar, final String str, int i) {
        ge.i.e(str, "fileName");
        this.f14849x = new x2.b();
        this.f14850y = new ThreadLocal();
        int i10 = oe.a.f9767y;
        this.A = com.bumptech.glide.d.D(30, oe.c.SECONDS);
        this.B = 2;
        if (i > 0) {
            final int i11 = 0;
            this.f14847v = new s(i, new fe.a() { // from class: y4.c
                @Override // fe.a
                public final Object b() throws Exception {
                    switch (i11) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            c5.a aVarA = bVar.a(str);
                            android.support.v4.media.session.b.k(aVarA, "PRAGMA query_only = 1");
                            return aVarA;
                        default:
                            return bVar.a(str);
                    }
                }
            });
            final int i12 = 1;
            this.f14848w = new s(1, new fe.a() { // from class: y4.c
                @Override // fe.a
                public final Object b() throws Exception {
                    switch (i12) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            c5.a aVarA = bVar.a(str);
                            android.support.v4.media.session.b.k(aVarA, "PRAGMA query_only = 1");
                            return aVarA;
                        default:
                            return bVar.a(str);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
    }
}
