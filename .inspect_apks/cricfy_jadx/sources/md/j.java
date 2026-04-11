package md;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.emoji2.text.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8441a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f8444d;

    public j() {
        HandlerThread handlerThread = new HandlerThread("LibGlobalFetchLib");
        handlerThread.start();
        this.f8444d = new Handler(handlerThread.getLooper());
    }

    public final void a() {
        synchronized (this.f8441a) {
            if (!this.f8442b) {
                this.f8442b = true;
                try {
                    this.f8444d.removeCallbacksAndMessages(null);
                    this.f8444d.getLooper().quit();
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void b() {
        synchronized (this.f8441a) {
            if (!this.f8442b) {
                int i = this.f8443c;
                if (i == 0) {
                } else {
                    this.f8443c = i - 1;
                }
            }
        }
    }

    public final void c() {
        synchronized (this.f8441a) {
            if (!this.f8442b) {
                this.f8443c++;
            }
        }
    }

    public final void d(fe.a aVar) {
        synchronized (this.f8441a) {
            if (!this.f8442b) {
                this.f8444d.post(new w(26, aVar));
            }
        }
    }

    public final int e() {
        int i;
        synchronized (this.f8441a) {
            i = !this.f8442b ? this.f8443c : 0;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        ge.i.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2core.HandlerWrapper");
        return true;
    }

    public final int hashCode() {
        return -1521653773;
    }
}
