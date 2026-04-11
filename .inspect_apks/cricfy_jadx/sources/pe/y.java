package pe;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends n0 implements Runnable {
    public static final y E;
    public static final long F;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l10;
        y yVar = new y();
        E = yVar;
        yVar.m0(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        F = timeUnit.toNanos(l10.longValue());
    }

    @Override // pe.n0, pe.b0
    public final h0 R(long j4, k1 k1Var, vd.h hVar) {
        long j7 = j4 > 0 ? j4 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j4 : 0L;
        if (j7 >= 4611686018427387903L) {
            return e1.f10231v;
        }
        long jNanoTime = System.nanoTime();
        k0 k0Var = new k0(j7 + jNanoTime, k1Var);
        u0(jNanoTime, k0Var);
        return k0Var;
    }

    @Override // pe.o0
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
                thread.setContextClassLoader(E.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // pe.o0
    public final void p0(long j4, l0 l0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // pe.n0
    public final void q0(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.q0(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zT0;
        i1.f10240a.set(this);
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
                long j4 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jN0 = n0();
                    if (jN0 == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j4 == Long.MAX_VALUE) {
                            j4 = F + jNanoTime;
                        }
                        long j7 = j4 - jNanoTime;
                        if (j7 <= 0) {
                            _thread = null;
                            v0();
                            if (t0()) {
                                return;
                            }
                            l0();
                            return;
                        }
                        if (jN0 > j7) {
                            jN0 = j7;
                        }
                    } else {
                        j4 = Long.MAX_VALUE;
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

    @Override // pe.n0, pe.o0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // pe.s
    public final String toString() {
        return "DefaultExecutor";
    }

    public final synchronized void v0() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            n0.B.set(this, null);
            n0.C.set(this, null);
            notifyAll();
        }
    }
}
