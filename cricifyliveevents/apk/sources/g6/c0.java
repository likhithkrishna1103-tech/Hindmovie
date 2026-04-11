package g6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends FutureTask {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d0 f5059v;

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        try {
            if (isCancelled()) {
                return;
            }
            try {
                this.f5059v.f((b0) get());
            } catch (InterruptedException | ExecutionException e9) {
                this.f5059v.f(new b0(e9));
            }
        } finally {
            this.f5059v = null;
        }
    }
}
