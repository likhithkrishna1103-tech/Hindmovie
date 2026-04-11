package androidx.datastore.preferences.protobuf;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f1051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileInputStream f1052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f1053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1054e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1056h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1057j = Integer.MAX_VALUE;

    public h(FileInputStream fileInputStream) {
        Charset charset = z.f1147a;
        this.f1052c = fileInputStream;
        this.f1053d = new byte[4096];
        this.f1054e = 0;
        this.f1055g = 0;
        this.i = 0;
    }

    public final int A() {
        return s();
    }

    public final long B() {
        return t();
    }

    public final void C() {
        int i = this.f1054e + this.f;
        this.f1054e = i;
        int i10 = this.i + i;
        int i11 = this.f1057j;
        if (i10 <= i11) {
            this.f = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f = i12;
        this.f1054e = i - i12;
    }

    public final void D(int i) {
        if (G(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.i) - this.f1055g) {
            throw b0.f();
        }
        throw new b0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final boolean E(int i) throws b0 {
        int iZ;
        int i10 = i & 7;
        int i11 = 0;
        if (i10 == 0) {
            int i12 = this.f1054e - this.f1055g;
            byte[] bArr = this.f1053d;
            if (i12 >= 10) {
                while (i11 < 10) {
                    int i13 = this.f1055g;
                    this.f1055g = i13 + 1;
                    if (bArr[i13] < 0) {
                        i11++;
                    }
                }
                throw b0.c();
            }
            while (i11 < 10) {
                if (this.f1055g == this.f1054e) {
                    D(1);
                }
                int i14 = this.f1055g;
                this.f1055g = i14 + 1;
                if (bArr[i14] < 0) {
                    i11++;
                }
            }
            throw b0.c();
            return true;
        }
        if (i10 == 1) {
            F(8);
            return true;
        }
        if (i10 == 2) {
            F(s());
            return true;
        }
        if (i10 != 3) {
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw b0.b();
            }
            F(4);
            return true;
        }
        do {
            iZ = z();
            if (iZ == 0) {
                break;
            }
        } while (E(iZ));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final void F(int i) throws b0 {
        int i10 = this.f1054e;
        int i11 = this.f1055g;
        int i12 = i10 - i11;
        if (i <= i12 && i >= 0) {
            this.f1055g = i11 + i;
            return;
        }
        FileInputStream fileInputStream = this.f1052c;
        if (i < 0) {
            throw b0.d();
        }
        int i13 = this.i;
        int i14 = i13 + i11;
        int i15 = i14 + i;
        int i16 = this.f1057j;
        if (i15 > i16) {
            F((i16 - i13) - i11);
            throw b0.f();
        }
        this.i = i14;
        this.f1054e = 0;
        this.f1055g = 0;
        while (i12 < i) {
            long j5 = i - i12;
            try {
                long jSkip = fileInputStream.skip(j5);
                if (jSkip < 0 || jSkip > j5) {
                    throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                }
                if (jSkip == 0) {
                    break;
                } else {
                    i12 += (int) jSkip;
                }
            } finally {
                this.i += i12;
                C();
            }
        }
        if (i12 >= i) {
            return;
        }
        int i17 = this.f1054e;
        int i18 = i17 - this.f1055g;
        this.f1055g = i17;
        D(1);
        while (true) {
            int i19 = i - i18;
            int i20 = this.f1054e;
            if (i19 <= i20) {
                this.f1055g = i19;
                return;
            } else {
                i18 += i20;
                this.f1055g = i20;
                D(1);
            }
        }
    }

    public final boolean G(int i) throws IOException {
        int i10 = this.f1055g;
        int i11 = i10 + i;
        int i12 = this.f1054e;
        if (i11 <= i12) {
            throw new IllegalStateException(e6.j.j(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i13 = this.i;
        if (i <= (Integer.MAX_VALUE - i13) - i10 && i13 + i10 + i <= this.f1057j) {
            byte[] bArr = this.f1053d;
            if (i10 > 0) {
                if (i12 > i10) {
                    System.arraycopy(bArr, i10, bArr, 0, i12 - i10);
                }
                this.i += i10;
                this.f1054e -= i10;
                this.f1055g = 0;
            }
            int i14 = this.f1054e;
            int iMin = Math.min(bArr.length - i14, (Integer.MAX_VALUE - this.i) - i14);
            FileInputStream fileInputStream = this.f1052c;
            int i15 = fileInputStream.read(bArr, i14, iMin);
            if (i15 == 0 || i15 < -1 || i15 > bArr.length) {
                throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + i15 + "\nThe InputStream implementation is buggy.");
            }
            if (i15 > 0) {
                this.f1054e += i15;
                C();
                if (this.f1054e >= i) {
                    return true;
                }
                return G(i);
            }
        }
        return false;
    }

    public final void a(int i) {
        if (this.f1056h != i) {
            throw new b0("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final int b() {
        return this.i + this.f1055g;
    }

    public final boolean c() {
        return this.f1055g == this.f1054e && !G(1);
    }

    public final void d(int i) {
        this.f1057j = i;
        C();
    }

    public final int e(int i) {
        if (i < 0) {
            throw b0.d();
        }
        int i10 = this.i + this.f1055g + i;
        int i11 = this.f1057j;
        if (i10 > i11) {
            throw b0.f();
        }
        this.f1057j = i10;
        C();
        return i11;
    }

    public final boolean f() {
        return t() != 0;
    }

    public final double g() {
        return Double.longBitsToDouble(r());
    }

    public final int h() {
        return s();
    }

    public final int i() {
        return q();
    }

    public final long j() {
        return r();
    }

    public final float k() {
        return Float.intBitsToFloat(q());
    }

    public final int l() {
        return s();
    }

    public final long m() {
        return t();
    }

    public final byte[] n(int i) {
        byte[] bArrO = o(i);
        if (bArrO != null) {
            return bArrO;
        }
        int i10 = this.f1055g;
        int i11 = this.f1054e;
        int length = i11 - i10;
        this.i += i11;
        this.f1055g = 0;
        this.f1054e = 0;
        ArrayList arrayListP = p(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f1053d, i10, bArr, 0, length);
        int size = arrayListP.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayListP.get(i12);
            i12++;
            byte[] bArr2 = (byte[]) obj;
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] o(int i) {
        if (i == 0) {
            return z.f1148b;
        }
        if (i < 0) {
            throw b0.d();
        }
        int i10 = this.i;
        int i11 = this.f1055g;
        int i12 = i10 + i11 + i;
        if (i12 - Integer.MAX_VALUE > 0) {
            throw new b0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i13 = this.f1057j;
        if (i12 > i13) {
            F((i13 - i10) - i11);
            throw b0.f();
        }
        int i14 = this.f1054e - i11;
        int i15 = i - i14;
        FileInputStream fileInputStream = this.f1052c;
        if (i15 >= 4096 && i15 > fileInputStream.available()) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f1053d, this.f1055g, bArr, 0, i14);
        this.i += this.f1054e;
        this.f1055g = 0;
        this.f1054e = 0;
        while (i14 < i) {
            int i16 = fileInputStream.read(bArr, i14, i - i14);
            if (i16 == -1) {
                throw b0.f();
            }
            this.i += i16;
            i14 += i16;
        }
        return bArr;
    }

    public final ArrayList p(int i) {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i10 = 0;
            while (i10 < iMin) {
                int i11 = this.f1052c.read(bArr, i10, iMin - i10);
                if (i11 == -1) {
                    throw b0.f();
                }
                this.i += i11;
                i10 += i11;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int q() {
        int i = this.f1055g;
        if (this.f1054e - i < 4) {
            D(4);
            i = this.f1055g;
        }
        this.f1055g = i + 4;
        byte[] bArr = this.f1053d;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long r() {
        int i = this.f1055g;
        if (this.f1054e - i < 8) {
            D(8);
            i = this.f1055g;
        }
        this.f1055g = i + 8;
        byte[] bArr = this.f1053d;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int s() {
        int i;
        int i10 = this.f1055g;
        int i11 = this.f1054e;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f1053d;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f1055g = i12;
                return b10;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                int i14 = (bArr[i12] << 7) ^ b10;
                if (i14 < 0) {
                    i = i14 ^ (-128);
                } else {
                    int i15 = i10 + 3;
                    int i16 = (bArr[i13] << 14) ^ i14;
                    if (i16 >= 0) {
                        i = i16 ^ 16256;
                    } else {
                        int i17 = i10 + 4;
                        int i18 = i16 ^ (bArr[i15] << 21);
                        if (i18 < 0) {
                            i = (-2080896) ^ i18;
                        } else {
                            i15 = i10 + 5;
                            byte b11 = bArr[i17];
                            int i19 = (i18 ^ (b11 << 28)) ^ 266354560;
                            if (b11 < 0) {
                                i17 = i10 + 6;
                                if (bArr[i15] < 0) {
                                    i15 = i10 + 7;
                                    if (bArr[i17] < 0) {
                                        i17 = i10 + 8;
                                        if (bArr[i15] < 0) {
                                            i15 = i10 + 9;
                                            if (bArr[i17] < 0) {
                                                int i20 = i10 + 10;
                                                if (bArr[i15] >= 0) {
                                                    i13 = i20;
                                                    i = i19;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i19;
                            }
                            i = i19;
                        }
                        i13 = i17;
                    }
                    i13 = i15;
                }
                this.f1055g = i13;
                return i;
            }
        }
        return (int) u();
    }

    public final long t() {
        long j5;
        long j8;
        long j10;
        long j11;
        int i = this.f1055g;
        int i10 = this.f1054e;
        if (i10 != i) {
            int i11 = i + 1;
            byte[] bArr = this.f1053d;
            byte b10 = bArr[i];
            if (b10 >= 0) {
                this.f1055g = i11;
                return b10;
            }
            if (i10 - i11 >= 9) {
                int i12 = i + 2;
                int i13 = (bArr[i11] << 7) ^ b10;
                if (i13 < 0) {
                    j5 = i13 ^ (-128);
                } else {
                    int i14 = i + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        j5 = i15 ^ 16256;
                        i12 = i14;
                    } else {
                        int i16 = i + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        if (i17 < 0) {
                            j11 = (-2080896) ^ i17;
                        } else {
                            long j12 = i17;
                            i12 = i + 5;
                            long j13 = j12 ^ (((long) bArr[i16]) << 28);
                            if (j13 >= 0) {
                                j10 = 266354560;
                            } else {
                                i16 = i + 6;
                                long j14 = j13 ^ (((long) bArr[i12]) << 35);
                                if (j14 < 0) {
                                    j8 = -34093383808L;
                                } else {
                                    i12 = i + 7;
                                    j13 = j14 ^ (((long) bArr[i16]) << 42);
                                    if (j13 >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        i16 = i + 8;
                                        j14 = j13 ^ (((long) bArr[i12]) << 49);
                                        if (j14 < 0) {
                                            j8 = -558586000294016L;
                                        } else {
                                            i12 = i + 9;
                                            long j15 = (j14 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                            if (j15 < 0) {
                                                int i18 = i + 10;
                                                if (bArr[i12] >= 0) {
                                                    i12 = i18;
                                                }
                                            }
                                            j5 = j15;
                                        }
                                    }
                                }
                                j11 = j8 ^ j14;
                            }
                            j5 = j10 ^ j13;
                        }
                        i12 = i16;
                        j5 = j11;
                    }
                }
                this.f1055g = i12;
                return j5;
            }
        }
        return u();
    }

    public final long u() throws b0 {
        long j5 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.f1055g == this.f1054e) {
                D(1);
            }
            int i10 = this.f1055g;
            this.f1055g = i10 + 1;
            byte b10 = this.f1053d[i10];
            j5 |= ((long) (b10 & 127)) << i;
            if ((b10 & 128) == 0) {
                return j5;
            }
        }
        throw b0.c();
    }

    public final int v() {
        return q();
    }

    public final long w() {
        return r();
    }

    public final int x() {
        int iS = s();
        return (-(iS & 1)) ^ (iS >>> 1);
    }

    public final long y() {
        long jT = t();
        return (-(jT & 1)) ^ (jT >>> 1);
    }

    public final int z() {
        if (c()) {
            this.f1056h = 0;
            return 0;
        }
        int iS = s();
        this.f1056h = iS;
        if ((iS >>> 3) != 0) {
            return iS;
        }
        throw new b0("Protocol message contained an invalid tag (zero).");
    }
}
