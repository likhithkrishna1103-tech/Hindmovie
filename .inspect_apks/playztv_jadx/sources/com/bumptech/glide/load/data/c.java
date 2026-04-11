package com.bumptech.glide.load.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final FileOutputStream f2804u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f2805v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f6.f f2806w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2807x;

    public c(FileOutputStream fileOutputStream, f6.f fVar) {
        this.f2804u = fileOutputStream;
        this.f2806w = fVar;
        this.f2805v = (byte[]) fVar.d(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.f2804u;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.f2805v;
            if (bArr != null) {
                this.f2806w.h(bArr);
                this.f2805v = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.f2807x;
        FileOutputStream fileOutputStream = this.f2804u;
        if (i > 0) {
            fileOutputStream.write(this.f2805v, 0, i);
            this.f2807x = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        byte[] bArr = this.f2805v;
        int i10 = this.f2807x;
        int i11 = i10 + 1;
        this.f2807x = i11;
        bArr[i10] = (byte) i;
        if (i11 != bArr.length || i11 <= 0) {
            return;
        }
        this.f2804u.write(bArr, 0, i11);
        this.f2807x = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i10) throws IOException {
        int i11 = 0;
        do {
            int i12 = i10 - i11;
            int i13 = i + i11;
            int i14 = this.f2807x;
            FileOutputStream fileOutputStream = this.f2804u;
            if (i14 == 0 && i12 >= this.f2805v.length) {
                fileOutputStream.write(bArr, i13, i12);
                return;
            }
            int iMin = Math.min(i12, this.f2805v.length - i14);
            System.arraycopy(bArr, i13, this.f2805v, this.f2807x, iMin);
            int i15 = this.f2807x + iMin;
            this.f2807x = i15;
            i11 += iMin;
            byte[] bArr2 = this.f2805v;
            if (i15 == bArr2.length && i15 > 0) {
                fileOutputStream.write(bArr2, 0, i15);
                this.f2807x = 0;
            }
        } while (i11 < i10);
    }
}
