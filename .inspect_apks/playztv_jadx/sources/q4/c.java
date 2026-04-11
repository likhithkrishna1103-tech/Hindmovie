package q4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10751a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f10752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f10753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f10754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f10755e;

    public c(h hVar, x0 x0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f10755e = hVar;
        this.f10752b = x0Var;
        this.f10754d = viewPropertyAnimator;
        this.f10753c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f10751a) {
            case 1:
                this.f10753c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f10751a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f10754d.setListener(null);
                this.f10753c.setAlpha(1.0f);
                h hVar = this.f10755e;
                x0 x0Var = this.f10752b;
                hVar.c(x0Var);
                hVar.f10815q.remove(x0Var);
                hVar.i();
                break;
            default:
                this.f10754d.setListener(null);
                h hVar2 = this.f10755e;
                x0 x0Var2 = this.f10752b;
                hVar2.c(x0Var2);
                hVar2.f10813o.remove(x0Var2);
                hVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f10751a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f10755e.getClass();
                break;
            default:
                this.f10755e.getClass();
                break;
        }
    }

    public c(h hVar, x0 x0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f10755e = hVar;
        this.f10752b = x0Var;
        this.f10753c = view;
        this.f10754d = viewPropertyAnimator;
    }
}
