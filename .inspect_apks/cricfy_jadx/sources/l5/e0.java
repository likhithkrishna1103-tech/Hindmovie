package l5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends AnimatorListenerAdapter implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f7791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f7793c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7795e;
    public boolean f = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7794d = true;

    public e0(View view, int i) {
        this.f7791a = view;
        this.f7792b = i;
        this.f7793c = (ViewGroup) view.getParent();
        h(true);
    }

    @Override // l5.l
    public final void b(n nVar) {
        nVar.x(this);
    }

    @Override // l5.l
    public final void c() {
        h(false);
        if (this.f) {
            return;
        }
        x.b(this.f7791a, this.f7792b);
    }

    @Override // l5.l
    public final void d(n nVar) {
        nVar.x(this);
    }

    @Override // l5.l
    public final void f() {
        h(true);
        if (this.f) {
            return;
        }
        x.b(this.f7791a, 0);
    }

    @Override // l5.l
    public final void g(n nVar) {
        throw null;
    }

    public final void h(boolean z10) {
        ViewGroup viewGroup;
        if (!this.f7794d || this.f7795e == z10 || (viewGroup = this.f7793c) == null) {
            return;
        }
        this.f7795e = z10;
        ab.b.E(viewGroup, z10);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f) {
            x.b(this.f7791a, this.f7792b);
            ViewGroup viewGroup = this.f7793c;
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
    public final void onAnimationStart(Animator animator, boolean z10) {
        if (z10) {
            x.b(this.f7791a, 0);
            ViewGroup viewGroup = this.f7793c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z10) {
        if (z10) {
            return;
        }
        if (!this.f) {
            x.b(this.f7791a, this.f7792b);
            ViewGroup viewGroup = this.f7793c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        h(false);
    }

    @Override // l5.l
    public final void a(n nVar) {
    }

    @Override // l5.l
    public final void e(n nVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }
}
