package u4;

import ae.l;
import ae.p;
import r4.x;
import r4.y;
import t4.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements y, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f12767a;

    public d(a aVar) {
        this.f12767a = aVar;
    }

    @Override // r4.l
    public final Object a(String str, l lVar, td.c cVar) throws Exception {
        g gVarE0 = this.f12767a.e0(str);
        try {
            Object objA = lVar.a(gVarE0);
            cf.d.g(gVarE0, null);
            return objA;
        } finally {
        }
    }

    @Override // r4.y
    public final Object b(td.g gVar) {
        return Boolean.valueOf(this.f12767a.f12762u.D());
    }

    @Override // t4.q
    public final y4.a c() {
        return this.f12767a;
    }

    @Override // r4.y
    public final Object d(x xVar, p pVar, td.g gVar) {
        return e(xVar, pVar, gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(r4.x r5, ae.p r6, td.c r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof u4.c
            if (r0 == 0) goto L13
            r0 = r7
            u4.c r0 = (u4.c) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            u4.c r0 = new u4.c
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f12766z
            int r1 = r0.B
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            z4.a r5 = r0.f12765y
            u4.d r6 = r0.f12764x
            i5.a.Q(r7)     // Catch: java.lang.Throwable -> L29
            goto L72
        L29:
            r7 = move-exception
            goto L87
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            i5.a.Q(r7)
            u4.a r7 = r4.f12767a
            z4.a r7 = r7.f12762u
            r7.D()
            int r5 = r5.ordinal()
            if (r5 == 0) goto L56
            if (r5 == r2) goto L52
            r1 = 2
            if (r5 != r1) goto L4c
            r7.f()
            goto L59
        L4c:
            a2.y0 r5 = new a2.y0
            r5.<init>()
            throw r5
        L52:
            r7.R()
            goto L59
        L56:
            r7.A()
        L59:
            t4.j r5 = new t4.j     // Catch: java.lang.Throwable -> L82
            r1 = 1
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L82
            r0.f12764x = r4     // Catch: java.lang.Throwable -> L82
            r0.f12765y = r7     // Catch: java.lang.Throwable -> L82
            r0.B = r2     // Catch: java.lang.Throwable -> L82
            java.lang.Object r5 = r6.i(r5, r0)     // Catch: java.lang.Throwable -> L82
            sd.a r6 = sd.a.f11942u
            if (r5 != r6) goto L6e
            return r6
        L6e:
            r6 = r7
            r7 = r5
            r5 = r6
            r6 = r4
        L72:
            r5.Q()     // Catch: java.lang.Throwable -> L29
            r5.e()
            boolean r5 = r5.D()
            if (r5 != 0) goto L81
            r6.getClass()
        L81:
            return r7
        L82:
            r5 = move-exception
            r6 = r7
            r7 = r5
            r5 = r6
            r6 = r4
        L87:
            r5.e()
            boolean r5 = r5.D()
            if (r5 != 0) goto L93
            r6.getClass()
        L93:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.d.e(r4.x, ae.p, td.c):java.lang.Object");
    }
}
