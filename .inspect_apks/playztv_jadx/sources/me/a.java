package me;

import i4.o0;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ke.p1;
import nd.k;
import pe.r;
import z0.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8313b = AtomicLongFieldUpdater.newUpdater(a.class, "sendersAndCloseStatus$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8314c = AtomicLongFieldUpdater.newUpdater(a.class, "receivers$volatile");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8315d = AtomicLongFieldUpdater.newUpdater(a.class, "bufferEnd$volatile");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8316e = AtomicLongFieldUpdater.newUpdater(a.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "sendSegment$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8317g = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "receiveSegment$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8318h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "bufferEndSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_closeCause$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8319j = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8320a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public a(int i10) {
        this.f8320a = i10;
        if (i10 < 0) {
            throw new IllegalArgumentException(e6.j.j(i10, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        g gVar = c.f8321a;
        this.bufferEnd$volatile = i10 != 0 ? i10 != Integer.MAX_VALUE ? i10 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f8315d.get(this);
        g gVar2 = new g(0L, null, this, 3);
        this.sendSegment$volatile = gVar2;
        this.receiveSegment$volatile = gVar2;
        if (j()) {
            gVar2 = c.f8321a;
            be.h.c(gVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = gVar2;
        this._closeCause$volatile = c.f8336r;
    }

    public static void h(a aVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8316e;
        if ((atomicLongFieldUpdater.addAndGet(aVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(aVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    public static boolean n(Object obj) {
        if (!(obj instanceof ke.e)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        ke.e eVar = (ke.e) obj;
        g gVar = c.f8321a;
        o0 o0VarK = eVar.k(k.f8990a, null);
        if (o0VarK == null) {
            return false;
        }
        eVar.l(o0VarK);
        return true;
    }

    public final boolean a(long j5) {
        return j5 < f8315d.get(this) || j5 < f8314c.get(this) + ((long) this.f8320a);
    }

    public final g b(long j5) {
        Object objF;
        Object obj = f8318h.get(this);
        g gVar = (g) f.get(this);
        if (gVar.f10399c > ((g) obj).f10399c) {
            obj = gVar;
        }
        g gVar2 = (g) f8317g.get(this);
        if (gVar2.f10399c > ((g) obj).f10399c) {
            obj = gVar2;
        }
        pe.b bVar = (pe.b) obj;
        loop0: while (true) {
            bVar.getClass();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pe.b.f10371a;
            Object obj2 = atomicReferenceFieldUpdater.get(bVar);
            o0 o0Var = pe.a.f10365a;
            objF = null;
            if (obj2 == o0Var) {
                break;
            }
            pe.b bVar2 = (pe.b) obj2;
            if (bVar2 == null) {
                while (!atomicReferenceFieldUpdater.compareAndSet(bVar, null, o0Var)) {
                    if (atomicReferenceFieldUpdater.get(bVar) != null) {
                        break;
                    }
                }
                break loop0;
            }
            bVar = bVar2;
        }
        g gVar3 = (g) bVar;
        loop2: for (g gVar4 = gVar3; gVar4 != null; gVar4 = (g) ((pe.b) pe.b.f10372b.get(gVar4))) {
            for (int i10 = c.f8322b - 1; -1 < i10; i10--) {
                if ((gVar4.f10399c * ((long) c.f8322b)) + ((long) i10) < j5) {
                    break loop2;
                }
                while (true) {
                    Object objK = gVar4.k(i10);
                    if (objK != null && objK != c.f8325e) {
                        if (!(objK instanceof j)) {
                            if (!(objK instanceof p1)) {
                                break;
                            }
                            if (gVar4.j(objK, i10, c.f8330l)) {
                                objF = pe.a.f(objF, objK);
                                gVar4.l(i10, true);
                                break;
                            }
                        } else {
                            if (gVar4.j(objK, i10, c.f8330l)) {
                                objF = pe.a.f(objF, ((j) objK).f8341a);
                                gVar4.l(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (gVar4.j(objK, i10, c.f8330l)) {
                            gVar4.h();
                            break;
                        }
                    }
                }
            }
        }
        if (objF != null) {
            if (!(objF instanceof ArrayList)) {
                l((p1) objF, true);
                return gVar3;
            }
            ArrayList arrayList = (ArrayList) objF;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                l((p1) arrayList.get(size), true);
            }
        }
        return gVar3;
    }

    public final void c() {
        i(false, f8313b.get(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x018e, code lost:
    
        h(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0191, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.a.d():void");
    }

    public final g e(long j5, g gVar) {
        Object objB;
        long j8;
        g gVar2 = c.f8321a;
        b bVar = b.C;
        loop0: while (true) {
            objB = pe.a.b(gVar, j5, bVar);
            if (!pe.a.e(objB)) {
                r rVarC = pe.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8317g;
                    r rVar = (r) atomicReferenceFieldUpdater.get(this);
                    if (rVar.f10399c >= rVarC.f10399c) {
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
        if (pe.a.e(objB)) {
            c();
            if (gVar.f10399c * ((long) c.f8322b) < g()) {
                gVar.a();
                return null;
            }
        } else {
            g gVar3 = (g) pe.a.c(objB);
            long j10 = gVar3.f10399c;
            if (!j() && j5 <= f8315d.get(this) / ((long) c.f8322b)) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8318h;
                    r rVar2 = (r) atomicReferenceFieldUpdater2.get(this);
                    if (rVar2.f10399c >= j10 || !gVar3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, rVar2, gVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != rVar2) {
                            if (gVar3.e()) {
                                gVar3.d();
                            }
                        }
                    }
                    if (rVar2.e()) {
                        rVar2.d();
                    }
                }
            }
            if (j10 <= j5) {
                return gVar3;
            }
            long j11 = j10 * ((long) c.f8322b);
            do {
                j8 = f8314c.get(this);
                if (j8 >= j11) {
                    break;
                }
            } while (!f8314c.compareAndSet(this, j8, j11));
            if (j10 * ((long) c.f8322b) < g()) {
                gVar3.a();
            }
        }
        return null;
    }

    public final Throwable f() {
        Throwable th = (Throwable) i.get(this);
        return th == null ? new i("Channel was closed") : th;
    }

    public final long g() {
        return f8313b.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (me.g) ((pe.b) pe.b.f10372b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(boolean r14, long r15) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.a.i(boolean, long):boolean");
    }

    public final boolean j() {
        long j5 = f8315d.get(this);
        return j5 == 0 || j5 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(long r5, me.g r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f10399c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            pe.b r0 = r7.b()
            me.g r0 = (me.g) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            pe.b r5 = r7.b()
            me.g r5 = (me.g) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = me.a.f8318h
            java.lang.Object r6 = r5.get(r4)
            pe.r r6 = (pe.r) r6
            long r0 = r6.f10399c
            long r2 = r7.f10399c
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
        throw new UnsupportedOperationException("Method not decompiled: me.a.k(long, me.g):void");
    }

    public final void l(p1 p1Var, boolean z2) {
        Throwable thF;
        if (!(p1Var instanceof ke.e)) {
            throw new IllegalStateException(("Unexpected waiter: " + p1Var).toString());
        }
        rd.c cVar = (rd.c) p1Var;
        if (z2) {
            thF = (Throwable) i.get(this);
            if (thF == null) {
                thF = new h("Channel was closed");
            }
        } else {
            thF = f();
        }
        cVar.g(i5.a.h(thF));
    }

    public final boolean m(Object obj, l lVar) {
        if (!(obj instanceof ke.e)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        ke.e eVar = (ke.e) obj;
        g gVar = c.f8321a;
        o0 o0VarK = eVar.k(lVar, null);
        if (o0VarK == null) {
            return false;
        }
        eVar.l(o0VarK);
        return true;
    }

    public final Object o(g gVar, int i10, long j5, Object obj) {
        AtomicReferenceArray atomicReferenceArray = gVar.f;
        Object objK = gVar.k(i10);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8313b;
        if (objK == null) {
            if (j5 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return c.f8332n;
                }
                if (gVar.j(objK, i10, obj)) {
                    d();
                    return c.f8331m;
                }
            }
        } else if (objK == c.f8324d && gVar.j(objK, i10, c.i)) {
            d();
            Object obj2 = atomicReferenceArray.get(i10 * 2);
            gVar.m(i10, null);
            return obj2;
        }
        while (true) {
            Object objK2 = gVar.k(i10);
            if (objK2 == null || objK2 == c.f8325e) {
                if (j5 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (gVar.j(objK2, i10, c.f8327h)) {
                        d();
                        return c.f8333o;
                    }
                } else {
                    if (obj == null) {
                        return c.f8332n;
                    }
                    if (gVar.j(objK2, i10, obj)) {
                        d();
                        return c.f8331m;
                    }
                }
            } else if (objK2 != c.f8324d) {
                o0 o0Var = c.f8328j;
                if (objK2 == o0Var) {
                    return c.f8333o;
                }
                if (objK2 == c.f8327h) {
                    return c.f8333o;
                }
                if (objK2 == c.f8330l) {
                    d();
                    return c.f8333o;
                }
                if (objK2 != c.f8326g && gVar.j(objK2, i10, c.f)) {
                    boolean z2 = objK2 instanceof j;
                    if (z2) {
                        objK2 = ((j) objK2).f8341a;
                    }
                    if (n(objK2)) {
                        gVar.n(i10, c.i);
                        d();
                        Object obj3 = atomicReferenceArray.get(i10 * 2);
                        gVar.m(i10, null);
                        return obj3;
                    }
                    gVar.n(i10, o0Var);
                    gVar.h();
                    if (z2) {
                        d();
                    }
                    return c.f8333o;
                }
            } else if (gVar.j(objK2, i10, c.i)) {
                d();
                Object obj4 = atomicReferenceArray.get(i10 * 2);
                gVar.m(i10, null);
                return obj4;
            }
        }
    }

    public final int p(g gVar, int i10, l lVar, long j5, Object obj, boolean z2) {
        while (true) {
            Object objK = gVar.k(i10);
            if (objK == null) {
                if (!a(j5) || z2) {
                    if (z2) {
                        if (gVar.j(null, i10, c.f8328j)) {
                            gVar.h();
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (gVar.j(null, i10, obj)) {
                            return 2;
                        }
                    }
                } else if (gVar.j(null, i10, c.f8324d)) {
                    break;
                }
            } else {
                if (objK != c.f8325e) {
                    o0 o0Var = c.f8329k;
                    if (objK == o0Var) {
                        gVar.m(i10, null);
                        return 5;
                    }
                    if (objK == c.f8327h) {
                        gVar.m(i10, null);
                        return 5;
                    }
                    if (objK == c.f8330l) {
                        gVar.m(i10, null);
                        c();
                        return 4;
                    }
                    gVar.m(i10, null);
                    if (objK instanceof j) {
                        objK = ((j) objK).f8341a;
                    }
                    if (m(objK, lVar)) {
                        gVar.n(i10, c.i);
                        return 0;
                    }
                    if (gVar.f.getAndSet((i10 * 2) + 1, o0Var) != o0Var) {
                        gVar.l(i10, true);
                    }
                    return 5;
                }
                if (gVar.j(objK, i10, c.f8324d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void q(long j5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        a aVar = this;
        if (aVar.j()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f8315d;
            if (atomicLongFieldUpdater.get(aVar) > j5) {
                break;
            } else {
                aVar = this;
            }
        }
        int i10 = c.f8323c;
        int i11 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f8316e;
            if (i11 < i10) {
                long j8 = atomicLongFieldUpdater.get(aVar);
                if (j8 == (4611686018427387903L & atomicLongFieldUpdater2.get(aVar)) && j8 == atomicLongFieldUpdater.get(aVar)) {
                    return;
                } else {
                    i11++;
                }
            } else {
                while (true) {
                    long j10 = atomicLongFieldUpdater2.get(aVar);
                    if (atomicLongFieldUpdater2.compareAndSet(aVar, j10, (j10 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        aVar = this;
                    }
                }
                while (true) {
                    long j11 = atomicLongFieldUpdater.get(aVar);
                    long j12 = atomicLongFieldUpdater2.get(aVar);
                    long j13 = j12 & 4611686018427387903L;
                    boolean z2 = (j12 & 4611686018427387904L) != 0;
                    if (j11 == j13 && j11 == atomicLongFieldUpdater.get(aVar)) {
                        break;
                    }
                    if (z2) {
                        aVar = this;
                    } else {
                        aVar = this;
                        atomicLongFieldUpdater2.compareAndSet(aVar, j12, 4611686018427387904L + j13);
                    }
                }
                while (true) {
                    long j14 = atomicLongFieldUpdater2.get(aVar);
                    if (atomicLongFieldUpdater2.compareAndSet(aVar, j14, j14 & 4611686018427387903L)) {
                        return;
                    } else {
                        aVar = this;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
    
        r16 = r7;
        r3 = (me.g) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019f, code lost:
    
        if (r3 != null) goto L83;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.a.toString():java.lang.String");
    }
}
