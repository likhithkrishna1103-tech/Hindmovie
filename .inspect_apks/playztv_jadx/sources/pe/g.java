package pe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import ke.b0;
import ke.h0;
import ke.l1;
import ke.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends ke.r implements b0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater B = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");
    public final Object A;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b0 f10379w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ke.r f10380x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f10381y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final k f10382z;

    /* JADX WARN: Multi-variable type inference failed */
    public g(ke.r rVar, int i) {
        b0 b0Var = rVar instanceof b0 ? (b0) rVar : null;
        this.f10379w = b0Var == null ? z.f7749a : b0Var;
        this.f10380x = rVar;
        this.f10381y = i;
        this.f10382z = new k();
        this.A = new Object();
    }

    @Override // ke.b0
    public final h0 S(long j5, l1 l1Var, rd.h hVar) {
        return this.f10379w.S(j5, l1Var, hVar);
    }

    @Override // ke.r
    public final void h0(rd.h hVar, Runnable runnable) {
        this.f10382z.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = B;
        if (atomicIntegerFieldUpdater.get(this) < this.f10381y) {
            synchronized (this.A) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f10381y) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableK0 = k0();
                if (runnableK0 == null) {
                    return;
                }
                this.f10380x.h0(this, new p7.i(this, 2, runnableK0));
            }
        }
    }

    public final Runnable k0() {
        while (true) {
            Runnable runnable = (Runnable) this.f10382z.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.A) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = B;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f10382z.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // ke.r
    public final String toString() {
        return this.f10380x + ".limitedParallelism(" + this.f10381y + ')';
    }
}
