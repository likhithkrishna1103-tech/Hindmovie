package ag;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements w {
    public long A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f448v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f449w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public r f450x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f451y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f452z;

    public n(g gVar) {
        this.f448v = gVar;
        e eVarW = gVar.w();
        this.f449w = eVarW;
        r rVar = eVarW.f428v;
        this.f450x = rVar;
        this.f451y = rVar != null ? rVar.f463b : -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r9 == r0.f463b) goto L13;
     */
    @Override // ag.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long U(long r9, ag.e r11) {
        /*
            r8 = this;
            java.lang.String r9 = "sink"
            ge.i.e(r11, r9)
            boolean r9 = r8.f452z
            if (r9 != 0) goto L5c
            ag.r r9 = r8.f450x
            ag.e r10 = r8.f449w
            if (r9 == 0) goto L25
            ag.r r0 = r10.f428v
            if (r9 != r0) goto L1d
            int r9 = r8.f451y
            ge.i.b(r0)
            int r0 = r0.f463b
            if (r9 != r0) goto L1d
            goto L25
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L25:
            long r0 = r8.A
            r2 = 1
            long r0 = r0 + r2
            ag.g r9 = r8.f448v
            boolean r9 = r9.o(r0)
            if (r9 != 0) goto L35
            r9 = -1
            return r9
        L35:
            ag.r r9 = r8.f450x
            if (r9 != 0) goto L43
            ag.r r9 = r10.f428v
            if (r9 == 0) goto L43
            r8.f450x = r9
            int r9 = r9.f463b
            r8.f451y = r9
        L43:
            long r9 = r10.f429w
            long r0 = r8.A
            long r9 = r9 - r0
            r0 = 8192(0x2000, double:4.0474E-320)
            long r6 = java.lang.Math.min(r0, r9)
            ag.e r2 = r8.f449w
            long r4 = r8.A
            r3 = r11
            r2.g(r3, r4, r6)
            long r9 = r8.A
            long r9 = r9 + r6
            r8.A = r9
            return r6
        L5c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.n.U(long, ag.e):long");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f452z = true;
    }

    @Override // ag.w, ag.u
    public final y d() {
        return this.f448v.d();
    }
}
