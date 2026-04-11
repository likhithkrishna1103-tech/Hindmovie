package vc;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ab.g f13670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yc.j f13671b;

    public o(ab.g gVar, yc.j jVar, vd.h hVar, u0 u0Var) {
        ge.i.e(gVar, "firebaseApp");
        ge.i.e(jVar, "settings");
        ge.i.e(hVar, "backgroundDispatcher");
        ge.i.e(u0Var, "sessionsActivityLifecycleCallbacks");
        this.f13670a = gVar;
        this.f13671b = jVar;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions 3.0.4.");
        gVar.a();
        Context applicationContext = gVar.f390a.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(u0Var);
            pe.x.k(pe.x.b(hVar), null, new d1.e(this, u0Var, null, 9), 3);
        } else {
            Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
        }
    }
}
