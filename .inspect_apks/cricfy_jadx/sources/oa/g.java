package oa;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import da.e0;
import f9.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends LinearLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f9718x = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ValueAnimator f9719v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ TabLayout f9720w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TabLayout tabLayout, Context context) {
        super(context);
        this.f9720w = tabLayout;
        setWillNotDraw(false);
    }

    public final void a(int i) {
        TabLayout tabLayout = this.f9720w;
        if (tabLayout.f2957s0 == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
            View childAt = getChildAt(i);
            z zVar = tabLayout.f2946g0;
            Drawable drawable = tabLayout.J;
            zVar.getClass();
            RectF rectFI = z.i(tabLayout, childAt);
            drawable.setBounds((int) rectFI.left, drawable.getBounds().top, (int) rectFI.right, drawable.getBounds().bottom);
            tabLayout.f2959v = i;
        }
    }

    public final void b(int i) {
        TabLayout tabLayout = this.f9720w;
        Rect bounds = tabLayout.J.getBounds();
        tabLayout.J.setBounds(bounds.left, 0, bounds.right, i);
        requestLayout();
    }

    public final void c(View view, View view2, float f) {
        TabLayout tabLayout = this.f9720w;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.J;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.J.getBounds().bottom);
        } else {
            tabLayout.f2946g0.s(tabLayout, view, view2, f, tabLayout.J);
        }
        postInvalidateOnAnimation();
    }

    public final void d(int i, int i10, boolean z10) {
        TabLayout tabLayout = this.f9720w;
        if (tabLayout.f2959v == i) {
            return;
        }
        View childAt = getChildAt(tabLayout.getSelectedTabPosition());
        View childAt2 = getChildAt(i);
        if (childAt2 == null) {
            a(tabLayout.getSelectedTabPosition());
            return;
        }
        tabLayout.f2959v = i;
        f fVar = new f(this, childAt, childAt2);
        if (!z10) {
            this.f9719v.removeAllUpdateListeners();
            this.f9719v.addUpdateListener(fVar);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f9719v = valueAnimator;
        valueAnimator.setInterpolator(tabLayout.f2947h0);
        valueAnimator.setDuration(i10);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.start();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.f9720w;
        int iHeight = tabLayout.J.getBounds().height();
        if (iHeight < 0) {
            iHeight = tabLayout.J.getIntrinsicHeight();
        }
        int i = tabLayout.W;
        if (i == 0) {
            height = getHeight() - iHeight;
            iHeight = getHeight();
        } else if (i != 1) {
            height = 0;
            if (i != 2) {
                iHeight = i != 3 ? 0 : getHeight();
            }
        } else {
            height = (getHeight() - iHeight) / 2;
            iHeight = (getHeight() + iHeight) / 2;
        }
        if (tabLayout.J.getBounds().width() > 0) {
            Rect bounds = tabLayout.J.getBounds();
            tabLayout.J.setBounds(bounds.left, height, bounds.right, iHeight);
            tabLayout.J.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        ValueAnimator valueAnimator = this.f9719v;
        TabLayout tabLayout = this.f9720w;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            d(tabLayout.getSelectedTabPosition(), -1, false);
            return;
        }
        if (tabLayout.f2959v == -1) {
            tabLayout.f2959v = tabLayout.getSelectedTabPosition();
        }
        a(tabLayout.f2959v);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.f9720w;
        boolean z10 = true;
        if (tabLayout.U == 1 || tabLayout.f2940a0 == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredWidth() - (((int) e0.a(getContext(), 16)) * 2)) {
                boolean z11 = false;
                for (int i12 = 0; i12 < childCount; i12++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i12).getLayoutParams();
                    if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.width = iMax;
                        layoutParams.weight = 0.0f;
                        z11 = true;
                    }
                }
                z10 = z11;
            } else {
                tabLayout.U = 0;
                tabLayout.n(false);
            }
            if (z10) {
                super.onMeasure(i, i10);
            }
        }
    }
}
