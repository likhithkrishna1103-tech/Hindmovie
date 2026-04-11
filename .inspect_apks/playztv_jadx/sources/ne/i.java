package ne;

import cc.d0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ be.m f9010u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c f9011v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d0 f9012w;

    public i(be.m mVar, c cVar, d0 d0Var) {
        this.f9010u = mVar;
        this.f9011v = cVar;
        this.f9012w = d0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ne.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r8, rd.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ne.h
            if (r0 == 0) goto L13
            r0 = r9
            ne.h r0 = (ne.h) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            ne.h r0 = new ne.h
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f9009z
            int r1 = r0.B
            r2 = 3
            r3 = 2
            nd.k r4 = nd.k.f8990a
            r5 = 1
            sd.a r6 = sd.a.f11942u
            if (r1 == 0) goto L43
            if (r1 == r5) goto L3f
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            i5.a.Q(r9)
            return r4
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            java.lang.Object r8 = r0.f9008y
            ne.i r1 = r0.f9007x
            i5.a.Q(r9)
            goto L67
        L3f:
            i5.a.Q(r9)
            return r4
        L43:
            i5.a.Q(r9)
            be.m r9 = r7.f9010u
            boolean r9 = r9.f2044u
            if (r9 == 0) goto L57
            r0.B = r5
            ne.c r9 = r7.f9011v
            java.lang.Object r8 = r9.j(r8, r0)
            if (r8 != r6) goto L83
            goto L82
        L57:
            r0.f9007x = r7
            r0.f9008y = r8
            r0.B = r3
            cc.d0 r9 = r7.f9012w
            java.lang.Object r9 = r9.i(r8, r0)
            if (r9 != r6) goto L66
            goto L82
        L66:
            r1 = r7
        L67:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L83
            be.m r9 = r1.f9010u
            r9.f2044u = r5
            ne.c r9 = r1.f9011v
            r1 = 0
            r0.f9007x = r1
            r0.f9008y = r1
            r0.B = r2
            java.lang.Object r8 = r9.j(r8, r0)
            if (r8 != r6) goto L83
        L82:
            return r6
        L83:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ne.i.j(java.lang.Object, rd.c):java.lang.Object");
    }
}
