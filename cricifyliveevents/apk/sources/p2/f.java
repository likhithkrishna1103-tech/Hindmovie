package p2;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayDeque f9898g = new ArrayDeque();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f9899h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f9900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f9901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h.d f9902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f9903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y1.g f9904e;
    public boolean f;

    public f(MediaCodec mediaCodec, HandlerThread handlerThread) {
        y1.g gVar = new y1.g();
        this.f9900a = mediaCodec;
        this.f9901b = handlerThread;
        this.f9904e = gVar;
        this.f9903d = new AtomicReference();
    }

    public static e e() {
        ArrayDeque arrayDeque = f9898g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new e();
                }
                return (e) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void f(e eVar) {
        ArrayDeque arrayDeque = f9898g;
        synchronized (arrayDeque) {
            arrayDeque.add(eVar);
        }
    }

    @Override // p2.m
    public final void a(Bundle bundle) {
        d();
        h.d dVar = this.f9902c;
        int i = a0.f14551a;
        dVar.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // p2.m
    public final void b(int i, e2.c cVar, long j4, int i10) {
        d();
        e eVarE = e();
        eVarE.f9893a = i;
        eVarE.f9894b = 0;
        eVarE.f9896d = j4;
        eVarE.f9897e = i10;
        MediaCodec.CryptoInfo cryptoInfo = eVarE.f9895c;
        cryptoInfo.numSubSamples = cVar.f;
        int[] iArr = cVar.f3755d;
        int[] iArrCopyOf = cryptoInfo.numBytesOfClearData;
        if (iArr != null) {
            if (iArrCopyOf == null || iArrCopyOf.length < iArr.length) {
                iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            } else {
                System.arraycopy(iArr, 0, iArrCopyOf, 0, iArr.length);
            }
        }
        cryptoInfo.numBytesOfClearData = iArrCopyOf;
        int[] iArr2 = cVar.f3756e;
        int[] iArrCopyOf2 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr2 != null) {
            if (iArrCopyOf2 == null || iArrCopyOf2.length < iArr2.length) {
                iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
            } else {
                System.arraycopy(iArr2, 0, iArrCopyOf2, 0, iArr2.length);
            }
        }
        cryptoInfo.numBytesOfEncryptedData = iArrCopyOf2;
        byte[] bArr = cVar.f3753b;
        byte[] bArrCopyOf = cryptoInfo.key;
        if (bArr != null) {
            if (bArrCopyOf == null || bArrCopyOf.length < bArr.length) {
                bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            } else {
                System.arraycopy(bArr, 0, bArrCopyOf, 0, bArr.length);
            }
        }
        bArrCopyOf.getClass();
        cryptoInfo.key = bArrCopyOf;
        byte[] bArr2 = cVar.f3752a;
        byte[] bArrCopyOf2 = cryptoInfo.iv;
        if (bArr2 != null) {
            if (bArrCopyOf2 == null || bArrCopyOf2.length < bArr2.length) {
                bArrCopyOf2 = Arrays.copyOf(bArr2, bArr2.length);
            } else {
                System.arraycopy(bArr2, 0, bArrCopyOf2, 0, bArr2.length);
            }
        }
        bArrCopyOf2.getClass();
        cryptoInfo.iv = bArrCopyOf2;
        cryptoInfo.mode = cVar.f3754c;
        if (Build.VERSION.SDK_INT >= 24) {
            i2.a0.q();
            cryptoInfo.setPattern(i2.a0.e(cVar.f3757g, cVar.f3758h));
        }
        h.d dVar = this.f9902c;
        int i11 = a0.f14551a;
        dVar.obtainMessage(2, eVarE).sendToTarget();
    }

    @Override // p2.m
    public final void c(int i, int i10, long j4, int i11) {
        d();
        e eVarE = e();
        eVarE.f9893a = i;
        eVarE.f9894b = i10;
        eVarE.f9896d = j4;
        eVarE.f9897e = i11;
        h.d dVar = this.f9902c;
        int i12 = a0.f14551a;
        dVar.obtainMessage(1, eVarE).sendToTarget();
    }

    @Override // p2.m
    public final void d() {
        RuntimeException runtimeException = (RuntimeException) this.f9903d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // p2.m
    public final void flush() {
        if (this.f) {
            try {
                h.d dVar = this.f9902c;
                dVar.getClass();
                dVar.removeCallbacksAndMessages(null);
                y1.g gVar = this.f9904e;
                synchronized (gVar) {
                    gVar.f14576b = false;
                }
                h.d dVar2 = this.f9902c;
                dVar2.getClass();
                dVar2.obtainMessage(3).sendToTarget();
                gVar.a();
            } catch (InterruptedException e9) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e9);
            }
        }
    }

    @Override // p2.m
    public final void shutdown() {
        if (this.f) {
            flush();
            this.f9901b.quit();
        }
        this.f = false;
    }

    @Override // p2.m
    public final void start() {
        if (this.f) {
            return;
        }
        HandlerThread handlerThread = this.f9901b;
        handlerThread.start();
        this.f9902c = new h.d(this, handlerThread.getLooper(), 5);
        this.f = true;
    }
}
