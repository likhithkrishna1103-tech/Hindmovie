package o2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements s1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ aa.l0 f9104u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u f9105v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ z f9106w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f9107x;

    public /* synthetic */ f0(aa.l0 l0Var, u uVar, z zVar, int i) {
        this.f9104u = l0Var;
        this.f9105v = uVar;
        this.f9106w = zVar;
        this.f9107x = i;
    }

    @Override // s1.h
    public final void accept(Object obj) {
        k0 k0Var = (k0) obj;
        aa.l0 l0Var = this.f9104u;
        k0Var.J(l0Var.f705v, (d0) l0Var.f706w, this.f9105v, this.f9106w, this.f9107x);
    }
}
