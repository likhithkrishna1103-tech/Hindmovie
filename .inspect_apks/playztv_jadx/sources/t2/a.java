package t2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import r2.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ Executor f12065u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h f12066v;

    public a(ExecutorService executorService, h hVar) {
        this.f12065u = executorService;
        this.f12066v = hVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f12065u.execute(runnable);
    }
}
