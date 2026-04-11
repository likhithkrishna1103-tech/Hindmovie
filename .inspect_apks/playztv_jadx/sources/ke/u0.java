package ke;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends z0 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7734z = AtomicIntegerFieldUpdater.newUpdater(u0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final y0 f7735y;

    public u0(y0 y0Var) {
        this.f7735y = y0Var;
    }

    @Override // ke.z0
    public final boolean k() {
        return true;
    }

    @Override // ke.z0
    public final void l(Throwable th) {
        if (f7734z.compareAndSet(this, 0, 1)) {
            this.f7735y.a(th);
        }
    }
}
