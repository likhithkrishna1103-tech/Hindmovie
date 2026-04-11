package z0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends OutputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final FileOutputStream f14770u;

    public m(FileOutputStream fileOutputStream) {
        this.f14770u = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f14770u.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f14770u.write(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        be.h.e(bArr, "b");
        this.f14770u.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i10) throws IOException {
        be.h.e(bArr, "bytes");
        this.f14770u.write(bArr, i, i10);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
