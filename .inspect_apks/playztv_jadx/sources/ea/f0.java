package ea;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends AtomicReference implements Runnable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final androidx.emoji2.text.o f4610w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final androidx.emoji2.text.o f4611x;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Callable f4612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g0 f4613v;

    static {
        int i = 1;
        f4610w = new androidx.emoji2.text.o(i);
        f4611x = new androidx.emoji2.text.o(i);
    }

    public f0(g0 g0Var, Callable callable) {
        this.f4613v = g0Var;
        callable.getClass();
        this.f4612u = callable;
    }

    public final void a(Thread thread) {
        Runnable runnable = (Runnable) get();
        w wVar = null;
        boolean z2 = false;
        int i = 0;
        while (true) {
            boolean z10 = runnable instanceof w;
            androidx.emoji2.text.o oVar = f4611x;
            if (!z10 && runnable != oVar) {
                break;
            }
            if (z10) {
                wVar = (w) runnable;
            }
            i++;
            if (i <= 1000) {
                Thread.yield();
            } else if (runnable == oVar || compareAndSet(runnable, oVar)) {
                z2 = Thread.interrupted() || z2;
                LockSupport.park(wVar);
            }
            runnable = (Runnable) get();
        }
        if (z2) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objCall = null;
        if (compareAndSet(null, threadCurrentThread)) {
            g0 g0Var = this.f4613v;
            boolean zIsDone = g0Var.isDone();
            androidx.emoji2.text.o oVar = f4610w;
            if (!zIsDone) {
                try {
                    objCall = this.f4612u.call();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, oVar)) {
                            a(threadCurrentThread);
                        }
                        if (zIsDone) {
                            return;
                        }
                        g0Var.l(th);
                        return;
                    } finally {
                        if (!compareAndSet(threadCurrentThread, oVar)) {
                            a(threadCurrentThread);
                        }
                        if (!zIsDone) {
                            g0Var.k(null);
                        }
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == f4610w) {
            str = "running=[DONE]";
        } else if (runnable instanceof w) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + this.f4612u.toString();
    }
}
