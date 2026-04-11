package f9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 extends d0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4202x;

    public h0(r1 r1Var) {
        super(r1Var);
        ((r1) this.f307w).V++;
    }

    public final void n1() {
        if (!this.f4202x) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void o1() {
        if (this.f4202x) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (p1()) {
            return;
        }
        ((r1) this.f307w).X.incrementAndGet();
        this.f4202x = true;
    }

    public abstract boolean p1();
}
