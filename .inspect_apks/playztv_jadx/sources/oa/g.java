package oa;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends u.g implements ScheduledFuture {
    public final ScheduledFuture B;

    public g(f fVar) {
        this.B = fVar.a(new u5.d(25, this));
    }

    @Override // u.g
    public final void b() {
        ScheduledFuture scheduledFuture = this.B;
        Object obj = this.f12515u;
        scheduledFuture.cancel((obj instanceof u.a) && ((u.a) obj).f12497a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.B.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.B.getDelay(timeUnit);
    }
}
