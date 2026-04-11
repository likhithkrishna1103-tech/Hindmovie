package tc;

import java.util.Date;
import java.util.HashMap;
import o8.o;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements o8.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ Object f12445u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f12446v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f12447w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f12448x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f12449y;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.f12445u = obj;
        this.f12446v = obj2;
        this.f12447w = obj3;
        this.f12448x = obj4;
        this.f12449y = obj5;
    }

    @Override // o8.a
    public Object b(o oVar) {
        yb.g gVar = (yb.g) this.f12445u;
        o oVar2 = (o) this.f12446v;
        o oVar3 = (o) this.f12447w;
        Date date = (Date) this.f12448x;
        HashMap map = (HashMap) this.f12449y;
        if (!oVar2.j()) {
            return t1.j(new xb.c("Firebase Installations failed to get installation ID for fetch.", oVar2.g()));
        }
        if (!oVar3.j()) {
            return t1.j(new xb.c("Firebase Installations failed to get installation auth token for fetch.", oVar3.g()));
        }
        try {
            yb.f fVarA = gVar.a((String) oVar2.h(), ((ob.a) oVar3.h()).f9480a, date, map);
            return fVarA.f14597a != 0 ? t1.k(fVarA) : gVar.f14605e.e(fVarA.f14598b).k(gVar.f14603c, new nc.c(20, fVarA));
        } catch (xb.d e10) {
            return t1.j(e10);
        }
    }
}
