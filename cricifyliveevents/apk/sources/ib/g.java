package ib;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends x.h implements ScheduledFuture {
    public final ScheduledFuture C;

    public g(f fVar) {
        this.C = fVar.a(new p6.c(22, this));
    }

    @Override // x.h
    public final void b() {
        ScheduledFuture scheduledFuture = this.C;
        Object obj = this.f14198v;
        scheduledFuture.cancel((obj instanceof x.a) && ((x.a) obj).f14182a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.C.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.C.getDelay(timeUnit);
    }
}
