package o8;

import com.bumptech.glide.manager.s;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9439a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f9440b = new s(6);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f9442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f9443e;
    public Exception f;

    public final void a(Executor executor, b bVar) {
        this.f9440b.i(new m(executor, bVar));
        q();
    }

    public final void b(Executor executor, c cVar) {
        this.f9440b.i(new m(executor, cVar));
        q();
    }

    public final void c(Executor executor, d dVar) {
        this.f9440b.i(new m(executor, dVar));
        q();
    }

    public final void d(Executor executor, e eVar) {
        this.f9440b.i(new m(executor, eVar));
        q();
    }

    public final o e(Executor executor, a aVar) {
        o oVar = new o();
        this.f9440b.i(new l(executor, aVar, oVar, 0));
        q();
        return oVar;
    }

    public final o f(Executor executor, a aVar) {
        o oVar = new o();
        this.f9440b.i(new l(executor, aVar, oVar, 1));
        q();
        return oVar;
    }

    public final Exception g() {
        Exception exc;
        synchronized (this.f9439a) {
            exc = this.f;
        }
        return exc;
    }

    public final Object h() {
        Object obj;
        synchronized (this.f9439a) {
            try {
                v.j("Task is not yet complete", this.f9441c);
                if (this.f9442d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new f(exc);
                }
                obj = this.f9443e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean i() {
        boolean z2;
        synchronized (this.f9439a) {
            z2 = this.f9441c;
        }
        return z2;
    }

    public final boolean j() {
        boolean z2;
        synchronized (this.f9439a) {
            try {
                z2 = false;
                if (this.f9441c && !this.f9442d && this.f == null) {
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    public final o k(Executor executor, g gVar) {
        o oVar = new o();
        this.f9440b.i(new m(executor, gVar, oVar));
        q();
        return oVar;
    }

    public final void l(Exception exc) {
        v.i(exc, "Exception must not be null");
        synchronized (this.f9439a) {
            p();
            this.f9441c = true;
            this.f = exc;
        }
        this.f9440b.j(this);
    }

    public final void m(Object obj) {
        synchronized (this.f9439a) {
            p();
            this.f9441c = true;
            this.f9443e = obj;
        }
        this.f9440b.j(this);
    }

    public final void n() {
        synchronized (this.f9439a) {
            try {
                if (this.f9441c) {
                    return;
                }
                this.f9441c = true;
                this.f9442d = true;
                this.f9440b.j(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean o(Object obj) {
        synchronized (this.f9439a) {
            try {
                if (this.f9441c) {
                    return false;
                }
                this.f9441c = true;
                this.f9443e = obj;
                this.f9440b.j(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p() {
        if (this.f9441c) {
            int i = me.i.f8340u;
            if (!i()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excG = g();
        }
    }

    public final void q() {
        synchronized (this.f9439a) {
            try {
                if (this.f9441c) {
                    this.f9440b.j(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
