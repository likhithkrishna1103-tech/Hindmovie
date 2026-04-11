package ua;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import o8.o;
import ta.k;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ExecutorService f12820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f12821v = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public o f12822w = t1.k(null);

    public b(ExecutorService executorService) {
        this.f12820u = executorService;
    }

    public final o a(Runnable runnable) {
        o oVarF;
        synchronized (this.f12821v) {
            oVarF = this.f12822w.f(this.f12820u, new nc.c(15, runnable));
            this.f12822w = oVarF;
        }
        return oVarF;
    }

    public final o b(k kVar) {
        o oVarF;
        synchronized (this.f12821v) {
            oVarF = this.f12822w.f(this.f12820u, new nc.c(14, kVar));
            this.f12822w = oVarF;
        }
        return oVarF;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f12820u.execute(runnable);
    }
}
