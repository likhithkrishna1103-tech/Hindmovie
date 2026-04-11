package s3;

import a3.q;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f11465d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f11466a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11468c;

    public static long a(int i, boolean z10, byte[] bArr) {
        long j4 = ((long) bArr[0]) & 255;
        if (z10) {
            j4 &= ~f11465d[i - 1];
        }
        for (int i10 = 1; i10 < i; i10++) {
            j4 = (j4 << 8) | (((long) bArr[i10]) & 255);
        }
        return j4;
    }

    public final long b(q qVar, boolean z10, boolean z11, int i) {
        int i10;
        int i11 = this.f11467b;
        byte[] bArr = this.f11466a;
        if (i11 == 0) {
            if (!qVar.g(bArr, 0, 1, z10)) {
                return -1L;
            }
            int i12 = bArr[0] & 255;
            int i13 = 0;
            while (true) {
                if (i13 >= 8) {
                    i10 = -1;
                    break;
                }
                if ((f11465d[i13] & ((long) i12)) != 0) {
                    i10 = i13 + 1;
                    break;
                }
                i13++;
            }
            this.f11468c = i10;
            if (i10 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f11467b = 1;
        }
        int i14 = this.f11468c;
        if (i14 > i) {
            this.f11467b = 0;
            return -2L;
        }
        if (i14 != 1) {
            qVar.readFully(bArr, 1, i14 - 1);
        }
        this.f11467b = 0;
        return a(this.f11468c, z11, bArr);
    }
}
