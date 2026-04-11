package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends AnimationSet implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ViewGroup f1242u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f1243v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1244w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1245x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1246y;

    public a0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f1246y = true;
        this.f1242u = viewGroup;
        this.f1243v = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j5, Transformation transformation) {
        this.f1246y = true;
        if (this.f1244w) {
            return !this.f1245x;
        }
        if (!super.getTransformation(j5, transformation)) {
            this.f1244w = true;
            q0.r.a(this.f1242u, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2 = this.f1244w;
        ViewGroup viewGroup = this.f1242u;
        if (z2 || !this.f1246y) {
            viewGroup.endViewTransition(this.f1243v);
            this.f1245x = true;
        } else {
            this.f1246y = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j5, Transformation transformation, float f) {
        this.f1246y = true;
        if (this.f1244w) {
            return !this.f1245x;
        }
        if (!super.getTransformation(j5, transformation, f)) {
            this.f1244w = true;
            q0.r.a(this.f1242u, this);
        }
        return true;
    }
}
