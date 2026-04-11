package e5;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f4431b;

    public b(e eVar, d dVar) {
        this.f4431b = eVar;
        this.f4430a = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        d dVar = this.f4430a;
        e.d(fFloatValue, dVar);
        e eVar = this.f4431b;
        eVar.a(fFloatValue, dVar, false);
        eVar.invalidateSelf();
    }
}
