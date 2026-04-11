package we;

import pe.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends i {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Runnable f14167x;

    public j(Runnable runnable, long j4, boolean z10) {
        super(z10, j4);
        this.f14167x = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14167x.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f14167x;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(x.g(runnable));
        sb.append(", ");
        sb.append(this.f14165v);
        sb.append(", ");
        sb.append(this.f14166w ? "Blocking" : "Non-blocking");
        sb.append(']');
        return sb.toString();
    }
}
