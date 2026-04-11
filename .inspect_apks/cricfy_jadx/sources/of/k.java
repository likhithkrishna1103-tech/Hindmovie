package of;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final kf.e f9812v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile AtomicInteger f9813w = new AtomicInteger(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ n f9814x;

    public k(n nVar, kf.e eVar) {
        this.f9814x = nVar;
        this.f9812v = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        nc.p pVar;
        String str = "OkHttp " + ((kf.q) this.f9814x.f9818w.f2035b).f();
        n nVar = this.f9814x;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(str);
        try {
            nVar.f9820y.h();
            boolean z10 = false;
            try {
                try {
                } catch (Throwable th) {
                    nc.p pVar2 = nVar.f9817v.f7548a;
                    pVar2.getClass();
                    nc.p.x(pVar2, null, this, 3);
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f9812v.m(nVar.g());
                pVar = nVar.f9817v.f7548a;
            } catch (IOException e10) {
                e = e10;
                z10 = true;
                if (z10) {
                    uf.f fVar = uf.f.f12506a;
                    uf.f.f12506a.j("Callback failure for " + n.a(nVar), 4, e);
                } else {
                    this.f9812v.j(e);
                }
                pVar = nVar.f9817v.f7548a;
            } catch (Throwable th3) {
                th = th3;
                z10 = true;
                nVar.d();
                if (!z10) {
                    IOException iOException = new IOException("canceled due to " + th);
                    iOException.initCause(th);
                    this.f9812v.j(iOException);
                }
                if (!(th instanceof InterruptedException)) {
                    throw th;
                }
                Thread.currentThread().interrupt();
                pVar = nVar.f9817v.f7548a;
            }
            pVar.getClass();
            nc.p.x(pVar, null, this, 3);
        } finally {
            threadCurrentThread.setName(name);
        }
    }
}
