package ye;

import cf.n;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import ue.o;
import ue.s;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ue.e f14713u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile AtomicInteger f14714v = new AtomicInteger(0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h f14715w;

    public e(h hVar, ue.e eVar) {
        this.f14715w = hVar;
        this.f14713u = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar;
        String strConcat = "OkHttp ".concat(((o) this.f14715w.f14719v.f1737b).f());
        h hVar = this.f14715w;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(strConcat);
        try {
            hVar.f14721x.h();
            boolean z2 = false;
            try {
                try {
                } catch (Throwable th) {
                    hVar.f14718u.f13040u.p(this);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f14713u.j(hVar.g());
                sVar = hVar.f14718u;
            } catch (IOException e11) {
                e = e11;
                z2 = true;
                if (z2) {
                    n nVar = n.f2753a;
                    n nVar2 = n.f2753a;
                    String str = "Callback failure for " + h.a(hVar);
                    nVar2.getClass();
                    n.i(str, 4, e);
                } else {
                    this.f14713u.d(e);
                }
                sVar = hVar.f14718u;
            } catch (Throwable th3) {
                th = th3;
                z2 = true;
                hVar.d();
                if (!z2) {
                    IOException iOException = new IOException("canceled due to " + th);
                    com.bumptech.glide.d.d(iOException, th);
                    this.f14713u.d(iOException);
                }
                throw th;
            }
            sVar.f13040u.p(this);
        } finally {
            threadCurrentThread.setName(name);
        }
    }
}
