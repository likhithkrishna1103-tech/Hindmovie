package ue;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import pe.b0;
import pe.h0;
import pe.k1;
import pe.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends pe.s implements b0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater C = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");
    public final k A;
    public final Object B;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ b0 f12466x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final pe.s f12467y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f12468z;

    /* JADX WARN: Multi-variable type inference failed */
    public g(pe.s sVar, int i) {
        b0 b0Var = sVar instanceof b0 ? (b0) sVar : null;
        this.f12466x = b0Var == null ? z.f10291a : b0Var;
        this.f12467y = sVar;
        this.f12468z = i;
        this.A = new k();
        this.B = new Object();
    }

    @Override // pe.b0
    public final h0 R(long j4, k1 k1Var, vd.h hVar) {
        return this.f12466x.R(j4, k1Var, hVar);
    }

    @Override // pe.b0
    public final void g0(long j4, pe.h hVar) {
        this.f12466x.g0(j4, hVar);
    }

    @Override // pe.s
    public final void h0(vd.h hVar, Runnable runnable) {
        this.A.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C;
        if (atomicIntegerFieldUpdater.get(this) < this.f12468z) {
            synchronized (this.B) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f12468z) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableK0 = k0();
                if (runnableK0 == null) {
                    return;
                }
                this.f12467y.h0(this, new k8.j(7, this, runnableK0, false));
            }
        }
    }

    public final Runnable k0() {
        while (true) {
            Runnable runnable = (Runnable) this.A.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.B) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.A.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // pe.s
    public final String toString() {
        return this.f12467y + ".limitedParallelism(" + this.f12468z + ')';
    }
}
