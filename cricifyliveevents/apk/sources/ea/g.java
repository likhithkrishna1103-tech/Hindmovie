package ea;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f3862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f3863h;

    public g(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f3862g = resources.getDimension(k9.d.m3_back_progress_bottom_container_max_scale_x_distance);
        this.f3863h = resources.getDimension(k9.d.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public final AnimatorSet a() {
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f3853b;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new q1.a(1));
        return animatorSet;
    }

    public final void b(float f) {
        float interpolation = this.f3852a.getInterpolation(f);
        View view = this.f3853b;
        float width = view.getWidth();
        float height = view.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f10 = this.f3862g / width;
        float f11 = this.f3863h / height;
        float fA = 1.0f - l9.a.a(0.0f, f10, interpolation);
        float fA2 = 1.0f - l9.a.a(0.0f, f11, interpolation);
        if (Float.isNaN(fA) || Float.isNaN(fA2)) {
            return;
        }
        view.setScaleX(fA);
        view.setPivotY(height);
        view.setScaleY(fA2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fA2 != 0.0f ? fA / fA2 : 1.0f);
            }
        }
    }
}
