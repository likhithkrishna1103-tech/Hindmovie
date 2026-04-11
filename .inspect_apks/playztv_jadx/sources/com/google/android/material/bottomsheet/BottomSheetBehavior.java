package com.google.android.material.bottomsheet;

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
import c0.b;
import c0.e;
import e6.i;
import e6.j;
import g4.l1;
import g5.l;
import j9.b0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import k9.f;
import l4.a;
import n.t0;
import p8.k;
import q0.f0;
import q0.o0;
import q9.g;
import r9.c;
import y0.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends b implements k9.b {

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final int f3335z0 = k.Widget_Design_BottomSheet_Modal;
    public int A;
    public final int B;
    public final g C;
    public final ColorStateList D;
    public final int E;
    public final int F;
    public int G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public int P;
    public int Q;
    public final boolean R;
    public final q9.k S;
    public boolean T;
    public final l1 U;
    public final ValueAnimator V;
    public final int W;
    public int X;
    public int Y;
    public final float Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f3336a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final float f3337b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f3338c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f3339d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final boolean f3340e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f3341f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public d f3342g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f3343h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f3344i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f3345j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final float f3346k0;
    public int l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f3347m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f3348n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public WeakReference f3349o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public WeakReference f3350p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final ArrayList f3351q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public VelocityTracker f3352r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public f f3353s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f3354t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f3355u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f3356u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3357v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f3358v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f3359w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public HashMap f3360w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3361x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final SparseIntArray f3362x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3363y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final c f3364y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3365z;

    public BottomSheetBehavior() {
        this.f3355u = 0;
        this.f3357v = true;
        this.E = -1;
        this.F = -1;
        this.U = new l1(this);
        this.Z = 0.5f;
        this.f3337b0 = -1.0f;
        this.f3340e0 = true;
        this.f3341f0 = 4;
        this.f3346k0 = 0.1f;
        this.f3351q0 = new ArrayList();
        this.f3356u0 = -1;
        this.f3362x0 = new SparseIntArray();
        this.f3364y0 = new c(this, 1);
    }

    public static View A(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap weakHashMap = o0.f10475a;
        if (f0.h(view)) {
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
        if (this.f3357v) {
            return this.X;
        }
        return Math.max(this.W, this.L ? 0 : this.Q);
    }

    public final int D(int i) {
        if (i == 3) {
            return C();
        }
        if (i == 4) {
            return this.f3336a0;
        }
        if (i == 5) {
            return this.f3348n0;
        }
        if (i == 6) {
            return this.Y;
        }
        throw new IllegalArgumentException(j.l("Invalid state to get top offset: ", i));
    }

    public final boolean E() {
        WeakReference weakReference = this.f3349o0;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.f3349o0.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void F(int i) {
        if (i == -1) {
            if (this.f3365z) {
                return;
            } else {
                this.f3365z = true;
            }
        } else {
            if (!this.f3365z && this.f3363y == i) {
                return;
            }
            this.f3365z = false;
            this.f3363y = Math.max(0, i);
        }
        N();
    }

    public final void G(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(a.o(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.f3338c0 && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i10 = (i == 6 && this.f3357v && D(i) <= this.X) ? 3 : i;
        WeakReference weakReference = this.f3349o0;
        if (weakReference == null || weakReference.get() == null) {
            H(i);
            return;
        }
        View view = (View) this.f3349o0.get();
        t0 t0Var = new t0(this, view, i10);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = o0.f10475a;
            if (view.isAttachedToWindow()) {
                view.post(t0Var);
                return;
            }
        }
        t0Var.run();
    }

    public final void H(int i) {
        if (this.f3341f0 == i) {
            return;
        }
        this.f3341f0 = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z2 = this.f3338c0;
        }
        WeakReference weakReference = this.f3349o0;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            M(true);
        } else if (i == 6 || i == 5 || i == 4) {
            M(false);
        }
        L(i, true);
        ArrayList arrayList = this.f3351q0;
        if (arrayList.size() <= 0) {
            K();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final boolean I(View view, float f) {
        if (this.f3339d0) {
            return true;
        }
        if (view.getTop() < this.f3336a0) {
            return false;
        }
        return Math.abs(((f * this.f3346k0) + ((float) view.getTop())) - ((float) this.f3336a0)) / ((float) y()) > 0.5f;
    }

    public final void J(View view, int i, boolean z2) {
        int iD = D(i);
        d dVar = this.f3342g0;
        if (dVar == null || (!z2 ? dVar.s(view, view.getLeft(), iD) : dVar.q(view.getLeft(), iD))) {
            H(i);
            return;
        }
        H(2);
        L(i, true);
        this.U.a(i);
    }

    public final void K() {
        View view;
        int iA;
        WeakReference weakReference = this.f3349o0;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        o0.k(view, 524288);
        o0.h(view, 0);
        o0.k(view, 262144);
        o0.h(view, 0);
        o0.k(view, 1048576);
        o0.h(view, 0);
        SparseIntArray sparseIntArray = this.f3362x0;
        int i = sparseIntArray.get(0, -1);
        if (i != -1) {
            o0.k(view, i);
            o0.h(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.f3357v && this.f3341f0 != 6) {
            String string = view.getResources().getString(p8.j.bottomsheet_action_expand_halfway);
            i iVar = new i(6, this);
            ArrayList arrayListF = o0.f(view);
            int i10 = 0;
            while (true) {
                if (i10 >= arrayListF.size()) {
                    int i11 = 0;
                    int i12 = -1;
                    while (true) {
                        int[] iArr = o0.f10478d;
                        if (i11 >= 32 || i12 != -1) {
                            break;
                        }
                        int i13 = iArr[i11];
                        boolean z2 = true;
                        for (int i14 = 0; i14 < arrayListF.size(); i14++) {
                            z2 &= ((r0.d) arrayListF.get(i14)).a() != i13;
                        }
                        if (z2) {
                            i12 = i13;
                        }
                        i11++;
                    }
                    iA = i12;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((r0.d) arrayListF.get(i10)).f11221a).getLabel())) {
                        iA = ((r0.d) arrayListF.get(i10)).a();
                        break;
                    }
                    i10++;
                }
            }
            if (iA != -1) {
                r0.d dVar = new r0.d(null, iA, string, iVar, null);
                View.AccessibilityDelegate accessibilityDelegateD = o0.d(view);
                q0.b bVar = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof q0.a ? ((q0.a) accessibilityDelegateD).f10412a : new q0.b(accessibilityDelegateD);
                if (bVar == null) {
                    bVar = new q0.b();
                }
                o0.n(view, bVar);
                o0.k(view, dVar.a());
                o0.f(view).add(dVar);
                o0.h(view, 0);
            }
            sparseIntArray.put(0, iA);
        }
        if (this.f3338c0 && this.f3341f0 != 5) {
            o0.l(view, r0.d.f11216l, new i(5, this));
        }
        int i15 = this.f3341f0;
        if (i15 == 3) {
            o0.l(view, r0.d.f11215k, new i(this.f3357v ? 4 : 6, this));
            return;
        }
        if (i15 == 4) {
            o0.l(view, r0.d.f11214j, new i(this.f3357v ? 3 : 6, this));
        } else {
            if (i15 != 6) {
                return;
            }
            o0.l(view, r0.d.f11215k, new i(4, this));
            o0.l(view, r0.d.f11214j, new i(3, this));
        }
    }

    public final void L(int i, boolean z2) {
        g gVar;
        if (i == 2) {
            return;
        }
        boolean z10 = this.f3341f0 == 3 && (this.R || E());
        if (this.T == z10 || (gVar = this.C) == null) {
            return;
        }
        this.T = z10;
        ValueAnimator valueAnimator = this.V;
        if (!z2 || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            gVar.m(this.T ? x() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(gVar.f11105u.i, z10 ? x() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void M(boolean z2) {
        WeakReference weakReference = this.f3349o0;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z2) {
                if (this.f3360w0 != null) {
                    return;
                } else {
                    this.f3360w0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.f3349o0.get() && z2) {
                    this.f3360w0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z2) {
                return;
            }
            this.f3360w0 = null;
        }
    }

    public final void N() {
        View view;
        if (this.f3349o0 != null) {
            w();
            if (this.f3341f0 != 4 || (view = (View) this.f3349o0.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // k9.b
    public final void a() {
        f fVar = this.f3353s0;
        if (fVar == null) {
            return;
        }
        int i = fVar.f7582d;
        int i10 = fVar.f7581c;
        c.c cVar = fVar.f;
        fVar.f = null;
        if (cVar != null) {
            float f = cVar.f2153c;
            if (Build.VERSION.SDK_INT >= 34) {
                if (!this.f3338c0) {
                    AnimatorSet animatorSetA = fVar.a();
                    animatorSetA.setDuration(q8.a.c(f, i10, i));
                    animatorSetA.start();
                    G(4);
                    return;
                }
                l lVar = new l(9, this);
                View view = fVar.f7580b;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getScaleY() * view.getHeight());
                objectAnimatorOfFloat.setInterpolator(new k1.a(1));
                objectAnimatorOfFloat.setDuration(q8.a.c(f, i10, i));
                objectAnimatorOfFloat.addListener(new l(4, fVar));
                objectAnimatorOfFloat.addListener(lVar);
                objectAnimatorOfFloat.start();
                return;
            }
        }
        G(this.f3338c0 ? 5 : 4);
    }

    @Override // k9.b
    public final void b(c.c cVar) {
        f fVar = this.f3353s0;
        if (fVar == null) {
            return;
        }
        if (fVar.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        c.c cVar2 = fVar.f;
        fVar.f = cVar;
        if (cVar2 == null) {
            return;
        }
        fVar.b(cVar.f2153c);
    }

    @Override // k9.b
    public final void c(c.c cVar) {
        f fVar = this.f3353s0;
        if (fVar == null) {
            return;
        }
        fVar.f = cVar;
    }

    @Override // k9.b
    public final void d() {
        f fVar = this.f3353s0;
        if (fVar == null) {
            return;
        }
        if (fVar.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        c.c cVar = fVar.f;
        fVar.f = null;
        if (cVar == null) {
            return;
        }
        AnimatorSet animatorSetA = fVar.a();
        animatorSetA.setDuration(fVar.f7583e);
        animatorSetA.start();
    }

    @Override // c0.b
    public final void g(e eVar) {
        this.f3349o0 = null;
        this.f3342g0 = null;
        this.f3353s0 = null;
    }

    @Override // c0.b
    public final void j() {
        this.f3349o0 = null;
        this.f3342g0 = null;
        this.f3353s0 = null;
    }

    @Override // c0.b
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i;
        d dVar;
        if (!view.isShown() || !this.f3340e0) {
            this.f3343h0 = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3354t0 = -1;
            this.f3356u0 = -1;
            VelocityTracker velocityTracker = this.f3352r0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f3352r0 = null;
            }
        }
        if (this.f3352r0 == null) {
            this.f3352r0 = VelocityTracker.obtain();
        }
        this.f3352r0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.f3356u0 = (int) motionEvent.getY();
            if (this.f3341f0 != 2) {
                WeakReference weakReference = this.f3350p0;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.p(view2, x10, this.f3356u0)) {
                    this.f3354t0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f3358v0 = true;
                }
            }
            this.f3343h0 = this.f3354t0 == -1 && !coordinatorLayout.p(view, x10, this.f3356u0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f3358v0 = false;
            this.f3354t0 = -1;
            if (this.f3343h0) {
                this.f3343h0 = false;
                return false;
            }
        }
        if (this.f3343h0 || (dVar = this.f3342g0) == null || !dVar.r(motionEvent)) {
            WeakReference weakReference2 = this.f3350p0;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.f3343h0 || this.f3341f0 == 1 || coordinatorLayout.p(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f3342g0 == null || (i = this.f3356u0) == -1 || Math.abs(i - motionEvent.getY()) <= this.f3342g0.f14438b) {
                return false;
            }
        }
        return true;
    }

    @Override // c0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = o0.f10475a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.f3349o0 == null) {
            this.A = coordinatorLayout.getResources().getDimensionPixelSize(p8.d.design_bottom_sheet_peek_height_min);
            boolean z2 = (Build.VERSION.SDK_INT < 29 || this.H || this.f3365z) ? false : true;
            if (this.I || this.J || this.K || this.M || this.N || this.O || z2) {
                e6.f0 f0Var = new e6.f0();
                f0Var.f4499v = this;
                f0Var.f4498u = z2;
                j9.f0.a(view, f0Var);
            }
            o0.q(view, new w8.b(view));
            this.f3349o0 = new WeakReference(view);
            this.f3353s0 = new f(view);
            g gVar = this.C;
            if (gVar != null) {
                view.setBackground(gVar);
                float fE = this.f3337b0;
                if (fE == -1.0f) {
                    fE = f0.e(view);
                }
                gVar.k(fE);
            } else {
                ColorStateList colorStateList = this.D;
                if (colorStateList != null) {
                    f0.i(view, colorStateList);
                }
            }
            K();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.f3342g0 == null) {
            this.f3342g0 = new d(coordinatorLayout.getContext(), coordinatorLayout, this.f3364y0);
        }
        int top = view.getTop();
        coordinatorLayout.r(view, i);
        this.f3347m0 = coordinatorLayout.getWidth();
        this.f3348n0 = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.l0 = height;
        int iMin = this.f3348n0;
        int i10 = iMin - height;
        int i11 = this.Q;
        if (i10 < i11) {
            boolean z10 = this.L;
            int i12 = this.F;
            if (z10) {
                if (i12 != -1) {
                    iMin = Math.min(iMin, i12);
                }
                this.l0 = iMin;
            } else {
                int iMin2 = iMin - i11;
                if (i12 != -1) {
                    iMin2 = Math.min(iMin2, i12);
                }
                this.l0 = iMin2;
            }
        }
        this.X = Math.max(0, this.f3348n0 - this.l0);
        this.Y = (int) ((1.0f - this.Z) * this.f3348n0);
        w();
        int i13 = this.f3341f0;
        if (i13 == 3) {
            view.offsetTopAndBottom(C());
        } else if (i13 == 6) {
            view.offsetTopAndBottom(this.Y);
        } else if (this.f3338c0 && i13 == 5) {
            view.offsetTopAndBottom(this.f3348n0);
        } else if (i13 == 4) {
            view.offsetTopAndBottom(this.f3336a0);
        } else if (i13 == 1 || i13 == 2) {
            view.offsetTopAndBottom(top - view.getTop());
        }
        L(this.f3341f0, false);
        this.f3350p0 = new WeakReference(A(view));
        ArrayList arrayList = this.f3351q0;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // c0.b
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(B(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, this.E, marginLayoutParams.width), B(i11, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.F, marginLayoutParams.height));
        return true;
    }

    @Override // c0.b
    public final boolean n(View view) {
        WeakReference weakReference = this.f3350p0;
        return (weakReference == null || view != weakReference.get() || this.f3341f0 == 3) ? false : true;
    }

    @Override // c0.b
    public final void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10, int[] iArr, int i11) {
        if (i11 == 1) {
            return;
        }
        WeakReference weakReference = this.f3350p0;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i12 = top - i10;
        boolean z2 = this.f3340e0;
        if (i10 > 0) {
            if (i12 < C()) {
                int iC = top - C();
                iArr[1] = iC;
                int i13 = -iC;
                WeakHashMap weakHashMap = o0.f10475a;
                view.offsetTopAndBottom(i13);
                H(3);
            } else {
                if (!z2) {
                    return;
                }
                iArr[1] = i10;
                WeakHashMap weakHashMap2 = o0.f10475a;
                view.offsetTopAndBottom(-i10);
                H(1);
            }
        } else if (i10 < 0 && !view2.canScrollVertically(-1)) {
            int i14 = this.f3336a0;
            if (i12 > i14 && !this.f3338c0) {
                int i15 = top - i14;
                iArr[1] = i15;
                int i16 = -i15;
                WeakHashMap weakHashMap3 = o0.f10475a;
                view.offsetTopAndBottom(i16);
                H(4);
            } else {
                if (!z2) {
                    return;
                }
                iArr[1] = i10;
                WeakHashMap weakHashMap4 = o0.f10475a;
                view.offsetTopAndBottom(-i10);
                H(1);
            }
        }
        z(view.getTop());
        this.f3344i0 = i10;
        this.f3345j0 = true;
    }

    @Override // c0.b
    public final void r(View view, Parcelable parcelable) {
        w8.a aVar = (w8.a) parcelable;
        int i = this.f3355u;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.f3363y = aVar.f13753x;
            }
            if (i == -1 || (i & 2) == 2) {
                this.f3357v = aVar.f13754y;
            }
            if (i == -1 || (i & 4) == 4) {
                this.f3338c0 = aVar.f13755z;
            }
            if (i == -1 || (i & 8) == 8) {
                this.f3339d0 = aVar.A;
            }
        }
        int i10 = aVar.f13752w;
        if (i10 == 1 || i10 == 2) {
            this.f3341f0 = 4;
        } else {
            this.f3341f0 = i10;
        }
    }

    @Override // c0.b
    public final Parcelable s(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new w8.a(this);
    }

    @Override // c0.b
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i10) {
        this.f3344i0 = 0;
        this.f3345j0 = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // c0.b
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
            java.lang.ref.WeakReference r3 = r2.f3350p0
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.f3345j0
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.f3344i0
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f3357v
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.Y
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.f3338c0
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.f3352r0
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f3359w
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.f3352r0
            int r6 = r2.f3354t0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.I(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.f3344i0
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f3357v
            if (r1 == 0) goto L74
            int r5 = r2.X
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f3336a0
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.Y
            if (r3 >= r1) goto L83
            int r6 = r2.f3336a0
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f3336a0
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f3357v
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.Y
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f3336a0
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.J(r4, r0, r3)
            r2.f3345j0 = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.u(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // c0.b
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.f3341f0;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        d dVar = this.f3342g0;
        if (dVar != null && (this.f3340e0 || i == 1)) {
            dVar.k(motionEvent);
        }
        if (actionMasked == 0) {
            this.f3354t0 = -1;
            this.f3356u0 = -1;
            VelocityTracker velocityTracker = this.f3352r0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f3352r0 = null;
            }
        }
        if (this.f3352r0 == null) {
            this.f3352r0 = VelocityTracker.obtain();
        }
        this.f3352r0.addMovement(motionEvent);
        if (this.f3342g0 != null && ((this.f3340e0 || this.f3341f0 == 1) && actionMasked == 2 && !this.f3343h0)) {
            float fAbs = Math.abs(this.f3356u0 - motionEvent.getY());
            d dVar2 = this.f3342g0;
            if (fAbs > dVar2.f14438b) {
                dVar2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f3343h0;
    }

    public final void w() {
        int iY = y();
        if (this.f3357v) {
            this.f3336a0 = Math.max(this.f3348n0 - iY, this.X);
        } else {
            this.f3336a0 = this.f3348n0 - iY;
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
            q9.g r0 = r5.C
            r1 = 0
            if (r0 == 0) goto L6f
            java.lang.ref.WeakReference r0 = r5.f3349o0
            if (r0 == 0) goto L6f
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L6f
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L6f
            java.lang.ref.WeakReference r0 = r5.f3349o0
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.E()
            if (r2 == 0) goto L6f
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L6f
            q9.g r2 = r5.C
            float r2 = r2.h()
            android.view.RoundedCorner r3 = c2.v.m(r0)
            if (r3 == 0) goto L44
            int r3 = c2.v.e(r3)
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
            q9.g r2 = r5.C
            q9.f r4 = r2.f11105u
            q9.k r4 = r4.f11090a
            q9.c r4 = r4.f
            android.graphics.RectF r2 = r2.g()
            float r2 = r4.a(r2)
            android.view.RoundedCorner r0 = c2.v.z(r0)
            if (r0 == 0) goto L6a
            int r0 = c2.v.e(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L6a
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L6a
            float r1 = r0 / r2
        L6a:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.x():float");
    }

    public final int y() {
        int i;
        return this.f3365z ? Math.min(Math.max(this.A, this.f3348n0 - ((this.f3347m0 * 9) / 16)), this.l0) + this.P : (this.H || this.I || (i = this.G) <= 0) ? this.f3363y + this.P : Math.max(this.f3363y, i + this.B);
    }

    public final void z(int i) {
        if (((View) this.f3349o0.get()) != null) {
            ArrayList arrayList = this.f3351q0;
            if (arrayList.isEmpty()) {
                return;
            }
            int i10 = this.f3336a0;
            if (i <= i10 && i10 != C()) {
                C();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        this.f3355u = 0;
        this.f3357v = true;
        this.E = -1;
        this.F = -1;
        this.U = new l1(this);
        this.Z = 0.5f;
        this.f3337b0 = -1.0f;
        this.f3340e0 = true;
        int i10 = 4;
        this.f3341f0 = 4;
        this.f3346k0 = 0.1f;
        this.f3351q0 = new ArrayList();
        this.f3356u0 = -1;
        this.f3362x0 = new SparseIntArray();
        this.f3364y0 = new c(this, 1);
        this.B = context.getResources().getDimensionPixelSize(p8.d.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p8.l.BottomSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(p8.l.BottomSheetBehavior_Layout_backgroundTint)) {
            this.D = a.a.i(context, typedArrayObtainStyledAttributes, p8.l.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(p8.l.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.S = q9.k.c(context, attributeSet, p8.b.bottomSheetStyle, f3335z0).a();
        }
        q9.k kVar = this.S;
        if (kVar != null) {
            g gVar = new g(kVar);
            this.C = gVar;
            gVar.j(context);
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                this.C.l(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.C.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(x(), 1.0f);
        this.V = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.V.addUpdateListener(new b0(i10, this));
        this.f3337b0 = typedArrayObtainStyledAttributes.getDimension(p8.l.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(p8.l.BottomSheetBehavior_Layout_android_maxWidth)) {
            this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.BottomSheetBehavior_Layout_android_maxWidth, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(p8.l.BottomSheetBehavior_Layout_android_maxHeight)) {
            this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.BottomSheetBehavior_Layout_android_maxHeight, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(p8.l.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            F(i);
        } else {
            F(typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_behavior_hideable, false);
        if (this.f3338c0 != z2) {
            this.f3338c0 = z2;
            if (!z2 && this.f3341f0 == 5) {
                G(4);
            }
            K();
        }
        this.H = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.f3357v != z10) {
            this.f3357v = z10;
            if (this.f3349o0 != null) {
                w();
            }
            H((this.f3357v && this.f3341f0 == 6) ? 3 : this.f3341f0);
            L(this.f3341f0, true);
            K();
        }
        this.f3339d0 = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.f3340e0 = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.f3355u = typedArrayObtainStyledAttributes.getInt(p8.l.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(p8.l.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.Z = f;
            if (this.f3349o0 != null) {
                this.Y = (int) ((1.0f - f) * this.f3348n0);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(p8.l.BottomSheetBehavior_Layout_behavior_expandedOffset);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i11 = typedValuePeekValue2.data;
                if (i11 >= 0) {
                    this.W = i11;
                    L(this.f3341f0, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(p8.l.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
                if (dimensionPixelOffset >= 0) {
                    this.W = dimensionPixelOffset;
                    L(this.f3341f0, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f3361x = typedArrayObtainStyledAttributes.getInt(p8.l.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500);
            this.I = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
            this.J = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
            this.K = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
            this.L = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
            this.M = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
            this.N = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
            this.O = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
            this.R = typedArrayObtainStyledAttributes.getBoolean(p8.l.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f3359w = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @Override // c0.b
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i10, int i11, int[] iArr) {
    }
}
