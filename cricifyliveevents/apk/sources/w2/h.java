package w2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13874d;

    public h(int i, int i10, int i11, int i12) {
        this.f13871a = i;
        this.f13872b = i10;
        this.f13873c = i11;
        this.f13874d = i12;
    }

    public final boolean a(int i) {
        if (i == 1) {
            if (this.f13871a - this.f13872b <= 1) {
                return false;
            }
        } else if (this.f13873c - this.f13874d <= 1) {
            return false;
        }
        return true;
    }
}
