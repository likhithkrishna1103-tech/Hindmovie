package u9;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f12797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f12798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f12799c;

    public e(f fVar, View view, View view2) {
        this.f12799c = fVar;
        this.f12797a = view;
        this.f12798b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f12799c.c(this.f12797a, this.f12798b, valueAnimator.getAnimatedFraction());
    }
}
