package com.google.android.material.sidesheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.e;
import com.bumptech.glide.f;
import ea.i;
import f0.b;
import g2.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import k4.j1;
import k9.j;
import k9.k;
import ka.l;
import ka.m;
import la.a;
import la.c;
import la.d;
import t0.d0;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends b implements ea.b {
    public static final int S = j.side_sheet_accessibility_pane_title;
    public static final int T = k.Widget_Material3_SideSheet;
    public final float A;
    public final boolean B;
    public int C;
    public e D;
    public boolean E;
    public final float F;
    public int G;
    public int H;
    public int I;
    public int J;
    public WeakReference K;
    public WeakReference L;
    public final int M;
    public VelocityTracker N;
    public i O;
    public int P;
    public final LinkedHashSet Q;
    public final c R;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public f f2930v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ka.i f2931w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ColorStateList f2932x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m f2933y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j1 f2934z;

    public SideSheetBehavior() {
        this.f2934z = new j1(this);
        this.B = true;
        this.C = 5;
        this.F = 0.1f;
        this.M = -1;
        this.Q = new LinkedHashSet();
        this.R = new c(this, 0);
    }

    public final void A() {
        View view;
        WeakReference weakReference = this.K;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        m0.k(view, 262144);
        m0.h(view, 0);
        m0.k(view, 1048576);
        m0.h(view, 0);
        int i = 5;
        if (this.C != 5) {
            m0.l(view, u0.c.f12051l, new s(i, 3, this));
        }
        int i10 = 3;
        if (this.C != 3) {
            m0.l(view, u0.c.f12049j, new s(i10, 3, this));
        }
    }

    @Override // ea.b
    public final void a() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        i iVar = this.O;
        if (iVar == null) {
            return;
        }
        c.c cVar = iVar.f;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        iVar.f = null;
        int i = 5;
        if (cVar == null || Build.VERSION.SDK_INT < 34) {
            w(5);
            return;
        }
        f fVar = this.f2930v;
        if (fVar != null && fVar.w() != 0) {
            i = 3;
        }
        ba.f fVar2 = new ba.f(3, this);
        WeakReference weakReference = this.L;
        final View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            final int iO = this.f2930v.o(marginLayoutParams);
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: la.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f7941a.f2930v.J(marginLayoutParams, l9.a.c(valueAnimator.getAnimatedFraction(), iO, 0));
                    view.requestLayout();
                }
            };
        }
        iVar.b(cVar, i, fVar2, animatorUpdateListener);
    }

    @Override // ea.b
    public final void b(c.c cVar) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        i iVar = this.O;
        if (iVar == null) {
            return;
        }
        f fVar = this.f2930v;
        int i = (fVar == null || fVar.w() == 0) ? 5 : 3;
        if (iVar.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        c.c cVar2 = iVar.f;
        iVar.f = cVar;
        if (cVar2 != null) {
            iVar.c(cVar.f1938c, cVar.f1939d == 0, i);
        }
        WeakReference weakReference = this.K;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.K.get();
        WeakReference weakReference2 = this.L;
        View view2 = weakReference2 != null ? (View) weakReference2.get() : null;
        if (view2 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) == null) {
            return;
        }
        this.f2930v.J(marginLayoutParams, (int) ((view.getScaleX() * this.G) + this.J));
        view2.requestLayout();
    }

    @Override // ea.b
    public final void c(c.c cVar) {
        i iVar = this.O;
        if (iVar == null) {
            return;
        }
        iVar.f = cVar;
    }

    @Override // ea.b
    public final void d() {
        i iVar = this.O;
        if (iVar == null) {
            return;
        }
        iVar.a();
    }

    @Override // f0.b
    public final void g(f0.e eVar) {
        this.K = null;
        this.D = null;
        this.O = null;
    }

    @Override // f0.b
    public final void j() {
        this.K = null;
        this.D = null;
        this.O = null;
    }

    @Override // f0.b
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        e eVar;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && m0.e(view) == null) || !this.B) {
            this.E = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.N) != null) {
            velocityTracker.recycle();
            this.N = null;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.P = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.E) {
            this.E = false;
            return false;
        }
        return (this.E || (eVar = this.D) == null || !eVar.r(motionEvent)) ? false : true;
    }

    @Override // f0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        View view2;
        View view3;
        int i10;
        View viewFindViewById;
        int i11 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.K;
        ka.i iVar = this.f2931w;
        int iU = 0;
        if (weakReference == null) {
            this.K = new WeakReference(view);
            this.O = new i(view);
            if (iVar != null) {
                view.setBackground(iVar);
                float elevation = this.A;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                iVar.p(elevation);
            } else {
                ColorStateList colorStateList = this.f2932x;
                if (colorStateList != null) {
                    WeakHashMap weakHashMap = m0.f11777a;
                    d0.i(view, colorStateList);
                }
            }
            int i12 = this.C == 5 ? 4 : 0;
            if (view.getVisibility() != i12) {
                view.setVisibility(i12);
            }
            A();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (m0.e(view) == null) {
                m0.o(view, view.getResources().getString(S));
            }
        }
        int i13 = Gravity.getAbsoluteGravity(((f0.e) view.getLayoutParams()).f3899c, i) == 3 ? 1 : 0;
        f fVar = this.f2930v;
        if (fVar == null || fVar.w() != i13) {
            f0.e eVar = null;
            m mVar = this.f2933y;
            if (i13 == 0) {
                this.f2930v = new a(this, i11);
                if (mVar != null) {
                    WeakReference weakReference2 = this.K;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null && (view3.getLayoutParams() instanceof f0.e)) {
                        eVar = (f0.e) view3.getLayoutParams();
                    }
                    if (eVar == null || ((ViewGroup.MarginLayoutParams) eVar).rightMargin <= 0) {
                        l lVarG = mVar.g();
                        lVarG.f = new ka.a(0.0f);
                        lVarG.f7344g = new ka.a(0.0f);
                        m mVarA = lVarG.a();
                        if (iVar != null) {
                            iVar.setShapeAppearanceModel(mVarA);
                        }
                    }
                }
            } else {
                if (i13 != 1) {
                    throw new IllegalArgumentException(l0.e.h(i13, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f2930v = new a(this, iU);
                if (mVar != null) {
                    WeakReference weakReference3 = this.K;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null && (view2.getLayoutParams() instanceof f0.e)) {
                        eVar = (f0.e) view2.getLayoutParams();
                    }
                    if (eVar == null || ((ViewGroup.MarginLayoutParams) eVar).leftMargin <= 0) {
                        l lVarG2 = mVar.g();
                        lVarG2.f7343e = new ka.a(0.0f);
                        lVarG2.f7345h = new ka.a(0.0f);
                        m mVarA2 = lVarG2.a();
                        if (iVar != null) {
                            iVar.setShapeAppearanceModel(mVarA2);
                        }
                    }
                }
            }
        }
        if (this.D == null) {
            this.D = new e(coordinatorLayout.getContext(), coordinatorLayout, this.R);
        }
        int iU2 = this.f2930v.u(view);
        coordinatorLayout.r(view, i);
        this.H = coordinatorLayout.getWidth();
        this.I = this.f2930v.v(coordinatorLayout);
        this.G = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.J = marginLayoutParams != null ? this.f2930v.b(marginLayoutParams) : 0;
        int i14 = this.C;
        if (i14 == 1 || i14 == 2) {
            iU = iU2 - this.f2930v.u(view);
        } else if (i14 != 3) {
            if (i14 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.C);
            }
            iU = this.f2930v.r();
        }
        WeakHashMap weakHashMap2 = m0.f11777a;
        view.offsetLeftAndRight(iU);
        if (this.L == null && (i10 = this.M) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i10)) != null) {
            this.L = new WeakReference(viewFindViewById);
        }
        Iterator it = this.Q.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // f0.b
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // f0.b
    public final void r(View view, Parcelable parcelable) {
        int i = ((d) parcelable).f7947x;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.C = i;
    }

    @Override // f0.b
    public final Parcelable s(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new d(this);
    }

    @Override // f0.b
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.C == 1 && actionMasked == 0) {
            return true;
        }
        if (y()) {
            this.D.k(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.N) != null) {
            velocityTracker.recycle();
            this.N = null;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        if (y() && actionMasked == 2 && !this.E && y()) {
            float fAbs = Math.abs(this.P - motionEvent.getX());
            e eVar = this.D;
            if (fAbs > eVar.f1651b) {
                eVar.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.E;
    }

    public final void w(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(q4.a.q(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = this.K;
        if (weakReference == null || weakReference.get() == null) {
            x(i);
            return;
        }
        View view = (View) this.K.get();
        d6.i iVar = new d6.i(i, 4, this);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(iVar);
        } else {
            iVar.run();
        }
    }

    public final void x(int i) {
        View view;
        if (this.C == i) {
            return;
        }
        this.C = i;
        WeakReference weakReference = this.K;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i10 = this.C == 5 ? 4 : 0;
        if (view.getVisibility() != i10) {
            view.setVisibility(i10);
        }
        Iterator it = this.Q.iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
        A();
    }

    public final boolean y() {
        if (this.D != null) {
            return this.B || this.C == 1;
        }
        return false;
    }

    public final void z(View view, int i, boolean z10) {
        int iQ;
        if (i == 3) {
            iQ = this.f2930v.q();
        } else {
            if (i != 5) {
                throw new IllegalArgumentException(l0.e.g(i, "Invalid state to get outer edge offset: "));
            }
            iQ = this.f2930v.r();
        }
        e eVar = this.D;
        if (eVar == null || (!z10 ? eVar.s(view, iQ, view.getTop()) : eVar.q(iQ, view.getTop()))) {
            x(i);
        } else {
            x(2);
            this.f2934z.a(i);
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.f2934z = new j1(this);
        this.B = true;
        this.C = 5;
        this.F = 0.1f;
        this.M = -1;
        this.Q = new LinkedHashSet();
        this.R = new c(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k9.l.SideSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.SideSheetBehavior_Layout_backgroundTint)) {
            this.f2932x = com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, k9.l.SideSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f2933y = m.c(context, attributeSet, 0, T).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(k9.l.SideSheetBehavior_Layout_coplanarSiblingViewId)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(k9.l.SideSheetBehavior_Layout_coplanarSiblingViewId, -1);
            this.M = resourceId;
            WeakReference weakReference = this.L;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.L = null;
            WeakReference weakReference2 = this.K;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        m mVar = this.f2933y;
        if (mVar != null) {
            ka.i iVar = new ka.i(mVar);
            this.f2931w = iVar;
            iVar.m(context);
            ColorStateList colorStateList = this.f2932x;
            if (colorStateList != null) {
                this.f2931w.q(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.f2931w.setTint(typedValue.data);
            }
        }
        this.A = typedArrayObtainStyledAttributes.getDimension(k9.l.SideSheetBehavior_Layout_android_elevation, -1.0f);
        this.B = typedArrayObtainStyledAttributes.getBoolean(k9.l.SideSheetBehavior_Layout_behavior_draggable, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
