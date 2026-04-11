package ag;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f440v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Inflater f441w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f442x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f443y;

    public k(q qVar, Inflater inflater) {
        this.f440v = qVar;
        this.f441w = inflater;
    }

    @Override // ag.w
    public final long U(long j4, e eVar) throws IOException {
        long j7;
        Inflater inflater = this.f441w;
        ge.i.e(eVar, "sink");
        while (!this.f443y) {
            try {
                r rVarR = eVar.R(1);
                int iMin = (int) Math.min(8192L, 8192 - rVarR.f464c);
                boolean zNeedsInput = inflater.needsInput();
                q qVar = this.f440v;
                if (zNeedsInput && !qVar.a()) {
                    r rVar = qVar.f460w.f428v;
                    ge.i.b(rVar);
                    int i = rVar.f464c;
                    int i10 = rVar.f463b;
                    int i11 = i - i10;
                    this.f442x = i11;
                    inflater.setInput(rVar.f462a, i10, i11);
                }
                int iInflate = inflater.inflate(rVarR.f462a, rVarR.f464c, iMin);
                int i12 = this.f442x;
                if (i12 != 0) {
                    int remaining = i12 - inflater.getRemaining();
                    this.f442x -= remaining;
                    qVar.skip(remaining);
                }
                if (iInflate > 0) {
                    rVarR.f464c += iInflate;
                    j7 = iInflate;
                    eVar.f429w += j7;
                } else {
                    if (rVarR.f463b == rVarR.f464c) {
                        eVar.f428v = rVarR.a();
                        s.a(rVarR);
                    }
                    j7 = 0;
                }
                if (j7 > 0) {
                    return j7;
                }
                if (inflater.finished() || inflater.needsDictionary()) {
                    return -1L;
                }
                if (qVar.a()) {
                    throw new EOFException("source exhausted prematurely");
                }
            } catch (DataFormatException e9) {
                throw new IOException(e9);
            }
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f443y) {
            return;
        }
        this.f441w.end();
        this.f443y = true;
        this.f440v.close();
    }

    @Override // ag.w, ag.u
    public final y d() {
        return this.f440v.f459v.d();
    }
}
