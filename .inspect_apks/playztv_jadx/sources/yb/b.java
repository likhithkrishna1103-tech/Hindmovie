package yb;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import n.q3;
import o8.o;
import org.json.JSONException;
import org.json.JSONObject;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f14577u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f14578v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ q3 f14579w;

    public b(q3 q3Var, int i, long j5) {
        this.f14579w = q3Var;
        this.f14577u = i;
        this.f14578v = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final q3 q3Var = this.f14579w;
        int i = this.f14577u;
        final long j5 = this.f14578v;
        synchronized (q3Var) {
            final int i10 = i - 1;
            final o oVarC = ((g) q3Var.f8509w).c(3 - i10);
            final o oVarB = ((c) q3Var.f8510x).b();
            t1.y(oVarC, oVarB).f((ScheduledExecutorService) q3Var.f8512z, new o8.a() { // from class: yb.a
                @Override // o8.a
                public final Object b(o oVar) throws JSONException {
                    Boolean boolValueOf;
                    q3 q3Var2 = q3Var;
                    o oVar2 = oVarC;
                    o oVar3 = oVarB;
                    long j8 = j5;
                    int i11 = i10;
                    if (!oVar2.j()) {
                        return t1.j(new xb.c("Failed to auto-fetch config update.", oVar2.g()));
                    }
                    if (!oVar3.j()) {
                        return t1.j(new xb.c("Failed to get activated config for auto-fetch", oVar3.g()));
                    }
                    f fVar = (f) oVar2.h();
                    e eVarA = (e) oVar3.h();
                    e eVar = fVar.f14598b;
                    if (eVar != null) {
                        boolValueOf = Boolean.valueOf(eVar.f >= j8);
                    } else {
                        boolValueOf = Boolean.valueOf(fVar.f14597a == 1);
                    }
                    if (!boolValueOf.booleanValue()) {
                        Log.d("FirebaseRemoteConfig", "Fetched template version is the same as SDK's current version. Retrying fetch.");
                        q3Var2.a(i11, j8);
                        return t1.k(null);
                    }
                    if (fVar.f14598b == null) {
                        Log.d("FirebaseRemoteConfig", "The fetch succeeded, but the backend had no updates.");
                        return t1.k(null);
                    }
                    if (eVarA == null) {
                        eVarA = e.c().a();
                    }
                    e eVar2 = fVar.f14598b;
                    JSONObject jSONObject = eVarA.f14595e;
                    JSONObject jSONObject2 = eVar2.f14591a;
                    JSONObject jSONObject3 = eVar2.f14592b;
                    JSONObject jSONObject4 = eVar2.f14595e;
                    JSONObject jSONObject5 = e.a(new JSONObject(jSONObject2.toString())).f14592b;
                    HashMap mapB = eVarA.b();
                    HashMap mapB2 = eVar2.b();
                    HashSet hashSet = new HashSet();
                    JSONObject jSONObject6 = eVarA.f14592b;
                    Iterator<String> itKeys = jSONObject6.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!jSONObject3.has(next)) {
                            hashSet.add(next);
                        } else if (!jSONObject6.get(next).equals(jSONObject3.get(next))) {
                            hashSet.add(next);
                        } else if ((jSONObject.has(next) && !jSONObject4.has(next)) || (!jSONObject.has(next) && jSONObject4.has(next))) {
                            hashSet.add(next);
                        } else if (jSONObject.has(next) && jSONObject4.has(next) && !jSONObject.getJSONObject(next).toString().equals(jSONObject4.getJSONObject(next).toString())) {
                            hashSet.add(next);
                        } else if (mapB.containsKey(next) != mapB2.containsKey(next)) {
                            hashSet.add(next);
                        } else if (mapB.containsKey(next) && mapB2.containsKey(next) && !((Map) mapB.get(next)).equals(mapB2.get(next))) {
                            hashSet.add(next);
                        } else {
                            jSONObject5.remove(next);
                        }
                    }
                    Iterator<String> itKeys2 = jSONObject5.keys();
                    while (itKeys2.hasNext()) {
                        hashSet.add(itKeys2.next());
                    }
                    if (hashSet.isEmpty()) {
                        Log.d("FirebaseRemoteConfig", "Config was fetched, but no params changed.");
                        return t1.k(null);
                    }
                    synchronized (q3Var2) {
                        Iterator it = ((LinkedHashSet) q3Var2.f8507u).iterator();
                        while (it.hasNext()) {
                            ((l) it.next()).getClass();
                        }
                    }
                    return t1.k(null);
                }
            });
        }
    }
}
