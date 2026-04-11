package ea;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p extends fa.a implements y {
    public static final Object A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f4622x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final x f4623y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final android.support.v4.media.session.b f4624z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile Object f4625u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile d f4626v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile o f4627w;

    static {
        boolean z2;
        Throwable th;
        android.support.v4.media.session.b gVar;
        try {
            z2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z2 = false;
        }
        f4622x = z2;
        f4623y = new x(p.class);
        Throwable th2 = null;
        try {
            gVar = new n();
            th = null;
        } catch (Error | Exception e10) {
            th = e10;
            try {
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(o.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(o.class, o.class, "b"), AtomicReferenceFieldUpdater.newUpdater(p.class, o.class, "w"), AtomicReferenceFieldUpdater.newUpdater(p.class, d.class, "v"), AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "u"));
            } catch (Error | Exception e11) {
                th2 = e11;
                gVar = new g();
            }
        }
        f4624z = gVar;
        if (th2 != null) {
            x xVar = f4623y;
            Logger loggerA = xVar.a();
            Level level = Level.SEVERE;
            loggerA.log(level, "UnsafeAtomicHelper is broken!", th);
            xVar.a().log(level, "SafeAtomicHelper is broken!", th2);
        }
        A = new Object();
    }

    public static void d(p pVar, boolean z2) {
        d dVar = null;
        while (true) {
            for (o oVarQ = f4624z.q(pVar); oVarQ != null; oVarQ = oVarQ.f4621b) {
                Thread thread = oVarQ.f4620a;
                if (thread != null) {
                    oVarQ.f4620a = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z2) {
                z2 = false;
            }
            pVar.b();
            d dVar2 = dVar;
            d dVarP = f4624z.p(pVar);
            d dVar3 = dVar2;
            while (dVarP != null) {
                d dVar4 = dVarP.f4601c;
                dVarP.f4601c = dVar3;
                dVar3 = dVarP;
                dVarP = dVar4;
            }
            while (dVar3 != null) {
                dVar = dVar3.f4601c;
                Runnable runnable = dVar3.f4599a;
                Objects.requireNonNull(runnable);
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    pVar = fVar.f4608u;
                    if (pVar.f4625u == fVar) {
                        if (f4624z.f(pVar, fVar, h(fVar.f4609v))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = dVar3.f4600b;
                    Objects.requireNonNull(executor);
                    e(runnable, executor);
                }
                dVar3 = dVar;
            }
            return;
        }
    }

    public static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e10) {
            f4623y.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object g(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f4591b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f4597a);
        }
        if (obj == A) {
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
    public static java.lang.Object h(ea.y r6) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ea.p.h(ea.y):java.lang.Object");
    }

    public final void a(StringBuilder sb2) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb2.append("CANCELLED");
                return;
            } catch (ExecutionException e10) {
                sb2.append("FAILURE, cause=[");
                sb2.append(e10.getCause());
                sb2.append("]");
                return;
            } catch (Exception e11) {
                sb2.append("UNKNOWN, cause=[");
                sb2.append(e11.getClass());
                sb2.append(" thrown from get()]");
                return;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        sb2.append("SUCCESS, result=[");
        c(sb2, obj);
        sb2.append("]");
    }

    public final void c(StringBuilder sb2, Object obj) {
        if (obj == null) {
            sb2.append("null");
        } else {
            if (obj == this) {
                sb2.append("this future");
                return;
            }
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        a aVar;
        Object obj = this.f4625u;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        if (f4622x) {
            aVar = new a(new CancellationException("Future.cancel() was called."), z2);
        } else {
            aVar = z2 ? a.f4588c : a.f4589d;
            Objects.requireNonNull(aVar);
        }
        p pVar = this;
        boolean z10 = false;
        while (true) {
            if (f4624z.f(pVar, obj, aVar)) {
                d(pVar, z2);
                if (!(obj instanceof f)) {
                    break;
                }
                y yVar = ((f) obj).f4609v;
                if (!(yVar instanceof h)) {
                    yVar.cancel(z2);
                    break;
                }
                pVar = (p) yVar;
                obj = pVar.f4625u;
                if (!(obj == null) && !(obj instanceof f)) {
                    break;
                }
                z10 = true;
            } else {
                obj = pVar.f4625u;
                if (!(obj instanceof f)) {
                    return z10;
                }
            }
        }
        return true;
    }

    @Override // ea.y
    public void f(Runnable runnable, Executor executor) {
        d dVar;
        d dVar2 = d.f4598d;
        if (!isDone() && (dVar = this.f4626v) != dVar2) {
            d dVar3 = new d(runnable, executor);
            do {
                dVar3.f4601c = dVar;
                if (f4624z.e(this, dVar, dVar3)) {
                    return;
                } else {
                    dVar = this.f4626v;
                }
            } while (dVar != dVar2);
        }
        e(runnable, executor);
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
        throw new UnsupportedOperationException("Method not decompiled: ea.p.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String i() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean isCancelled() {
        return this.f4625u instanceof a;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof f)) & (this.f4625u != null);
    }

    public final void j(o oVar) {
        oVar.f4620a = null;
        while (true) {
            o oVar2 = this.f4627w;
            if (oVar2 == o.f4619c) {
                return;
            }
            o oVar3 = null;
            while (oVar2 != null) {
                o oVar4 = oVar2.f4621b;
                if (oVar2.f4620a != null) {
                    oVar3 = oVar2;
                } else if (oVar3 != null) {
                    oVar3.f4621b = oVar4;
                    if (oVar3.f4620a == null) {
                        break;
                    }
                } else if (!f4624z.g(this, oVar2, oVar4)) {
                    break;
                }
                oVar2 = oVar4;
            }
            return;
        }
    }

    public boolean k(Object obj) {
        if (obj == null) {
            obj = A;
        }
        if (!f4624z.f(this, null, obj)) {
            return false;
        }
        d(this, false);
        return true;
    }

    public boolean l(Throwable th) {
        if (!f4624z.f(this, null, new c(th))) {
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
        throw new UnsupportedOperationException("Method not decompiled: ea.p.toString():java.lang.String");
    }

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException {
        Object obj;
        o oVar = o.f4619c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f4625u;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return g(obj2);
            }
            o oVar2 = this.f4627w;
            if (oVar2 != oVar) {
                o oVar3 = new o();
                do {
                    android.support.v4.media.session.b bVar = f4624z;
                    bVar.M(oVar3, oVar2);
                    if (bVar.g(this, oVar2, oVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f4625u;
                            } else {
                                j(oVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return g(obj);
                    }
                    oVar2 = this.f4627w;
                } while (oVar2 != oVar);
            }
            Object obj3 = this.f4625u;
            Objects.requireNonNull(obj3);
            return g(obj3);
        }
        throw new InterruptedException();
    }
}
