package id;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6586a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f6589d;

    public k() {
        HandlerThread handlerThread = new HandlerThread("LibGlobalFetchLib");
        handlerThread.start();
        this.f6589d = new Handler(handlerThread.getLooper());
    }

    public final void a() {
        synchronized (this.f6586a) {
            if (!this.f6587b) {
                this.f6587b = true;
                try {
                    this.f6589d.removeCallbacksAndMessages(null);
                    this.f6589d.getLooper().quit();
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void b() {
        synchronized (this.f6586a) {
            if (!this.f6587b) {
                int i = this.f6588c;
                if (i == 0) {
                } else {
                    this.f6588c = i - 1;
                }
            }
        }
    }

    public final void c() {
        synchronized (this.f6586a) {
            if (!this.f6587b) {
                this.f6588c++;
            }
        }
    }

    public final void d(ae.a aVar) {
        synchronized (this.f6586a) {
            if (!this.f6587b) {
                this.f6589d.post(new a2.a(24, aVar));
            }
        }
    }

    public final int e() {
        int i;
        synchronized (this.f6586a) {
            i = !this.f6587b ? this.f6588c : 0;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        be.h.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.HandlerWrapper");
        return true;
    }

    public final int hashCode() {
        return -1521653773;
    }
}
