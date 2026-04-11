package ea;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Log;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f3867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f3868h;
    public final float i;

    public i(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f3867g = resources.getDimension(k9.d.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f3868h = resources.getDimension(k9.d.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.i = resources.getDimension(k9.d.m3_back_progress_side_container_max_scale_y_distance);
    }

    public final void a() {
        if (this.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        c.c cVar = this.f;
        this.f = null;
        if (cVar == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f3853b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f3856e);
        animatorSet.start();
    }

    public final void b(c.c cVar, int i, AnimatorListenerAdapter animatorListenerAdapter, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        int i10;
        boolean z10 = cVar.f1939d == 0;
        View view = this.f3853b;
        boolean z11 = (Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3;
        float scaleX = view.getScaleX() * view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i10 = z11 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
        } else {
            i10 = 0;
        }
        float f = scaleX + i10;
        Property property = View.TRANSLATION_X;
        if (z11) {
            f = -f;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new q1.a(1));
        objectAnimatorOfFloat.setDuration(l9.a.c(cVar.f1938c, this.f3854c, this.f3855d));
        objectAnimatorOfFloat.addListener(new h(this, z10, i));
        objectAnimatorOfFloat.addListener(animatorListenerAdapter);
        objectAnimatorOfFloat.start();
    }

    public final void c(float f, boolean z10, int i) {
        float interpolation = this.f3852a.getInterpolation(f);
        View view = this.f3853b;
        boolean z11 = (Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3;
        boolean z12 = z10 == z11;
        int width = view.getWidth();
        int height = view.getHeight();
        float f10 = width;
        if (f10 > 0.0f) {
            float f11 = height;
            if (f11 <= 0.0f) {
                return;
            }
            float f12 = this.f3867g / f10;
            float f13 = this.f3868h / f10;
            float f14 = this.i / f11;
            if (z11) {
                f10 = 0.0f;
            }
            view.setPivotX(f10);
            if (!z12) {
                f13 = -f12;
            }
            float fA = l9.a.a(0.0f, f13, interpolation);
            float f15 = fA + 1.0f;
            float fA2 = 1.0f - l9.a.a(0.0f, f14, interpolation);
            if (Float.isNaN(f15) || Float.isNaN(fA2)) {
                return;
            }
            view.setScaleX(f15);
            view.setScaleY(fA2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    childAt.setPivotX(z11 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f16 = z12 ? 1.0f - fA : 1.0f;
                    float f17 = fA2 != 0.0f ? (f15 / fA2) * f16 : 1.0f;
                    if (!Float.isNaN(f16) && !Float.isNaN(f17)) {
                        childAt.setScaleX(f16);
                        childAt.setScaleY(f17);
                    }
                }
            }
        }
    }
}
