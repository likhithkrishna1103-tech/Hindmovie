package qf;

import ag.i;
import ag.p;
import ag.u;
import ag.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements u {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i f10814v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10815w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ g f10816x;

    public b(g gVar) {
        this.f10816x = gVar;
        this.f10814v = new i(((p) gVar.f10825c.f7868y).f456v.d());
    }

    @Override // ag.u
    public final void a0(long j4, ag.e eVar) {
        if (this.f10815w) {
            throw new IllegalStateException("closed");
        }
        if (j4 == 0) {
            return;
        }
        p pVar = (p) this.f10816x.f10825c.f7868y;
        if (pVar.f458x) {
            throw new IllegalStateException("closed");
        }
        pVar.f457w.k0(j4);
        pVar.a();
        pVar.g("\r\n");
        pVar.a0(j4, eVar);
        pVar.g("\r\n");
    }

    @Override // ag.u, java.lang.AutoCloseable, java.nio.channels.Channel
    public final synchronized void close() {
        if (this.f10815w) {
            return;
        }
        this.f10815w = true;
        ((p) this.f10816x.f10825c.f7868y).g("0\r\n\r\n");
        i iVar = this.f10814v;
        y yVar = iVar.f434e;
        iVar.f434e = y.f472d;
        yVar.a();
        yVar.b();
        this.f10816x.f10826d = 3;
    }

    @Override // ag.u
    public final y d() {
        return this.f10814v;
    }

    @Override // ag.u, java.io.Flushable
    public final synchronized void flush() {
        if (this.f10815w) {
            return;
        }
        ((p) this.f10816x.f10825c.f7868y).flush();
    }
}
