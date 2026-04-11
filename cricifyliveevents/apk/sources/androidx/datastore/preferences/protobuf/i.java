package androidx.datastore.preferences.protobuf;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FileInputStream f722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f724e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f726h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f727j = Integer.MAX_VALUE;

    public i(FileInputStream fileInputStream) {
        Charset charset = x.f808a;
        this.f722c = fileInputStream;
        this.f723d = new byte[4096];
        this.f724e = 0;
        this.f725g = 0;
        this.i = 0;
    }

    public final byte[] A(int i) throws IOException {
        if (i == 0) {
            return x.f809b;
        }
        if (i < 0) {
            throw z.d();
        }
        int i10 = this.i;
        int i11 = this.f725g;
        int i12 = i10 + i11 + i;
        if (i12 - Integer.MAX_VALUE > 0) {
            throw new z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i13 = this.f727j;
        if (i12 > i13) {
            J((i13 - i10) - i11);
            throw z.e();
        }
        int i14 = this.f724e - i11;
        int i15 = i - i14;
        FileInputStream fileInputStream = this.f722c;
        if (i15 >= 4096) {
            try {
                if (i15 > fileInputStream.available()) {
                    return null;
                }
            } catch (z e9) {
                e9.f818v = true;
                throw e9;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f723d, this.f725g, bArr, 0, i14);
        this.i += this.f724e;
        this.f725g = 0;
        this.f724e = 0;
        while (i14 < i) {
            try {
                int i16 = fileInputStream.read(bArr, i14, i - i14);
                if (i16 == -1) {
                    throw z.e();
                }
                this.i += i16;
                i14 += i16;
            } catch (z e10) {
                e10.f818v = true;
                throw e10;
            }
        }
        return bArr;
    }

    public final ArrayList B(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i10 = 0;
            while (i10 < iMin) {
                int i11 = this.f722c.read(bArr, i10, iMin - i10);
                if (i11 == -1) {
                    throw z.e();
                }
                this.i += i11;
                i10 += i11;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int C() throws z {
        int i = this.f725g;
        if (this.f724e - i < 4) {
            I(4);
            i = this.f725g;
        }
        this.f725g = i + 4;
        byte[] bArr = this.f723d;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long D() throws z {
        int i = this.f725g;
        if (this.f724e - i < 8) {
            I(8);
            i = this.f725g;
        }
        this.f725g = i + 8;
        byte[] bArr = this.f723d;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int E() {
        int i;
        int i10 = this.f725g;
        int i11 = this.f724e;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f723d;
            byte b8 = bArr[i10];
            if (b8 >= 0) {
                this.f725g = i12;
                return b8;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                int i14 = (bArr[i12] << 7) ^ b8;
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
                            byte b10 = bArr[i17];
                            int i19 = (i18 ^ (b10 << 28)) ^ 266354560;
                            if (b10 < 0) {
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
                this.f725g = i13;
                return i;
            }
        }
        return (int) G();
    }

    public final long F() {
        long j4;
        long j7;
        long j10;
        long j11;
        int i = this.f725g;
        int i10 = this.f724e;
        if (i10 != i) {
            int i11 = i + 1;
            byte[] bArr = this.f723d;
            byte b8 = bArr[i];
            if (b8 >= 0) {
                this.f725g = i11;
                return b8;
            }
            if (i10 - i11 >= 9) {
                int i12 = i + 2;
                int i13 = (bArr[i11] << 7) ^ b8;
                if (i13 < 0) {
                    j4 = i13 ^ (-128);
                } else {
                    int i14 = i + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        j4 = i15 ^ 16256;
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
                                    j7 = -34093383808L;
                                } else {
                                    i12 = i + 7;
                                    j13 = j14 ^ (((long) bArr[i16]) << 42);
                                    if (j13 >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        i16 = i + 8;
                                        j14 = j13 ^ (((long) bArr[i12]) << 49);
                                        if (j14 < 0) {
                                            j7 = -558586000294016L;
                                        } else {
                                            i12 = i + 9;
                                            long j15 = (j14 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                            if (j15 < 0) {
                                                int i18 = i + 10;
                                                if (bArr[i12] >= 0) {
                                                    i12 = i18;
                                                }
                                            }
                                            j4 = j15;
                                        }
                                    }
                                }
                                j11 = j7 ^ j14;
                            }
                            j4 = j10 ^ j13;
                        }
                        i12 = i16;
                        j4 = j11;
                    }
                }
                this.f725g = i12;
                return j4;
            }
        }
        return G();
    }

    public final long G() throws z {
        long j4 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.f725g == this.f724e) {
                I(1);
            }
            int i10 = this.f725g;
            this.f725g = i10 + 1;
            byte b8 = this.f723d[i10];
            j4 |= ((long) (b8 & 127)) << i;
            if ((b8 & 128) == 0) {
                return j4;
            }
        }
        throw z.c();
    }

    public final void H() {
        int i = this.f724e + this.f;
        this.f724e = i;
        int i10 = this.i + i;
        int i11 = this.f727j;
        if (i10 <= i11) {
            this.f = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f = i12;
        this.f724e = i - i12;
    }

    public final void I(int i) throws z {
        if (K(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.i) - this.f725g) {
            throw z.e();
        }
        throw new z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void J(int i) throws z {
        int i10 = this.f724e;
        int i11 = this.f725g;
        int i12 = i10 - i11;
        if (i <= i12 && i >= 0) {
            this.f725g = i11 + i;
            return;
        }
        FileInputStream fileInputStream = this.f722c;
        if (i < 0) {
            throw z.d();
        }
        int i13 = this.i;
        int i14 = i13 + i11;
        int i15 = i14 + i;
        int i16 = this.f727j;
        if (i15 > i16) {
            J((i16 - i13) - i11);
            throw z.e();
        }
        this.i = i14;
        this.f724e = 0;
        this.f725g = 0;
        while (i12 < i) {
            long j4 = i - i12;
            try {
                try {
                    long jSkip = fileInputStream.skip(j4);
                    if (jSkip < 0 || jSkip > j4) {
                        throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i12 += (int) jSkip;
                    }
                } catch (z e9) {
                    e9.f818v = true;
                    throw e9;
                }
            } catch (Throwable th) {
                this.i += i12;
                H();
                throw th;
            }
        }
        this.i += i12;
        H();
        if (i12 >= i) {
            return;
        }
        int i17 = this.f724e;
        int i18 = i17 - this.f725g;
        this.f725g = i17;
        I(1);
        while (true) {
            int i19 = i - i18;
            int i20 = this.f724e;
            if (i19 <= i20) {
                this.f725g = i19;
                return;
            } else {
                i18 += i20;
                this.f725g = i20;
                I(1);
            }
        }
    }

    public final boolean K(int i) throws IOException {
        FileInputStream fileInputStream = this.f722c;
        int i10 = this.f725g;
        int i11 = i10 + i;
        int i12 = this.f724e;
        if (i11 <= i12) {
            throw new IllegalStateException(l0.e.h(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i13 = this.i;
        if (i <= (Integer.MAX_VALUE - i13) - i10 && i13 + i10 + i <= this.f727j) {
            byte[] bArr = this.f723d;
            if (i10 > 0) {
                if (i12 > i10) {
                    System.arraycopy(bArr, i10, bArr, 0, i12 - i10);
                }
                this.i += i10;
                this.f724e -= i10;
                this.f725g = 0;
            }
            int i14 = this.f724e;
            try {
                int i15 = fileInputStream.read(bArr, i14, Math.min(bArr.length - i14, (Integer.MAX_VALUE - this.i) - i14));
                if (i15 == 0 || i15 < -1 || i15 > bArr.length) {
                    throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + i15 + "\nThe InputStream implementation is buggy.");
                }
                if (i15 > 0) {
                    this.f724e += i15;
                    H();
                    if (this.f724e >= i) {
                        return true;
                    }
                    return K(i);
                }
            } catch (z e9) {
                e9.f818v = true;
                throw e9;
            }
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void a(int i) throws z {
        if (this.f726h != i) {
            throw new z("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int b() {
        return this.i + this.f725g;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean c() {
        return this.f725g == this.f724e && !K(1);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void d(int i) {
        this.f727j = i;
        H();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int e(int i) throws z {
        if (i < 0) {
            throw z.d();
        }
        int i10 = this.i + this.f725g + i;
        if (i10 < 0) {
            throw new z("Failed to parse the message.");
        }
        int i11 = this.f727j;
        if (i10 > i11) {
            throw z.e();
        }
        this.f727j = i10;
        H();
        return i11;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean f() {
        return F() != 0;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final g g() throws IOException {
        int iE = E();
        int i = this.f724e;
        int i10 = this.f725g;
        int i11 = i - i10;
        byte[] bArr = this.f723d;
        if (iE <= i11 && iE > 0) {
            g gVarC = g.c(bArr, i10, iE);
            this.f725g += iE;
            return gVarC;
        }
        if (iE == 0) {
            return g.f703x;
        }
        if (iE < 0) {
            throw z.d();
        }
        byte[] bArrA = A(iE);
        if (bArrA != null) {
            return g.c(bArrA, 0, bArrA.length);
        }
        int i12 = this.f725g;
        int i13 = this.f724e;
        int length = i13 - i12;
        this.i += i13;
        this.f725g = 0;
        this.f724e = 0;
        ArrayList arrayListB = B(iE - length);
        byte[] bArr2 = new byte[iE];
        System.arraycopy(bArr, i12, bArr2, 0, length);
        int size = arrayListB.size();
        int i14 = 0;
        while (i14 < size) {
            Object obj = arrayListB.get(i14);
            i14++;
            byte[] bArr3 = (byte[]) obj;
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        g gVar = g.f703x;
        return new g(bArr2);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final double h() {
        return Double.longBitsToDouble(D());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int i() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int j() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long k() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final float l() {
        return Float.intBitsToFloat(C());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int m() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long n() {
        return F();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int o() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long p() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int q() {
        int iE = E();
        return (-(iE & 1)) ^ (iE >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long r() {
        long jF = F();
        return (-(jF & 1)) ^ (jF >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String s() throws z {
        int iE = E();
        byte[] bArr = this.f723d;
        if (iE > 0) {
            int i = this.f724e;
            int i10 = this.f725g;
            if (iE <= i - i10) {
                String str = new String(bArr, i10, iE, x.f808a);
                this.f725g += iE;
                return str;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE < 0) {
            throw z.d();
        }
        if (iE > this.f724e) {
            return new String(z(iE), x.f808a);
        }
        I(iE);
        String str2 = new String(bArr, this.f725g, iE, x.f808a);
        this.f725g += iE;
        return str2;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String t() throws IOException {
        int iE = E();
        int i = this.f725g;
        int i10 = this.f724e;
        int i11 = i10 - i;
        byte[] bArrZ = this.f723d;
        if (iE <= i11 && iE > 0) {
            this.f725g = i + iE;
        } else {
            if (iE == 0) {
                return "";
            }
            if (iE < 0) {
                throw z.d();
            }
            i = 0;
            if (iE <= i10) {
                I(iE);
                this.f725g = iE;
            } else {
                bArrZ = z(iE);
            }
        }
        return k1.f737a.f(bArrZ, i, iE);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int u() throws z {
        if (c()) {
            this.f726h = 0;
            return 0;
        }
        int iE = E();
        this.f726h = iE;
        if ((iE >>> 3) != 0) {
            return iE;
        }
        throw new z("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int v() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long w() {
        return F();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean x(int i) throws z {
        int i10 = i & 7;
        int i11 = 0;
        if (i10 != 0) {
            if (i10 == 1) {
                J(8);
                return true;
            }
            if (i10 == 2) {
                J(E());
                return true;
            }
            if (i10 == 3) {
                y();
                a(((i >>> 3) << 3) | 4);
                return true;
            }
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw z.b();
            }
            J(4);
            return true;
        }
        int i12 = this.f724e - this.f725g;
        byte[] bArr = this.f723d;
        if (i12 >= 10) {
            while (i11 < 10) {
                int i13 = this.f725g;
                this.f725g = i13 + 1;
                if (bArr[i13] < 0) {
                    i11++;
                }
            }
            throw z.c();
        }
        while (i11 < 10) {
            if (this.f725g == this.f724e) {
                I(1);
            }
            int i14 = this.f725g;
            this.f725g = i14 + 1;
            if (bArr[i14] < 0) {
                i11++;
            }
        }
        throw z.c();
        return true;
    }

    public final byte[] z(int i) throws IOException {
        byte[] bArrA = A(i);
        if (bArrA != null) {
            return bArrA;
        }
        int i10 = this.f725g;
        int i11 = this.f724e;
        int length = i11 - i10;
        this.i += i11;
        this.f725g = 0;
        this.f724e = 0;
        ArrayList arrayListB = B(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f723d, i10, bArr, 0, length);
        int size = arrayListB.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayListB.get(i12);
            i12++;
            byte[] bArr2 = (byte[]) obj;
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }
}
