package n;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends w1 {
    public final /* synthetic */ n0 D;
    public final /* synthetic */ q0 E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(q0 q0Var, q0 q0Var2, n0 n0Var) {
        super(q0Var2);
        this.E = q0Var;
        this.D = n0Var;
    }

    @Override // n.w1
    public final m.a0 b() {
        return this.D;
    }

    @Override // n.w1
    public final boolean c() {
        q0 q0Var = this.E;
        if (q0Var.getInternalPopup().a()) {
            return true;
        }
        q0Var.f8506z.l(q0Var.getTextDirection(), q0Var.getTextAlignment());
        return true;
    }
}
