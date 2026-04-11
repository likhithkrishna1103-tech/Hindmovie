package f9;

import java.lang.Thread;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p1 f4269b;

    public m1(p1 p1Var, String str) {
        this.f4269b = p1Var;
        this.f4268a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        w0 w0Var = ((r1) this.f4269b.f307w).A;
        r1.g(w0Var);
        w0Var.B.b(th, this.f4268a);
    }
}
