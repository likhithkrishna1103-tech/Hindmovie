package o3;

import w2.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f9331d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9332a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9334c;

    public static long a(int i, boolean z2, byte[] bArr) {
        long j5 = ((long) bArr[0]) & 255;
        if (z2) {
            j5 &= ~f9331d[i - 1];
        }
        for (int i10 = 1; i10 < i; i10++) {
            j5 = (j5 << 8) | (((long) bArr[i10]) & 255);
        }
        return j5;
    }

    public final long b(p pVar, boolean z2, boolean z10, int i) {
        int i10;
        int i11 = this.f9333b;
        byte[] bArr = this.f9332a;
        if (i11 == 0) {
            if (!pVar.f(bArr, 0, 1, z2)) {
                return -1L;
            }
            int i12 = bArr[0] & 255;
            int i13 = 0;
            while (true) {
                if (i13 >= 8) {
                    i10 = -1;
                    break;
                }
                if ((f9331d[i13] & ((long) i12)) != 0) {
                    i10 = i13 + 1;
                    break;
                }
                i13++;
            }
            this.f9334c = i10;
            if (i10 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f9333b = 1;
        }
        int i14 = this.f9334c;
        if (i14 > i) {
            this.f9333b = 0;
            return -2L;
        }
        if (i14 != 1) {
            pVar.readFully(bArr, 1, i14 - 1);
        }
        this.f9333b = 0;
        return a(this.f9334c, z10, bArr);
    }
}
