package com.google.firebase.sessions;

import ab.g;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import gb.a;
import gb.b;
import hb.c;
import hb.j;
import hb.r;
import ic.d;
import java.util.List;
import ma.e;
import o.t3;
import pe.s;
import u7.f;
import v1.b0;
import vc.i;
import vc.m;
import vc.o;
import vc.s0;
import vc.t;
import vc.u;
import vd.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {

    @Deprecated
    public static final String LIBRARY_NAME = "fire-sessions";
    private static final u Companion = new u();
    private static final r appContext = r.a(Context.class);
    private static final r firebaseApp = r.a(g.class);
    private static final r firebaseInstallationsApi = r.a(d.class);
    private static final r backgroundDispatcher = new r(a.class, s.class);
    private static final r blockingDispatcher = new r(b.class, s.class);
    private static final r transportFactory = r.a(f.class);
    private static final r firebaseSessionsComponent = r.a(vc.r.class);

    /* JADX INFO: Access modifiers changed from: private */
    public static final o getComponents$lambda$0(c cVar) {
        return (o) ((i) ((vc.r) cVar.f(firebaseSessionsComponent))).f13646p.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vc.r getComponents$lambda$1(c cVar) {
        Object objF = cVar.f(appContext);
        ge.i.d(objF, "get(...)");
        Object objF2 = cVar.f(backgroundDispatcher);
        ge.i.d(objF2, "get(...)");
        Object objF3 = cVar.f(blockingDispatcher);
        ge.i.d(objF3, "get(...)");
        Object objF4 = cVar.f(firebaseApp);
        ge.i.d(objF4, "get(...)");
        Object objF5 = cVar.f(firebaseInstallationsApi);
        ge.i.d(objF5, "get(...)");
        hc.b bVarD = cVar.d(transportFactory);
        ge.i.d(bVarD, "getProvider(...)");
        i iVar = new i();
        iVar.f13633a = e.a((g) objF4);
        e eVarA = e.a((Context) objF);
        iVar.f13634b = eVarA;
        iVar.f13635c = xc.a.a(new m(eVarA, 1));
        iVar.f13636d = xc.a.a(t.f13692a);
        iVar.f13637e = e.a((d) objF5);
        iVar.f = xc.a.a(new m2.e(iVar.f13633a));
        e eVarA2 = e.a((h) objF3);
        iVar.f13638g = eVarA2;
        iVar.f13639h = xc.a.a(new vc.s(iVar.f, eVarA2));
        iVar.i = e.a((h) objF2);
        iVar.f13640j = xc.a.a(new s0(iVar.f13635c, xc.a.a(new dd.c(iVar.f13636d, iVar.f13637e, iVar.f, iVar.f13639h, xc.a.a(new l7.a(iVar.i, iVar.f13636d, xc.a.a(new vc.s(iVar.f13634b, iVar.f13638g, 0)), 28)), 17)), 1));
        xc.c cVarA = xc.a.a(t.f13693b);
        iVar.f13641k = cVarA;
        iVar.f13642l = xc.a.a(new s0(iVar.f13636d, cVarA, 0));
        iVar.f13643m = xc.a.a(new dd.c(iVar.f13633a, iVar.f13637e, iVar.f13640j, xc.a.a(new m(e.a(bVarD), 0)), iVar.i, 15));
        iVar.f13644n = xc.a.a(new l7.a(iVar.f13634b, iVar.f13638g, xc.a.a(new e8.e(iVar.f13642l, 1)), 22));
        xc.c cVarA2 = xc.a.a(new t3(iVar.f13640j, iVar.f13642l, iVar.f13643m, iVar.f13636d, iVar.f13644n, xc.a.a(new vc.s(iVar.f13634b, iVar.f13641k, 1)), iVar.i));
        iVar.f13645o = cVarA2;
        iVar.f13646p = xc.a.a(new b6.f(iVar.f13633a, iVar.f13640j, iVar.i, xc.a.a(new l4.a(cVarA2)), 15));
        return iVar;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<hb.b> getComponents() {
        hb.a aVarB = hb.b.b(o.class);
        aVarB.f5870a = LIBRARY_NAME;
        aVarB.a(j.a(firebaseSessionsComponent));
        aVarB.f5875g = new b0(9);
        aVarB.c(2);
        hb.b bVarB = aVarB.b();
        hb.a aVarB2 = hb.b.b(vc.r.class);
        aVarB2.f5870a = "fire-sessions-component";
        aVarB2.a(j.a(appContext));
        aVarB2.a(j.a(backgroundDispatcher));
        aVarB2.a(j.a(blockingDispatcher));
        aVarB2.a(j.a(firebaseApp));
        aVarB2.a(j.a(firebaseInstallationsApi));
        aVarB2.a(new j(transportFactory, 1, 1));
        aVarB2.f5875g = new b0(10);
        return sd.i.a(new hb.b[]{bVarB, aVarB2.b(), vf.g.n(LIBRARY_NAME, "3.0.4")});
    }
}
