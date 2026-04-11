package qf;

import ag.i;
import ag.w;
import ag.y;
import java.io.IOException;
import kf.p;
import kf.q;
import kf.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f10810v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f10811w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10812x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ g f10813y;

    public a(g gVar, q qVar) {
        ge.i.e(qVar, "url");
        this.f10813y = gVar;
        this.f10810v = qVar;
        this.f10811w = new i(((ag.q) gVar.f10825c.f7867x).f459v.d());
    }

    @Override // ag.w
    public long U(long j4, ag.e eVar) throws IOException {
        g gVar = this.f10813y;
        ge.i.e(eVar, "sink");
        try {
            return ((ag.q) gVar.f10825c.f7867x).U(j4, eVar);
        } catch (IOException e9) {
            gVar.f10824b.h();
            a(g.f);
            throw e9;
        }
    }

    public final void a(p pVar) {
        u uVar;
        kf.b bVar;
        ge.i.e(pVar, "trailers");
        g gVar = this.f10813y;
        int i = gVar.f10826d;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException("state: " + gVar.f10826d);
        }
        i iVar = this.f10811w;
        y yVar = iVar.f434e;
        iVar.f434e = y.f472d;
        yVar.a();
        yVar.b();
        gVar.f10826d = 6;
        if (pVar.size() <= 0 || (uVar = gVar.f10823a) == null || (bVar = uVar.f7555j) == null) {
            return;
        }
        pf.g.b(bVar, this.f10810v, pVar);
    }

    @Override // ag.w, ag.u
    public final y d() {
        return this.f10811w;
    }
}
