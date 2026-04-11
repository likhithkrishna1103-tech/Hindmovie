package a2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j0 implements s1.m, g4.e1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f294u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ List f295v;

    public /* synthetic */ j0(int i, aa.c1 c1Var) {
        this.f294u = i;
        this.f295v = c1Var;
    }

    @Override // s1.m
    public void a(Object obj) {
        ((p1.u0) obj).y(this.f295v);
    }

    @Override // g4.e1
    public Object g(g4.b0 b0Var, g4.s sVar, int i) {
        switch (this.f294u) {
        }
        return b0Var.l(sVar, this.f295v);
    }
}
