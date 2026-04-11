package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class o0 extends r {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f7718z = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f7719w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7720x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public od.g f7721y;

    public final void k0(boolean z2) {
        long j5 = this.f7719w - (z2 ? 4294967296L : 1L);
        this.f7719w = j5;
        if (j5 <= 0 && this.f7720x) {
            shutdown();
        }
    }

    public abstract Thread l0();

    public final void m0(boolean z2) {
        this.f7719w = (z2 ? 4294967296L : 1L) + this.f7719w;
        if (z2) {
            return;
        }
        this.f7720x = true;
    }

    public abstract long n0();

    public final boolean o0() {
        od.g gVar = this.f7721y;
        if (gVar == null) {
            return false;
        }
        d0 d0Var = (d0) (gVar.isEmpty() ? null : gVar.removeFirst());
        if (d0Var == null) {
            return false;
        }
        d0Var.run();
        return true;
    }

    public void p0(long j5, l0 l0Var) {
        y.D.u0(j5, l0Var);
    }

    public abstract void shutdown();
}
