package com.google.android.material.appbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import u0.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends t0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f2769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f2770e;
    public final /* synthetic */ AppBarLayout.BaseBehavior f;

    public b(CoordinatorLayout coordinatorLayout, AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout) {
        this.f = baseBehavior;
        this.f2769d = appBarLayout;
        this.f2770e = coordinatorLayout;
    }

    @Override // t0.b
    public final void d(View view, e eVar) {
        this.f11731a.onInitializeAccessibilityNodeInfo(view, eVar.f12062a);
        eVar.i(ScrollView.class.getName());
        AppBarLayout appBarLayout = this.f2769d;
        if (appBarLayout.getTotalScrollRange() == 0) {
            return;
        }
        CoordinatorLayout coordinatorLayout = this.f2770e;
        AppBarLayout.BaseBehavior baseBehavior = this.f;
        View viewB = AppBarLayout.BaseBehavior.B(baseBehavior, coordinatorLayout);
        if (viewB == null) {
            return;
        }
        int childCount = appBarLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((m9.d) appBarLayout.getChildAt(i).getLayoutParams()).f8397a != 0) {
                if (baseBehavior.y() != (-appBarLayout.getTotalScrollRange())) {
                    eVar.b(u0.c.f12048h);
                    eVar.k(true);
                }
                if (baseBehavior.y() != 0) {
                    if (!viewB.canScrollVertically(-1)) {
                        eVar.b(u0.c.i);
                        eVar.k(true);
                        return;
                    } else {
                        if ((-appBarLayout.getDownNestedPreScrollRange()) != 0) {
                            eVar.b(u0.c.i);
                            eVar.k(true);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override // t0.b
    public final boolean g(View view, int i, Bundle bundle) {
        AppBarLayout appBarLayout = this.f2769d;
        if (i == 4096) {
            appBarLayout.setExpanded(false);
            return true;
        }
        if (i != 8192) {
            return super.g(view, i, bundle);
        }
        AppBarLayout.BaseBehavior baseBehavior = this.f;
        if (baseBehavior.y() != 0) {
            CoordinatorLayout coordinatorLayout = this.f2770e;
            View viewB = AppBarLayout.BaseBehavior.B(baseBehavior, coordinatorLayout);
            if (!viewB.canScrollVertically(-1)) {
                appBarLayout.setExpanded(true);
                return true;
            }
            int i10 = -appBarLayout.getDownNestedPreScrollRange();
            if (i10 != 0) {
                baseBehavior.E(coordinatorLayout, this.f2769d, viewB, i10, new int[]{0, 0});
                return true;
            }
        }
        return false;
    }
}
