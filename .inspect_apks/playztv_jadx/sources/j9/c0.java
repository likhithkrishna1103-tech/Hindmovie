package j9;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends g5.p {
    @Override // g5.p
    public final void d(g5.x xVar) {
        View view = xVar.f5315b;
        if (view instanceof TextView) {
            xVar.f5314a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // g5.p
    public final void g(g5.x xVar) {
        View view = xVar.f5315b;
        if (view instanceof TextView) {
            xVar.f5314a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // g5.p
    public final Animator k(ViewGroup viewGroup, g5.x xVar, g5.x xVar2) {
        if (xVar == null || xVar2 == null || !(xVar.f5315b instanceof TextView)) {
            return null;
        }
        View view = xVar2.f5315b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        HashMap map = xVar.f5314a;
        HashMap map2 = xVar2.f5314a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new b0(0, textView));
        return valueAnimatorOfFloat;
    }
}
