package t4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements y4.a, se.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final y4.a f12116u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final se.a f12117v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public rd.h f12118w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Throwable f12119x;

    public f(y4.a aVar) {
        se.c cVar = new se.c(false);
        be.h.e(aVar, "delegate");
        this.f12116u = aVar;
        this.f12117v = cVar;
    }

    @Override // se.a
    public final void a(Object obj) {
        this.f12117v.a(null);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        this.f12116u.close();
    }

    @Override // se.a
    public final Object d(td.c cVar) {
        return this.f12117v.d(cVar);
    }

    @Override // y4.a
    public final y4.c e0(String str) {
        be.h.e(str, "sql");
        return this.f12116u.e0(str);
    }

    public final String toString() {
        return this.f12116u.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0135 A[LOOP:4: B:65:0x012f->B:67:0x0135, LOOP_END] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v1, types: [od.q] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(java.lang.StringBuilder r7) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.f.v(java.lang.StringBuilder):void");
    }
}
