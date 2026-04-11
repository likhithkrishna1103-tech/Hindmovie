package y4;

import w4.c0;
import w4.d0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements d0, a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x2.b f14899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f14900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sd.h f14902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f14903e;

    public z(x2.b bVar, h hVar, boolean z10) {
        ge.i.e(bVar, "connectionElementKey");
        this.f14899a = bVar;
        this.f14900b = hVar;
        this.f14901c = z10;
        this.f14902d = new sd.h();
    }

    @Override // w4.d0
    public final Boolean a(vd.c cVar) {
        if (this.f14903e) {
            android.support.v4.media.session.b.N(21, "Connection is recycled");
            throw null;
        }
        vd.h hVar = ((xd.c) cVar).f14484w;
        ge.i.b(hVar);
        a aVar = (a) hVar.C(this.f14899a);
        if (aVar != null && aVar.f14839w == this) {
            return Boolean.valueOf(!this.f14902d.isEmpty() || this.f14900b.f14853v.c());
        }
        android.support.v4.media.session.b.N(21, "Attempted to use connection on a different coroutine");
        throw null;
    }

    @Override // y4.a0
    public final c5.a b() {
        return this.f14900b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // w4.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r7, fe.l r8, xd.c r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof y4.y
            if (r0 == 0) goto L13
            r0 = r9
            y4.y r0 = (y4.y) r0
            int r1 = r0.D
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.D = r1
            goto L18
        L13:
            y4.y r0 = new y4.y
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.B
            wd.a r1 = wd.a.f14143v
            int r2 = r0.D
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            y4.h r7 = r0.A
            fe.l r8 = r0.f14898z
            java.lang.String r0 = r0.f14897y
            com.bumptech.glide.c.C(r9)
            r9 = r7
            r7 = r0
            goto L67
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            com.bumptech.glide.c.C(r9)
            boolean r9 = r6.f14903e
            r2 = 21
            if (r9 != 0) goto L90
            vd.h r9 = r0.f14484w
            ge.i.b(r9)
            x2.b r5 = r6.f14899a
            vd.f r9 = r9.C(r5)
            y4.a r9 = (y4.a) r9
            if (r9 == 0) goto L8a
            y4.z r9 = r9.f14839w
            if (r9 != r6) goto L8a
            y4.h r9 = r6.f14900b
            r0.f14897y = r7
            r0.f14898z = r8
            r0.A = r9
            r0.D = r3
            xe.a r2 = r9.f14854w
            java.lang.Object r0 = r2.g(r0)
            if (r0 != r1) goto L67
            return r1
        L67:
            y4.t r0 = new y4.t     // Catch: java.lang.Throwable -> L7d
            y4.h r1 = r6.f14900b     // Catch: java.lang.Throwable -> L7d
            c5.c r7 = r1.c0(r7)     // Catch: java.lang.Throwable -> L7d
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r7 = r8.a(r0)     // Catch: java.lang.Throwable -> L7f
            android.support.v4.media.session.b.d(r0, r4)     // Catch: java.lang.Throwable -> L7d
            r9.a(r4)
            return r7
        L7d:
            r7 = move-exception
            goto L86
        L7f:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L81
        L81:
            r8 = move-exception
            android.support.v4.media.session.b.d(r0, r7)     // Catch: java.lang.Throwable -> L7d
            throw r8     // Catch: java.lang.Throwable -> L7d
        L86:
            r9.a(r4)
            throw r7
        L8a:
            java.lang.String r7 = "Attempted to use connection on a different coroutine"
            android.support.v4.media.session.b.N(r2, r7)
            throw r4
        L90:
            java.lang.String r7 = "Connection is recycled"
            android.support.v4.media.session.b.N(r2, r7)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.z.c(java.lang.String, fe.l, xd.c):java.lang.Object");
    }

    @Override // w4.d0
    public final Object d(c0 c0Var, fe.p pVar, xd.h hVar) {
        if (this.f14903e) {
            android.support.v4.media.session.b.N(21, "Connection is recycled");
            throw null;
        }
        vd.h hVar2 = hVar.f14484w;
        ge.i.b(hVar2);
        a aVar = (a) hVar2.C(this.f14899a);
        if (aVar != null && aVar.f14839w == this) {
            return g(c0Var, pVar, hVar);
        }
        android.support.v4.media.session.b.N(21, "Attempted to use connection on a different coroutine");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(w4.c0 r8, xd.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            sd.h r0 = r7.f14902d
            java.lang.String r1 = "SAVEPOINT '"
            boolean r2 = r9 instanceof y4.v
            if (r2 == 0) goto L17
            r2 = r9
            y4.v r2 = (y4.v) r2
            int r3 = r2.C
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.C = r3
            goto L1c
        L17:
            y4.v r2 = new y4.v
            r2.<init>(r7, r9)
        L1c:
            java.lang.Object r9 = r2.A
            int r3 = r2.C
            r4 = 1
            y4.h r5 = r7.f14900b
            if (r3 == 0) goto L39
            if (r3 != r4) goto L31
            y4.h r8 = r2.f14892z
            w4.c0 r2 = r2.f14891y
            com.bumptech.glide.c.C(r9)
            r9 = r8
            r8 = r2
            goto L4e
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            com.bumptech.glide.c.C(r9)
            r2.f14891y = r8
            r2.f14892z = r5
            r2.C = r4
            xe.a r9 = r5.f14854w
            java.lang.Object r9 = r9.g(r2)
            wd.a r2 = wd.a.f14143v
            if (r9 != r2) goto L4d
            return r2
        L4d:
            r9 = r5
        L4e:
            r2 = 0
            int r3 = r0.f11665x     // Catch: java.lang.Throwable -> L68
            boolean r6 = r0.isEmpty()     // Catch: java.lang.Throwable -> L68
            if (r6 == 0) goto L7c
            int r8 = r8.ordinal()     // Catch: java.lang.Throwable -> L68
            if (r8 == 0) goto L76
            if (r8 == r4) goto L70
            r1 = 2
            if (r8 != r1) goto L6a
            java.lang.String r8 = "BEGIN EXCLUSIVE TRANSACTION"
            android.support.v4.media.session.b.k(r5, r8)     // Catch: java.lang.Throwable -> L68
            goto L90
        L68:
            r8 = move-exception
            goto L9e
        L6a:
            a9.l r8 = new a9.l     // Catch: java.lang.Throwable -> L68
            r8.<init>()     // Catch: java.lang.Throwable -> L68
            throw r8     // Catch: java.lang.Throwable -> L68
        L70:
            java.lang.String r8 = "BEGIN IMMEDIATE TRANSACTION"
            android.support.v4.media.session.b.k(r5, r8)     // Catch: java.lang.Throwable -> L68
            goto L90
        L76:
            java.lang.String r8 = "BEGIN DEFERRED TRANSACTION"
            android.support.v4.media.session.b.k(r5, r8)     // Catch: java.lang.Throwable -> L68
            goto L90
        L7c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L68
            r8.append(r3)     // Catch: java.lang.Throwable -> L68
            r1 = 39
            r8.append(r1)     // Catch: java.lang.Throwable -> L68
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L68
            android.support.v4.media.session.b.k(r5, r8)     // Catch: java.lang.Throwable -> L68
        L90:
            y4.u r8 = new y4.u     // Catch: java.lang.Throwable -> L68
            r8.<init>(r3)     // Catch: java.lang.Throwable -> L68
            r0.addLast(r8)     // Catch: java.lang.Throwable -> L68
            rd.l r8 = rd.l.f11003a     // Catch: java.lang.Throwable -> L68
            r9.a(r2)
            return r8
        L9e:
            r9.a(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.z.e(w4.c0, xd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(boolean r8, xd.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            sd.h r0 = r7.f14902d
            java.lang.String r1 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            java.lang.String r2 = "RELEASE SAVEPOINT '"
            boolean r3 = r9 instanceof y4.w
            if (r3 == 0) goto L19
            r3 = r9
            y4.w r3 = (y4.w) r3
            int r4 = r3.C
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.C = r4
            goto L1e
        L19:
            y4.w r3 = new y4.w
            r3.<init>(r7, r9)
        L1e:
            java.lang.Object r9 = r3.A
            int r4 = r3.C
            r5 = 1
            y4.h r6 = r7.f14900b
            if (r4 == 0) goto L39
            if (r4 != r5) goto L31
            boolean r8 = r3.f14893y
            y4.h r3 = r3.f14894z
            com.bumptech.glide.c.C(r9)
            goto L4e
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            com.bumptech.glide.c.C(r9)
            r3.f14894z = r6
            r3.f14893y = r8
            r3.C = r5
            xe.a r9 = r6.f14854w
            java.lang.Object r9 = r9.g(r3)
            wd.a r3 = wd.a.f14143v
            if (r9 != r3) goto L4d
            return r3
        L4d:
            r3 = r6
        L4e:
            r9 = 0
            boolean r4 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6e
            if (r4 != 0) goto Lab
            java.lang.Object r4 = sd.j.n0(r0)     // Catch: java.lang.Throwable -> L6e
            y4.u r4 = (y4.u) r4     // Catch: java.lang.Throwable -> L6e
            r5 = 39
            if (r8 == 0) goto L85
            r4.getClass()     // Catch: java.lang.Throwable -> L6e
            boolean r8 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6e
            if (r8 == 0) goto L70
            java.lang.String r8 = "END TRANSACTION"
            android.support.v4.media.session.b.k(r6, r8)     // Catch: java.lang.Throwable -> L6e
            goto La5
        L6e:
            r8 = move-exception
            goto Lb3
        L70:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L6e
            int r0 = r4.f14890a     // Catch: java.lang.Throwable -> L6e
            r8.append(r0)     // Catch: java.lang.Throwable -> L6e
            r8.append(r5)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L6e
            android.support.v4.media.session.b.k(r6, r8)     // Catch: java.lang.Throwable -> L6e
            goto La5
        L85:
            boolean r8 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6e
            if (r8 == 0) goto L91
            java.lang.String r8 = "ROLLBACK TRANSACTION"
            android.support.v4.media.session.b.k(r6, r8)     // Catch: java.lang.Throwable -> L6e
            goto La5
        L91:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L6e
            int r0 = r4.f14890a     // Catch: java.lang.Throwable -> L6e
            r8.append(r0)     // Catch: java.lang.Throwable -> L6e
            r8.append(r5)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L6e
            android.support.v4.media.session.b.k(r6, r8)     // Catch: java.lang.Throwable -> L6e
        La5:
            rd.l r8 = rd.l.f11003a     // Catch: java.lang.Throwable -> L6e
            r3.a(r9)
            return r8
        Lab:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = "Not in a transaction"
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L6e
            throw r8     // Catch: java.lang.Throwable -> L6e
        Lb3:
            r3.a(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.z.f(boolean, xd.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
    
        if (f(false, r0) != r7) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v0, types: [fe.p, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v4, types: [fe.p] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, y4.z] */
    /* JADX WARN: Type inference failed for: r9v0, types: [w4.c0] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v5, types: [w4.c0] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(w4.c0 r9, fe.p r10, xd.c r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof y4.x
            if (r0 == 0) goto L13
            r0 = r11
            y4.x r0 = (y4.x) r0
            int r1 = r0.D
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.D = r1
            goto L18
        L13:
            y4.x r0 = new y4.x
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.B
            int r1 = r0.D
            r2 = 0
            r3 = 5
            r4 = 3
            r5 = 2
            r6 = 1
            wd.a r7 = wd.a.f14143v
            if (r1 == 0) goto L5d
            if (r1 == r6) goto L54
            if (r1 == r5) goto L4b
            if (r1 == r4) goto L45
            r9 = 4
            if (r1 == r9) goto L45
            if (r1 == r3) goto L38
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            java.lang.Throwable r9 = r0.f14896z
            java.lang.Object r10 = r0.f14895y
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            com.bumptech.glide.c.C(r11)     // Catch: android.database.SQLException -> L43
            goto La7
        L43:
            r11 = move-exception
            goto La2
        L45:
            java.lang.Object r9 = r0.f14895y
            com.bumptech.glide.c.C(r11)
            return r9
        L4b:
            int r9 = r0.A
            com.bumptech.glide.c.C(r11)     // Catch: java.lang.Throwable -> L51
            goto L84
        L51:
            r9 = move-exception
            r10 = r9
            goto L93
        L54:
            java.lang.Object r9 = r0.f14895y
            r10 = r9
            fe.p r10 = (fe.p) r10
            com.bumptech.glide.c.C(r11)
            goto L6f
        L5d:
            com.bumptech.glide.c.C(r11)
            if (r9 != 0) goto L64
            w4.c0 r9 = w4.c0.f13925v
        L64:
            r0.f14895y = r10
            r0.D = r6
            java.lang.Object r9 = r8.e(r9, r0)
            if (r9 != r7) goto L6f
            goto La1
        L6f:
            y4.i r9 = new y4.i     // Catch: java.lang.Throwable -> L51
            r11 = 1
            r9.<init>(r11, r8)     // Catch: java.lang.Throwable -> L51
            r11 = 0
            r0.f14895y = r11     // Catch: java.lang.Throwable -> L51
            r0.A = r6     // Catch: java.lang.Throwable -> L51
            r0.D = r5     // Catch: java.lang.Throwable -> L51
            java.lang.Object r11 = r10.j(r9, r0)     // Catch: java.lang.Throwable -> L51
            if (r11 != r7) goto L83
            goto La1
        L83:
            r9 = r6
        L84:
            if (r9 == 0) goto L87
            r2 = r6
        L87:
            r0.f14895y = r11
            r0.D = r4
            java.lang.Object r9 = r8.f(r2, r0)
            if (r9 != r7) goto L92
            goto La1
        L92:
            return r11
        L93:
            throw r10     // Catch: java.lang.Throwable -> L94
        L94:
            r9 = move-exception
            r0.f14895y = r10     // Catch: android.database.SQLException -> L43
            r0.f14896z = r9     // Catch: android.database.SQLException -> L43
            r0.D = r3     // Catch: android.database.SQLException -> L43
            java.lang.Object r10 = r8.f(r2, r0)     // Catch: android.database.SQLException -> L43
            if (r10 != r7) goto La7
        La1:
            return r7
        La2:
            if (r10 == 0) goto La8
            ab.b.c(r10, r11)
        La7:
            throw r9
        La8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.z.g(w4.c0, fe.p, xd.c):java.lang.Object");
    }
}
