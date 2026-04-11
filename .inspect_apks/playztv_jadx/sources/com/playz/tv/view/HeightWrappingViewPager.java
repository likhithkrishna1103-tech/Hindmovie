package com.playz.tv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import k5.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class HeightWrappingViewPager extends i {
    public HeightWrappingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // k5.i, android.view.View
    public final void onMeasure(int i, int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            int i11 = 0;
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i11) {
                    i11 = measuredHeight;
                }
            }
            i10 = View.MeasureSpec.makeMeasureSpec(Math.max(i11, (int) (getContext().getResources().getDisplayMetrics().heightPixels * (getResources().getConfiguration().orientation == 2 ? 0.55f : 0.3f))), 1073741824);
        }
        super.onMeasure(i, i10);
    }
}
