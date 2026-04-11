package bf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements hf.w {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final hf.h f2106u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2107v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2108w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2109x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2110y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2111z;

    public s(hf.h hVar) {
        be.h.e(hVar, "source");
        this.f2106u = hVar;
    }

    @Override // hf.w
    public final hf.y c() {
        return this.f2106u.c();
    }

    @Override // hf.w
    public final long l(long j5, hf.f fVar) throws IOException {
        int i;
        int i10;
        be.h.e(fVar, "sink");
        do {
            int i11 = this.f2110y;
            hf.h hVar = this.f2106u;
            if (i11 == 0) {
                hVar.skip(this.f2111z);
                this.f2111z = 0;
                if ((this.f2108w & 4) == 0) {
                    i = this.f2109x;
                    int iR = ve.b.r(hVar);
                    this.f2110y = iR;
                    this.f2107v = iR;
                    int i12 = hVar.readByte() & 255;
                    this.f2108w = hVar.readByte() & 255;
                    Logger logger = t.f2112x;
                    if (logger.isLoggable(Level.FINE)) {
                        hf.i iVar = f.f2073a;
                        logger.fine(f.a(true, this.f2109x, this.f2107v, i12, this.f2108w));
                    }
                    i10 = hVar.readInt() & Integer.MAX_VALUE;
                    this.f2109x = i10;
                    if (i12 != 9) {
                        throw new IOException(i12 + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long jL = hVar.l(Math.min(8192L, i11), fVar);
                if (jL != -1) {
                    this.f2110y -= (int) jL;
                    return jL;
                }
            }
            return -1L;
        } while (i10 == i);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
