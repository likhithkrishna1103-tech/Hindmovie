package y9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f14569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f14570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f14571c;

    public b(boolean z2, View view, View view2) {
        this.f14569a = z2;
        this.f14570b = view;
        this.f14571c = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f14569a) {
            return;
        }
        this.f14570b.setVisibility(4);
        View view = this.f14571c;
        view.setAlpha(1.0f);
        view.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        if (this.f14569a) {
            this.f14570b.setVisibility(0);
            View view = this.f14571c;
            view.setAlpha(0.0f);
            view.setVisibility(4);
        }
    }
}
