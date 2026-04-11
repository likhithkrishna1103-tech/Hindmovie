package n7;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends Thread {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final WeakReference f8834u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f8835v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CountDownLatch f8836w = new CountDownLatch(1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f8837x = false;

    public d(b bVar, long j5) {
        this.f8834u = new WeakReference(bVar);
        this.f8835v = j5;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        b bVar;
        WeakReference weakReference = this.f8834u;
        try {
            if (this.f8836w.await(this.f8835v, TimeUnit.MILLISECONDS) || (bVar = (b) weakReference.get()) == null) {
                return;
            }
            bVar.b();
            this.f8837x = true;
        } catch (InterruptedException unused) {
            b bVar2 = (b) weakReference.get();
            if (bVar2 != null) {
                bVar2.b();
                this.f8837x = true;
            }
        }
    }
}
