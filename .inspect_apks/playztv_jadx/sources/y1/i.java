package y1;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n7.c f14466a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DecoderInputBuffer[] f14470e;
    public final h[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14472h;
    public DecoderInputBuffer i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f14473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14475l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14476m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14467b = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f14477n = -9223372036854775807L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f14468c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f14469d = new ArrayDeque();

    public i(DecoderInputBuffer[] decoderInputBufferArr, h[] hVarArr) {
        this.f14470e = decoderInputBufferArr;
        this.f14471g = decoderInputBufferArr.length;
        for (int i = 0; i < this.f14471g; i++) {
            this.f14470e[i] = b();
        }
        this.f = hVarArr;
        this.f14472h = hVarArr.length;
        for (int i10 = 0; i10 < this.f14472h; i10++) {
            this.f[i10] = c();
        }
        n7.c cVar = new n7.c(this);
        this.f14466a = cVar;
        cVar.start();
    }

    public abstract DecoderInputBuffer b();

    public abstract h c();

    public abstract e d(Throwable th);

    @Override // y1.d
    public final Object dequeueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.f14467b) {
            try {
                e eVar = this.f14473j;
                if (eVar != null) {
                    throw eVar;
                }
                s1.d.g(this.i == null);
                int i = this.f14471g;
                if (i == 0) {
                    decoderInputBuffer = null;
                } else {
                    DecoderInputBuffer[] decoderInputBufferArr = this.f14470e;
                    int i10 = i - 1;
                    this.f14471g = i10;
                    decoderInputBuffer = decoderInputBufferArr[i10];
                }
                this.i = decoderInputBuffer;
            } catch (Throwable th) {
                throw th;
            }
        }
        return decoderInputBuffer;
    }

    public abstract e e(DecoderInputBuffer decoderInputBuffer, h hVar, boolean z2);

    public final boolean f() {
        e eVarD;
        synchronized (this.f14467b) {
            while (!this.f14475l) {
                try {
                    if (!this.f14468c.isEmpty() && this.f14472h > 0) {
                        break;
                    }
                    this.f14467b.wait();
                } finally {
                }
            }
            if (this.f14475l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f14468c.removeFirst();
            h[] hVarArr = this.f;
            int i = this.f14472h - 1;
            this.f14472h = i;
            h hVar = hVarArr[i];
            boolean z2 = this.f14474k;
            this.f14474k = false;
            if (decoderInputBuffer.isEndOfStream()) {
                hVar.addFlag(4);
            } else {
                hVar.timeUs = decoderInputBuffer.timeUs;
                if (decoderInputBuffer.isFirstSample()) {
                    hVar.addFlag(134217728);
                }
                if (!h(decoderInputBuffer.timeUs)) {
                    hVar.shouldBeSkipped = true;
                }
                try {
                    eVarD = e(decoderInputBuffer, hVar, z2);
                } catch (OutOfMemoryError e10) {
                    eVarD = d(e10);
                } catch (RuntimeException e11) {
                    eVarD = d(e11);
                }
                if (eVarD != null) {
                    synchronized (this.f14467b) {
                        this.f14473j = eVarD;
                    }
                    return false;
                }
            }
            synchronized (this.f14467b) {
                try {
                    if (this.f14474k) {
                        hVar.release();
                    } else if (hVar.shouldBeSkipped) {
                        this.f14476m++;
                        hVar.release();
                    } else {
                        hVar.skippedOutputBufferCount = this.f14476m;
                        this.f14476m = 0;
                        this.f14469d.addLast(hVar);
                    }
                    decoderInputBuffer.clear();
                    DecoderInputBuffer[] decoderInputBufferArr = this.f14470e;
                    int i10 = this.f14471g;
                    this.f14471g = i10 + 1;
                    decoderInputBufferArr[i10] = decoderInputBuffer;
                } finally {
                }
            }
            return true;
        }
    }

    @Override // y1.d
    public final void flush() {
        synchronized (this.f14467b) {
            try {
                this.f14474k = true;
                this.f14476m = 0;
                DecoderInputBuffer decoderInputBuffer = this.i;
                if (decoderInputBuffer != null) {
                    decoderInputBuffer.clear();
                    DecoderInputBuffer[] decoderInputBufferArr = this.f14470e;
                    int i = this.f14471g;
                    this.f14471g = i + 1;
                    decoderInputBufferArr[i] = decoderInputBuffer;
                    this.i = null;
                }
                while (!this.f14468c.isEmpty()) {
                    DecoderInputBuffer decoderInputBuffer2 = (DecoderInputBuffer) this.f14468c.removeFirst();
                    decoderInputBuffer2.clear();
                    DecoderInputBuffer[] decoderInputBufferArr2 = this.f14470e;
                    int i10 = this.f14471g;
                    this.f14471g = i10 + 1;
                    decoderInputBufferArr2[i10] = decoderInputBuffer2;
                }
                while (!this.f14469d.isEmpty()) {
                    ((h) this.f14469d.removeFirst()).release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y1.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final h dequeueOutputBuffer() {
        synchronized (this.f14467b) {
            try {
                e eVar = this.f14473j;
                if (eVar != null) {
                    throw eVar;
                }
                if (this.f14469d.isEmpty()) {
                    return null;
                }
                return (h) this.f14469d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean h(long j5) {
        boolean z2;
        synchronized (this.f14467b) {
            long j8 = this.f14477n;
            z2 = j8 == -9223372036854775807L || j5 >= j8;
        }
        return z2;
    }

    @Override // y1.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.f14467b) {
            try {
                e eVar = this.f14473j;
                if (eVar != null) {
                    throw eVar;
                }
                s1.d.b(decoderInputBuffer == this.i);
                this.f14468c.addLast(decoderInputBuffer);
                if (!this.f14468c.isEmpty() && this.f14472h > 0) {
                    this.f14467b.notify();
                }
                this.i = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(h hVar) {
        synchronized (this.f14467b) {
            hVar.clear();
            h[] hVarArr = this.f;
            int i = this.f14472h;
            this.f14472h = i + 1;
            hVarArr[i] = hVar;
            if (!this.f14468c.isEmpty() && this.f14472h > 0) {
                this.f14467b.notify();
            }
        }
    }

    @Override // y1.d
    public void release() {
        synchronized (this.f14467b) {
            this.f14475l = true;
            this.f14467b.notify();
        }
        try {
            this.f14466a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // y1.d
    public final void setOutputStartTimeUs(long j5) {
        synchronized (this.f14467b) {
            try {
                s1.d.g(this.f14471g == this.f14470e.length || this.f14474k);
                this.f14477n = j5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
