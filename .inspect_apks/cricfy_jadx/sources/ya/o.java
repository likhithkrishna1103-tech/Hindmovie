package ya;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o extends za.a implements w {
    public static final vf.g A;
    public static final Object B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f15004y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final g1.a f15005z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile Object f15006v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile c f15007w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile n f15008x;

    static {
        boolean z10;
        Throwable th;
        vf.g fVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        f15004y = z10;
        f15005z = new g1.a(o.class);
        Throwable th2 = null;
        try {
            fVar = new m();
            th = null;
        } catch (Error | Exception e9) {
            th = e9;
            try {
                fVar = new d(AtomicReferenceFieldUpdater.newUpdater(n.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(n.class, n.class, "b"), AtomicReferenceFieldUpdater.newUpdater(o.class, n.class, "x"), AtomicReferenceFieldUpdater.newUpdater(o.class, c.class, "w"), AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "v"));
            } catch (Error | Exception e10) {
                th2 = e10;
                fVar = new f();
            }
        }
        A = fVar;
        if (th2 != null) {
            g1.a aVar = f15005z;
            Logger loggerA = aVar.a();
            Level level = Level.SEVERE;
            loggerA.log(level, "UnsafeAtomicHelper is broken!", th);
            aVar.a().log(level, "SafeAtomicHelper is broken!", th2);
        }
        B = new Object();
    }

    public static void d(o oVar, boolean z10) {
        c cVar = null;
        while (true) {
            for (n nVarE = A.E(oVar); nVarE != null; nVarE = nVarE.f15003b) {
                Thread thread = nVarE.f15002a;
                if (thread != null) {
                    nVarE.f15002a = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z10) {
                z10 = false;
            }
            oVar.b();
            c cVar2 = cVar;
            c cVarD = A.D(oVar);
            c cVar3 = cVar2;
            while (cVarD != null) {
                c cVar4 = cVarD.f14987c;
                cVarD.f14987c = cVar3;
                cVar3 = cVarD;
                cVarD = cVar4;
            }
            while (cVar3 != null) {
                cVar = cVar3.f14987c;
                Runnable runnable = cVar3.f14985a;
                Objects.requireNonNull(runnable);
                if (runnable instanceof e) {
                    e eVar = (e) runnable;
                    oVar = eVar.f14995v;
                    if (oVar.f15006v == eVar) {
                        if (A.i(oVar, eVar, g(eVar.f14996w))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = cVar3.f14986b;
                    Objects.requireNonNull(executor);
                    e(runnable, executor);
                }
                cVar3 = cVar;
            }
            return;
        }
    }

    public static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e9) {
            f15005z.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e9);
        }
    }

    public static Object f(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f14980b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof b) {
            throw new ExecutionException(((b) obj).f14982a);
        }
        if (obj == B) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object g(ya.w r6) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.o.g(ya.w):java.lang.Object");
    }

    public final void a(StringBuilder sb) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                } catch (Throwable th) {
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (ExecutionException e9) {
                sb.append("FAILURE, cause=[");
                sb.append(e9.getCause());
                sb.append("]");
                return;
            } catch (Exception e10) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e10.getClass());
                sb.append(" thrown from get()]");
                return;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        c(sb, obj);
        sb.append("]");
    }

    public final void c(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        a aVar;
        Object obj = this.f15006v;
        if (!(obj == null) && !(obj instanceof e)) {
            return false;
        }
        if (f15004y) {
            aVar = new a(new CancellationException("Future.cancel() was called."), z10);
        } else {
            aVar = z10 ? a.f14977c : a.f14978d;
            Objects.requireNonNull(aVar);
        }
        o oVar = this;
        boolean z11 = false;
        while (true) {
            if (A.i(oVar, obj, aVar)) {
                d(oVar, z10);
                if (!(obj instanceof e)) {
                    break;
                }
                w wVar = ((e) obj).f14996w;
                if (!(wVar instanceof g)) {
                    wVar.cancel(z10);
                    break;
                }
                oVar = (o) wVar;
                obj = oVar.f15006v;
                if (!(obj == null) && !(obj instanceof e)) {
                    break;
                }
                z11 = true;
            } else {
                obj = oVar.f15006v;
                if (!(obj instanceof e)) {
                    return z11;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x00c6 -> B:37:0x0083). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object get(long r21, java.util.concurrent.TimeUnit r23) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.o.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // ya.w
    public void h(Runnable runnable, Executor executor) {
        c cVar;
        c cVar2 = c.f14984d;
        if (!isDone() && (cVar = this.f15007w) != cVar2) {
            c cVar3 = new c(runnable, executor);
            do {
                cVar3.f14987c = cVar;
                if (A.g(this, cVar, cVar3)) {
                    return;
                } else {
                    cVar = this.f15007w;
                }
            } while (cVar != cVar2);
        }
        e(runnable, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String i() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean isCancelled() {
        return this.f15006v instanceof a;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof e)) & (this.f15006v != null);
    }

    public final void j(n nVar) {
        nVar.f15002a = null;
        while (true) {
            n nVar2 = this.f15008x;
            if (nVar2 == n.f15001c) {
                return;
            }
            n nVar3 = null;
            while (nVar2 != null) {
                n nVar4 = nVar2.f15003b;
                if (nVar2.f15002a != null) {
                    nVar3 = nVar2;
                } else if (nVar3 != null) {
                    nVar3.f15003b = nVar4;
                    if (nVar3.f15002a == null) {
                        break;
                    }
                } else if (!A.k(this, nVar2, nVar4)) {
                    break;
                }
                nVar2 = nVar4;
            }
            return;
        }
    }

    public boolean k(Object obj) {
        if (obj == null) {
            obj = B;
        }
        if (!A.i(this, null, obj)) {
            return false;
        }
        d(this, false);
        return true;
    }

    public boolean l(Throwable th) {
        if (!A.i(this, null, new b(th))) {
            return false;
        }
        d(this, false);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.o.toString():java.lang.String");
    }

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException {
        Object obj;
        n nVar = n.f15001c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f15006v;
            if ((obj2 != null) & (!(obj2 instanceof e))) {
                return f(obj2);
            }
            n nVar2 = this.f15008x;
            if (nVar2 != nVar) {
                n nVar3 = new n();
                do {
                    vf.g gVar = A;
                    gVar.P(nVar3, nVar2);
                    if (gVar.k(this, nVar2, nVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f15006v;
                            } else {
                                j(nVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof e))));
                        return f(obj);
                    }
                    nVar2 = this.f15008x;
                } while (nVar2 != nVar);
            }
            Object obj3 = this.f15006v;
            Objects.requireNonNull(obj3);
            return f(obj3);
        }
        throw new InterruptedException();
    }
}
