package te;

import fe.p;
import ge.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vd.c[] f12020a = new vd.c[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d5.a f12021b = new d5.a(3, "NULL");

    public static final Object a(vd.h hVar, Object obj, Object obj2, p pVar, vd.c cVar) {
        Object objJ;
        Object objL = ue.a.l(hVar, obj2);
        try {
            k kVar = new k(cVar, hVar);
            if (q4.a.v(pVar)) {
                s.a(2, pVar);
                objJ = pVar.j(obj, kVar);
            } else {
                ge.i.e(pVar, "<this>");
                vd.h hVarH = kVar.h();
                Object bVar = hVarH == vd.i.f13722v ? new wd.b(kVar) : new wd.c(kVar, hVarH);
                s.a(2, pVar);
                objJ = pVar.j(obj, bVar);
            }
            ue.a.g(hVar, objL);
            if (objJ == wd.a.f14143v) {
                ge.i.e(cVar, "frame");
            }
            return objJ;
        } catch (Throwable th) {
            ue.a.g(hVar, objL);
            throw th;
        }
    }
}
