package x6;

import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends FilterInputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14286u;

    public j(e eVar) {
        super(eVar);
        this.f14286u = Integer.MIN_VALUE;
    }

    public final long a(long j5) {
        int i = this.f14286u;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j5 <= ((long) i)) ? j5 : i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i = this.f14286u;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    public final void d(long j5) {
        int i = this.f14286u;
        if (i == Integer.MIN_VALUE || j5 == -1) {
            return;
        }
        this.f14286u = (int) (((long) i) - j5);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        super.mark(i);
        this.f14286u = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i = super.read();
        d(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f14286u = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) throws IOException {
        long jA = a(j5);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        d(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        int iA = (int) a(i10);
        if (iA == -1) {
            return -1;
        }
        int i11 = super.read(bArr, i, iA);
        d(i11);
        return i11;
    }
}
