package l5;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorService f7826e = Executors.newCachedThreadPool(new x5.c());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f7827a = new LinkedHashSet(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f7828b = new LinkedHashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f7829c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile a0 f7830d = null;

    public c0(j jVar) {
        f(new a0(jVar));
    }

    public final synchronized void a(y yVar) {
        Throwable th;
        try {
            a0 a0Var = this.f7830d;
            if (a0Var != null && (th = a0Var.f7824b) != null) {
                yVar.onResult(th);
            }
            this.f7828b.add(yVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void b(y yVar) {
        j jVar;
        try {
            a0 a0Var = this.f7830d;
            if (a0Var != null && (jVar = a0Var.f7823a) != null) {
                yVar.onResult(jVar);
            }
            this.f7827a.add(yVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f7828b);
        if (arrayList.isEmpty()) {
            x5.b.c("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((y) obj).onResult(th);
        }
    }

    public final void d() {
        a0 a0Var = this.f7830d;
        if (a0Var == null) {
            return;
        }
        j jVar = a0Var.f7823a;
        if (jVar == null) {
            c(a0Var.f7824b);
            return;
        }
        synchronized (this) {
            ArrayList arrayList = new ArrayList(this.f7827a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((y) obj).onResult(jVar);
            }
        }
    }

    public final synchronized void e(i iVar) {
        this.f7828b.remove(iVar);
    }

    public final void f(a0 a0Var) {
        if (this.f7830d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f7830d = a0Var;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d();
        } else {
            this.f7829c.post(new a2.a(27, this));
        }
    }

    public c0(Callable callable, boolean z2) {
        if (z2) {
            try {
                f((a0) callable.call());
                return;
            } catch (Throwable th) {
                f(new a0(th));
                return;
            }
        }
        ExecutorService executorService = f7826e;
        b0 b0Var = new b0(callable);
        b0Var.f7825u = this;
        executorService.execute(b0Var);
    }
}
