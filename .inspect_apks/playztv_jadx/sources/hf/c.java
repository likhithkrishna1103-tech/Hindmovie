package hf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6101u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f6102v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f6103w;

    public c(InputStream inputStream, y yVar) {
        be.h.e(inputStream, "input");
        this.f6102v = inputStream;
        this.f6103w = yVar;
    }

    @Override // hf.w
    public final y c() {
        switch (this.f6101u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (v) this.f6102v;
            default:
                return (y) this.f6103w;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f6101u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v vVar = (v) this.f6102v;
                c cVar = (c) this.f6103w;
                vVar.h();
                try {
                    cVar.close();
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
                ((InputStream) this.f6102v).close();
                return;
        }
    }

    @Override // hf.w
    public final long l(long j5, f fVar) throws IOException {
        switch (this.f6101u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(fVar, "sink");
                v vVar = (v) this.f6102v;
                c cVar = (c) this.f6103w;
                vVar.h();
                try {
                    long jL = cVar.l(8192L, fVar);
                    if (vVar.i()) {
                        throw vVar.k(null);
                    }
                    return jL;
                } catch (IOException e10) {
                    if (vVar.i()) {
                        throw vVar.k(e10);
                    }
                    throw e10;
                } finally {
                    vVar.i();
                }
            default:
                be.h.e(fVar, "sink");
                try {
                    ((y) this.f6103w).f();
                    r rVarS = fVar.S(1);
                    int i = ((InputStream) this.f6102v).read(rVarS.f6143a, rVarS.f6145c, (int) Math.min(8192L, 8192 - rVarS.f6145c));
                    if (i == -1) {
                        if (rVarS.f6144b == rVarS.f6145c) {
                            fVar.f6112u = rVarS.a();
                            s.a(rVarS);
                        }
                        return -1L;
                    }
                    rVarS.f6145c += i;
                    long j8 = i;
                    fVar.f6113v += j8;
                    return j8;
                } catch (AssertionError e11) {
                    if (cf.l.u(e11)) {
                        throw new IOException(e11);
                    }
                    throw e11;
                }
        }
    }

    public final String toString() {
        switch (this.f6101u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "AsyncTimeout.source(" + ((c) this.f6103w) + ')';
            default:
                return "source(" + ((InputStream) this.f6102v) + ')';
        }
    }

    public c(v vVar, c cVar) {
        this.f6102v = vVar;
        this.f6103w = cVar;
    }
}
