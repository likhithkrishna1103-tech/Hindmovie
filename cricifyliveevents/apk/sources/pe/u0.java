package pe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends y0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater A = AtomicIntegerFieldUpdater.newUpdater(u0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final hf.h f10275z;

    public u0(hf.h hVar) {
        this.f10275z = hVar;
    }

    @Override // pe.y0
    public final boolean k() {
        return true;
    }

    @Override // pe.y0
    public final void l(Throwable th) {
        if (A.compareAndSet(this, 0, 1)) {
            this.f10275z.a(th);
        }
    }
}
