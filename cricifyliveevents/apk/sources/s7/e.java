package s7;

import g7.x;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends InputStream {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ArrayDeque f11593x;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public x f11594v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public IOException f11595w;

    static {
        char[] cArr = m.f11607a;
        f11593x = new ArrayDeque(0);
    }

    public final void a() {
        this.f11595w = null;
        this.f11594v = null;
        ArrayDeque arrayDeque = f11593x;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f11594v.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f11594v.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f11594v.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.f11594v.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            return this.f11594v.read();
        } catch (IOException e9) {
            this.f11595w = e9;
            throw e9;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f11594v.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j4) throws IOException {
        try {
            return this.f11594v.skip(j4);
        } catch (IOException e9) {
            this.f11595w = e9;
            throw e9;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            return this.f11594v.read(bArr);
        } catch (IOException e9) {
            this.f11595w = e9;
            throw e9;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        try {
            return this.f11594v.read(bArr, i, i10);
        } catch (IOException e9) {
            this.f11595w = e9;
            throw e9;
        }
    }
}
