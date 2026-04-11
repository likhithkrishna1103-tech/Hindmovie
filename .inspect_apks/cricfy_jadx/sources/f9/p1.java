package f9;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 extends b2 {
    public static final AtomicLong G = new AtomicLong(Long.MIN_VALUE);
    public final PriorityBlockingQueue A;
    public final LinkedBlockingQueue B;
    public final m1 C;
    public final m1 D;
    public final Object E;
    public final Semaphore F;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public o1 f4321y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public o1 f4322z;

    public p1(r1 r1Var) {
        super(r1Var);
        this.E = new Object();
        this.F = new Semaphore(2);
        this.A = new PriorityBlockingQueue();
        this.B = new LinkedBlockingQueue();
        this.C = new m1(this, "Thread death: Uncaught exception on worker thread");
        this.D = new m1(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // a7.a
    public final void m1() {
        if (Thread.currentThread() != this.f4321y) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // f9.b2
    public final boolean n1() {
        return false;
    }

    public final void q1() {
        if (Thread.currentThread() != this.f4322z) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void r1() {
        if (Thread.currentThread() == this.f4321y) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean s1() {
        return Thread.currentThread() == this.f4321y;
    }

    public final n1 t1(Callable callable) {
        o1();
        n1 n1Var = new n1(this, callable, false);
        if (Thread.currentThread() != this.f4321y) {
            z1(n1Var);
            return n1Var;
        }
        if (!this.A.isEmpty()) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.a("Callable skipped the worker queue.");
        }
        n1Var.run();
        return n1Var;
    }

    public final n1 u1(Callable callable) {
        o1();
        n1 n1Var = new n1(this, callable, true);
        if (Thread.currentThread() == this.f4321y) {
            n1Var.run();
            return n1Var;
        }
        z1(n1Var);
        return n1Var;
    }

    public final void v1(Runnable runnable) {
        o1();
        o8.u.g(runnable);
        z1(new n1(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object w1(AtomicReference atomicReference, long j4, String str, Runnable runnable) {
        synchronized (atomicReference) {
            p1 p1Var = ((r1) this.f307w).B;
            r1.g(p1Var);
            p1Var.v1(runnable);
            try {
                atomicReference.wait(j4);
            } catch (InterruptedException unused) {
                w0 w0Var = ((r1) this.f307w).A;
                r1.g(w0Var);
                u0 u0Var = w0Var.E;
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                u0Var.a(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            w0 w0Var2 = ((r1) this.f307w).A;
            r1.g(w0Var2);
            w0Var2.E.a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void x1(Runnable runnable) {
        o1();
        z1(new n1(this, runnable, true, "Task exception on worker thread"));
    }

    public final void y1(Runnable runnable) {
        o1();
        n1 n1Var = new n1(this, runnable, false, "Task exception on network thread");
        synchronized (this.E) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = this.B;
                linkedBlockingQueue.add(n1Var);
                o1 o1Var = this.f4322z;
                if (o1Var == null) {
                    o1 o1Var2 = new o1(this, "Measurement Network", linkedBlockingQueue);
                    this.f4322z = o1Var2;
                    o1Var2.setUncaughtExceptionHandler(this.D);
                    this.f4322z.start();
                } else {
                    o1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z1(n1 n1Var) {
        synchronized (this.E) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.A;
                priorityBlockingQueue.add(n1Var);
                o1 o1Var = this.f4321y;
                if (o1Var == null) {
                    o1 o1Var2 = new o1(this, "Measurement Worker", priorityBlockingQueue);
                    this.f4321y = o1Var2;
                    o1Var2.setUncaughtExceptionHandler(this.C);
                    this.f4321y.start();
                } else {
                    o1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
