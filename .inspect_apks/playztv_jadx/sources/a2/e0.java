package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements s1.m {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f191u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ o0 f192v;

    public /* synthetic */ e0(o0 o0Var, int i) {
        this.f191u = i;
        this.f192v = o0Var;
    }

    @Override // s1.m
    public void a(Object obj) {
        p1.u0 u0Var = (p1.u0) obj;
        switch (this.f191u) {
            case 2:
                u0Var.p(this.f192v.f349h0);
                break;
            default:
                u0Var.h(this.f192v.f351j0);
                break;
        }
    }
}
