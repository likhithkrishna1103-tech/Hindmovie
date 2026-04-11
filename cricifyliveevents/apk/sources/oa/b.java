package oa;

import android.animation.ValueAnimator;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9712b;

    public /* synthetic */ b(int i, Object obj) {
        this.f9711a = i;
        this.f9712b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f9711a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((TabLayout) this.f9712b).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
            case 1:
                ((TextInputLayout) this.f9712b).R0.m(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 2:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ka.i iVar = ((BottomSheetBehavior) this.f9712b).D;
                if (iVar != null) {
                    iVar.r(fFloatValue);
                }
                break;
            default:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                v4.j jVar = (v4.j) this.f9712b;
                jVar.f13267c.setAlpha(iFloatValue);
                jVar.f13268d.setAlpha(iFloatValue);
                jVar.f13281s.invalidate();
                break;
        }
    }
}
