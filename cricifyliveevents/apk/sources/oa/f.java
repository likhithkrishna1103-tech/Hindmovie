package oa;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f9715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f9716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f9717c;

    public f(g gVar, View view, View view2) {
        this.f9717c = gVar;
        this.f9715a = view;
        this.f9716b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f9717c.c(this.f9715a, this.f9716b, valueAnimator.getAnimatedFraction());
    }
}
