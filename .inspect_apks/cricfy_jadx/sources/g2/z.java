package g2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements y1.m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4950v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g0 f4951w;

    public /* synthetic */ z(g0 g0Var, int i) {
        this.f4950v = i;
        this.f4951w = g0Var;
    }

    @Override // y1.m
    public void a(Object obj) {
        v1.u0 u0Var = (v1.u0) obj;
        switch (this.f4950v) {
            case 2:
                u0Var.P(this.f4951w.f4697i0);
                break;
            default:
                u0Var.n(this.f4951w.f4699k0);
                break;
        }
    }
}
