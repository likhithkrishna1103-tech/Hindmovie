package x6;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ByteBuffer f14272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14273v = -1;

    public a(ByteBuffer byteBuffer) {
        this.f14272u = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f14272u.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.f14273v = this.f14272u.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f14272u;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i = this.f14273v;
        if (i == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.f14272u.position(i);
    }

    @Override // java.io.InputStream
    public final long skip(long j5) {
        ByteBuffer byteBuffer = this.f14272u;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long jMin = Math.min(j5, byteBuffer.remaining());
        byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
        return jMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) {
        ByteBuffer byteBuffer = this.f14272u;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i10, byteBuffer.remaining());
        byteBuffer.get(bArr, i, iMin);
        return iMin;
    }
}
