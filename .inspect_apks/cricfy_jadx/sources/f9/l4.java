package f9;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l4 extends h4 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4265y;

    public l4(q4 q4Var) {
        super(q4Var);
        this.f4215x.M++;
    }

    public final void n1() {
        if (!this.f4265y) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void o1() {
        if (this.f4265y) {
            throw new IllegalStateException("Can't initialize twice");
        }
        p1();
        this.f4215x.N++;
        this.f4265y = true;
    }

    public abstract void p1();
}
