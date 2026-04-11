package s7;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ByteBuffer f11588v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11589w = -1;

    public a(ByteBuffer byteBuffer) {
        this.f11588v = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f11588v.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.f11589w = this.f11588v.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f11588v;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i = this.f11589w;
        if (i == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.f11588v.position(i);
    }

    @Override // java.io.InputStream
    public final long skip(long j4) {
        ByteBuffer byteBuffer = this.f11588v;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long jMin = Math.min(j4, byteBuffer.remaining());
        byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
        return jMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) {
        ByteBuffer byteBuffer = this.f11588v;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i10, byteBuffer.remaining());
        byteBuffer.get(bArr, i, iMin);
        return iMin;
    }
}
