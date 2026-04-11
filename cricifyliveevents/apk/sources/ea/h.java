package ea;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f3864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f3866c;

    public h(i iVar, boolean z10, int i) {
        this.f3866c = iVar;
        this.f3864a = z10;
        this.f3865b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        i iVar = this.f3866c;
        iVar.f3853b.setTranslationX(0.0f);
        iVar.c(0.0f, this.f3864a, this.f3865b);
    }
}
