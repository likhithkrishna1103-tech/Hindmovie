package v4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13188a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f13189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f13190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f13191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f13192e;

    public c(h hVar, x0 x0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f13192e = hVar;
        this.f13189b = x0Var;
        this.f13191d = viewPropertyAnimator;
        this.f13190c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f13188a) {
            case 1:
                this.f13190c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f13188a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f13191d.setListener(null);
                this.f13190c.setAlpha(1.0f);
                h hVar = this.f13192e;
                x0 x0Var = this.f13189b;
                hVar.c(x0Var);
                hVar.f13245q.remove(x0Var);
                hVar.i();
                break;
            default:
                this.f13191d.setListener(null);
                h hVar2 = this.f13192e;
                x0 x0Var2 = this.f13189b;
                hVar2.c(x0Var2);
                hVar2.f13243o.remove(x0Var2);
                hVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f13188a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f13192e.getClass();
                break;
            default:
                this.f13192e.getClass();
                break;
        }
    }

    public c(h hVar, x0 x0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f13192e = hVar;
        this.f13189b = x0Var;
        this.f13190c = view;
        this.f13191d = viewPropertyAnimator;
    }
}
