package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends AnimationSet implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f960v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f961w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f962x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f963y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f964z;

    public d0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f964z = true;
        this.f960v = viewGroup;
        this.f961w = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation) {
        this.f964z = true;
        if (this.f962x) {
            return !this.f963y;
        }
        if (!super.getTransformation(j4, transformation)) {
            this.f962x = true;
            t0.q.a(this.f960v, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10 = this.f962x;
        ViewGroup viewGroup = this.f960v;
        if (z10 || !this.f964z) {
            viewGroup.endViewTransition(this.f961w);
            this.f963y = true;
        } else {
            this.f964z = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j4, Transformation transformation, float f) {
        this.f964z = true;
        if (this.f962x) {
            return !this.f963y;
        }
        if (!super.getTransformation(j4, transformation, f)) {
            this.f962x = true;
            t0.q.a(this.f960v, this);
        }
        return true;
    }
}
