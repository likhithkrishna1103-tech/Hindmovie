package s1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends OutputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final FileOutputStream f11643u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f11644v = false;

    public a(File file) {
        this.f11643u = new FileOutputStream(file);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.f11643u;
        if (this.f11644v) {
            return;
        }
        this.f11644v = true;
        flush();
        try {
            fileOutputStream.getFD().sync();
        } catch (IOException e10) {
            b.q("AtomicFile", "Failed to sync file descriptor:", e10);
        }
        fileOutputStream.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f11643u.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f11643u.write(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.f11643u.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i10) throws IOException {
        this.f11643u.write(bArr, i, i10);
    }
}
