package cc;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final w0 f2721u = new w0();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f2722v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static ub.o f2723w;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        be.h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        be.h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        be.h.e(activity, "activity");
        ub.o oVar = f2723w;
        if (oVar != null) {
            oVar.V(2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        nd.k kVar;
        be.h.e(activity, "activity");
        ub.o oVar = f2723w;
        if (oVar != null) {
            oVar.V(1);
            kVar = nd.k.f8990a;
        } else {
            kVar = null;
        }
        if (kVar == null) {
            f2722v = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        be.h.e(activity, "activity");
        be.h.e(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        be.h.e(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        be.h.e(activity, "activity");
    }
}
