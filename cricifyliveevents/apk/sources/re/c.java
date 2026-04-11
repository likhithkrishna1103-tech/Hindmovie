package re;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.o1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c implements g {
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11015v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f11011w = AtomicLongFieldUpdater.newUpdater(c.class, "sendersAndCloseStatus$volatile");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f11012x = AtomicLongFieldUpdater.newUpdater(c.class, "receivers$volatile");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f11013y = AtomicLongFieldUpdater.newUpdater(c.class, "bufferEnd$volatile");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f11014z = AtomicLongFieldUpdater.newUpdater(c.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater A = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "sendSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater B = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "receiveSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater C = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "bufferEndSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater D = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_closeCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater E = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "closeHandler$volatile");

    public c(int i) {
        this.f11015v = i;
        if (i < 0) {
            throw new IllegalArgumentException(l0.e.h(i, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        k kVar = e.f11016a;
        this.bufferEnd$volatile = i != 0 ? i != Integer.MAX_VALUE ? i : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f11013y.get(this);
        k kVar2 = new k(0L, null, this, 3);
        this.sendSegment$volatile = kVar2;
        this.receiveSegment$volatile = kVar2;
        if (u()) {
            kVar2 = e.f11016a;
            ge.i.c(kVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = kVar2;
        this._closeCause$volatile = e.f11032s;
    }

    public static final k a(c cVar, long j4, k kVar) {
        Object objB;
        c cVar2;
        k kVar2 = e.f11016a;
        d dVar = d.D;
        loop0: while (true) {
            objB = ue.a.b(kVar, j4, dVar);
            if (!ue.a.e(objB)) {
                ue.r rVarC = ue.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
                    ue.r rVar = (ue.r) atomicReferenceFieldUpdater.get(cVar);
                    if (rVar.f12485c >= rVarC.f12485c) {
                        break loop0;
                    }
                    if (!rVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(cVar, rVar, rVarC)) {
                        if (atomicReferenceFieldUpdater.get(cVar) != rVar) {
                            if (rVarC.e()) {
                                rVarC.d();
                            }
                        }
                    }
                    if (rVar.e()) {
                        rVar.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean zE = ue.a.e(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f11012x;
        if (zE) {
            cVar.j();
            if (kVar.f12485c * ((long) e.f11017b) < atomicLongFieldUpdater.get(cVar)) {
                kVar.a();
                return null;
            }
        } else {
            k kVar3 = (k) ue.a.c(objB);
            long j7 = kVar3.f12485c;
            if (j7 <= j4) {
                return kVar3;
            }
            long j10 = ((long) e.f11017b) * j7;
            while (true) {
                long j11 = f11011w.get(cVar);
                long j12 = 1152921504606846975L & j11;
                if (j12 >= j10) {
                    cVar2 = cVar;
                    break;
                }
                cVar2 = cVar;
                if (f11011w.compareAndSet(cVar2, j11, (((long) ((int) (j11 >> 60))) << 60) + j12)) {
                    break;
                }
                cVar = cVar2;
            }
            if (j7 * ((long) e.f11017b) < atomicLongFieldUpdater.get(cVar2)) {
                kVar3.a();
            }
        }
        return null;
    }

    public static final void b(c cVar, Object obj, pe.h hVar) {
        hVar.i(com.bumptech.glide.c.e(cVar.p()));
    }

    public static final int c(c cVar, k kVar, int i, Object obj, long j4, Object obj2, boolean z10) {
        kVar.m(i, obj);
        if (z10) {
            return cVar.B(kVar, i, obj, j4, obj2, z10);
        }
        Object objK = kVar.k(i);
        if (objK == null) {
            if (cVar.d(j4)) {
                if (kVar.j(i, null, e.f11019d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (kVar.j(i, null, obj2)) {
                    return 2;
                }
            }
        } else if (objK instanceof o1) {
            kVar.m(i, null);
            if (cVar.y(objK, obj)) {
                kVar.n(i, e.i);
                return 0;
            }
            d5.a aVar = e.f11024k;
            if (kVar.f.getAndSet((i * 2) + 1, aVar) == aVar) {
                return 5;
            }
            kVar.l(i, true);
            return 5;
        }
        return cVar.B(kVar, i, obj, j4, obj2, z10);
    }

    public static void r(c cVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f11014z;
        if ((atomicLongFieldUpdater.addAndGet(cVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(cVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    public static boolean z(Object obj) {
        if (!(obj instanceof pe.f)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        pe.f fVar = (pe.f) obj;
        k kVar = e.f11016a;
        d5.a aVarC = fVar.c(rd.l.f11003a, null);
        if (aVarC == null) {
            return false;
        }
        fVar.l(aVarC);
        return true;
    }

    public final Object A(k kVar, int i, long j4, Object obj) {
        AtomicReferenceArray atomicReferenceArray = kVar.f;
        Object objK = kVar.k(i);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f11011w;
        if (objK == null) {
            if (j4 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return e.f11027n;
                }
                if (kVar.j(i, objK, obj)) {
                    l();
                    return e.f11026m;
                }
            }
        } else if (objK == e.f11019d && kVar.j(i, objK, e.i)) {
            l();
            Object obj2 = atomicReferenceArray.get(i * 2);
            kVar.m(i, null);
            return obj2;
        }
        while (true) {
            Object objK2 = kVar.k(i);
            if (objK2 == null || objK2 == e.f11020e) {
                if (j4 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (kVar.j(i, objK2, e.f11022h)) {
                        l();
                        return e.f11028o;
                    }
                } else {
                    if (obj == null) {
                        return e.f11027n;
                    }
                    if (kVar.j(i, objK2, obj)) {
                        l();
                        return e.f11026m;
                    }
                }
            } else if (objK2 != e.f11019d) {
                d5.a aVar = e.f11023j;
                if (objK2 == aVar) {
                    return e.f11028o;
                }
                if (objK2 == e.f11022h) {
                    return e.f11028o;
                }
                if (objK2 == e.f11025l) {
                    l();
                    return e.f11028o;
                }
                if (objK2 != e.f11021g && kVar.j(i, objK2, e.f)) {
                    boolean z10 = objK2 instanceof t;
                    if (z10) {
                        objK2 = ((t) objK2).f11044a;
                    }
                    if (z(objK2)) {
                        kVar.n(i, e.i);
                        l();
                        Object obj3 = atomicReferenceArray.get(i * 2);
                        kVar.m(i, null);
                        return obj3;
                    }
                    kVar.n(i, aVar);
                    kVar.h();
                    if (z10) {
                        l();
                    }
                    return e.f11028o;
                }
            } else if (kVar.j(i, objK2, e.i)) {
                l();
                Object obj4 = atomicReferenceArray.get(i * 2);
                kVar.m(i, null);
                return obj4;
            }
        }
    }

    public final int B(k kVar, int i, Object obj, long j4, Object obj2, boolean z10) {
        while (true) {
            Object objK = kVar.k(i);
            if (objK == null) {
                if (!d(j4) || z10) {
                    if (z10) {
                        if (kVar.j(i, null, e.f11023j)) {
                            kVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (kVar.j(i, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (kVar.j(i, null, e.f11019d)) {
                    break;
                }
            } else {
                if (objK != e.f11020e) {
                    d5.a aVar = e.f11024k;
                    if (objK == aVar) {
                        kVar.m(i, null);
                        return 5;
                    }
                    if (objK == e.f11022h) {
                        kVar.m(i, null);
                        return 5;
                    }
                    if (objK == e.f11025l) {
                        kVar.m(i, null);
                        j();
                        return 4;
                    }
                    kVar.m(i, null);
                    if (objK instanceof t) {
                        objK = ((t) objK).f11044a;
                    }
                    if (y(objK, obj)) {
                        kVar.n(i, e.i);
                        return 0;
                    }
                    if (kVar.f.getAndSet((i * 2) + 1, aVar) != aVar) {
                        kVar.l(i, true);
                    }
                    return 5;
                }
                if (kVar.j(i, objK, e.f11019d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void C(long j4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        c cVar = this;
        if (cVar.u()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f11013y;
            if (atomicLongFieldUpdater.get(cVar) > j4) {
                break;
            } else {
                cVar = this;
            }
        }
        int i = e.f11018c;
        int i10 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f11014z;
            if (i10 < i) {
                long j7 = atomicLongFieldUpdater.get(cVar);
                if (j7 == (4611686018427387903L & atomicLongFieldUpdater2.get(cVar)) && j7 == atomicLongFieldUpdater.get(cVar)) {
                    return;
                } else {
                    i10++;
                }
            } else {
                while (true) {
                    long j10 = atomicLongFieldUpdater2.get(cVar);
                    if (atomicLongFieldUpdater2.compareAndSet(cVar, j10, (j10 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        cVar = this;
                    }
                }
                while (true) {
                    long j11 = atomicLongFieldUpdater.get(cVar);
                    long j12 = atomicLongFieldUpdater2.get(cVar);
                    long j13 = j12 & 4611686018427387903L;
                    boolean z10 = (j12 & 4611686018427387904L) != 0;
                    if (j11 == j13 && j11 == atomicLongFieldUpdater.get(cVar)) {
                        break;
                    }
                    if (z10) {
                        cVar = this;
                    } else {
                        cVar = this;
                        atomicLongFieldUpdater2.compareAndSet(cVar, j12, 4611686018427387904L + j13);
                    }
                }
                while (true) {
                    long j14 = atomicLongFieldUpdater2.get(cVar);
                    if (atomicLongFieldUpdater2.compareAndSet(cVar, j14, j14 & 4611686018427387903L)) {
                        return;
                    } else {
                        cVar = this;
                    }
                }
            }
        }
    }

    public final boolean d(long j4) {
        return j4 < f11013y.get(this) || j4 < f11012x.get(this) + ((long) this.f11015v);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[SYNTHETIC] */
    @Override // re.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(java.lang.Object r16) {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = re.c.f11011w
            long r1 = r8.get(r15)
            r9 = 0
            boolean r3 = r15.s(r9, r1)
            r10 = 1
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L15
            r1 = r9
            goto L1b
        L15:
            long r1 = r1 & r11
            boolean r1 = r15.d(r1)
            r1 = r1 ^ r10
        L1b:
            re.i r13 = re.j.f11037b
            if (r1 == 0) goto L20
            return r13
        L20:
            d5.a r6 = re.e.f11023j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = re.c.A
            java.lang.Object r1 = r1.get(r15)
            re.k r1 = (re.k) r1
        L2a:
            long r2 = r8.getAndIncrement(r15)
            long r4 = r2 & r11
            boolean r7 = r15.s(r9, r2)
            int r14 = re.e.f11017b
            long r2 = (long) r14
            long r11 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r9 = r1.f12485c
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L5d
            re.k r3 = a(r15, r11, r1)
            if (r3 != 0) goto L5c
            if (r7 == 0) goto L54
            java.lang.Throwable r1 = r15.p()
            re.h r2 = new re.h
            r2.<init>(r1)
            return r2
        L54:
            r9 = 0
            r10 = 1
        L56:
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L2a
        L5c:
            r1 = r3
        L5d:
            r0 = r15
            r3 = r16
            int r9 = c(r0, r1, r2, r3, r4, r6, r7)
            rd.l r3 = rd.l.f11003a
            if (r9 == 0) goto Lbe
            r10 = 1
            if (r9 == r10) goto Lbd
            r3 = 2
            if (r9 == r3) goto L9c
            r2 = 3
            if (r9 == r2) goto L94
            r2 = 4
            if (r9 == r2) goto L7d
            r2 = 5
            if (r9 == r2) goto L78
            goto L7b
        L78:
            r1.a()
        L7b:
            r9 = 0
            goto L56
        L7d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = re.c.f11012x
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r1.a()
        L8a:
            java.lang.Throwable r1 = r15.p()
            re.h r2 = new re.h
            r2.<init>(r1)
            return r2
        L94:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L9c:
            if (r7 == 0) goto Lab
            r1.h()
            java.lang.Throwable r1 = r15.p()
            re.h r2 = new re.h
            r2.<init>(r1)
            return r2
        Lab:
            boolean r3 = r6 instanceof pe.o1
            if (r3 == 0) goto Lb2
            pe.o1 r6 = (pe.o1) r6
            goto Lb3
        Lb2:
            r6 = 0
        Lb3:
            if (r6 == 0) goto Lb9
            int r2 = r2 + r14
            r6.a(r1, r2)
        Lb9:
            r1.h()
            return r13
        Lbd:
            return r3
        Lbe:
            r1.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: re.c.e(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0177, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c2, code lost:
    
        b(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0163 A[RETURN] */
    @Override // re.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.Object r23, vd.c r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: re.c.f(java.lang.Object, vd.c):java.lang.Object");
    }

    @Override // re.r
    public final void g(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        h(cancellationException, true);
    }

    public final boolean h(Throwable th, boolean z10) {
        c cVar;
        boolean z11;
        long j4;
        long j7;
        long j10;
        Object obj;
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f11011w;
        if (!z10) {
            cVar = this;
            break;
        }
        do {
            j12 = atomicLongFieldUpdater.get(this);
            if (((int) (j12 >> 60)) != 0) {
                cVar = this;
                break;
            }
            k kVar = e.f11016a;
            cVar = this;
        } while (!atomicLongFieldUpdater.compareAndSet(cVar, j12, (j12 & 1152921504606846975L) + (((long) 1) << 60)));
        d5.a aVar = e.f11032s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = D;
            if (atomicReferenceFieldUpdater.compareAndSet(this, aVar, th)) {
                z11 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != aVar) {
                z11 = false;
                break;
            }
        }
        if (z10) {
            do {
                j11 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(cVar, j11, (((long) 3) << 60) + (j11 & 1152921504606846975L)));
        } else {
            do {
                j4 = atomicLongFieldUpdater.get(this);
                int i = (int) (j4 >> 60);
                if (i == 0) {
                    j7 = j4 & 1152921504606846975L;
                    j10 = 2;
                } else {
                    if (i != 1) {
                        break;
                    }
                    j7 = j4 & 1152921504606846975L;
                    j10 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(cVar, j4, (j10 << 60) + j7));
        }
        j();
        if (z11) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = E;
                obj = atomicReferenceFieldUpdater2.get(this);
                d5.a aVar2 = obj == null ? e.f11030q : e.f11031r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, aVar2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                ge.s.a(1, obj);
                ((fe.l) obj).a(n());
                return z11;
            }
        }
        return z11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (re.k) ((ue.b) ue.b.f12460b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final re.k i(long r13) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: re.c.i(long):re.k");
    }

    public final void j() {
        s(false, f11011w.get(this));
    }

    public final void k(long j4) {
        k kVar = (k) B.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f11012x;
            long j7 = atomicLongFieldUpdater.get(this);
            if (j4 < Math.max(((long) this.f11015v) + j7, f11013y.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j7, 1 + j7)) {
                long j10 = e.f11017b;
                long j11 = j7 / j10;
                int i = (int) (j7 % j10);
                if (kVar.f12485c != j11) {
                    k kVarM = m(j11, kVar);
                    if (kVarM != null) {
                        kVar = kVarM;
                    }
                }
                k kVar2 = kVar;
                if (A(kVar2, i, j7, null) != e.f11028o || j7 < q()) {
                    kVar2.a();
                }
                kVar = kVar2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x018e, code lost:
    
        r(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0191, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: re.c.l():void");
    }

    public final k m(long j4, k kVar) {
        Object objB;
        long j7;
        k kVar2 = e.f11016a;
        d dVar = d.D;
        loop0: while (true) {
            objB = ue.a.b(kVar, j4, dVar);
            if (!ue.a.e(objB)) {
                ue.r rVarC = ue.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = B;
                    ue.r rVar = (ue.r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f12485c >= rVarC.f12485c) {
                        break loop0;
                    }
                    if (!rVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, rVar, rVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != rVar) {
                            if (rVarC.e()) {
                                rVarC.d();
                            }
                        }
                    }
                    if (rVar.e()) {
                        rVar.d();
                    }
                }
            } else {
                break;
            }
        }
        if (ue.a.e(objB)) {
            j();
            if (kVar.f12485c * ((long) e.f11017b) < q()) {
                kVar.a();
                return null;
            }
        } else {
            k kVar3 = (k) ue.a.c(objB);
            long j10 = kVar3.f12485c;
            if (!u() && j4 <= f11013y.get(this) / ((long) e.f11017b)) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C;
                    ue.r rVar2 = (ue.r) atomicReferenceFieldUpdater2.get(this);
                    if (rVar2.f12485c >= j10 || !kVar3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, rVar2, kVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != rVar2) {
                            if (kVar3.e()) {
                                kVar3.d();
                            }
                        }
                    }
                    if (rVar2.e()) {
                        rVar2.d();
                    }
                }
            }
            if (j10 <= j4) {
                return kVar3;
            }
            long j11 = j10 * ((long) e.f11017b);
            do {
                j7 = f11012x.get(this);
                if (j7 >= j11) {
                    break;
                }
            } while (!f11012x.compareAndSet(this, j7, j11));
            if (j10 * ((long) e.f11017b) < q()) {
                kVar3.a();
            }
        }
        return null;
    }

    public final Throwable n() {
        return (Throwable) D.get(this);
    }

    public final Throwable o() {
        Throwable thN = n();
        return thN == null ? new l("Channel was closed") : thN;
    }

    public final Throwable p() {
        Throwable thN = n();
        return thN == null ? new j9.b("Channel was closed") : thN;
    }

    public final long q() {
        return f11011w.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (re.k) ((ue.b) ue.b.f12460b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(boolean r14, long r15) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: re.c.s(boolean, long):boolean");
    }

    public boolean t() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0194, code lost:
    
        r16 = r7;
        r3 = (re.k) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019d, code lost:
    
        if (r3 != null) goto L83;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: re.c.toString():java.lang.String");
    }

    public final boolean u() {
        long j4 = f11013y.get(this);
        return j4 == 0 || j4 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(long r5, re.k r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f12485c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            ue.b r0 = r7.b()
            re.k r0 = (re.k) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            ue.b r5 = r7.b()
            re.k r5 = (re.k) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = re.c.C
            java.lang.Object r6 = r5.get(r4)
            ue.r r6 = (ue.r) r6
            long r0 = r6.f12485c
            long r2 = r7.f12485c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.e()
            if (r5 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: re.c.v(long, re.k):void");
    }

    public final Object w(Object obj, vd.c cVar) throws Throwable {
        pe.h hVar = new pe.h(1, u8.a.t(cVar));
        hVar.w();
        hVar.i(com.bumptech.glide.c.e(p()));
        Object objV = hVar.v();
        return objV == wd.a.f14143v ? objV : rd.l.f11003a;
    }

    public final void x(o1 o1Var, boolean z10) {
        if (o1Var instanceof pe.f) {
            ((vd.c) o1Var).i(com.bumptech.glide.c.e(z10 ? o() : p()));
            return;
        }
        if (!(o1Var instanceof b)) {
            throw new IllegalStateException(("Unexpected waiter: " + o1Var).toString());
        }
        b bVar = (b) o1Var;
        pe.h hVar = bVar.f11009w;
        ge.i.b(hVar);
        bVar.f11009w = null;
        bVar.f11008v = e.f11025l;
        Throwable thN = bVar.f11010x.n();
        if (thN == null) {
            hVar.i(Boolean.FALSE);
        } else {
            hVar.i(com.bumptech.glide.c.e(thN));
        }
    }

    public final boolean y(Object obj, Object obj2) {
        if (!(obj instanceof b)) {
            if (!(obj instanceof pe.f)) {
                throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
            }
            pe.f fVar = (pe.f) obj;
            k kVar = e.f11016a;
            d5.a aVarC = fVar.c(obj2, null);
            if (aVarC == null) {
                return false;
            }
            fVar.l(aVarC);
            return true;
        }
        b bVar = (b) obj;
        pe.h hVar = bVar.f11009w;
        ge.i.b(hVar);
        bVar.f11009w = null;
        bVar.f11008v = obj2;
        Boolean bool = Boolean.TRUE;
        k kVar2 = e.f11016a;
        d5.a aVarC2 = hVar.c(bool, null);
        if (aVarC2 == null) {
            return false;
        }
        hVar.l(aVarC2);
        return true;
    }
}
