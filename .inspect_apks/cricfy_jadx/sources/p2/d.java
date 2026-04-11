package p2;

import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.HashSet;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements l {
    public int A = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final MediaCodec f9888v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final g f9889w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final m f9890x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l7.a f9891y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9892z;

    public d(MediaCodec mediaCodec, HandlerThread handlerThread, m mVar, l7.a aVar) {
        this.f9888v = mediaCodec;
        this.f9889w = new g(handlerThread);
        this.f9890x = mVar;
        this.f9891y = aVar;
    }

    public static void d(d dVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        l7.a aVar;
        LoudnessCodecController loudnessCodecController;
        g gVar = dVar.f9889w;
        MediaCodec mediaCodec = dVar.f9888v;
        HandlerThread handlerThread = gVar.f9906b;
        y1.d.g(gVar.f9907c == null);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        mediaCodec.setCallback(gVar, handler);
        gVar.f9907c = handler;
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, mediaCrypto, i);
        Trace.endSection();
        dVar.f9890x.start();
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        if (Build.VERSION.SDK_INT >= 35 && (aVar = dVar.f9891y) != null && ((loudnessCodecController = (LoudnessCodecController) aVar.f7868y) == null || loudnessCodecController.addMediaCodec(mediaCodec))) {
            y1.d.g(((HashSet) aVar.f7866w).add(mediaCodec));
        }
        dVar.A = 1;
    }

    public static String g(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // p2.l
    public final void a(Bundle bundle) {
        this.f9890x.a(bundle);
    }

    @Override // p2.l
    public final void b(int i, e2.c cVar, long j4, int i10) {
        this.f9890x.b(i, cVar, j4, i10);
    }

    @Override // p2.l
    public final void c(int i, int i10, long j4, int i11) {
        this.f9890x.c(i, i10, j4, i11);
    }

    @Override // p2.l
    public final int e(MediaCodec.BufferInfo bufferInfo) {
        this.f9890x.d();
        g gVar = this.f9889w;
        synchronized (gVar.f9905a) {
            try {
                IllegalStateException illegalStateException = gVar.f9916n;
                if (illegalStateException != null) {
                    gVar.f9916n = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = gVar.f9912j;
                if (codecException != null) {
                    gVar.f9912j = null;
                    throw codecException;
                }
                MediaCodec.CryptoException cryptoException = gVar.f9913k;
                if (cryptoException != null) {
                    gVar.f9913k = null;
                    throw cryptoException;
                }
                if (gVar.f9914l > 0 || gVar.f9915m) {
                    return -1;
                }
                v.g gVar2 = gVar.f9909e;
                int i = gVar2.f12524a;
                int i10 = gVar2.f12525b;
                if (i == i10) {
                    return -1;
                }
                if (i == i10) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i11 = gVar2.f12526c[i];
                gVar2.f12524a = gVar2.f12527d & (i + 1);
                if (i11 >= 0) {
                    y1.d.h(gVar.f9911h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) gVar.f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (i11 == -2) {
                    gVar.f9911h = (MediaFormat) gVar.f9910g.remove();
                }
                return i11;
            } finally {
            }
        }
    }

    @Override // p2.l
    public final void f(int i) {
        this.f9888v.releaseOutputBuffer(i, false);
    }

    @Override // p2.l
    public final void flush() {
        this.f9890x.flush();
        this.f9888v.flush();
        g gVar = this.f9889w;
        synchronized (gVar.f9905a) {
            gVar.f9914l++;
            Handler handler = gVar.f9907c;
            int i = a0.f14551a;
            handler.post(new androidx.emoji2.text.w(29, gVar));
        }
        this.f9888v.start();
    }

    @Override // p2.l
    public final void h(int i) {
        this.f9888v.setVideoScalingMode(i);
    }

    @Override // p2.l
    public final boolean i(m2.e eVar) {
        g gVar = this.f9889w;
        synchronized (gVar.f9905a) {
            gVar.f9917o = eVar;
        }
        return true;
    }

    @Override // p2.l
    public final void l(y2.i iVar, Handler handler) {
        this.f9888v.setOnFrameRenderedListener(new b(this, iVar, 0), handler);
    }

    @Override // p2.l
    public final MediaFormat m() {
        MediaFormat mediaFormat;
        g gVar = this.f9889w;
        synchronized (gVar.f9905a) {
            try {
                mediaFormat = gVar.f9911h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    @Override // p2.l
    public final void n() {
        this.f9888v.detachOutputSurface();
    }

    @Override // p2.l
    public final ByteBuffer o(int i) {
        return this.f9888v.getInputBuffer(i);
    }

    @Override // p2.l
    public final void p(Surface surface) {
        this.f9888v.setOutputSurface(surface);
    }

    @Override // p2.l
    public final ByteBuffer q(int i) {
        return this.f9888v.getOutputBuffer(i);
    }

    @Override // p2.l
    public final void r(int i, long j4) {
        this.f9888v.releaseOutputBuffer(i, j4);
    }

    @Override // p2.l
    public final void release() {
        l7.a aVar;
        l7.a aVar2;
        try {
            if (this.A == 1) {
                this.f9890x.shutdown();
                g gVar = this.f9889w;
                synchronized (gVar.f9905a) {
                    gVar.f9915m = true;
                    gVar.f9906b.quit();
                    gVar.a();
                }
            }
            this.A = 2;
            if (this.f9892z) {
                return;
            }
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 30 && i < 33) {
                    this.f9888v.stop();
                }
                if (i >= 35 && (aVar2 = this.f9891y) != null) {
                    aVar2.H(this.f9888v);
                }
                this.f9888v.release();
                this.f9892z = true;
            } finally {
            }
        } catch (Throwable th) {
            if (!this.f9892z) {
                try {
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30 && i10 < 33) {
                        this.f9888v.stop();
                    }
                    if (i10 >= 35 && (aVar = this.f9891y) != null) {
                        aVar.H(this.f9888v);
                    }
                    this.f9888v.release();
                    this.f9892z = true;
                } finally {
                }
            }
            throw th;
        }
    }

    @Override // p2.l
    public final int t() {
        this.f9890x.d();
        g gVar = this.f9889w;
        synchronized (gVar.f9905a) {
            try {
                IllegalStateException illegalStateException = gVar.f9916n;
                if (illegalStateException != null) {
                    gVar.f9916n = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = gVar.f9912j;
                if (codecException != null) {
                    gVar.f9912j = null;
                    throw codecException;
                }
                MediaCodec.CryptoException cryptoException = gVar.f9913k;
                if (cryptoException != null) {
                    gVar.f9913k = null;
                    throw cryptoException;
                }
                int i = -1;
                if (gVar.f9914l > 0 || gVar.f9915m) {
                    return -1;
                }
                v.g gVar2 = gVar.f9908d;
                int i10 = gVar2.f12524a;
                int i11 = gVar2.f12525b;
                if (!(i10 == i11)) {
                    if (i10 == i11) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    i = gVar2.f12526c[i10];
                    gVar2.f12524a = (i10 + 1) & gVar2.f12527d;
                }
                return i;
            } finally {
            }
        }
    }
}
