package ya;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends h implements Runnable {
    public final Runnable C;

    public a0(Runnable runnable) {
        runnable.getClass();
        this.C = runnable;
    }

    @Override // ya.o
    public final String i() {
        return "task=[" + this.C + "]";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.C.run();
        } catch (Throwable th) {
            l(th);
            throw th;
        }
    }
}
