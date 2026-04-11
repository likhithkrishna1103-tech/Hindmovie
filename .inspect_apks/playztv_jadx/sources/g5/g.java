package g5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5272b = false;

    public g(View view) {
        this.f5271a = view;
    }

    @Override // g5.n
    public final void c() {
        View view = this.f5271a;
        view.setTag(j.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? z.f5317a.q(view) : 0.0f));
    }

    @Override // g5.n
    public final void d() {
        this.f5271a.setTag(j.transition_pause_alpha, null);
    }

    @Override // g5.n
    public final void e(p pVar) {
        throw null;
    }

    @Override // g5.n
    public final void f(p pVar) {
        throw null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        z.f5317a.x(this.f5271a, 1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f5271a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.f5272b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z2) {
        boolean z10 = this.f5272b;
        View view = this.f5271a;
        if (z10) {
            view.setLayerType(0, null);
        }
        if (z2) {
            return;
        }
        e0 e0Var = z.f5317a;
        e0Var.x(view, 1.0f);
        e0Var.getClass();
    }

    @Override // g5.n
    public final void a(p pVar) {
    }

    @Override // g5.n
    public final void b(p pVar) {
    }

    @Override // g5.n
    public final void g(p pVar) {
    }
}
