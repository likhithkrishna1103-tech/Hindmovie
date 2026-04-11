package fa;

import android.animation.ValueAnimator;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.DefaultTimeBar;
import g6.w;
import pa.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4519b;

    public /* synthetic */ a(int i, Object obj) {
        this.f4518a = i;
        this.f4519b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.f4518a;
        Object obj = this.f4519b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((DrawerLayout) obj).setScrimColor(l0.b.d(-1728053248, l9.a.c(valueAnimator.getAnimatedFraction(), c.f4523a, 0)));
                break;
            case 1:
                w wVar = (w) obj;
                g6.a aVar = wVar.f5145g0;
                if (aVar == null) {
                    aVar = g6.a.f5030v;
                }
                if (aVar != g6.a.f5031w) {
                    o6.b bVar = wVar.J;
                    if (bVar != null) {
                        bVar.r(wVar.f5153w.a());
                    }
                } else {
                    wVar.invalidateSelf();
                }
                break;
            case 2:
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) obj;
                int i10 = DefaultTimeBar.f1286n0;
                defaultTimeBar.getClass();
                defaultTimeBar.f1290d0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                defaultTimeBar.invalidate(defaultTimeBar.f1300v);
                break;
            case 3:
                l lVar = (l) obj;
                lVar.getClass();
                lVar.f10097d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                s9.c cVar = (s9.c) obj;
                cVar.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                cVar.f11631j.setAlpha((int) (255.0f * fFloatValue));
                cVar.f11645x = fFloatValue;
                break;
        }
    }
}
