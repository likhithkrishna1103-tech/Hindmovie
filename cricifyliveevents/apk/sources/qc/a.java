package qc;

import android.util.Log;
import j9.p;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import nb.w;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements j9.h, j9.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ b f10785v;

    public /* synthetic */ a(b bVar) {
        this.f10785v = bVar;
    }

    @Override // j9.h
    public p B(Object obj) {
        b bVar = this.f10785v;
        p pVarB = bVar.f10789d.b();
        p pVarB2 = bVar.f10790e.b();
        return vf.g.c0(pVarB, pVarB2).f(bVar.f10788c, new c8.b(bVar, pVarB, pVarB2, 10));
    }

    @Override // j9.a
    public Object c(p pVar) {
        boolean z10;
        b bVar = this.f10785v;
        if (pVar.j()) {
            rc.c cVar = bVar.f10789d;
            synchronized (cVar) {
                cVar.f10933c = vf.g.A(null);
            }
            cVar.f10932b.a();
            rc.e eVar = (rc.e) pVar.h();
            if (eVar != null) {
                JSONArray jSONArray = eVar.f10943d;
                bb.c cVar2 = bVar.f10787b;
                if (cVar2 != null) {
                    try {
                        cVar2.c(b.b(jSONArray));
                    } catch (bb.a e9) {
                        Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e9);
                    } catch (JSONException e10) {
                        Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e10);
                    }
                }
                nc.p pVar2 = bVar.f10794k;
                try {
                    uc.d dVarD = ((w) pVar2.f9070b).D(eVar);
                    Iterator it = ((Set) pVar2.f9072d).iterator();
                    while (it.hasNext()) {
                        ((Executor) pVar2.f9071c).execute(new sc.a((kb.b) it.next(), dVarD, 0));
                    }
                } catch (d e11) {
                    Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e11);
                }
            } else {
                Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
