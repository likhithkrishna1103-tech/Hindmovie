package re;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends c {
    public final a F;

    public m(int i, a aVar) {
        super(i);
        this.F = aVar;
        if (aVar != a.f11004v) {
            if (i < 1) {
                throw new IllegalArgumentException(l0.e.h(i, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + ge.q.a(c.class).c() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            re.a r1 = r15.F
            re.a r2 = re.a.f11006x
            rd.l r8 = rd.l.f11003a
            if (r1 != r2) goto L17
            java.lang.Object r1 = super.e(r16)
            boolean r2 = r1 instanceof re.i
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof re.h
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            d5.a r6 = re.e.f11019d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = re.c.A
            java.lang.Object r1 = r1.get(r15)
            re.k r1 = (re.k) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = re.c.f11011w
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.s(r7, r2)
            int r9 = re.e.f11017b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f12485c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            re.k r2 = re.c.a(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.p()
            re.h r2 = new re.h
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = re.c.c(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb7
            r3 = 1
            if (r12 == r3) goto Lb6
            r3 = 2
            if (r12 == r3) goto L90
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.a()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = re.c.f11012x
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.a()
        L7e:
            java.lang.Throwable r1 = r15.p()
            re.h r2 = new re.h
            r2.<init>(r1)
            return r2
        L88:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L90:
            if (r7 == 0) goto L9f
            r1.h()
            java.lang.Throwable r1 = r15.p()
            re.h r2 = new re.h
            r2.<init>(r1)
            return r2
        L9f:
            boolean r3 = r6 instanceof pe.o1
            if (r3 == 0) goto La6
            pe.o1 r6 = (pe.o1) r6
            goto La7
        La6:
            r6 = 0
        La7:
            if (r6 == 0) goto Lae
            int r12 = r2 + r9
            r6.a(r1, r12)
        Lae:
            long r3 = r1.f12485c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.k(r3)
        Lb6:
            return r8
        Lb7:
            r1.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: re.m.D(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // re.c, re.s
    public final Object e(Object obj) {
        return D(obj, false);
    }

    @Override // re.c, re.s
    public final Object f(Object obj, vd.c cVar) throws Throwable {
        if (D(obj, true) instanceof h) {
            throw p();
        }
        return rd.l.f11003a;
    }

    @Override // re.c
    public final boolean t() {
        return this.F == a.f11005w;
    }
}
