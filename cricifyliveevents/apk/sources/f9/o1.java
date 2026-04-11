package f9;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends Thread {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f4302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final BlockingQueue f4303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4304x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ p1 f4305y;

    public o1(p1 p1Var, String str, BlockingQueue blockingQueue) {
        this.f4305y = p1Var;
        o8.u.g(blockingQueue);
        this.f4302v = new Object();
        this.f4303w = blockingQueue;
        setName(str);
    }

    public final void a() {
        Object obj = this.f4302v;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public final void b() {
        p1 p1Var = this.f4305y;
        synchronized (p1Var.E) {
            try {
                if (!this.f4304x) {
                    p1Var.F.release();
                    p1Var.E.notifyAll();
                    if (this == p1Var.f4321y) {
                        p1Var.f4321y = null;
                    } else if (this == p1Var.f4322z) {
                        p1Var.f4322z = null;
                    } else {
                        w0 w0Var = ((r1) p1Var.f307w).A;
                        r1.g(w0Var);
                        w0Var.B.a("Current scheduler thread is neither worker nor network");
                    }
                    this.f4304x = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z10 = false;
        while (!z10) {
            try {
                this.f4305y.F.acquire();
                z10 = true;
            } catch (InterruptedException e9) {
                w0 w0Var = ((r1) this.f4305y.f307w).A;
                r1.g(w0Var);
                w0Var.E.b(e9, String.valueOf(getName()).concat(" was interrupted"));
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.f4303w;
                n1 n1Var = (n1) blockingQueue.poll();
                if (n1Var != null) {
                    Process.setThreadPriority(true != n1Var.f4282w ? 10 : threadPriority);
                    n1Var.run();
                } else {
                    Object obj = this.f4302v;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.f4305y.getClass();
                            try {
                                obj.wait(30000L);
                            } catch (InterruptedException e10) {
                                w0 w0Var2 = ((r1) this.f4305y.f307w).A;
                                r1.g(w0Var2);
                                w0Var2.E.b(e10, String.valueOf(getName()).concat(" was interrupted"));
                            }
                        }
                    }
                    synchronized (this.f4305y.E) {
                        if (this.f4303w.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
