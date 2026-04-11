package u;

import ea.y;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements y {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final WeakReference f12522u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i f12523v = new i(this);

    public j(h hVar) {
        this.f12522u = new WeakReference(hVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        h hVar = (h) this.f12522u.get();
        boolean zCancel = this.f12523v.cancel(z2);
        if (zCancel && hVar != null) {
            hVar.f12518a = null;
            hVar.f12519b = null;
            hVar.f12520c.j(null);
        }
        return zCancel;
    }

    @Override // ea.y
    public final void f(Runnable runnable, Executor executor) {
        this.f12523v.f(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f12523v.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f12523v.f12515u instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f12523v.isDone();
    }

    public final String toString() {
        return this.f12523v.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j5, TimeUnit timeUnit) {
        return this.f12523v.get(j5, timeUnit);
    }
}
