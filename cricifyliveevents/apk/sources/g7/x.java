package g7;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends FilterInputStream {
    public final a7.g A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile byte[] f5226v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5227w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f5228x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f5229y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f5230z;

    public x(InputStream inputStream, a7.g gVar) {
        super(inputStream);
        this.f5229y = -1;
        this.A = gVar;
        this.f5226v = (byte[]) gVar.d(65536, byte[].class);
    }

    public static void q() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f5229y;
        if (i != -1) {
            int i10 = this.f5230z - i;
            int i11 = this.f5228x;
            if (i10 < i11) {
                if (i == 0 && i11 > bArr.length && this.f5227w == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i11) {
                        i11 = length;
                    }
                    byte[] bArr2 = (byte[]) this.A.d(i11, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f5226v = bArr2;
                    this.A.h(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i12 = this.f5230z - this.f5229y;
                this.f5230z = i12;
                this.f5229y = 0;
                this.f5227w = 0;
                int i13 = inputStream.read(bArr, i12, bArr.length - i12);
                int i14 = this.f5230z;
                if (i13 > 0) {
                    i14 += i13;
                }
                this.f5227w = i14;
                return i13;
            }
        }
        int i15 = inputStream.read(bArr);
        if (i15 > 0) {
            this.f5229y = -1;
            this.f5230z = 0;
            this.f5227w = i15;
        }
        return i15;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f5226v == null || inputStream == null) {
            q();
            throw null;
        }
        return (this.f5227w - this.f5230z) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f5226v != null) {
            this.A.h(this.f5226v);
            this.f5226v = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final synchronized void g() {
        if (this.f5226v != null) {
            this.A.h(this.f5226v);
            this.f5226v = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.f5228x = Math.max(this.f5228x, i);
        this.f5229y = this.f5230z;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f5226v;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            q();
            throw null;
        }
        if (this.f5230z >= this.f5227w && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f5226v && (bArr = this.f5226v) == null) {
            q();
            throw null;
        }
        int i = this.f5227w;
        int i10 = this.f5230z;
        if (i - i10 <= 0) {
            return -1;
        }
        this.f5230z = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f5226v == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.f5229y;
        if (-1 == i) {
            throw new a2.a("Mark has been invalidated, pos: " + this.f5230z + " markLimit: " + this.f5228x);
        }
        this.f5230z = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j4) {
        if (j4 < 1) {
            return 0L;
        }
        byte[] bArr = this.f5226v;
        if (bArr == null) {
            q();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            q();
            throw null;
        }
        int i = this.f5227w;
        int i10 = this.f5230z;
        if (i - i10 >= j4) {
            this.f5230z = (int) (((long) i10) + j4);
            return j4;
        }
        long j7 = ((long) i) - ((long) i10);
        this.f5230z = i;
        if (this.f5229y == -1 || j4 > this.f5228x) {
            long jSkip = inputStream.skip(j4 - j7);
            if (jSkip > 0) {
                this.f5229y = -1;
            }
            return j7 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j7;
        }
        int i11 = this.f5227w;
        int i12 = this.f5230z;
        if (i11 - i12 >= j4 - j7) {
            this.f5230z = (int) ((((long) i12) + j4) - j7);
            return j4;
        }
        long j10 = (j7 + ((long) i11)) - ((long) i12);
        this.f5230z = i11;
        return j10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i10) {
        int i11;
        int i12;
        byte[] bArr2 = this.f5226v;
        if (bArr2 == null) {
            q();
            throw null;
        }
        if (i10 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i13 = this.f5230z;
            int i14 = this.f5227w;
            if (i13 < i14) {
                int i15 = i14 - i13;
                if (i15 >= i10) {
                    i15 = i10;
                }
                System.arraycopy(bArr2, i13, bArr, i, i15);
                this.f5230z += i15;
                if (i15 == i10 || inputStream.available() == 0) {
                    return i15;
                }
                i += i15;
                i11 = i10 - i15;
            } else {
                i11 = i10;
            }
            while (true) {
                if (this.f5229y == -1 && i11 >= bArr2.length) {
                    i12 = inputStream.read(bArr, i, i11);
                    if (i12 == -1) {
                        return i11 != i10 ? i10 - i11 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i11 != i10 ? i10 - i11 : -1;
                    }
                    if (bArr2 != this.f5226v && (bArr2 = this.f5226v) == null) {
                        q();
                        throw null;
                    }
                    int i16 = this.f5227w;
                    int i17 = this.f5230z;
                    i12 = i16 - i17;
                    if (i12 >= i11) {
                        i12 = i11;
                    }
                    System.arraycopy(bArr2, i17, bArr, i, i12);
                    this.f5230z += i12;
                }
                i11 -= i12;
                if (i11 == 0) {
                    return i10;
                }
                if (inputStream.available() == 0) {
                    return i10 - i11;
                }
                i += i12;
            }
        } else {
            q();
            throw null;
        }
    }
}
