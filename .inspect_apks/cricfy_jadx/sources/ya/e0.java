package ya;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends o implements RunnableFuture, g {
    public volatile d0 C;

    public e0(Callable callable) {
        this.C = new d0(this, callable);
    }

    @Override // ya.o
    public final void b() {
        d0 d0Var;
        Object obj = this.f15006v;
        if ((obj instanceof a) && ((a) obj).f14979a && (d0Var = this.C) != null) {
            androidx.emoji2.text.q qVar = d0.f14992y;
            androidx.emoji2.text.q qVar2 = d0.f14991x;
            Runnable runnable = (Runnable) d0Var.get();
            if (runnable instanceof Thread) {
                v vVar = new v(d0Var);
                v.a(vVar, Thread.currentThread());
                if (d0Var.compareAndSet(runnable, vVar)) {
                    try {
                        ((Thread) runnable).interrupt();
                    } finally {
                        if (((Runnable) d0Var.getAndSet(qVar2)) == qVar) {
                            LockSupport.unpark((Thread) runnable);
                        }
                    }
                }
            }
        }
        this.C = null;
    }

    @Override // ya.o
    public final String i() {
        d0 d0Var = this.C;
        if (d0Var == null) {
            return super.i();
        }
        return "task=[" + d0Var + "]";
    }

    @Override // ya.o, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f15006v instanceof a;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        d0 d0Var = this.C;
        if (d0Var != null) {
            d0Var.run();
        }
        this.C = null;
    }
}
