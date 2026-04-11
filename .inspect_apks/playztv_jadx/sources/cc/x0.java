package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f2725a = new x0();

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        if (r10 == r6) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [ob.d] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ob.d r9, td.c r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cc.p
            if (r0 == 0) goto L13
            r0 = r10
            cc.p r0 = (cc.p) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            cc.p r0 = new cc.p
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f2690y
            int r1 = r0.A
            java.lang.String r2 = ""
            java.lang.String r3 = "InstallationId"
            r4 = 2
            r5 = 1
            sd.a r6 = sd.a.f11942u
            if (r1 == 0) goto L48
            if (r1 == r5) goto L3e
            if (r1 != r4) goto L36
            java.lang.Object r9 = r0.f2689x
            java.lang.String r9 = (java.lang.String) r9
            i5.a.Q(r10)     // Catch: java.lang.Exception -> L33
            goto L93
        L33:
            r10 = move-exception
            goto L9c
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            java.lang.Object r9 = r0.f2689x
            ob.d r9 = (ob.d) r9
            i5.a.Q(r10)     // Catch: java.lang.Exception -> L46
            goto L65
        L46:
            r10 = move-exception
            goto L76
        L48:
            i5.a.Q(r10)
            r10 = r9
            ob.c r10 = (ob.c) r10     // Catch: java.lang.Exception -> L46
            o8.o r9 = r10.e()     // Catch: java.lang.Exception -> L46
            java.lang.String r1 = "firebaseInstallations.getToken(false)"
            be.h.d(r9, r1)     // Catch: java.lang.Exception -> L72
            r0.f2689x = r10     // Catch: java.lang.Exception -> L72
            r0.A = r5     // Catch: java.lang.Exception -> L72
            java.lang.Object r9 = cf.d.a(r9, r0)     // Catch: java.lang.Exception -> L72
            if (r9 != r6) goto L62
            goto L92
        L62:
            r7 = r10
            r10 = r9
            r9 = r7
        L65:
            ob.a r10 = (ob.a) r10     // Catch: java.lang.Exception -> L46
            java.lang.String r10 = r10.f9480a     // Catch: java.lang.Exception -> L46
            java.lang.String r1 = "{\n          firebaseInst…).await().token\n        }"
            be.h.d(r10, r1)     // Catch: java.lang.Exception -> L46
            r7 = r10
            r10 = r9
            r9 = r7
            goto L7d
        L72:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L76:
            java.lang.String r1 = "Error getting authentication token."
            android.util.Log.w(r3, r1, r10)
            r10 = r9
            r9 = r2
        L7d:
            ob.c r10 = (ob.c) r10     // Catch: java.lang.Exception -> L33
            o8.o r10 = r10.d()     // Catch: java.lang.Exception -> L33
            java.lang.String r1 = "firebaseInstallations.id"
            be.h.d(r10, r1)     // Catch: java.lang.Exception -> L33
            r0.f2689x = r9     // Catch: java.lang.Exception -> L33
            r0.A = r4     // Catch: java.lang.Exception -> L33
            java.lang.Object r10 = cf.d.a(r10, r0)     // Catch: java.lang.Exception -> L33
            if (r10 != r6) goto L93
        L92:
            return r6
        L93:
            java.lang.String r0 = "{\n          firebaseInst…ions.id.await()\n        }"
            be.h.d(r10, r0)     // Catch: java.lang.Exception -> L33
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L33
            r2 = r10
            goto La1
        L9c:
            java.lang.String r0 = "Error getting Firebase installation id ."
            android.util.Log.w(r3, r0, r10)
        La1:
            cc.q r10 = new cc.q
            r10.<init>(r2, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.x0.a(ob.d, td.c):java.lang.Object");
    }
}
