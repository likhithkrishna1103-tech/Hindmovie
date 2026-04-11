package y1;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f14575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14576b;

    public g() {
        this(v.f14615a);
    }

    public final synchronized void a() {
        while (!this.f14576b) {
            this.f14575a.getClass();
            wait();
        }
    }

    public final synchronized void b() {
        boolean z10 = false;
        while (!this.f14576b) {
            try {
                this.f14575a.getClass();
                wait();
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean c(long j4) {
        if (j4 <= 0) {
            return this.f14576b;
        }
        this.f14575a.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j7 = j4 + jElapsedRealtime;
        if (j7 < jElapsedRealtime) {
            b();
        } else {
            boolean z10 = false;
            while (!this.f14576b && jElapsedRealtime < j7) {
                try {
                    this.f14575a.getClass();
                    wait(j7 - jElapsedRealtime);
                } catch (InterruptedException unused) {
                    z10 = true;
                }
                this.f14575a.getClass();
                jElapsedRealtime = SystemClock.elapsedRealtime();
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }
        return this.f14576b;
    }

    public final synchronized void d() {
        this.f14576b = false;
    }

    public final synchronized boolean e() {
        if (this.f14576b) {
            return false;
        }
        this.f14576b = true;
        notifyAll();
        return true;
    }

    public g(v vVar) {
        this.f14575a = vVar;
    }
}
