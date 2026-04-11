package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends FilterInputStream {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte[] f2237x = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f2238y = 31;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte f2239v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2240w;

    public i(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException(l0.e.g(i, "Cannot add invalid orientation: "));
        }
        this.f2239v = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int i;
        int i10 = this.f2240w;
        int i11 = (i10 < 2 || i10 > (i = f2238y)) ? super.read() : i10 == i ? this.f2239v : f2237x[i10 - 2] & 255;
        if (i11 != -1) {
            this.f2240w++;
        }
        return i11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j4) throws IOException {
        long jSkip = super.skip(j4);
        if (jSkip > 0) {
            this.f2240w = (int) (((long) this.f2240w) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        int i11;
        int i12 = this.f2240w;
        int i13 = f2238y;
        if (i12 > i13) {
            i11 = super.read(bArr, i, i10);
        } else if (i12 == i13) {
            bArr[i] = this.f2239v;
            i11 = 1;
        } else if (i12 < 2) {
            i11 = super.read(bArr, i, 2 - i12);
        } else {
            int iMin = Math.min(i13 - i12, i10);
            System.arraycopy(f2237x, this.f2240w - 2, bArr, i, iMin);
            i11 = iMin;
        }
        if (i11 > 0) {
            this.f2240w += i11;
        }
        return i11;
    }
}
