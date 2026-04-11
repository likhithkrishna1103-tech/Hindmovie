package g2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements y1.m, y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4927v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f4928w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f4929x;

    public /* synthetic */ w(int i, int i10, int i11) {
        this.f4927v = i11;
        this.f4928w = i;
        this.f4929x = i10;
    }

    @Override // y1.m
    public void a(Object obj) {
        ((v1.u0) obj).H(this.f4928w, this.f4929x);
    }

    @Override // y1.h
    public void accept(Object obj) {
        switch (this.f4927v) {
            case 1:
                ((k4.h1) obj).h0(this.f4928w, this.f4929x);
                break;
            default:
                ((k4.h1) obj).o0(this.f4928w, this.f4929x);
                break;
        }
    }
}
