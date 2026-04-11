package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e1 f1008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f1009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f1011d;

    public k(e1 e1Var, l lVar, View view, g gVar) {
        this.f1008a = e1Var;
        this.f1009b = lVar;
        this.f1010c = view;
        this.f1011d = gVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        ge.i.e(animation, "animation");
        l lVar = this.f1009b;
        lVar.f1014a.post(new androidx.emoji2.text.n(lVar, this.f1010c, this.f1011d, 1));
        if (r0.J(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f1008a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        ge.i.e(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        ge.i.e(animation, "animation");
        if (r0.J(2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f1008a + " has reached onAnimationStart.");
        }
    }
}
