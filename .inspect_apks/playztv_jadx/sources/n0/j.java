package n0;

import android.os.Process;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends Thread {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f8634u;

    public j(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f8634u = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f8634u);
        super.run();
    }
}
