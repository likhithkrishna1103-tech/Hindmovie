package j2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends DecoderInputBuffer {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f6703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6705w;

    public final boolean b(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        s1.d.b(!decoderInputBuffer.isEncrypted());
        s1.d.b(!decoderInputBuffer.hasSupplementalData());
        s1.d.b(!decoderInputBuffer.isEndOfStream());
        if (c()) {
            if (this.f6704v >= this.f6705w) {
                return false;
            }
            ByteBuffer byteBuffer2 = decoderInputBuffer.data;
            if (byteBuffer2 != null && (byteBuffer = this.data) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i = this.f6704v;
        this.f6704v = i + 1;
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
        this.f6703u = decoderInputBuffer.timeUs;
        return true;
    }

    public final boolean c() {
        return this.f6704v > 0;
    }

    @Override // androidx.media3.decoder.DecoderInputBuffer, y1.a
    public final void clear() {
        super.clear();
        this.f6704v = 0;
    }
}
