package j2;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import cc.q0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayDeque f6683g = new ArrayDeque();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f6684h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f6685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f6686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q0 f6687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f6688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s1.g f6689e;
    public boolean f;

    public g(MediaCodec mediaCodec, HandlerThread handlerThread) {
        s1.g gVar = new s1.g();
        this.f6685a = mediaCodec;
        this.f6686b = handlerThread;
        this.f6689e = gVar;
        this.f6688d = new AtomicReference();
    }

    public static f d() {
        ArrayDeque arrayDeque = f6683g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new f();
                }
                return (f) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void e(f fVar) {
        ArrayDeque arrayDeque = f6683g;
        synchronized (arrayDeque) {
            arrayDeque.add(fVar);
        }
    }

    @Override // j2.n
    public final void a(int i, y1.c cVar, long j5, int i10) {
        c();
        f fVarD = d();
        fVarD.f6678a = i;
        fVarD.f6679b = 0;
        fVarD.f6681d = j5;
        fVarD.f6682e = i10;
        MediaCodec.CryptoInfo cryptoInfo = fVarD.f6680c;
        cryptoInfo.numSubSamples = cVar.f;
        int[] iArr = cVar.f14461d;
        int[] iArrCopyOf = cryptoInfo.numBytesOfClearData;
        if (iArr != null) {
            if (iArrCopyOf == null || iArrCopyOf.length < iArr.length) {
                iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            } else {
                System.arraycopy(iArr, 0, iArrCopyOf, 0, iArr.length);
            }
        }
        cryptoInfo.numBytesOfClearData = iArrCopyOf;
        int[] iArr2 = cVar.f14462e;
        int[] iArrCopyOf2 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr2 != null) {
            if (iArrCopyOf2 == null || iArrCopyOf2.length < iArr2.length) {
                iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
            } else {
                System.arraycopy(iArr2, 0, iArrCopyOf2, 0, iArr2.length);
            }
        }
        cryptoInfo.numBytesOfEncryptedData = iArrCopyOf2;
        byte[] bArr = cVar.f14459b;
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
        byte[] bArr2 = cVar.f14458a;
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
        cryptoInfo.mode = cVar.f14460c;
        if (Build.VERSION.SDK_INT >= 24) {
            e.p();
            cryptoInfo.setPattern(e.d(cVar.f14463g, cVar.f14464h));
        }
        q0 q0Var = this.f6687c;
        int i11 = b0.f11647a;
        q0Var.obtainMessage(2, fVarD).sendToTarget();
    }

    @Override // j2.n
    public final void b(Bundle bundle) {
        c();
        q0 q0Var = this.f6687c;
        int i = b0.f11647a;
        q0Var.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // j2.n
    public final void c() {
        RuntimeException runtimeException = (RuntimeException) this.f6688d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // j2.n
    public final void f(int i, int i10, long j5, int i11) {
        c();
        f fVarD = d();
        fVarD.f6678a = i;
        fVarD.f6679b = i10;
        fVarD.f6681d = j5;
        fVarD.f6682e = i11;
        q0 q0Var = this.f6687c;
        int i12 = b0.f11647a;
        q0Var.obtainMessage(1, fVarD).sendToTarget();
    }

    @Override // j2.n
    public final void flush() {
        if (this.f) {
            try {
                q0 q0Var = this.f6687c;
                q0Var.getClass();
                q0Var.removeCallbacksAndMessages(null);
                s1.g gVar = this.f6689e;
                synchronized (gVar) {
                    gVar.f11670b = false;
                }
                q0 q0Var2 = this.f6687c;
                q0Var2.getClass();
                q0Var2.obtainMessage(3).sendToTarget();
                gVar.a();
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e10);
            }
        }
    }

    @Override // j2.n
    public final void shutdown() {
        if (this.f) {
            flush();
            this.f6686b.quit();
        }
        this.f = false;
    }

    @Override // j2.n
    public final void start() {
        if (this.f) {
            return;
        }
        HandlerThread handlerThread = this.f6686b;
        handlerThread.start();
        this.f6687c = new q0(this, handlerThread.getLooper(), 6);
        this.f = true;
    }
}
