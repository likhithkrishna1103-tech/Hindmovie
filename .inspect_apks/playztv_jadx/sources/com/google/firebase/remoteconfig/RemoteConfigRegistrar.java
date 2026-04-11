package com.google.firebase.remoteconfig;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import ga.g;
import ia.a;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import ka.b;
import na.c;
import na.j;
import na.r;
import ob.d;
import xb.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class RemoteConfigRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rc";

    /* JADX INFO: Access modifiers changed from: private */
    public static i lambda$getComponents$0(r rVar, c cVar) {
        ha.c cVar2;
        Context context = (Context) cVar.b(Context.class);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) cVar.d(rVar);
        g gVar = (g) cVar.b(g.class);
        d dVar = (d) cVar.b(d.class);
        a aVar = (a) cVar.b(a.class);
        synchronized (aVar) {
            try {
                if (!aVar.f6469a.containsKey("frc")) {
                    aVar.f6469a.put("frc", new ha.c(aVar.f6470b));
                }
                cVar2 = (ha.c) aVar.f6469a.get("frc");
            } catch (Throwable th) {
                throw th;
            }
        }
        return new i(context, scheduledExecutorService, gVar, dVar, cVar2, cVar.e(b.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<na.b> getComponents() {
        r rVar = new r(ma.b.class, ScheduledExecutorService.class);
        na.a aVar = new na.a(i.class, new Class[]{ac.a.class});
        aVar.f8873a = LIBRARY_NAME;
        aVar.a(j.a(Context.class));
        aVar.a(new j(rVar, 1, 0));
        aVar.a(j.a(g.class));
        aVar.a(j.a(d.class));
        aVar.a(j.a(a.class));
        aVar.a(new j(0, 1, b.class));
        aVar.f8878g = new lb.b(rVar, 2);
        aVar.c(2);
        return Arrays.asList(aVar.b(), com.bumptech.glide.c.g(LIBRARY_NAME, "22.0.0"));
    }
}
