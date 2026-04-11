package v4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f13208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f13209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f13210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f13211e;

    public /* synthetic */ e(h hVar, f fVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i) {
        this.f13207a = i;
        this.f13211e = hVar;
        this.f13208b = fVar;
        this.f13209c = viewPropertyAnimator;
        this.f13210d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f13207a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f13209c.setListener(null);
                View view = this.f13210d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                f fVar = this.f13208b;
                x0 x0Var = fVar.f13217a;
                h hVar = this.f13211e;
                hVar.c(x0Var);
                hVar.f13246r.remove(fVar.f13217a);
                hVar.i();
                break;
            default:
                this.f13209c.setListener(null);
                View view2 = this.f13210d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                f fVar2 = this.f13208b;
                x0 x0Var2 = fVar2.f13218b;
                h hVar2 = this.f13211e;
                hVar2.c(x0Var2);
                hVar2.f13246r.remove(fVar2.f13218b);
                hVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f13207a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x0 x0Var = this.f13208b.f13217a;
                this.f13211e.getClass();
                break;
            default:
                x0 x0Var2 = this.f13208b.f13218b;
                this.f13211e.getClass();
                break;
        }
    }
}
