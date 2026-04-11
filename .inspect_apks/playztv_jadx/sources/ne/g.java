package ne;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ c f9005u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ be.n f9006v;

    public g(c cVar, be.n nVar) {
        this.f9005u = cVar;
        this.f9006v = nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ne.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r5, rd.c r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ne.f
            if (r0 == 0) goto L13
            r0 = r6
            ne.f r0 = (ne.f) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            ne.f r0 = new ne.f
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f9003y
            int r1 = r0.A
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            ne.g r5 = r0.f9002x
            i5.a.Q(r6)     // Catch: java.lang.Throwable -> L27
            goto L43
        L27:
            r6 = move-exception
            goto L48
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            i5.a.Q(r6)
            ne.c r6 = r4.f9005u     // Catch: java.lang.Throwable -> L46
            r0.f9002x = r4     // Catch: java.lang.Throwable -> L46
            r0.A = r2     // Catch: java.lang.Throwable -> L46
            java.lang.Object r5 = r6.j(r5, r0)     // Catch: java.lang.Throwable -> L46
            sd.a r6 = sd.a.f11942u
            if (r5 != r6) goto L43
            return r6
        L43:
            nd.k r5 = nd.k.f8990a
            return r5
        L46:
            r6 = move-exception
            r5 = r4
        L48:
            be.n r5 = r5.f9006v
            r5.f2045u = r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ne.g.j(java.lang.Object, rd.c):java.lang.Object");
    }
}
