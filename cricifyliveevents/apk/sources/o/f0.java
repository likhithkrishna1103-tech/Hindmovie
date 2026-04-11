package o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends w1 {
    public final /* synthetic */ l0 E;
    public final /* synthetic */ o0 F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(o0 o0Var, o0 o0Var2, l0 l0Var) {
        super(o0Var2);
        this.F = o0Var;
        this.E = l0Var;
    }

    @Override // o.w1
    public final n.a0 b() {
        return this.E;
    }

    @Override // o.w1
    public final boolean c() {
        o0 o0Var = this.F;
        if (o0Var.getInternalPopup().a()) {
            return true;
        }
        o0Var.A.l(o0Var.getTextDirection(), o0Var.getTextAlignment());
        return true;
    }
}
