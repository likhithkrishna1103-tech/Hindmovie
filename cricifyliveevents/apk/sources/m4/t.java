package m4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.DefaultTimeBar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f8263b;

    public /* synthetic */ t(v vVar, int i) {
        this.f8262a = i;
        this.f8263b = vVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f8262a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v vVar = this.f8263b;
                View view = vVar.f8270b;
                if (view != null) {
                    view.setVisibility(4);
                }
                ViewGroup viewGroup = vVar.f8271c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                ViewGroup viewGroup2 = vVar.f8273e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                }
                break;
            case 1:
            default:
                super.onAnimationEnd(animator);
                break;
            case 2:
                this.f8263b.i(0);
                break;
            case 3:
                this.f8263b.i(0);
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                ViewGroup viewGroup3 = this.f8263b.f;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(4);
                }
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                ViewGroup viewGroup4 = this.f8263b.f8275h;
                if (viewGroup4 != null) {
                    viewGroup4.setVisibility(4);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i = this.f8262a;
        v vVar = this.f8263b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                View view = vVar.f8276j;
                if ((view instanceof DefaultTimeBar) && !vVar.A) {
                    DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                    ValueAnimator valueAnimator = defaultTimeBar.f1289c0;
                    if (valueAnimator.isStarted()) {
                        valueAnimator.cancel();
                    }
                    valueAnimator.setFloatValues(defaultTimeBar.f1290d0, 0.0f);
                    valueAnimator.setDuration(250L);
                    valueAnimator.start();
                    break;
                }
                break;
            case 1:
                View view2 = vVar.f8270b;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ViewGroup viewGroup = vVar.f8271c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                ViewGroup viewGroup2 = vVar.f8273e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(vVar.A ? 0 : 4);
                }
                View view3 = vVar.f8276j;
                if ((view3 instanceof DefaultTimeBar) && !vVar.A) {
                    DefaultTimeBar defaultTimeBar2 = (DefaultTimeBar) view3;
                    ValueAnimator valueAnimator2 = defaultTimeBar2.f1289c0;
                    if (valueAnimator2.isStarted()) {
                        valueAnimator2.cancel();
                    }
                    defaultTimeBar2.f1291e0 = false;
                    valueAnimator2.setFloatValues(defaultTimeBar2.f1290d0, 1.0f);
                    valueAnimator2.setDuration(250L);
                    valueAnimator2.start();
                    break;
                }
                break;
            case 2:
                vVar.i(4);
                break;
            case 3:
                vVar.i(4);
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                ViewGroup viewGroup3 = vVar.f8275h;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(0);
                    vVar.f8275h.setTranslationX(r9.getWidth());
                    ViewGroup viewGroup4 = vVar.f8275h;
                    viewGroup4.scrollTo(viewGroup4.getWidth(), 0);
                }
                break;
            default:
                ViewGroup viewGroup5 = vVar.f;
                if (viewGroup5 != null) {
                    viewGroup5.setVisibility(0);
                }
                break;
        }
    }
}
