package com.google.firebase.sessions;

import android.content.Context;
import androidx.annotation.Keep;
import be.h;
import cc.f0;
import cc.j0;
import cc.m;
import cc.m0;
import cc.o;
import cc.o0;
import cc.u;
import cc.u0;
import cc.v0;
import com.google.firebase.components.ComponentRegistrar;
import ec.j;
import ga.g;
import java.util.List;
import ma.a;
import ma.b;
import na.c;
import na.r;
import ob.d;
import z6.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-sessions";
    private static final o Companion = new o();
    private static final r firebaseApp = r.a(g.class);
    private static final r firebaseInstallationsApi = r.a(d.class);
    private static final r backgroundDispatcher = new r(a.class, ke.r.class);
    private static final r blockingDispatcher = new r(b.class, ke.r.class);
    private static final r transportFactory = r.a(f.class);
    private static final r sessionsSettings = r.a(j.class);
    private static final r sessionLifecycleServiceBinder = r.a(u0.class);

    /* JADX INFO: Access modifiers changed from: private */
    public static final m getComponents$lambda$0(c cVar) {
        Object objD = cVar.d(firebaseApp);
        h.d(objD, "container[firebaseApp]");
        Object objD2 = cVar.d(sessionsSettings);
        h.d(objD2, "container[sessionsSettings]");
        Object objD3 = cVar.d(backgroundDispatcher);
        h.d(objD3, "container[backgroundDispatcher]");
        Object objD4 = cVar.d(sessionLifecycleServiceBinder);
        h.d(objD4, "container[sessionLifecycleServiceBinder]");
        return new m((g) objD, (j) objD2, (rd.h) objD3, (u0) objD4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o0 getComponents$lambda$1(c cVar) {
        return new o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j0 getComponents$lambda$2(c cVar) {
        Object objD = cVar.d(firebaseApp);
        h.d(objD, "container[firebaseApp]");
        Object objD2 = cVar.d(firebaseInstallationsApi);
        h.d(objD2, "container[firebaseInstallationsApi]");
        Object objD3 = cVar.d(sessionsSettings);
        h.d(objD3, "container[sessionsSettings]");
        nb.b bVarG = cVar.g(transportFactory);
        h.d(bVarG, "container.getProvider(transportFactory)");
        u5.c cVar2 = new u5.c(7, bVarG);
        Object objD4 = cVar.d(backgroundDispatcher);
        h.d(objD4, "container[backgroundDispatcher]");
        return new m0((g) objD, (d) objD2, (j) objD3, cVar2, (rd.h) objD4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j getComponents$lambda$3(c cVar) {
        Object objD = cVar.d(firebaseApp);
        h.d(objD, "container[firebaseApp]");
        Object objD2 = cVar.d(blockingDispatcher);
        h.d(objD2, "container[blockingDispatcher]");
        Object objD3 = cVar.d(backgroundDispatcher);
        h.d(objD3, "container[backgroundDispatcher]");
        Object objD4 = cVar.d(firebaseInstallationsApi);
        h.d(objD4, "container[firebaseInstallationsApi]");
        return new j((g) objD, (rd.h) objD2, (rd.h) objD3, (d) objD4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u getComponents$lambda$4(c cVar) {
        g gVar = (g) cVar.d(firebaseApp);
        gVar.a();
        Context context = gVar.f5346a;
        h.d(context, "container[firebaseApp].applicationContext");
        Object objD = cVar.d(backgroundDispatcher);
        h.d(objD, "container[backgroundDispatcher]");
        return new f0(context, (rd.h) objD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u0 getComponents$lambda$5(c cVar) {
        Object objD = cVar.d(firebaseApp);
        h.d(objD, "container[firebaseApp]");
        return new v0((g) objD);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<na.b> getComponents() {
        na.a aVarA = na.b.a(m.class);
        aVarA.f8873a = LIBRARY_NAME;
        r rVar = firebaseApp;
        aVarA.a(na.j.b(rVar));
        r rVar2 = sessionsSettings;
        aVarA.a(na.j.b(rVar2));
        r rVar3 = backgroundDispatcher;
        aVarA.a(na.j.b(rVar3));
        aVarA.a(na.j.b(sessionLifecycleServiceBinder));
        aVarA.f8878g = new b2.f(4);
        aVarA.c(2);
        na.b bVarB = aVarA.b();
        na.a aVarA2 = na.b.a(o0.class);
        aVarA2.f8873a = "session-generator";
        aVarA2.f8878g = new b2.f(5);
        na.b bVarB2 = aVarA2.b();
        na.a aVarA3 = na.b.a(j0.class);
        aVarA3.f8873a = "session-publisher";
        aVarA3.a(new na.j(rVar, 1, 0));
        r rVar4 = firebaseInstallationsApi;
        aVarA3.a(na.j.b(rVar4));
        aVarA3.a(new na.j(rVar2, 1, 0));
        aVarA3.a(new na.j(transportFactory, 1, 1));
        aVarA3.a(new na.j(rVar3, 1, 0));
        aVarA3.f8878g = new b2.f(6);
        na.b bVarB3 = aVarA3.b();
        na.a aVarA4 = na.b.a(j.class);
        aVarA4.f8873a = "sessions-settings";
        aVarA4.a(new na.j(rVar, 1, 0));
        aVarA4.a(na.j.b(blockingDispatcher));
        aVarA4.a(new na.j(rVar3, 1, 0));
        aVarA4.a(new na.j(rVar4, 1, 0));
        aVarA4.f8878g = new b2.f(7);
        na.b bVarB4 = aVarA4.b();
        na.a aVarA5 = na.b.a(u.class);
        aVarA5.f8873a = "sessions-datastore";
        aVarA5.a(new na.j(rVar, 1, 0));
        aVarA5.a(new na.j(rVar3, 1, 0));
        aVarA5.f8878g = new b2.f(8);
        na.b bVarB5 = aVarA5.b();
        na.a aVarA6 = na.b.a(u0.class);
        aVarA6.f8873a = "sessions-service-binder";
        aVarA6.a(new na.j(rVar, 1, 0));
        aVarA6.f8878g = new b2.f(9);
        return od.j.S(bVarB, bVarB2, bVarB3, bVarB4, bVarB5, aVarA6.b(), com.bumptech.glide.c.g(LIBRARY_NAME, "2.0.5"));
    }
}
