package androidx.media3.decoder.av1;

import android.view.Surface;
import androidx.fragment.app.f1;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import e2.d;
import f2.a;
import f2.b;
import f2.c;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class Dav1dDecoder implements d {
    private static final int DAV1D_DECODE_ONLY = 2;
    private static final int DAV1D_EAGAIN = 3;
    private static final int DAV1D_ERROR = 0;
    private static final int DAV1D_OK = 1;
    private int availableInputBufferCount;
    private final DecoderInputBuffer[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final VideoDecoderOutputBuffer[] availableOutputBuffers;
    private long dav1dDecoderContext;
    private final Thread decodeThread;
    private DecoderInputBuffer dequeuedInputBuffer;
    private b exception;
    private boolean flushed;
    private final Object lock;
    private volatile int outputMode;
    private long outputStartTimeUs;
    private final ArrayDeque<DecoderInputBuffer> queuedInputBuffers;
    private final ArrayDeque<VideoDecoderOutputBuffer> queuedOutputBuffers;
    private boolean released;
    private int skippedOutputBufferCount;
    private Surface surface;

    public Dav1dDecoder(int i, int i10, int i11, int i12, int i13, boolean z10) throws b {
        boolean zA;
        try {
            zA = c.f3933a.a();
        } catch (Exception unused) {
            zA = false;
        }
        if (!zA) {
            throw new b("Failed to load decoder native library.");
        }
        this.lock = new Object();
        this.outputStartTimeUs = -9223372036854775807L;
        this.queuedInputBuffers = new ArrayDeque<>();
        this.queuedOutputBuffers = new ArrayDeque<>();
        this.availableInputBuffers = new DecoderInputBuffer[i];
        this.availableInputBufferCount = i;
        for (int i14 = 0; i14 < this.availableInputBufferCount; i14++) {
            this.availableInputBuffers[i14] = new DecoderInputBuffer(2);
            this.availableInputBuffers[i14].ensureSpaceForWrite(i11);
        }
        this.availableOutputBuffers = new VideoDecoderOutputBuffer[i10];
        this.availableOutputBufferCount = i10;
        for (int i15 = 0; i15 < this.availableOutputBufferCount; i15++) {
            this.availableOutputBuffers[i15] = new VideoDecoderOutputBuffer(new f1(7, this));
        }
        a aVar = new a(this, i12, i13, z10);
        this.decodeThread = aVar;
        aVar.start();
        maybeThrowException();
    }

    private boolean canDecodeInputBuffer() {
        return !this.queuedInputBuffers.isEmpty();
    }

    private boolean canDecodeOutputBuffer() {
        return this.availableOutputBufferCount > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int dav1dCheckError(long j4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void dav1dClose(long j4);

    private native int dav1dDecode(long j4, DecoderInputBuffer decoderInputBuffer, int i, int i10, boolean z10, int i11, long j7, int i12);

    private native void dav1dFlush(long j4);

    /* JADX INFO: Access modifiers changed from: private */
    public native String dav1dGetErrorMessage(long j4);

    private native int dav1dGetFrame(long j4, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native long dav1dInit(int i, int i10, boolean z10);

    private native void dav1dReleaseFrame(long j4, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    private native int dav1dRenderFrame(long j4, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer);

    private boolean decode() {
        Dav1dDecoder dav1dDecoder;
        int iDav1dGetFrame;
        synchronized (this.lock) {
            try {
                if (this.flushed) {
                    flushInternal();
                }
                while (!this.released && ((!canDecodeInputBuffer() || !canDecodeOutputBuffer()) && !this.flushed)) {
                    this.lock.wait();
                }
                if (this.released) {
                    return false;
                }
                if (this.flushed) {
                    flushInternal();
                    return true;
                }
                DecoderInputBuffer decoderInputBufferRemoveFirst = this.queuedInputBuffers.removeFirst();
                VideoDecoderOutputBuffer[] videoDecoderOutputBufferArr = this.availableOutputBuffers;
                int i = this.availableOutputBufferCount - 1;
                this.availableOutputBufferCount = i;
                VideoDecoderOutputBuffer videoDecoderOutputBuffer = videoDecoderOutputBufferArr[i];
                if (decoderInputBufferRemoveFirst.isEndOfStream()) {
                    videoDecoderOutputBuffer.addFlag(4);
                    releaseInputBuffer(decoderInputBufferRemoveFirst);
                    synchronized (this.lock) {
                        try {
                            if (this.flushed) {
                                videoDecoderOutputBuffer.release();
                                flushInternal();
                            } else {
                                videoDecoderOutputBuffer.skippedOutputBufferCount = this.skippedOutputBufferCount;
                                this.skippedOutputBufferCount = 0;
                                this.queuedOutputBuffers.addLast(videoDecoderOutputBuffer);
                            }
                        } finally {
                        }
                    }
                    dav1dDecoder = this;
                } else {
                    boolean z10 = !isAtLeastOutputStartTimeUs(decoderInputBufferRemoveFirst.timeUs);
                    int i10 = decoderInputBufferRemoveFirst.isFirstSample() ? 134217728 : 0;
                    try {
                        ByteBuffer byteBuffer = decoderInputBufferRemoveFirst.data;
                        int i11 = a0.f14551a;
                        dav1dDecoder = this;
                        try {
                            if (dav1dDecoder.dav1dDecode(this.dav1dDecoderContext, decoderInputBufferRemoveFirst, byteBuffer.position(), byteBuffer.remaining(), z10, i10, decoderInputBufferRemoveFirst.timeUs, this.outputMode) == 0) {
                                throw new b("dav1dDecode error: " + dav1dGetErrorMessage(dav1dDecoder.dav1dDecoderContext));
                            }
                            while (true) {
                                iDav1dGetFrame = dav1dGetFrame(dav1dDecoder.dav1dDecoderContext, videoDecoderOutputBuffer);
                                if (iDav1dGetFrame != 1 && iDav1dGetFrame != 2) {
                                    break;
                                }
                                if (iDav1dGetFrame == 2) {
                                    videoDecoderOutputBuffer.shouldBeSkipped = true;
                                }
                                synchronized (dav1dDecoder.lock) {
                                    if (dav1dDecoder.flushed) {
                                        videoDecoderOutputBuffer.release();
                                        flushInternal();
                                    } else {
                                        if (!isAtLeastOutputStartTimeUs(videoDecoderOutputBuffer.timeUs) || videoDecoderOutputBuffer.shouldBeSkipped) {
                                            dav1dDecoder.skippedOutputBufferCount++;
                                            videoDecoderOutputBuffer.release();
                                        } else {
                                            videoDecoderOutputBuffer.skippedOutputBufferCount = dav1dDecoder.skippedOutputBufferCount;
                                            dav1dDecoder.skippedOutputBufferCount = 0;
                                            dav1dDecoder.queuedOutputBuffers.addLast(videoDecoderOutputBuffer);
                                        }
                                        while (!dav1dDecoder.released && !canDecodeOutputBuffer() && !dav1dDecoder.flushed) {
                                            dav1dDecoder.lock.wait();
                                        }
                                        if (dav1dDecoder.released) {
                                            return false;
                                        }
                                        if (dav1dDecoder.flushed) {
                                            flushInternal();
                                            return true;
                                        }
                                        VideoDecoderOutputBuffer[] videoDecoderOutputBufferArr2 = dav1dDecoder.availableOutputBuffers;
                                        int i12 = dav1dDecoder.availableOutputBufferCount - 1;
                                        dav1dDecoder.availableOutputBufferCount = i12;
                                        videoDecoderOutputBuffer = videoDecoderOutputBufferArr2[i12];
                                    }
                                }
                                break;
                            }
                            if (iDav1dGetFrame == 0) {
                                throw new b("dav1dGetFrame error: " + dav1dGetErrorMessage(dav1dDecoder.dav1dDecoderContext));
                            }
                            if (iDav1dGetFrame == 3) {
                                videoDecoderOutputBuffer.release();
                            }
                            e = null;
                        } catch (b e9) {
                            e = e9;
                        } catch (OutOfMemoryError e10) {
                            e = e10;
                            e = createUnexpectedDecodeException(e);
                        } catch (RuntimeException e11) {
                            e = e11;
                            e = createUnexpectedDecodeException(e);
                        }
                    } catch (b e12) {
                        e = e12;
                        dav1dDecoder = this;
                    } catch (OutOfMemoryError e13) {
                        e = e13;
                        dav1dDecoder = this;
                    } catch (RuntimeException e14) {
                        e = e14;
                        dav1dDecoder = this;
                    }
                    if (e != null) {
                        synchronized (dav1dDecoder.lock) {
                            dav1dDecoder.exception = e;
                        }
                        return false;
                    }
                }
                releaseUnusedInputBuffers(dav1dDecoder.dav1dDecoderContext, this);
                return true;
            } finally {
                th = th;
                while (true) {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            }
        }
    }

    private void flushInternal() {
        this.skippedOutputBufferCount = 0;
        DecoderInputBuffer decoderInputBuffer = this.dequeuedInputBuffer;
        if (decoderInputBuffer != null) {
            releaseInputBufferInternal(decoderInputBuffer);
            this.dequeuedInputBuffer = null;
        }
        while (!this.queuedInputBuffers.isEmpty()) {
            releaseInputBufferInternal(this.queuedInputBuffers.removeFirst());
        }
        while (!this.queuedOutputBuffers.isEmpty()) {
            this.queuedOutputBuffers.removeFirst().release();
        }
        dav1dFlush(this.dav1dDecoderContext);
        this.flushed = false;
    }

    private void maybeNotifyDecodeLoop() {
        if (canDecodeInputBuffer() || canDecodeOutputBuffer()) {
            this.lock.notify();
        }
    }

    private void maybeThrowException() throws b {
        b bVar = this.exception;
        if (bVar != null) {
            throw bVar;
        }
    }

    private void releaseInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.lock) {
            releaseInputBufferInternal(decoderInputBuffer);
        }
    }

    private void releaseInputBufferInternal(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.clear();
        DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
        int i = this.availableInputBufferCount;
        this.availableInputBufferCount = i + 1;
        decoderInputBufferArr[i] = decoderInputBuffer;
    }

    private void releaseOutputBufferInternal(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        videoDecoderOutputBuffer.clear();
        VideoDecoderOutputBuffer[] videoDecoderOutputBufferArr = this.availableOutputBuffers;
        int i = this.availableOutputBufferCount;
        this.availableOutputBufferCount = i + 1;
        videoDecoderOutputBufferArr[i] = videoDecoderOutputBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void releaseUnusedInputBuffers(long j4, Dav1dDecoder dav1dDecoder);

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (InterruptedException e9) {
                throw new IllegalStateException(e9);
            }
        } while (decode());
    }

    public b createUnexpectedDecodeException(Throwable th) {
        return new b("Unexpected decode error", th);
    }

    @Override // e2.d
    public final void flush() {
        synchronized (this.lock) {
            this.flushed = true;
            this.lock.notify();
        }
    }

    public String getName() {
        return "libdav1d";
    }

    public final boolean isAtLeastOutputStartTimeUs(long j4) {
        boolean z10;
        synchronized (this.lock) {
            long j7 = this.outputStartTimeUs;
            z10 = j7 == -9223372036854775807L || j4 >= j7;
        }
        return z10;
    }

    @Override // e2.d
    public void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public void releaseOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        synchronized (this.lock) {
            dav1dReleaseFrame(this.dav1dDecoderContext, videoDecoderOutputBuffer);
            releaseOutputBufferInternal(videoDecoderOutputBuffer);
            maybeNotifyDecodeLoop();
        }
    }

    public void renderToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws b {
        if (this.outputMode != 1) {
            throw new b("Unsupported Output Mode.");
        }
        if (dav1dRenderFrame(this.dav1dDecoderContext, surface, videoDecoderOutputBuffer) != 1) {
            throw new b("Failed to render output buffer to surface.");
        }
    }

    public void setOutputMode(int i) {
        this.outputMode = i;
    }

    @Override // e2.d
    public final void setOutputStartTimeUs(long j4) {
        synchronized (this.lock) {
            this.outputStartTimeUs = j4;
        }
    }

    @Override // e2.d
    public final DecoderInputBuffer dequeueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.lock) {
            try {
                maybeThrowException();
                if (this.dequeuedInputBuffer != null && !this.flushed) {
                    throw new IllegalStateException();
                }
                int i = this.availableInputBufferCount;
                if (i == 0 || this.flushed) {
                    decoderInputBuffer = null;
                } else {
                    DecoderInputBuffer[] decoderInputBufferArr = this.availableInputBuffers;
                    int i10 = i - 1;
                    this.availableInputBufferCount = i10;
                    decoderInputBuffer = decoderInputBufferArr[i10];
                }
                this.dequeuedInputBuffer = decoderInputBuffer;
            } catch (Throwable th) {
                throw th;
            }
        }
        return decoderInputBuffer;
    }

    @Override // e2.d
    public final VideoDecoderOutputBuffer dequeueOutputBuffer() {
        synchronized (this.lock) {
            try {
                maybeThrowException();
                if (!this.queuedOutputBuffers.isEmpty() && !this.flushed) {
                    return this.queuedOutputBuffers.removeFirst();
                }
                return null;
            } finally {
            }
        }
    }

    @Override // e2.d
    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.lock) {
            try {
                maybeThrowException();
                if (decoderInputBuffer != this.dequeuedInputBuffer) {
                    throw new IllegalArgumentException();
                }
                this.queuedInputBuffers.addLast(decoderInputBuffer);
                maybeNotifyDecodeLoop();
                this.dequeuedInputBuffer = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
