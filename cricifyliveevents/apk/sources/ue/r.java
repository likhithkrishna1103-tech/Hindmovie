package ue;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import pe.f1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r extends b implements f1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f12484d = AtomicIntegerFieldUpdater.newUpdater(r.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12485c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public r(long j4, r rVar, int i) {
        super(rVar);
        this.f12485c = j4;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // ue.b
    public final boolean c() {
        return f12484d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f12484d.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i, vd.h hVar);

    public final void h() {
        if (f12484d.incrementAndGet(this) == f()) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = f12484d;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
