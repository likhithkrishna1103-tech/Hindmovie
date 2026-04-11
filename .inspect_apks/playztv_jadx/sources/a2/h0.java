package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h0 implements s1.m, g4.l0, s1.h, k7.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f254u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f255v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f256w;

    public /* synthetic */ h0(int i, p1.v0 v0Var, p1.v0 v0Var2) {
        this.f254u = i;
        this.f255v = v0Var;
        this.f256w = v0Var2;
    }

    @Override // s1.m
    public void a(Object obj) {
        p1.v0 v0Var = (p1.v0) this.f255v;
        p1.v0 v0Var2 = (p1.v0) this.f256w;
        p1.u0 u0Var = (p1.u0) obj;
        int i = this.f254u;
        u0Var.j(i);
        u0Var.F(i, v0Var, v0Var2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    @Override // s1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void accept(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f255v
            g4.b0 r0 = (g4.b0) r0
            java.lang.Object r1 = r4.f256w
            g4.s r1 = (g4.s) r1
            ea.y r5 = (ea.y) r5
            java.lang.String r2 = "MediaSessionStub"
            java.lang.Object r5 = r5.get()     // Catch: java.lang.InterruptedException -> L18 java.util.concurrent.ExecutionException -> L1a java.util.concurrent.CancellationException -> L1c
            g4.q1 r5 = (g4.q1) r5     // Catch: java.lang.InterruptedException -> L18 java.util.concurrent.ExecutionException -> L1a java.util.concurrent.CancellationException -> L1c
            java.lang.String r3 = "SessionResult must not be null"
            s1.d.e(r5, r3)     // Catch: java.lang.InterruptedException -> L18 java.util.concurrent.ExecutionException -> L1a java.util.concurrent.CancellationException -> L1c
            goto L40
        L18:
            r5 = move-exception
            goto L1e
        L1a:
            r5 = move-exception
            goto L1e
        L1c:
            r5 = move-exception
            goto L35
        L1e:
            java.lang.String r3 = "Session operation failed"
            s1.b.q(r2, r3, r5)
            g4.q1 r2 = new g4.q1
            java.lang.Throwable r5 = r5.getCause()
            boolean r5 = r5 instanceof java.lang.UnsupportedOperationException
            if (r5 == 0) goto L2f
            r5 = -6
            goto L30
        L2f:
            r5 = -1
        L30:
            r2.<init>(r5)
            r5 = r2
            goto L40
        L35:
            java.lang.String r3 = "Session operation cancelled"
            s1.b.q(r2, r3, r5)
            g4.q1 r5 = new g4.q1
            r2 = 1
            r5.<init>(r2)
        L40:
            int r2 = r4.f254u
            g4.f1.L(r0, r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.h0.accept(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    @Override // g4.l0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(g4.s r20) {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.h0.d(g4.s):void");
    }

    @Override // k7.b
    public Object h() {
        b7.s sVar = (b7.s) this.f255v;
        ((a7.b) sVar.f1901d).C((c7.j) this.f256w, this.f254u + 1, false);
        return null;
    }

    public /* synthetic */ h0(Object obj, int i, Object obj2) {
        this.f255v = obj;
        this.f256w = obj2;
        this.f254u = i;
    }
}
