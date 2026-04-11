package w2;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13702e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Serializable f13703g;

    public boolean a(int i) {
        int i10;
        int i11;
        int i12;
        int i13;
        if ((i & (-2097152)) != -2097152 || (i10 = (i >>> 19) & 3) == 1 || (i11 = (i >>> 17) & 3) == 0 || (i12 = (i >>> 12) & 15) == 0 || i12 == 15 || (i13 = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.f13698a = i10;
        this.f13703g = b.f13587s[3 - i11];
        int i14 = b.f13588t[i13];
        this.f13700c = i14;
        if (i10 == 2) {
            this.f13700c = i14 / 2;
        } else if (i10 == 0) {
            this.f13700c = i14 / 4;
        }
        int i15 = (i >>> 9) & 1;
        int i16 = 1152;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalArgumentException();
                }
                i16 = 384;
            }
        } else if (i10 != 3) {
            i16 = 576;
        }
        this.f = i16;
        if (i11 == 3) {
            int i17 = i10 == 3 ? b.f13589u[i12 - 1] : b.f13590v[i12 - 1];
            this.f13702e = i17;
            this.f13699b = (((i17 * 12) / this.f13700c) + i15) * 4;
        } else {
            if (i10 == 3) {
                int i18 = i11 == 2 ? b.f13591w[i12 - 1] : b.f13592x[i12 - 1];
                this.f13702e = i18;
                this.f13699b = ((i18 * 144) / this.f13700c) + i15;
            } else {
                int i19 = b.f13593y[i12 - 1];
                this.f13702e = i19;
                this.f13699b = (((i11 == 1 ? 72 : 144) * i19) / this.f13700c) + i15;
            }
        }
        this.f13701d = ((i >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
