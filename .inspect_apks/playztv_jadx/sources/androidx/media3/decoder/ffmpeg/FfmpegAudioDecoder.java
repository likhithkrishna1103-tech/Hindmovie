package androidx.media3.decoder.ffmpeg;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import s1.b0;
import s1.u;
import y1.h;
import y1.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
final class FfmpegAudioDecoder extends i {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f1533w = {102, 76, 97, 67};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f1534o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final byte[] f1535p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f1536q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1537r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1538s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1539t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile int f1540u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile int f1541v;

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
    public FfmpegAudioDecoder(int r18, p1.q r19, boolean r20) throws androidx.media3.decoder.ffmpeg.d {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.ffmpeg.FfmpegAudioDecoder.<init>(int, p1.q, boolean):void");
    }

    private native int ffmpegDecode(long j5, ByteBuffer byteBuffer, int i, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, ByteBuffer byteBuffer2, int i10);

    private native int ffmpegGetChannelCount(long j5);

    private native int ffmpegGetSampleRate(long j5);

    private native long ffmpegInitialize(String str, byte[] bArr, boolean z2, int i, int i10);

    private native void ffmpegRelease(long j5);

    private native long ffmpegReset(long j5, byte[] bArr);

    private ByteBuffer growOutputBuffer(SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, int i) {
        this.f1537r = i;
        ByteBuffer byteBuffer = simpleDecoderOutputBuffer.f1532v;
        byteBuffer.getClass();
        s1.d.b(i >= byteBuffer.limit());
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        int iPosition = byteBuffer.position();
        byteBuffer.position(0);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(iPosition);
        byteBufferOrder.limit(i);
        simpleDecoderOutputBuffer.f1532v = byteBufferOrder;
        return byteBufferOrder;
    }

    @Override // y1.i
    public final DecoderInputBuffer b() {
        return new DecoderInputBuffer(2, FfmpegLibrary.b());
    }

    @Override // y1.i
    public final h c() {
        return new SimpleDecoderOutputBuffer(new b(this));
    }

    @Override // y1.i
    public final y1.e d(Throwable th) {
        return new d("Unexpected decode error", th);
    }

    @Override // y1.i
    public final y1.e e(DecoderInputBuffer decoderInputBuffer, h hVar, boolean z2) {
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) hVar;
        if (z2) {
            long jFfmpegReset = ffmpegReset(this.f1538s, this.f1535p);
            this.f1538s = jFfmpegReset;
            if (jFfmpegReset == 0) {
                return new d("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        int i = b0.f11647a;
        int iLimit = byteBuffer.limit();
        long j5 = decoderInputBuffer.timeUs;
        int i10 = this.f1537r;
        simpleDecoderOutputBuffer.timeUs = j5;
        ByteBuffer byteBuffer2 = simpleDecoderOutputBuffer.f1532v;
        if (byteBuffer2 == null || byteBuffer2.capacity() < i10) {
            simpleDecoderOutputBuffer.f1532v = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        }
        simpleDecoderOutputBuffer.f1532v.position(0);
        simpleDecoderOutputBuffer.f1532v.limit(i10);
        int iFfmpegDecode = ffmpegDecode(this.f1538s, byteBuffer, iLimit, simpleDecoderOutputBuffer, simpleDecoderOutputBuffer.f1532v, this.f1537r);
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
        if (!this.f1539t) {
            this.f1540u = ffmpegGetChannelCount(this.f1538s);
            this.f1541v = ffmpegGetSampleRate(this.f1538s);
            if (this.f1541v == 0 && "alac".equals(this.f1534o)) {
                this.f1535p.getClass();
                u uVar = new u(this.f1535p);
                uVar.J(this.f1535p.length - 4);
                this.f1541v = uVar.B();
            }
            this.f1539t = true;
        }
        ByteBuffer byteBuffer3 = simpleDecoderOutputBuffer.f1532v;
        byteBuffer3.getClass();
        byteBuffer3.position(0);
        byteBuffer3.limit(iFfmpegDecode);
        return null;
    }

    public final String k() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.f1534o;
    }

    @Override // y1.i, y1.d
    public final void release() {
        super.release();
        ffmpegRelease(this.f1538s);
        this.f1538s = 0L;
    }
}
