package xe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pe.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends g implements a {
    public static final /* synthetic */ AtomicReferenceFieldUpdater C = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public c(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner$volatile = z10 ? null : d.f14491a;
    }

    @Override // xe.a
    public final void a(Object obj) {
        while (d()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            d5.a aVar = d.f14491a;
            if (obj2 != aVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, aVar)) {
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

    public final boolean d() {
        return Math.max(g.B.get(this), 0) == 0;
    }

    public final boolean e() {
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g.B;
            int i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = this.f14495v;
            if (i10 > i11) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > i11) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i11));
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    C.set(this, null);
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        r2 = r0.f14490w;
        xe.c.C.set(r2, null);
        r3 = r0.f14489v;
        r3.F(r1, r3.f10228x, new pe.g(0, new df.l(r2, r0)));
     */
    @Override // xe.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(xd.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r6.e()
            rd.l r1 = rd.l.f11003a
            if (r0 == 0) goto L9
            goto L50
        L9:
            vd.c r7 = u8.a.t(r7)
            pe.h r7 = pe.x.h(r7)
            xe.b r0 = new xe.b     // Catch: java.lang.Throwable -> L51
            r0.<init>(r6, r7)     // Catch: java.lang.Throwable -> L51
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = xe.g.B     // Catch: java.lang.Throwable -> L51
            int r2 = r2.getAndDecrement(r6)     // Catch: java.lang.Throwable -> L51
            int r3 = r6.f14495v     // Catch: java.lang.Throwable -> L51
            if (r2 > r3) goto L16
            if (r2 <= 0) goto L3d
            xe.c r2 = r0.f14490w     // Catch: java.lang.Throwable -> L51
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = xe.c.C     // Catch: java.lang.Throwable -> L51
            r4 = 0
            r3.set(r2, r4)     // Catch: java.lang.Throwable -> L51
            pe.h r3 = r0.f14489v     // Catch: java.lang.Throwable -> L51
            df.l r4 = new df.l     // Catch: java.lang.Throwable -> L51
            r4.<init>(r2, r0)     // Catch: java.lang.Throwable -> L51
            int r0 = r3.f10228x     // Catch: java.lang.Throwable -> L51
            pe.g r2 = new pe.g     // Catch: java.lang.Throwable -> L51
            r5 = 0
            r2.<init>(r5, r4)     // Catch: java.lang.Throwable -> L51
            r3.F(r1, r0, r2)     // Catch: java.lang.Throwable -> L51
            goto L43
        L3d:
            boolean r2 = r6.b(r0)     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L16
        L43:
            java.lang.Object r7 = r7.v()
            wd.a r0 = wd.a.f14143v
            if (r7 != r0) goto L4c
            goto L4d
        L4c:
            r7 = r1
        L4d:
            if (r7 != r0) goto L50
            return r7
        L50:
            return r1
        L51:
            r0 = move-exception
            r7.E()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xe.c.g(xd.c):java.lang.Object");
    }

    public final String toString() {
        return "Mutex@" + x.g(this) + "[isLocked=" + d() + ",owner=" + C.get(this) + ']';
    }
}
