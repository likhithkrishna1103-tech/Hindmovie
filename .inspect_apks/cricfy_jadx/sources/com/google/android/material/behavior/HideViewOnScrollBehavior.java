package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.y0;
import ba.f;
import com.bumptech.glide.c;
import f0.b;
import f0.e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o9.a;
import sd.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends b {
    public static final int G = k9.b.motionDurationLong2;
    public static final int H = k9.b.motionDurationMedium4;
    public static final int I = k9.b.motionEasingEmphasizedInterpolator;
    public int A;
    public TimeInterpolator B;
    public TimeInterpolator C;
    public ViewPropertyAnimator F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f2779v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AccessibilityManager f2780w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f2781x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2783z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final LinkedHashSet f2782y = new LinkedHashSet();
    public int D = 0;
    public int E = 2;

    public HideViewOnScrollBehavior() {
    }

    @Override // f0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (this.f2780w == null) {
            this.f2780w = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.f2780w;
        if (accessibilityManager != null && this.f2781x == null) {
            a aVar = new a(this, view, 1);
            this.f2781x = aVar;
            accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            view.addOnAttachStateChangeListener(new y0(4, this));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i10 = ((e) view.getLayoutParams()).f3899c;
        if (i10 == 80 || i10 == 81) {
            w(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i10, i);
            w((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.D = this.f2779v.s(view, marginLayoutParams);
        this.f2783z = i.C(view.getContext(), G, 225);
        this.A = i.C(view.getContext(), H, 175);
        Context context = view.getContext();
        q1.a aVar2 = l9.a.f7928d;
        int i11 = I;
        this.B = i.D(context, i11, aVar2);
        this.C = i.D(view.getContext(), i11, l9.a.f7927c);
        return false;
    }

    @Override // f0.b
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11, int[] iArr) {
        if (i <= 0) {
            if (i < 0) {
                x(view);
                return;
            }
            return;
        }
        if (this.E == 1) {
            return;
        }
        AccessibilityManager accessibilityManager = this.f2780w;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            ViewPropertyAnimator viewPropertyAnimator = this.F;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.E = 1;
            Iterator it = this.f2782y.iterator();
            if (it.hasNext()) {
                throw q4.a.l(it);
            }
            this.F = this.f2779v.w(view, this.D).setInterpolator(this.C).setDuration(this.A).setListener(new f(7, this));
        }
    }

    @Override // f0.b
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10) {
        return i == 2;
    }

    public final void w(int i) {
        c cVar = this.f2779v;
        if (cVar == null || cVar.v() != i) {
            if (i == 0) {
                this.f2779v = new o9.b(2);
            } else if (i == 1) {
                this.f2779v = new o9.b(0);
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException(l0.e.h(i, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
                }
                this.f2779v = new o9.b(1);
            }
        }
    }

    public final void x(View view) {
        if (this.E == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.E = 2;
        Iterator it = this.f2782y.iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
        this.f2779v.getClass();
        this.F = this.f2779v.w(view, 0).setInterpolator(this.B).setDuration(this.f2783z).setListener(new f(7, this));
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
