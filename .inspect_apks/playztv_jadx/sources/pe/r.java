package pe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import ke.g1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class r extends b implements g1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10398d = AtomicIntegerFieldUpdater.newUpdater(r.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10399c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public r(long j5, r rVar, int i) {
        super(rVar);
        this.f10399c = j5;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // pe.b
    public final boolean c() {
        return f10398d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f10398d.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i, rd.h hVar);

    public final void h() {
        if (f10398d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = f10398d;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
