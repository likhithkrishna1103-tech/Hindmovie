package v8;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l9.g;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends g {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final int f13333e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final int f13334f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final int f13335g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final int f13336h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f13337i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final ArrayList f13338j0;

    public b(Context context) {
        super(context);
        this.f13338j0 = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f13333e0 = resources.getDimensionPixelSize(p8.d.design_bottom_navigation_item_max_width);
        this.f13334f0 = resources.getDimensionPixelSize(p8.d.design_bottom_navigation_item_min_width);
        this.f13335g0 = resources.getDimensionPixelSize(p8.d.design_bottom_navigation_active_item_max_width);
        this.f13336h0 = resources.getDimensionPixelSize(p8.d.design_bottom_navigation_active_item_min_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int i13 = i11 - i;
        int i14 = i12 - i10;
        int measuredWidth = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                WeakHashMap weakHashMap = o0.f10475a;
                if (getLayoutDirection() == 1) {
                    int i16 = i13 - measuredWidth;
                    childAt.layout(i16 - childAt.getMeasuredWidth(), 0, i16, i14);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i14);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v8.b.onMeasure(int, int):void");
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.f13337i0 = z2;
    }
}
