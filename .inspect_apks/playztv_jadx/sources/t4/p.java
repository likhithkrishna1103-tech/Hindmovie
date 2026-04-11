package t4;

import java.util.concurrent.atomic.AtomicBoolean;
import r4.x;
import r4.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements y, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f12148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final od.g f12150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f12151d;

    public p(f fVar, boolean z2) {
        be.h.e(fVar, "delegate");
        this.f12148a = fVar;
        this.f12149b = z2;
        this.f12150c = new od.g();
        this.f12151d = new AtomicBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // r4.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r6, ae.l r7, td.c r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof t4.o
            if (r0 == 0) goto L13
            r0 = r8
            t4.o r0 = (t4.o) r0
            int r1 = r0.D
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.D = r1
            goto L18
        L13:
            t4.o r0 = new t4.o
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.B
            int r1 = r0.D
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            t4.f r6 = r0.A
            ae.l r7 = r0.f12147z
            java.lang.String r1 = r0.f12146y
            t4.p r0 = r0.f12145x
            i5.a.Q(r8)
            r8 = r6
            r6 = r1
            goto L70
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            i5.a.Q(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r5.f12151d
            boolean r8 = r8.get()
            r1 = 21
            if (r8 != 0) goto L99
            rd.h r8 = r0.f12489v
            be.h.b(r8)
            k8.z r4 = t4.a.f12103v
            rd.f r8 = r8.v(r4)
            t4.a r8 = (t4.a) r8
            if (r8 == 0) goto L93
            t4.p r8 = r8.f12104u
            if (r8 != r5) goto L93
            r0.f12145x = r5
            r0.f12146y = r6
            r0.f12147z = r7
            t4.f r8 = r5.f12148a
            r0.A = r8
            r0.D = r2
            se.a r1 = r8.f12117v
            java.lang.Object r0 = r1.d(r0)
            sd.a r1 = sd.a.f11942u
            if (r0 != r1) goto L6f
            return r1
        L6f:
            r0 = r5
        L70:
            t4.i r1 = new t4.i     // Catch: java.lang.Throwable -> L86
            t4.f r2 = r0.f12148a     // Catch: java.lang.Throwable -> L86
            y4.c r6 = r2.e0(r6)     // Catch: java.lang.Throwable -> L86
            r1.<init>(r0, r6)     // Catch: java.lang.Throwable -> L86
            java.lang.Object r6 = r7.a(r1)     // Catch: java.lang.Throwable -> L88
            cf.d.g(r1, r3)     // Catch: java.lang.Throwable -> L86
            r8.a(r3)
            return r6
        L86:
            r6 = move-exception
            goto L8f
        L88:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L8a
        L8a:
            r7 = move-exception
            cf.d.g(r1, r6)     // Catch: java.lang.Throwable -> L86
            throw r7     // Catch: java.lang.Throwable -> L86
        L8f:
            r8.a(r3)
            throw r6
        L93:
            java.lang.String r6 = "Attempted to use connection on a different coroutine"
            android.support.v4.media.session.b.O(r6, r1)
            throw r3
        L99:
            java.lang.String r6 = "Connection is recycled"
            android.support.v4.media.session.b.O(r6, r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.p.a(java.lang.String, ae.l, td.c):java.lang.Object");
    }

    @Override // r4.y
    public final Object b(td.g gVar) {
        if (this.f12151d.get()) {
            android.support.v4.media.session.b.O("Connection is recycled", 21);
            throw null;
        }
        rd.h hVar = gVar.f12489v;
        be.h.b(hVar);
        a aVar = (a) hVar.v(a.f12103v);
        if (aVar != null && aVar.f12104u == this) {
            return Boolean.valueOf(!this.f12150c.isEmpty());
        }
        android.support.v4.media.session.b.O("Attempted to use connection on a different coroutine", 21);
        throw null;
    }

    @Override // t4.q
    public final y4.a c() {
        return this.f12148a;
    }

    @Override // r4.y
    public final Object d(x xVar, ae.p pVar, td.g gVar) {
        if (this.f12151d.get()) {
            android.support.v4.media.session.b.O("Connection is recycled", 21);
            throw null;
        }
        rd.h hVar = gVar.f12489v;
        be.h.b(hVar);
        a aVar = (a) hVar.v(a.f12103v);
        if (aVar != null && aVar.f12104u == this) {
            return g(xVar, pVar, gVar);
        }
        android.support.v4.media.session.b.O("Attempted to use connection on a different coroutine", 21);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(r4.x r8, td.c r9) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "SAVEPOINT '"
            boolean r1 = r9 instanceof t4.l
            if (r1 == 0) goto L15
            r1 = r9
            t4.l r1 = (t4.l) r1
            int r2 = r1.C
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.C = r2
            goto L1a
        L15:
            t4.l r1 = new t4.l
            r1.<init>(r7, r9)
        L1a:
            java.lang.Object r9 = r1.A
            int r2 = r1.C
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            t4.f r8 = r1.f12138z
            r4.x r2 = r1.f12137y
            t4.p r1 = r1.f12136x
            i5.a.Q(r9)
            r9 = r8
            r8 = r2
            goto L50
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            i5.a.Q(r9)
            r1.f12136x = r7
            r1.f12137y = r8
            t4.f r9 = r7.f12148a
            r1.f12138z = r9
            r1.C = r3
            se.a r2 = r9.f12117v
            java.lang.Object r1 = r2.d(r1)
            sd.a r2 = sd.a.f11942u
            if (r1 != r2) goto L4f
            return r2
        L4f:
            r1 = r7
        L50:
            r2 = 0
            od.g r4 = r1.f12150c     // Catch: java.lang.Throwable -> L6e
            t4.f r1 = r1.f12148a     // Catch: java.lang.Throwable -> L6e
            int r5 = r4.f9568w     // Catch: java.lang.Throwable -> L6e
            boolean r6 = r4.isEmpty()     // Catch: java.lang.Throwable -> L6e
            if (r6 == 0) goto L82
            int r8 = r8.ordinal()     // Catch: java.lang.Throwable -> L6e
            if (r8 == 0) goto L7c
            if (r8 == r3) goto L76
            r0 = 2
            if (r8 != r0) goto L70
            java.lang.String r8 = "BEGIN EXCLUSIVE TRANSACTION"
            android.support.v4.media.session.b.o(r1, r8)     // Catch: java.lang.Throwable -> L6e
            goto L96
        L6e:
            r8 = move-exception
            goto La4
        L70:
            a2.y0 r8 = new a2.y0     // Catch: java.lang.Throwable -> L6e
            r8.<init>()     // Catch: java.lang.Throwable -> L6e
            throw r8     // Catch: java.lang.Throwable -> L6e
        L76:
            java.lang.String r8 = "BEGIN IMMEDIATE TRANSACTION"
            android.support.v4.media.session.b.o(r1, r8)     // Catch: java.lang.Throwable -> L6e
            goto L96
        L7c:
            java.lang.String r8 = "BEGIN DEFERRED TRANSACTION"
            android.support.v4.media.session.b.o(r1, r8)     // Catch: java.lang.Throwable -> L6e
            goto L96
        L82:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L6e
            r8.append(r5)     // Catch: java.lang.Throwable -> L6e
            r0 = 39
            r8.append(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L6e
            android.support.v4.media.session.b.o(r1, r8)     // Catch: java.lang.Throwable -> L6e
        L96:
            t4.k r8 = new t4.k     // Catch: java.lang.Throwable -> L6e
            r8.<init>(r5)     // Catch: java.lang.Throwable -> L6e
            r4.addLast(r8)     // Catch: java.lang.Throwable -> L6e
            nd.k r8 = nd.k.f8990a     // Catch: java.lang.Throwable -> L6e
            r9.a(r2)
            return r8
        La4:
            r9.a(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.p.e(r4.x, td.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(boolean r8, td.c r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.p.f(boolean, td.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(r4.x r10, ae.p r11, td.c r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof t4.n
            if (r0 == 0) goto L13
            r0 = r12
            t4.n r0 = (t4.n) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            t4.n r0 = new t4.n
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.A
            int r1 = r0.C
            r2 = 0
            r3 = 5
            r4 = 3
            r5 = 2
            r6 = 1
            sd.a r7 = sd.a.f11942u
            if (r1 == 0) goto L6a
            if (r1 == r6) goto L5d
            if (r1 == r5) goto L4e
            if (r1 == r4) goto L48
            r10 = 4
            if (r1 == r10) goto L48
            if (r1 == r3) goto L38
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            java.io.Serializable r10 = r0.f12143y
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.Object r11 = r0.f12142x
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            i5.a.Q(r12)     // Catch: android.database.SQLException -> L45
            goto Lc4
        L45:
            r12 = move-exception
            goto Lbf
        L48:
            java.lang.Object r10 = r0.f12142x
            i5.a.Q(r12)
            return r10
        L4e:
            int r10 = r0.f12144z
            java.lang.Object r11 = r0.f12142x
            t4.p r11 = (t4.p) r11
            i5.a.Q(r12)     // Catch: java.lang.Throwable -> L58
            goto L9a
        L58:
            r10 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto Laa
        L5d:
            java.io.Serializable r10 = r0.f12143y
            r11 = r10
            ae.p r11 = (ae.p) r11
            java.lang.Object r10 = r0.f12142x
            t4.p r10 = (t4.p) r10
            i5.a.Q(r12)
            goto L82
        L6a:
            i5.a.Q(r12)
            if (r10 != 0) goto L71
            r4.x r10 = r4.x.f11512u
        L71:
            r0.f12142x = r9
            r12 = r11
            java.io.Serializable r12 = (java.io.Serializable) r12
            r0.f12143y = r12
            r0.C = r6
            java.lang.Object r10 = r9.e(r10, r0)
            if (r10 != r7) goto L81
            goto Lb8
        L81:
            r10 = r9
        L82:
            t4.j r12 = new t4.j     // Catch: java.lang.Throwable -> La9
            r1 = 0
            r12.<init>(r1, r10)     // Catch: java.lang.Throwable -> La9
            r0.f12142x = r10     // Catch: java.lang.Throwable -> La9
            r1 = 0
            r0.f12143y = r1     // Catch: java.lang.Throwable -> La9
            r0.f12144z = r6     // Catch: java.lang.Throwable -> La9
            r0.C = r5     // Catch: java.lang.Throwable -> La9
            java.lang.Object r12 = r11.i(r12, r0)     // Catch: java.lang.Throwable -> La9
            if (r12 != r7) goto L98
            goto Lb8
        L98:
            r11 = r10
            r10 = r6
        L9a:
            if (r10 == 0) goto L9d
            r2 = r6
        L9d:
            r0.f12142x = r12
            r0.C = r4
            java.lang.Object r10 = r11.f(r2, r0)
            if (r10 != r7) goto La8
            goto Lb8
        La8:
            return r12
        La9:
            r11 = move-exception
        Laa:
            throw r11     // Catch: java.lang.Throwable -> Lab
        Lab:
            r12 = move-exception
            r0.f12142x = r11     // Catch: android.database.SQLException -> Lbb
            r0.f12143y = r12     // Catch: android.database.SQLException -> Lbb
            r0.C = r3     // Catch: android.database.SQLException -> Lbb
            java.lang.Object r10 = r10.f(r2, r0)     // Catch: android.database.SQLException -> Lbb
            if (r10 != r7) goto Lb9
        Lb8:
            return r7
        Lb9:
            r10 = r12
            goto Lc4
        Lbb:
            r10 = move-exception
            r8 = r12
            r12 = r10
            r10 = r8
        Lbf:
            if (r11 == 0) goto Lc5
            com.bumptech.glide.d.d(r11, r12)
        Lc4:
            throw r10
        Lc5:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.p.g(r4.x, ae.p, td.c):java.lang.Object");
    }
}
