package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o0 extends s {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f10259x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10260y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public sd.h f10261z;

    public final void k0(boolean z10) {
        long j4 = this.f10259x - (z10 ? 4294967296L : 1L);
        this.f10259x = j4;
        if (j4 <= 0 && this.f10260y) {
            shutdown();
        }
    }

    public abstract Thread l0();

    public final void m0(boolean z10) {
        this.f10259x = (z10 ? 4294967296L : 1L) + this.f10259x;
        if (z10) {
            return;
        }
        this.f10260y = true;
    }

    public abstract long n0();

    public final boolean o0() {
        sd.h hVar = this.f10261z;
        if (hVar == null) {
            return false;
        }
        d0 d0Var = (d0) (hVar.isEmpty() ? null : hVar.removeFirst());
        if (d0Var == null) {
            return false;
        }
        d0Var.run();
        return true;
    }

    public void p0(long j4, l0 l0Var) {
        y.E.u0(j4, l0Var);
    }

    public abstract void shutdown();
}
