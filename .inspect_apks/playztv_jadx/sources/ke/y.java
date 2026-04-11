package ke;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y extends n0 implements Runnable {
    public static final y D;
    public static final long E;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l10;
        y yVar = new y();
        D = yVar;
        yVar.m0(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        E = timeUnit.toNanos(l10.longValue());
    }

    @Override // ke.n0, ke.b0
    public final h0 S(long j5, l1 l1Var, rd.h hVar) {
        long j8 = j5 > 0 ? j5 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j5 : 0L;
        if (j8 >= 4611686018427387903L) {
            return f1.f7691u;
        }
        long jNanoTime = System.nanoTime();
        k0 k0Var = new k0(j8 + jNanoTime, l1Var);
        u0(jNanoTime, k0Var);
        return k0Var;
    }

    @Override // ke.o0
    public final Thread l0() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(D.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // ke.o0
    public final void p0(long j5, l0 l0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // ke.n0
    public final void q0(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.q0(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zT0;
        j1.f7701a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    if (zT0) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j5 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jN0 = n0();
                    if (jN0 == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j5 == Long.MAX_VALUE) {
                            j5 = E + jNanoTime;
                        }
                        long j8 = j5 - jNanoTime;
                        if (j8 <= 0) {
                            _thread = null;
                            v0();
                            if (t0()) {
                                return;
                            }
                            l0();
                            return;
                        }
                        if (jN0 > j8) {
                            jN0 = j8;
                        }
                    } else {
                        j5 = Long.MAX_VALUE;
                    }
                    if (jN0 > 0) {
                        int i10 = debugStatus;
                        if (i10 == 2 || i10 == 3) {
                            _thread = null;
                            v0();
                            if (t0()) {
                                return;
                            }
                            l0();
                            return;
                        }
                        LockSupport.parkNanos(this, jN0);
                    }
                }
            }
        } finally {
            _thread = null;
            v0();
            if (!t0()) {
                l0();
            }
        }
    }

    @Override // ke.n0, ke.o0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // ke.r
    public final String toString() {
        return "DefaultExecutor";
    }

    public final synchronized void v0() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            n0.A.set(this, null);
            n0.B.set(this, null);
            notifyAll();
        }
    }
}
