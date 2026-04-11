package f9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b2 extends a7.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4048x;

    public b2(r1 r1Var) {
        super(r1Var);
        ((r1) this.f307w).V++;
    }

    public abstract boolean n1();

    public final void o1() {
        if (!this.f4048x) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void p1() {
        if (this.f4048x) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (n1()) {
            return;
        }
        ((r1) this.f307w).X.incrementAndGet();
        this.f4048x = true;
    }
}
