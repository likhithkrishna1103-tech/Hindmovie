package d1;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xe.c f3259a = xe.d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pc.c f3260b = new pc.c(6);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l4.a f3261c = new l4.a((fe.p) new j1(2, null));

    public k1(String str) {
    }

    @Override // d1.s0
    public final Object a(xd.c cVar) {
        return new Integer(((AtomicInteger) this.f3260b.f10180v).get());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d1.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(fe.l r8, xd.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof d1.h1
            if (r0 == 0) goto L13
            r0 = r9
            d1.h1 r0 = (d1.h1) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            d1.h1 r0 = new d1.h1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.A
            int r1 = r0.C
            r2 = 2
            r3 = 1
            r4 = 0
            wd.a r5 = wd.a.f14143v
            if (r1 == 0) goto L45
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r8 = r0.f3245y
            xe.a r8 = (xe.a) r8
            com.bumptech.glide.c.C(r9)     // Catch: java.lang.Throwable -> L2f
            goto L67
        L2f:
            r9 = move-exception
            goto L6f
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            xe.c r8 = r0.f3246z
            java.lang.Object r1 = r0.f3245y
            fe.l r1 = (fe.l) r1
            com.bumptech.glide.c.C(r9)
            r9 = r8
            r8 = r1
            goto L57
        L45:
            com.bumptech.glide.c.C(r9)
            r0.f3245y = r8
            xe.c r9 = r7.f3259a
            r0.f3246z = r9
            r0.C = r3
            java.lang.Object r1 = r9.g(r0)
            if (r1 != r5) goto L57
            goto L63
        L57:
            r0.f3245y = r9     // Catch: java.lang.Throwable -> L6b
            r0.f3246z = r4     // Catch: java.lang.Throwable -> L6b
            r0.C = r2     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r8 = r8.a(r0)     // Catch: java.lang.Throwable -> L6b
            if (r8 != r5) goto L64
        L63:
            return r5
        L64:
            r6 = r9
            r9 = r8
            r8 = r6
        L67:
            r8.a(r4)
            return r9
        L6b:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L6f:
            r8.a(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.k1.b(fe.l, xd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // d1.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(fe.p r6, xd.c r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof d1.i1
            if (r0 == 0) goto L13
            r0 = r7
            d1.i1 r0 = (d1.i1) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            d1.i1 r0 = new d1.i1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.A
            int r1 = r0.C
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            boolean r6 = r0.f3250z
            xe.c r0 = r0.f3249y
            com.bumptech.glide.c.C(r7)     // Catch: java.lang.Throwable -> L2a
            goto L53
        L2a:
            r7 = move-exception
            goto L5d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            com.bumptech.glide.c.C(r7)
            xe.c r7 = r5.f3259a
            boolean r1 = r7.e()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L59
            r0.f3249y = r7     // Catch: java.lang.Throwable -> L59
            r0.f3250z = r1     // Catch: java.lang.Throwable -> L59
            r0.C = r2     // Catch: java.lang.Throwable -> L59
            java.lang.Object r6 = r6.j(r4, r0)     // Catch: java.lang.Throwable -> L59
            wd.a r0 = wd.a.f14143v
            if (r6 != r0) goto L50
            return r0
        L50:
            r0 = r7
            r7 = r6
            r6 = r1
        L53:
            if (r6 == 0) goto L58
            r0.a(r3)
        L58:
            return r7
        L59:
            r6 = move-exception
            r0 = r7
            r7 = r6
            r6 = r1
        L5d:
            if (r6 == 0) goto L62
            r0.a(r3)
        L62:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.k1.c(fe.p, xd.c):java.lang.Object");
    }

    @Override // d1.s0
    public final se.c d() {
        return this.f3261c;
    }

    @Override // d1.s0
    public final Object e(g0 g0Var) {
        return new Integer(((AtomicInteger) this.f3260b.f10180v).incrementAndGet());
    }
}
