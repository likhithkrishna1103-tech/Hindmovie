package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import ga.g;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import lb.e;
import lb.f;
import ma.a;
import ma.b;
import na.c;
import na.j;
import na.r;
import oa.i;
import ob.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static d lambda$getComponents$0(c cVar) {
        return new ob.c((g) cVar.b(g.class), cVar.e(f.class), (ExecutorService) cVar.d(new r(a.class, ExecutorService.class)), new i((Executor) cVar.d(new r(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<na.b> getComponents() {
        na.a aVarA = na.b.a(d.class);
        aVarA.f8873a = LIBRARY_NAME;
        aVarA.a(j.a(g.class));
        aVarA.a(new j(0, 1, f.class));
        aVarA.a(new j(new r(a.class, ExecutorService.class), 1, 0));
        aVarA.a(new j(new r(b.class, Executor.class), 1, 0));
        aVarA.f8878g = new ia.b(13);
        na.b bVarB = aVarA.b();
        e eVar = new e(0);
        na.a aVarA2 = na.b.a(e.class);
        aVarA2.f8875c = 1;
        aVarA2.f8878g = new b2.e(eVar);
        return Arrays.asList(bVarB, aVarA2.b(), com.bumptech.glide.c.g(LIBRARY_NAME, "18.0.0"));
    }
}
