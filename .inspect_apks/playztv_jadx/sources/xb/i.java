package xb;

import android.app.Application;
import android.content.Context;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import wa.t1;
import yb.j;
import yb.n;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements ac.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Random f14347j = new Random();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f14348k = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f14350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f14351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ga.g f14352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ob.d f14353e;
    public final ha.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final nb.b f14354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14355h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f14349a = new HashMap();
    public final HashMap i = new HashMap();

    public i(Context context, ScheduledExecutorService scheduledExecutorService, ga.g gVar, ob.d dVar, ha.c cVar, nb.b bVar) {
        this.f14350b = context;
        this.f14351c = scheduledExecutorService;
        this.f14352d = gVar;
        this.f14353e = dVar;
        this.f = cVar;
        this.f14354g = bVar;
        gVar.a();
        this.f14355h = gVar.f5348c.f5360b;
        AtomicReference atomicReference = h.f14346a;
        Application application = (Application) context.getApplicationContext();
        AtomicReference atomicReference2 = h.f14346a;
        if (atomicReference2.get() == null) {
            h hVar = new h();
            while (true) {
                if (atomicReference2.compareAndSet(null, hVar)) {
                    s7.c.b(application);
                    s7.c.f11878y.a(hVar);
                    break;
                } else if (atomicReference2.get() != null) {
                    break;
                }
            }
        }
        t1.f(scheduledExecutorService, new bb.d(3, this));
    }

    public final synchronized b a() throws Throwable {
        try {
            try {
                yb.c cVarC = c("fetch");
                yb.c cVarC2 = c("activate");
                yb.c cVarC3 = c("defaults");
                j jVar = new j(this.f14350b.getSharedPreferences("frc_" + this.f14355h + "_firebase_settings", 0));
                yb.h hVar = new yb.h(this.f14351c, cVarC2, cVarC3);
                ga.g gVar = this.f14352d;
                nb.b bVar = this.f14354g;
                gVar.a();
                pb.c cVar = gVar.f5347b.equals("[DEFAULT]") ? new pb.c(bVar) : null;
                if (cVar != null) {
                    hVar.a(new g(cVar));
                }
                pb.c cVar2 = new pb.c(21, false);
                cVar2.f10310v = cVarC2;
                cVar2.f10311w = cVarC3;
                ScheduledExecutorService scheduledExecutorService = this.f14351c;
                z0.i iVar = new z0.i();
                iVar.f14764d = Collections.newSetFromMap(new ConcurrentHashMap());
                iVar.f14761a = cVarC2;
                iVar.f14762b = cVar2;
                iVar.f14763c = scheduledExecutorService;
                return b(this.f14352d, this.f14353e, this.f, this.f14351c, cVarC, cVarC2, cVarC3, d(cVarC, jVar), hVar, jVar, iVar);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized b b(ga.g gVar, ob.d dVar, ha.c cVar, Executor executor, yb.c cVar2, yb.c cVar3, yb.c cVar4, yb.g gVar2, yb.h hVar, j jVar, z0.i iVar) {
        try {
            if (!this.f14349a.containsKey("firebase")) {
                Context context = this.f14350b;
                gVar.a();
                b bVar = new b(context, gVar.f5347b.equals("[DEFAULT]") ? cVar : null, executor, cVar2, cVar3, cVar4, gVar2, hVar, jVar, e(gVar, dVar, gVar2, cVar3, this.f14350b, jVar), iVar);
                cVar3.b();
                cVar4.b();
                cVar2.b();
                this.f14349a.put("firebase", bVar);
                f14348k.put("firebase", bVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (b) this.f14349a.get("firebase");
    }

    public final yb.c c(String str) {
        n nVar;
        String str2 = "frc_" + this.f14355h + "_firebase_" + str + ".json";
        ScheduledExecutorService scheduledExecutorService = this.f14351c;
        Context context = this.f14350b;
        HashMap map = n.f14637c;
        synchronized (n.class) {
            try {
                HashMap map2 = n.f14637c;
                if (!map2.containsKey(str2)) {
                    map2.put(str2, new n(context, str2));
                }
                nVar = (n) map2.get(str2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return yb.c.d(scheduledExecutorService, nVar);
    }

    public final synchronized yb.g d(yb.c cVar, j jVar) {
        ob.d dVar;
        nb.b fVar;
        ScheduledExecutorService scheduledExecutorService;
        Random random;
        String str;
        ga.g gVar;
        try {
            dVar = this.f14353e;
            ga.g gVar2 = this.f14352d;
            gVar2.a();
            fVar = gVar2.f5347b.equals("[DEFAULT]") ? this.f14354g : new na.f(7);
            scheduledExecutorService = this.f14351c;
            random = f14347j;
            ga.g gVar3 = this.f14352d;
            gVar3.a();
            str = gVar3.f5348c.f5359a;
            gVar = this.f14352d;
            gVar.a();
        } catch (Throwable th) {
            throw th;
        }
        return new yb.g(dVar, fVar, scheduledExecutorService, random, cVar, new ConfigFetchHttpClient(this.f14350b, gVar.f5348c.f5360b, str, jVar.f14615a.getLong("fetch_timeout_in_seconds", 60L), jVar.f14615a.getLong("fetch_timeout_in_seconds", 60L)), jVar, this.i);
    }

    public final synchronized p2.c e(ga.g gVar, ob.d dVar, yb.g gVar2, yb.c cVar, Context context, j jVar) {
        return new p2.c(gVar, dVar, gVar2, cVar, context, jVar, this.f14351c);
    }
}
