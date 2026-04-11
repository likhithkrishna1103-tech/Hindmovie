package af;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f812x;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f799v) {
            return;
        }
        if (!this.f812x) {
            a();
        }
        this.f799v = true;
    }

    @Override // af.b, hf.w
    public final long l(long j5, hf.f fVar) throws IOException {
        be.h.e(fVar, "sink");
        if (this.f799v) {
            throw new IllegalStateException("closed");
        }
        if (this.f812x) {
            return -1L;
        }
        long jL = super.l(8192L, fVar);
        if (jL != -1) {
            return jL;
        }
        this.f812x = true;
        a();
        return -1L;
    }
}
