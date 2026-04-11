package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.i1;
import com.google.firebase.components.ComponentRegistrar;
import ga.g;
import h.p;
import java.util.Arrays;
import java.util.List;
import k8.c0;
import k8.z;
import ka.b;
import na.a;
import na.c;
import na.j;
import na.l;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    public static b lambda$getComponents$0(c cVar) {
        g gVar = (g) cVar.b(g.class);
        Context context = (Context) cVar.b(Context.class);
        kb.c cVar2 = (kb.c) cVar.b(kb.c.class);
        v.h(gVar);
        v.h(context);
        v.h(cVar2);
        v.h(context.getApplicationContext());
        if (ka.c.f7607c == null) {
            synchronized (ka.c.class) {
                try {
                    if (ka.c.f7607c == null) {
                        Bundle bundle = new Bundle(1);
                        gVar.a();
                        if ("[DEFAULT]".equals(gVar.f5347b)) {
                            ((l) cVar2).a(new p(1), new c0(15));
                            bundle.putBoolean("dataCollectionDefaultEnabled", gVar.h());
                        }
                        ka.c.f7607c = new ka.c(i1.b(context, bundle).f3046d);
                    }
                } finally {
                }
            }
        }
        return ka.c.f7607c;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<na.b> getComponents() {
        a aVarA = na.b.a(b.class);
        aVarA.a(j.a(g.class));
        aVarA.a(j.a(Context.class));
        aVarA.a(j.a(kb.c.class));
        aVarA.f8878g = new z(18);
        aVarA.c(2);
        return Arrays.asList(aVarA.b(), com.bumptech.glide.c.g("fire-analytics", "22.1.2"));
    }
}
