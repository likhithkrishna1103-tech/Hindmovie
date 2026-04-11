package pa;

import android.os.Bundle;
import android.util.Log;
import androidx.emoji2.text.g;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import k8.b0;
import n.a1;
import q0.e;
import ta.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements sa.a, ra.a, nb.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ g f10297u;

    public /* synthetic */ a(g gVar) {
        this.f10297u = gVar;
    }

    @Override // nb.a
    public void c(nb.b bVar) {
        g gVar = this.f10297u;
        qa.c cVar = qa.c.f11167a;
        cVar.b("AnalyticsConnector now available.");
        ka.b bVar2 = (ka.b) bVar.get();
        a1 a1Var = new a1(bVar2);
        p2.c cVar2 = new p2.c(2, false);
        ka.c cVar3 = (ka.c) bVar2;
        b0 b0VarB = cVar3.b("clx", cVar2);
        if (b0VarB == null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Could not register AnalyticsConnectorListener with Crashlytics origin.", null);
            }
            b0VarB = cVar3.b("crash", cVar2);
            if (b0VarB != null) {
                Log.w("FirebaseCrashlytics", "A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.", null);
            }
        }
        if (b0VarB == null) {
            cVar.f("Could not register Firebase Analytics listener; a listener is already registered.", null);
            return;
        }
        cVar.b("Registered Firebase Analytics listener.");
        e eVar = new e(6, false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        kc.b bVar3 = new kc.b(a1Var);
        synchronized (gVar) {
            try {
                ArrayList arrayList = (ArrayList) gVar.f1173c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    eVar.e((o) obj);
                }
                cVar2.f10131w = eVar;
                cVar2.f10130v = bVar3;
                gVar.f1172b = eVar;
                gVar.f1171a = bVar3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // sa.a
    public void e(o oVar) {
        g gVar = this.f10297u;
        synchronized (gVar) {
            try {
                if (((sa.a) gVar.f1172b) instanceof sa.b) {
                    ((ArrayList) gVar.f1173c).add(oVar);
                }
                ((sa.a) gVar.f1172b).e(oVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ra.a
    public void p(Bundle bundle) {
        ((ra.a) this.f10297u.f1171a).p(bundle);
    }
}
