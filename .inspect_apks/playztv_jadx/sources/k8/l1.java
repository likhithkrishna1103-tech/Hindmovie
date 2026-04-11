package k8;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends Thread {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f7301u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final BlockingQueue f7302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7303w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h1 f7304x;

    public l1(h1 h1Var, String str, BlockingQueue blockingQueue) {
        this.f7304x = h1Var;
        t7.v.h(blockingQueue);
        this.f7301u = new Object();
        this.f7302v = blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.f7301u) {
            this.f7301u.notifyAll();
        }
    }

    public final void b(InterruptedException interruptedException) {
        this.f7304x.g().D.c(interruptedException, getName() + " was interrupted");
    }

    public final void c() {
        synchronized (this.f7304x.D) {
            try {
                if (!this.f7303w) {
                    this.f7304x.E.release();
                    this.f7304x.D.notifyAll();
                    h1 h1Var = this.f7304x;
                    if (this == h1Var.f7224x) {
                        h1Var.f7224x = null;
                    } else if (this == h1Var.f7225y) {
                        h1Var.f7225y = null;
                    } else {
                        h1Var.g().A.d("Current scheduler thread is neither worker nor network");
                    }
                    this.f7303w = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z2 = false;
        while (!z2) {
            try {
                this.f7304x.E.acquire();
                z2 = true;
            } catch (InterruptedException e10) {
                b(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                i1 i1Var = (i1) this.f7302v.poll();
                if (i1Var != null) {
                    Process.setThreadPriority(i1Var.f7238v ? threadPriority : 10);
                    i1Var.run();
                } else {
                    synchronized (this.f7301u) {
                        if (this.f7302v.peek() == null) {
                            try {
                                this.f7301u.wait(30000L);
                            } catch (InterruptedException e11) {
                                b(e11);
                            }
                        }
                    }
                    synchronized (this.f7304x.D) {
                        if (this.f7302v.peek() == null) {
                            c();
                            c();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }
}
