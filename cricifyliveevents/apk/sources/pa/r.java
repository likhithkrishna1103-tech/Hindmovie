package pa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import o.a1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f10099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f10101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ t f10102e;

    public r(t tVar, int i, TextView textView, int i10, TextView textView2) {
        this.f10102e = tVar;
        this.f10098a = i;
        this.f10099b = textView;
        this.f10100c = i10;
        this.f10101d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        a1 a1Var;
        int i = this.f10098a;
        t tVar = this.f10102e;
        tVar.f10115n = i;
        tVar.f10113l = null;
        TextView textView = this.f10099b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f10100c == 1 && (a1Var = tVar.f10119r) != null) {
                a1Var.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f10101d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f10101d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
