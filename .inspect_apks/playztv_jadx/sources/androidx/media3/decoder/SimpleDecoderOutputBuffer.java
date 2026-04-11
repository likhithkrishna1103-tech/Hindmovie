package androidx.media3.decoder;

import androidx.media3.decoder.ffmpeg.b;
import java.nio.ByteBuffer;
import y1.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleDecoderOutputBuffer extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f1531u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ByteBuffer f1532v;

    public SimpleDecoderOutputBuffer(b bVar) {
        this.f1531u = bVar;
    }

    @Override // y1.h, y1.a
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f1532v;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // y1.h
    public final void release() {
        this.f1531u.a(this);
    }
}
