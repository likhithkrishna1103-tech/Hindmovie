package com.google.android.material.bottomsheet;

import ag.o;
import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.e;
import ba.f;
import com.google.android.gms.internal.measurement.o4;
import da.g0;
import ea.g;
import f0.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import k4.j1;
import k9.d;
import k9.j;
import k9.k;
import k9.l;
import ka.i;
import ka.m;
import l4.c0;
import la.c;
import o.r0;
import q4.a;
import t0.d0;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends b implements ea.b {
    public static final int C0 = k.Widget_Design_BottomSheet_Modal;
    public boolean A;
    public final SparseIntArray A0;
    public int B;
    public final c B0;
    public final int C;
    public final i D;
    public final ColorStateList E;
    public final int F;
    public final int G;
    public int H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final boolean P;
    public int Q;
    public int R;
    public final boolean S;
    public final m T;
    public boolean U;
    public final j1 V;
    public final ValueAnimator W;
    public final int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final float f2789a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f2790b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final float f2791c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f2792d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f2793e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final boolean f2794f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final boolean f2795g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f2796h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f2797i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public e f2798j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f2799k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f2800l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f2801m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final float f2802n0;
    public int o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f2803p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f2804q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public WeakReference f2805r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public WeakReference f2806s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final ArrayList f2807t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public VelocityTracker f2808u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2809v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public g f2810v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2811w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f2812w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f2813x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f2814x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f2815y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f2816y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2817z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public HashMap f2818z0;

    public BottomSheetBehavior() {
        this.f2809v = 0;
        this.f2811w = true;
        this.F = -1;
        this.G = -1;
        this.V = new j1(this);
        this.f2789a0 = 0.5f;
        this.f2791c0 = -1.0f;
        this.f2794f0 = true;
        this.f2795g0 = true;
        this.f2797i0 = 4;
        this.f2802n0 = 0.1f;
        this.f2807t0 = new ArrayList();
        this.f2814x0 = -1;
        this.A0 = new SparseIntArray();
        this.B0 = new c(this, 1);
    }

    public static View A(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewA = A(viewGroup.getChildAt(i));
            if (viewA != null) {
                return viewA;
            }
        }
        return null;
    }

    public static int B(int i, int i10, int i11, int i12) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i10, i12);
        if (i11 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i11), 1073741824);
        }
        if (size != 0) {
            i11 = Math.min(size, i11);
        }
        return View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE);
    }

    public final int C() {
        if (this.f2811w) {
            return this.Y;
        }
        return Math.max(this.X, this.M ? 0 : this.R);
    }

    public final int D(int i) {
        if (i == 3) {
            return C();
        }
        if (i == 4) {
            return this.f2790b0;
        }
        if (i == 5) {
            return this.f2804q0;
        }
        if (i == 6) {
            return this.Z;
        }
        throw new IllegalArgumentException(l0.e.g(i, "Invalid state to get top offset: "));
    }

    public final boolean E() {
        WeakReference weakReference = this.f2805r0;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.f2805r0.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void F(int i) {
        if (i == -1) {
            if (this.A) {
                return;
            } else {
                this.A = true;
            }
        } else {
            if (!this.A && this.f2817z == i) {
                return;
            }
            this.A = false;
            this.f2817z = Math.max(0, i);
        }
        N();
    }

    public final void G(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(a.q(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.f2792d0 && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i10 = (i == 6 && this.f2811w && D(i) <= this.Y) ? 3 : i;
        WeakReference weakReference = this.f2805r0;
        if (weakReference == null || weakReference.get() == null) {
            H(i);
            return;
        }
        View view = (View) this.f2805r0.get();
        r0 r0Var = new r0(this, view, i10);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(r0Var);
        } else {
            r0Var.run();
        }
    }

    public final void H(int i) {
        if (this.f2797i0 == i) {
            return;
        }
        this.f2797i0 = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z10 = this.f2792d0;
        }
        WeakReference weakReference = this.f2805r0;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            M(true);
        } else if (i == 6 || i == 5 || i == 4) {
            M(false);
        }
        L(i, true);
        ArrayList arrayList = this.f2807t0;
        if (arrayList.size() > 0) {
            throw a.k(0, arrayList);
        }
        K();
    }

    public final boolean I(View view, float f) {
        if (this.f2793e0) {
            return true;
        }
        if (view.getTop() < this.f2790b0) {
            return false;
        }
        return Math.abs(((f * this.f2802n0) + ((float) view.getTop())) - ((float) this.f2790b0)) / ((float) y()) > 0.5f;
    }

    public final void J(View view, int i, boolean z10) {
        int iD = D(i);
        e eVar = this.f2798j0;
        if (eVar == null || (!z10 ? eVar.s(view, view.getLeft(), iD) : eVar.q(view.getLeft(), iD))) {
            H(i);
            return;
        }
        H(2);
        L(i, true);
        this.V.a(i);
    }

    public final void K() {
        View view;
        int iA;
        WeakReference weakReference = this.f2805r0;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        m0.k(view, 524288);
        m0.h(view, 0);
        m0.k(view, 262144);
        m0.h(view, 0);
        m0.k(view, 1048576);
        m0.h(view, 0);
        SparseIntArray sparseIntArray = this.A0;
        int i = sparseIntArray.get(0, -1);
        if (i != -1) {
            m0.k(view, i);
            m0.h(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.f2811w && this.f2797i0 != 6) {
            String string = view.getResources().getString(j.bottomsheet_action_expand_halfway);
            o oVar = new o(6, 6, this);
            ArrayList arrayListF = m0.f(view);
            int i10 = 0;
            while (true) {
                if (i10 >= arrayListF.size()) {
                    int i11 = 0;
                    int i12 = -1;
                    while (true) {
                        int[] iArr = m0.f11780d;
                        if (i11 >= 32 || i12 != -1) {
                            break;
                        }
                        int i13 = iArr[i11];
                        boolean z10 = true;
                        for (int i14 = 0; i14 < arrayListF.size(); i14++) {
                            z10 &= ((u0.c) arrayListF.get(i14)).a() != i13;
                        }
                        if (z10) {
                            i12 = i13;
                        }
                        i11++;
                    }
                    iA = i12;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((u0.c) arrayListF.get(i10)).f12056a).getLabel())) {
                        iA = ((u0.c) arrayListF.get(i10)).a();
                        break;
                    }
                    i10++;
                }
            }
            if (iA != -1) {
                u0.c cVar = new u0.c(null, iA, string, oVar, null);
                View.AccessibilityDelegate accessibilityDelegateD = m0.d(view);
                t0.b bVar = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof t0.a ? ((t0.a) accessibilityDelegateD).f11723a : new t0.b(accessibilityDelegateD);
                if (bVar == null) {
                    bVar = new t0.b();
                }
                m0.n(view, bVar);
                m0.k(view, cVar.a());
                m0.f(view).add(cVar);
                m0.h(view, 0);
            }
            sparseIntArray.put(0, iA);
        }
        if (this.f2792d0 && this.f2797i0 != 5) {
            m0.l(view, u0.c.f12051l, new o(5, 6, this));
        }
        int i15 = this.f2797i0;
        if (i15 == 3) {
            m0.l(view, u0.c.f12050k, new o(this.f2811w ? 4 : 6, 6, this));
            return;
        }
        if (i15 == 4) {
            m0.l(view, u0.c.f12049j, new o(this.f2811w ? 3 : 6, 6, this));
        } else {
            if (i15 != 6) {
                return;
            }
            m0.l(view, u0.c.f12050k, new o(4, 6, this));
            m0.l(view, u0.c.f12049j, new o(3, 6, this));
        }
    }

    public final void L(int i, boolean z10) {
        i iVar;
        if (i == 2) {
            return;
        }
        boolean z11 = this.f2797i0 == 3 && (this.S || E());
        if (this.U == z11 || (iVar = this.D) == null) {
            return;
        }
        this.U = z11;
        ValueAnimator valueAnimator = this.W;
        if (!z10 || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            iVar.r(this.U ? x() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(iVar.f7334w.f7323j, z11 ? x() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void M(boolean z10) {
        WeakReference weakReference = this.f2805r0;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.f2818z0 != null) {
                    return;
                } else {
                    this.f2818z0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.f2805r0.get() && z10) {
                    this.f2818z0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z10) {
                return;
            }
            this.f2818z0 = null;
        }
    }

    public final void N() {
        View view;
        if (this.f2805r0 != null) {
            w();
            if (this.f2797i0 != 4 || (view = (View) this.f2805r0.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // ea.b
    public final void a() {
        g gVar = this.f2810v0;
        if (gVar == null) {
            return;
        }
        int i = gVar.f3855d;
        int i10 = gVar.f3854c;
        c.c cVar = gVar.f;
        gVar.f = null;
        if (cVar != null) {
            float f = cVar.f1938c;
            if (Build.VERSION.SDK_INT >= 34) {
                if (!this.f2792d0) {
                    AnimatorSet animatorSetA = gVar.a();
                    animatorSetA.setDuration(l9.a.c(f, i10, i));
                    animatorSetA.start();
                    G(4);
                    return;
                }
                f fVar = new f(9, this);
                View view = gVar.f3853b;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getScaleY() * view.getHeight());
                objectAnimatorOfFloat.setInterpolator(new q1.a(1));
                objectAnimatorOfFloat.setDuration(l9.a.c(f, i10, i));
                objectAnimatorOfFloat.addListener(new f(1, gVar));
                objectAnimatorOfFloat.addListener(fVar);
                objectAnimatorOfFloat.start();
                return;
            }
        }
        G(this.f2792d0 ? 5 : 4);
    }

    @Override // ea.b
    public final void b(c.c cVar) {
        g gVar = this.f2810v0;
        if (gVar == null) {
            return;
        }
        if (gVar.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        c.c cVar2 = gVar.f;
        gVar.f = cVar;
        if (cVar2 == null) {
            return;
        }
        gVar.b(cVar.f1938c);
    }

    @Override // ea.b
    public final void c(c.c cVar) {
        g gVar = this.f2810v0;
        if (gVar == null) {
            return;
        }
        gVar.f = cVar;
    }

    @Override // ea.b
    public final void d() {
        g gVar = this.f2810v0;
        if (gVar == null) {
            return;
        }
        if (gVar.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        c.c cVar = gVar.f;
        gVar.f = null;
        if (cVar == null) {
            return;
        }
        AnimatorSet animatorSetA = gVar.a();
        animatorSetA.setDuration(gVar.f3856e);
        animatorSetA.start();
    }

    @Override // f0.b
    public final void g(f0.e eVar) {
        this.f2805r0 = null;
        this.f2798j0 = null;
        this.f2810v0 = null;
    }

    @Override // f0.b
    public final void j() {
        this.f2805r0 = null;
        this.f2798j0 = null;
        this.f2810v0 = null;
    }

    @Override // f0.b
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i;
        e eVar;
        if (!view.isShown() || !this.f2794f0) {
            this.f2799k0 = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2812w0 = -1;
            this.f2814x0 = -1;
            VelocityTracker velocityTracker = this.f2808u0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2808u0 = null;
            }
        }
        if (this.f2808u0 == null) {
            this.f2808u0 = VelocityTracker.obtain();
        }
        this.f2808u0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            this.f2814x0 = y10;
            if (this.f2797i0 != 2) {
                WeakReference weakReference = this.f2806s0;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.p(view2, x10, y10)) {
                    this.f2812w0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f2816y0 = true;
                }
            }
            this.f2799k0 = this.f2812w0 == -1 && !coordinatorLayout.p(view, x10, this.f2814x0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2816y0 = false;
            this.f2812w0 = -1;
            if (this.f2799k0) {
                this.f2799k0 = false;
                return false;
            }
        }
        if (this.f2799k0 || (eVar = this.f2798j0) == null || !eVar.r(motionEvent)) {
            WeakReference weakReference2 = this.f2806s0;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.f2799k0 || this.f2797i0 == 1 || coordinatorLayout.p(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f2798j0 == null || (i = this.f2814x0) == -1 || Math.abs(i - motionEvent.getY()) <= this.f2798j0.f1651b) {
                return false;
            }
        }
        return true;
    }

    @Override // f0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.f2805r0 == null) {
            this.B = coordinatorLayout.getResources().getDimensionPixelSize(d.design_bottom_sheet_peek_height_min);
            boolean z10 = (Build.VERSION.SDK_INT < 29 || this.I || this.A) ? false : true;
            if (this.J || this.K || this.L || this.N || this.O || this.P || z10) {
                o4 o4Var = new o4();
                o4Var.f2561w = this;
                o4Var.f2560v = z10;
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                a3.d dVar = new a3.d();
                dVar.f154a = paddingStart;
                dVar.f155b = paddingEnd;
                dVar.f156c = paddingBottom;
                c0 c0Var = new c0(13, o4Var, dVar);
                WeakHashMap weakHashMap = m0.f11777a;
                d0.l(view, c0Var);
                if (view.isAttachedToWindow()) {
                    view.requestApplyInsets();
                } else {
                    view.addOnAttachStateChangeListener(new g0());
                }
            }
            m0.p(view, new q9.b(view));
            this.f2805r0 = new WeakReference(view);
            this.f2810v0 = new g(view);
            i iVar = this.D;
            if (iVar != null) {
                view.setBackground(iVar);
                float elevation = this.f2791c0;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                iVar.p(elevation);
            } else {
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    d0.i(view, colorStateList);
                }
            }
            K();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.f2798j0 == null) {
            this.f2798j0 = new e(coordinatorLayout.getContext(), coordinatorLayout, this.B0);
        }
        int top = view.getTop();
        coordinatorLayout.r(view, i);
        this.f2803p0 = coordinatorLayout.getWidth();
        this.f2804q0 = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.o0 = height;
        int iMin = this.f2804q0;
        int i10 = iMin - height;
        int i11 = this.R;
        if (i10 < i11) {
            boolean z11 = this.M;
            int i12 = this.G;
            if (z11) {
                if (i12 != -1) {
                    iMin = Math.min(iMin, i12);
                }
                this.o0 = iMin;
            } else {
                int iMin2 = iMin - i11;
                if (i12 != -1) {
                    iMin2 = Math.min(iMin2, i12);
                }
                this.o0 = iMin2;
            }
        }
        this.Y = Math.max(0, this.f2804q0 - this.o0);
        this.Z = (int) ((1.0f - this.f2789a0) * this.f2804q0);
        w();
        int i13 = this.f2797i0;
        if (i13 == 3) {
            int iC = C();
            WeakHashMap weakHashMap2 = m0.f11777a;
            view.offsetTopAndBottom(iC);
        } else if (i13 == 6) {
            int i14 = this.Z;
            WeakHashMap weakHashMap3 = m0.f11777a;
            view.offsetTopAndBottom(i14);
        } else if (this.f2792d0 && i13 == 5) {
            int i15 = this.f2804q0;
            WeakHashMap weakHashMap4 = m0.f11777a;
            view.offsetTopAndBottom(i15);
        } else if (i13 == 4) {
            int i16 = this.f2790b0;
            WeakHashMap weakHashMap5 = m0.f11777a;
            view.offsetTopAndBottom(i16);
        } else if (i13 == 1 || i13 == 2) {
            int top2 = top - view.getTop();
            WeakHashMap weakHashMap6 = m0.f11777a;
            view.offsetTopAndBottom(top2);
        }
        L(this.f2797i0, false);
        this.f2806s0 = new WeakReference(A(view));
        ArrayList arrayList = this.f2807t0;
        if (arrayList.size() <= 0) {
            return true;
        }
        throw a.k(0, arrayList);
    }

    @Override // f0.b
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(B(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, this.F, marginLayoutParams.width), B(i11, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.G, marginLayoutParams.height));
        return true;
    }

    @Override // f0.b
    public final boolean n(View view) {
        WeakReference weakReference = this.f2806s0;
        return (weakReference == null || view != weakReference.get() || this.f2797i0 == 3 || this.f2796h0) ? false : true;
    }

    @Override // f0.b
    public final void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10, int[] iArr, int i11) {
        if (i11 == 1) {
            return;
        }
        WeakReference weakReference = this.f2806s0;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i12 = top - i10;
        boolean z10 = this.f2794f0;
        boolean z11 = this.f2795g0;
        if (i10 > 0) {
            if (!this.f2801m0 && !z11 && view2 == view3 && view2.canScrollVertically(1)) {
                this.f2796h0 = true;
                return;
            }
            if (i12 < C()) {
                int iC = top - C();
                iArr[1] = iC;
                WeakHashMap weakHashMap = m0.f11777a;
                view.offsetTopAndBottom(-iC);
                H(3);
            } else {
                if (!z10) {
                    return;
                }
                iArr[1] = i10;
                WeakHashMap weakHashMap2 = m0.f11777a;
                view.offsetTopAndBottom(-i10);
                H(1);
            }
        } else if (i10 < 0) {
            boolean zCanScrollVertically = view2.canScrollVertically(-1);
            if (!this.f2801m0 && !z11 && view2 == view3 && zCanScrollVertically) {
                this.f2796h0 = true;
                return;
            }
            if (!zCanScrollVertically) {
                int i13 = this.f2790b0;
                if (i12 > i13 && !this.f2792d0) {
                    int i14 = top - i13;
                    iArr[1] = i14;
                    WeakHashMap weakHashMap3 = m0.f11777a;
                    view.offsetTopAndBottom(-i14);
                    H(4);
                } else {
                    if (!z10) {
                        return;
                    }
                    iArr[1] = i10;
                    WeakHashMap weakHashMap4 = m0.f11777a;
                    view.offsetTopAndBottom(-i10);
                    H(1);
                }
            }
        }
        z(view.getTop());
        this.f2800l0 = i10;
        this.f2801m0 = true;
        this.f2796h0 = false;
    }

    @Override // f0.b
    public final void r(View view, Parcelable parcelable) {
        q9.a aVar = (q9.a) parcelable;
        int i = this.f2809v;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.f2817z = aVar.f10458y;
            }
            if (i == -1 || (i & 2) == 2) {
                this.f2811w = aVar.f10459z;
            }
            if (i == -1 || (i & 4) == 4) {
                this.f2792d0 = aVar.A;
            }
            if (i == -1 || (i & 8) == 8) {
                this.f2793e0 = aVar.B;
            }
        }
        int i10 = aVar.f10457x;
        if (i10 == 1 || i10 == 2) {
            this.f2797i0 = 4;
        } else {
            this.f2797i0 = i10;
        }
    }

    @Override // f0.b
    public final Parcelable s(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new q9.a(this);
    }

    @Override // f0.b
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10) {
        this.f2800l0 = 0;
        this.f2801m0 = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // f0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.C()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.H(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.f2806s0
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.f2801m0
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.f2800l0
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f2811w
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.Z
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.f2792d0
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.f2808u0
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f2813x
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.f2808u0
            int r6 = r2.f2812w0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.I(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.f2800l0
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f2811w
            if (r1 == 0) goto L74
            int r5 = r2.Y
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f2790b0
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.Z
            if (r3 >= r1) goto L83
            int r6 = r2.f2790b0
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f2790b0
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f2811w
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.Z
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f2790b0
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.J(r4, r0, r3)
            r2.f2801m0 = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.u(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // f0.b
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.f2797i0;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        e eVar = this.f2798j0;
        if (eVar != null && (this.f2794f0 || i == 1)) {
            eVar.k(motionEvent);
        }
        if (actionMasked == 0) {
            this.f2812w0 = -1;
            this.f2814x0 = -1;
            VelocityTracker velocityTracker = this.f2808u0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2808u0 = null;
            }
        }
        if (this.f2808u0 == null) {
            this.f2808u0 = VelocityTracker.obtain();
        }
        this.f2808u0.addMovement(motionEvent);
        if (this.f2798j0 != null && ((this.f2794f0 || this.f2797i0 == 1) && actionMasked == 2 && !this.f2799k0)) {
            float fAbs = Math.abs(this.f2814x0 - motionEvent.getY());
            e eVar2 = this.f2798j0;
            if (fAbs > eVar2.f1651b) {
                eVar2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f2799k0;
    }

    public final void w() {
        int iY = y();
        if (this.f2811w) {
            this.f2790b0 = Math.max(this.f2804q0 - iY, this.Y);
        } else {
            this.f2790b0 = this.f2804q0 - iY;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float x() {
        /*
            r5 = this;
            ka.i r0 = r5.D
            r1 = 0
            if (r0 == 0) goto L77
            java.lang.ref.WeakReference r0 = r5.f2805r0
            if (r0 == 0) goto L77
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L77
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L77
            java.lang.ref.WeakReference r0 = r5.f2805r0
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.E()
            if (r2 == 0) goto L77
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L77
            ka.i r2 = r5.D
            float r2 = r2.k()
            android.view.RoundedCorner r3 = i2.a.n(r0)
            if (r3 == 0) goto L44
            int r3 = i2.a.d(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            float r3 = r3 / r2
            goto L45
        L44:
            r3 = r1
        L45:
            ka.i r2 = r5.D
            float[] r4 = r2.X
            if (r4 == 0) goto L4f
            r2 = 0
            r2 = r4[r2]
            goto L5d
        L4f:
            ka.g r4 = r2.f7334w
            ka.m r4 = r4.f7316a
            ka.d r4 = r4.f
            android.graphics.RectF r2 = r2.h()
            float r2 = r4.a(r2)
        L5d:
            android.view.RoundedCorner r0 = i2.a.C(r0)
            if (r0 == 0) goto L72
            int r0 = i2.a.d(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L72
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L72
            float r1 = r0 / r2
        L72:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.x():float");
    }

    public final int y() {
        int i;
        return this.A ? Math.min(Math.max(this.B, this.f2804q0 - ((this.f2803p0 * 9) / 16)), this.o0) + this.Q : (this.I || this.J || (i = this.H) <= 0) ? this.f2817z + this.Q : Math.max(this.f2817z, i + this.C);
    }

    public final void z(int i) {
        if (((View) this.f2805r0.get()) != null) {
            ArrayList arrayList = this.f2807t0;
            if (arrayList.isEmpty()) {
                return;
            }
            int i10 = this.f2790b0;
            if (i <= i10 && i10 != C()) {
                C();
            }
            if (arrayList.size() > 0) {
                throw a.k(0, arrayList);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        this.f2809v = 0;
        this.f2811w = true;
        this.F = -1;
        this.G = -1;
        this.V = new j1(this);
        this.f2789a0 = 0.5f;
        this.f2791c0 = -1.0f;
        this.f2794f0 = true;
        this.f2795g0 = true;
        this.f2797i0 = 4;
        this.f2802n0 = 0.1f;
        this.f2807t0 = new ArrayList();
        this.f2814x0 = -1;
        this.A0 = new SparseIntArray();
        this.B0 = new c(this, 1);
        this.C = context.getResources().getDimensionPixelSize(d.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.BottomSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(l.BottomSheetBehavior_Layout_backgroundTint)) {
            this.E = com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, l.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(l.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.T = m.c(context, attributeSet, k9.b.bottomSheetStyle, C0).a();
        }
        m mVar = this.T;
        if (mVar != null) {
            i iVar = new i(mVar);
            this.D = iVar;
            iVar.m(context);
            ColorStateList colorStateList = this.E;
            if (colorStateList != null) {
                this.D.q(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.D.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(x(), 1.0f);
        this.W = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.W.addUpdateListener(new oa.b(2, this));
        this.f2791c0 = typedArrayObtainStyledAttributes.getDimension(l.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(l.BottomSheetBehavior_Layout_android_maxWidth)) {
            this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.BottomSheetBehavior_Layout_android_maxWidth, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(l.BottomSheetBehavior_Layout_android_maxHeight)) {
            this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.BottomSheetBehavior_Layout_android_maxHeight, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(l.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            F(i);
        } else {
            F(typedArrayObtainStyledAttributes.getDimensionPixelSize(l.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_hideable, false);
        if (this.f2792d0 != z10) {
            this.f2792d0 = z10;
            if (!z10 && this.f2797i0 == 5) {
                G(4);
            }
            K();
        }
        this.I = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.f2811w != z11) {
            this.f2811w = z11;
            if (this.f2805r0 != null) {
                w();
            }
            H((this.f2811w && this.f2797i0 == 6) ? 3 : this.f2797i0);
            L(this.f2797i0, true);
            K();
        }
        this.f2793e0 = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.f2794f0 = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.f2795g0 = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_draggableOnNestedScroll, true);
        this.f2809v = typedArrayObtainStyledAttributes.getInt(l.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(l.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.f2789a0 = f;
            if (this.f2805r0 != null) {
                this.Z = (int) ((1.0f - f) * this.f2804q0);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(l.BottomSheetBehavior_Layout_behavior_expandedOffset);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i10 = typedValuePeekValue2.data;
                if (i10 >= 0) {
                    this.X = i10;
                    L(this.f2797i0, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(l.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
                if (dimensionPixelOffset >= 0) {
                    this.X = dimensionPixelOffset;
                    L(this.f2797i0, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f2815y = typedArrayObtainStyledAttributes.getInt(l.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500);
            this.J = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
            this.K = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
            this.L = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
            this.M = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
            this.N = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
            this.O = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
            this.P = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
            this.S = typedArrayObtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f2813x = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @Override // f0.b
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11, int[] iArr) {
    }
}
