package k4;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m0 implements a1, b1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ d1 f7083v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f7084w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f7085x;

    public /* synthetic */ m0(d1 d1Var, int i, int i10) {
        this.f7083v = d1Var;
        this.f7084w = i;
        this.f7085x = i10;
    }

    @Override // k4.b1
    public void b(h1 h1Var, s sVar, List list) {
        d1 d1Var = this.f7083v;
        h1Var.s0(d1Var.N(sVar, h1Var, this.f7084w), d1Var.N(sVar, h1Var, this.f7085x), list);
    }

    @Override // k4.a1
    public void h(h1 h1Var, s sVar) {
        d1 d1Var = this.f7083v;
        h1Var.H0(d1Var.N(sVar, h1Var, this.f7084w), d1Var.N(sVar, h1Var, this.f7085x));
    }
}
