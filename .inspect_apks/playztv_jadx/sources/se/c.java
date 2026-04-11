package se;

import i4.o0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ke.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends g implements a {
    public static final /* synthetic */ AtomicReferenceFieldUpdater B = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public c(boolean z2) {
        super(1, z2 ? 1 : 0);
        this.owner$volatile = z2 ? null : d.f11946a;
    }

    @Override // se.a
    public final void a(Object obj) {
        while (e()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = B;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            o0 o0Var = d.f11946a;
            if (obj2 != o0Var) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, o0Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    c();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r0 = r1.f11945v;
        r5.set(r0, null);
        r2 = r1.f11944u;
        r2.D(r4, r2.f7685w, new ke.f(0, new he.i(r0, r1)));
     */
    @Override // se.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(td.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = se.g.A
            int r1 = r0.get(r7)
            int r2 = r7.f11951u
            if (r1 <= r2) goto L17
        La:
            int r1 = r0.get(r7)
            if (r1 <= r2) goto L0
            boolean r1 = r0.compareAndSet(r7, r1, r2)
            if (r1 == 0) goto La
            goto L0
        L17:
            r3 = 0
            nd.k r4 = nd.k.f8990a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = se.c.B
            if (r1 > 0) goto L64
            rd.c r8 = a.a.w(r8)
            ke.g r8 = ke.x.g(r8)
            se.b r1 = new se.b     // Catch: java.lang.Throwable -> L5f
            r1.<init>(r7, r8)     // Catch: java.lang.Throwable -> L5f
        L2b:
            int r6 = r0.getAndDecrement(r7)     // Catch: java.lang.Throwable -> L5f
            if (r6 > r2) goto L2b
            if (r6 <= 0) goto L4b
            se.c r0 = r1.f11945v     // Catch: java.lang.Throwable -> L5f
            r5.set(r0, r3)     // Catch: java.lang.Throwable -> L5f
            ke.g r2 = r1.f11944u     // Catch: java.lang.Throwable -> L5f
            he.i r3 = new he.i     // Catch: java.lang.Throwable -> L5f
            r3.<init>(r0, r1)     // Catch: java.lang.Throwable -> L5f
            int r0 = r2.f7685w     // Catch: java.lang.Throwable -> L5f
            ke.f r1 = new ke.f     // Catch: java.lang.Throwable -> L5f
            r5 = 0
            r1.<init>(r5, r3)     // Catch: java.lang.Throwable -> L5f
            r2.D(r4, r0, r1)     // Catch: java.lang.Throwable -> L5f
            goto L51
        L4b:
            boolean r6 = r7.b(r1)     // Catch: java.lang.Throwable -> L5f
            if (r6 == 0) goto L2b
        L51:
            java.lang.Object r8 = r8.u()
            sd.a r0 = sd.a.f11942u
            if (r8 != r0) goto L5a
            goto L5b
        L5a:
            r8 = r4
        L5b:
            if (r8 != r0) goto L5e
            return r8
        L5e:
            return r4
        L5f:
            r0 = move-exception
            r8.C()
            throw r0
        L64:
            int r2 = r1 + (-1)
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 == 0) goto L0
            r5.set(r7, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: se.c.d(td.c):java.lang.Object");
    }

    public final boolean e() {
        return Math.max(g.A.get(this), 0) == 0;
    }

    public final String toString() {
        return "Mutex@" + x.f(this) + "[isLocked=" + e() + ",owner=" + B.get(this) + ']';
    }
}
