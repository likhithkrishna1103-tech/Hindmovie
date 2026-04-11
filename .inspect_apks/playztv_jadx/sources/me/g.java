package me;

import java.util.concurrent.atomic.AtomicReferenceArray;
import pe.r;
import z0.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f8339e;
    public final /* synthetic */ AtomicReferenceArray f;

    public g(long j5, g gVar, a aVar, int i) {
        super(j5, gVar, i);
        this.f8339e = aVar;
        this.f = new AtomicReferenceArray(c.f8322b * 2);
    }

    @Override // pe.r
    public final int f() {
        return c.f8322b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        be.h.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // pe.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, rd.h r6) {
        /*
            r4 = this;
            int r6 = me.c.f8322b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof ke.p1
            me.a r2 = r4.f8339e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof me.j
            if (r1 == 0) goto L21
            goto L62
        L21:
            i4.o0 r1 = me.c.f8328j
            if (r6 == r1) goto L59
            i4.o0 r1 = me.c.f8329k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            i4.o0 r1 = me.c.f8326g
            if (r6 == r1) goto L11
            i4.o0 r1 = me.c.f
            if (r6 != r1) goto L33
            goto L11
        L33:
            i4.o0 r5 = me.c.i
            if (r6 == r5) goto L7c
            i4.o0 r5 = me.c.f8324d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            i4.o0 r5 = me.c.f8330l
            if (r6 != r5) goto L41
            goto L7c
        L41:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unexpected state: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L59:
            r4.m(r5, r3)
            if (r0 == 0) goto L7c
            be.h.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            i4.o0 r1 = me.c.f8328j
            goto L69
        L67:
            i4.o0 r1 = me.c.f8329k
        L69:
            boolean r6 = r4.j(r6, r5, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L7c
            be.h.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.g.g(int, rd.h):void");
    }

    public final boolean j(Object obj, int i, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i10 = (i * 2) + 1;
        do {
            atomicReferenceArray = this.f;
            if (atomicReferenceArray.compareAndSet(i10, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i10) == obj);
        return false;
    }

    public final Object k(int i) {
        return this.f.get((i * 2) + 1);
    }

    public final void l(int i, boolean z2) {
        if (z2) {
            a aVar = this.f8339e;
            be.h.b(aVar);
            aVar.q((this.f10399c * ((long) c.f8322b)) + ((long) i));
        }
        h();
    }

    public final void m(int i, l lVar) {
        this.f.set(i * 2, lVar);
    }

    public final void n(int i, Object obj) {
        this.f.set((i * 2) + 1, obj);
    }
}
