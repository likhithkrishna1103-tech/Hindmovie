package p2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends DecoderInputBuffer {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f9918v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9919w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9920x;

    public final boolean b(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        y1.d.b(!decoderInputBuffer.isEncrypted());
        y1.d.b(!decoderInputBuffer.hasSupplementalData());
        y1.d.b(!decoderInputBuffer.isEndOfStream());
        if (c()) {
            if (this.f9919w >= this.f9920x) {
                return false;
            }
            ByteBuffer byteBuffer2 = decoderInputBuffer.data;
            if (byteBuffer2 != null && (byteBuffer = this.data) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i = this.f9919w;
        this.f9919w = i + 1;
        if (i == 0) {
            this.timeUs = decoderInputBuffer.timeUs;
            if (decoderInputBuffer.isKeyFrame()) {
                setFlags(1);
            }
        }
        ByteBuffer byteBuffer3 = decoderInputBuffer.data;
        if (byteBuffer3 != null) {
            ensureSpaceForWrite(byteBuffer3.remaining());
            this.data.put(byteBuffer3);
        }
        this.f9918v = decoderInputBuffer.timeUs;
        return true;
    }

    public final boolean c() {
        return this.f9919w > 0;
    }

    @Override // androidx.media3.decoder.DecoderInputBuffer, e2.a
    public final void clear() {
        super.clear();
        this.f9919w = 0;
    }
}
