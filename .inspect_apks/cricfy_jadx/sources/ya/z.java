package ya;

import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends ua.q implements ScheduledFuture, w, Future {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final o f15019w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ScheduledFuture f15020x;

    public z(o oVar, ScheduledFuture scheduledFuture) {
        this.f15019w = oVar;
        this.f15020x = scheduledFuture;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        boolean zX = x(z10);
        if (zX) {
            this.f15020x.cancel(z10);
        }
        return zX;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f15020x.compareTo(delayed);
    }

    @Override // ua.q
    public final Object f() {
        return this.f15019w;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f15019w.get();
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f15020x.getDelay(timeUnit);
    }

    @Override // ya.w
    public final void h(Runnable runnable, Executor executor) {
        this.f15019w.h(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f15019w.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f15019w.isDone();
    }

    public final boolean x(boolean z10) {
        return this.f15019w.cancel(z10);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        return this.f15019w.get(j4, timeUnit);
    }
}
