package com.google.android.gms.internal.measurement;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b5 extends q0 {
    public static final Logger f = Logger.getLogger(b5.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f2898g = n6.f3123e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x5 f2899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2902e;

    public b5(int i, byte[] bArr) {
        if (((bArr.length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }
        this.f2900c = bArr;
        this.f2902e = 0;
        this.f2901d = i;
    }

    public static int j(int i, u4 u4Var, j6 j6Var) {
        return u4Var.a(j6Var) + (w(i << 3) << 1);
    }

    public static int k(String str) {
        int length;
        try {
            length = p6.a(str);
        } catch (q6 unused) {
            length = str.getBytes(l5.f3086a).length;
        }
        return w(length) + length;
    }

    public static int p(int i, a5 a5Var) {
        int iW = w(i << 3);
        int iH = a5Var.h();
        return l4.a.w(iH, iH, iW);
    }

    public static int u(long j5) {
        return (640 - (Long.numberOfLeadingZeros(j5) * 9)) >>> 6;
    }

    public static int v(int i) {
        return w(i << 3);
    }

    public static int w(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void d(byte b10) throws c6.c {
        int i = this.f2902e;
        try {
            int i10 = i + 1;
            try {
                this.f2900c[i] = b10;
                this.f2902e = i10;
            } catch (IndexOutOfBoundsException e10) {
                e = e10;
                i = i10;
                throw new c6.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(i), Integer.valueOf(this.f2901d), 1), e);
            }
        } catch (IndexOutOfBoundsException e11) {
            e = e11;
        }
    }

    public final void e(int i) throws c6.c {
        try {
            byte[] bArr = this.f2900c;
            int i10 = this.f2902e;
            int i11 = i10 + 1;
            this.f2902e = i11;
            bArr[i10] = (byte) i;
            int i12 = i10 + 2;
            this.f2902e = i12;
            bArr[i11] = (byte) (i >> 8);
            int i13 = i10 + 3;
            this.f2902e = i13;
            bArr[i12] = (byte) (i >> 16);
            this.f2902e = i10 + 4;
            bArr[i13] = (byte) (i >>> 24);
        } catch (IndexOutOfBoundsException e10) {
            throw new c6.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2902e), Integer.valueOf(this.f2901d), 1), e10);
        }
    }

    public final void f(int i, int i10) throws c6.c {
        r(i, 5);
        e(i10);
    }

    public final void g(int i, long j5) throws c6.c {
        r(i, 1);
        h(j5);
    }

    public final void h(long j5) throws c6.c {
        try {
            byte[] bArr = this.f2900c;
            int i = this.f2902e;
            int i10 = i + 1;
            this.f2902e = i10;
            bArr[i] = (byte) j5;
            int i11 = i + 2;
            this.f2902e = i11;
            bArr[i10] = (byte) (j5 >> 8);
            int i12 = i + 3;
            this.f2902e = i12;
            bArr[i11] = (byte) (j5 >> 16);
            int i13 = i + 4;
            this.f2902e = i13;
            bArr[i12] = (byte) (j5 >> 24);
            int i14 = i + 5;
            this.f2902e = i14;
            bArr[i13] = (byte) (j5 >> 32);
            int i15 = i + 6;
            this.f2902e = i15;
            bArr[i14] = (byte) (j5 >> 40);
            int i16 = i + 7;
            this.f2902e = i16;
            bArr[i15] = (byte) (j5 >> 48);
            this.f2902e = i + 8;
            bArr[i16] = (byte) (j5 >> 56);
        } catch (IndexOutOfBoundsException e10) {
            throw new c6.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2902e), Integer.valueOf(this.f2901d), 1), e10);
        }
    }

    public final int i() {
        return this.f2901d - this.f2902e;
    }

    public final void l(int i) throws c6.c {
        if (i >= 0) {
            q(i);
        } else {
            o(i);
        }
    }

    public final void m(int i, int i10) throws c6.c {
        r(i, 0);
        l(i10);
    }

    public final void n(int i, long j5) throws c6.c {
        r(i, 0);
        o(j5);
    }

    public final void o(long j5) throws c6.c {
        boolean z2 = f2898g;
        byte[] bArr = this.f2900c;
        if (z2 && i() >= 10) {
            while ((j5 & (-128)) != 0) {
                int i = this.f2902e;
                this.f2902e = i + 1;
                n6.f3121c.c(bArr, n6.f + ((long) i), (byte) (((int) j5) | 128));
                j5 >>>= 7;
            }
            int i10 = this.f2902e;
            this.f2902e = i10 + 1;
            n6.f3121c.c(bArr, n6.f + ((long) i10), (byte) j5);
            return;
        }
        while ((j5 & (-128)) != 0) {
            try {
                int i11 = this.f2902e;
                this.f2902e = i11 + 1;
                bArr[i11] = (byte) (((int) j5) | 128);
                j5 >>>= 7;
            } catch (IndexOutOfBoundsException e10) {
                throw new c6.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2902e), Integer.valueOf(this.f2901d), 1), e10);
            }
        }
        int i12 = this.f2902e;
        this.f2902e = i12 + 1;
        bArr[i12] = (byte) j5;
    }

    public final void q(int i) throws c6.c {
        while (true) {
            int i10 = i & (-128);
            byte[] bArr = this.f2900c;
            if (i10 == 0) {
                int i11 = this.f2902e;
                this.f2902e = i11 + 1;
                bArr[i11] = (byte) i;
                return;
            } else {
                try {
                    int i12 = this.f2902e;
                    this.f2902e = i12 + 1;
                    bArr[i12] = (byte) (i | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new c6.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2902e), Integer.valueOf(this.f2901d), 1), e10);
                }
            }
            throw new c6.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2902e), Integer.valueOf(this.f2901d), 1), e10);
        }
    }

    public final void r(int i, int i10) throws c6.c {
        q((i << 3) | i10);
    }

    public final void s(byte[] bArr, int i, int i10) throws c6.c {
        try {
            System.arraycopy(bArr, i, this.f2900c, this.f2902e, i10);
            this.f2902e += i10;
        } catch (IndexOutOfBoundsException e10) {
            throw new c6.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2902e), Integer.valueOf(this.f2901d), Integer.valueOf(i10)), e10);
        }
    }

    public final void t(int i, int i10) throws c6.c {
        r(i, 0);
        q(i10);
    }
}
