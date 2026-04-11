package lf;

import ag.g;
import ag.w;
import ag.y;
import ge.i;
import kf.b0;
import kf.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends b0 implements w {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s f7957w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f7958x;

    public b(s sVar, long j4) {
        this.f7957w = sVar;
        this.f7958x = j4;
    }

    @Override // ag.w
    public final long U(long j4, ag.e eVar) {
        i.e(eVar, "sink");
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override // kf.b0
    public final long a() {
        return this.f7958x;
    }

    @Override // ag.w, ag.u
    public final y d() {
        return y.f472d;
    }

    @Override // kf.b0
    public final s g() {
        return this.f7957w;
    }

    @Override // kf.b0
    public final g q() {
        return vf.g.d(this);
    }

    @Override // kf.b0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
