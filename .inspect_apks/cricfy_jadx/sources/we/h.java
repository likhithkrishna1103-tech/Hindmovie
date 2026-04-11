package we;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import pe.p0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends p0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f14164x;

    @Override // pe.s
    public final void h0(vd.h hVar, Runnable runnable) {
        c cVar = this.f14164x;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.C;
        cVar.g(runnable, false);
    }
}
