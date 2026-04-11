package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b8.h;
import c0.b;
import g5.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k1.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends b {
    public static final int C = p8.b.motionDurationLong2;
    public static final int D = p8.b.motionDurationMedium4;
    public static final int E = p8.b.motionEasingEmphasizedInterpolator;
    public ViewPropertyAnimator B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3324v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3325w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TimeInterpolator f3326x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TimeInterpolator f3327y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinkedHashSet f3323u = new LinkedHashSet();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3328z = 0;
    public int A = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // c0.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f3328z = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f3324v = h.x(view.getContext(), C, 225);
        this.f3325w = h.x(view.getContext(), D, 175);
        Context context = view.getContext();
        a aVar = q8.a.f11075d;
        int i10 = E;
        this.f3326x = h.y(context, i10, aVar);
        this.f3327y = h.y(view.getContext(), i10, q8.a.f11074c);
        return false;
    }

    @Override // c0.b
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11, int[] iArr) {
        LinkedHashSet linkedHashSet = this.f3323u;
        if (i > 0) {
            if (this.A == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.B;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.A = 1;
            Iterator it = linkedHashSet.iterator();
            if (it.hasNext()) {
                throw l4.a.k(it);
            }
            this.B = view.animate().translationY(this.f3328z).setInterpolator(this.f3327y).setDuration(this.f3325w).setListener(new l(7, this));
            return;
        }
        if (i >= 0 || this.A == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.B;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.A = 2;
        Iterator it2 = linkedHashSet.iterator();
        if (it2.hasNext()) {
            throw l4.a.k(it2);
        }
        this.B = view.animate().translationY(0).setInterpolator(this.f3326x).setDuration(this.f3324v).setListener(new l(7, this));
    }

    @Override // c0.b
    public boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
