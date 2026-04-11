package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements s1.m, s1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f162v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f163w;

    public /* synthetic */ b0(int i, int i10, int i11) {
        this.f161u = i11;
        this.f162v = i;
        this.f163w = i10;
    }

    @Override // s1.m
    public void a(Object obj) {
        ((p1.u0) obj).H(this.f162v, this.f163w);
    }

    @Override // s1.h
    public void accept(Object obj) {
        switch (this.f161u) {
            case 1:
                ((g4.j1) obj).j0(this.f162v, this.f163w);
                break;
            default:
                ((g4.j1) obj).p0(this.f162v, this.f163w);
                break;
        }
    }
}
