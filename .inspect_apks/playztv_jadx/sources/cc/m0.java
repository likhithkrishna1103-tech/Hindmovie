package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements j0 {
    public static final double f = Math.random();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f2677g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ga.g f2678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ob.d f2679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ec.j f2680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u5.c f2681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rd.h f2682e;

    public m0(ga.g gVar, ob.d dVar, ec.j jVar, u5.c cVar, rd.h hVar) {
        this.f2678a = gVar;
        this.f2679b = dVar;
        this.f2680c = jVar;
        this.f2681d = cVar;
        this.f2682e = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(cc.m0 r4, td.c r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof cc.l0
            if (r0 == 0) goto L13
            r0 = r5
            cc.l0 r0 = (cc.l0) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            cc.l0 r0 = new cc.l0
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f2673y
            int r1 = r0.A
            r2 = 1
            java.lang.String r3 = "SessionFirelogPublisher"
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            cc.m0 r4 = r0.f2672x
            i5.a.Q(r5)
            goto L48
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            i5.a.Q(r5)
            java.lang.String r5 = "Data Collection is enabled for at least one Subscriber"
            android.util.Log.d(r3, r5)
            ec.j r5 = r4.f2680c
            r0.f2672x = r4
            r0.A = r2
            java.lang.Object r5 = r5.b(r0)
            sd.a r0 = sd.a.f11942u
            if (r5 != r0) goto L48
            return r0
        L48:
            ec.j r5 = r4.f2680c
            ec.a r0 = r5.f4663a
            java.lang.Boolean r0 = r0.a()
            if (r0 == 0) goto L57
            boolean r2 = r0.booleanValue()
            goto L63
        L57:
            ec.e r5 = r5.f4664b
            java.lang.Boolean r5 = r5.a()
            if (r5 == 0) goto L63
            boolean r2 = r5.booleanValue()
        L63:
            if (r2 != 0) goto L6d
            java.lang.String r4 = "Sessions SDK disabled. Events will not be sent."
            android.util.Log.d(r3, r4)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L6d:
            ec.j r4 = r4.f2680c
            double r4 = r4.a()
            double r0 = cc.m0.f
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 > 0) goto L7c
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            return r4
        L7c:
            java.lang.String r4 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r3, r4)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.m0.a(cc.m0, td.c):java.lang.Object");
    }
}
