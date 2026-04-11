package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import ga.g;
import java.util.Arrays;
import java.util.List;
import mb.a;
import na.c;
import na.j;
import na.r;
import ob.d;
import wb.b;
import z6.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(r rVar, c cVar) {
        g gVar = (g) cVar.b(g.class);
        if (cVar.b(a.class) == null) {
            return new FirebaseMessaging(gVar, cVar.e(b.class), cVar.e(lb.g.class), (d) cVar.b(d.class), cVar.g(rVar), (kb.c) cVar.b(kb.c.class));
        }
        throw new ClassCastException();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<na.b> getComponents() {
        r rVar = new r(eb.b.class, f.class);
        na.a aVarA = na.b.a(FirebaseMessaging.class);
        aVarA.f8873a = LIBRARY_NAME;
        aVarA.a(j.a(g.class));
        aVarA.a(new j(0, 0, a.class));
        aVarA.a(new j(0, 1, b.class));
        aVarA.a(new j(0, 1, lb.g.class));
        aVarA.a(j.a(d.class));
        aVarA.a(new j(rVar, 0, 1));
        aVarA.a(j.a(kb.c.class));
        aVarA.f8878g = new lb.b(rVar, 1);
        aVarA.c(1);
        return Arrays.asList(aVarA.b(), com.bumptech.glide.c.g(LIBRARY_NAME, "24.0.2"));
    }
}
