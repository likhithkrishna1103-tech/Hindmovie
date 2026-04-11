package hf;

import android.animation.ValueAnimator;
import androidx.media3.decoder.DecoderInputBuffer;
import me.ibrahimsn.lib.SmoothBottomBar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SmoothBottomBar f5968b;

    public /* synthetic */ j(SmoothBottomBar smoothBottomBar, int i) {
        this.f5967a = i;
        this.f5968b = smoothBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5967a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ge.i.d(valueAnimator, "animation");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                this.f5968b.f8474x = ((Float) animatedValue).floatValue();
                return;
            default:
                ge.i.d(valueAnimator, "it");
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                if (animatedValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                this.f5968b.f8473w = ((Integer) animatedValue2).intValue();
                return;
        }
    }
}
