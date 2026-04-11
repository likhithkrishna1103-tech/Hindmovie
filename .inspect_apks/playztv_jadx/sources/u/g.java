package u;

import cf.l;
import ea.y;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g implements y {
    public static final Object A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f12512x = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Logger f12513y = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final l f12514z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile Object f12515u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile c f12516v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile f f12517w;

    static {
        l eVar;
        try {
            eVar = new d(AtomicReferenceFieldUpdater.newUpdater(f.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(f.class, f.class, "b"), AtomicReferenceFieldUpdater.newUpdater(g.class, f.class, "w"), AtomicReferenceFieldUpdater.newUpdater(g.class, c.class, "v"), AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "u"));
            th = null;
        } catch (Throwable th) {
            th = th;
            eVar = new e();
        }
        f12514z = eVar;
        if (th != null) {
            f12513y.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        A = new Object();
    }

    public static void c(g gVar) {
        f fVar;
        c cVar;
        c cVar2;
        c cVar3;
        do {
            fVar = gVar.f12517w;
        } while (!f12514z.f(gVar, fVar, f.f12509c));
        while (true) {
            cVar = null;
            if (fVar == null) {
                break;
            }
            Thread thread = fVar.f12510a;
            if (thread != null) {
                fVar.f12510a = null;
                LockSupport.unpark(thread);
            }
            fVar = fVar.f12511b;
        }
        gVar.b();
        do {
            cVar2 = gVar.f12516v;
        } while (!f12514z.d(gVar, cVar2, c.f12500d));
        while (true) {
            cVar3 = cVar;
            cVar = cVar2;
            if (cVar == null) {
                break;
            }
            cVar2 = cVar.f12503c;
            cVar.f12503c = cVar3;
        }
        while (cVar3 != null) {
            c cVar4 = cVar3.f12503c;
            d(cVar3.f12501a, cVar3.f12502b);
            cVar3 = cVar4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f12513y.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f12498b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof b) {
            throw new ExecutionException(((b) obj).f12499a);
        }
        if (obj == A) {
            return null;
        }
        return obj;
    }

    public static Object g(g gVar) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = gVar.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb2) {
        try {
            Object objG = g(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(objG == this ? "this future" : String.valueOf(objG));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        Object obj = this.f12515u;
        if (obj == null) {
            if (f12514z.e(this, obj, f12512x ? new a(new CancellationException("Future.cancel() was called."), z2) : z2 ? a.f12495c : a.f12496d)) {
                c(this);
                return true;
            }
        }
        return false;
    }

    @Override // ea.y
    public final void f(Runnable runnable, Executor executor) {
        c cVar = this.f12516v;
        c cVar2 = c.f12500d;
        if (cVar != cVar2) {
            c cVar3 = new c(runnable, executor);
            do {
                cVar3.f12503c = cVar;
                if (f12514z.d(this, cVar, cVar3)) {
                    return;
                } else {
                    cVar = this.f12516v;
                }
            } while (cVar != cVar2);
        }
        d(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j5, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        f fVar = f.f12509c;
        long nanos = timeUnit.toNanos(j5);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f12515u;
        if (obj != null) {
            return e(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            f fVar2 = this.f12517w;
            if (fVar2 != fVar) {
                f fVar3 = new f();
                do {
                    l lVar = f12514z;
                    lVar.x(fVar3, fVar2);
                    if (lVar.f(this, fVar2, fVar3)) {
                        while (true) {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                i(fVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f12515u;
                            if (obj2 != null) {
                                return e(obj2);
                            }
                            long jNanoTime2 = jNanoTime - System.nanoTime();
                            if (jNanoTime2 < 1000) {
                                i(fVar3);
                                nanos = jNanoTime2;
                                break;
                            }
                            nanos = jNanoTime2;
                        }
                    } else {
                        fVar2 = this.f12517w;
                    }
                } while (fVar2 != fVar);
            }
            return e(this.f12515u);
        }
        while (nanos > 0) {
            Object obj3 = this.f12515u;
            if (obj3 != null) {
                return e(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strM = "Waited " + j5 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strM2 = e6.j.m(strM, " (plus ");
            long j8 = -nanos;
            long jConvert = timeUnit.convert(j8, TimeUnit.NANOSECONDS);
            long nanos2 = j8 - timeUnit.toNanos(jConvert);
            boolean z2 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strM3 = strM2 + jConvert + " " + lowerCase;
                if (z2) {
                    strM3 = e6.j.m(strM3, ",");
                }
                strM2 = e6.j.m(strM3, " ");
            }
            if (z2) {
                strM2 = strM2 + nanos2 + " nanoseconds ";
            }
            strM = e6.j.m(strM2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(e6.j.m(strM, " but future completed as timeout expired"));
        }
        throw new TimeoutException(strM + " for " + string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String h() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void i(f fVar) {
        fVar.f12510a = null;
        while (true) {
            f fVar2 = this.f12517w;
            if (fVar2 == f.f12509c) {
                return;
            }
            f fVar3 = null;
            while (fVar2 != null) {
                f fVar4 = fVar2.f12511b;
                if (fVar2.f12510a != null) {
                    fVar3 = fVar2;
                } else if (fVar3 != null) {
                    fVar3.f12511b = fVar4;
                    if (fVar3.f12510a == null) {
                        break;
                    }
                } else if (!f12514z.f(this, fVar2, fVar4)) {
                    break;
                }
                fVar2 = fVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f12515u instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f12515u != null;
    }

    public boolean j(Object obj) {
        if (obj == null) {
            obj = A;
        }
        if (!f12514z.e(this, null, obj)) {
            return false;
        }
        c(this);
        return true;
    }

    public boolean k(Throwable th) {
        th.getClass();
        if (!f12514z.e(this, null, new b(th))) {
            return false;
        }
        c(this);
        return true;
    }

    public final String toString() {
        String strH;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f12515u instanceof a) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            try {
                strH = h();
            } catch (RuntimeException e10) {
                strH = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strH != null && !strH.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strH);
                sb2.append("]");
            } else if (isDone()) {
                a(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        f fVar = f.f12509c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f12515u;
            if (obj2 != null) {
                return e(obj2);
            }
            f fVar2 = this.f12517w;
            if (fVar2 != fVar) {
                f fVar3 = new f();
                do {
                    l lVar = f12514z;
                    lVar.x(fVar3, fVar2);
                    if (lVar.f(this, fVar2, fVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f12515u;
                            } else {
                                i(fVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return e(obj);
                    }
                    fVar2 = this.f12517w;
                } while (fVar2 != fVar);
            }
            return e(this.f12515u);
        }
        throw new InterruptedException();
    }
}
