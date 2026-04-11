package app.cricfy.tv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import p5.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class HeightWrappingViewPager extends g {
    public HeightWrappingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // p5.g, android.view.View
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
