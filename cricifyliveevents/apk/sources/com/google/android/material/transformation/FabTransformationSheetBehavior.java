package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import f0.e;
import f9.a0;
import java.util.HashMap;
import k9.a;
import l9.d;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public HashMap D;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final w D(Context context, boolean z10) {
        int i = z10 ? a.mtrl_fab_transformation_sheet_expand_spec : a.mtrl_fab_transformation_sheet_collapse_spec;
        w wVar = new w(13, false);
        wVar.f9016w = d.b(context, i);
        wVar.f9017x = new a0(16);
        return wVar;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void w(View view, View view2, boolean z10, boolean z11) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                this.D = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z12 = (childAt.getLayoutParams() instanceof e) && (((e) childAt.getLayoutParams()).f3897a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z12) {
                    if (z10) {
                        this.D.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        childAt.setImportantForAccessibility(4);
                    } else {
                        HashMap map = this.D;
                        if (map != null && map.containsKey(childAt)) {
                            childAt.setImportantForAccessibility(((Integer) this.D.get(childAt)).intValue());
                        }
                    }
                }
            }
            if (!z10) {
                this.D = null;
            }
        }
        super.w(view, view2, z10, z11);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
