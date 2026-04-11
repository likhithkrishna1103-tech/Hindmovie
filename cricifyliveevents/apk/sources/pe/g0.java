package pe;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements h0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ScheduledFuture f10235v;

    public g0(ScheduledFuture scheduledFuture) {
        this.f10235v = scheduledFuture;
    }

    @Override // pe.h0
    public final void b() {
        this.f10235v.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f10235v + ']';
    }
}
