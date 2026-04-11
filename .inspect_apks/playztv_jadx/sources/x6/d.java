package x6;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends FilterInputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f14275u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14276v;

    public d(InputStream inputStream, long j5) {
        super(inputStream);
        this.f14275u = j5;
    }

    public final void a(int i) throws IOException {
        if (i >= 0) {
            this.f14276v += i;
            return;
        }
        long j5 = this.f14276v;
        long j8 = this.f14275u;
        if (j8 - j5 <= 0) {
            return;
        }
        throw new IOException("Failed to read all expected data, expected: " + j8 + ", but read: " + this.f14276v);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f14275u - ((long) this.f14276v), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int i;
        i = super.read();
        a(i >= 0 ? 1 : -1);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i10) {
        int i11;
        i11 = super.read(bArr, i, i10);
        a(i11);
        return i11;
    }
}
