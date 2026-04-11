package md;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Closeable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f8451v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Closeable f8452w;

    public o(FileOutputStream fileOutputStream) throws IOException {
        this.f8452w = fileOutputStream;
        fileOutputStream.getChannel().position(0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f8451v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((FileOutputStream) this.f8452w).close();
                break;
            default:
                ((RandomAccessFile) this.f8452w).close();
                break;
        }
    }

    public final void g(long j4) throws IOException {
        switch (this.f8451v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((FileOutputStream) this.f8452w).getChannel().position(j4);
                break;
            default:
                ((RandomAccessFile) this.f8452w).seek(j4);
                break;
        }
    }

    public final void q(int i, byte[] bArr) throws IOException {
        switch (this.f8451v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((FileOutputStream) this.f8452w).write(bArr, 0, i);
                break;
            default:
                ((RandomAccessFile) this.f8452w).write(bArr, 0, i);
                break;
        }
    }

    public o(RandomAccessFile randomAccessFile) throws IOException {
        this.f8452w = randomAccessFile;
        randomAccessFile.seek(0L);
    }

    private final void a() {
    }
}
