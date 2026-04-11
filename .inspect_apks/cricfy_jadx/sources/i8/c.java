package i8;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final WeakReference f6359v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f6360w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CountDownLatch f6361x = new CountDownLatch(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6362y = false;

    public c(b bVar, long j4) {
        this.f6359v = new WeakReference(bVar);
        this.f6360w = j4;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        b bVar;
        WeakReference weakReference = this.f6359v;
        try {
            if (this.f6361x.await(this.f6360w, TimeUnit.MILLISECONDS) || (bVar = (b) weakReference.get()) == null) {
                return;
            }
            bVar.b();
            this.f6362y = true;
        } catch (InterruptedException unused) {
            b bVar2 = (b) weakReference.get();
            if (bVar2 != null) {
                bVar2.b();
                this.f6362y = true;
            }
        }
    }
}
