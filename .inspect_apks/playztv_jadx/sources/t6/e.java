package t6;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import e6.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Future, u6.d, f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f12213u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f12214v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12215w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12216x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12217y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public x f12218z;

    @Override // u6.d
    public final synchronized void a(Object obj) {
    }

    @Override // u6.d
    public final void b(h hVar) throws Throwable {
        hVar.m(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // u6.d
    public final synchronized void c(Drawable drawable) {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f12215w = true;
                notifyAll();
                c cVar = null;
                if (z2) {
                    c cVar2 = this.f12214v;
                    this.f12214v = null;
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

    @Override // u6.d
    public final synchronized c g() {
        return this.f12214v;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        try {
            return n(null);
        } catch (TimeoutException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // t6.f
    public final synchronized void i(x xVar) {
        this.f12217y = true;
        this.f12218z = xVar;
        notifyAll();
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isCancelled() {
        return this.f12215w;
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
            boolean r0 = r1.f12215w     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.f12216x     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.f12217y     // Catch: java.lang.Throwable -> L10
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
        throw new UnsupportedOperationException("Method not decompiled: t6.e.isDone():boolean");
    }

    @Override // u6.d
    public final synchronized void j(c cVar) {
        this.f12214v = cVar;
    }

    public final synchronized Object n(Long l10) {
        if (!isDone()) {
            char[] cArr = m.f14291a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalArgumentException("You must call this method on a background thread");
            }
        }
        if (this.f12215w) {
            throw new CancellationException();
        }
        if (this.f12217y) {
            throw new ExecutionException(this.f12218z);
        }
        if (this.f12216x) {
            return this.f12213u;
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
        if (this.f12217y) {
            throw new ExecutionException(this.f12218z);
        }
        if (this.f12215w) {
            throw new CancellationException();
        }
        if (this.f12216x) {
            return this.f12213u;
        }
        throw new TimeoutException();
    }

    public final String toString() {
        c cVar;
        String str;
        String strO = l4.a.o(new StringBuilder(), super.toString(), "[status=");
        synchronized (this) {
            try {
                cVar = null;
                if (this.f12215w) {
                    str = "CANCELLED";
                } else if (this.f12217y) {
                    str = "FAILURE";
                } else if (this.f12216x) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    cVar = this.f12214v;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (cVar == null) {
            return strO + str + "]";
        }
        return strO + str + ", request=[" + cVar + "]]";
    }

    @Override // t6.f
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final synchronized boolean mo3a(Object obj) {
        this.f12216x = true;
        this.f12213u = obj;
        notifyAll();
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j5, TimeUnit timeUnit) {
        return n(Long.valueOf(timeUnit.toMillis(j5)));
    }

    @Override // com.bumptech.glide.manager.h
    public final void d() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
    }

    @Override // u6.d
    public final void e(Drawable drawable) {
    }

    @Override // u6.d
    public final void h(Drawable drawable) {
    }

    @Override // u6.d
    public final void k(h hVar) {
    }
}
