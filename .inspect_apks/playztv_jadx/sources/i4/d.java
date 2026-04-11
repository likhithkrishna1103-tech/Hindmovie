package i4;

import android.animation.ValueAnimator;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.DefaultTimeBar;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6219b;

    public /* synthetic */ d(int i, Object obj) {
        this.f6218a = i;
        this.f6219b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.f6218a;
        Object obj = this.f6219b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) obj;
                int i10 = DefaultTimeBar.f1593m0;
                defaultTimeBar.getClass();
                defaultTimeBar.f1596c0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                defaultTimeBar.invalidate(defaultTimeBar.f1605u);
                break;
            case 1:
                l5.w wVar = (l5.w) obj;
                l5.a aVar = wVar.f7911d0;
                if (aVar == null) {
                    aVar = l5.a.f7820u;
                }
                if (aVar != l5.a.f7821v) {
                    t5.c cVar = wVar.I;
                    if (cVar != null) {
                        cVar.s(wVar.f7919v.a());
                    }
                } else {
                    wVar.invalidateSelf();
                }
                break;
            case 2:
                ((DrawerLayout) obj).setScrimColor(i0.b.d(-1728053248, q8.a.c(valueAnimator.getAnimatedFraction(), l9.a.f8020a, 0)));
                break;
            case 3:
                v9.j jVar = (v9.j) obj;
                jVar.getClass();
                jVar.f13379d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                y8.c cVar2 = (y8.c) obj;
                cVar2.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                cVar2.f14550j.setAlpha((int) (255.0f * fFloatValue));
                cVar2.f14564x = fFloatValue;
                break;
        }
    }
}
