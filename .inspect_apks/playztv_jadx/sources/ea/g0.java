package ea;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends p implements RunnableFuture, h {
    public volatile f0 B;

    public g0(Callable callable) {
        this.B = new f0(this, callable);
    }

    @Override // ea.p
    public final void b() {
        f0 f0Var;
        Object obj = this.f4625u;
        if ((obj instanceof a) && ((a) obj).f4590a && (f0Var = this.B) != null) {
            androidx.emoji2.text.o oVar = f0.f4611x;
            androidx.emoji2.text.o oVar2 = f0.f4610w;
            Runnable runnable = (Runnable) f0Var.get();
            if (runnable instanceof Thread) {
                w wVar = new w(f0Var);
                w.a(wVar, Thread.currentThread());
                if (f0Var.compareAndSet(runnable, wVar)) {
                    try {
                        ((Thread) runnable).interrupt();
                    } finally {
                        if (((Runnable) f0Var.getAndSet(oVar2)) == oVar) {
                            LockSupport.unpark((Thread) runnable);
                        }
                    }
                }
            }
        }
        this.B = null;
    }

    @Override // ea.p
    public final String i() {
        f0 f0Var = this.B;
        if (f0Var == null) {
            return super.i();
        }
        return "task=[" + f0Var + "]";
    }

    @Override // ea.p, java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f4625u instanceof a;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        f0 f0Var = this.B;
        if (f0Var != null) {
            f0Var.run();
        }
        this.B = null;
    }
}
