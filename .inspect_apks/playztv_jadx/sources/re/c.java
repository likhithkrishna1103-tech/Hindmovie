package re;

import a2.y0;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import i4.o0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import ke.x;
import pe.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater B = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater C = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater D = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");
    public static final o0 E = new o0("NOT_IN_STACK", 1);
    public final p A;
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f11585u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11586v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f11587w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f11588x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f f11589y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f11590z;

    public c(int i, int i10, long j5, String str) {
        this.f11585u = i;
        this.f11586v = i10;
        this.f11587w = j5;
        this.f11588x = str;
        if (i < 1) {
            throw new IllegalArgumentException(e6.j.j(i, "Core pool size ", " should be at least 1").toString());
        }
        if (i10 < i) {
            throw new IllegalArgumentException(l4.a.l(i10, i, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i10 > 2097150) {
            throw new IllegalArgumentException(e6.j.j(i10, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j5 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j5 + " must be positive").toString());
        }
        this.f11589y = new f();
        this.f11590z = new f();
        this.A = new p((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
        this._isTerminated$volatile = 0;
    }

    public final boolean F() {
        o0 o0Var;
        int iB;
        while (true) {
            long j5 = B.get(this);
            a aVar = (a) this.A.b((int) (2097151 & j5));
            if (aVar == null) {
                aVar = null;
            } else {
                long j8 = (2097152 + j5) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    o0Var = E;
                    if (objC == o0Var) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                }
                if (iB >= 0) {
                    if (B.compareAndSet(this, j5, ((long) iB) | j8)) {
                        aVar.g(o0Var);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.C.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final int a() {
        synchronized (this.A) {
            try {
                if (D.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = C;
                long j5 = atomicLongFieldUpdater.get(this);
                int i = (int) (j5 & 2097151);
                int i10 = i - ((int) ((j5 & 4398044413952L) >> 21));
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= this.f11585u) {
                    return 0;
                }
                if (i >= this.f11586v) {
                    return 0;
                }
                int i11 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.A.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i11);
                this.A.c(i11, aVar);
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
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = re.c.D
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof re.a
            r3 = 0
            if (r1 == 0) goto L17
            re.a r0 = (re.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            re.c r1 = r0.B
            boolean r1 = be.h.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            pe.p r1 = r8.A
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = re.c.C     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            pe.p r5 = r8.A
            java.lang.Object r5 = r5.b(r1)
            be.h.b(r5)
            re.a r5 = (re.a) r5
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
            re.m r5 = r5.f11573u
            re.f r6 = r8.f11590z
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = re.m.f11605b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            re.i r7 = (re.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            re.i r7 = r5.a()
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
            re.f r1 = r8.f11590z
            r1.b()
            re.f r1 = r8.f11589y
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            re.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            re.f r1 = r8.f11589y
            java.lang.Object r1 = r1.d()
            re.i r1 = (re.i) r1
            if (r1 != 0) goto Lb2
            re.f r1 = r8.f11590z
            java.lang.Object r1 = r1.d()
            re.i r1 = (re.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            re.b r1 = re.b.f11583y
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = re.c.B
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = re.c.C
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
        throw new UnsupportedOperationException("Method not decompiled: re.c.close():void");
    }

    public final void d(Runnable runnable, boolean z2) {
        i jVar;
        b bVar;
        k.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f11596u = jNanoTime;
            jVar.f11597v = z2;
        } else {
            jVar = new j(runnable, jNanoTime, z2);
        }
        boolean z10 = jVar.f11597v;
        AtomicLongFieldUpdater atomicLongFieldUpdater = C;
        long jAddAndGet = z10 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !be.h.a(aVar.B, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f11575w) != b.f11583y && (jVar.f11597v || bVar != b.f11580v)) {
            aVar.A = true;
            m mVar = aVar.f11573u;
            mVar.getClass();
            jVar = (i) m.f11605b.getAndSet(mVar, jVar);
            if (jVar == null) {
                jVar = null;
            } else {
                AtomicReferenceArray atomicReferenceArray = mVar.f11609a;
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m.f11606c;
                if (atomicIntegerFieldUpdater.get(mVar) - m.f11607d.get(mVar) != 127) {
                    if (jVar.f11597v) {
                        m.f11608e.incrementAndGet(mVar);
                    }
                    int i = atomicIntegerFieldUpdater.get(mVar) & ModuleDescriptor.MODULE_VERSION;
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
            if (!(jVar.f11597v ? this.f11590z.a(jVar) : this.f11589y.a(jVar))) {
                throw new RejectedExecutionException(l4.a.o(new StringBuilder(), this.f11588x, " was terminated"));
            }
        }
        if (z10) {
            if (F() || x(jAddAndGet)) {
                return;
            }
            F();
            return;
        }
        if (F() || x(atomicLongFieldUpdater.get(this))) {
            return;
        }
        F();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        d(runnable, false);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        p pVar = this.A;
        int iA = pVar.a();
        int i = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 1; i14 < iA; i14++) {
            a aVar = (a) pVar.b(i14);
            if (aVar != null) {
                m mVar = aVar.f11573u;
                mVar.getClass();
                int i15 = m.f11605b.get(mVar) != null ? (m.f11606c.get(mVar) - m.f11607d.get(mVar)) + 1 : m.f11606c.get(mVar) - m.f11607d.get(mVar);
                int iOrdinal = aVar.f11575w.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i15);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 1) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i15);
                    sb3.append('b');
                    arrayList.add(sb3.toString());
                } else if (iOrdinal == 2) {
                    i11++;
                } else if (iOrdinal == 3) {
                    i12++;
                    if (i15 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i15);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new y0();
                    }
                    i13++;
                }
            }
        }
        long j5 = C.get(this);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f11588x);
        sb5.append('@');
        sb5.append(x.f(this));
        sb5.append("[Pool Size {core = ");
        int i16 = this.f11585u;
        sb5.append(i16);
        sb5.append(", max = ");
        sb5.append(this.f11586v);
        sb5.append("}, Worker States {CPU = ");
        sb5.append(i);
        sb5.append(", blocking = ");
        sb5.append(i10);
        sb5.append(", parked = ");
        sb5.append(i11);
        sb5.append(", dormant = ");
        sb5.append(i12);
        sb5.append(", terminated = ");
        sb5.append(i13);
        sb5.append("}, running workers queues = ");
        sb5.append(arrayList);
        sb5.append(", global CPU queue size = ");
        sb5.append(this.f11589y.c());
        sb5.append(", global blocking queue size = ");
        sb5.append(this.f11590z.c());
        sb5.append(", Control State {created workers= ");
        sb5.append((int) (2097151 & j5));
        sb5.append(", blocking tasks = ");
        sb5.append((int) ((4398044413952L & j5) >> 21));
        sb5.append(", CPUs acquired = ");
        sb5.append(i16 - ((int) ((j5 & 9223367638808264704L) >> 42)));
        sb5.append("}]");
        return sb5.toString();
    }

    public final void v(a aVar, int i, int i10) {
        while (true) {
            long j5 = B.get(this);
            int i11 = (int) (2097151 & j5);
            long j8 = (2097152 + j5) & (-2097152);
            if (i11 == i) {
                if (i10 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == E) {
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
                if (B.compareAndSet(this, j5, ((long) i11) | j8)) {
                    return;
                }
            }
        }
    }

    public final boolean x(long j5) {
        int i = ((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i10 = this.f11585u;
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
}
