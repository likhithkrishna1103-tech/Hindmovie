package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.y0;
import ba.f;
import f0.b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o9.a;
import sd.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HideBottomViewOnScrollBehavior<V extends View> extends b {
    public static final int G = k9.b.motionDurationLong2;
    public static final int H = k9.b.motionDurationMedium4;
    public static final int I = k9.b.motionEasingEmphasizedInterpolator;
    public AccessibilityManager B;
    public a C;
    public ViewPropertyAnimator F;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2775w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2776x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TimeInterpolator f2777y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TimeInterpolator f2778z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinkedHashSet f2774v = new LinkedHashSet();
    public int A = 0;
    public final boolean D = true;
    public int E = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // f0.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.A = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f2775w = i.C(view.getContext(), G, 225);
        this.f2776x = i.C(view.getContext(), H, 175);
        Context context = view.getContext();
        q1.a aVar = l9.a.f7928d;
        int i10 = I;
        this.f2777y = i.D(context, i10, aVar);
        this.f2778z = i.D(view.getContext(), i10, l9.a.f7927c);
        if (this.B == null) {
            this.B = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.B;
        if (accessibilityManager == null || this.C != null) {
            return false;
        }
        a aVar2 = new a(this, view, 0);
        this.C = aVar2;
        accessibilityManager.addTouchExplorationStateChangeListener(aVar2);
        view.addOnAttachStateChangeListener(new y0(3, this));
        return false;
    }

    @Override // f0.b
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i <= 0) {
            if (i < 0) {
                w(view);
                return;
            }
            return;
        }
        if (this.E == 1) {
            return;
        }
        if (this.D && (accessibilityManager = this.B) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.E = 1;
        Iterator it = this.f2774v.iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
        this.F = view.animate().translationY(this.A).setInterpolator(this.f2778z).setDuration(this.f2776x).setListener(new f(6, this));
    }

    @Override // f0.b
    public boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10) {
        return i == 2;
    }

    public final void w(View view) {
        if (this.E == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.E = 2;
        Iterator it = this.f2774v.iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
        this.F = view.animate().translationY(0).setInterpolator(this.f2777y).setDuration(this.f2775w).setListener(new f(6, this));
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
