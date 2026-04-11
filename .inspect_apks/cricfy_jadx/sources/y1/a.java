package y1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends OutputStream {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FileOutputStream f14549v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14550w = false;

    public a(File file) {
        this.f14549v = new FileOutputStream(file);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.f14549v;
        if (this.f14550w) {
            return;
        }
        this.f14550w = true;
        flush();
        try {
            fileOutputStream.getFD().sync();
        } catch (IOException e9) {
            b.q("AtomicFile", "Failed to sync file descriptor:", e9);
        }
        fileOutputStream.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f14549v.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f14549v.write(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.f14549v.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i10) throws IOException {
        this.f14549v.write(bArr, i, i10);
    }
}
