package x6;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import l6.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends InputStream {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ArrayDeque f14277w;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public v f14278u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public IOException f14279v;

    static {
        char[] cArr = m.f14291a;
        f14277w = new ArrayDeque(0);
    }

    public final void a() {
        this.f14279v = null;
        this.f14278u = null;
        ArrayDeque arrayDeque = f14277w;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f14278u.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f14278u.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f14278u.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.f14278u.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            return this.f14278u.read();
        } catch (IOException e10) {
            this.f14279v = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f14278u.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j5) throws IOException {
        try {
            return this.f14278u.skip(j5);
        } catch (IOException e10) {
            this.f14279v = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            return this.f14278u.read(bArr);
        } catch (IOException e10) {
            this.f14279v = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        try {
            return this.f14278u.read(bArr, i, i10);
        } catch (IOException e10) {
            this.f14279v = e10;
            throw e10;
        }
    }
}
