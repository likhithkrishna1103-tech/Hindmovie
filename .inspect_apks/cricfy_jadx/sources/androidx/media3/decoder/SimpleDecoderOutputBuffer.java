package androidx.media3.decoder;

import androidx.media3.decoder.ffmpeg.b;
import e2.h;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleDecoderOutputBuffer extends h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f1227v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ByteBuffer f1228w;

    public SimpleDecoderOutputBuffer(b bVar) {
        this.f1227v = bVar;
    }

    @Override // e2.h, e2.a
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f1228w;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // e2.h
    public final void release() {
        this.f1227v.f(this);
    }
}
