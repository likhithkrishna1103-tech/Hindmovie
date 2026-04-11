package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends FilterInputStream {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f2812w = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f2813x = 31;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final byte f2814u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2815v;

    public j(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException(e6.j.l("Cannot add invalid orientation: ", i));
        }
        this.f2814u = (byte) i;
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
        int i10 = this.f2815v;
        int i11 = (i10 < 2 || i10 > (i = f2813x)) ? super.read() : i10 == i ? this.f2814u : f2812w[i10 - 2] & 255;
        if (i11 != -1) {
            this.f2815v++;
        }
        return i11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) throws IOException {
        long jSkip = super.skip(j5);
        if (jSkip > 0) {
            this.f2815v = (int) (((long) this.f2815v) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        int i11;
        int i12 = this.f2815v;
        int i13 = f2813x;
        if (i12 > i13) {
            i11 = super.read(bArr, i, i10);
        } else if (i12 == i13) {
            bArr[i] = this.f2814u;
            i11 = 1;
        } else if (i12 < 2) {
            i11 = super.read(bArr, i, 2 - i12);
        } else {
            int iMin = Math.min(i13 - i12, i10);
            System.arraycopy(f2812w, this.f2815v - 2, bArr, i, iMin);
            i11 = iMin;
        }
        if (i11 > 0) {
            this.f2815v += i11;
        }
        return i11;
    }
}
