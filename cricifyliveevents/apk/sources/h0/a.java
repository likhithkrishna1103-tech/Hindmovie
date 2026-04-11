package h0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f5425v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Activity f5426w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f5427x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f5428y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5429z = false;
    public boolean A = false;

    public a(Activity activity) {
        this.f5426w = activity;
        this.f5427x = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f5426w == activity) {
            this.f5426w = null;
            this.f5429z = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.f5429z || this.A || this.f5428y) {
            return;
        }
        Object obj = this.f5425v;
        try {
            Object obj2 = b.f5432c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.f5427x) {
                b.f5435g.postAtFrontOfQueue(new ya.s(20, b.f5431b.get(activity), obj2));
                this.A = true;
                this.f5425v = null;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f5426w == activity) {
            this.f5428y = true;
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
