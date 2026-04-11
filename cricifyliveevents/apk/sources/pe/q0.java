package pe;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends p0 implements b0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Executor f10265x;

    public q0(Executor executor) {
        this.f10265x = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // pe.b0
    public final h0 R(long j4, k1 k1Var, vd.h hVar) {
        Executor executor = this.f10265x;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(k1Var, j4, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e9) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e9);
                v0 v0Var = (v0) hVar.C(t.f10271w);
                if (v0Var != null) {
                    v0Var.g(cancellationException);
                }
            }
        }
        return scheduledFutureSchedule != null ? new g0(scheduledFutureSchedule) : y.E.R(j4, k1Var, hVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f10265x;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q0) && ((q0) obj).f10265x == this.f10265x;
    }

    @Override // pe.b0
    public final void g0(long j4, h hVar) {
        Executor executor = this.f10265x;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            k8.j jVar = new k8.j(3, this, hVar);
            vd.h hVar2 = hVar.f10237z;
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(jVar, j4, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e9) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e9);
                v0 v0Var = (v0) hVar2.C(t.f10271w);
                if (v0Var != null) {
                    v0Var.g(cancellationException);
                }
            }
        }
        if (scheduledFutureSchedule != null) {
            hVar.y(new e(0, scheduledFutureSchedule));
        } else {
            y.E.g0(j4, hVar);
        }
    }

    @Override // pe.s
    public final void h0(vd.h hVar, Runnable runnable) {
        try {
            this.f10265x.execute(runnable);
        } catch (RejectedExecutionException e9) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e9);
            v0 v0Var = (v0) hVar.C(t.f10271w);
            if (v0Var != null) {
                v0Var.g(cancellationException);
            }
            we.e eVar = f0.f10232a;
            we.d.f14160x.h0(hVar, runnable);
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f10265x);
    }

    @Override // pe.s
    public final String toString() {
        return this.f10265x.toString();
    }
}
