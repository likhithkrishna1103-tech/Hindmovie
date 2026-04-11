package ne;

import i4.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f9022a = new o0("NONE", 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o0 f9023b = new o0("PENDING", 1);

    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        if (r6.s().equals(r5) == false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable a(ne.b r4, ne.c r5, td.c r6) {
        /*
            boolean r0 = r6 instanceof ne.e
            if (r0 == 0) goto L13
            r0 = r6
            ne.e r0 = (ne.e) r0
            int r1 = r0.f9001z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9001z = r1
            goto L18
        L13:
            ne.e r0 = new ne.e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f9000y
            int r1 = r0.f9001z
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            be.n r4 = r0.f8999x
            i5.a.Q(r6)     // Catch: java.lang.Throwable -> L27
            goto L4b
        L27:
            r5 = move-exception
            goto L4f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            i5.a.Q(r6)
            be.n r6 = new be.n
            r6.<init>()
            ne.g r1 = new ne.g     // Catch: java.lang.Throwable -> L4d
            r1.<init>(r5, r6)     // Catch: java.lang.Throwable -> L4d
            r0.f8999x = r6     // Catch: java.lang.Throwable -> L4d
            r0.f9001z = r2     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r4 = r4.o(r1, r0)     // Catch: java.lang.Throwable -> L4d
            sd.a r5 = sd.a.f11942u
            if (r4 != r5) goto L4b
            return r5
        L4b:
            r4 = 0
            return r4
        L4d:
            r5 = move-exception
            r4 = r6
        L4f:
            java.lang.Object r4 = r4.f2045u
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L5b
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L8d
        L5b:
            rd.h r6 = r0.f12489v
            be.h.b(r6)
            ke.s r0 = ke.s.f7730v
            rd.f r6 = r6.v(r0)
            ke.v0 r6 = (ke.v0) r6
            if (r6 == 0) goto L8e
            ke.d1 r6 = (ke.d1) r6
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ke.d1.f7686u
            java.lang.Object r0 = r0.get(r6)
            boolean r1 = r0 instanceof ke.o
            if (r1 != 0) goto L82
            boolean r1 = r0 instanceof ke.c1
            if (r1 == 0) goto L8e
            ke.c1 r0 = (ke.c1) r0
            boolean r0 = r0.e()
            if (r0 == 0) goto L8e
        L82:
            java.util.concurrent.CancellationException r6 = r6.s()
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L8d
            goto L8e
        L8d:
            throw r5
        L8e:
            if (r4 != 0) goto L91
            return r5
        L91:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L99
            com.bumptech.glide.d.d(r4, r5)
            throw r4
        L99:
            com.bumptech.glide.d.d(r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ne.o.a(ne.b, ne.c, td.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ne.b r5, td.c r6) {
        /*
            i4.o0 r0 = oe.c.f9578b
            boolean r1 = r6 instanceof ne.j
            if (r1 == 0) goto L15
            r1 = r6
            ne.j r1 = (ne.j) r1
            int r2 = r1.A
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.A = r2
            goto L1a
        L15:
            ne.j r1 = new ne.j
            r1.<init>(r6)
        L1a:
            java.lang.Object r6 = r1.f9015z
            int r2 = r1.A
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            cc.v r5 = r1.f9014y
            be.n r1 = r1.f9013x
            i5.a.Q(r6)     // Catch: oe.a -> L2b
            goto L5e
        L2b:
            r6 = move-exception
            goto L5a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            i5.a.Q(r6)
            be.n r6 = new be.n
            r6.<init>()
            r6.f2045u = r0
            cc.v r2 = new cc.v
            r4 = 1
            r2.<init>(r4, r6)
            r1.f9013x = r6     // Catch: oe.a -> L56
            r1.f9014y = r2     // Catch: oe.a -> L56
            r1.A = r3     // Catch: oe.a -> L56
            java.lang.Object r5 = r5.o(r2, r1)     // Catch: oe.a -> L56
            sd.a r1 = sd.a.f11942u
            if (r5 != r1) goto L54
            return r1
        L54:
            r1 = r6
            goto L5e
        L56:
            r5 = move-exception
            r1 = r6
            r6 = r5
            r5 = r2
        L5a:
            cc.v r2 = r6.f9573u
            if (r2 != r5) goto L6b
        L5e:
            java.lang.Object r5 = r1.f2045u
            if (r5 == r0) goto L63
            return r5
        L63:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element"
            r5.<init>(r6)
            throw r5
        L6b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ne.o.b(ne.b, td.c):java.lang.Object");
    }
}
