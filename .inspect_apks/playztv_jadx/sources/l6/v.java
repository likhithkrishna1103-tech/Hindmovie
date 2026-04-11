package l6;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v extends FilterInputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile byte[] f8008u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8009v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8010w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8011x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8012y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f6.f f8013z;

    public v(InputStream inputStream, f6.f fVar) {
        super(inputStream);
        this.f8011x = -1;
        this.f8013z = fVar;
        this.f8008u = (byte[]) fVar.d(65536, byte[].class);
    }

    public static void v() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f8011x;
        if (i != -1) {
            int i10 = this.f8012y - i;
            int i11 = this.f8010w;
            if (i10 < i11) {
                if (i == 0 && i11 > bArr.length && this.f8009v == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i11) {
                        i11 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f8013z.d(i11, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f8008u = bArr2;
                    this.f8013z.h(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i12 = this.f8012y - this.f8011x;
                this.f8012y = i12;
                this.f8011x = 0;
                this.f8009v = 0;
                int i13 = inputStream.read(bArr, i12, bArr.length - i12);
                int i14 = this.f8012y;
                if (i13 > 0) {
                    i14 += i13;
                }
                this.f8009v = i14;
                return i13;
            }
        }
        int i15 = inputStream.read(bArr);
        if (i15 > 0) {
            this.f8011x = -1;
            this.f8012y = 0;
            this.f8009v = i15;
        }
        return i15;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f8008u == null || inputStream == null) {
            v();
            throw null;
        }
        return (this.f8009v - this.f8012y) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f8008u != null) {
            this.f8013z.h(this.f8008u);
            this.f8008u = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final synchronized void d() {
        if (this.f8008u != null) {
            this.f8013z.h(this.f8008u);
            this.f8008u = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.f8010w = Math.max(this.f8010w, i);
        this.f8011x = this.f8012y;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f8008u;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            v();
            throw null;
        }
        if (this.f8012y >= this.f8009v && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f8008u && (bArr = this.f8008u) == null) {
            v();
            throw null;
        }
        int i = this.f8009v;
        int i10 = this.f8012y;
        if (i - i10 <= 0) {
            return -1;
        }
        this.f8012y = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f8008u == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.f8011x;
        if (-1 == i) {
            throw new c6.c("Mark has been invalidated, pos: " + this.f8012y + " markLimit: " + this.f8010w);
        }
        this.f8012y = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j5) {
        if (j5 < 1) {
            return 0L;
        }
        byte[] bArr = this.f8008u;
        if (bArr == null) {
            v();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            v();
            throw null;
        }
        int i = this.f8009v;
        int i10 = this.f8012y;
        if (i - i10 >= j5) {
            this.f8012y = (int) (((long) i10) + j5);
            return j5;
        }
        long j8 = ((long) i) - ((long) i10);
        this.f8012y = i;
        if (this.f8011x == -1 || j5 > this.f8010w) {
            long jSkip = inputStream.skip(j5 - j8);
            if (jSkip > 0) {
                this.f8011x = -1;
            }
            return j8 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j8;
        }
        int i11 = this.f8009v;
        int i12 = this.f8012y;
        if (i11 - i12 >= j5 - j8) {
            this.f8012y = (int) ((((long) i12) + j5) - j8);
            return j5;
        }
        long j10 = (j8 + ((long) i11)) - ((long) i12);
        this.f8012y = i11;
        return j10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i10) {
        int i11;
        int i12;
        byte[] bArr2 = this.f8008u;
        if (bArr2 == null) {
            v();
            throw null;
        }
        if (i10 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i13 = this.f8012y;
            int i14 = this.f8009v;
            if (i13 < i14) {
                int i15 = i14 - i13;
                if (i15 >= i10) {
                    i15 = i10;
                }
                System.arraycopy(bArr2, i13, bArr, i, i15);
                this.f8012y += i15;
                if (i15 == i10 || inputStream.available() == 0) {
                    return i15;
                }
                i += i15;
                i11 = i10 - i15;
            } else {
                i11 = i10;
            }
            while (true) {
                if (this.f8011x == -1 && i11 >= bArr2.length) {
                    i12 = inputStream.read(bArr, i, i11);
                    if (i12 == -1) {
                        return i11 != i10 ? i10 - i11 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i11 != i10 ? i10 - i11 : -1;
                    }
                    if (bArr2 != this.f8008u && (bArr2 = this.f8008u) == null) {
                        v();
                        throw null;
                    }
                    int i16 = this.f8009v;
                    int i17 = this.f8012y;
                    i12 = i16 - i17;
                    if (i12 >= i11) {
                        i12 = i11;
                    }
                    System.arraycopy(bArr2, i17, bArr, i, i12);
                    this.f8012y += i12;
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
            v();
            throw null;
        }
    }
}
