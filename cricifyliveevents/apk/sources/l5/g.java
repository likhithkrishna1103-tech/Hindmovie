package l5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7803b = false;

    public g(View view) {
        this.f7802a = view;
    }

    @Override // l5.l
    public final void b(n nVar) {
        throw null;
    }

    @Override // l5.l
    public final void c() {
        View view = this.f7802a;
        view.setTag(j.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? x.f7832a.z(view) : 0.0f));
    }

    @Override // l5.l
    public final void f() {
        this.f7802a.setTag(j.transition_pause_alpha, null);
    }

    @Override // l5.l
    public final void g(n nVar) {
        throw null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        x.f7832a.L(this.f7802a, 1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f7802a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.f7803b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z10) {
        boolean z11 = this.f7803b;
        View view = this.f7802a;
        if (z11) {
            view.setLayerType(0, null);
        }
        if (z10) {
            return;
        }
        c0 c0Var = x.f7832a;
        c0Var.L(view, 1.0f);
        c0Var.getClass();
    }

    @Override // l5.l
    public final void a(n nVar) {
    }

    @Override // l5.l
    public final void d(n nVar) {
    }

    @Override // l5.l
    public final void e(n nVar) {
    }
}
