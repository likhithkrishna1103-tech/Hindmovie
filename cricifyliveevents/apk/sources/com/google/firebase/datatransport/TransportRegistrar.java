package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import hb.b;
import hb.c;
import hb.j;
import hb.r;
import java.util.Arrays;
import java.util.List;
import u7.f;
import v1.b0;
import v7.a;
import vf.g;
import x7.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$0(c cVar) {
        p.b((Context) cVar.b(Context.class));
        return p.a().c(a.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$1(c cVar) {
        p.b((Context) cVar.b(Context.class));
        return p.a().c(a.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$2(c cVar) {
        p.b((Context) cVar.b(Context.class));
        return p.a().c(a.f13498e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b> getComponents() {
        hb.a aVarB = b.b(f.class);
        aVarB.f5870a = LIBRARY_NAME;
        aVarB.a(j.b(Context.class));
        aVarB.f5875g = new b0(16);
        b bVarB = aVarB.b();
        hb.a aVarA = b.a(new r(yb.a.class, f.class));
        aVarA.a(j.b(Context.class));
        aVarA.f5875g = new b0(17);
        b bVarB2 = aVarA.b();
        hb.a aVarA2 = b.a(new r(yb.b.class, f.class));
        aVarA2.a(j.b(Context.class));
        aVarA2.f5875g = new b0(18);
        return Arrays.asList(bVarB, bVarB2, aVarA2.b(), g.n(LIBRARY_NAME, "19.0.0"));
    }
}
