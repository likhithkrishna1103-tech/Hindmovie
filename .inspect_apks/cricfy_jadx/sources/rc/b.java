package rc;

import android.util.Log;
import j9.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10926v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f10927w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ i2.f f10928x;

    public b(i2.f fVar, int i, long j4) {
        this.f10928x = fVar;
        this.f10926v = i;
        this.f10927w = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final i2.f fVar = this.f10928x;
        int i = this.f10926v;
        final long j4 = this.f10927w;
        synchronized (fVar) {
            final int i10 = i - 1;
            final p pVarC = ((g) fVar.f5995d).c(3 - i10);
            final p pVarB = ((c) fVar.f5996e).b();
            vf.g.c0(pVarC, pVarB).f((ScheduledExecutorService) fVar.f5997g, new j9.a() { // from class: rc.a
                @Override // j9.a
                public final Object c(p pVar) throws JSONException {
                    Boolean boolValueOf;
                    i2.f fVar2 = fVar;
                    p pVar2 = pVarC;
                    p pVar3 = pVarB;
                    long j7 = j4;
                    int i11 = i10;
                    if (!pVar2.j()) {
                        return vf.g.z(new qc.c("Failed to auto-fetch config update.", pVar2.g()));
                    }
                    if (!pVar3.j()) {
                        return vf.g.z(new qc.c("Failed to get activated config for auto-fetch", pVar3.g()));
                    }
                    f fVar3 = (f) pVar2.h();
                    e eVarA = (e) pVar3.h();
                    e eVar = fVar3.f10947b;
                    if (eVar != null) {
                        boolValueOf = Boolean.valueOf(eVar.f >= j7);
                    } else {
                        boolValueOf = Boolean.valueOf(fVar3.f10946a == 1);
                    }
                    if (!boolValueOf.booleanValue()) {
                        Log.d("FirebaseRemoteConfig", "Fetched template version is the same as SDK's current version. Retrying fetch.");
                        fVar2.a(i11, j7);
                        return vf.g.A(null);
                    }
                    if (fVar3.f10947b == null) {
                        Log.d("FirebaseRemoteConfig", "The fetch succeeded, but the backend had no updates.");
                        return vf.g.A(null);
                    }
                    if (eVarA == null) {
                        eVarA = e.c().a();
                    }
                    e eVar2 = fVar3.f10947b;
                    JSONObject jSONObject = eVarA.f10944e;
                    JSONObject jSONObject2 = eVar2.f10940a;
                    JSONObject jSONObject3 = eVar2.f10941b;
                    JSONObject jSONObject4 = eVar2.f10944e;
                    JSONObject jSONObject5 = e.a(new JSONObject(jSONObject2.toString())).f10941b;
                    HashMap mapB = eVarA.b();
                    HashMap mapB2 = eVar2.b();
                    HashSet hashSet = new HashSet();
                    JSONObject jSONObject6 = eVarA.f10941b;
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
                        return vf.g.A(null);
                    }
                    synchronized (fVar2) {
                        Iterator it = ((LinkedHashSet) fVar2.f5993b).iterator();
                        while (it.hasNext()) {
                            ((i) it.next()).getClass();
                        }
                    }
                    return vf.g.A(null);
                }
            });
        }
    }
}
