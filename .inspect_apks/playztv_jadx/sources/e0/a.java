package e0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import ea.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f4231u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Activity f4232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f4233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4234x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4235y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4236z = false;

    public a(Activity activity) {
        this.f4232v = activity;
        this.f4233w = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f4232v == activity) {
            this.f4232v = null;
            this.f4235y = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.f4235y || this.f4236z || this.f4234x) {
            return;
        }
        Object obj = this.f4231u;
        try {
            Object obj2 = b.f4239c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.f4233w) {
                b.f4242g.postAtFrontOfQueue(new t(b.f4238b.get(activity), 5, obj2));
                this.f4236z = true;
                this.f4231u = null;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f4232v == activity) {
            this.f4234x = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
