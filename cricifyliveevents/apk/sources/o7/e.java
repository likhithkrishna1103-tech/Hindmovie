package o7;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import s7.m;
import z6.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Future, p7.d, f {
    public x A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f9574v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f9575w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9576x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9577y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9578z;

    @Override // p7.d
    public final synchronized void a(Object obj) {
    }

    @Override // p7.d
    public final synchronized void b(Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f9576x = true;
                notifyAll();
                c cVar = null;
                if (z10) {
                    c cVar2 = this.f9575w;
                    this.f9575w = null;
                    cVar = cVar2;
                }
                if (cVar != null) {
                    cVar.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p7.d
    public final synchronized void d(c cVar) {
        this.f9575w = cVar;
    }

    @Override // p7.d
    public final void e(h hVar) throws Throwable {
        hVar.m(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        try {
            return n(null);
        } catch (TimeoutException e9) {
            throw new AssertionError(e9);
        }
    }

    @Override // o7.f
    public final synchronized void i(x xVar) {
        this.f9578z = true;
        this.A = xVar;
        notifyAll();
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isCancelled() {
        return this.f9576x;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0012  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f9576x     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.f9577y     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.f9578z     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            goto L12
        Le:
            r0 = 0
            goto L13
        L10:
            r0 = move-exception
            goto L15
        L12:
            r0 = 1
        L13:
            monitor-exit(r1)
            return r0
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.e.isDone():boolean");
    }

    @Override // p7.d
    public final synchronized c j() {
        return this.f9575w;
    }

    public final synchronized Object n(Long l10) {
        if (!isDone()) {
            char[] cArr = m.f11607a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalArgumentException("You must call this method on a background thread");
            }
        }
        if (this.f9576x) {
            throw new CancellationException();
        }
        if (this.f9578z) {
            throw new ExecutionException(this.A);
        }
        if (this.f9577y) {
            return this.f9574v;
        }
        if (l10 == null) {
            wait(0L);
        } else if (l10.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l10.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                wait(jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.f9578z) {
            throw new ExecutionException(this.A);
        }
        if (this.f9576x) {
            throw new CancellationException();
        }
        if (this.f9577y) {
            return this.f9574v;
        }
        throw new TimeoutException();
    }

    public final String toString() {
        c cVar;
        String str;
        String strQ = q4.a.q(new StringBuilder(), super.toString(), "[status=");
        synchronized (this) {
            try {
                cVar = null;
                if (this.f9576x) {
                    str = "CANCELLED";
                } else if (this.f9578z) {
                    str = "FAILURE";
                } else if (this.f9577y) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    cVar = this.f9575w;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (cVar == null) {
            return strQ + str + "]";
        }
        return strQ + str + ", request=[" + cVar + "]]";
    }

    @Override // o7.f
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final synchronized boolean mo0a(Object obj) {
        this.f9577y = true;
        this.f9574v = obj;
        notifyAll();
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        return n(Long.valueOf(timeUnit.toMillis(j4)));
    }

    @Override // com.bumptech.glide.manager.h
    public final void c() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
    }

    @Override // p7.d
    public final void f(h hVar) {
    }

    @Override // p7.d
    public final void g(Drawable drawable) {
    }

    @Override // p7.d
    public final void k(Drawable drawable) {
    }
}
