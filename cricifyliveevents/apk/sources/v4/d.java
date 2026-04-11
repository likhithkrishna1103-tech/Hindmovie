package v4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f13197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f13199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f13200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f13201e;
    public final /* synthetic */ h f;

    public d(h hVar, x0 x0Var, int i, View view, int i10, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = hVar;
        this.f13197a = x0Var;
        this.f13198b = i;
        this.f13199c = view;
        this.f13200d = i10;
        this.f13201e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.f13198b;
        View view = this.f13199c;
        if (i != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f13200d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f13201e.setListener(null);
        h hVar = this.f;
        x0 x0Var = this.f13197a;
        hVar.c(x0Var);
        hVar.f13244p.remove(x0Var);
        hVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f.getClass();
    }
}
