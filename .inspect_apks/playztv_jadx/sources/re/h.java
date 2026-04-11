package re;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import ke.p0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends p0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f11595w;

    @Override // ke.r
    public final void h0(rd.h hVar, Runnable runnable) {
        c cVar = this.f11595w;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.B;
        cVar.d(runnable, false);
    }
}
