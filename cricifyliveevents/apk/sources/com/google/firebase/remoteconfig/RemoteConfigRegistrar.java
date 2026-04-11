package com.google.firebase.remoteconfig;

import ab.g;
import android.content.Context;
import androidx.annotation.Keep;
import cb.a;
import com.google.firebase.components.ComponentRegistrar;
import eb.b;
import hb.c;
import hb.j;
import hb.r;
import ic.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import qc.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class RemoteConfigRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-rc";

    /* JADX INFO: Access modifiers changed from: private */
    public static i lambda$getComponents$0(r rVar, c cVar) {
        bb.c cVar2;
        Context context = (Context) cVar.b(Context.class);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) cVar.f(rVar);
        g gVar = (g) cVar.b(g.class);
        d dVar = (d) cVar.b(d.class);
        a aVar = (a) cVar.b(a.class);
        synchronized (aVar) {
            try {
                if (!aVar.f2125a.containsKey("frc")) {
                    aVar.f2125a.put("frc", new bb.c(aVar.f2126b));
                }
                cVar2 = (bb.c) aVar.f2125a.get("frc");
            } catch (Throwable th) {
                throw th;
            }
        }
        return new i(context, scheduledExecutorService, gVar, dVar, cVar2, cVar.g(b.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<hb.b> getComponents() {
        r rVar = new r(gb.b.class, ScheduledExecutorService.class);
        hb.a aVar = new hb.a(i.class, new Class[]{tc.a.class});
        aVar.f5870a = LIBRARY_NAME;
        aVar.a(j.b(Context.class));
        aVar.a(new j(rVar, 1, 0));
        aVar.a(j.b(g.class));
        aVar.a(j.b(d.class));
        aVar.a(j.b(a.class));
        aVar.a(new j(0, 1, b.class));
        aVar.f5875g = new fc.b(rVar, 2);
        aVar.c(2);
        return Arrays.asList(aVar.b(), vf.g.n(LIBRARY_NAME, "23.0.1"));
    }
}
