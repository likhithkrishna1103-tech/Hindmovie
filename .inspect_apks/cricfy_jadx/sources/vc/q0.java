package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 implements n0 {
    public static final double f = Math.random();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f13678g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ab.g f13679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.d f13680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final yc.j f13681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f13682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vd.h f13683e;

    public q0(ab.g gVar, ic.d dVar, yc.j jVar, l lVar, vd.h hVar) {
        ge.i.e(gVar, "firebaseApp");
        ge.i.e(dVar, "firebaseInstallations");
        ge.i.e(jVar, "sessionSettings");
        ge.i.e(lVar, "eventGDTLogger");
        ge.i.e(hVar, "backgroundDispatcher");
        this.f13679a = gVar;
        this.f13680b = dVar;
        this.f13681c = jVar;
        this.f13682d = lVar;
        this.f13683e = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        if (r7.b(r0) == r5) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(vc.q0 r6, xd.c r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof vc.p0
            if (r0 == 0) goto L13
            r0 = r7
            vc.p0 r0 = (vc.p0) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            vc.p0 r0 = new vc.p0
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f13676z
            int r1 = r0.B
            r2 = 2
            r3 = 1
            java.lang.String r4 = "FirebaseSessions"
            wd.a r5 = wd.a.f14143v
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            vc.q0 r6 = r0.f13675y
            com.bumptech.glide.c.C(r7)
            goto L80
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            vc.q0 r6 = r0.f13675y
            com.bumptech.glide.c.C(r7)
            goto L4c
        L3c:
            com.bumptech.glide.c.C(r7)
            wc.c r7 = wc.c.f14137a
            r0.f13675y = r6
            r0.B = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r5) goto L4c
            goto L7f
        L4c:
            java.util.Map r7 = (java.util.Map) r7
            java.util.Collection r7 = r7.values()
            if (r7 == 0) goto L5b
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L5b
            goto Lbc
        L5b:
            java.util.Iterator r7 = r7.iterator()
        L5f:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Lbc
            java.lang.Object r1 = r7.next()
            nb.i r1 = (nb.i) r1
            n8.k r1 = r1.f8944a
            boolean r1 = r1.a()
            if (r1 == 0) goto L5f
            yc.j r7 = r6.f13681c
            r0.f13675y = r6
            r0.B = r2
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r5) goto L80
        L7f:
            return r5
        L80:
            yc.j r7 = r6.f13681c
            yc.o r0 = r7.f15043a
            java.lang.Boolean r0 = r0.a()
            if (r0 == 0) goto L8f
            boolean r3 = r0.booleanValue()
            goto L9b
        L8f:
            yc.o r7 = r7.f15044b
            java.lang.Boolean r7 = r7.a()
            if (r7 == 0) goto L9b
            boolean r3 = r7.booleanValue()
        L9b:
            if (r3 != 0) goto La5
            java.lang.String r6 = "Sessions SDK disabled through settings API. Events will not be sent."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        La5:
            yc.j r6 = r6.f13681c
            double r6 = r6.a()
            double r0 = vc.q0.f
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto Lb4
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        Lb4:
            java.lang.String r6 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        Lbc:
            java.lang.String r6 = "Sessions SDK disabled through data collection. Events will not be sent."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.q0.a(vc.q0, xd.c):java.lang.Object");
    }
}
