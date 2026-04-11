package com.google.firebase.abt.component;

import a3.m;
import android.content.Context;
import androidx.annotation.Keep;
import cb.a;
import com.google.firebase.components.ComponentRegistrar;
import eb.b;
import hb.c;
import hb.j;
import java.util.Arrays;
import java.util.List;
import vf.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class AbtRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-abt";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a lambda$getComponents$0(c cVar) {
        return new a((Context) cVar.b(Context.class), cVar.g(b.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<hb.b> getComponents() {
        hb.a aVarB = hb.b.b(a.class);
        aVarB.f5870a = LIBRARY_NAME;
        aVarB.a(j.b(Context.class));
        aVarB.a(new j(0, 1, b.class));
        aVarB.f5875g = new m(6);
        return Arrays.asList(aVarB.b(), g.n(LIBRARY_NAME, "21.1.1"));
    }
}
