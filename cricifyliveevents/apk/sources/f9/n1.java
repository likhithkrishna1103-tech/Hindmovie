package f9;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 extends FutureTask implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f4281v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f4282w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f4283x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ p1 f4284y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(p1 p1Var, Runnable runnable, boolean z10, String str) {
        super(runnable, null);
        this.f4284y = p1Var;
        long andIncrement = p1.G.getAndIncrement();
        this.f4281v = andIncrement;
        this.f4283x = str;
        this.f4282w = z10;
        if (andIncrement == Long.MAX_VALUE) {
            w0 w0Var = ((r1) p1Var.f307w).A;
            r1.g(w0Var);
            w0Var.B.a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        n1 n1Var = (n1) obj;
        boolean z10 = n1Var.f4282w;
        boolean z11 = this.f4282w;
        if (z11 != z10) {
            return !z11 ? 1 : -1;
        }
        long j4 = n1Var.f4281v;
        long j7 = this.f4281v;
        if (j7 < j4) {
            return -1;
        }
        if (j7 > j4) {
            return 1;
        }
        w0 w0Var = ((r1) this.f4284y.f307w).A;
        r1.g(w0Var);
        w0Var.C.b(Long.valueOf(j7), "Two tasks share the same index. index");
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        w0 w0Var = ((r1) this.f4284y.f307w).A;
        r1.g(w0Var);
        w0Var.B.b(th, this.f4283x);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(p1 p1Var, Callable callable, boolean z10) {
        super(callable);
        this.f4284y = p1Var;
        long andIncrement = p1.G.getAndIncrement();
        this.f4281v = andIncrement;
        this.f4283x = "Task exception on worker thread";
        this.f4282w = z10;
        if (andIncrement == Long.MAX_VALUE) {
            w0 w0Var = ((r1) p1Var.f307w).A;
            r1.g(w0Var);
            w0Var.B.a("Tasks index overflow");
        }
    }
}
