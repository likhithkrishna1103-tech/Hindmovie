package s1;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f11669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11670b;

    public g() {
        this(w.f11715a);
    }

    public final synchronized void a() {
        while (!this.f11670b) {
            this.f11669a.getClass();
            wait();
        }
    }

    public final synchronized void b() {
        boolean z2 = false;
        while (!this.f11670b) {
            try {
                this.f11669a.getClass();
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean c(long j5) {
        if (j5 <= 0) {
            return this.f11670b;
        }
        this.f11669a.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j8 = j5 + jElapsedRealtime;
        if (j8 < jElapsedRealtime) {
            b();
        } else {
            boolean z2 = false;
            while (!this.f11670b && jElapsedRealtime < j8) {
                try {
                    this.f11669a.getClass();
                    wait(j8 - jElapsedRealtime);
                } catch (InterruptedException unused) {
                    z2 = true;
                }
                this.f11669a.getClass();
                jElapsedRealtime = SystemClock.elapsedRealtime();
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
        return this.f11670b;
    }

    public final synchronized void d() {
        this.f11670b = false;
    }

    public final synchronized boolean e() {
        if (this.f11670b) {
            return false;
        }
        this.f11670b = true;
        notifyAll();
        return true;
    }

    public g(w wVar) {
        this.f11669a = wVar;
    }
}
