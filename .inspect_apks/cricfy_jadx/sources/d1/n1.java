package d1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 extends OutputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FileOutputStream f3280v;

    public n1(FileOutputStream fileOutputStream) {
        this.f3280v = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f3280v.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f3280v.write(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        ge.i.e(bArr, "b");
        this.f3280v.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i10) throws IOException {
        ge.i.e(bArr, "bytes");
        this.f3280v.write(bArr, i, i10);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
