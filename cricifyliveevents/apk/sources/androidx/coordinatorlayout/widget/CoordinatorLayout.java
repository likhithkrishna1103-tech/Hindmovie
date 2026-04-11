package androidx.coordinatorlayout.widget;

import a5.f;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import e0.a;
import e0.b;
import f0.d;
import f0.g;
import f0.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import nc.p;
import p6.c;
import s0.e;
import t0.b0;
import t0.d0;
import t0.m;
import t0.m0;
import t0.n;
import t0.p1;
import v.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements m, n {
    public static final String O;
    public static final Class[] P;
    public static final ThreadLocal Q;
    public static final f R;
    public static final e S;
    public final int[] A;
    public boolean B;
    public boolean C;
    public final int[] D;
    public View E;
    public View F;
    public f0.f G;
    public boolean H;
    public p1 I;
    public boolean J;
    public Drawable K;
    public ViewGroup.OnHierarchyChangeListener L;
    public c M;
    public final d4.e N;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f643v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p f644w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f645x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f646y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f647z;

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        O = r02 != null ? r02.getName() : null;
        R = new f(5);
        P = new Class[]{Context.class, AttributeSet.class};
        Q = new ThreadLocal();
        S = new e(12);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        int i = a.coordinatorLayoutStyle;
        super(context, attributeSet, i);
        this.f643v = new ArrayList();
        this.f644w = new p(6);
        this.f645x = new ArrayList();
        this.f646y = new ArrayList();
        this.f647z = new int[2];
        this.A = new int[2];
        this.N = new d4.e();
        TypedArray typedArrayObtainStyledAttributes = i == 0 ? context.obtainStyledAttributes(attributeSet, e0.c.CoordinatorLayout, 0, b.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, e0.c.CoordinatorLayout, i, 0);
        if (Build.VERSION.SDK_INT < 29) {
            coordinatorLayout = this;
            context2 = context;
        } else if (i == 0) {
            saveAttributeDataForStyleable(context, e0.c.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, b.Widget_Support_CoordinatorLayout);
            coordinatorLayout = this;
            context2 = context;
        } else {
            context2 = context;
            coordinatorLayout = this;
            coordinatorLayout.saveAttributeDataForStyleable(context2, e0.c.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(e0.c.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            coordinatorLayout.D = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i10 = 0; i10 < length; i10++) {
                coordinatorLayout.D[i10] = (int) (r1[i10] * f);
            }
        }
        coordinatorLayout.K = typedArrayObtainStyledAttributes.getDrawable(e0.c.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        y();
        super.setOnHierarchyChangeListener(new d(this));
        WeakHashMap weakHashMap = m0.f11777a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) S.i();
        return rect == null ? new Rect() : rect;
    }

    public static void m(int i, Rect rect, Rect rect2, f0.e eVar, int i10, int i11) {
        int i12 = eVar.f3899c;
        if (i12 == 0) {
            i12 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i12, i);
        int i13 = eVar.f3900d;
        if ((i13 & 7) == 0) {
            i13 |= 8388611;
        }
        if ((i13 & 112) == 0) {
            i13 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i13, i);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int i16 = absoluteGravity2 & 7;
        int i17 = absoluteGravity2 & 112;
        int iWidth = i16 != 1 ? i16 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i17 != 16 ? i17 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i14 == 1) {
            iWidth -= i10 / 2;
        } else if (i14 != 5) {
            iWidth -= i10;
        }
        if (i15 == 16) {
            iHeight -= i11 / 2;
        } else if (i15 != 80) {
            iHeight -= i11;
        }
        rect2.set(iWidth, iHeight, i10 + iWidth, i11 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f0.e o(View view) {
        f0.e eVar = (f0.e) view.getLayoutParams();
        if (!eVar.f3898b) {
            if (view instanceof f0.a) {
                f0.b behavior = ((f0.a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                f0.b bVar = eVar.f3897a;
                if (bVar != behavior) {
                    if (bVar != null) {
                        bVar.j();
                    }
                    eVar.f3897a = behavior;
                    eVar.f3898b = true;
                    if (behavior != null) {
                        behavior.g(eVar);
                    }
                }
                eVar.f3898b = true;
                return eVar;
            }
            f0.c cVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                cVar = (f0.c) superclass.getAnnotation(f0.c.class);
                if (cVar != null) {
                    break;
                }
            }
            if (cVar != null) {
                try {
                    f0.b bVar2 = (f0.b) cVar.value().getDeclaredConstructor(null).newInstance(null);
                    f0.b bVar3 = eVar.f3897a;
                    if (bVar3 != bVar2) {
                        if (bVar3 != null) {
                            bVar3.j();
                        }
                        eVar.f3897a = bVar2;
                        eVar.f3898b = true;
                        if (bVar2 != null) {
                            bVar2.g(eVar);
                        }
                    }
                } catch (Exception e9) {
                    Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e9);
                }
            }
            eVar.f3898b = true;
        }
        return eVar;
    }

    public static void w(View view, int i) {
        f0.e eVar = (f0.e) view.getLayoutParams();
        int i10 = eVar.i;
        if (i10 != i) {
            WeakHashMap weakHashMap = m0.f11777a;
            view.offsetLeftAndRight(i - i10);
            eVar.i = i;
        }
    }

    public static void x(View view, int i) {
        f0.e eVar = (f0.e) view.getLayoutParams();
        int i10 = eVar.f3904j;
        if (i10 != i) {
            WeakHashMap weakHashMap = m0.f11777a;
            view.offsetTopAndBottom(i - i10);
            eVar.f3904j = i;
        }
    }

    @Override // t0.m
    public final void a(View view, View view2, int i, int i10) {
        d4.e eVar = this.N;
        if (i10 == 1) {
            eVar.f3357b = i;
        } else {
            eVar.f3356a = i;
        }
        this.F = view2;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ((f0.e) getChildAt(i11).getLayoutParams()).getClass();
        }
    }

    @Override // t0.m
    public final void b(View view, int i) {
        d4.e eVar = this.N;
        if (i == 1) {
            eVar.f3357b = 0;
        } else {
            eVar.f3356a = 0;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f0.e eVar2 = (f0.e) childAt.getLayoutParams();
            if (eVar2.a(i)) {
                f0.b bVar = eVar2.f3897a;
                if (bVar != null) {
                    bVar.u(this, childAt, view, i);
                }
                if (i == 0) {
                    eVar2.f3907m = false;
                } else if (i == 1) {
                    eVar2.f3908n = false;
                }
                eVar2.f3909o = false;
            }
        }
        this.F = null;
    }

    @Override // t0.m
    public final void c(View view, int i, int i10, int[] iArr, int i11) {
        f0.b bVar;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f0.e eVar = (f0.e) childAt.getLayoutParams();
                if (eVar.a(i11) && (bVar = eVar.f3897a) != null) {
                    int[] iArr2 = this.f647z;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.o(this, childAt, view, i, i10, iArr2, i11);
                    iMax = i > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i10 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z10) {
            q(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f0.e) && super.checkLayoutParams(layoutParams);
    }

    @Override // t0.n
    public final void d(View view, int i, int i10, int i11, int i12, int i13, int[] iArr) {
        f0.b bVar;
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        boolean z10 = false;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                f0.e eVar = (f0.e) childAt.getLayoutParams();
                if (eVar.a(i13) && (bVar = eVar.f3897a) != null) {
                    int[] iArr2 = this.f647z;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.p(this, childAt, i10, i11, i12, iArr2);
                    iMax = i11 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i12 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z10) {
            q(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        f0.b bVar = ((f0.e) view.getLayoutParams()).f3897a;
        if (bVar != null) {
            bVar.getClass();
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.K;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // t0.m
    public final void e(View view, int i, int i10, int i11, int i12, int i13) {
        d(view, i, i10, i11, i12, 0, this.A);
    }

    @Override // t0.m
    public final boolean f(View view, View view2, int i, int i10) {
        View view3;
        int i11;
        int i12;
        int childCount = getChildCount();
        int i13 = 0;
        boolean z10 = false;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                view3 = view;
                i11 = i;
                i12 = i10;
            } else {
                f0.e eVar = (f0.e) childAt.getLayoutParams();
                f0.b bVar = eVar.f3897a;
                if (bVar != null) {
                    view3 = view;
                    i11 = i;
                    i12 = i10;
                    boolean zT = bVar.t(this, childAt, view3, i11, i12);
                    z10 |= zT;
                    if (i12 == 0) {
                        eVar.f3907m = zT;
                    } else if (i12 == 1) {
                        eVar.f3908n = zT;
                    }
                } else {
                    view3 = view;
                    i11 = i;
                    i12 = i10;
                    if (i12 == 0) {
                        eVar.f3907m = false;
                    } else if (i12 == 1) {
                        eVar.f3908n = false;
                    }
                }
            }
            i13++;
            view = view3;
            i = i11;
            i10 = i12;
        }
        return z10;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f0.e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f0.e(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        u();
        return Collections.unmodifiableList(this.f643v);
    }

    public final p1 getLastWindowInsets() {
        return this.I;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        d4.e eVar = this.N;
        return eVar.f3357b | eVar.f3356a;
    }

    public Drawable getStatusBarBackground() {
        return this.K;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(f0.e eVar, Rect rect, int i, int i10) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i10) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i10 + iMax2);
    }

    public final void i(View view) {
        List list = (List) ((k) this.f644w.f9070b).get(view);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            View view2 = (View) list.get(i);
            f0.b bVar = ((f0.e) view2.getLayoutParams()).f3897a;
            if (bVar != null) {
                bVar.h(this, view2, view);
            }
        }
    }

    public final void j(View view, Rect rect, boolean z10) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            l(rect, view);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList k(View view) {
        k kVar = (k) this.f644w.f9070b;
        int i = kVar.f12542x;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < i; i10++) {
            ArrayList arrayList2 = (ArrayList) kVar.j(i10);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.f(i10));
            }
        }
        ArrayList arrayList3 = this.f646y;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void l(Rect rect, View view) {
        ThreadLocal threadLocal = h.f3914a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = h.f3914a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        h.a(this, view, matrix);
        ThreadLocal threadLocal3 = h.f3915b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int n(int i) {
        int[] iArr = this.D;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        v(false);
        if (this.H) {
            if (this.G == null) {
                this.G = new f0.f(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.G);
        }
        if (this.I == null) {
            WeakHashMap weakHashMap = m0.f11777a;
            if (getFitsSystemWindows()) {
                b0.c(this);
            }
        }
        this.C = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v(false);
        if (this.H && this.G != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.G);
        }
        View view = this.F;
        if (view != null) {
            b(view, 0);
        }
        this.C = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.J || this.K == null) {
            return;
        }
        p1 p1Var = this.I;
        int iD = p1Var != null ? p1Var.d() : 0;
        if (iD > 0) {
            this.K.setBounds(0, 0, getWidth(), iD);
            this.K.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            v(true);
        }
        boolean zT = t(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zT;
        }
        v(true);
        return zT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        f0.b bVar;
        WeakHashMap weakHashMap = m0.f11777a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f643v;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            View view = (View) arrayList.get(i13);
            if (view.getVisibility() != 8 && ((bVar = ((f0.e) view.getLayoutParams()).f3897a) == null || !bVar.l(this, view, layoutDirection))) {
                r(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f10, boolean z10) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                f0.e eVar = (f0.e) childAt.getLayoutParams();
                if (eVar.a(0)) {
                    f0.b bVar = eVar.f3897a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f10) {
        f0.b bVar;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                f0.e eVar = (f0.e) childAt.getLayoutParams();
                if (eVar.a(0) && (bVar = eVar.f3897a) != null) {
                    zN |= bVar.n(view);
                }
            }
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i10, int[] iArr) {
        c(view, i, i10, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i10, int i11, int i12) {
        e(view, i, i10, i11, i12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.f112v);
        SparseArray sparseArray = gVar.f3913x;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id2 = childAt.getId();
            f0.b bVar = o(childAt).f3897a;
            if (id2 != -1 && bVar != null && (parcelable2 = (Parcelable) sparseArray.get(id2)) != null) {
                bVar.r(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableS;
        g gVar = new g(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id2 = childAt.getId();
            f0.b bVar = ((f0.e) childAt.getLayoutParams()).f3897a;
            if (id2 != -1 && bVar != null && (parcelableS = bVar.s(childAt)) != null) {
                sparseArray.append(id2, parcelableS);
            }
        }
        gVar.f3913x = sparseArray;
        return gVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return f(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.E
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.t(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.E
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            f0.e r6 = (f0.e) r6
            f0.b r6 = r6.f3897a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.E
            boolean r6 = r6.v(r0, r7, r1)
        L2a:
            android.view.View r7 = r0.E
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.v(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean p(View view, int i, int i10) {
        e eVar = S;
        Rect rectG = g();
        l(rectG, view);
        try {
            return rectG.contains(i, i10);
        } finally {
            rectG.setEmpty();
            eVar.b(rectG);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(int r23) {
        /*
            Method dump skipped, instruction units count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.q(int):void");
    }

    public final void r(View view, int i) {
        Rect rectG;
        Rect rectG2;
        f0.e eVar = (f0.e) view.getLayoutParams();
        View view2 = eVar.f3905k;
        if (view2 == null && eVar.f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        e eVar2 = S;
        if (view2 != null) {
            rectG = g();
            rectG2 = g();
            try {
                l(rectG, view2);
                f0.e eVar3 = (f0.e) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                m(i, rectG, rectG2, eVar3, measuredWidth, measuredHeight);
                h(eVar3, rectG2, measuredWidth, measuredHeight);
                view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
                return;
            } finally {
                rectG.setEmpty();
                eVar2.b(rectG);
                rectG2.setEmpty();
                eVar2.b(rectG2);
            }
        }
        int i10 = eVar.f3901e;
        if (i10 < 0) {
            f0.e eVar4 = (f0.e) view.getLayoutParams();
            rectG = g();
            rectG.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin);
            if (this.I != null) {
                WeakHashMap weakHashMap = m0.f11777a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectG.left = this.I.b() + rectG.left;
                    rectG.top = this.I.d() + rectG.top;
                    rectG.right -= this.I.c();
                    rectG.bottom -= this.I.a();
                }
            }
            rectG2 = g();
            int i11 = eVar4.f3899c;
            if ((i11 & 7) == 0) {
                i11 |= 8388611;
            }
            if ((i11 & 112) == 0) {
                i11 |= 48;
            }
            Gravity.apply(i11, view.getMeasuredWidth(), view.getMeasuredHeight(), rectG, rectG2, i);
            view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
            return;
        }
        f0.e eVar5 = (f0.e) view.getLayoutParams();
        int i12 = eVar5.f3899c;
        if (i12 == 0) {
            i12 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i12, i);
        int i13 = absoluteGravity & 7;
        int i14 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i == 1) {
            i10 = width - i10;
        }
        int iN = n(i10) - measuredWidth2;
        if (i13 == 1) {
            iN += measuredWidth2 / 2;
        } else if (i13 == 5) {
            iN += measuredWidth2;
        }
        int i15 = i14 != 16 ? i14 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar5).leftMargin, Math.min(iN, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) eVar5).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar5).topMargin, Math.min(i15, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) eVar5).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        f0.b bVar = ((f0.e) view.getLayoutParams()).f3897a;
        if (bVar == null || !bVar.q(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (!z10 || this.B) {
            return;
        }
        v(false);
        this.B = true;
    }

    public final void s(View view, int i, int i10, int i11) {
        measureChildWithMargins(view, i, i10, i11, 0);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        y();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.L = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.K;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.K = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.K.setState(getDrawableState());
                }
                Drawable drawable3 = this.K;
                WeakHashMap weakHashMap = m0.f11777a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.K.setVisible(getVisibility() == 0, false);
                this.K.setCallback(this);
            }
            WeakHashMap weakHashMap2 = m0.f11777a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? getContext().getDrawable(i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.K;
        if (drawable == null || drawable.isVisible() == z10) {
            return;
        }
        this.K.setVisible(z10, false);
    }

    public final boolean t(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f645x;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        f fVar = R;
        if (fVar != null) {
            Collections.sort(arrayList, fVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) arrayList.get(i11);
            f0.b bVar = ((f0.e) view.getLayoutParams()).f3897a;
            if (zK && actionMasked != 0) {
                if (bVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i == 0) {
                        bVar.k(this, view, motionEventObtain);
                    } else if (i == 1) {
                        bVar.v(this, view, motionEventObtain);
                    }
                }
            } else if (!zK && bVar != null) {
                if (i == 0) {
                    zK = bVar.k(this, view, motionEvent);
                } else if (i == 1) {
                    zK = bVar.v(this, view, motionEvent);
                }
                if (zK) {
                    this.E = view;
                }
            }
        }
        arrayList.clear();
        return zK;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.u():void");
    }

    public final void v(boolean z10) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            f0.b bVar = ((f0.e) childAt.getLayoutParams()).f3897a;
            if (bVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    bVar.k(this, childAt, motionEventObtain);
                } else {
                    bVar.v(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            ((f0.e) getChildAt(i10).getLayoutParams()).getClass();
        }
        this.E = null;
        this.B = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.K;
    }

    public final void y() {
        WeakHashMap weakHashMap = m0.f11777a;
        if (!getFitsSystemWindows()) {
            d0.l(this, null);
            return;
        }
        if (this.M == null) {
            this.M = new c(10, this);
        }
        d0.l(this, this.M);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f0.e ? new f0.e((f0.e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f0.e((ViewGroup.MarginLayoutParams) layoutParams) : new f0.e(layoutParams);
    }
}
