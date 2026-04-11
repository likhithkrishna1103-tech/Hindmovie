package q3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10615e;

    public boolean a() {
        int i = this.f10611a;
        int i10 = 2;
        if ((i & 7) != 0) {
            int i11 = this.f10614d;
            int i12 = this.f10612b;
            if (((i11 > i12 ? 1 : i11 == i12 ? 2 : 4) & i) == 0) {
                return false;
            }
        }
        if ((i & 112) != 0) {
            int i13 = this.f10614d;
            int i14 = this.f10613c;
            if ((((i13 > i14 ? 1 : i13 == i14 ? 2 : 4) << 4) & i) == 0) {
                return false;
            }
        }
        if ((i & 1792) != 0) {
            int i15 = this.f10615e;
            int i16 = this.f10612b;
            if ((((i15 > i16 ? 1 : i15 == i16 ? 2 : 4) << 8) & i) == 0) {
                return false;
            }
        }
        if ((i & 28672) != 0) {
            int i17 = this.f10615e;
            int i18 = this.f10613c;
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
