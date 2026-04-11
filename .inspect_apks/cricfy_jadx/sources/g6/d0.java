package g6;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f5060e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f5061a = new LinkedHashSet(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f5062b = new LinkedHashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f5063c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile b0 f5064d = null;

    static {
        if ("true".equals(System.getProperty("lottie.testing.directExecutor"))) {
            f5060e = new p.a(1);
        } else {
            f5060e = Executors.newCachedThreadPool(new s6.d());
        }
    }

    public d0(i iVar) {
        f(new b0(iVar));
    }

    public final synchronized void a(z zVar) {
        Throwable th;
        try {
            b0 b0Var = this.f5064d;
            if (b0Var != null && (th = b0Var.f5058b) != null) {
                zVar.onResult(th);
            }
            this.f5062b.add(zVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void b(z zVar) {
        i iVar;
        try {
            b0 b0Var = this.f5064d;
            if (b0Var != null && (iVar = b0Var.f5057a) != null) {
                zVar.onResult(iVar);
            }
            this.f5061a.add(zVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f5062b);
        if (arrayList.isEmpty()) {
            s6.c.c("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((z) obj).onResult(th);
        }
    }

    public final void d() {
        b0 b0Var = this.f5064d;
        if (b0Var == null) {
            return;
        }
        i iVar = b0Var.f5057a;
        if (iVar == null) {
            c(b0Var.f5058b);
            return;
        }
        synchronized (this) {
            ArrayList arrayList = new ArrayList(this.f5061a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((z) obj).onResult(iVar);
            }
        }
    }

    public final synchronized void e(h hVar) {
        this.f5062b.remove(hVar);
    }

    public final void f(b0 b0Var) {
        if (this.f5064d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f5064d = b0Var;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d();
        } else {
            this.f5063c.post(new androidx.emoji2.text.w(12, this));
        }
    }

    public d0(Callable callable, boolean z10) {
        if (z10) {
            try {
                f((b0) callable.call());
                return;
            } catch (Throwable th) {
                f(new b0(th));
                return;
            }
        }
        Executor executor = f5060e;
        c0 c0Var = new c0(callable);
        c0Var.f5059v = this;
        executor.execute(c0Var);
    }
}
