package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends g {
    final /* synthetic */ c0 this$0;

    /* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
    public static final class a extends g {
        final /* synthetic */ c0 this$0;

        public a(c0 c0Var) {
            this.this$0 = c0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            be.h.e(activity, "activity");
            this.this$0.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            be.h.e(activity, "activity");
            c0 c0Var = this.this$0;
            int i = c0Var.f1449u + 1;
            c0Var.f1449u = i;
            if (i == 1 && c0Var.f1452x) {
                c0Var.f1454z.d(m.ON_START);
                c0Var.f1452x = false;
            }
        }
    }

    public b0(c0 c0Var) {
        this.this$0 = c0Var;
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        be.h.e(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i = g0.f1459v;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            be.h.c(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((g0) fragmentFindFragmentByTag).f1460u = this.this$0.B;
        }
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        be.h.e(activity, "activity");
        c0 c0Var = this.this$0;
        int i = c0Var.f1450v - 1;
        c0Var.f1450v = i;
        if (i == 0) {
            Handler handler = c0Var.f1453y;
            be.h.b(handler);
            handler.postDelayed(c0Var.A, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        be.h.e(activity, "activity");
        a0.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        be.h.e(activity, "activity");
        c0 c0Var = this.this$0;
        int i = c0Var.f1449u - 1;
        c0Var.f1449u = i;
        if (i == 0 && c0Var.f1451w) {
            c0Var.f1454z.d(m.ON_STOP);
            c0Var.f1452x = true;
        }
    }
}
