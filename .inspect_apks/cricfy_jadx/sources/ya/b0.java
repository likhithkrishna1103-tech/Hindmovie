package ya;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends y implements ScheduledExecutorService {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ScheduledExecutorService f14983w;

    public b0(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f14983w = scheduledExecutorService;
    }

    @Override // ya.y, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        i2.a0.u(this);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j4, TimeUnit timeUnit) {
        e0 e0Var = new e0(callable);
        return new z(e0Var, this.f14983w.schedule(e0Var, j4, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j4, long j7, TimeUnit timeUnit) {
        a0 a0Var = new a0(runnable);
        return new z(a0Var, this.f14983w.scheduleAtFixedRate(a0Var, j4, j7, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j4, long j7, TimeUnit timeUnit) {
        a0 a0Var = new a0(runnable);
        return new z(a0Var, this.f14983w.scheduleWithFixedDelay(a0Var, j4, j7, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
        e0 e0Var = new e0(Executors.callable(runnable, null));
        return new z(e0Var, this.f14983w.schedule(e0Var, j4, timeUnit));
    }
}
