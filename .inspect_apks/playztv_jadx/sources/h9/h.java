package h9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f5992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f5993d;

    public h(k kVar) {
        this.f5993d = kVar;
    }

    public abstract float a();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        float f = (int) this.f5992c;
        q9.g gVar = this.f5993d.f5996b;
        if (gVar != null) {
            gVar.k(f);
        }
        this.f5990a = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        boolean z2 = this.f5990a;
        k kVar = this.f5993d;
        if (!z2) {
            q9.g gVar = kVar.f5996b;
            this.f5991b = gVar == null ? 0.0f : gVar.f11105u.f11100m;
            this.f5992c = a();
            this.f5990a = true;
        }
        float f = this.f5991b;
        float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.f5992c - f)) + f);
        q9.g gVar2 = kVar.f5996b;
        if (gVar2 != null) {
            gVar2.k(animatedFraction);
        }
    }
}
