package y4;

import java.util.concurrent.atomic.AtomicInteger;
import w4.c0;
import w4.d0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements d0, a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge.h f14866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c5.a f14867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f14868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0 f14869d;

    /* JADX WARN: Multi-variable type inference failed */
    public n(fe.p pVar, c5.a aVar) {
        ge.i.e(aVar, "delegate");
        this.f14866a = (ge.h) pVar;
        this.f14867b = aVar;
        this.f14868c = new AtomicInteger(0);
    }

    @Override // w4.d0
    public final Boolean a(vd.c cVar) {
        return Boolean.valueOf(this.f14869d != null || this.f14867b.c());
    }

    @Override // y4.a0
    public final c5.a b() {
        return this.f14867b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v3, types: [fe.p, ge.h] */
    @Override // w4.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r6, fe.l r7, xd.c r8) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r8 instanceof y4.k
            if (r0 == 0) goto L13
            r0 = r8
            y4.k r0 = (y4.k) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            y4.k r0 = new y4.k
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.A
            int r1 = r0.C
            r2 = 2
            r3 = 1
            wd.a r4 = wd.a.f14143v
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            com.bumptech.glide.c.C(r8)
            return r8
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            fe.l r7 = r0.f14863z
            java.lang.String r6 = r0.f14862y
            com.bumptech.glide.c.C(r8)
            goto L4a
        L3a:
            com.bumptech.glide.c.C(r8)
            r0.f14862y = r6
            r0.f14863z = r7
            r0.C = r3
            java.lang.Boolean r8 = r5.a(r0)
            if (r8 != r4) goto L4a
            goto L66
        L4a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r1 = 0
            if (r8 == 0) goto L68
            y4.l r8 = new y4.l
            r8.<init>(r5, r6, r7, r1)
            r0.f14862y = r1
            r0.f14863z = r1
            r0.C = r2
            ge.h r6 = r5.f14866a
            java.lang.Object r6 = r6.j(r8, r0)
            if (r6 != r4) goto L67
        L66:
            return r4
        L67:
            return r6
        L68:
            c5.a r8 = r5.f14867b
            c5.c r6 = r8.c0(r6)
            java.lang.Object r7 = r7.a(r6)     // Catch: java.lang.Throwable -> L76
            android.support.v4.media.session.b.d(r6, r1)
            return r7
        L76:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L78
        L78:
            r8 = move-exception
            android.support.v4.media.session.b.d(r6, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.n.c(java.lang.String, fe.l, xd.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [fe.p, ge.h] */
    @Override // w4.d0
    public final Object d(c0 c0Var, fe.p pVar, xd.h hVar) {
        return this.f14866a.j(new m(this, c0Var, pVar, null), hVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(w4.c0 r8, fe.p r9, xd.c r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof y4.j
            if (r0 == 0) goto L13
            r0 = r10
            y4.j r0 = (y4.j) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            y4.j r0 = new y4.j
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f14861z
            int r1 = r0.B
            java.lang.String r2 = "ROLLBACK TRANSACTION"
            r3 = 0
            java.util.concurrent.atomic.AtomicInteger r4 = r7.f14868c
            r5 = 1
            c5.a r6 = r7.f14867b
            if (r1 == 0) goto L38
            if (r1 != r5) goto L30
            int r5 = r0.f14860y
            com.bumptech.glide.c.C(r10)     // Catch: java.lang.Throwable -> L2e
            goto L78
        L2e:
            r8 = move-exception
            goto L8c
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            com.bumptech.glide.c.C(r10)
            int r10 = r8.ordinal()
            if (r10 == 0) goto L58
            if (r10 == r5) goto L52
            r1 = 2
            if (r10 != r1) goto L4c
            java.lang.String r10 = "BEGIN EXCLUSIVE TRANSACTION"
            android.support.v4.media.session.b.k(r6, r10)
            goto L5d
        L4c:
            a9.l r8 = new a9.l
            r8.<init>()
            throw r8
        L52:
            java.lang.String r10 = "BEGIN IMMEDIATE TRANSACTION"
            android.support.v4.media.session.b.k(r6, r10)
            goto L5d
        L58:
            java.lang.String r10 = "BEGIN DEFERRED TRANSACTION"
            android.support.v4.media.session.b.k(r6, r10)
        L5d:
            int r10 = r4.incrementAndGet()
            if (r10 <= 0) goto L65
            r7.f14869d = r8
        L65:
            y4.i r8 = new y4.i     // Catch: java.lang.Throwable -> L2e
            r10 = 0
            r8.<init>(r10, r7)     // Catch: java.lang.Throwable -> L2e
            r0.f14860y = r5     // Catch: java.lang.Throwable -> L2e
            r0.B = r5     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r10 = r9.j(r8, r0)     // Catch: java.lang.Throwable -> L2e
            wd.a r8 = wd.a.f14143v
            if (r10 != r8) goto L78
            return r8
        L78:
            int r8 = r4.decrementAndGet()
            if (r8 != 0) goto L80
            r7.f14869d = r3
        L80:
            if (r5 == 0) goto L88
            java.lang.String r8 = "END TRANSACTION"
            android.support.v4.media.session.b.k(r6, r8)
            return r10
        L88:
            android.support.v4.media.session.b.k(r6, r2)
            return r10
        L8c:
            throw r8     // Catch: java.lang.Throwable -> L8d
        L8d:
            r9 = move-exception
            int r10 = r4.decrementAndGet()     // Catch: android.database.SQLException -> L97
            if (r10 != 0) goto L99
            r7.f14869d = r3     // Catch: android.database.SQLException -> L97
            goto L99
        L97:
            r10 = move-exception
            goto L9d
        L99:
            android.support.v4.media.session.b.k(r6, r2)     // Catch: android.database.SQLException -> L97
            goto La0
        L9d:
            ab.b.c(r8, r10)
        La0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.n.e(w4.c0, fe.p, xd.c):java.lang.Object");
    }
}
