package re;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends ue.r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f11039e;
    public final /* synthetic */ AtomicReferenceArray f;

    public k(long j4, k kVar, c cVar, int i) {
        super(j4, kVar, i);
        this.f11039e = cVar;
        this.f = new AtomicReferenceArray(e.f11017b * 2);
    }

    @Override // ue.r
    public final int f() {
        return e.f11017b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        ge.i.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // ue.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, vd.h r6) {
        /*
            r4 = this;
            int r6 = re.e.f11017b
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
            boolean r1 = r6 instanceof pe.o1
            re.c r2 = r4.f11039e
            r3 = 0
            if (r1 != 0) goto L62
            boolean r1 = r6 instanceof re.t
            if (r1 == 0) goto L21
            goto L62
        L21:
            d5.a r1 = re.e.f11023j
            if (r6 == r1) goto L59
            d5.a r1 = re.e.f11024k
            if (r6 != r1) goto L2a
            goto L59
        L2a:
            d5.a r1 = re.e.f11021g
            if (r6 == r1) goto L11
            d5.a r1 = re.e.f
            if (r6 != r1) goto L33
            goto L11
        L33:
            d5.a r5 = re.e.i
            if (r6 == r5) goto L7c
            d5.a r5 = re.e.f11019d
            if (r6 != r5) goto L3c
            goto L7c
        L3c:
            d5.a r5 = re.e.f11025l
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
            ge.i.b(r2)
            return
        L62:
            if (r0 == 0) goto L67
            d5.a r1 = re.e.f11023j
            goto L69
        L67:
            d5.a r1 = re.e.f11024k
        L69:
            boolean r6 = r4.j(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L7c
            ge.i.b(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: re.k.g(int, vd.h):void");
    }

    public final boolean j(int i, Object obj, Object obj2) {
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

    public final void l(int i, boolean z10) {
        if (z10) {
            c cVar = this.f11039e;
            ge.i.b(cVar);
            cVar.C((this.f12485c * ((long) e.f11017b)) + ((long) i));
        }
        h();
    }

    public final void m(int i, Object obj) {
        this.f.set(i * 2, obj);
    }

    public final void n(int i, Object obj) {
        this.f.set((i * 2) + 1, obj);
    }
}
