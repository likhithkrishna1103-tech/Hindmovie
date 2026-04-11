package qf;

import ge.i;
import java.io.IOException;
import kf.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10822z;

    @Override // qf.a, ag.w
    public final long U(long j4, ag.e eVar) throws IOException {
        i.e(eVar, "sink");
        if (this.f10812x) {
            throw new IllegalStateException("closed");
        }
        if (this.f10822z) {
            return -1L;
        }
        long jU = super.U(8192L, eVar);
        if (jU != -1) {
            return jU;
        }
        this.f10822z = true;
        a(p.f7513w);
        return -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f10812x) {
            return;
        }
        if (!this.f10822z) {
            a(g.f);
        }
        this.f10812x = true;
    }
}
