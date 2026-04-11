package ea;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends i implements Runnable {
    public final Runnable B;

    public c0(Runnable runnable) {
        runnable.getClass();
        this.B = runnable;
    }

    @Override // ea.p
    public final String i() {
        return "task=[" + this.B + "]";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.B.run();
        } catch (Throwable th) {
            l(th);
            throw th;
        }
    }
}
