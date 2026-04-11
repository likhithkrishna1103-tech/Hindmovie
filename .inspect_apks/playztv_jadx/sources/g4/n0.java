package g4;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n0 implements c1, d1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ f1 f5137u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5138v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f5139w;

    public /* synthetic */ n0(f1 f1Var, int i, int i10) {
        this.f5137u = f1Var;
        this.f5138v = i;
        this.f5139w = i10;
    }

    @Override // g4.d1
    public void b(j1 j1Var, s sVar, List list) {
        f1 f1Var = this.f5137u;
        j1Var.t0(f1Var.H(sVar, j1Var, this.f5138v), f1Var.H(sVar, j1Var, this.f5139w), list);
    }

    @Override // g4.c1
    public void j(j1 j1Var, s sVar) {
        f1 f1Var = this.f5137u;
        j1Var.H0(f1Var.H(sVar, j1Var, this.f5138v), f1Var.H(sVar, j1Var, this.f5139w));
    }
}
