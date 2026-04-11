package com.google.firebase.crashlytics;

import ab.g;
import android.util.Log;
import androidx.fragment.app.f1;
import com.google.firebase.components.ComponentRegistrar;
import gb.a;
import gb.b;
import gb.c;
import hb.j;
import hb.r;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import wc.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f3028d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f3029a = new r(a.class, ExecutorService.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f3030b = new r(b.class, ExecutorService.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f3031c = new r(c.class, ExecutorService.class);

    static {
        Map map = wc.c.f14138b;
        d dVar = d.f14139v;
        if (map.containsKey(dVar)) {
            Log.d("FirebaseSessions", "Dependency " + dVar + " already added.");
            return;
        }
        map.put(dVar, new wc.a(new xe.c(true)));
        Log.d("FirebaseSessions", "Dependency to " + dVar + " added.");
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        hb.a aVarB = hb.b.b(jb.b.class);
        aVarB.f5870a = "fire-cls";
        aVarB.a(j.b(g.class));
        aVarB.a(j.b(ic.d.class));
        aVarB.a(new j(this.f3029a, 1, 0));
        aVarB.a(new j(this.f3030b, 1, 0));
        aVarB.a(new j(this.f3031c, 1, 0));
        aVarB.a(new j(0, 2, kb.a.class));
        aVarB.a(new j(0, 2, eb.b.class));
        aVarB.a(new j(0, 2, tc.a.class));
        aVarB.f5875g = new f1(22, this);
        aVarB.c(2);
        return Arrays.asList(aVarB.b(), vf.g.n("fire-cls", "20.0.4"));
    }
}
