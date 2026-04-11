package qf;

import ag.i;
import ag.p;
import ag.u;
import ag.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements u {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i f10819v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10820w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ g f10821x;

    public e(g gVar) {
        this.f10821x = gVar;
        this.f10819v = new i(((p) gVar.f10825c.f7868y).f456v.d());
    }

    @Override // ag.u
    public final void a0(long j4, ag.e eVar) {
        if (this.f10820w) {
            throw new IllegalStateException("closed");
        }
        lf.d.a(eVar.f429w, 0L, j4);
        ((p) this.f10821x.f10825c.f7868y).a0(j4, eVar);
    }

    @Override // ag.u, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f10820w) {
            return;
        }
        this.f10820w = true;
        i iVar = this.f10819v;
        y yVar = iVar.f434e;
        iVar.f434e = y.f472d;
        yVar.a();
        yVar.b();
        this.f10821x.f10826d = 3;
    }

    @Override // ag.u
    public final y d() {
        return this.f10819v;
    }

    @Override // ag.u, java.io.Flushable
    public final void flush() {
        if (this.f10820w) {
            return;
        }
        ((p) this.f10821x.f10825c.f7868y).flush();
    }
}
