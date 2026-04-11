package v9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import n.d1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f13381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f13383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f13384e;

    public o(q qVar, int i, TextView textView, int i10, TextView textView2) {
        this.f13384e = qVar;
        this.f13380a = i;
        this.f13381b = textView;
        this.f13382c = i10;
        this.f13383d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        d1 d1Var;
        int i = this.f13380a;
        q qVar = this.f13384e;
        qVar.f13397n = i;
        qVar.f13395l = null;
        TextView textView = this.f13381b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f13382c == 1 && (d1Var = qVar.f13401r) != null) {
                d1Var.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f13383d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f13383d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
