package ke;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n0 extends o0 implements b0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater A = AtomicReferenceFieldUpdater.newUpdater(n0.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater B = AtomicReferenceFieldUpdater.newUpdater(n0.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater C = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // ke.b0
    public h0 S(long j5, l1 l1Var, rd.h hVar) {
        return z.f7749a.S(j5, l1Var, hVar);
    }

    @Override // ke.r
    public final void h0(rd.h hVar, Runnable runnable) {
        q0(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        r7 = null;
     */
    @Override // ke.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long n0() {
        /*
            r10 = this;
            i4.o0 r0 = ke.x.f7742c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = ke.n0.A
            boolean r2 = r10.o0()
            r3 = 0
            if (r2 == 0) goto Le
            goto Lb4
        Le:
            r10.r0()
        L11:
            java.lang.Object r2 = r1.get(r10)
            r5 = 0
            if (r2 != 0) goto L1a
        L18:
            r7 = r5
            goto L4a
        L1a:
            boolean r6 = r2 instanceof pe.m
            if (r6 == 0) goto L3e
            r6 = r2
            pe.m r6 = (pe.m) r6
            java.lang.Object r7 = r6.d()
            i4.o0 r8 = pe.m.f10390g
            if (r7 == r8) goto L2c
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L4a
        L2c:
            pe.m r6 = r6.c()
        L30:
            boolean r5 = r1.compareAndSet(r10, r2, r6)
            if (r5 == 0) goto L37
            goto L11
        L37:
            java.lang.Object r5 = r1.get(r10)
            if (r5 == r2) goto L30
            goto L11
        L3e:
            if (r2 != r0) goto L41
            goto L18
        L41:
            boolean r6 = r1.compareAndSet(r10, r2, r5)
            if (r6 == 0) goto Lb9
            r7 = r2
            java.lang.Runnable r7 = (java.lang.Runnable) r7
        L4a:
            if (r7 == 0) goto L50
            r7.run()
            return r3
        L50:
            od.g r2 = r10.f7721y
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != 0) goto L5b
        L59:
            r8 = r6
            goto L63
        L5b:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L62
            goto L59
        L62:
            r8 = r3
        L63:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 != 0) goto L68
            goto Lb4
        L68:
            java.lang.Object r1 = r1.get(r10)
            if (r1 == 0) goto L90
            boolean r2 = r1 instanceof pe.m
            if (r2 == 0) goto L8d
            pe.m r1 = (pe.m) r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pe.m.f
            long r0 = r0.get(r1)
            r8 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r8 = r8 & r0
            int r2 = (int) r8
            r8 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r0 = r0 & r8
            r8 = 30
            long r0 = r0 >> r8
            int r0 = (int) r0
            if (r2 != r0) goto L8c
            goto L90
        L8c:
            return r3
        L8d:
            if (r1 != r0) goto Lb4
            goto Lb8
        L90:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ke.n0.B
            java.lang.Object r0 = r0.get(r10)
            ke.m0 r0 = (ke.m0) r0
            if (r0 == 0) goto Lb8
            monitor-enter(r0)
            ke.l0[] r1 = r0.f10407a     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto La5
            r2 = 0
            r5 = r1[r2]     // Catch: java.lang.Throwable -> La3
            goto La5
        La3:
            r1 = move-exception
            goto Lb6
        La5:
            monitor-exit(r0)
            if (r5 != 0) goto La9
            goto Lb8
        La9:
            long r0 = r5.f7705u
            long r5 = java.lang.System.nanoTime()
            long r0 = r0 - r5
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto Lb5
        Lb4:
            return r3
        Lb5:
            return r0
        Lb6:
            monitor-exit(r0)
            throw r1
        Lb8:
            return r6
        Lb9:
            java.lang.Object r6 = r1.get(r10)
            if (r6 == r2) goto L41
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: ke.n0.n0():long");
    }

    public void q0(Runnable runnable) {
        r0();
        if (!s0(runnable)) {
            y.D.q0(runnable);
            return;
        }
        Thread threadL0 = l0();
        if (Thread.currentThread() != threadL0) {
            LockSupport.unpark(threadL0);
        }
    }

    public final void r0() {
        l0 l0VarC;
        m0 m0Var = (m0) B.get(this);
        if (m0Var == null || pe.w.f10406b.get(m0Var) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (m0Var) {
                try {
                    l0[] l0VarArr = m0Var.f10407a;
                    l0 l0Var = l0VarArr != null ? l0VarArr[0] : null;
                    if (l0Var != null) {
                        l0VarC = ((jNanoTime - l0Var.f7705u) > 0L ? 1 : ((jNanoTime - l0Var.f7705u) == 0L ? 0 : -1)) >= 0 ? s0(l0Var) : false ? m0Var.c(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (l0VarC != null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s0(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ke.n0.A
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = ke.n0.C
            int r2 = r2.get(r6)
            r3 = 0
            if (r2 == 0) goto L10
            return r3
        L10:
            r2 = 1
            if (r1 != 0) goto L22
        L13:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L1b
            goto L62
        L1b:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L13
            goto L0
        L22:
            boolean r4 = r1 instanceof pe.m
            if (r4 == 0) goto L47
            r4 = r1
            pe.m r4 = (pe.m) r4
            int r5 = r4.a(r7)
            if (r5 == 0) goto L62
            if (r5 == r2) goto L35
            r0 = 2
            if (r5 == r0) goto L4b
            goto L0
        L35:
            pe.m r3 = r4.c()
        L39:
            boolean r2 = r0.compareAndSet(r6, r1, r3)
            if (r2 == 0) goto L40
            goto L0
        L40:
            java.lang.Object r2 = r0.get(r6)
            if (r2 == r1) goto L39
            goto L0
        L47:
            i4.o0 r4 = ke.x.f7742c
            if (r1 != r4) goto L4c
        L4b:
            return r3
        L4c:
            pe.m r3 = new pe.m
            r4 = 8
            r3.<init>(r4, r2)
            r4 = r1
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r3.a(r4)
            r3.a(r7)
        L5c:
            boolean r4 = r0.compareAndSet(r6, r1, r3)
            if (r4 == 0) goto L63
        L62:
            return r2
        L63:
            java.lang.Object r4 = r0.get(r6)
            if (r4 == r1) goto L5c
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: ke.n0.s0(java.lang.Runnable):boolean");
    }

    @Override // ke.o0
    public void shutdown() {
        l0 l0VarC;
        j1.f7701a.set(null);
        C.set(this, 1);
        i4.o0 o0Var = x.f7742c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = A;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof pe.m)) {
                    if (obj != o0Var) {
                        pe.m mVar = new pe.m(8, true);
                        mVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((pe.m) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, o0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (n0() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            m0 m0Var = (m0) B.get(this);
            if (m0Var == null) {
                return;
            }
            synchronized (m0Var) {
                l0VarC = pe.w.f10406b.get(m0Var) > 0 ? m0Var.c(0) : null;
            }
            if (l0VarC == null) {
                return;
            } else {
                p0(jNanoTime, l0VarC);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t0() {
        /*
            r7 = this;
            od.g r0 = r7.f7721y
            r1 = 1
            if (r0 == 0) goto La
            boolean r0 = r0.isEmpty()
            goto Lb
        La:
            r0 = r1
        Lb:
            r2 = 0
            if (r0 != 0) goto Lf
            goto L54
        Lf:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ke.n0.B
            java.lang.Object r0 = r0.get(r7)
            ke.m0 r0 = (ke.m0) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = pe.w.f10406b
            int r0 = r3.get(r0)
            if (r0 != 0) goto L23
            r0 = r1
            goto L24
        L23:
            r0 = r2
        L24:
            if (r0 != 0) goto L27
            goto L54
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ke.n0.A
            java.lang.Object r0 = r0.get(r7)
            if (r0 != 0) goto L30
            goto L53
        L30:
            boolean r3 = r0 instanceof pe.m
            if (r3 == 0) goto L4f
            pe.m r0 = (pe.m) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = pe.m.f
            long r3 = r3.get(r0)
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r0 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r5
            r5 = 30
            long r3 = r3 >> r5
            int r3 = (int) r3
            if (r0 != r3) goto L4e
            return r1
        L4e:
            return r2
        L4f:
            i4.o0 r3 = ke.x.f7742c
            if (r0 != r3) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ke.n0.t0():boolean");
    }

    public final void u0(long j5, l0 l0Var) {
        int iD;
        Thread threadL0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = B;
        if (C.get(this) != 0) {
            iD = 1;
        } else {
            m0 m0Var = (m0) atomicReferenceFieldUpdater.get(this);
            if (m0Var == null) {
                m0 m0Var2 = new m0();
                m0Var2.f7708c = j5;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, m0Var2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                be.h.b(obj);
                m0Var = (m0) obj;
            }
            iD = l0Var.d(j5, m0Var, this);
        }
        if (iD != 0) {
            if (iD == 1) {
                p0(j5, l0Var);
                return;
            } else {
                if (iD != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        m0 m0Var3 = (m0) atomicReferenceFieldUpdater.get(this);
        if (m0Var3 != null) {
            synchronized (m0Var3) {
                l0[] l0VarArr = m0Var3.f10407a;
                l0Var = l0VarArr != null ? l0VarArr[0] : null;
            }
        }
        if (l0Var != l0Var || Thread.currentThread() == (threadL0 = l0())) {
            return;
        }
        LockSupport.unpark(threadL0);
    }
}
