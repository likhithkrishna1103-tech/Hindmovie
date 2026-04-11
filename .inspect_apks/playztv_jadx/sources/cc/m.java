package cc;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ga.g f2675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ec.j f2676b;

    public m(ga.g gVar, ec.j jVar, rd.h hVar, u0 u0Var) {
        this.f2675a = gVar;
        this.f2676b = jVar;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions SDK.");
        gVar.a();
        Context applicationContext = gVar.f5346a.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(w0.f2721u);
            ke.x.j(ke.x.a(hVar), null, new l(this, hVar, u0Var, null, 0), 3);
        } else {
            Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
        }
    }
}
