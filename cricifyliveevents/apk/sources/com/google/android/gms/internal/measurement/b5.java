package com.google.android.gms.internal.measurement;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b5 extends vf.g {
    public static final Logger i = Logger.getLogger(b5.class.getName());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f2327j = s6.f2618e;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w5 f2328e;
    public final byte[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2330h;

    public b5(int i10, byte[] bArr) {
        int length = bArr.length;
        if (((length - i10) | i10) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(q4.a.m(length, i10, "Array range is invalid. Buffer.length=", ", offset=0, length="));
        }
        this.f = bArr;
        this.f2330h = 0;
        this.f2329g = i10;
    }

    public static int e0(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    public static int f0(String str) {
        int length;
        try {
            length = u6.b(str);
        } catch (t6 unused) {
            length = str.getBytes(p5.f2570a).length;
        }
        return v0(length) + length;
    }

    public static int v0(int i10) {
        return (352 - (Integer.numberOfLeadingZeros(i10) * 9)) >>> 6;
    }

    public final void g0(int i10, int i11) throws a2.a {
        p0((i10 << 3) | i11);
    }

    public final void h0(int i10, int i11) throws a2.a {
        p0(i10 << 3);
        o0(i11);
    }

    public final void i0(int i10, int i11) throws a2.a {
        p0(i10 << 3);
        p0(i11);
    }

    public final void j0(int i10, int i11) throws a2.a {
        p0((i10 << 3) | 5);
        q0(i11);
    }

    public final void k0(int i10, long j4) throws a2.a {
        p0(i10 << 3);
        r0(j4);
    }

    public final void l0(int i10, long j4) throws a2.a {
        p0((i10 << 3) | 1);
        s0(j4);
    }

    public final void m0(a5 a5Var) throws a2.a {
        p0(a5Var.c());
        t0(a5Var.c(), a5Var.f2318w);
    }

    public final void n0(byte b8) throws a2.a {
        int i10 = this.f2330h;
        try {
            int i11 = i10 + 1;
            try {
                this.f[i10] = b8;
                this.f2330h = i11;
            } catch (IndexOutOfBoundsException e9) {
                e = e9;
                i10 = i11;
                throw new a2.a(i10, this.f2329g, 1, e);
            }
        } catch (IndexOutOfBoundsException e10) {
            e = e10;
        }
    }

    public final void o0(int i10) throws a2.a {
        if (i10 >= 0) {
            p0(i10);
        } else {
            r0(i10);
        }
    }

    public final void p0(int i10) throws a2.a {
        int i11;
        int i12 = this.f2330h;
        while (true) {
            int i13 = i10 & (-128);
            byte[] bArr = this.f;
            if (i13 == 0) {
                i11 = i12 + 1;
                bArr[i12] = (byte) i10;
                this.f2330h = i11;
                return;
            } else {
                i11 = i12 + 1;
                try {
                    bArr[i12] = (byte) (i10 | 128);
                    i10 >>>= 7;
                    i12 = i11;
                } catch (IndexOutOfBoundsException e9) {
                    throw new a2.a(i11, this.f2329g, 1, e9);
                }
            }
            throw new a2.a(i11, this.f2329g, 1, e9);
        }
    }

    public final void q0(int i10) throws a2.a {
        int i11 = this.f2330h;
        try {
            byte[] bArr = this.f;
            bArr[i11] = (byte) i10;
            bArr[i11 + 1] = (byte) (i10 >> 8);
            bArr[i11 + 2] = (byte) (i10 >> 16);
            bArr[i11 + 3] = (byte) (i10 >> 24);
            this.f2330h = i11 + 4;
        } catch (IndexOutOfBoundsException e9) {
            throw new a2.a(i11, this.f2329g, 4, e9);
        }
    }

    public final void r0(long j4) throws a2.a {
        int i10;
        int i11 = this.f2330h;
        int i12 = this.f2329g;
        byte[] bArr = this.f;
        if (!f2327j || i12 - i11 < 10) {
            long j7 = j4;
            while ((j7 & (-128)) != 0) {
                int i13 = i11 + 1;
                try {
                    bArr[i11] = (byte) (((int) j7) | 128);
                    j7 >>>= 7;
                    i11 = i13;
                } catch (IndexOutOfBoundsException e9) {
                    e = e9;
                    i10 = i13;
                    throw new a2.a(i10, i12, 1, e);
                }
            }
            i10 = i11 + 1;
            try {
                bArr[i11] = (byte) j7;
            } catch (IndexOutOfBoundsException e10) {
                e = e10;
                throw new a2.a(i10, i12, 1, e);
            }
        } else {
            long j10 = j4;
            while ((j10 & (-128)) != 0) {
                s6.f2616c.a(bArr, s6.f + ((long) i11), (byte) (((int) j10) | 128));
                j10 >>>= 7;
                i11++;
            }
            i10 = i11 + 1;
            s6.f2616c.a(bArr, s6.f + ((long) i11), (byte) j10);
        }
        this.f2330h = i10;
    }

    public final void s0(long j4) throws a2.a {
        int i10 = this.f2330h;
        try {
            byte[] bArr = this.f;
            bArr[i10] = (byte) j4;
            bArr[i10 + 1] = (byte) (j4 >> 8);
            bArr[i10 + 2] = (byte) (j4 >> 16);
            bArr[i10 + 3] = (byte) (j4 >> 24);
            bArr[i10 + 4] = (byte) (j4 >> 32);
            bArr[i10 + 5] = (byte) (j4 >> 40);
            bArr[i10 + 6] = (byte) (j4 >> 48);
            bArr[i10 + 7] = (byte) (j4 >> 56);
            this.f2330h = i10 + 8;
        } catch (IndexOutOfBoundsException e9) {
            throw new a2.a(i10, this.f2329g, 8, e9);
        }
    }

    public final void t0(int i10, byte[] bArr) throws a2.a {
        try {
            System.arraycopy(bArr, 0, this.f, this.f2330h, i10);
            this.f2330h += i10;
        } catch (IndexOutOfBoundsException e9) {
            throw new a2.a(this.f2330h, this.f2329g, i10, e9);
        }
    }

    public final void u0(String str) throws a2.a {
        int i10 = this.f2330h;
        try {
            int iV0 = v0(str.length() * 3);
            int iV02 = v0(str.length());
            int i11 = this.f2329g;
            byte[] bArr = this.f;
            if (iV02 != iV0) {
                p0(u6.b(str));
                int i12 = this.f2330h;
                this.f2330h = u6.c(str, bArr, i12, i11 - i12);
            } else {
                int i13 = i10 + iV02;
                this.f2330h = i13;
                int iC = u6.c(str, bArr, i13, i11 - i13);
                this.f2330h = i10;
                p0((iC - i10) - iV02);
                this.f2330h = iC;
            }
        } catch (t6 e9) {
            this.f2330h = i10;
            i.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e9);
            byte[] bytes = str.getBytes(p5.f2570a);
            try {
                int length = bytes.length;
                p0(length);
                t0(length, bytes);
            } catch (IndexOutOfBoundsException e10) {
                throw new a2.a(e10);
            }
        } catch (IndexOutOfBoundsException e11) {
            throw new a2.a(e11);
        }
    }
}
