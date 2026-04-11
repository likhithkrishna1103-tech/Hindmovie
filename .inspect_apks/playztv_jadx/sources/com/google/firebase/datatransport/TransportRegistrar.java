package com.google.firebase.datatransport;

import a7.a;
import android.content.Context;
import androidx.annotation.Keep;
import c7.t;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import na.b;
import na.c;
import na.j;
import na.r;
import z6.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$0(c cVar) {
        t.b((Context) cVar.b(Context.class));
        return t.a().c(a.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$1(c cVar) {
        t.b((Context) cVar.b(Context.class));
        return t.a().c(a.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$2(c cVar) {
        t.b((Context) cVar.b(Context.class));
        return t.a().c(a.f613e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b> getComponents() {
        na.a aVarA = b.a(f.class);
        aVarA.f8873a = LIBRARY_NAME;
        aVarA.a(j.a(Context.class));
        aVarA.f8878g = new b2.f(11);
        b bVarB = aVarA.b();
        na.a aVarB = b.b(new r(eb.a.class, f.class));
        aVarB.a(j.a(Context.class));
        aVarB.f8878g = new b2.f(12);
        b bVarB2 = aVarB.b();
        na.a aVarB2 = b.b(new r(eb.b.class, f.class));
        aVarB2.a(j.a(Context.class));
        aVarB2.f8878g = new b2.f(13);
        return Arrays.asList(bVarB, bVarB2, aVarB2.b(), com.bumptech.glide.c.g(LIBRARY_NAME, "19.0.0"));
    }
}
