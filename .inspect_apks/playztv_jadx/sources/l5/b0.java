package l5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends FutureTask {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c0 f7825u;

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        try {
            if (isCancelled()) {
                return;
            }
            try {
                this.f7825u.f((a0) get());
            } catch (InterruptedException | ExecutionException e10) {
                this.f7825u.f(new a0(e10));
            }
        } finally {
            this.f7825u = null;
        }
    }
}
