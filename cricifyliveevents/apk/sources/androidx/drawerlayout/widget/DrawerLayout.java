package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import b1.e;
import com.google.android.material.datepicker.g;
import i1.a;
import j1.b;
import j1.c;
import j1.d;
import j1.f;
import java.util.ArrayList;
import java.util.WeakHashMap;
import t0.d0;
import t0.m0;
import t0.p1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int[] f821b0 = {R.attr.colorPrimaryDark};

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int[] f822c0 = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final boolean f823d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final boolean f824e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final boolean f825f0;
    public final Paint A;
    public final e B;
    public final e C;
    public final f D;
    public final f E;
    public int F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public c N;
    public ArrayList O;
    public float P;
    public float Q;
    public Drawable R;
    public WindowInsets S;
    public boolean T;
    public final ArrayList U;
    public Rect V;
    public Matrix W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final pc.c f826a0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f827v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f828w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f829x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f830y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f831z;

    static {
        int i = Build.VERSION.SDK_INT;
        f823d0 = true;
        f824e0 = true;
        f825f0 = i >= 29;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DrawerLayout(Context context, AttributeSet attributeSet) {
        int i = a.drawerLayoutStyle;
        super(context, attributeSet, i);
        this.f827v = new g(3);
        this.f830y = -1728053248;
        this.A = new Paint();
        this.H = true;
        this.I = 3;
        this.J = 3;
        this.K = 3;
        this.L = 3;
        this.f826a0 = new pc.c(this);
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f829x = (int) ((64.0f * f) + 0.5f);
        float f10 = f * 400.0f;
        f fVar = new f(this, 3);
        this.D = fVar;
        f fVar2 = new f(this, 5);
        this.E = fVar2;
        e eVar = new e(getContext(), this, fVar);
        eVar.f1651b = (int) (eVar.f1651b * 1.0f);
        this.B = eVar;
        eVar.f1664q = 1;
        eVar.f1661n = f10;
        fVar.f6511b = eVar;
        e eVar2 = new e(getContext(), this, fVar2);
        eVar2.f1651b = (int) (1.0f * eVar2.f1651b);
        this.C = eVar2;
        eVar2.f1664q = 2;
        eVar2.f1661n = f10;
        fVar2.f6511b = eVar2;
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = m0.f11777a;
        setImportantForAccessibility(1);
        m0.n(this, new b(this));
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            setOnApplyWindowInsetsListener(new j1.a());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f821b0);
            try {
                this.R = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, i1.c.DrawerLayout, i, 0);
        try {
            if (typedArrayObtainStyledAttributes2.hasValue(i1.c.DrawerLayout_elevation)) {
                this.f828w = typedArrayObtainStyledAttributes2.getDimension(i1.c.DrawerLayout_elevation, 0.0f);
            } else {
                this.f828w = getResources().getDimension(i1.b.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.U = new ArrayList();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public static String k(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    public static boolean l(View view) {
        WeakHashMap weakHashMap = m0.f11777a;
        return (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) ? false : true;
    }

    public static boolean m(View view) {
        return ((d) view.getLayoutParams()).f6503a == 0;
    }

    public static boolean n(View view) {
        if (o(view)) {
            return (((d) view.getLayoutParams()).f6506d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public static boolean o(View view) {
        int i = ((d) view.getLayoutParams()).f6503a;
        WeakHashMap weakHashMap = m0.f11777a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public static boolean p(View view) {
        if (o(view)) {
            return ((d) view.getLayoutParams()).f6504b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.O == null) {
            this.O = new ArrayList();
        }
        this.O.add(cVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i10) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i11 = 0;
        boolean z10 = false;
        while (true) {
            arrayList2 = this.U;
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (!o(childAt)) {
                arrayList2.add(childAt);
            } else if (n(childAt)) {
                childAt.addFocusables(arrayList, i, i10);
                z10 = true;
            }
            i11++;
        }
        if (!z10) {
            int size = arrayList2.size();
            for (int i12 = 0; i12 < size; i12++) {
                View view = (View) arrayList2.get(i12);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i10);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        View childAt;
        super.addView(view, i, layoutParams);
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                childAt = null;
                break;
            }
            childAt = getChildAt(i10);
            if ((((d) childAt.getLayoutParams()).f6506d & 1) == 1) {
                break;
            } else {
                i10++;
            }
        }
        if (childAt != null || o(view)) {
            WeakHashMap weakHashMap = m0.f11777a;
            view.setImportantForAccessibility(4);
        } else {
            WeakHashMap weakHashMap2 = m0.f11777a;
            view.setImportantForAccessibility(1);
        }
        if (f823d0) {
            return;
        }
        m0.n(view, this.f827v);
    }

    public final boolean b(View view, int i) {
        return (j(view) & i) == i;
    }

    public final void c(View view, boolean z10) {
        if (!o(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        d dVar = (d) view.getLayoutParams();
        if (this.H) {
            dVar.f6504b = 0.0f;
            dVar.f6506d = 0;
        } else if (z10) {
            dVar.f6506d |= 4;
            if (b(view, 3)) {
                this.B.s(view, -view.getWidth(), view.getTop());
            } else {
                this.C.s(view, getWidth(), view.getTop());
            }
        } else {
            float f = ((d) view.getLayoutParams()).f6504b;
            float width = view.getWidth();
            int i = ((int) (width * 0.0f)) - ((int) (f * width));
            if (!b(view, 3)) {
                i = -i;
            }
            view.offsetLeftAndRight(i);
            t(view, 0.0f);
            w(view, 0);
            view.setVisibility(4);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((d) getChildAt(i).getLayoutParams()).f6504b);
        }
        this.f831z = fMax;
        boolean zG = this.B.g();
        boolean zG2 = this.C.g();
        if (zG || zG2) {
            WeakHashMap weakHashMap = m0.f11777a;
            postInvalidateOnAnimation();
        }
    }

    public final void d() {
        View viewF = f(8388611);
        if (viewF != null) {
            c(viewF, true);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + k(8388611));
        }
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean zDispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f831z <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (this.V == null) {
                this.V = new Rect();
            }
            childAt.getHitRect(this.V);
            if (this.V.contains((int) x10, (int) y10) && !m(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.W == null) {
                            this.W = new Matrix();
                        }
                        matrix.invert(this.W);
                        motionEventObtain.transform(this.W);
                    }
                    zDispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zDispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        Drawable background;
        int height = getHeight();
        boolean zM = m(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i = 0;
        if (zM) {
            int childCount = getChildCount();
            int i10 = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && o(childAt) && childAt.getHeight() >= height) {
                    if (b(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i10) {
                            i10 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i10, 0, width, getHeight());
            i = i10;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j4);
        canvas.restoreToCount(iSave);
        float f = this.f831z;
        if (f > 0.0f && zM) {
            int i12 = this.f830y;
            Paint paint = this.A;
            paint.setColor((((int) ((((-16777216) & i12) >>> 24) * f)) << 24) | (i12 & 16777215));
            canvas.drawRect(i, 0.0f, width, getHeight(), paint);
        }
        return zDrawChild;
    }

    public final void e(boolean z10) {
        int childCount = getChildCount();
        boolean zS = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d dVar = (d) childAt.getLayoutParams();
            if (o(childAt) && (!z10 || dVar.f6505c)) {
                zS |= b(childAt, 3) ? this.B.s(childAt, -childAt.getWidth(), childAt.getTop()) : this.C.s(childAt, getWidth(), childAt.getTop());
                dVar.f6505c = false;
            }
        }
        f fVar = this.D;
        fVar.f6513d.removeCallbacks(fVar.f6512c);
        f fVar2 = this.E;
        fVar2.f6513d.removeCallbacks(fVar2.f6512c);
        if (zS) {
            invalidate();
        }
    }

    public final View f(int i) {
        WeakHashMap weakHashMap = m0.f11777a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((j(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public final View g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (o(childAt) && p(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        d dVar = new d(-1, -1);
        dVar.f6503a = 0;
        return dVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            d dVar = (d) layoutParams;
            d dVar2 = new d(dVar);
            dVar2.f6503a = 0;
            dVar2.f6503a = dVar.f6503a;
            return dVar2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            d dVar3 = new d((ViewGroup.MarginLayoutParams) layoutParams);
            dVar3.f6503a = 0;
            return dVar3;
        }
        d dVar4 = new d(layoutParams);
        dVar4.f6503a = 0;
        return dVar4;
    }

    public float getDrawerElevation() {
        if (f824e0) {
            return this.f828w;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.R;
    }

    public final int h(int i) {
        WeakHashMap weakHashMap = m0.f11777a;
        int layoutDirection = getLayoutDirection();
        if (i == 3) {
            int i10 = this.I;
            if (i10 != 3) {
                return i10;
            }
            int i11 = layoutDirection == 0 ? this.K : this.L;
            if (i11 != 3) {
                return i11;
            }
            return 0;
        }
        if (i == 5) {
            int i12 = this.J;
            if (i12 != 3) {
                return i12;
            }
            int i13 = layoutDirection == 0 ? this.L : this.K;
            if (i13 != 3) {
                return i13;
            }
            return 0;
        }
        if (i == 8388611) {
            int i14 = this.K;
            if (i14 != 3) {
                return i14;
            }
            int i15 = layoutDirection == 0 ? this.I : this.J;
            if (i15 != 3) {
                return i15;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i16 = this.L;
        if (i16 != 3) {
            return i16;
        }
        int i17 = layoutDirection == 0 ? this.J : this.I;
        if (i17 != 3) {
            return i17;
        }
        return 0;
    }

    public final int i(View view) {
        if (o(view)) {
            return h(((d) view.getLayoutParams()).f6503a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final int j(View view) {
        int i = ((d) view.getLayoutParams()).f6503a;
        WeakHashMap weakHashMap = m0.f11777a;
        return Gravity.getAbsoluteGravity(i, getLayoutDirection());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.H = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.T || this.R == null) {
            return;
        }
        WindowInsets windowInsets = this.S;
        int systemWindowInsetTop = windowInsets != null ? windowInsets.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.R.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.R.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            b1.e r1 = r8.B
            boolean r2 = r1.r(r9)
            b1.e r3 = r8.C
            boolean r3 = r3.r(r9)
            r2 = r2 | r3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L65
            if (r0 == r3) goto L5e
            r9 = 2
            if (r0 == r9) goto L1e
            r9 = 3
            if (r0 == r9) goto L5e
            goto L63
        L1e:
            float[] r9 = r1.f1653d
            int r9 = r9.length
            r0 = r4
        L22:
            if (r0 >= r9) goto L63
            int r5 = r1.f1658k
            int r6 = r3 << r0
            r5 = r5 & r6
            if (r5 == 0) goto L5b
            float[] r5 = r1.f
            r5 = r5[r0]
            float[] r6 = r1.f1653d
            r6 = r6[r0]
            float r5 = r5 - r6
            float[] r6 = r1.f1655g
            r6 = r6[r0]
            float[] r7 = r1.f1654e
            r7 = r7[r0]
            float r6 = r6 - r7
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r5 = r1.f1651b
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L5b
            j1.f r9 = r8.D
            androidx.drawerlayout.widget.DrawerLayout r0 = r9.f6513d
            androidx.fragment.app.m r9 = r9.f6512c
            r0.removeCallbacks(r9)
            j1.f r9 = r8.E
            androidx.drawerlayout.widget.DrawerLayout r0 = r9.f6513d
            androidx.fragment.app.m r9 = r9.f6512c
            r0.removeCallbacks(r9)
            goto L63
        L5b:
            int r0 = r0 + 1
            goto L22
        L5e:
            r8.e(r3)
            r8.M = r4
        L63:
            r9 = r4
            goto L8b
        L65:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r8.P = r0
            r8.Q = r9
            float r5 = r8.f831z
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L88
            int r0 = (int) r0
            int r9 = (int) r9
            android.view.View r9 = r1.h(r0, r9)
            if (r9 == 0) goto L88
            boolean r9 = m(r9)
            if (r9 == 0) goto L88
            r9 = r3
            goto L89
        L88:
            r9 = r4
        L89:
            r8.M = r4
        L8b:
            if (r2 != 0) goto Lae
            if (r9 != 0) goto Lae
            int r9 = r8.getChildCount()
            r0 = r4
        L94:
            if (r0 >= r9) goto La8
            android.view.View r1 = r8.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            j1.d r1 = (j1.d) r1
            boolean r1 = r1.f6505c
            if (r1 == 0) goto La5
            goto Lae
        La5:
            int r0 = r0 + 1
            goto L94
        La8:
            boolean r9 = r8.M
            if (r9 == 0) goto Lad
            goto Lae
        Lad:
            return r4
        Lae:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || g() == null) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewG = g();
        if (viewG != null && i(viewG) == 0) {
            e(false);
        }
        return viewG != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        WindowInsets rootWindowInsets;
        float f;
        int i13;
        boolean z11 = true;
        this.G = true;
        int i14 = i11 - i;
        int childCount = getChildCount();
        int i15 = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (m(childAt)) {
                    int i16 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                    childAt.layout(i16, ((ViewGroup.MarginLayoutParams) dVar).topMargin, childAt.getMeasuredWidth() + i16, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) dVar).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b(childAt, 3)) {
                        float f10 = measuredWidth;
                        i13 = (-measuredWidth) + ((int) (dVar.f6504b * f10));
                        f = (measuredWidth + i13) / f10;
                    } else {
                        float f11 = measuredWidth;
                        f = (i14 - r11) / f11;
                        i13 = i14 - ((int) (dVar.f6504b * f11));
                    }
                    boolean z12 = f != dVar.f6504b ? z11 : false;
                    int i17 = dVar.f6503a & 112;
                    if (i17 == 16) {
                        int i18 = i12 - i10;
                        int i19 = (i18 - measuredHeight) / 2;
                        int i20 = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
                        if (i19 < i20) {
                            i19 = i20;
                        } else {
                            int i21 = i19 + measuredHeight;
                            int i22 = i18 - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
                            if (i21 > i22) {
                                i19 = i22 - measuredHeight;
                            }
                        }
                        childAt.layout(i13, i19, measuredWidth + i13, measuredHeight + i19);
                    } else if (i17 != 80) {
                        int i23 = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
                        childAt.layout(i13, i23, measuredWidth + i13, measuredHeight + i23);
                    } else {
                        int i24 = i12 - i10;
                        childAt.layout(i13, (i24 - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i13, i24 - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin);
                    }
                    if (z12) {
                        t(childAt, f);
                    }
                    int i25 = dVar.f6504b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i25) {
                        childAt.setVisibility(i25);
                    }
                }
            }
            i15++;
            z11 = true;
        }
        if (f825f0 && (rootWindowInsets = getRootWindowInsets()) != null) {
            l0.c cVarJ = p1.h(null, rootWindowInsets).f11791a.j();
            e eVar = this.B;
            eVar.f1662o = Math.max(eVar.f1663p, cVarJ.f7602a);
            e eVar2 = this.C;
            eVar2.f1662o = Math.max(eVar2.f1663p, cVarJ.f7604c);
        }
        this.G = false;
        this.H = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View viewF;
        if (!(parcelable instanceof j1.e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j1.e eVar = (j1.e) parcelable;
        super.onRestoreInstanceState(eVar.f112v);
        int i = eVar.f6507x;
        if (i != 0 && (viewF = f(i)) != null) {
            q(viewF);
        }
        int i10 = eVar.f6508y;
        if (i10 != 3) {
            s(i10, 3);
        }
        int i11 = eVar.f6509z;
        if (i11 != 3) {
            s(i11, 5);
        }
        int i12 = eVar.A;
        if (i12 != 3) {
            s(i12, 8388611);
        }
        int i13 = eVar.B;
        if (i13 != 3) {
            s(i13, 8388613);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        if (f824e0) {
            return;
        }
        WeakHashMap weakHashMap = m0.f11777a;
        getLayoutDirection();
        getLayoutDirection();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        j1.e eVar = new j1.e(super.onSaveInstanceState());
        eVar.f6507x = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            d dVar = (d) getChildAt(i).getLayoutParams();
            int i10 = dVar.f6506d;
            boolean z10 = i10 == 1;
            boolean z11 = i10 == 2;
            if (z10 || z11) {
                eVar.f6507x = dVar.f6503a;
                break;
            }
        }
        eVar.f6508y = this.I;
        eVar.f6509z = this.J;
        eVar.A = this.K;
        eVar.B = this.L;
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            b1.e r0 = r6.B
            r0.k(r7)
            b1.e r1 = r6.C
            r1.k(r7)
            int r1 = r7.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L70
            if (r1 == r3) goto L20
            r7 = 3
            if (r1 == r7) goto L1a
            return r3
        L1a:
            r6.e(r3)
            r6.M = r2
            return r3
        L20:
            float r1 = r7.getX()
            float r7 = r7.getY()
            int r4 = (int) r1
            int r5 = (int) r7
            android.view.View r4 = r0.h(r4, r5)
            if (r4 == 0) goto L6b
            boolean r4 = m(r4)
            if (r4 == 0) goto L6b
            float r4 = r6.P
            float r1 = r1 - r4
            float r4 = r6.Q
            float r7 = r7 - r4
            int r0 = r0.f1651b
            float r1 = r1 * r1
            float r7 = r7 * r7
            float r7 = r7 + r1
            int r0 = r0 * r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L6b
            int r7 = r6.getChildCount()
            r0 = r2
        L4c:
            if (r0 >= r7) goto L61
            android.view.View r1 = r6.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            j1.d r4 = (j1.d) r4
            int r4 = r4.f6506d
            r4 = r4 & r3
            if (r4 != r3) goto L5e
            goto L62
        L5e:
            int r0 = r0 + 1
            goto L4c
        L61:
            r1 = 0
        L62:
            if (r1 == 0) goto L6b
            int r7 = r6.i(r1)
            r0 = 2
            if (r7 != r0) goto L6c
        L6b:
            r2 = r3
        L6c:
            r6.e(r2)
            return r3
        L70:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.P = r0
            r6.Q = r7
            r6.M = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void q(View view) {
        if (!o(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        d dVar = (d) view.getLayoutParams();
        if (this.H) {
            dVar.f6504b = 1.0f;
            dVar.f6506d = 1;
            v(view, true);
            u(view);
        } else {
            dVar.f6506d |= 2;
            if (b(view, 3)) {
                this.B.s(view, 0, view.getTop());
            } else {
                this.C.s(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void r() {
        View viewF = f(8388611);
        if (viewF != null) {
            q(viewF);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + k(8388611));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            e(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.G) {
            return;
        }
        super.requestLayout();
    }

    public final void s(int i, int i10) {
        View viewF;
        WeakHashMap weakHashMap = m0.f11777a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i10, getLayoutDirection());
        if (i10 == 3) {
            this.I = i;
        } else if (i10 == 5) {
            this.J = i;
        } else if (i10 == 8388611) {
            this.K = i;
        } else if (i10 == 8388613) {
            this.L = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.B : this.C).a();
        }
        if (i != 1) {
            if (i == 2 && (viewF = f(absoluteGravity)) != null) {
                q(viewF);
                return;
            }
            return;
        }
        View viewF2 = f(absoluteGravity);
        if (viewF2 != null) {
            c(viewF2, true);
        }
    }

    public void setDrawerElevation(float f) {
        this.f828w = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (o(childAt)) {
                float f10 = this.f828w;
                WeakHashMap weakHashMap = m0.f11777a;
                d0.k(childAt, f10);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        ArrayList arrayList;
        c cVar2 = this.N;
        if (cVar2 != null && (arrayList = this.O) != null) {
            arrayList.remove(cVar2);
        }
        if (cVar != null) {
            a(cVar);
        }
        this.N = cVar;
    }

    public void setDrawerLockMode(int i) {
        s(i, 3);
        s(i, 5);
    }

    public void setScrimColor(int i) {
        this.f830y = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.R = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.R = new ColorDrawable(i);
        invalidate();
    }

    public final void t(View view, float f) {
        d dVar = (d) view.getLayoutParams();
        if (f == dVar.f6504b) {
            return;
        }
        dVar.f6504b = f;
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((c) this.O.get(size)).a(f);
            }
        }
    }

    public final void u(View view) {
        u0.c cVar = u0.c.f12051l;
        m0.k(view, cVar.a());
        m0.h(view, 0);
        if (!n(view) || i(view) == 2) {
            return;
        }
        m0.l(view, cVar, this.f826a0);
    }

    public final void v(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z10 || o(childAt)) && !(z10 && childAt == view)) {
                WeakHashMap weakHashMap = m0.f11777a;
                childAt.setImportantForAccessibility(4);
            } else {
                WeakHashMap weakHashMap2 = m0.f11777a;
                childAt.setImportantForAccessibility(1);
            }
        }
    }

    public final void w(View view, int i) {
        int i10;
        View rootView;
        int i11 = this.B.f1650a;
        int i12 = this.C.f1650a;
        if (i11 == 1 || i12 == 1) {
            i10 = 1;
        } else {
            i10 = 2;
            if (i11 != 2 && i12 != 2) {
                i10 = 0;
            }
        }
        if (view != null && i == 0) {
            float f = ((d) view.getLayoutParams()).f6504b;
            if (f == 0.0f) {
                d dVar = (d) view.getLayoutParams();
                if ((dVar.f6506d & 1) == 1) {
                    dVar.f6506d = 0;
                    ArrayList arrayList = this.O;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((c) this.O.get(size)).c(view);
                        }
                    }
                    v(view, false);
                    u(view);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f == 1.0f) {
                d dVar2 = (d) view.getLayoutParams();
                if ((dVar2.f6506d & 1) == 0) {
                    dVar2.f6506d = 1;
                    ArrayList arrayList2 = this.O;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ((c) this.O.get(size2)).b(view);
                        }
                    }
                    v(view, true);
                    u(view);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i10 != this.F) {
            this.F = i10;
            ArrayList arrayList3 = this.O;
            if (arrayList3 != null) {
                for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                    ((c) this.O.get(size3)).getClass();
                }
            }
        }
    }

    public void setStatusBarBackground(int i) {
        this.R = i != 0 ? getContext().getDrawable(i) : null;
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d dVar = new d(context, attributeSet);
        dVar.f6503a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f822c0);
        dVar.f6503a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return dVar;
    }
}
