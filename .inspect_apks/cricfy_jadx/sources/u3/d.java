package u3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12090e;

    public boolean a() {
        int i = this.f12086a;
        int i10 = 2;
        if ((i & 7) != 0) {
            int i11 = this.f12089d;
            int i12 = this.f12087b;
            if (((i11 > i12 ? 1 : i11 == i12 ? 2 : 4) & i) == 0) {
                return false;
            }
        }
        if ((i & 112) != 0) {
            int i13 = this.f12089d;
            int i14 = this.f12088c;
            if ((((i13 > i14 ? 1 : i13 == i14 ? 2 : 4) << 4) & i) == 0) {
                return false;
            }
        }
        if ((i & 1792) != 0) {
            int i15 = this.f12090e;
            int i16 = this.f12087b;
            if ((((i15 > i16 ? 1 : i15 == i16 ? 2 : 4) << 8) & i) == 0) {
                return false;
            }
        }
        if ((i & 28672) != 0) {
            int i17 = this.f12090e;
            int i18 = this.f12088c;
            if (i17 > i18) {
                i10 = 1;
            } else if (i17 != i18) {
                i10 = 4;
            }
            if ((i & (i10 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
