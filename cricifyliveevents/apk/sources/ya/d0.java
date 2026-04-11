package ya;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends AtomicReference implements Runnable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final androidx.emoji2.text.q f14991x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final androidx.emoji2.text.q f14992y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Callable f14993v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e0 f14994w;

    static {
        int i = 3;
        f14991x = new androidx.emoji2.text.q(i);
        f14992y = new androidx.emoji2.text.q(i);
    }

    public d0(e0 e0Var, Callable callable) {
        this.f14994w = e0Var;
        callable.getClass();
        this.f14993v = callable;
    }

    public final void a(Thread thread) {
        Runnable runnable = (Runnable) get();
        v vVar = null;
        boolean z10 = false;
        int i = 0;
        while (true) {
            boolean z11 = runnable instanceof v;
            androidx.emoji2.text.q qVar = f14992y;
            if (!z11 && runnable != qVar) {
                break;
            }
            if (z11) {
                vVar = (v) runnable;
            }
            i++;
            if (i <= 1000) {
                Thread.yield();
            } else if (runnable == qVar || compareAndSet(runnable, qVar)) {
                z10 = Thread.interrupted() || z10;
                LockSupport.park(vVar);
            }
            runnable = (Runnable) get();
        }
        if (z10) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        Object objCall = null;
        if (compareAndSet(null, threadCurrentThread)) {
            e0 e0Var = this.f14994w;
            boolean zIsDone = e0Var.isDone();
            androidx.emoji2.text.q qVar = f14991x;
            if (!zIsDone) {
                try {
                    objCall = this.f14993v.call();
                } catch (Throwable th) {
                    try {
                        if (th instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        if (!compareAndSet(threadCurrentThread, qVar)) {
                            a(threadCurrentThread);
                        }
                        if (zIsDone) {
                            return;
                        }
                        e0Var.l(th);
                        return;
                    } finally {
                        if (!compareAndSet(threadCurrentThread, qVar)) {
                            a(threadCurrentThread);
                        }
                        if (!zIsDone) {
                            e0Var.k(null);
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
        if (runnable == f14991x) {
            str = "running=[DONE]";
        } else if (runnable instanceof v) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + this.f14993v.toString();
    }
}
