package ea;

import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends aa.q implements ScheduledFuture, y, Future {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p f4594v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ScheduledFuture f4595w;

    public b0(p pVar, ScheduledFuture scheduledFuture) {
        this.f4594v = pVar;
        this.f4595w = scheduledFuture;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        boolean zW = w(z2);
        if (zW) {
            this.f4595w.cancel(z2);
        }
        return zW;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f4595w.compareTo(delayed);
    }

    @Override // aa.q
    public final Object e() {
        return this.f4594v;
    }

    @Override // ea.y
    public final void f(Runnable runnable, Executor executor) {
        this.f4594v.f(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f4594v.get();
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f4595w.getDelay(timeUnit);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f4594v.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f4594v.isDone();
    }

    public final boolean w(boolean z2) {
        return this.f4594v.cancel(z2);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j5, TimeUnit timeUnit) {
        return this.f4594v.get(j5, timeUnit);
    }
}
