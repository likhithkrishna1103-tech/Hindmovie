package k8;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends FutureTask implements Comparable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f7237u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f7238v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f7239w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h1 f7240x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(h1 h1Var, Runnable runnable, boolean z2, String str) {
        super(runnable, null);
        this.f7240x = h1Var;
        long andIncrement = h1.F.getAndIncrement();
        this.f7237u = andIncrement;
        this.f7239w = str;
        this.f7238v = z2;
        if (andIncrement == Long.MAX_VALUE) {
            h1Var.g().A.d("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        i1 i1Var = (i1) obj;
        boolean z2 = i1Var.f7238v;
        boolean z10 = this.f7238v;
        if (z10 != z2) {
            return z10 ? -1 : 1;
        }
        long j5 = i1Var.f7237u;
        long j8 = this.f7237u;
        if (j8 < j5) {
            return -1;
        }
        if (j8 > j5) {
            return 1;
        }
        this.f7240x.g().B.c(Long.valueOf(j8), "Two tasks share the same index. index");
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f7240x.g().A.c(th, this.f7239w);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(h1 h1Var, Callable callable, boolean z2) {
        super(callable);
        this.f7240x = h1Var;
        long andIncrement = h1.F.getAndIncrement();
        this.f7237u = andIncrement;
        this.f7239w = "Task exception on worker thread";
        this.f7238v = z2;
        if (andIncrement == Long.MAX_VALUE) {
            h1Var.g().A.d("Tasks index overflow");
        }
    }
}
