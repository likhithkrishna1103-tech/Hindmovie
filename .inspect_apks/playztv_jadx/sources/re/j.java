package re;

import ke.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends i {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f11598w;

    public j(Runnable runnable, long j5, boolean z2) {
        super(z2, j5);
        this.f11598w = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11598w.run();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Task[");
        Runnable runnable = this.f11598w;
        sb2.append(runnable.getClass().getSimpleName());
        sb2.append('@');
        sb2.append(x.f(runnable));
        sb2.append(", ");
        sb2.append(this.f11596u);
        sb2.append(", ");
        sb2.append(this.f11597v ? "Blocking" : "Non-blocking");
        sb2.append(']');
        return sb2.toString();
    }
}
