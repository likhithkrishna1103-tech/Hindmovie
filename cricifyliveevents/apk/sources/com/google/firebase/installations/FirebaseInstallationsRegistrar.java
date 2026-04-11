package com.google.firebase.installations;

import ab.g;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import fc.f;
import gb.a;
import gb.b;
import h2.e;
import hb.c;
import hb.r;
import ib.j;
import ic.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static d lambda$getComponents$0(c cVar) {
        return new ic.c((g) cVar.b(g.class), cVar.g(f.class), (ExecutorService) cVar.f(new r(a.class, ExecutorService.class)), new j((Executor) cVar.f(new r(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<hb.b> getComponents() {
        hb.a aVarB = hb.b.b(d.class);
        aVarB.f5870a = LIBRARY_NAME;
        aVarB.a(hb.j.b(g.class));
        aVarB.a(new hb.j(0, 1, f.class));
        aVarB.a(new hb.j(new r(a.class, ExecutorService.class), 1, 0));
        aVarB.a(new hb.j(new r(b.class, Executor.class), 1, 0));
        aVarB.f5875g = new e(14);
        hb.b bVarB = aVarB.b();
        fc.e eVar = new fc.e(0);
        hb.a aVarB2 = hb.b.b(fc.e.class);
        aVarB2.f5872c = 1;
        aVarB2.f5875g = new h2.d(eVar);
        return Arrays.asList(bVarB, aVarB2.b(), vf.g.n(LIBRARY_NAME, "19.1.0"));
    }
}
