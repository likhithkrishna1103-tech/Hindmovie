package ea;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends AbstractOwnableSynchronizer implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f0 f4636u;

    public w(f0 f0Var) {
        this.f4636u = f0Var;
    }

    public static void a(w wVar, Thread thread) {
        wVar.setExclusiveOwnerThread(thread);
    }

    public final String toString() {
        return this.f4636u.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
