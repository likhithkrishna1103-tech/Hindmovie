package hf;

import android.animation.ValueAnimator;
import androidx.media3.decoder.DecoderInputBuffer;
import me.ibrahimsn.lib.SmoothBottomBar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5964a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5966c;

    public i(SmoothBottomBar smoothBottomBar, b bVar) {
        this.f5965b = smoothBottomBar;
        this.f5966c = bVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5964a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ge.i.d(valueAnimator, "it");
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                ((b) this.f5966c).f5963e = ((Integer) animatedValue).intValue();
                ((SmoothBottomBar) this.f5965b).invalidate();
                return;
            default:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                j5.d dVar = (j5.d) this.f5966c;
                j5.c cVar = (j5.c) this.f5965b;
                j5.d.d(fFloatValue, cVar);
                dVar.a(fFloatValue, cVar, false);
                dVar.invalidateSelf();
                return;
        }
    }

    public i(j5.d dVar, j5.c cVar) {
        this.f5966c = dVar;
        this.f5965b = cVar;
    }
}
