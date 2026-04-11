package j2;

import a2.r0;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f6691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f6692c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaFormat f6696h;
    public MediaFormat i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MediaCodec.CodecException f6697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MediaCodec.CryptoException f6698k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f6699l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IllegalStateException f6701n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public u5.c f6702o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6690a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q4.k f6693d = new q4.k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q4.k f6694e = new q4.k();
    public final ArrayDeque f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque f6695g = new ArrayDeque();

    public h(HandlerThread handlerThread) {
        this.f6691b = handlerThread;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.f6695g;
        if (!arrayDeque.isEmpty()) {
            this.i = (MediaFormat) arrayDeque.getLast();
        }
        q4.k kVar = this.f6693d;
        kVar.f10861c = kVar.f10860b;
        q4.k kVar2 = this.f6694e;
        kVar2.f10861c = kVar2.f10860b;
        this.f.clear();
        arrayDeque.clear();
    }

    public final void b(IllegalStateException illegalStateException) {
        synchronized (this.f6690a) {
            this.f6701n = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f6690a) {
            this.f6698k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f6690a) {
            this.f6697j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        r0 r0Var;
        synchronized (this.f6690a) {
            this.f6693d.a(i);
            u5.c cVar = this.f6702o;
            if (cVar != null && (r0Var = ((s) cVar.f12782v).f6730b0) != null) {
                r0Var.a();
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        r0 r0Var;
        synchronized (this.f6690a) {
            try {
                MediaFormat mediaFormat = this.i;
                if (mediaFormat != null) {
                    this.f6694e.a(-2);
                    this.f6695g.add(mediaFormat);
                    this.i = null;
                }
                this.f6694e.a(i);
                this.f.add(bufferInfo);
                u5.c cVar = this.f6702o;
                if (cVar != null && (r0Var = ((s) cVar.f12782v).f6730b0) != null) {
                    r0Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f6690a) {
            this.f6694e.a(-2);
            this.f6695g.add(mediaFormat);
            this.i = null;
        }
    }
}
