package ub;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends FilterInputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f12843u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f12844v;

    public d(InputStream inputStream) {
        super(inputStream);
        this.f12844v = -1L;
        this.f12843u = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.f12843u);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.f12844v = this.f12843u;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f12843u == 0) {
            return -1;
        }
        int i = ((FilterInputStream) this).in.read();
        if (i != -1) {
            this.f12843u--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f12844v == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f12843u = this.f12844v;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j5, this.f12843u));
        this.f12843u -= jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        long j5 = this.f12843u;
        if (j5 == 0) {
            return -1;
        }
        int i11 = ((FilterInputStream) this).in.read(bArr, i, (int) Math.min(i10, j5));
        if (i11 != -1) {
            this.f12843u -= (long) i11;
        }
        return i11;
    }
}
