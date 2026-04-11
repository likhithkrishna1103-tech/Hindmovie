package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f1002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f1004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e1 f1005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f1006e;

    public j(l lVar, View view, boolean z10, e1 e1Var, g gVar) {
        this.f1002a = lVar;
        this.f1003b = view;
        this.f1004c = z10;
        this.f1005d = e1Var;
        this.f1006e = gVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ge.i.e(animator, "anim");
        ViewGroup viewGroup = this.f1002a.f1014a;
        View view = this.f1003b;
        viewGroup.endViewTransition(view);
        boolean z10 = this.f1004c;
        e1 e1Var = this.f1005d;
        if (z10) {
            int i = e1Var.f973a;
            ge.i.d(view, "viewToAnimate");
            q4.a.b(view, i);
        }
        this.f1006e.d();
        if (r0.J(2)) {
            Log.v("FragmentManager", "Animator from operation " + e1Var + " has ended.");
        }
    }
}
