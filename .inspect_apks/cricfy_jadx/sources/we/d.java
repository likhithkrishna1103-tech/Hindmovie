package we;

import java.util.concurrent.Executor;
import pe.p0;
import pe.s;
import ue.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p0 implements Executor {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f14160x = new d();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final s f14161y;

    static {
        l lVar = l.f14173x;
        int i = t.f12487a;
        if (64 >= i) {
            i = 64;
        }
        f14161y = lVar.j0(ue.a.j(i, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        h0(vd.i.f13722v, runnable);
    }

    @Override // pe.s
    public final void h0(vd.h hVar, Runnable runnable) {
        f14161y.h0(hVar, runnable);
    }

    @Override // pe.s
    public final String toString() {
        return "Dispatchers.IO";
    }
}
