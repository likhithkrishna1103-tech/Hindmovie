package q0;

import android.os.Process;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends Thread {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10349v;

    public j(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f10349v = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f10349v);
        super.run();
    }
}
