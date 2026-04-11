package com.google.firebase.messaging;

import ab.g;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import gc.a;
import hb.c;
import hb.j;
import hb.r;
import ic.d;
import java.util.Arrays;
import java.util.List;
import pc.b;
import u7.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(r rVar, c cVar) {
        g gVar = (g) cVar.b(g.class);
        if (cVar.b(a.class) == null) {
            return new FirebaseMessaging(gVar, cVar.g(b.class), cVar.g(fc.g.class), (d) cVar.b(d.class), cVar.d(rVar), (ec.c) cVar.b(ec.c.class));
        }
        throw new ClassCastException();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<hb.b> getComponents() {
        r rVar = new r(yb.b.class, f.class);
        hb.a aVarB = hb.b.b(FirebaseMessaging.class);
        aVarB.f5870a = LIBRARY_NAME;
        aVarB.a(j.b(g.class));
        aVarB.a(new j(0, 0, a.class));
        aVarB.a(new j(0, 1, b.class));
        aVarB.a(new j(0, 1, fc.g.class));
        aVarB.a(j.b(d.class));
        aVarB.a(new j(rVar, 0, 1));
        aVarB.a(j.b(ec.c.class));
        aVarB.f5875g = new fc.b(rVar, 1);
        aVarB.c(1);
        return Arrays.asList(aVarB.b(), vf.g.n(LIBRARY_NAME, "25.0.1"));
    }
}
