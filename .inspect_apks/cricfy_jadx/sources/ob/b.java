package ob;

import j9.p;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kb.d;
import nb.j;
import vf.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ExecutorService f9739v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f9740w = new Object();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public p f9741x = g.A(null);

    public b(ExecutorService executorService) {
        this.f9739v = executorService;
    }

    public final p a(Runnable runnable) {
        p pVarF;
        synchronized (this.f9740w) {
            pVarF = this.f9741x.f(this.f9739v, new d(6, runnable));
            this.f9741x = pVarF;
        }
        return pVarF;
    }

    public final p b(j jVar) {
        p pVarF;
        synchronized (this.f9740w) {
            pVarF = this.f9741x.f(this.f9739v, new d(5, jVar));
            this.f9741x = pVarF;
        }
        return pVarF;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f9739v.execute(runnable);
    }
}
