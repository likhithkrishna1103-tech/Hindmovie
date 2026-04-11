package x2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import v1.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Executor f14286v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b0 f14287w;

    public a(ExecutorService executorService, b0 b0Var) {
        this.f14286v = executorService;
        this.f14287w = b0Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f14286v.execute(runnable);
    }
}
