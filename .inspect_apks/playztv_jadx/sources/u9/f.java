package u9;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import j9.f0;
import java.util.WeakHashMap;
import k8.c0;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends LinearLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f12800w = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ValueAnimator f12801u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ TabLayout f12802v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TabLayout tabLayout, Context context) {
        super(context);
        this.f12802v = tabLayout;
        setWillNotDraw(false);
    }

    public final void a(int i) {
        TabLayout tabLayout = this.f12802v;
        if (tabLayout.f3492q0 == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
            View childAt = getChildAt(i);
            c0 c0Var = tabLayout.f3481e0;
            Drawable drawable = tabLayout.I;
            c0Var.getClass();
            RectF rectFG = c0.g(tabLayout, childAt);
            drawable.setBounds((int) rectFG.left, drawable.getBounds().top, (int) rectFG.right, drawable.getBounds().bottom);
            tabLayout.f3494u = i;
        }
    }

    public final void b(int i) {
        TabLayout tabLayout = this.f12802v;
        Rect bounds = tabLayout.I.getBounds();
        tabLayout.I.setBounds(bounds.left, 0, bounds.right, i);
        requestLayout();
    }

    public final void c(View view, View view2, float f) {
        TabLayout tabLayout = this.f12802v;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.I;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.I.getBounds().bottom);
        } else {
            tabLayout.f3481e0.j(tabLayout, view, view2, f, tabLayout.I);
        }
        WeakHashMap weakHashMap = o0.f10475a;
        postInvalidateOnAnimation();
    }

    public final void d(int i, int i10, boolean z2) {
        TabLayout tabLayout = this.f12802v;
        if (tabLayout.f3494u == i) {
            return;
        }
        View childAt = getChildAt(tabLayout.getSelectedTabPosition());
        View childAt2 = getChildAt(i);
        if (childAt2 == null) {
            a(tabLayout.getSelectedTabPosition());
            return;
        }
        tabLayout.f3494u = i;
        e eVar = new e(this, childAt, childAt2);
        if (!z2) {
            this.f12801u.removeAllUpdateListeners();
            this.f12801u.addUpdateListener(eVar);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f12801u = valueAnimator;
        valueAnimator.setInterpolator(tabLayout.f3482f0);
        valueAnimator.setDuration(i10);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(eVar);
        valueAnimator.start();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.f12802v;
        int iHeight = tabLayout.I.getBounds().height();
        if (iHeight < 0) {
            iHeight = tabLayout.I.getIntrinsicHeight();
        }
        int i = tabLayout.U;
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
        if (tabLayout.I.getBounds().width() > 0) {
            Rect bounds = tabLayout.I.getBounds();
            tabLayout.I.setBounds(bounds.left, height, bounds.right, iHeight);
            tabLayout.I.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        ValueAnimator valueAnimator = this.f12801u;
        TabLayout tabLayout = this.f12802v;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            d(tabLayout.getSelectedTabPosition(), -1, false);
            return;
        }
        if (tabLayout.f3494u == -1) {
            tabLayout.f3494u = tabLayout.getSelectedTabPosition();
        }
        a(tabLayout.f3494u);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.f12802v;
        boolean z2 = true;
        if (tabLayout.S == 1 || tabLayout.V == 2) {
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
            if (iMax * childCount <= getMeasuredWidth() - (((int) f0.b(getContext(), 16)) * 2)) {
                boolean z10 = false;
                for (int i12 = 0; i12 < childCount; i12++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i12).getLayoutParams();
                    if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.width = iMax;
                        layoutParams.weight = 0.0f;
                        z10 = true;
                    }
                }
                z2 = z10;
            } else {
                tabLayout.S = 0;
                tabLayout.n(false);
            }
            if (z2) {
                super.onMeasure(i, i10);
            }
        }
    }
}
