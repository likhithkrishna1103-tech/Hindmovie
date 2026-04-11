package qc;

import android.app.Application;
import android.content.Context;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import g6.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import nb.w;
import nc.p;
import rc.l;
import rc.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements tc.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Random f10798j = new Random();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f10799k = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f10802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ab.g f10803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ic.d f10804e;
    public final bb.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final hc.b f10805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f10806h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10800a = new HashMap();
    public final HashMap i = new HashMap();

    public i(Context context, ScheduledExecutorService scheduledExecutorService, ab.g gVar, ic.d dVar, bb.c cVar, hc.b bVar) {
        this.f10801b = context;
        this.f10802c = scheduledExecutorService;
        this.f10803d = gVar;
        this.f10804e = dVar;
        this.f = cVar;
        this.f10805g = bVar;
        gVar.a();
        this.f10806h = gVar.f392c.f404b;
        AtomicReference atomicReference = h.f10797a;
        Application application = (Application) context.getApplicationContext();
        AtomicReference atomicReference2 = h.f10797a;
        if (atomicReference2.get() == null) {
            h hVar = new h();
            while (true) {
                if (atomicReference2.compareAndSet(null, hVar)) {
                    n8.c.b(application);
                    n8.c.f8862z.a(hVar);
                    break;
                } else if (atomicReference2.get() != null) {
                    break;
                }
            }
        }
        vf.g.e(scheduledExecutorService, new k(2, this));
    }

    public final synchronized b a() throws Throwable {
        try {
            try {
                rc.c cVarC = c("fetch");
                rc.c cVarC2 = c("activate");
                rc.c cVarC3 = c("defaults");
                l lVar = new l(this.f10801b.getSharedPreferences("frc_" + this.f10806h + "_firebase_settings", 0));
                rc.h hVar = new rc.h(this.f10802c, cVarC2, cVarC3);
                ab.g gVar = this.f10803d;
                hc.b bVar = this.f10805g;
                gVar.a();
                w wVar = gVar.f391b.equals("[DEFAULT]") ? new w(bVar) : null;
                if (wVar != null) {
                    hVar.a(new g(wVar));
                }
                w wVar2 = new w(14, false);
                wVar2.f9016w = cVarC2;
                wVar2.f9017x = cVarC3;
                ScheduledExecutorService scheduledExecutorService = this.f10802c;
                p pVar = new p();
                pVar.f9072d = Collections.newSetFromMap(new ConcurrentHashMap());
                pVar.f9069a = cVarC2;
                pVar.f9070b = wVar2;
                pVar.f9071c = scheduledExecutorService;
                return b(this.f10803d, this.f10804e, this.f, this.f10802c, cVarC, cVarC2, cVarC3, d(cVarC, lVar), hVar, lVar, pVar);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized b b(ab.g gVar, ic.d dVar, bb.c cVar, Executor executor, rc.c cVar2, rc.c cVar3, rc.c cVar4, rc.g gVar2, rc.h hVar, l lVar, p pVar) {
        try {
            if (!this.f10800a.containsKey("firebase")) {
                Context context = this.f10801b;
                gVar.a();
                b bVar = new b(context, gVar.f391b.equals("[DEFAULT]") ? cVar : null, executor, cVar2, cVar3, cVar4, gVar2, hVar, lVar, e(gVar, dVar, gVar2, cVar3, this.f10801b, lVar), pVar);
                cVar3.b();
                cVar4.b();
                cVar2.b();
                this.f10800a.put("firebase", bVar);
                f10799k.put("firebase", bVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (b) this.f10800a.get("firebase");
    }

    public final rc.c c(String str) {
        m mVar;
        String str2 = "frc_" + this.f10806h + "_firebase_" + str + ".json";
        ScheduledExecutorService scheduledExecutorService = this.f10802c;
        Context context = this.f10801b;
        HashMap map = m.f10987c;
        synchronized (m.class) {
            try {
                HashMap map2 = m.f10987c;
                if (!map2.containsKey(str2)) {
                    map2.put(str2, new m(context, str2));
                }
                mVar = (m) map2.get(str2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return rc.c.d(scheduledExecutorService, mVar);
    }

    public final synchronized rc.g d(rc.c cVar, l lVar) {
        ic.d dVar;
        hc.b fVar;
        ScheduledExecutorService scheduledExecutorService;
        Random random;
        String str;
        ab.g gVar;
        try {
            dVar = this.f10804e;
            ab.g gVar2 = this.f10803d;
            gVar2.a();
            fVar = gVar2.f391b.equals("[DEFAULT]") ? this.f10805g : new hb.f(7);
            scheduledExecutorService = this.f10802c;
            random = f10798j;
            ab.g gVar3 = this.f10803d;
            gVar3.a();
            str = gVar3.f392c.f403a;
            gVar = this.f10803d;
            gVar.a();
        } catch (Throwable th) {
            throw th;
        }
        return new rc.g(dVar, fVar, scheduledExecutorService, random, cVar, new ConfigFetchHttpClient(this.f10801b, gVar.f392c.f404b, str, lVar.f10983a.getLong("fetch_timeout_in_seconds", 60L), lVar.f10983a.getLong("fetch_timeout_in_seconds", 60L)), lVar, this.i);
    }

    public final synchronized w e(ab.g gVar, ic.d dVar, rc.g gVar2, rc.c cVar, Context context, l lVar) {
        return new w(gVar, dVar, gVar2, cVar, context, lVar, this.f10802c);
    }
}
