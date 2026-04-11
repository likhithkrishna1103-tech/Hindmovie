package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c0.e;
import java.util.HashMap;
import java.util.WeakHashMap;
import k8.b0;
import p8.a;
import pb.c;
import q0.o0;
import q8.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public HashMap C;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final c D(Context context, boolean z2) {
        int i = z2 ? a.mtrl_fab_transformation_sheet_expand_spec : a.mtrl_fab_transformation_sheet_collapse_spec;
        c cVar = new c(19, false);
        cVar.f10310v = d.b(context, i);
        cVar.f10311w = new b0(22);
        return cVar;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void w(View view, View view2, boolean z2, boolean z10) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z2) {
                this.C = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z11 = (childAt.getLayoutParams() instanceof e) && (((e) childAt.getLayoutParams()).f2209a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z11) {
                    if (z2) {
                        this.C.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap = o0.f10475a;
                        childAt.setImportantForAccessibility(4);
                    } else {
                        HashMap map = this.C;
                        if (map != null && map.containsKey(childAt)) {
                            int iIntValue = ((Integer) this.C.get(childAt)).intValue();
                            WeakHashMap weakHashMap2 = o0.f10475a;
                            childAt.setImportantForAccessibility(iIntValue);
                        }
                    }
                }
            }
            if (!z2) {
                this.C = null;
            }
        }
        super.w(view, view2, z2, z10);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
