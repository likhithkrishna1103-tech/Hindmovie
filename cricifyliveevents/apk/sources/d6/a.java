package d6;

import j9.p;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements j9.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f3394v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3395w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3396x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f3397y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f3398z;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.f3394v = obj;
        this.f3395w = obj2;
        this.f3396x = obj3;
        this.f3397y = obj4;
        this.f3398z = obj5;
    }

    @Override // j9.a
    public Object c(p pVar) {
        rc.g gVar = (rc.g) this.f3394v;
        p pVar2 = (p) this.f3395w;
        p pVar3 = (p) this.f3396x;
        Date date = (Date) this.f3397y;
        HashMap map = (HashMap) this.f3398z;
        if (!pVar2.j()) {
            return vf.g.z(new qc.c("Firebase Installations failed to get installation ID for fetch.", pVar2.g()));
        }
        if (!pVar3.j()) {
            return vf.g.z(new qc.c("Firebase Installations failed to get installation auth token for fetch.", pVar3.g()));
        }
        try {
            rc.f fVarA = gVar.a((String) pVar2.h(), ((ic.a) pVar3.h()).f6414a, date, map);
            return fVarA.f10946a != 0 ? vf.g.A(fVarA) : gVar.f10954e.e(fVarA.f10947b).k(gVar.f10952c, new kb.d(11, fVarA));
        } catch (qc.d e9) {
            return vf.g.z(e9);
        }
    }
}
