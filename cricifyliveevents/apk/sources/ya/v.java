package ya;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends AbstractOwnableSynchronizer implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d0 f15017v;

    public v(d0 d0Var) {
        this.f15017v = d0Var;
    }

    public static void a(v vVar, Thread thread) {
        vVar.setExclusiveOwnerThread(thread);
    }

    public final String toString() {
        return this.f15017v.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
