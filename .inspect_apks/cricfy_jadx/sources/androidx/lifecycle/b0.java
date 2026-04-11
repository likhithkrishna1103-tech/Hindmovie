package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends g {
    final /* synthetic */ c0 this$0;

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static final class a extends g {
        final /* synthetic */ c0 this$0;

        public a(c0 c0Var) {
            this.this$0 = c0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            ge.i.e(activity, "activity");
            this.this$0.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            ge.i.e(activity, "activity");
            c0 c0Var = this.this$0;
            int i = c0Var.f1147v + 1;
            c0Var.f1147v = i;
            if (i == 1 && c0Var.f1150y) {
                c0Var.A.d(m.ON_START);
                c0Var.f1150y = false;
            }
        }
    }

    public b0(c0 c0Var) {
        this.this$0 = c0Var;
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        ge.i.e(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i = g0.f1156w;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            ge.i.c(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((g0) fragmentFindFragmentByTag).f1157v = this.this$0.C;
        }
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ge.i.e(activity, "activity");
        c0 c0Var = this.this$0;
        int i = c0Var.f1148w - 1;
        c0Var.f1148w = i;
        if (i == 0) {
            Handler handler = c0Var.f1151z;
            ge.i.b(handler);
            handler.postDelayed(c0Var.B, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        ge.i.e(activity, "activity");
        a0.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ge.i.e(activity, "activity");
        c0 c0Var = this.this$0;
        int i = c0Var.f1147v - 1;
        c0Var.f1147v = i;
        if (i == 0 && c0Var.f1149x) {
            c0Var.A.d(m.ON_STOP);
            c0Var.f1150y = true;
        }
    }
}
