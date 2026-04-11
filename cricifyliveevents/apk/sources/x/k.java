package x;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import ya.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final WeakReference f14205v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j f14206w = new j(this);

    public k(i iVar) {
        this.f14205v = new WeakReference(iVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        i iVar = (i) this.f14205v.get();
        boolean zCancel = this.f14206w.cancel(z10);
        if (zCancel && iVar != null) {
            iVar.f14201a = null;
            iVar.f14202b = null;
            iVar.f14203c.j(null);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f14206w.get();
    }

    @Override // ya.w
    public final void h(Runnable runnable, Executor executor) {
        this.f14206w.h(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f14206w.f14198v instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f14206w.isDone();
    }

    public final String toString() {
        return this.f14206w.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) {
        return this.f14206w.get(j4, timeUnit);
    }
}
