package s7;

import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends FilterInputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11602v;

    public j(e eVar) {
        super(eVar);
        this.f11602v = Integer.MIN_VALUE;
    }

    public final long a(long j4) {
        int i = this.f11602v;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j4 <= ((long) i)) ? j4 : i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i = this.f11602v;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    public final void g(long j4) {
        int i = this.f11602v;
        if (i == Integer.MIN_VALUE || j4 == -1) {
            return;
        }
        this.f11602v = (int) (((long) i) - j4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        super.mark(i);
        this.f11602v = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i = super.read();
        g(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f11602v = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j4) throws IOException {
        long jA = a(j4);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        g(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        int iA = (int) a(i10);
        if (iA == -1) {
            return -1;
        }
        int i11 = super.read(bArr, i, iA);
        g(i11);
        return i11;
    }
}
