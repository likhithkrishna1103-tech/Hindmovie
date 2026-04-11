package j5;

import android.animation.Animator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f6590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f6591b;

    public b(d dVar, c cVar) {
        this.f6591b = dVar;
        this.f6590a = cVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        d dVar = this.f6591b;
        c cVar = this.f6590a;
        dVar.a(1.0f, cVar, true);
        cVar.f6600k = cVar.f6596e;
        cVar.f6601l = cVar.f;
        cVar.f6602m = cVar.f6597g;
        cVar.a((cVar.f6599j + 1) % cVar.i.length);
        if (!dVar.A) {
            dVar.f6615z += 1.0f;
            return;
        }
        dVar.A = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        if (cVar.f6603n) {
            cVar.f6603n = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f6591b.f6615z = 0.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }
}
