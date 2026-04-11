package s7;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends FilterInputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f11591v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11592w;

    public d(InputStream inputStream, long j4) {
        super(inputStream);
        this.f11591v = j4;
    }

    public final void a(int i) throws IOException {
        if (i >= 0) {
            this.f11592w += i;
            return;
        }
        long j4 = this.f11592w;
        long j7 = this.f11591v;
        if (j7 - j4 <= 0) {
            return;
        }
        throw new IOException("Failed to read all expected data, expected: " + j7 + ", but read: " + this.f11592w);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f11591v - ((long) this.f11592w), ((FilterInputStream) this).in.available());
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
