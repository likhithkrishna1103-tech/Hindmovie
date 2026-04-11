package k8;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h1 extends x1 {
    public static final AtomicLong F = new AtomicLong(Long.MIN_VALUE);
    public final LinkedBlockingQueue A;
    public final j1 B;
    public final j1 C;
    public final Object D;
    public final Semaphore E;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public l1 f7224x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public l1 f7225y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final PriorityBlockingQueue f7226z;

    public h1(k1 k1Var) {
        super(k1Var);
        this.D = new Object();
        this.E = new Semaphore(2);
        this.f7226z = new PriorityBlockingQueue();
        this.A = new LinkedBlockingQueue();
        this.B = new j1(this, "Thread death: Uncaught exception on worker thread");
        this.C = new j1(this, "Thread death: Uncaught exception on network thread");
    }

    public final boolean A1() {
        return Thread.currentThread() == this.f7224x;
    }

    public final void B1() {
        if (Thread.currentThread() != this.f7225y) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // c3.e
    public final void p1() {
        if (Thread.currentThread() != this.f7224x) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // k8.x1
    public final boolean s1() {
        return false;
    }

    public final Object t1(AtomicReference atomicReference, long j5, String str, Runnable runnable) {
        synchronized (atomicReference) {
            x().y1(runnable);
            try {
                atomicReference.wait(j5);
            } catch (InterruptedException unused) {
                g().D.d("Interrupted waiting for ".concat(str));
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            g().D.d("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final i1 u1(Callable callable) {
        q1();
        i1 i1Var = new i1(this, callable, false);
        if (Thread.currentThread() != this.f7224x) {
            v1(i1Var);
            return i1Var;
        }
        if (!this.f7226z.isEmpty()) {
            g().D.d("Callable skipped the worker queue.");
        }
        i1Var.run();
        return i1Var;
    }

    public final void v1(i1 i1Var) {
        synchronized (this.D) {
            try {
                this.f7226z.add(i1Var);
                l1 l1Var = this.f7224x;
                if (l1Var == null) {
                    l1 l1Var2 = new l1(this, "Measurement Worker", this.f7226z);
                    this.f7224x = l1Var2;
                    l1Var2.setUncaughtExceptionHandler(this.B);
                    this.f7224x.start();
                } else {
                    l1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w1(Runnable runnable) {
        q1();
        i1 i1Var = new i1(this, runnable, false, "Task exception on network thread");
        synchronized (this.D) {
            try {
                this.A.add(i1Var);
                l1 l1Var = this.f7225y;
                if (l1Var == null) {
                    l1 l1Var2 = new l1(this, "Measurement Network", this.A);
                    this.f7225y = l1Var2;
                    l1Var2.setUncaughtExceptionHandler(this.C);
                    this.f7225y.start();
                } else {
                    l1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final i1 x1(Callable callable) {
        q1();
        i1 i1Var = new i1(this, callable, true);
        if (Thread.currentThread() == this.f7224x) {
            i1Var.run();
            return i1Var;
        }
        v1(i1Var);
        return i1Var;
    }

    public final void y1(Runnable runnable) {
        q1();
        t7.v.h(runnable);
        v1(new i1(this, runnable, false, "Task exception on worker thread"));
    }

    public final void z1(Runnable runnable) {
        q1();
        v1(new i1(this, runnable, true, "Task exception on worker thread"));
    }
}
