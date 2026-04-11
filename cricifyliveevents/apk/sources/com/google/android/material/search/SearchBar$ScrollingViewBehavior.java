package com.google.android.material.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class SearchBar$ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    public boolean B;

    public SearchBar$ScrollingViewBehavior() {
        this.B = false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, f0.b
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        super.h(coordinatorLayout, view, view2);
        if (!this.B && (view2 instanceof AppBarLayout)) {
            this.B = true;
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }
        return false;
    }

    public SearchBar$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = false;
    }
}
