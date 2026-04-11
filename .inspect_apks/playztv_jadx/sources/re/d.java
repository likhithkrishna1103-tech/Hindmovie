package re;

import java.util.concurrent.Executor;
import ke.p0;
import ke.r;
import pe.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p0 implements Executor {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f11591w = new d();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final r f11592x;

    static {
        l lVar = l.f11604w;
        int i = t.f10401a;
        if (64 >= i) {
            i = 64;
        }
        f11592x = lVar.j0(pe.a.j(i, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        h0(rd.i.f11572u, runnable);
    }

    @Override // ke.r
    public final void h0(rd.h hVar, Runnable runnable) {
        f11592x.h0(hVar, runnable);
    }

    @Override // ke.r
    public final String toString() {
        return "Dispatchers.IO";
    }
}
