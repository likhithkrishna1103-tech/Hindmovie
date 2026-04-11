package g5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends AnimatorListenerAdapter implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f5275c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5277e;
    public boolean f = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5276d = true;

    public g0(View view, int i) {
        this.f5273a = view;
        this.f5274b = i;
        this.f5275c = (ViewGroup) view.getParent();
        h(true);
    }

    @Override // g5.n
    public final void c() {
        h(false);
        if (this.f) {
            return;
        }
        z.b(this.f5273a, this.f5274b);
    }

    @Override // g5.n
    public final void d() {
        h(true);
        if (this.f) {
            return;
        }
        z.b(this.f5273a, 0);
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

    public final void h(boolean z2) {
        ViewGroup viewGroup;
        if (!this.f5276d || this.f5277e == z2 || (viewGroup = this.f5275c) == null) {
            return;
        }
        this.f5277e = z2;
        b8.h.F(viewGroup, z2);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f) {
            z.b(this.f5273a, this.f5274b);
            ViewGroup viewGroup = this.f5275c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        h(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z2) {
        if (z2) {
            z.b(this.f5273a, 0);
            ViewGroup viewGroup = this.f5275c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z2) {
        if (z2) {
            return;
        }
        if (!this.f) {
            z.b(this.f5273a, this.f5274b);
            ViewGroup viewGroup = this.f5275c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        h(false);
    }

    @Override // g5.n
    public final void a(p pVar) {
    }

    @Override // g5.n
    public final void b(p pVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }
}
