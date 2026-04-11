package j9;

import com.bumptech.glide.manager.u;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6706a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f6707b = new u();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f6709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f6710e;
    public Exception f;

    public final void a(Executor executor, c cVar) {
        this.f6707b.h(new n(executor, cVar));
        q();
    }

    public final void b(Executor executor, d dVar) {
        this.f6707b.h(new n(executor, dVar));
        q();
    }

    public final void c(Executor executor, e eVar) {
        this.f6707b.h(new n(executor, eVar));
        q();
    }

    public final void d(Executor executor, f fVar) {
        this.f6707b.h(new n(executor, fVar));
        q();
    }

    public final p e(Executor executor, a aVar) {
        p pVar = new p();
        this.f6707b.h(new m(executor, aVar, pVar, 0));
        q();
        return pVar;
    }

    public final p f(Executor executor, a aVar) {
        p pVar = new p();
        this.f6707b.h(new m(executor, aVar, pVar, 1));
        q();
        return pVar;
    }

    public final Exception g() {
        Exception exc;
        synchronized (this.f6706a) {
            exc = this.f;
        }
        return exc;
    }

    public final Object h() {
        Object obj;
        synchronized (this.f6706a) {
            try {
                o8.u.i("Task is not yet complete", this.f6708c);
                if (this.f6709d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new g(exc);
                }
                obj = this.f6710e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean i() {
        boolean z10;
        synchronized (this.f6706a) {
            z10 = this.f6708c;
        }
        return z10;
    }

    public final boolean j() {
        boolean z10;
        synchronized (this.f6706a) {
            try {
                z10 = false;
                if (this.f6708c && !this.f6709d && this.f == null) {
                    z10 = true;
                }
            } finally {
            }
        }
        return z10;
    }

    public final p k(Executor executor, h hVar) {
        p pVar = new p();
        this.f6707b.h(new n(executor, hVar, pVar));
        q();
        return pVar;
    }

    public final void l(Object obj) {
        synchronized (this.f6706a) {
            p();
            this.f6708c = true;
            this.f6710e = obj;
        }
        this.f6707b.i(this);
    }

    public final boolean m(Object obj) {
        synchronized (this.f6706a) {
            try {
                if (this.f6708c) {
                    return false;
                }
                this.f6708c = true;
                this.f6710e = obj;
                this.f6707b.i(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(Exception exc) {
        o8.u.h(exc, "Exception must not be null");
        synchronized (this.f6706a) {
            p();
            this.f6708c = true;
            this.f = exc;
        }
        this.f6707b.i(this);
    }

    public final void o() {
        synchronized (this.f6706a) {
            try {
                if (this.f6708c) {
                    return;
                }
                this.f6708c = true;
                this.f6709d = true;
                this.f6707b.i(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p() {
        if (this.f6708c) {
            int i = b.f6687v;
            if (!i()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excG = g();
        }
    }

    public final void q() {
        synchronized (this.f6706a) {
            try {
                if (this.f6708c) {
                    this.f6707b.i(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
