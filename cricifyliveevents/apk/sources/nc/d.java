package nc;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends FilterInputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f9041v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f9042w;

    public d(InputStream inputStream) {
        super(inputStream);
        this.f9042w = -1L;
        this.f9041v = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.f9041v);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.f9042w = this.f9041v;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f9041v == 0) {
            return -1;
        }
        int i = ((FilterInputStream) this).in.read();
        if (i != -1) {
            this.f9041v--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f9042w == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f9041v = this.f9042w;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j4) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j4, this.f9041v));
        this.f9041v -= jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        long j4 = this.f9041v;
        if (j4 == 0) {
            return -1;
        }
        int i11 = ((FilterInputStream) this).in.read(bArr, i, (int) Math.min(i10, j4));
        if (i11 != -1) {
            this.f9041v -= (long) i11;
        }
        return i11;
    }
}
