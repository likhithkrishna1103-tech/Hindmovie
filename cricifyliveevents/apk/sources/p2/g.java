package p2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import g2.i0;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f9906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f9907c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaFormat f9911h;
    public MediaFormat i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MediaCodec.CodecException f9912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MediaCodec.CryptoException f9913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f9914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IllegalStateException f9916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m2.e f9917o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9905a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v.g f9908d = new v.g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v.g f9909e = new v.g();
    public final ArrayDeque f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque f9910g = new ArrayDeque();

    public g(HandlerThread handlerThread) {
        this.f9906b = handlerThread;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.f9910g;
        if (!arrayDeque.isEmpty()) {
            this.i = (MediaFormat) arrayDeque.getLast();
        }
        v.g gVar = this.f9908d;
        gVar.f12525b = gVar.f12524a;
        v.g gVar2 = this.f9909e;
        gVar2.f12525b = gVar2.f12524a;
        this.f.clear();
        arrayDeque.clear();
    }

    public final void b(IllegalStateException illegalStateException) {
        synchronized (this.f9905a) {
            this.f9916n = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f9905a) {
            this.f9913k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f9905a) {
            this.f9912j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        i0 i0Var;
        synchronized (this.f9905a) {
            this.f9908d.a(i);
            m2.e eVar = this.f9917o;
            if (eVar != null && (i0Var = ((r) eVar.f8050v).f9948c0) != null) {
                i0Var.a();
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        i0 i0Var;
        synchronized (this.f9905a) {
            try {
                MediaFormat mediaFormat = this.i;
                if (mediaFormat != null) {
                    this.f9909e.a(-2);
                    this.f9910g.add(mediaFormat);
                    this.i = null;
                }
                this.f9909e.a(i);
                this.f.add(bufferInfo);
                m2.e eVar = this.f9917o;
                if (eVar != null && (i0Var = ((r) eVar.f8050v).f9948c0) != null) {
                    i0Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f9905a) {
            this.f9909e.a(-2);
            this.f9910g.add(mediaFormat);
            this.i = null;
        }
    }
}
