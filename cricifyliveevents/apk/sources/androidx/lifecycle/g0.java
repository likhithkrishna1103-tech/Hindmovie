package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g0 extends Fragment {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f1156w = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p6.c f1157v;

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final f0 Companion = new f0();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            ge.i.e(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ge.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            ge.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ge.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            ge.i.e(activity, "activity");
            int i = g0.f1156w;
            d0.a(activity, m.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            ge.i.e(activity, "activity");
            int i = g0.f1156w;
            d0.a(activity, m.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            ge.i.e(activity, "activity");
            int i = g0.f1156w;
            d0.a(activity, m.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            ge.i.e(activity, "activity");
            int i = g0.f1156w;
            d0.a(activity, m.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            ge.i.e(activity, "activity");
            int i = g0.f1156w;
            d0.a(activity, m.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            ge.i.e(activity, "activity");
            int i = g0.f1156w;
            d0.a(activity, m.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            ge.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            ge.i.e(activity, "activity");
            ge.i.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ge.i.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ge.i.e(activity, "activity");
        }
    }

    public final void a(m mVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            ge.i.d(activity, "activity");
            d0.a(activity, mVar);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(m.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(m.ON_DESTROY);
        this.f1157v = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(m.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        p6.c cVar = this.f1157v;
        if (cVar != null) {
            ((c0) cVar.f10035w).b();
        }
        a(m.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        p6.c cVar = this.f1157v;
        if (cVar != null) {
            c0 c0Var = (c0) cVar.f10035w;
            int i = c0Var.f1147v + 1;
            c0Var.f1147v = i;
            if (i == 1 && c0Var.f1150y) {
                c0Var.A.d(m.ON_START);
                c0Var.f1150y = false;
            }
        }
        a(m.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(m.ON_STOP);
    }
}
