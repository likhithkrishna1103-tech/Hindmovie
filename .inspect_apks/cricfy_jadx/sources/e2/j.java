package e2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f3762a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DecoderInputBuffer[] f3766e;
    public final h[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3768h;
    public DecoderInputBuffer i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f3769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3772m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3763b = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3773n = -9223372036854775807L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f3764c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque f3765d = new ArrayDeque();

    public j(DecoderInputBuffer[] decoderInputBufferArr, h[] hVarArr) {
        this.f3766e = decoderInputBufferArr;
        this.f3767g = decoderInputBufferArr.length;
        for (int i = 0; i < this.f3767g; i++) {
            this.f3766e[i] = b();
        }
        this.f = hVarArr;
        this.f3768h = hVarArr.length;
        for (int i10 = 0; i10 < this.f3768h; i10++) {
            this.f[i10] = c();
        }
        i iVar = new i(this);
        this.f3762a = iVar;
        iVar.start();
    }

    public abstract DecoderInputBuffer b();

    public abstract h c();

    public abstract e d(Throwable th);

    @Override // e2.d
    public final Object dequeueInputBuffer() {
        DecoderInputBuffer decoderInputBuffer;
        synchronized (this.f3763b) {
            try {
                e eVar = this.f3769j;
                if (eVar != null) {
                    throw eVar;
                }
                y1.d.g(this.i == null);
                int i = this.f3767g;
                if (i == 0) {
                    decoderInputBuffer = null;
                } else {
                    DecoderInputBuffer[] decoderInputBufferArr = this.f3766e;
                    int i10 = i - 1;
                    this.f3767g = i10;
                    decoderInputBuffer = decoderInputBufferArr[i10];
                }
                this.i = decoderInputBuffer;
            } catch (Throwable th) {
                throw th;
            }
        }
        return decoderInputBuffer;
    }

    public abstract e e(DecoderInputBuffer decoderInputBuffer, h hVar, boolean z10);

    public final boolean f() {
        e eVarD;
        synchronized (this.f3763b) {
            while (!this.f3771l) {
                try {
                    if (!this.f3764c.isEmpty() && this.f3768h > 0) {
                        break;
                    }
                    this.f3763b.wait();
                } finally {
                }
            }
            if (this.f3771l) {
                return false;
            }
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f3764c.removeFirst();
            h[] hVarArr = this.f;
            int i = this.f3768h - 1;
            this.f3768h = i;
            h hVar = hVarArr[i];
            boolean z10 = this.f3770k;
            this.f3770k = false;
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
                    eVarD = e(decoderInputBuffer, hVar, z10);
                } catch (OutOfMemoryError e9) {
                    eVarD = d(e9);
                } catch (RuntimeException e10) {
                    eVarD = d(e10);
                }
                if (eVarD != null) {
                    synchronized (this.f3763b) {
                        this.f3769j = eVarD;
                    }
                    return false;
                }
            }
            synchronized (this.f3763b) {
                try {
                    if (this.f3770k) {
                        hVar.release();
                    } else if (hVar.shouldBeSkipped) {
                        this.f3772m++;
                        hVar.release();
                    } else {
                        hVar.skippedOutputBufferCount = this.f3772m;
                        this.f3772m = 0;
                        this.f3765d.addLast(hVar);
                    }
                    decoderInputBuffer.clear();
                    DecoderInputBuffer[] decoderInputBufferArr = this.f3766e;
                    int i10 = this.f3767g;
                    this.f3767g = i10 + 1;
                    decoderInputBufferArr[i10] = decoderInputBuffer;
                } finally {
                }
            }
            return true;
        }
    }

    @Override // e2.d
    public final void flush() {
        synchronized (this.f3763b) {
            try {
                this.f3770k = true;
                this.f3772m = 0;
                DecoderInputBuffer decoderInputBuffer = this.i;
                if (decoderInputBuffer != null) {
                    decoderInputBuffer.clear();
                    DecoderInputBuffer[] decoderInputBufferArr = this.f3766e;
                    int i = this.f3767g;
                    this.f3767g = i + 1;
                    decoderInputBufferArr[i] = decoderInputBuffer;
                    this.i = null;
                }
                while (!this.f3764c.isEmpty()) {
                    DecoderInputBuffer decoderInputBuffer2 = (DecoderInputBuffer) this.f3764c.removeFirst();
                    decoderInputBuffer2.clear();
                    DecoderInputBuffer[] decoderInputBufferArr2 = this.f3766e;
                    int i10 = this.f3767g;
                    this.f3767g = i10 + 1;
                    decoderInputBufferArr2[i10] = decoderInputBuffer2;
                }
                while (!this.f3765d.isEmpty()) {
                    ((h) this.f3765d.removeFirst()).release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // e2.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final h dequeueOutputBuffer() {
        synchronized (this.f3763b) {
            try {
                e eVar = this.f3769j;
                if (eVar != null) {
                    throw eVar;
                }
                if (this.f3765d.isEmpty()) {
                    return null;
                }
                return (h) this.f3765d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean h(long j4) {
        boolean z10;
        synchronized (this.f3763b) {
            long j7 = this.f3773n;
            z10 = j7 == -9223372036854775807L || j4 >= j7;
        }
        return z10;
    }

    @Override // e2.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        synchronized (this.f3763b) {
            try {
                e eVar = this.f3769j;
                if (eVar != null) {
                    throw eVar;
                }
                y1.d.b(decoderInputBuffer == this.i);
                this.f3764c.addLast(decoderInputBuffer);
                if (!this.f3764c.isEmpty() && this.f3768h > 0) {
                    this.f3763b.notify();
                }
                this.i = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(h hVar) {
        synchronized (this.f3763b) {
            hVar.clear();
            h[] hVarArr = this.f;
            int i = this.f3768h;
            this.f3768h = i + 1;
            hVarArr[i] = hVar;
            if (!this.f3764c.isEmpty() && this.f3768h > 0) {
                this.f3763b.notify();
            }
        }
    }

    @Override // e2.d
    public void release() {
        synchronized (this.f3763b) {
            this.f3771l = true;
            this.f3763b.notify();
        }
        try {
            this.f3762a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // e2.d
    public final void setOutputStartTimeUs(long j4) {
        synchronized (this.f3763b) {
            try {
                y1.d.g(this.f3767g == this.f3766e.length || this.f3770k);
                this.f3773n = j4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
