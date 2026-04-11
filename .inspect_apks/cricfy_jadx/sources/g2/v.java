package g2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements y1.m, y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4917v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ float f4918w;

    public /* synthetic */ v(int i, float f) {
        this.f4917v = i;
        this.f4918w = f;
    }

    @Override // y1.m
    public void a(Object obj) {
        ((v1.u0) obj).z(this.f4918w);
    }

    @Override // y1.h
    public void accept(Object obj) {
        switch (this.f4917v) {
            case 1:
                ((k4.h1) obj).e(this.f4918w);
                break;
            default:
                ((k4.h1) obj).O0(this.f4918w);
                break;
        }
    }
}
