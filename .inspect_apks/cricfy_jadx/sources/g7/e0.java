package g7;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends MediaDataSource {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f5179v;

    public e0(ByteBuffer byteBuffer) {
        this.f5179v = byteBuffer;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f5179v.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j4, byte[] bArr, int i, int i10) {
        ByteBuffer byteBuffer = this.f5179v;
        if (j4 >= byteBuffer.limit()) {
            return -1;
        }
        byteBuffer.position((int) j4);
        int iMin = Math.min(i10, byteBuffer.remaining());
        byteBuffer.get(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
