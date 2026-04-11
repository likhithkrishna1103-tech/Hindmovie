package sa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f11650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f11652c;

    public b(boolean z10, View view, View view2) {
        this.f11650a = z10;
        this.f11651b = view;
        this.f11652c = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f11650a) {
            return;
        }
        this.f11651b.setVisibility(4);
        View view = this.f11652c;
        view.setAlpha(1.0f);
        view.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        if (this.f11650a) {
            this.f11651b.setVisibility(0);
            View view = this.f11652c;
            view.setAlpha(0.0f);
            view.setVisibility(4);
        }
    }
}
