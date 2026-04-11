package l6;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends MediaDataSource {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f7960u;

    public b0(ByteBuffer byteBuffer) {
        this.f7960u = byteBuffer;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f7960u.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j5, byte[] bArr, int i, int i10) {
        ByteBuffer byteBuffer = this.f7960u;
        if (j5 >= byteBuffer.limit()) {
            return -1;
        }
        byteBuffer.position((int) j5);
        int iMin = Math.min(i10, byteBuffer.remaining());
        byteBuffer.get(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
