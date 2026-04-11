package id;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Closeable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6597u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Closeable f6598v;

    public p(FileOutputStream fileOutputStream) throws IOException {
        this.f6598v = fileOutputStream;
        fileOutputStream.getChannel().position(0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f6597u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((FileOutputStream) this.f6598v).close();
                break;
            default:
                ((RandomAccessFile) this.f6598v).close();
                break;
        }
    }

    public final void d(long j5) throws IOException {
        switch (this.f6597u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((FileOutputStream) this.f6598v).getChannel().position(j5);
                break;
            default:
                ((RandomAccessFile) this.f6598v).seek(j5);
                break;
        }
    }

    public final void v(int i, byte[] bArr) throws IOException {
        switch (this.f6597u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((FileOutputStream) this.f6598v).write(bArr, 0, i);
                break;
            default:
                ((RandomAccessFile) this.f6598v).write(bArr, 0, i);
                break;
        }
    }

    public p(RandomAccessFile randomAccessFile) throws IOException {
        this.f6598v = randomAccessFile;
        randomAccessFile.seek(0L);
    }

    private final void a() {
    }
}
