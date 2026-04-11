package l5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends AnimatorListenerAdapter implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f7797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f7798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f7799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7800d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f7801e;

    public f0(h hVar, ViewGroup viewGroup, View view, View view2) {
        this.f7801e = hVar;
        this.f7797a = viewGroup;
        this.f7798b = view;
        this.f7799c = view2;
    }

    @Override // l5.l
    public final void a(n nVar) {
        if (this.f7800d) {
            h();
        }
    }

    @Override // l5.l
    public final void b(n nVar) {
        nVar.x(this);
    }

    @Override // l5.l
    public final void d(n nVar) {
        nVar.x(this);
    }

    @Override // l5.l
    public final void g(n nVar) {
        throw null;
    }

    public final void h() {
        this.f7799c.setTag(j.save_overlay_view, null);
        this.f7797a.getOverlay().remove(this.f7798b);
        this.f7800d = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        h();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.f7797a.getOverlay().remove(this.f7798b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.f7798b;
        if (view.getParent() == null) {
            this.f7797a.getOverlay().add(view);
        } else {
            this.f7801e.c();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z10) {
        if (z10) {
            View view = this.f7799c;
            int i = j.save_overlay_view;
            View view2 = this.f7798b;
            view.setTag(i, view2);
            this.f7797a.getOverlay().add(view2);
            this.f7800d = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z10) {
        if (z10) {
            return;
        }
        h();
    }

    @Override // l5.l
    public final void c() {
    }

    @Override // l5.l
    public final void f() {
    }

    @Override // l5.l
    public final void e(n nVar) {
    }
}
