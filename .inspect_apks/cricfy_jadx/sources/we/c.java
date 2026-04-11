package we;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import pe.x;
import ue.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater C = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater D = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater E = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");
    public static final d5.a F = new d5.a(3, "NOT_IN_STACK");
    public final f A;
    public final p B;
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f14155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f14156w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f14157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f14158y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f14159z;

    public c(int i, int i10, long j4, String str) {
        this.f14155v = i;
        this.f14156w = i10;
        this.f14157x = j4;
        this.f14158y = str;
        if (i < 1) {
            throw new IllegalArgumentException(l0.e.h(i, "Core pool size ", " should be at least 1").toString());
        }
        if (i10 < i) {
            throw new IllegalArgumentException(q4.a.m(i10, i, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i10 > 2097150) {
            throw new IllegalArgumentException(l0.e.h(i10, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j4 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j4 + " must be positive").toString());
        }
        this.f14159z = new f();
        this.A = new f();
        this.B = new p((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
        this._isTerminated$volatile = 0;
    }

    public final int a() {
        synchronized (this.B) {
            try {
                if (E.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = D;
                long j4 = atomicLongFieldUpdater.get(this);
                int i = (int) (j4 & 2097151);
                int i10 = i - ((int) ((j4 & 4398044413952L) >> 21));
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= this.f14155v) {
                    return 0;
                }
                if (i >= this.f14156w) {
                    return 0;
                }
                int i11 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.B.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i11);
                this.B.c(i11, aVar);
                if (i11 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = i10 + 1;
                aVar.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = we.c.E
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof we.a
            r3 = 0
            if (r1 == 0) goto L17
            we.a r0 = (we.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            we.c r1 = r0.C
            boolean r1 = ge.i.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            ue.p r1 = r8.B
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = we.c.D     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            ue.p r5 = r8.B
            java.lang.Object r5 = r5.b(r1)
            ge.i.b(r5)
            we.a r5 = (we.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            we.m r5 = r5.f14145v
            we.f r6 = r8.A
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = we.m.f14174b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            we.i r7 = (we.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            we.i r7 = r5.a()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            we.f r1 = r8.A
            r1.b()
            we.f r1 = r8.f14159z
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            we.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            we.f r1 = r8.f14159z
            java.lang.Object r1 = r1.d()
            we.i r1 = (we.i) r1
            if (r1 != 0) goto Lb2
            we.f r1 = r8.A
            java.lang.Object r1 = r1.d()
            we.i r1 = (we.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            we.b r1 = we.b.f14154z
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = we.c.C
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = we.c.D
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: we.c.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        g(runnable, false);
    }

    public final void g(Runnable runnable, boolean z10) {
        i jVar;
        b bVar;
        k.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f14165v = jNanoTime;
            jVar.f14166w = z10;
        } else {
            jVar = new j(runnable, jNanoTime, z10);
        }
        boolean z11 = jVar.f14166w;
        AtomicLongFieldUpdater atomicLongFieldUpdater = D;
        long jAddAndGet = z11 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !ge.i.a(aVar.C, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f14147x) != b.f14154z && (jVar.f14166w || bVar != b.f14151w)) {
            aVar.B = true;
            m mVar = aVar.f14145v;
            mVar.getClass();
            jVar = (i) m.f14174b.getAndSet(mVar, jVar);
            if (jVar == null) {
                jVar = null;
            } else {
                AtomicReferenceArray atomicReferenceArray = mVar.f14178a;
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m.f14175c;
                if (atomicIntegerFieldUpdater.get(mVar) - m.f14176d.get(mVar) != 127) {
                    if (jVar.f14166w) {
                        m.f14177e.incrementAndGet(mVar);
                    }
                    int i = atomicIntegerFieldUpdater.get(mVar) & 127;
                    while (atomicReferenceArray.get(i) != null) {
                        Thread.yield();
                    }
                    atomicReferenceArray.lazySet(i, jVar);
                    atomicIntegerFieldUpdater.incrementAndGet(mVar);
                    jVar = null;
                }
            }
        }
        if (jVar != null) {
            if (!(jVar.f14166w ? this.A.a(jVar) : this.f14159z.a(jVar))) {
                throw new RejectedExecutionException(q4.a.q(new StringBuilder(), this.f14158y, " was terminated"));
            }
        }
        if (z11) {
            if (z() || s(jAddAndGet)) {
                return;
            }
            z();
            return;
        }
        if (z() || s(atomicLongFieldUpdater.get(this))) {
            return;
        }
        z();
    }

    public final void q(a aVar, int i, int i10) {
        while (true) {
            long j4 = C.get(this);
            int i11 = (int) (2097151 & j4);
            long j7 = (2097152 + j4) & (-2097152);
            if (i11 == i) {
                if (i10 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == F) {
                            i11 = -1;
                            break;
                        }
                        if (objC == null) {
                            i11 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i11 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i11 = i10;
                }
            }
            if (i11 >= 0) {
                if (C.compareAndSet(this, j4, ((long) i11) | j7)) {
                    return;
                }
            }
        }
    }

    public final boolean s(long j4) {
        int i = ((int) (2097151 & j4)) - ((int) ((j4 & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i10 = this.f14155v;
        if (i < i10) {
            int iA = a();
            if (iA == 1 && i10 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        p pVar = this.B;
        int iA = pVar.a();
        int i = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 1; i14 < iA; i14++) {
            a aVar = (a) pVar.b(i14);
            if (aVar != null) {
                m mVar = aVar.f14145v;
                mVar.getClass();
                int i15 = m.f14174b.get(mVar) != null ? (m.f14175c.get(mVar) - m.f14176d.get(mVar)) + 1 : m.f14175c.get(mVar) - m.f14176d.get(mVar);
                int iOrdinal = aVar.f14147x.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i15);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i15);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i11++;
                } else if (iOrdinal == 3) {
                    i12++;
                    if (i15 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i15);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new a9.l();
                    }
                    i13++;
                }
            }
        }
        long j4 = D.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f14158y);
        sb4.append('@');
        sb4.append(x.g(this));
        sb4.append("[Pool Size {core = ");
        int i16 = this.f14155v;
        sb4.append(i16);
        sb4.append(", max = ");
        sb4.append(this.f14156w);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i10);
        sb4.append(", parked = ");
        sb4.append(i11);
        sb4.append(", dormant = ");
        sb4.append(i12);
        sb4.append(", terminated = ");
        sb4.append(i13);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f14159z.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.A.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j4));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j4) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i16 - ((int) ((j4 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final boolean z() {
        d5.a aVar;
        int iB;
        while (true) {
            long j4 = C.get(this);
            a aVar2 = (a) this.B.b((int) (2097151 & j4));
            if (aVar2 == null) {
                aVar2 = null;
            } else {
                long j7 = (2097152 + j4) & (-2097152);
                Object objC = aVar2.c();
                while (true) {
                    aVar = F;
                    if (objC == aVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar3 = (a) objC;
                    iB = aVar3.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar3.c();
                }
                if (iB >= 0) {
                    if (C.compareAndSet(this, j4, ((long) iB) | j7)) {
                        aVar2.g(aVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar2 == null) {
                return false;
            }
            if (a.D.compareAndSet(aVar2, -1, 0)) {
                LockSupport.unpark(aVar2);
                return true;
            }
        }
    }
}
