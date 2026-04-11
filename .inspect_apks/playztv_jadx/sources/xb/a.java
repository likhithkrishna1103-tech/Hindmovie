package xb;

import android.util.Log;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import o8.o;
import org.json.JSONArray;
import org.json.JSONException;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements o8.g, o8.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ b f14334u;

    public /* synthetic */ a(b bVar) {
        this.f14334u = bVar;
    }

    @Override // o8.a
    public Object b(o oVar) {
        boolean z2;
        b bVar = this.f14334u;
        if (oVar.j()) {
            yb.c cVar = bVar.f14338d;
            synchronized (cVar) {
                cVar.f14584c = t1.k(null);
            }
            cVar.f14583b.a();
            yb.e eVar = (yb.e) oVar.h();
            if (eVar != null) {
                JSONArray jSONArray = eVar.f14594d;
                ha.c cVar2 = bVar.f14336b;
                if (cVar2 != null) {
                    try {
                        cVar2.c(b.c(jSONArray));
                    } catch (ha.a e10) {
                        Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e10);
                    } catch (JSONException e11) {
                        Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e11);
                    }
                }
                z0.i iVar = bVar.f14343k;
                try {
                    bc.d dVarD = ((pb.c) iVar.f14762b).d(eVar);
                    Iterator it = ((Set) iVar.f14764d).iterator();
                    while (it.hasNext()) {
                        ((Executor) iVar.f14763c).execute(new zb.a((qa.b) it.next(), dVarD, 0));
                    }
                } catch (d e12) {
                    Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e12);
                }
            } else {
                Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            }
            z2 = true;
        } else {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    @Override // o8.g
    public o r(Object obj) {
        b bVar = this.f14334u;
        o oVarB = bVar.f14338d.b();
        o oVarB2 = bVar.f14339e.b();
        return t1.y(oVarB, oVarB2).f(bVar.f14337c, new dd.e(bVar, oVarB, oVarB2, 12));
    }
}
