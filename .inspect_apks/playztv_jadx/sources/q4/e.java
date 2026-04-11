package q4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f10772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f10773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f10774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f10775e;

    public /* synthetic */ e(h hVar, f fVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i) {
        this.f10771a = i;
        this.f10775e = hVar;
        this.f10772b = fVar;
        this.f10773c = viewPropertyAnimator;
        this.f10774d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f10771a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f10773c.setListener(null);
                View view = this.f10774d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                f fVar = this.f10772b;
                x0 x0Var = fVar.f10787a;
                h hVar = this.f10775e;
                hVar.c(x0Var);
                hVar.f10816r.remove(fVar.f10787a);
                hVar.i();
                break;
            default:
                this.f10773c.setListener(null);
                View view2 = this.f10774d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                f fVar2 = this.f10772b;
                x0 x0Var2 = fVar2.f10788b;
                h hVar2 = this.f10775e;
                hVar2.c(x0Var2);
                hVar2.f10816r.remove(fVar2.f10788b);
                hVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f10771a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x0 x0Var = this.f10772b.f10787a;
                this.f10775e.getClass();
                break;
            default:
                x0 x0Var2 = this.f10772b.f10788b;
                this.f10775e.getClass();
                break;
        }
    }
}
