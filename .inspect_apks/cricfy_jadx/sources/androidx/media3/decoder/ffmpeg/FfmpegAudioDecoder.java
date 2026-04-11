package androidx.media3.decoder.ffmpeg;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import e2.h;
import e2.j;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
final class FfmpegAudioDecoder extends j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f1229w = {102, 76, 97, 67};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f1230o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final byte[] f1231p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f1232q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1233r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1234s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1235t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile int f1236u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile int f1237v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d2 A[LOOP:1: B:31:0x0071->B:57:0x00d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FfmpegAudioDecoder(int r18, v1.p r19, boolean r20) throws androidx.media3.decoder.ffmpeg.d {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.ffmpeg.FfmpegAudioDecoder.<init>(int, v1.p, boolean):void");
    }

    private native int ffmpegDecode(long j4, ByteBuffer byteBuffer, int i, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, ByteBuffer byteBuffer2, int i10);

    private native int ffmpegGetChannelCount(long j4);

    private native int ffmpegGetSampleRate(long j4);

    private native long ffmpegInitialize(String str, byte[] bArr, boolean z10, int i, int i10);

    private native void ffmpegRelease(long j4);

    private native long ffmpegReset(long j4, byte[] bArr);

    private ByteBuffer growOutputBuffer(SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, int i) {
        this.f1233r = i;
        ByteBuffer byteBuffer = simpleDecoderOutputBuffer.f1228w;
        byteBuffer.getClass();
        y1.d.b(i >= byteBuffer.limit());
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        int iPosition = byteBuffer.position();
        byteBuffer.position(0);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(iPosition);
        byteBufferOrder.limit(i);
        simpleDecoderOutputBuffer.f1228w = byteBufferOrder;
        return byteBufferOrder;
    }

    @Override // e2.j
    public final DecoderInputBuffer b() {
        return new DecoderInputBuffer(2, FfmpegLibrary.b());
    }

    @Override // e2.j
    public final h c() {
        return new SimpleDecoderOutputBuffer(new b(this));
    }

    @Override // e2.j
    public final e2.e d(Throwable th) {
        return new d("Unexpected decode error", th);
    }

    @Override // e2.j
    public final e2.e e(DecoderInputBuffer decoderInputBuffer, h hVar, boolean z10) {
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) hVar;
        if (z10) {
            long jFfmpegReset = ffmpegReset(this.f1234s, this.f1231p);
            this.f1234s = jFfmpegReset;
            if (jFfmpegReset == 0) {
                return new d("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        int i = a0.f14551a;
        int iLimit = byteBuffer.limit();
        long j4 = decoderInputBuffer.timeUs;
        int i10 = this.f1233r;
        simpleDecoderOutputBuffer.timeUs = j4;
        ByteBuffer byteBuffer2 = simpleDecoderOutputBuffer.f1228w;
        if (byteBuffer2 == null || byteBuffer2.capacity() < i10) {
            simpleDecoderOutputBuffer.f1228w = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        }
        simpleDecoderOutputBuffer.f1228w.position(0);
        simpleDecoderOutputBuffer.f1228w.limit(i10);
        int iFfmpegDecode = ffmpegDecode(this.f1234s, byteBuffer, iLimit, simpleDecoderOutputBuffer, simpleDecoderOutputBuffer.f1228w, this.f1233r);
        if (iFfmpegDecode == -2) {
            return new d("Error decoding (see logcat).");
        }
        if (iFfmpegDecode == -1) {
            simpleDecoderOutputBuffer.shouldBeSkipped = true;
            return null;
        }
        if (iFfmpegDecode == 0) {
            simpleDecoderOutputBuffer.shouldBeSkipped = true;
            return null;
        }
        if (!this.f1235t) {
            this.f1236u = ffmpegGetChannelCount(this.f1234s);
            this.f1237v = ffmpegGetSampleRate(this.f1234s);
            if (this.f1237v == 0 && "alac".equals(this.f1230o)) {
                this.f1231p.getClass();
                t tVar = new t(this.f1231p);
                tVar.J(this.f1231p.length - 4);
                this.f1237v = tVar.B();
            }
            this.f1235t = true;
        }
        ByteBuffer byteBuffer3 = simpleDecoderOutputBuffer.f1228w;
        byteBuffer3.getClass();
        byteBuffer3.position(0);
        byteBuffer3.limit(iFfmpegDecode);
        return null;
    }

    public final String k() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.f1230o;
    }

    @Override // e2.j, e2.d
    public final void release() {
        super.release();
        ffmpegRelease(this.f1234s);
        this.f1234s = 0L;
    }
}
