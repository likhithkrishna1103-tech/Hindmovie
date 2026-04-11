package jb;

import android.os.Bundle;
import android.util.Log;
import androidx.emoji2.text.g;
import i2.k;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kf.i;
import nb.n;
import o8.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements mb.a, lb.a, hc.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g f6722v;

    public /* synthetic */ a(g gVar) {
        this.f6722v = gVar;
    }

    @Override // mb.a
    public void a(n nVar) {
        g gVar = this.f6722v;
        synchronized (gVar) {
            try {
                if (((mb.a) gVar.f854b) instanceof mb.b) {
                    ((ArrayList) gVar.f855c).add(nVar);
                }
                ((mb.a) gVar.f854b).a(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // hc.a
    public void j(hc.b bVar) {
        g gVar = this.f6722v;
        kb.c cVar = kb.c.f7396a;
        cVar.b("AnalyticsConnector now available.");
        eb.b bVar2 = (eb.b) bVar.get();
        l4.a aVar = new l4.a(bVar2);
        k kVar = new k();
        eb.c cVar2 = (eb.c) bVar2;
        j jVarB = cVar2.b("clx", kVar);
        if (jVarB == null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Could not register AnalyticsConnectorListener with Crashlytics origin.", null);
            }
            jVarB = cVar2.b("crash", kVar);
            if (jVarB != null) {
                Log.w("FirebaseCrashlytics", "A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.", null);
            }
        }
        if (jVarB == null) {
            cVar.f("Could not register Firebase Analytics listener; a listener is already registered.", null);
            return;
        }
        cVar.b("Registered Firebase Analytics listener.");
        i iVar = new i(3, false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        l7.a aVar2 = new l7.a(aVar);
        synchronized (gVar) {
            try {
                ArrayList arrayList = (ArrayList) gVar.f855c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    iVar.a((n) obj);
                }
                kVar.f6086w = iVar;
                kVar.f6085v = aVar2;
                gVar.f854b = iVar;
                gVar.f853a = aVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // lb.a
    public void q(Bundle bundle) {
        ((lb.a) this.f6722v.f853a).q(bundle);
    }
}
