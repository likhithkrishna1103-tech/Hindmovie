package ke;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends p0 implements b0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Executor f7726w;

    public q0(Executor executor) {
        this.f7726w = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // ke.b0
    public final h0 S(long j5, l1 l1Var, rd.h hVar) {
        Executor executor = this.f7726w;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(l1Var, j5, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e10);
                v0 v0Var = (v0) hVar.v(s.f7730v);
                if (v0Var != null) {
                    ((d1) v0Var).j(cancellationException);
                }
            }
        }
        return scheduledFutureSchedule != null ? new g0(scheduledFutureSchedule) : y.D.S(j5, l1Var, hVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f7726w;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q0) && ((q0) obj).f7726w == this.f7726w;
    }

    @Override // ke.r
    public final void h0(rd.h hVar, Runnable runnable) {
        try {
            this.f7726w.execute(runnable);
        } catch (RejectedExecutionException e10) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e10);
            v0 v0Var = (v0) hVar.v(s.f7730v);
            if (v0Var != null) {
                ((d1) v0Var).j(cancellationException);
            }
            re.e eVar = f0.f7690a;
            re.d.f11591w.h0(hVar, runnable);
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f7726w);
    }

    @Override // ke.r
    public final String toString() {
        return this.f7726w.toString();
    }
}
