package s1;

import aa.o0;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f11707d = {'\r', '\n'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f11708e = {'\n'};
    public static final o0 f = o0.n(5, StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f11709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11711c;

    public u() {
        this.f11709a = b0.f11649c;
    }

    public static int b(int i, int i10, int i11, int i12) {
        byte b10 = (byte) i11;
        return q1.c.A((byte) 0, z7.a.g(((i & 7) << 2) | ((i10 & 48) >> 4)), z7.a.g(((((byte) i10) & 15) << 4) | ((b10 & 60) >> 2)), z7.a.g(((b10 & 3) << 6) | (((byte) i12) & 63)));
    }

    public static int d(Charset charset) {
        d.a("Unsupported charset: " + charset, f.contains(charset));
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    public static boolean e(byte b10) {
        return (b10 & 192) == 128;
    }

    public final int A() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        int i11 = (bArr[i] & 255) << 16;
        int i12 = i + 2;
        this.f11710b = i12;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        this.f11710b = i + 3;
        return (bArr[i12] & 255) | i13;
    }

    public final int B() {
        int iJ = j();
        if (iJ >= 0) {
            return iJ;
        }
        throw new IllegalStateException(e6.j.l("Top bit not zero: ", iJ));
    }

    public final long C() {
        long jR = r();
        if (jR >= 0) {
            return jR;
        }
        throw new IllegalStateException("Top bit not zero: " + jR);
    }

    public final int D() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        int i11 = (bArr[i] & 255) << 8;
        this.f11710b = i + 2;
        return (bArr[i10] & 255) | i11;
    }

    public final long E() {
        int i;
        int i10;
        long j5 = this.f11709a[this.f11710b];
        int i11 = 7;
        while (true) {
            if (i11 < 0) {
                break;
            }
            int i12 = 1 << i11;
            if ((((long) i12) & j5) != 0) {
                i11--;
            } else if (i11 < 6) {
                j5 &= (long) (i12 - 1);
                i10 = 7 - i11;
            } else if (i11 == 7) {
                i10 = 1;
            }
        }
        i10 = 0;
        if (i10 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j5);
        }
        for (i = 1; i < i10; i++) {
            byte b10 = this.f11709a[this.f11710b + i];
            if ((b10 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j5);
            }
            j5 = (j5 << 6) | ((long) (b10 & 63));
        }
        this.f11710b += i10;
        return j5;
    }

    public final Charset F() {
        if (a() >= 3) {
            byte[] bArr = this.f11709a;
            int i = this.f11710b;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.f11710b = i + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f11709a;
        int i10 = this.f11710b;
        byte b10 = bArr2[i10];
        if (b10 == -2 && bArr2[i10 + 1] == -1) {
            this.f11710b = i10 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b10 != -1 || bArr2[i10 + 1] != -2) {
            return null;
        }
        this.f11710b = i10 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public final void G(int i) {
        byte[] bArr = this.f11709a;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        H(i, bArr);
    }

    public final void H(int i, byte[] bArr) {
        this.f11709a = bArr;
        this.f11711c = i;
        this.f11710b = 0;
    }

    public final void I(int i) {
        d.b(i >= 0 && i <= this.f11709a.length);
        this.f11711c = i;
    }

    public final void J(int i) {
        d.b(i >= 0 && i <= this.f11711c);
        this.f11710b = i;
    }

    public final void K(int i) {
        J(this.f11710b + i);
    }

    public final int a() {
        return Math.max(this.f11711c - this.f11710b, 0);
    }

    public final void c(int i) {
        byte[] bArr = this.f11709a;
        if (i > bArr.length) {
            this.f11709a = Arrays.copyOf(bArr, i);
        }
    }

    public final char f(int i, ByteOrder byteOrder) {
        byte b10;
        byte b11;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f11709a;
            int i10 = this.f11710b + i;
            b10 = bArr[i10];
            b11 = bArr[i10 + 1];
        } else {
            byte[] bArr2 = this.f11709a;
            int i11 = this.f11710b + i;
            b10 = bArr2[i11 + 1];
            b11 = bArr2[i11];
        }
        return (char) ((b10 << 8) | (b11 & 255));
    }

    public final int g(Charset charset) {
        int codePoint;
        int iB;
        d.a("Unsupported charset: " + charset, f.contains(charset));
        if (a() < d(charset)) {
            throw new IndexOutOfBoundsException("position=" + this.f11710b + ", limit=" + this.f11711c);
        }
        int i = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b10 = this.f11709a[this.f11710b];
            if ((b10 & 128) == 0) {
                codePoint = b10 & 255;
                return (codePoint << 8) | i;
            }
            return 0;
        }
        if (charset.equals(StandardCharsets.UTF_8)) {
            byte b11 = this.f11709a[this.f11710b];
            int i10 = (b11 & 128) == 0 ? 1 : ((b11 & 224) == 192 && a() >= 2 && e(this.f11709a[this.f11710b + 1])) ? 2 : ((this.f11709a[this.f11710b] & 240) == 224 && a() >= 3 && e(this.f11709a[this.f11710b + 1]) && e(this.f11709a[this.f11710b + 2])) ? 3 : ((this.f11709a[this.f11710b] & 248) == 240 && a() >= 4 && e(this.f11709a[this.f11710b + 1]) && e(this.f11709a[this.f11710b + 2]) && e(this.f11709a[this.f11710b + 3])) ? 4 : 0;
            if (i10 == 1) {
                iB = this.f11709a[this.f11710b] & 255;
            } else if (i10 == 2) {
                byte[] bArr = this.f11709a;
                int i11 = this.f11710b;
                iB = b(0, 0, bArr[i11], bArr[i11 + 1]);
            } else {
                if (i10 != 3) {
                    if (i10 == 4) {
                        byte[] bArr2 = this.f11709a;
                        int i12 = this.f11710b;
                        iB = b(bArr2[i12], bArr2[i12 + 1], bArr2[i12 + 2], bArr2[i12 + 3]);
                    }
                    return 0;
                }
                byte[] bArr3 = this.f11709a;
                int i13 = this.f11710b;
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
        System.arraycopy(this.f11709a, this.f11710b, bArr, i, i10);
        this.f11710b += i10;
    }

    public final char i(Charset charset, char[] cArr) {
        int iG;
        if (a() >= d(charset) && (iG = g(charset)) != 0) {
            long j5 = iG >>> 8;
            q1.c.f(j5, "out of range: %s", (j5 >> 32) == 0);
            int i = (int) j5;
            if (!Character.isSupplementaryCodePoint(i)) {
                long j8 = i;
                char c9 = (char) j8;
                q1.c.f(j8, "Out of range: %s", ((long) c9) == j8);
                for (char c10 : cArr) {
                    if (c10 == c9) {
                        this.f11710b = q1.c.n(iG & 255) + this.f11710b;
                        return c9;
                    }
                }
            }
        }
        return (char) 0;
    }

    public final int j() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        int i11 = (bArr[i] & 255) << 24;
        int i12 = i + 2;
        this.f11710b = i12;
        int i13 = ((bArr[i10] & 255) << 16) | i11;
        int i14 = i + 3;
        this.f11710b = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        this.f11710b = i + 4;
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
        throw new UnsupportedOperationException("Method not decompiled: s1.u.k(java.nio.charset.Charset):java.lang.String");
    }

    public final int l() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        int i11 = bArr[i] & 255;
        int i12 = i + 2;
        this.f11710b = i12;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        int i14 = i + 3;
        this.f11710b = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        this.f11710b = i + 4;
        return ((bArr[i14] & 255) << 24) | i15;
    }

    public final long m() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        long j5 = ((long) bArr[i]) & 255;
        int i11 = i + 2;
        this.f11710b = i11;
        long j8 = j5 | ((((long) bArr[i10]) & 255) << 8);
        int i12 = i + 3;
        this.f11710b = i12;
        long j10 = j8 | ((((long) bArr[i11]) & 255) << 16);
        int i13 = i + 4;
        this.f11710b = i13;
        long j11 = j10 | ((((long) bArr[i12]) & 255) << 24);
        int i14 = i + 5;
        this.f11710b = i14;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 32);
        int i15 = i + 6;
        this.f11710b = i15;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 40);
        int i16 = i + 7;
        this.f11710b = i16;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 48);
        this.f11710b = i + 8;
        return ((((long) bArr[i16]) & 255) << 56) | j14;
    }

    public final short n() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        int i11 = bArr[i] & 255;
        this.f11710b = i + 2;
        return (short) (((bArr[i10] & 255) << 8) | i11);
    }

    public final long o() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        long j5 = ((long) bArr[i]) & 255;
        int i11 = i + 2;
        this.f11710b = i11;
        long j8 = j5 | ((((long) bArr[i10]) & 255) << 8);
        int i12 = i + 3;
        this.f11710b = i12;
        long j10 = j8 | ((((long) bArr[i11]) & 255) << 16);
        this.f11710b = i + 4;
        return ((((long) bArr[i12]) & 255) << 24) | j10;
    }

    public final int p() {
        int iL = l();
        if (iL >= 0) {
            return iL;
        }
        throw new IllegalStateException(e6.j.l("Top bit not zero: ", iL));
    }

    public final int q() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        int i11 = bArr[i] & 255;
        this.f11710b = i + 2;
        return ((bArr[i10] & 255) << 8) | i11;
    }

    public final long r() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        long j5 = (((long) bArr[i]) & 255) << 56;
        int i11 = i + 2;
        this.f11710b = i11;
        long j8 = j5 | ((((long) bArr[i10]) & 255) << 48);
        int i12 = i + 3;
        this.f11710b = i12;
        long j10 = j8 | ((((long) bArr[i11]) & 255) << 40);
        int i13 = i + 4;
        this.f11710b = i13;
        long j11 = j10 | ((((long) bArr[i12]) & 255) << 32);
        int i14 = i + 5;
        this.f11710b = i14;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 24);
        int i15 = i + 6;
        this.f11710b = i15;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 16);
        int i16 = i + 7;
        this.f11710b = i16;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 8);
        this.f11710b = i + 8;
        return (((long) bArr[i16]) & 255) | j14;
    }

    public final String s() {
        if (a() == 0) {
            return null;
        }
        int i = this.f11710b;
        while (i < this.f11711c && this.f11709a[i] != 0) {
            i++;
        }
        byte[] bArr = this.f11709a;
        int i10 = this.f11710b;
        int i11 = b0.f11647a;
        String str = new String(bArr, i10, i - i10, StandardCharsets.UTF_8);
        this.f11710b = i;
        if (i < this.f11711c) {
            this.f11710b = i + 1;
        }
        return str;
    }

    public final String t(int i) {
        if (i == 0) {
            return "";
        }
        int i10 = this.f11710b;
        int i11 = (i10 + i) - 1;
        int i12 = (i11 >= this.f11711c || this.f11709a[i11] != 0) ? i : i - 1;
        byte[] bArr = this.f11709a;
        int i13 = b0.f11647a;
        String str = new String(bArr, i10, i12, StandardCharsets.UTF_8);
        this.f11710b += i;
        return str;
    }

    public final short u() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        int i11 = (bArr[i] & 255) << 8;
        this.f11710b = i + 2;
        return (short) ((bArr[i10] & 255) | i11);
    }

    public final String v(int i, Charset charset) {
        String str = new String(this.f11709a, this.f11710b, i, charset);
        this.f11710b += i;
        return str;
    }

    public final int w() {
        return (x() << 21) | (x() << 14) | (x() << 7) | x();
    }

    public final int x() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        this.f11710b = i + 1;
        return bArr[i] & 255;
    }

    public final int y() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        int i11 = (bArr[i] & 255) << 8;
        this.f11710b = i + 2;
        int i12 = (bArr[i10] & 255) | i11;
        this.f11710b = i + 4;
        return i12;
    }

    public final long z() {
        byte[] bArr = this.f11709a;
        int i = this.f11710b;
        int i10 = i + 1;
        this.f11710b = i10;
        long j5 = (((long) bArr[i]) & 255) << 24;
        int i11 = i + 2;
        this.f11710b = i11;
        long j8 = j5 | ((((long) bArr[i10]) & 255) << 16);
        int i12 = i + 3;
        this.f11710b = i12;
        long j10 = j8 | ((((long) bArr[i11]) & 255) << 8);
        this.f11710b = i + 4;
        return (((long) bArr[i12]) & 255) | j10;
    }

    public u(int i) {
        this.f11709a = new byte[i];
        this.f11711c = i;
    }

    public u(byte[] bArr) {
        this.f11709a = bArr;
        this.f11711c = bArr.length;
    }

    public u(int i, byte[] bArr) {
        this.f11709a = bArr;
        this.f11711c = i;
    }
}
