package hf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements u {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6098u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v f6099v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f6100w;

    public b(OutputStream outputStream, v vVar) {
        this.f6100w = outputStream;
        this.f6099v = vVar;
    }

    @Override // hf.u
    public final void b0(long j5, f fVar) throws IOException {
        switch (this.f6098u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b8.h.c(fVar.f6113v, 0L, j5);
                long j8 = j5;
                while (true) {
                    long j10 = 0;
                    if (j8 <= 0) {
                        return;
                    }
                    r rVar = fVar.f6112u;
                    be.h.b(rVar);
                    while (true) {
                        if (j10 < 65536) {
                            j10 += (long) (rVar.f6145c - rVar.f6144b);
                            if (j10 >= j8) {
                                j10 = j8;
                            } else {
                                rVar = rVar.f;
                                be.h.b(rVar);
                            }
                        }
                    }
                    b bVar = (b) this.f6100w;
                    v vVar = this.f6099v;
                    vVar.h();
                    try {
                        try {
                            bVar.b0(j10, fVar);
                            if (vVar.i()) {
                                throw vVar.k(null);
                            }
                            j8 -= j10;
                        } catch (IOException e10) {
                            if (!vVar.i()) {
                                throw e10;
                            }
                            throw vVar.k(e10);
                        }
                    } catch (Throwable th) {
                        vVar.i();
                        throw th;
                    }
                }
                break;
            default:
                b8.h.c(fVar.f6113v, 0L, j5);
                while (j5 > 0) {
                    this.f6099v.f();
                    r rVar2 = fVar.f6112u;
                    be.h.b(rVar2);
                    int iMin = (int) Math.min(j5, rVar2.f6145c - rVar2.f6144b);
                    ((OutputStream) this.f6100w).write(rVar2.f6143a, rVar2.f6144b, iMin);
                    int i = rVar2.f6144b + iMin;
                    rVar2.f6144b = i;
                    long j11 = iMin;
                    j5 -= j11;
                    fVar.f6113v -= j11;
                    if (i == rVar2.f6145c) {
                        fVar.f6112u = rVar2.a();
                        s.a(rVar2);
                    }
                }
                return;
        }
    }

    @Override // hf.u
    public final y c() {
        switch (this.f6098u) {
        }
        return this.f6099v;
    }

    @Override // hf.u, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f6098u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b bVar = (b) this.f6100w;
                v vVar = this.f6099v;
                vVar.h();
                try {
                    bVar.close();
                    if (vVar.i()) {
                        throw vVar.k(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!vVar.i()) {
                        throw e10;
                    }
                    throw vVar.k(e10);
                } finally {
                    vVar.i();
                }
            default:
                ((OutputStream) this.f6100w).close();
                return;
        }
    }

    @Override // hf.u, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f6098u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b bVar = (b) this.f6100w;
                v vVar = this.f6099v;
                vVar.h();
                try {
                    bVar.flush();
                    if (vVar.i()) {
                        throw vVar.k(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!vVar.i()) {
                        throw e10;
                    }
                    throw vVar.k(e10);
                } finally {
                    vVar.i();
                }
            default:
                ((OutputStream) this.f6100w).flush();
                return;
        }
    }

    public final String toString() {
        switch (this.f6098u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "AsyncTimeout.sink(" + ((b) this.f6100w) + ')';
            default:
                return "sink(" + ((OutputStream) this.f6100w) + ')';
        }
    }

    public b(v vVar, b bVar) {
        this.f6099v = vVar;
        this.f6100w = bVar;
    }
}
