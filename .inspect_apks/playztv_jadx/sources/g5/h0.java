package g5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends AnimatorListenerAdapter implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f5278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f5279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f5280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5281d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f5282e;

    public h0(h hVar, ViewGroup viewGroup, View view, View view2) {
        this.f5282e = hVar;
        this.f5278a = viewGroup;
        this.f5279b = view;
        this.f5280c = view2;
    }

    @Override // g5.n
    public final void b(p pVar) {
        if (this.f5281d) {
            h();
        }
    }

    @Override // g5.n
    public final void e(p pVar) {
        pVar.x(this);
    }

    @Override // g5.n
    public final void f(p pVar) {
        throw null;
    }

    @Override // g5.n
    public final void g(p pVar) {
        pVar.x(this);
    }

    public final void h() {
        this.f5280c.setTag(j.save_overlay_view, null);
        this.f5278a.getOverlay().remove(this.f5279b);
        this.f5281d = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        h();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.f5278a.getOverlay().remove(this.f5279b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.f5279b;
        if (view.getParent() == null) {
            this.f5278a.getOverlay().add(view);
        } else {
            this.f5282e.c();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z2) {
        if (z2) {
            View view = this.f5280c;
            int i = j.save_overlay_view;
            View view2 = this.f5279b;
            view.setTag(i, view2);
            this.f5278a.getOverlay().add(view2);
            this.f5281d = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z2) {
        if (z2) {
            return;
        }
        h();
    }

    @Override // g5.n
    public final void c() {
    }

    @Override // g5.n
    public final void d() {
    }

    @Override // g5.n
    public final void a(p pVar) {
    }
}
