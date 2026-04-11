package com.bumptech.glide.load.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FileOutputStream f2229v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte[] f2230w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a7.g f2231x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2232y;

    public b(FileOutputStream fileOutputStream, a7.g gVar) {
        this.f2229v = fileOutputStream;
        this.f2231x = gVar;
        this.f2230w = (byte[]) gVar.d(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.f2229v;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.f2230w;
            if (bArr != null) {
                this.f2231x.h(bArr);
                this.f2230w = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.f2232y;
        FileOutputStream fileOutputStream = this.f2229v;
        if (i > 0) {
            fileOutputStream.write(this.f2230w, 0, i);
            this.f2232y = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        byte[] bArr = this.f2230w;
        int i10 = this.f2232y;
        int i11 = i10 + 1;
        this.f2232y = i11;
        bArr[i10] = (byte) i;
        if (i11 != bArr.length || i11 <= 0) {
            return;
        }
        this.f2229v.write(bArr, 0, i11);
        this.f2232y = 0;
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
            int i14 = this.f2232y;
            FileOutputStream fileOutputStream = this.f2229v;
            if (i14 == 0 && i12 >= this.f2230w.length) {
                fileOutputStream.write(bArr, i13, i12);
                return;
            }
            int iMin = Math.min(i12, this.f2230w.length - i14);
            System.arraycopy(bArr, i13, this.f2230w, this.f2232y, iMin);
            int i15 = this.f2232y + iMin;
            this.f2232y = i15;
            i11 += iMin;
            byte[] bArr2 = this.f2230w;
            if (i15 == bArr2.length && i15 > 0) {
                fileOutputStream.write(bArr2, 0, i15);
                this.f2232y = 0;
            }
        } while (i11 < i10);
    }
}
