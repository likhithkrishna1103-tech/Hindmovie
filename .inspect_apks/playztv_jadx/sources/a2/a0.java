package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements s1.m, s1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f153u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ float f154v;

    public /* synthetic */ a0(int i, float f) {
        this.f153u = i;
        this.f154v = f;
    }

    @Override // s1.m
    public void a(Object obj) {
        ((p1.u0) obj).C(this.f154v);
    }

    @Override // s1.h
    public void accept(Object obj) {
        switch (this.f153u) {
            case 1:
                ((g4.j1) obj).i(this.f154v);
                break;
            default:
                ((g4.j1) obj).O0(this.f154v);
                break;
        }
    }
}
