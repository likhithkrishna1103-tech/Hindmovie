package a3;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f121e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Serializable f122g;

    public boolean a(int i) {
        int i10;
        int i11;
        int i12;
        int i13;
        if ((i & (-2097152)) != -2097152 || (i10 = (i >>> 19) & 3) == 1 || (i11 = (i >>> 17) & 3) == 0 || (i12 = (i >>> 12) & 15) == 0 || i12 == 15 || (i13 = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.f117a = i10;
        this.f122g = b.f139s[3 - i11];
        int i14 = b.f140t[i13];
        this.f119c = i14;
        if (i10 == 2) {
            this.f119c = i14 / 2;
        } else if (i10 == 0) {
            this.f119c = i14 / 4;
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
            int i17 = i10 == 3 ? b.f141u[i12 - 1] : b.f142v[i12 - 1];
            this.f121e = i17;
            this.f118b = (((i17 * 12) / this.f119c) + i15) * 4;
        } else {
            if (i10 == 3) {
                int i18 = i11 == 2 ? b.f143w[i12 - 1] : b.f144x[i12 - 1];
                this.f121e = i18;
                this.f118b = ((i18 * 144) / this.f119c) + i15;
            } else {
                int i19 = b.f145y[i12 - 1];
                this.f121e = i19;
                this.f118b = (((i11 == 1 ? 72 : 144) * i19) / this.f119c) + i15;
            }
        }
        this.f120d = ((i >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
