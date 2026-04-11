package ag;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final InputStream f444v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final y f445w;

    public l(InputStream inputStream, y yVar) {
        ge.i.e(inputStream, "input");
        this.f444v = inputStream;
        this.f445w = yVar;
    }

    @Override // ag.w
    public final long U(long j4, e eVar) throws IOException {
        ge.i.e(eVar, "sink");
        try {
            this.f445w.f();
            r rVarR = eVar.R(1);
            int i = this.f444v.read(rVarR.f462a, rVarR.f464c, (int) Math.min(8192L, 8192 - rVarR.f464c));
            if (i != -1) {
                rVarR.f464c += i;
                long j7 = i;
                eVar.f429w += j7;
                return j7;
            }
            if (rVarR.f463b != rVarR.f464c) {
                return -1L;
            }
            eVar.f428v = rVarR.a();
            s.a(rVarR);
            return -1L;
        } catch (AssertionError e9) {
            if (bg.f.a(e9)) {
                throw new IOException(e9);
            }
            throw e9;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f444v.close();
    }

    @Override // ag.w, ag.u
    public final y d() {
        return this.f445w;
    }

    public final String toString() {
        return "source(" + this.f444v + ')';
    }
}
