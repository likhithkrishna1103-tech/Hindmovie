package k9;

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
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f7592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f7593h;
    public final float i;

    public h(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f7592g = resources.getDimension(p8.d.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.f7593h = resources.getDimension(p8.d.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.i = resources.getDimension(p8.d.m3_back_progress_side_container_max_scale_y_distance);
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
        View view = this.f7580b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f7583e);
        animatorSet.start();
    }

    public final void b(c.c cVar, int i, AnimatorListenerAdapter animatorListenerAdapter, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        int i10;
        boolean z2 = cVar.f2154d == 0;
        WeakHashMap weakHashMap = o0.f10475a;
        View view = this.f7580b;
        boolean z10 = (Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3;
        float scaleX = view.getScaleX() * view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i10 = z10 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
        } else {
            i10 = 0;
        }
        float f = scaleX + i10;
        Property property = View.TRANSLATION_X;
        if (z10) {
            f = -f;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new k1.a(1));
        objectAnimatorOfFloat.setDuration(q8.a.c(cVar.f2153c, this.f7581c, this.f7582d));
        objectAnimatorOfFloat.addListener(new g(this, z2, i));
        objectAnimatorOfFloat.addListener(animatorListenerAdapter);
        objectAnimatorOfFloat.start();
    }

    public final void c(float f, boolean z2, int i) {
        float interpolation = this.f7579a.getInterpolation(f);
        WeakHashMap weakHashMap = o0.f10475a;
        View view = this.f7580b;
        boolean z10 = (Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3;
        boolean z11 = z2 == z10;
        int width = view.getWidth();
        int height = view.getHeight();
        float f4 = width;
        if (f4 > 0.0f) {
            float f10 = height;
            if (f10 <= 0.0f) {
                return;
            }
            float f11 = this.f7592g / f4;
            float f12 = this.f7593h / f4;
            float f13 = this.i / f10;
            if (z10) {
                f4 = 0.0f;
            }
            view.setPivotX(f4);
            if (!z11) {
                f12 = -f11;
            }
            float fA = q8.a.a(0.0f, f12, interpolation);
            float f14 = fA + 1.0f;
            view.setScaleX(f14);
            float fA2 = 1.0f - q8.a.a(0.0f, f13, interpolation);
            view.setScaleY(fA2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    childAt.setPivotX(z10 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f15 = z11 ? 1.0f - fA : 1.0f;
                    float f16 = fA2 != 0.0f ? (f14 / fA2) * f15 : 1.0f;
                    childAt.setScaleX(f15);
                    childAt.setScaleY(f16);
                }
            }
        }
    }
}
