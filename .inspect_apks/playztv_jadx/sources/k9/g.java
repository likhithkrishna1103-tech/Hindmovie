package k9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f7589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f7591c;

    public g(h hVar, boolean z2, int i) {
        this.f7591c = hVar;
        this.f7589a = z2;
        this.f7590b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        h hVar = this.f7591c;
        hVar.f7580b.setTranslationX(0.0f);
        hVar.c(0.0f, this.f7589a, this.f7590b);
    }
}
