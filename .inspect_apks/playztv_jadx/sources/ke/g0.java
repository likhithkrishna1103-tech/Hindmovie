package ke;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements h0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ScheduledFuture f7695u;

    public g0(ScheduledFuture scheduledFuture) {
        this.f7695u = scheduledFuture;
    }

    @Override // ke.h0
    public final void b() {
        this.f7695u.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f7695u + ']';
    }
}
