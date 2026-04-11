package com.google.firebase.analytics.connector.internal;

import ab.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.k1;
import com.google.firebase.components.ComponentRegistrar;
import eb.b;
import eb.d;
import f9.c0;
import fc.e;
import hb.a;
import hb.c;
import hb.j;
import hb.l;
import java.util.Arrays;
import java.util.List;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static b lambda$getComponents$0(c cVar) {
        g gVar = (g) cVar.b(g.class);
        Context context = (Context) cVar.b(Context.class);
        ec.c cVar2 = (ec.c) cVar.b(ec.c.class);
        u.g(gVar);
        u.g(context);
        u.g(cVar2);
        u.g(context.getApplicationContext());
        if (eb.c.f3882c == null) {
            synchronized (eb.c.class) {
                try {
                    if (eb.c.f3882c == null) {
                        Bundle bundle = new Bundle(1);
                        gVar.a();
                        if ("[DEFAULT]".equals(gVar.f391b)) {
                            ((l) cVar2).a(d.f3885w, e.f4546w);
                            bundle.putBoolean("dataCollectionDefaultEnabled", gVar.h());
                        }
                        eb.c.f3882c = new eb.c(k1.e(context, bundle).f2504b);
                    }
                } finally {
                }
            }
        }
        return eb.c.f3882c;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<hb.b> getComponents() {
        a aVarB = hb.b.b(b.class);
        aVarB.a(j.b(g.class));
        aVarB.a(j.b(Context.class));
        aVarB.a(j.b(ec.c.class));
        aVarB.f5875g = c0.G;
        aVarB.c(2);
        return Arrays.asList(aVarB.b(), vf.g.n("fire-analytics", "23.0.0"));
    }
}
