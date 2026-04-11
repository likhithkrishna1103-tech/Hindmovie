package hf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f6131u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f6132v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public r f6133w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6134x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6135y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f6136z;

    public o(h hVar) {
        this.f6131u = hVar;
        f fVarB = hVar.B();
        this.f6132v = fVarB;
        r rVar = fVarB.f6112u;
        this.f6133w = rVar;
        this.f6134x = rVar != null ? rVar.f6144b : -1;
    }

    @Override // hf.w
    public final y c() {
        return this.f6131u.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6135y = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r9 == r0.f6144b) goto L13;
     */
    @Override // hf.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l(long r9, hf.f r11) {
        /*
            r8 = this;
            java.lang.String r9 = "sink"
            be.h.e(r11, r9)
            boolean r9 = r8.f6135y
            if (r9 != 0) goto L5c
            hf.r r9 = r8.f6133w
            hf.f r10 = r8.f6132v
            if (r9 == 0) goto L25
            hf.r r0 = r10.f6112u
            if (r9 != r0) goto L1d
            int r9 = r8.f6134x
            be.h.b(r0)
            int r0 = r0.f6144b
            if (r9 != r0) goto L1d
            goto L25
        L1d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L25:
            long r0 = r8.f6136z
            r2 = 1
            long r0 = r0 + r2
            hf.h r9 = r8.f6131u
            boolean r9 = r9.q(r0)
            if (r9 != 0) goto L35
            r9 = -1
            return r9
        L35:
            hf.r r9 = r8.f6133w
            if (r9 != 0) goto L43
            hf.r r9 = r10.f6112u
            if (r9 == 0) goto L43
            r8.f6133w = r9
            int r9 = r9.f6144b
            r8.f6134x = r9
        L43:
            long r9 = r10.f6113v
            long r0 = r8.f6136z
            long r9 = r9 - r0
            r0 = 8192(0x2000, double:4.0474E-320)
            long r6 = java.lang.Math.min(r0, r9)
            hf.f r2 = r8.f6132v
            long r4 = r8.f6136z
            r3 = r11
            r2.d(r3, r4, r6)
            long r9 = r8.f6136z
            long r9 = r9 + r6
            r8.f6136z = r9
            return r6
        L5c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: hf.o.l(long, hf.f):long");
    }
}
