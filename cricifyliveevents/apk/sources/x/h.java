package x;

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
import ya.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h implements w {
    public static final vf.g A;
    public static final Object B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f14196y = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Logger f14197z = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile Object f14198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile d f14199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile g f14200x;

    static {
        vf.g fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, g.class, "x"), AtomicReferenceFieldUpdater.newUpdater(h.class, d.class, "w"), AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "v"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        A = fVar;
        if (th != null) {
            f14197z.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        B = new Object();
    }

    public static void c(h hVar) {
        g gVar;
        d dVar;
        d dVar2;
        d dVar3;
        do {
            gVar = hVar.f14200x;
        } while (!A.j(hVar, gVar, g.f14193c));
        while (true) {
            dVar = null;
            if (gVar == null) {
                break;
            }
            Thread thread = gVar.f14194a;
            if (thread != null) {
                gVar.f14194a = null;
                LockSupport.unpark(thread);
            }
            gVar = gVar.f14195b;
        }
        hVar.b();
        do {
            dVar2 = hVar.f14199w;
        } while (!A.f(hVar, dVar2, d.f14186d));
        while (true) {
            dVar3 = dVar;
            dVar = dVar2;
            if (dVar == null) {
                break;
            }
            dVar2 = dVar.f14189c;
            dVar.f14189c = dVar3;
        }
        while (dVar3 != null) {
            d dVar4 = dVar3.f14189c;
            d(dVar3.f14187a, dVar3.f14188b);
            dVar3 = dVar4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e9) {
            f14197z.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e9);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f14183b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f14185a);
        }
        if (obj == B) {
            return null;
        }
        return obj;
    }

    public static Object f(h hVar) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = hVar.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object objF = f(this);
            sb.append("SUCCESS, result=[");
            sb.append(objF == this ? "this future" : String.valueOf(objF));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e9) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e9.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e10) {
            sb.append("FAILURE, cause=[");
            sb.append(e10.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f14198v;
        if (obj == null) {
            if (A.h(this, obj, f14196y ? new a(new CancellationException("Future.cancel() was called."), z10) : z10 ? a.f14180c : a.f14181d)) {
                c(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String g() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        g gVar = g.f14193c;
        long nanos = timeUnit.toNanos(j4);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f14198v;
        if (obj != null) {
            return e(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar2 = this.f14200x;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                do {
                    vf.g gVar4 = A;
                    gVar4.O(gVar3, gVar2);
                    if (gVar4.j(this, gVar2, gVar3)) {
                        while (true) {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                i(gVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f14198v;
                            if (obj2 != null) {
                                return e(obj2);
                            }
                            long jNanoTime2 = jNanoTime - System.nanoTime();
                            if (jNanoTime2 < 1000) {
                                i(gVar3);
                                nanos = jNanoTime2;
                                break;
                            }
                            nanos = jNanoTime2;
                        }
                    } else {
                        gVar2 = this.f14200x;
                    }
                } while (gVar2 != gVar);
            }
            return e(this.f14198v);
        }
        while (nanos > 0) {
            Object obj3 = this.f14198v;
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
        String strJ = "Waited " + j4 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strJ2 = l0.e.j(strJ, " (plus ");
            long j7 = -nanos;
            long jConvert = timeUnit.convert(j7, TimeUnit.NANOSECONDS);
            long nanos2 = j7 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strJ3 = strJ2 + jConvert + " " + lowerCase;
                if (z10) {
                    strJ3 = l0.e.j(strJ3, ",");
                }
                strJ2 = l0.e.j(strJ3, " ");
            }
            if (z10) {
                strJ2 = strJ2 + nanos2 + " nanoseconds ";
            }
            strJ = l0.e.j(strJ2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(l0.e.j(strJ, " but future completed as timeout expired"));
        }
        throw new TimeoutException(strJ + " for " + string);
    }

    @Override // ya.w
    public final void h(Runnable runnable, Executor executor) {
        d dVar = this.f14199w;
        d dVar2 = d.f14186d;
        if (dVar != dVar2) {
            d dVar3 = new d(runnable, executor);
            do {
                dVar3.f14189c = dVar;
                if (A.f(this, dVar, dVar3)) {
                    return;
                } else {
                    dVar = this.f14199w;
                }
            } while (dVar != dVar2);
        }
        d(runnable, executor);
    }

    public final void i(g gVar) {
        gVar.f14194a = null;
        while (true) {
            g gVar2 = this.f14200x;
            if (gVar2 == g.f14193c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f14195b;
                if (gVar2.f14194a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f14195b = gVar4;
                    if (gVar3.f14194a == null) {
                        break;
                    }
                } else if (!A.j(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f14198v instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f14198v != null;
    }

    public boolean j(Object obj) {
        if (obj == null) {
            obj = B;
        }
        if (!A.h(this, null, obj)) {
            return false;
        }
        c(this);
        return true;
    }

    public boolean k(Throwable th) {
        th.getClass();
        if (!A.h(this, null, new c(th))) {
            return false;
        }
        c(this);
        return true;
    }

    public final String toString() {
        String strG;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f14198v instanceof a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strG = g();
            } catch (RuntimeException e9) {
                strG = "Exception thrown from implementation: " + e9.getClass();
            }
            if (strG != null && !strG.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strG);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        g gVar = g.f14193c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f14198v;
            if (obj2 != null) {
                return e(obj2);
            }
            g gVar2 = this.f14200x;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                do {
                    vf.g gVar4 = A;
                    gVar4.O(gVar3, gVar2);
                    if (gVar4.j(this, gVar2, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f14198v;
                            } else {
                                i(gVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return e(obj);
                    }
                    gVar2 = this.f14200x;
                } while (gVar2 != gVar);
            }
            return e(this.f14198v);
        }
        throw new InterruptedException();
    }
}
