package j2;

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
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements m {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MediaCodec f6672u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f6673v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final n f6674w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a7.b f6675x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6676y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6677z = 0;

    public d(MediaCodec mediaCodec, HandlerThread handlerThread, n nVar, a7.b bVar) {
        this.f6672u = mediaCodec;
        this.f6673v = new h(handlerThread);
        this.f6674w = nVar;
        this.f6675x = bVar;
    }

    public static void c(d dVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        a7.b bVar;
        LoudnessCodecController loudnessCodecController;
        h hVar = dVar.f6673v;
        MediaCodec mediaCodec = dVar.f6672u;
        HandlerThread handlerThread = hVar.f6691b;
        s1.d.g(hVar.f6692c == null);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        mediaCodec.setCallback(hVar, handler);
        hVar.f6692c = handler;
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, mediaCrypto, i);
        Trace.endSection();
        dVar.f6674w.start();
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        if (Build.VERSION.SDK_INT >= 35 && (bVar = dVar.f6675x) != null && ((loudnessCodecController = (LoudnessCodecController) bVar.f620x) == null || loudnessCodecController.addMediaCodec(mediaCodec))) {
            s1.d.g(((HashSet) bVar.f618v).add(mediaCodec));
        }
        dVar.f6677z = 1;
    }

    public static String d(String str, int i) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i == 1) {
            sb2.append("Audio");
        } else if (i == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i);
            sb2.append(")");
        }
        return sb2.toString();
    }

    @Override // j2.m
    public final int A() {
        this.f6674w.c();
        h hVar = this.f6673v;
        synchronized (hVar.f6690a) {
            try {
                IllegalStateException illegalStateException = hVar.f6701n;
                if (illegalStateException != null) {
                    hVar.f6701n = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = hVar.f6697j;
                if (codecException != null) {
                    hVar.f6697j = null;
                    throw codecException;
                }
                MediaCodec.CryptoException cryptoException = hVar.f6698k;
                if (cryptoException != null) {
                    hVar.f6698k = null;
                    throw cryptoException;
                }
                int i = -1;
                if (hVar.f6699l > 0 || hVar.f6700m) {
                    return -1;
                }
                q4.k kVar = hVar.f6693d;
                int i10 = kVar.f10860b;
                int i11 = kVar.f10861c;
                if (!(i10 == i11)) {
                    if (i10 == i11) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    i = kVar.f10859a[i10];
                    kVar.f10860b = (i10 + 1) & kVar.f10862d;
                }
                return i;
            } finally {
            }
        }
    }

    @Override // j2.m
    public final void a(int i, y1.c cVar, long j5, int i10) {
        this.f6674w.a(i, cVar, j5, i10);
    }

    @Override // j2.m
    public final void b(Bundle bundle) {
        this.f6674w.b(bundle);
    }

    @Override // j2.m
    public final void f(int i, int i10, long j5, int i11) {
        this.f6674w.f(i, i10, j5, i11);
    }

    @Override // j2.m
    public final void flush() {
        this.f6674w.flush();
        this.f6672u.flush();
        h hVar = this.f6673v;
        synchronized (hVar.f6690a) {
            hVar.f6699l++;
            Handler handler = hVar.f6692c;
            int i = b0.f11647a;
            handler.post(new a2.a(25, hVar));
        }
        this.f6672u.start();
    }

    @Override // j2.m
    public final int g(MediaCodec.BufferInfo bufferInfo) {
        this.f6674w.c();
        h hVar = this.f6673v;
        synchronized (hVar.f6690a) {
            try {
                IllegalStateException illegalStateException = hVar.f6701n;
                if (illegalStateException != null) {
                    hVar.f6701n = null;
                    throw illegalStateException;
                }
                MediaCodec.CodecException codecException = hVar.f6697j;
                if (codecException != null) {
                    hVar.f6697j = null;
                    throw codecException;
                }
                MediaCodec.CryptoException cryptoException = hVar.f6698k;
                if (cryptoException != null) {
                    hVar.f6698k = null;
                    throw cryptoException;
                }
                if (hVar.f6699l > 0 || hVar.f6700m) {
                    return -1;
                }
                q4.k kVar = hVar.f6694e;
                int i = kVar.f10860b;
                int i10 = kVar.f10861c;
                if (i == i10) {
                    return -1;
                }
                if (i == i10) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i11 = kVar.f10859a[i];
                kVar.f10860b = kVar.f10862d & (i + 1);
                if (i11 >= 0) {
                    s1.d.h(hVar.f6696h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) hVar.f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (i11 == -2) {
                    hVar.f6696h = (MediaFormat) hVar.f6695g.remove();
                }
                return i11;
            } finally {
            }
        }
    }

    @Override // j2.m
    public final boolean h(u5.c cVar) {
        h hVar = this.f6673v;
        synchronized (hVar.f6690a) {
            hVar.f6702o = cVar;
        }
        return true;
    }

    @Override // j2.m
    public final void i(int i) {
        this.f6672u.releaseOutputBuffer(i, false);
    }

    @Override // j2.m
    public final void m(int i) {
        this.f6672u.setVideoScalingMode(i);
    }

    @Override // j2.m
    public final void n(u2.i iVar, Handler handler) {
        this.f6672u.setOnFrameRenderedListener(new b(this, iVar, 0), handler);
    }

    @Override // j2.m
    public final MediaFormat q() {
        MediaFormat mediaFormat;
        h hVar = this.f6673v;
        synchronized (hVar.f6690a) {
            try {
                mediaFormat = hVar.f6696h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    @Override // j2.m
    public final void release() {
        a7.b bVar;
        a7.b bVar2;
        try {
            if (this.f6677z == 1) {
                this.f6674w.shutdown();
                h hVar = this.f6673v;
                synchronized (hVar.f6690a) {
                    hVar.f6700m = true;
                    hVar.f6691b.quit();
                    hVar.a();
                }
            }
            this.f6677z = 2;
            if (this.f6676y) {
                return;
            }
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 30 && i < 33) {
                    this.f6672u.stop();
                }
                if (i >= 35 && (bVar2 = this.f6675x) != null) {
                    bVar2.B(this.f6672u);
                }
                this.f6672u.release();
                this.f6676y = true;
            } finally {
            }
        } catch (Throwable th) {
            if (!this.f6676y) {
                try {
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30 && i10 < 33) {
                        this.f6672u.stop();
                    }
                    if (i10 >= 35 && (bVar = this.f6675x) != null) {
                        bVar.B(this.f6672u);
                    }
                    this.f6672u.release();
                    this.f6676y = true;
                } finally {
                }
            }
            throw th;
        }
    }

    @Override // j2.m
    public final void s() {
        this.f6672u.detachOutputSurface();
    }

    @Override // j2.m
    public final ByteBuffer t(int i) {
        return this.f6672u.getInputBuffer(i);
    }

    @Override // j2.m
    public final void u(Surface surface) {
        this.f6672u.setOutputSurface(surface);
    }

    @Override // j2.m
    public final ByteBuffer v(int i) {
        return this.f6672u.getOutputBuffer(i);
    }

    @Override // j2.m
    public final void z(int i, long j5) {
        this.f6672u.releaseOutputBuffer(i, j5);
    }
}
