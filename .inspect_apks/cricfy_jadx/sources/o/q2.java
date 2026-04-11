package o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9332e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9334h;

    public final void a(int i, int i10) {
        this.f9330c = i;
        this.f9331d = i10;
        this.f9334h = true;
        if (this.f9333g) {
            if (i10 != Integer.MIN_VALUE) {
                this.f9328a = i10;
            }
            if (i != Integer.MIN_VALUE) {
                this.f9329b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f9328a = i;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f9329b = i10;
        }
    }
}
