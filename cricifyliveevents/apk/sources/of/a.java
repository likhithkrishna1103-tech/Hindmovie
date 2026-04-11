package of;

import ag.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kf.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements kf.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9775a = new a();

    @Override // kf.r
    public final z a(pf.h hVar) throws IOException {
        pf.f gVar;
        n nVar = hVar.f10296a;
        synchronized (nVar) {
            if (!nVar.J) {
                throw new IllegalStateException("released");
            }
            if (nVar.G || nVar.F || nVar.I || nVar.H) {
                throw new IllegalStateException("Check failed.");
            }
        }
        h hVar2 = nVar.B;
        ge.i.b(hVar2);
        o oVarH = hVar2.h();
        kf.u uVar = nVar.f9817v;
        oVarH.getClass();
        int i = hVar.f10301g;
        l7.a aVar = oVarH.f9827h;
        rf.q qVar = oVarH.i;
        if (qVar != null) {
            gVar = new rf.r(uVar, oVarH, hVar, qVar);
        } else {
            oVarH.f9825e.setSoTimeout(i);
            y yVarD = ((ag.q) aVar.f7867x).f459v.d();
            long j4 = i;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            yVarD.g(j4);
            ((ag.p) aVar.f7868y).f456v.d().g(hVar.f10302h);
            gVar = new qf.g(uVar, oVarH, aVar);
        }
        com.bumptech.glide.l lVar = new com.bumptech.glide.l(nVar, hVar2, gVar);
        nVar.E = lVar;
        nVar.L = lVar;
        synchronized (nVar) {
            nVar.F = true;
            nVar.G = true;
        }
        if (nVar.K) {
            throw new IOException("Canceled");
        }
        return pf.h.a(hVar, 0, lVar, null, 61).b(hVar.f10300e);
    }
}
