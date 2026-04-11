package i4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.DefaultTimeBar;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f6319b;

    public /* synthetic */ v(x xVar, int i) {
        this.f6318a = i;
        this.f6319b = xVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f6318a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x xVar = this.f6319b;
                View view = xVar.f6326b;
                if (view != null) {
                    view.setVisibility(4);
                }
                ViewGroup viewGroup = xVar.f6327c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                ViewGroup viewGroup2 = xVar.f6329e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                }
                break;
            case 1:
            default:
                super.onAnimationEnd(animator);
                break;
            case 2:
                this.f6319b.i(0);
                break;
            case 3:
                this.f6319b.i(0);
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ViewGroup viewGroup3 = this.f6319b.f;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(4);
                }
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                ViewGroup viewGroup4 = this.f6319b.f6331h;
                if (viewGroup4 != null) {
                    viewGroup4.setVisibility(4);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i = this.f6318a;
        x xVar = this.f6319b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                View view = xVar.f6332j;
                if ((view instanceof DefaultTimeBar) && !xVar.A) {
                    DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                    ValueAnimator valueAnimator = defaultTimeBar.f1595b0;
                    if (valueAnimator.isStarted()) {
                        valueAnimator.cancel();
                    }
                    valueAnimator.setFloatValues(defaultTimeBar.f1596c0, 0.0f);
                    valueAnimator.setDuration(250L);
                    valueAnimator.start();
                    break;
                }
                break;
            case 1:
                View view2 = xVar.f6326b;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ViewGroup viewGroup = xVar.f6327c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                ViewGroup viewGroup2 = xVar.f6329e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(xVar.A ? 0 : 4);
                }
                View view3 = xVar.f6332j;
                if ((view3 instanceof DefaultTimeBar) && !xVar.A) {
                    DefaultTimeBar defaultTimeBar2 = (DefaultTimeBar) view3;
                    ValueAnimator valueAnimator2 = defaultTimeBar2.f1595b0;
                    if (valueAnimator2.isStarted()) {
                        valueAnimator2.cancel();
                    }
                    defaultTimeBar2.f1597d0 = false;
                    valueAnimator2.setFloatValues(defaultTimeBar2.f1596c0, 1.0f);
                    valueAnimator2.setDuration(250L);
                    valueAnimator2.start();
                    break;
                }
                break;
            case 2:
                xVar.i(4);
                break;
            case 3:
                xVar.i(4);
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ViewGroup viewGroup3 = xVar.f6331h;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(0);
                    xVar.f6331h.setTranslationX(r9.getWidth());
                    ViewGroup viewGroup4 = xVar.f6331h;
                    viewGroup4.scrollTo(viewGroup4.getWidth(), 0);
                }
                break;
            default:
                ViewGroup viewGroup5 = xVar.f;
                if (viewGroup5 != null) {
                    viewGroup5.setVisibility(0);
                }
                break;
        }
    }
}
