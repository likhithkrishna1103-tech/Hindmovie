package com.google.android.material.sidesheet;

import a2.p0;
import a2.x;
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
import c0.b;
import c0.e;
import g4.l1;
import g5.l;
import i5.a;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import k9.h;
import p8.j;
import p8.k;
import q0.f0;
import q0.o0;
import q9.g;
import r9.c;
import y0.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends b implements k9.b {
    public static final int R = j.side_sheet_accessibility_pane_title;
    public static final int S = k.Widget_Material3_SideSheet;
    public final boolean A;
    public int B;
    public d C;
    public boolean D;
    public final float E;
    public int F;
    public int G;
    public int H;
    public int I;
    public WeakReference J;
    public WeakReference K;
    public final int L;
    public VelocityTracker M;
    public h N;
    public int O;
    public final LinkedHashSet P;
    public final c Q;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f3466u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f3467v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ColorStateList f3468w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final q9.k f3469x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l1 f3470y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f3471z;

    public SideSheetBehavior() {
        this.f3470y = new l1(this);
        this.A = true;
        this.B = 5;
        this.E = 0.1f;
        this.L = -1;
        this.P = new LinkedHashSet();
        this.Q = new c(this, 0);
    }

    public final void A() {
        View view;
        WeakReference weakReference = this.J;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        o0.k(view, 262144);
        o0.h(view, 0);
        o0.k(view, 1048576);
        o0.h(view, 0);
        int i = 5;
        if (this.B != 5) {
            o0.l(view, r0.d.f11216l, new x(i, 3, this));
        }
        int i10 = 3;
        if (this.B != 3) {
            o0.l(view, r0.d.f11214j, new x(i10, 3, this));
        }
    }

    @Override // k9.b
    public final void a() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        h hVar = this.N;
        if (hVar == null) {
            return;
        }
        c.c cVar = hVar.f;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        hVar.f = null;
        int i = 5;
        if (cVar == null || Build.VERSION.SDK_INT < 34) {
            w(5);
            return;
        }
        a aVar = this.f3466u;
        if (aVar != null && aVar.z() != 0) {
            i = 3;
        }
        l lVar = new l(6, this);
        WeakReference weakReference = this.K;
        final View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            final int iR = this.f3466u.r(marginLayoutParams);
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: r9.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f11553a.f3466u.R(marginLayoutParams, q8.a.c(valueAnimator.getAnimatedFraction(), iR, 0));
                    view.requestLayout();
                }
            };
        }
        hVar.b(cVar, i, lVar, animatorUpdateListener);
    }

    @Override // k9.b
    public final void b(c.c cVar) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        h hVar = this.N;
        if (hVar == null) {
            return;
        }
        a aVar = this.f3466u;
        int i = (aVar == null || aVar.z() == 0) ? 5 : 3;
        if (hVar.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        c.c cVar2 = hVar.f;
        hVar.f = cVar;
        if (cVar2 != null) {
            hVar.c(cVar.f2153c, cVar.f2154d == 0, i);
        }
        WeakReference weakReference = this.J;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.J.get();
        WeakReference weakReference2 = this.K;
        View view2 = weakReference2 != null ? (View) weakReference2.get() : null;
        if (view2 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) == null) {
            return;
        }
        this.f3466u.R(marginLayoutParams, (int) ((view.getScaleX() * this.F) + this.I));
        view2.requestLayout();
    }

    @Override // k9.b
    public final void c(c.c cVar) {
        h hVar = this.N;
        if (hVar == null) {
            return;
        }
        hVar.f = cVar;
    }

    @Override // k9.b
    public final void d() {
        h hVar = this.N;
        if (hVar == null) {
            return;
        }
        hVar.a();
    }

    @Override // c0.b
    public final void g(e eVar) {
        this.J = null;
        this.C = null;
        this.N = null;
    }

    @Override // c0.b
    public final void j() {
        this.J = null;
        this.C = null;
        this.N = null;
    }

    @Override // c0.b
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        d dVar;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && o0.e(view) == null) || !this.A) {
            this.D = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.M) != null) {
            velocityTracker.recycle();
            this.M = null;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.O = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.D) {
            this.D = false;
            return false;
        }
        return (this.D || (dVar = this.C) == null || !dVar.r(motionEvent)) ? false : true;
    }

    @Override // c0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        View view2;
        View view3;
        int i10;
        View viewFindViewById;
        WeakHashMap weakHashMap = o0.f10475a;
        int i11 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.J;
        g gVar = this.f3467v;
        int iX = 0;
        if (weakReference == null) {
            this.J = new WeakReference(view);
            this.N = new h(view);
            if (gVar != null) {
                view.setBackground(gVar);
                float fE = this.f3471z;
                if (fE == -1.0f) {
                    fE = f0.e(view);
                }
                gVar.k(fE);
            } else {
                ColorStateList colorStateList = this.f3468w;
                if (colorStateList != null) {
                    f0.i(view, colorStateList);
                }
            }
            int i12 = this.B == 5 ? 4 : 0;
            if (view.getVisibility() != i12) {
                view.setVisibility(i12);
            }
            A();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (o0.e(view) == null) {
                o0.o(view, view.getResources().getString(R));
            }
        }
        int i13 = Gravity.getAbsoluteGravity(((e) view.getLayoutParams()).f2211c, i) == 3 ? 1 : 0;
        a aVar = this.f3466u;
        if (aVar == null || aVar.z() != i13) {
            e eVar = null;
            q9.k kVar = this.f3469x;
            if (i13 == 0) {
                this.f3466u = new r9.a(this, i11);
                if (kVar != null) {
                    WeakReference weakReference2 = this.J;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null && (view3.getLayoutParams() instanceof e)) {
                        eVar = (e) view3.getLayoutParams();
                    }
                    if (eVar == null || ((ViewGroup.MarginLayoutParams) eVar).rightMargin <= 0) {
                        q9.j jVarF = kVar.f();
                        jVarF.f = new q9.a(0.0f);
                        jVarF.f11117g = new q9.a(0.0f);
                        q9.k kVarA = jVarF.a();
                        if (gVar != null) {
                            gVar.setShapeAppearanceModel(kVarA);
                        }
                    }
                }
            } else {
                if (i13 != 1) {
                    throw new IllegalArgumentException(e6.j.j(i13, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f3466u = new r9.a(this, iX);
                if (kVar != null) {
                    WeakReference weakReference3 = this.J;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null && (view2.getLayoutParams() instanceof e)) {
                        eVar = (e) view2.getLayoutParams();
                    }
                    if (eVar == null || ((ViewGroup.MarginLayoutParams) eVar).leftMargin <= 0) {
                        q9.j jVarF2 = kVar.f();
                        jVarF2.f11116e = new q9.a(0.0f);
                        jVarF2.f11118h = new q9.a(0.0f);
                        q9.k kVarA2 = jVarF2.a();
                        if (gVar != null) {
                            gVar.setShapeAppearanceModel(kVarA2);
                        }
                    }
                }
            }
        }
        if (this.C == null) {
            this.C = new d(coordinatorLayout.getContext(), coordinatorLayout, this.Q);
        }
        int iX2 = this.f3466u.x(view);
        coordinatorLayout.r(view, i);
        this.G = coordinatorLayout.getWidth();
        this.H = this.f3466u.y(coordinatorLayout);
        this.F = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.I = marginLayoutParams != null ? this.f3466u.c(marginLayoutParams) : 0;
        int i14 = this.B;
        if (i14 == 1 || i14 == 2) {
            iX = iX2 - this.f3466u.x(view);
        } else if (i14 != 3) {
            if (i14 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.B);
            }
            iX = this.f3466u.u();
        }
        view.offsetLeftAndRight(iX);
        if (this.K == null && (i10 = this.L) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i10)) != null) {
            this.K = new WeakReference(viewFindViewById);
        }
        Iterator it = this.P.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // c0.b
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // c0.b
    public final void r(View view, Parcelable parcelable) {
        int i = ((r9.d) parcelable).f11559w;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.B = i;
    }

    @Override // c0.b
    public final Parcelable s(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new r9.d(this);
    }

    @Override // c0.b
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.B == 1 && actionMasked == 0) {
            return true;
        }
        if (y()) {
            this.C.k(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.M) != null) {
            velocityTracker.recycle();
            this.M = null;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        if (y() && actionMasked == 2 && !this.D && y()) {
            float fAbs = Math.abs(this.O - motionEvent.getX());
            d dVar = this.C;
            if (fAbs > dVar.f14438b) {
                dVar.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.D;
    }

    public final void w(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(l4.a.o(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = this.J;
        if (weakReference == null || weakReference.get() == null) {
            x(i);
            return;
        }
        View view = (View) this.J.get();
        p0 p0Var = new p0(i, 5, this);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = o0.f10475a;
            if (view.isAttachedToWindow()) {
                view.post(p0Var);
                return;
            }
        }
        p0Var.run();
    }

    public final void x(int i) {
        View view;
        if (this.B == i) {
            return;
        }
        this.B = i;
        WeakReference weakReference = this.J;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i10 = this.B == 5 ? 4 : 0;
        if (view.getVisibility() != i10) {
            view.setVisibility(i10);
        }
        Iterator it = this.P.iterator();
        if (it.hasNext()) {
            throw l4.a.k(it);
        }
        A();
    }

    public final boolean y() {
        if (this.C != null) {
            return this.A || this.B == 1;
        }
        return false;
    }

    public final void z(View view, int i, boolean z2) {
        int iS;
        if (i == 3) {
            iS = this.f3466u.s();
        } else {
            if (i != 5) {
                throw new IllegalArgumentException(e6.j.l("Invalid state to get outer edge offset: ", i));
            }
            iS = this.f3466u.u();
        }
        d dVar = this.C;
        if (dVar == null || (!z2 ? dVar.s(view, iS, view.getTop()) : dVar.q(iS, view.getTop()))) {
            x(i);
        } else {
            x(2);
            this.f3470y.a(i);
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.f3470y = new l1(this);
        this.A = true;
        this.B = 5;
        this.E = 0.1f;
        this.L = -1;
        this.P = new LinkedHashSet();
        this.Q = new c(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p8.l.SideSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(p8.l.SideSheetBehavior_Layout_backgroundTint)) {
            this.f3468w = a.a.i(context, typedArrayObtainStyledAttributes, p8.l.SideSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(p8.l.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f3469x = q9.k.c(context, attributeSet, 0, S).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(p8.l.SideSheetBehavior_Layout_coplanarSiblingViewId)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(p8.l.SideSheetBehavior_Layout_coplanarSiblingViewId, -1);
            this.L = resourceId;
            WeakReference weakReference = this.K;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.K = null;
            WeakReference weakReference2 = this.J;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = o0.f10475a;
                    if (view.isLaidOut()) {
                        view.requestLayout();
                    }
                }
            }
        }
        q9.k kVar = this.f3469x;
        if (kVar != null) {
            g gVar = new g(kVar);
            this.f3467v = gVar;
            gVar.j(context);
            ColorStateList colorStateList = this.f3468w;
            if (colorStateList != null) {
                this.f3467v.l(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.f3467v.setTint(typedValue.data);
            }
        }
        this.f3471z = typedArrayObtainStyledAttributes.getDimension(p8.l.SideSheetBehavior_Layout_android_elevation, -1.0f);
        this.A = typedArrayObtainStyledAttributes.getBoolean(p8.l.SideSheetBehavior_Layout_behavior_draggable, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
