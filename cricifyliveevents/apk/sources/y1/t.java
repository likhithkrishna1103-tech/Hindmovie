package y1;

import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import ua.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f14607d = {'\r', '\n'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f14608e = {'\n'};
    public static final m0 f = m0.j(5, StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f14609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14611c;

    public t() {
        this.f14609a = a0.f14553c;
    }

    public static int b(int i, int i10, int i11, int i12) {
        byte b8 = (byte) i11;
        return com.bumptech.glide.d.p((byte) 0, com.bumptech.glide.f.g(((i & 7) << 2) | ((i10 & 48) >> 4)), com.bumptech.glide.f.g(((((byte) i10) & 15) << 4) | ((b8 & 60) >> 2)), com.bumptech.glide.f.g(((b8 & 3) << 6) | (((byte) i12) & 63)));
    }

    public static int d(Charset charset) {
        d.a("Unsupported charset: " + charset, f.contains(charset));
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    public static boolean e(byte b8) {
        return (b8 & 192) == 128;
    }

    public final int A() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        int i11 = (bArr[i] & 255) << 16;
        int i12 = i + 2;
        this.f14610b = i12;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        this.f14610b = i + 3;
        return (bArr[i12] & 255) | i13;
    }

    public final int B() {
        int iJ = j();
        if (iJ >= 0) {
            return iJ;
        }
        throw new IllegalStateException(l0.e.g(iJ, "Top bit not zero: "));
    }

    public final long C() {
        long jR = r();
        if (jR >= 0) {
            return jR;
        }
        throw new IllegalStateException("Top bit not zero: " + jR);
    }

    public final int D() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        int i11 = (bArr[i] & 255) << 8;
        this.f14610b = i + 2;
        return (bArr[i10] & 255) | i11;
    }

    public final long E() {
        int i;
        int i10;
        long j4 = this.f14609a[this.f14610b];
        int i11 = 7;
        while (true) {
            if (i11 < 0) {
                break;
            }
            int i12 = 1 << i11;
            if ((((long) i12) & j4) != 0) {
                i11--;
            } else if (i11 < 6) {
                j4 &= (long) (i12 - 1);
                i10 = 7 - i11;
            } else if (i11 == 7) {
                i10 = 1;
            }
        }
        i10 = 0;
        if (i10 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j4);
        }
        for (i = 1; i < i10; i++) {
            byte b8 = this.f14609a[this.f14610b + i];
            if ((b8 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j4);
            }
            j4 = (j4 << 6) | ((long) (b8 & 63));
        }
        this.f14610b += i10;
        return j4;
    }

    public final Charset F() {
        if (a() >= 3) {
            byte[] bArr = this.f14609a;
            int i = this.f14610b;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.f14610b = i + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f14609a;
        int i10 = this.f14610b;
        byte b8 = bArr2[i10];
        if (b8 == -2 && bArr2[i10 + 1] == -1) {
            this.f14610b = i10 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b8 != -1 || bArr2[i10 + 1] != -2) {
            return null;
        }
        this.f14610b = i10 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public final void G(int i) {
        byte[] bArr = this.f14609a;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        H(i, bArr);
    }

    public final void H(int i, byte[] bArr) {
        this.f14609a = bArr;
        this.f14611c = i;
        this.f14610b = 0;
    }

    public final void I(int i) {
        d.b(i >= 0 && i <= this.f14609a.length);
        this.f14611c = i;
    }

    public final void J(int i) {
        d.b(i >= 0 && i <= this.f14611c);
        this.f14610b = i;
    }

    public final void K(int i) {
        J(this.f14610b + i);
    }

    public final int a() {
        return Math.max(this.f14611c - this.f14610b, 0);
    }

    public final void c(int i) {
        byte[] bArr = this.f14609a;
        if (i > bArr.length) {
            this.f14609a = Arrays.copyOf(bArr, i);
        }
    }

    public final char f(int i, ByteOrder byteOrder) {
        byte b8;
        byte b10;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f14609a;
            int i10 = this.f14610b + i;
            b8 = bArr[i10];
            b10 = bArr[i10 + 1];
        } else {
            byte[] bArr2 = this.f14609a;
            int i11 = this.f14610b + i;
            b8 = bArr2[i11 + 1];
            b10 = bArr2[i11];
        }
        return (char) ((b8 << 8) | (b10 & 255));
    }

    public final int g(Charset charset) {
        int codePoint;
        int iB;
        d.a("Unsupported charset: " + charset, f.contains(charset));
        if (a() < d(charset)) {
            throw new IndexOutOfBoundsException("position=" + this.f14610b + ", limit=" + this.f14611c);
        }
        int i = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b8 = this.f14609a[this.f14610b];
            if ((b8 & 128) == 0) {
                codePoint = b8 & 255;
                return (codePoint << 8) | i;
            }
            return 0;
        }
        if (charset.equals(StandardCharsets.UTF_8)) {
            byte b10 = this.f14609a[this.f14610b];
            int i10 = (b10 & 128) == 0 ? 1 : ((b10 & 224) == 192 && a() >= 2 && e(this.f14609a[this.f14610b + 1])) ? 2 : ((this.f14609a[this.f14610b] & 240) == 224 && a() >= 3 && e(this.f14609a[this.f14610b + 1]) && e(this.f14609a[this.f14610b + 2])) ? 3 : ((this.f14609a[this.f14610b] & 248) == 240 && a() >= 4 && e(this.f14609a[this.f14610b + 1]) && e(this.f14609a[this.f14610b + 2]) && e(this.f14609a[this.f14610b + 3])) ? 4 : 0;
            if (i10 == 1) {
                iB = this.f14609a[this.f14610b] & 255;
            } else if (i10 == 2) {
                byte[] bArr = this.f14609a;
                int i11 = this.f14610b;
                iB = b(0, 0, bArr[i11], bArr[i11 + 1]);
            } else {
                if (i10 != 3) {
                    if (i10 == 4) {
                        byte[] bArr2 = this.f14609a;
                        int i12 = this.f14610b;
                        iB = b(bArr2[i12], bArr2[i12 + 1], bArr2[i12 + 2], bArr2[i12 + 3]);
                    }
                    return 0;
                }
                byte[] bArr3 = this.f14609a;
                int i13 = this.f14610b;
                iB = b(0, bArr3[i13] & 15, bArr3[i13 + 1], bArr3[i13 + 2]);
            }
            i = i10;
            codePoint = iB;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char cF = f(0, byteOrder);
            if (!Character.isHighSurrogate(cF) || a() < 4) {
                codePoint = cF;
                i = 2;
            } else {
                codePoint = Character.toCodePoint(cF, f(2, byteOrder));
                i = 4;
            }
        }
        return (codePoint << 8) | i;
    }

    public final void h(byte[] bArr, int i, int i10) {
        System.arraycopy(this.f14609a, this.f14610b, bArr, i, i10);
        this.f14610b += i10;
    }

    public final char i(Charset charset, char[] cArr) {
        int iG;
        if (a() >= d(charset) && (iG = g(charset)) != 0) {
            long j4 = iG >>> 8;
            com.bumptech.glide.d.e(j4, "out of range: %s", (j4 >> 32) == 0);
            int i = (int) j4;
            if (!Character.isSupplementaryCodePoint(i)) {
                long j7 = i;
                char c9 = (char) j7;
                com.bumptech.glide.d.e(j7, "Out of range: %s", ((long) c9) == j7);
                for (char c10 : cArr) {
                    if (c10 == c9) {
                        this.f14610b = com.bumptech.glide.d.l(iG & 255) + this.f14610b;
                        return c9;
                    }
                }
            }
        }
        return (char) 0;
    }

    public final int j() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        int i11 = (bArr[i] & 255) << 24;
        int i12 = i + 2;
        this.f14610b = i12;
        int i13 = ((bArr[i10] & 255) << 16) | i11;
        int i14 = i + 3;
        this.f14610b = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        this.f14610b = i + 4;
        return (bArr[i14] & 255) | i15;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(java.nio.charset.Charset r5) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.t.k(java.nio.charset.Charset):java.lang.String");
    }

    public final int l() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        int i11 = bArr[i] & 255;
        int i12 = i + 2;
        this.f14610b = i12;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        int i14 = i + 3;
        this.f14610b = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        this.f14610b = i + 4;
        return ((bArr[i14] & 255) << 24) | i15;
    }

    public final long m() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        long j4 = ((long) bArr[i]) & 255;
        int i11 = i + 2;
        this.f14610b = i11;
        long j7 = j4 | ((((long) bArr[i10]) & 255) << 8);
        int i12 = i + 3;
        this.f14610b = i12;
        long j10 = j7 | ((((long) bArr[i11]) & 255) << 16);
        int i13 = i + 4;
        this.f14610b = i13;
        long j11 = j10 | ((((long) bArr[i12]) & 255) << 24);
        int i14 = i + 5;
        this.f14610b = i14;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 32);
        int i15 = i + 6;
        this.f14610b = i15;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 40);
        int i16 = i + 7;
        this.f14610b = i16;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 48);
        this.f14610b = i + 8;
        return ((((long) bArr[i16]) & 255) << 56) | j14;
    }

    public final short n() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        int i11 = bArr[i] & 255;
        this.f14610b = i + 2;
        return (short) (((bArr[i10] & 255) << 8) | i11);
    }

    public final long o() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        long j4 = ((long) bArr[i]) & 255;
        int i11 = i + 2;
        this.f14610b = i11;
        long j7 = j4 | ((((long) bArr[i10]) & 255) << 8);
        int i12 = i + 3;
        this.f14610b = i12;
        long j10 = j7 | ((((long) bArr[i11]) & 255) << 16);
        this.f14610b = i + 4;
        return ((((long) bArr[i12]) & 255) << 24) | j10;
    }

    public final int p() {
        int iL = l();
        if (iL >= 0) {
            return iL;
        }
        throw new IllegalStateException(l0.e.g(iL, "Top bit not zero: "));
    }

    public final int q() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        int i11 = bArr[i] & 255;
        this.f14610b = i + 2;
        return ((bArr[i10] & 255) << 8) | i11;
    }

    public final long r() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        long j4 = (((long) bArr[i]) & 255) << 56;
        int i11 = i + 2;
        this.f14610b = i11;
        long j7 = j4 | ((((long) bArr[i10]) & 255) << 48);
        int i12 = i + 3;
        this.f14610b = i12;
        long j10 = j7 | ((((long) bArr[i11]) & 255) << 40);
        int i13 = i + 4;
        this.f14610b = i13;
        long j11 = j10 | ((((long) bArr[i12]) & 255) << 32);
        int i14 = i + 5;
        this.f14610b = i14;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 24);
        int i15 = i + 6;
        this.f14610b = i15;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 16);
        int i16 = i + 7;
        this.f14610b = i16;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 8);
        this.f14610b = i + 8;
        return (((long) bArr[i16]) & 255) | j14;
    }

    public final String s() {
        if (a() == 0) {
            return null;
        }
        int i = this.f14610b;
        while (i < this.f14611c && this.f14609a[i] != 0) {
            i++;
        }
        byte[] bArr = this.f14609a;
        int i10 = this.f14610b;
        int i11 = a0.f14551a;
        String str = new String(bArr, i10, i - i10, StandardCharsets.UTF_8);
        this.f14610b = i;
        if (i < this.f14611c) {
            this.f14610b = i + 1;
        }
        return str;
    }

    public final String t(int i) {
        if (i == 0) {
            return "";
        }
        int i10 = this.f14610b;
        int i11 = (i10 + i) - 1;
        int i12 = (i11 >= this.f14611c || this.f14609a[i11] != 0) ? i : i - 1;
        byte[] bArr = this.f14609a;
        int i13 = a0.f14551a;
        String str = new String(bArr, i10, i12, StandardCharsets.UTF_8);
        this.f14610b += i;
        return str;
    }

    public final short u() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        int i11 = (bArr[i] & 255) << 8;
        this.f14610b = i + 2;
        return (short) ((bArr[i10] & 255) | i11);
    }

    public final String v(int i, Charset charset) {
        String str = new String(this.f14609a, this.f14610b, i, charset);
        this.f14610b += i;
        return str;
    }

    public final int w() {
        return (x() << 21) | (x() << 14) | (x() << 7) | x();
    }

    public final int x() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        this.f14610b = i + 1;
        return bArr[i] & 255;
    }

    public final int y() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        int i11 = (bArr[i] & 255) << 8;
        this.f14610b = i + 2;
        int i12 = (bArr[i10] & 255) | i11;
        this.f14610b = i + 4;
        return i12;
    }

    public final long z() {
        byte[] bArr = this.f14609a;
        int i = this.f14610b;
        int i10 = i + 1;
        this.f14610b = i10;
        long j4 = (((long) bArr[i]) & 255) << 24;
        int i11 = i + 2;
        this.f14610b = i11;
        long j7 = j4 | ((((long) bArr[i10]) & 255) << 16);
        int i12 = i + 3;
        this.f14610b = i12;
        long j10 = j7 | ((((long) bArr[i11]) & 255) << 8);
        this.f14610b = i + 4;
        return (((long) bArr[i12]) & 255) | j10;
    }

    public t(int i) {
        this.f14609a = new byte[i];
        this.f14611c = i;
    }

    public t(byte[] bArr) {
        this.f14609a = bArr;
        this.f14611c = bArr.length;
    }

    public t(int i, byte[] bArr) {
        this.f14609a = bArr;
        this.f14611c = i;
    }
}
