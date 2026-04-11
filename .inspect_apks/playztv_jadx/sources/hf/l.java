package hf;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final q f6124u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Inflater f6125v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6126w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6127x;

    public l(q qVar, Inflater inflater) {
        this.f6124u = qVar;
        this.f6125v = inflater;
    }

    @Override // hf.w
    public final y c() {
        return this.f6124u.f6140u.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6127x) {
            return;
        }
        this.f6125v.end();
        this.f6127x = true;
        this.f6124u.close();
    }

    @Override // hf.w
    public final long l(long j5, f fVar) throws IOException {
        long j8;
        Inflater inflater = this.f6125v;
        be.h.e(fVar, "sink");
        while (!this.f6127x) {
            try {
                r rVarS = fVar.S(1);
                int iMin = (int) Math.min(8192L, 8192 - rVarS.f6145c);
                boolean zNeedsInput = inflater.needsInput();
                q qVar = this.f6124u;
                if (zNeedsInput && !qVar.a()) {
                    r rVar = qVar.f6141v.f6112u;
                    be.h.b(rVar);
                    int i = rVar.f6145c;
                    int i10 = rVar.f6144b;
                    int i11 = i - i10;
                    this.f6126w = i11;
                    inflater.setInput(rVar.f6143a, i10, i11);
                }
                int iInflate = inflater.inflate(rVarS.f6143a, rVarS.f6145c, iMin);
                int i12 = this.f6126w;
                if (i12 != 0) {
                    int remaining = i12 - inflater.getRemaining();
                    this.f6126w -= remaining;
                    qVar.skip(remaining);
                }
                if (iInflate > 0) {
                    rVarS.f6145c += iInflate;
                    j8 = iInflate;
                    fVar.f6113v += j8;
                } else {
                    if (rVarS.f6144b == rVarS.f6145c) {
                        fVar.f6112u = rVarS.a();
                        s.a(rVarS);
                    }
                    j8 = 0;
                }
                if (j8 > 0) {
                    return j8;
                }
                if (inflater.finished() || inflater.needsDictionary()) {
                    return -1L;
                }
                if (qVar.a()) {
                    throw new EOFException("source exhausted prematurely");
                }
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        }
        throw new IllegalStateException("closed");
    }
}
