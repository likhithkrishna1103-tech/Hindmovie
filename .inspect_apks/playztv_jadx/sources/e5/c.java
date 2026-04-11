package e5;

import android.animation.Animator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f4433b;

    public c(e eVar, d dVar) {
        this.f4433b = eVar;
        this.f4432a = dVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        e eVar = this.f4433b;
        d dVar = this.f4432a;
        eVar.a(1.0f, dVar, true);
        dVar.f4442k = dVar.f4438e;
        dVar.f4443l = dVar.f;
        dVar.f4444m = dVar.f4439g;
        dVar.a((dVar.f4441j + 1) % dVar.i.length);
        if (!eVar.f4458z) {
            eVar.f4457y += 1.0f;
            return;
        }
        eVar.f4458z = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        if (dVar.f4445n) {
            dVar.f4445n = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f4433b.f4457y = 0.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }
}
