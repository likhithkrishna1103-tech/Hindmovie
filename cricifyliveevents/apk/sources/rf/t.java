package rf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements ag.w {
    public int A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ag.g f11115v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11116w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f11117x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11118y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11119z;

    public t(ag.g gVar) {
        ge.i.e(gVar, "source");
        this.f11115v = gVar;
    }

    @Override // ag.w
    public final long U(long j4, ag.e eVar) throws IOException {
        int i;
        int i10;
        ge.i.e(eVar, "sink");
        do {
            int i11 = this.f11119z;
            ag.g gVar = this.f11115v;
            if (i11 == 0) {
                gVar.skip(this.A);
                this.A = 0;
                if ((this.f11117x & 4) == 0) {
                    i = this.f11118y;
                    int iL = lf.d.l(gVar);
                    this.f11119z = iL;
                    this.f11116w = iL;
                    int i12 = gVar.readByte() & 255;
                    this.f11117x = gVar.readByte() & 255;
                    Logger logger = u.f11120y;
                    if (logger.isLoggable(Level.FINE)) {
                        ag.h hVar = h.f11080a;
                        logger.fine(h.b(true, this.f11118y, this.f11116w, i12, this.f11117x));
                    }
                    i10 = gVar.readInt() & Integer.MAX_VALUE;
                    this.f11118y = i10;
                    if (i12 != 9) {
                        throw new IOException(i12 + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long jU = gVar.U(Math.min(8192L, i11), eVar);
                if (jU != -1) {
                    this.f11119z -= (int) jU;
                    return jU;
                }
            }
            return -1L;
        } while (i10 == i);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // ag.w, ag.u
    public final ag.y d() {
        return this.f11115v.d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
