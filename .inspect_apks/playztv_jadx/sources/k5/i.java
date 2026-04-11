package k5;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.fragment.app.n0;
import androidx.fragment.app.v;
import androidx.fragment.app.v0;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.material.datepicker.j;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import lc.m;
import lc.n;
import q0.f0;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i extends ViewGroup {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int[] f7032s0 = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final c0.i f7033t0 = new c0.i(2);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final b f7034u0 = new b(0);
    public int A;
    public Parcelable B;
    public final Scroller C;
    public boolean D;
    public g E;
    public int F;
    public Drawable G;
    public int H;
    public int I;
    public float J;
    public float K;
    public int L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public boolean Q;
    public boolean R;
    public final int S;
    public int T;
    public final int U;
    public float V;
    public float W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f7035a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f7036b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f7037c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public VelocityTracker f7038d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final int f7039e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final int f7040f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final int f7041g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final int f7042h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final EdgeEffect f7043i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final EdgeEffect f7044j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f7045k0;
    public boolean l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f7046m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public ArrayList f7047n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public f f7048o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public ArrayList f7049p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final androidx.fragment.app.e f7050q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f7051r0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f7052u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f7053v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d f7054w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f7055x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a f7056y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7057z;

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7053v = new ArrayList();
        this.f7054w = new d();
        this.f7055x = new Rect();
        this.A = -1;
        this.B = null;
        this.J = -3.4028235E38f;
        this.K = Float.MAX_VALUE;
        this.P = 1;
        this.f7037c0 = -1;
        this.f7045k0 = true;
        this.f7050q0 = new androidx.fragment.app.e(8, this);
        this.f7051r0 = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.C = new Scroller(context2, f7034u0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.U = viewConfiguration.getScaledPagingTouchSlop();
        this.f7039e0 = (int) (400.0f * f);
        this.f7040f0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7043i0 = new EdgeEffect(context2);
        this.f7044j0 = new EdgeEffect(context2);
        this.f7041g0 = (int) (25.0f * f);
        this.f7042h0 = (int) (2.0f * f);
        this.S = (int) (f * 16.0f);
        o0.n(this, new j(3, this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        k4 k4Var = new k4();
        k4Var.f3071v = this;
        k4Var.f3070u = new Rect();
        f0.l(this, k4Var);
    }

    public static boolean c(int i, int i10, int i11, View view, boolean z2) {
        int i12;
        if (!(view instanceof ViewGroup)) {
            return z2 ? false : false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            int i13 = i10 + scrollX;
            if (i13 >= childAt.getLeft() && i13 < childAt.getRight() && (i12 = i11 + scrollY) >= childAt.getTop() && i12 < childAt.getBottom() && c(i, i13 - childAt.getLeft(), i12 - childAt.getTop(), childAt, true)) {
                break;
            }
        }
        if (z2 || !view.canScrollHorizontally(-i)) {
        }
        return true;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.N != z2) {
            this.N = z2;
        }
    }

    public final d a(int i, int i10) {
        d dVar = new d();
        dVar.f7020b = i;
        m mVar = (m) this.f7056y;
        n0 n0Var = mVar.f8108b;
        if (mVar.f8110d == null) {
            n0Var.getClass();
            mVar.f8110d = new androidx.fragment.app.a(n0Var);
        }
        long j5 = i;
        v vVarB = n0Var.B("android:switcher:" + getId() + ":" + j5);
        if (vVarB != null) {
            androidx.fragment.app.a aVar = mVar.f8110d;
            aVar.getClass();
            aVar.b(new v0(7, vVarB));
        } else {
            n nVar = mVar.f8112g;
            vVarB = (v) nVar.H0.get(((Integer) nVar.I0.get(i)).intValue());
            mVar.f8110d.e(getId(), vVarB, "android:switcher:" + getId() + ":" + j5, 1);
        }
        if (vVarB != mVar.f8111e) {
            if (vVarB.X) {
                vVarB.X = false;
            }
            if (mVar.f8109c == 1) {
                mVar.f8110d.h(vVarB, androidx.lifecycle.n.f1485x);
            } else {
                vVarB.N(false);
            }
        }
        dVar.f7019a = vVarB;
        this.f7056y.getClass();
        dVar.f7022d = 1.0f;
        ArrayList arrayList = this.f7053v;
        if (i10 < 0 || i10 >= arrayList.size()) {
            arrayList.add(dVar);
            return dVar;
        }
        arrayList.add(i10, dVar);
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i10) {
        d dVarH;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 0 && (dVarH = h(childAt)) != null && dVarH.f7020b == this.f7057z) {
                    childAt.addFocusables(arrayList, i, i10);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i10 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList arrayList) {
        d dVarH;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (dVarH = h(childAt)) != null && dVarH.f7020b == this.f7057z) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        e eVar = (e) layoutParams;
        boolean z2 = eVar.f7024a | (view.getClass().getAnnotation(c.class) != null);
        eVar.f7024a = z2;
        if (!this.M) {
            super.addView(view, i, layoutParams);
        } else {
            if (z2) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            eVar.f7027d = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r8) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.i.b(int):boolean");
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        if (this.f7056y == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.J)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.K));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.D = true;
        Scroller scroller = this.C;
        if (scroller.isFinished() || !scroller.computeScrollOffset()) {
            d(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = scroller.getCurrX();
        int currY = scroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!n(currX)) {
                scroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = o0.f10475a;
        postInvalidateOnAnimation();
    }

    public final void d(boolean z2) {
        boolean z10 = this.f7051r0 == 2;
        if (z10) {
            setScrollingCacheEnabled(false);
            Scroller scroller = this.C;
            if (!scroller.isFinished()) {
                scroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = scroller.getCurrX();
                int currY = scroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        n(currX);
                    }
                }
            }
        }
        this.O = false;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f7053v;
            if (i >= arrayList.size()) {
                break;
            }
            d dVar = (d) arrayList.get(i);
            if (dVar.f7021c) {
                dVar.f7021c = false;
                z10 = true;
            }
            i++;
        }
        if (z10) {
            androidx.fragment.app.e eVar = this.f7050q0;
            if (!z2) {
                eVar.run();
            } else {
                WeakHashMap weakHashMap = o0.f10475a;
                postOnAnimation(eVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L66
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L61
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L48
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L61
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r6 = r5.b(r4)
            goto L62
        L2b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L61
            boolean r6 = r5.b(r1)
            goto L62
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L41
            boolean r6 = r5.m()
            goto L62
        L41:
            r6 = 66
            boolean r6 = r5.b(r6)
            goto L62
        L48:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L5a
            int r6 = r5.f7057z
            if (r6 <= 0) goto L61
            int r6 = r6 - r1
            r5.O = r2
            r5.u(r6, r2, r1, r2)
            r6 = r1
            goto L62
        L5a:
            r6 = 17
            boolean r6 = r5.b(r6)
            goto L62
        L61:
            r6 = r2
        L62:
            if (r6 == 0) goto L65
            goto L66
        L65:
            return r2
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.i.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        d dVarH;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (dVarH = h(childAt)) != null && dVarH.f7020b == this.f7057z && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        EdgeEffect edgeEffect = this.f7044j0;
        EdgeEffect edgeEffect2 = this.f7043i0;
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f7056y) != null && aVar.c() > 1)) {
            if (!edgeEffect2.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.J * width);
                edgeEffect2.setSize(height, width);
                zDraw = edgeEffect2.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!edgeEffect.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.K + 1.0f)) * width2);
                edgeEffect.setSize(height2, width2);
                zDraw |= edgeEffect.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            edgeEffect2.finish();
            edgeEffect.finish();
        }
        if (zDraw) {
            WeakHashMap weakHashMap = o0.f10475a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.G;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e() {
        int iC = this.f7056y.c();
        this.f7052u = iC;
        ArrayList arrayList = this.f7053v;
        boolean z2 = arrayList.size() < (this.P * 2) + 1 && arrayList.size() < iC;
        int i = this.f7057z;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            d dVar = (d) arrayList.get(i10);
            a aVar = this.f7056y;
            v vVar = dVar.f7019a;
            aVar.getClass();
        }
        Collections.sort(arrayList, f7033t0);
        if (z2) {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                e eVar = (e) getChildAt(i11).getLayoutParams();
                if (!eVar.f7024a) {
                    eVar.f7026c = 0.0f;
                }
            }
            u(i, 0, false, true);
            requestLayout();
        }
    }

    public final void f(int i) {
        f fVar = this.f7048o0;
        if (fVar != null) {
            ((u9.h) fVar).b(i);
        }
        ArrayList arrayList = this.f7047n0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar2 = (f) this.f7047n0.get(i10);
                if (fVar2 != null) {
                    ((u9.h) fVar2).b(i);
                }
            }
        }
    }

    public final Rect g(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        e eVar = new e(-1, -1);
        eVar.f7026c = 0.0f;
        return eVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.f7056y;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i10) {
        throw null;
    }

    public int getCurrentItem() {
        return this.f7057z;
    }

    public int getOffscreenPageLimit() {
        return this.P;
    }

    public int getPageMargin() {
        return this.F;
    }

    public final d h(View view) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f7053v;
            if (i >= arrayList.size()) {
                return null;
            }
            d dVar = (d) arrayList.get(i);
            a aVar = this.f7056y;
            v vVar = dVar.f7019a;
            ((m) aVar).getClass();
            if (vVar.f1378a0 == view) {
                return dVar;
            }
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k5.d i() {
        /*
            r13 = this;
            int r0 = r13.getClientWidth()
            r1 = 0
            if (r0 <= 0) goto Lf
            int r2 = r13.getScrollX()
            float r2 = (float) r2
            float r3 = (float) r0
            float r2 = r2 / r3
            goto L10
        Lf:
            r2 = r1
        L10:
            if (r0 <= 0) goto L18
            int r3 = r13.F
            float r3 = (float) r3
            float r0 = (float) r0
            float r3 = r3 / r0
            goto L19
        L18:
            r3 = r1
        L19:
            r0 = 0
            r4 = -1
            r5 = 1
            r6 = 0
            r8 = r0
            r9 = r5
            r7 = r6
            r6 = r4
            r4 = r1
        L22:
            java.util.ArrayList r10 = r13.f7053v
            int r11 = r10.size()
            if (r8 >= r11) goto L72
            java.lang.Object r11 = r10.get(r8)
            k5.d r11 = (k5.d) r11
            if (r9 != 0) goto L4c
            int r12 = r11.f7020b
            int r6 = r6 + r5
            if (r12 == r6) goto L4c
            float r1 = r1 + r4
            float r1 = r1 + r3
            k5.d r4 = r13.f7054w
            r4.f7023e = r1
            r4.f7020b = r6
            k5.a r1 = r13.f7056y
            r1.getClass()
            r1 = 1065353216(0x3f800000, float:1.0)
            r4.f7022d = r1
            int r8 = r8 + (-1)
            r6 = r4
            goto L4d
        L4c:
            r6 = r11
        L4d:
            float r1 = r6.f7023e
            float r4 = r6.f7022d
            float r4 = r4 + r1
            float r4 = r4 + r3
            if (r9 != 0) goto L59
            int r9 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r9 < 0) goto L72
        L59:
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L71
            int r4 = r10.size()
            int r4 = r4 - r5
            if (r8 != r4) goto L65
            goto L71
        L65:
            int r4 = r6.f7020b
            float r7 = r6.f7022d
            int r8 = r8 + 1
            r9 = r6
            r6 = r4
            r4 = r7
            r7 = r9
            r9 = r0
            goto L22
        L71:
            return r6
        L72:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.i.i():k5.d");
    }

    public final d j(int i) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f7053v;
            if (i10 >= arrayList.size()) {
                return null;
            }
            d dVar = (d) arrayList.get(i10);
            if (dVar.f7020b == i) {
                return dVar;
            }
            i10++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(float r12, int r13, int r14) {
        /*
            r11 = this;
            int r14 = r11.f7046m0
            r0 = 0
            r1 = 1
            if (r14 <= 0) goto L6c
            int r14 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = r0
        L1b:
            if (r6 >= r5) goto L6c
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            k5.e r8 = (k5.e) r8
            boolean r9 = r8.f7024a
            if (r9 != 0) goto L2c
            goto L69
        L2c:
            int r8 = r8.f7025b
            r8 = r8 & 7
            if (r8 == r1) goto L50
            r9 = 3
            if (r8 == r9) goto L4a
            r9 = 5
            if (r8 == r9) goto L3a
            r8 = r2
            goto L5d
        L3a:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L46:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5d
        L4a:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5d
        L50:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L46
        L5d:
            int r2 = r2 + r14
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L68
            r7.offsetLeftAndRight(r2)
        L68:
            r2 = r8
        L69:
            int r6 = r6 + 1
            goto L1b
        L6c:
            k5.f r14 = r11.f7048o0
            if (r14 == 0) goto L75
            u9.h r14 = (u9.h) r14
            r14.a(r13, r12)
        L75:
            java.util.ArrayList r14 = r11.f7047n0
            if (r14 == 0) goto L91
            int r14 = r14.size()
        L7d:
            if (r0 >= r14) goto L91
            java.util.ArrayList r2 = r11.f7047n0
            java.lang.Object r2 = r2.get(r0)
            k5.f r2 = (k5.f) r2
            if (r2 == 0) goto L8e
            u9.h r2 = (u9.h) r2
            r2.a(r13, r12)
        L8e:
            int r0 = r0 + 1
            goto L7d
        L91:
            r11.l0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.i.k(float, int, int):void");
    }

    public final void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f7037c0) {
            int i = actionIndex == 0 ? 1 : 0;
            this.V = motionEvent.getX(i);
            this.f7037c0 = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f7038d0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean m() {
        a aVar = this.f7056y;
        if (aVar == null || this.f7057z >= aVar.c() - 1) {
            return false;
        }
        int i = this.f7057z + 1;
        this.O = false;
        u(i, 0, true, false);
        return true;
    }

    public final boolean n(int i) {
        if (this.f7053v.size() == 0) {
            if (!this.f7045k0) {
                this.l0 = false;
                k(0.0f, 0, 0);
                if (!this.l0) {
                    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
                }
            }
            return false;
        }
        d dVarI = i();
        int clientWidth = getClientWidth();
        int i10 = this.F;
        int i11 = clientWidth + i10;
        float f = clientWidth;
        int i12 = dVarI.f7020b;
        float f4 = ((i / f) - dVarI.f7023e) / (dVarI.f7022d + (i10 / f));
        this.l0 = false;
        k(f4, i12, (int) (i11 * f4));
        if (this.l0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean o(float f) {
        boolean z2;
        boolean z10;
        float f4 = this.V - f;
        this.V = f;
        float scrollX = getScrollX() + f4;
        float clientWidth = getClientWidth();
        float f10 = this.J * clientWidth;
        float f11 = this.K * clientWidth;
        ArrayList arrayList = this.f7053v;
        boolean z11 = false;
        d dVar = (d) arrayList.get(0);
        d dVar2 = (d) arrayList.get(arrayList.size() - 1);
        if (dVar.f7020b != 0) {
            f10 = dVar.f7023e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (dVar2.f7020b != this.f7056y.c() - 1) {
            f11 = dVar2.f7023e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (scrollX < f10) {
            if (z2) {
                this.f7043i0.onPull(Math.abs(f10 - scrollX) / clientWidth);
                z11 = true;
            }
            scrollX = f10;
        } else if (scrollX > f11) {
            if (z10) {
                this.f7044j0.onPull(Math.abs(scrollX - f11) / clientWidth);
                z11 = true;
            }
            scrollX = f11;
        }
        int i = (int) scrollX;
        this.V = (scrollX - i) + this.V;
        scrollTo(i, getScrollY());
        n(i);
        return z11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7045k0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f7050q0);
        Scroller scroller = this.C;
        if (scroller != null && !scroller.isFinished()) {
            this.C.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i;
        float f;
        ArrayList arrayList;
        int i10;
        super.onDraw(canvas);
        if (this.F <= 0 || this.G == null) {
            return;
        }
        ArrayList arrayList2 = this.f7053v;
        if (arrayList2.size() <= 0 || this.f7056y == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.F / width;
        int i11 = 0;
        d dVar = (d) arrayList2.get(0);
        float f10 = dVar.f7023e;
        int size = arrayList2.size();
        int i12 = dVar.f7020b;
        int i13 = ((d) arrayList2.get(size - 1)).f7020b;
        while (i12 < i13) {
            while (true) {
                i = dVar.f7020b;
                if (i12 <= i || i11 >= size) {
                    break;
                }
                i11++;
                dVar = (d) arrayList2.get(i11);
            }
            if (i12 == i) {
                float f11 = dVar.f7023e;
                float f12 = dVar.f7022d;
                f = (f11 + f12) * width;
                f10 = f11 + f12 + f4;
            } else {
                this.f7056y.getClass();
                f = (f10 + 1.0f) * width;
                f10 = 1.0f + f4 + f10;
            }
            if (this.F + f > scrollX) {
                arrayList = arrayList2;
                i10 = scrollX;
                this.G.setBounds(Math.round(f), this.H, Math.round(this.F + f), this.I);
                this.G.draw(canvas);
            } else {
                arrayList = arrayList2;
                i10 = scrollX;
            }
            if (f > i10 + r3) {
                return;
            }
            i12++;
            arrayList2 = arrayList;
            scrollX = i10;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            s();
            return false;
        }
        if (action != 0) {
            if (this.Q) {
                return true;
            }
            if (this.R) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.f7035a0 = x10;
            this.V = x10;
            float y10 = motionEvent.getY();
            this.f7036b0 = y10;
            this.W = y10;
            this.f7037c0 = motionEvent.getPointerId(0);
            this.R = false;
            this.D = true;
            Scroller scroller = this.C;
            scroller.computeScrollOffset();
            if (this.f7051r0 != 2 || Math.abs(scroller.getFinalX() - scroller.getCurrX()) <= this.f7042h0) {
                d(false);
                this.Q = false;
            } else {
                scroller.abortAnimation();
                this.O = false;
                p();
                this.Q = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.f7037c0;
            if (i != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x11 = motionEvent.getX(iFindPointerIndex);
                float f = x11 - this.V;
                float fAbs = Math.abs(f);
                float y11 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y11 - this.f7036b0);
                if (f != 0.0f) {
                    float f4 = this.V;
                    if ((f4 >= this.T || f <= 0.0f) && ((f4 <= getWidth() - this.T || f >= 0.0f) && c((int) f, (int) x11, (int) y11, this, false))) {
                        this.V = x11;
                        this.W = y11;
                        this.R = true;
                        return false;
                    }
                }
                int i10 = this.U;
                float f10 = i10;
                if (fAbs > f10 && fAbs * 0.5f > fAbs2) {
                    this.Q = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f11 = this.f7035a0;
                    float f12 = i10;
                    this.V = f > 0.0f ? f11 + f12 : f11 - f12;
                    this.W = y11;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > f10) {
                    this.R = true;
                }
                if (this.Q && o(x11)) {
                    WeakHashMap weakHashMap = o0.f10475a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            l(motionEvent);
        }
        if (this.f7038d0 == null) {
            this.f7038d0 = VelocityTracker.obtain();
        }
        this.f7038d0.addMovement(motionEvent);
        return this.Q;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.i.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i10) {
        e eVar;
        e eVar2;
        int i11;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i10));
        int measuredWidth = getMeasuredWidth();
        this.T = Math.min(measuredWidth / 10, this.S);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            boolean z2 = true;
            int i13 = 1073741824;
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8 && (eVar2 = (e) childAt.getLayoutParams()) != null && eVar2.f7024a) {
                int i14 = eVar2.f7025b;
                int i15 = i14 & 7;
                int i16 = i14 & 112;
                boolean z10 = i16 == 48 || i16 == 80;
                if (i15 != 3 && i15 != 5) {
                    z2 = false;
                }
                int i17 = Integer.MIN_VALUE;
                if (z10) {
                    i11 = Integer.MIN_VALUE;
                    i17 = 1073741824;
                } else {
                    i11 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i18 = ((ViewGroup.LayoutParams) eVar2).width;
                if (i18 != -2) {
                    if (i18 == -1) {
                        i18 = paddingLeft;
                    }
                    i17 = 1073741824;
                } else {
                    i18 = paddingLeft;
                }
                int i19 = ((ViewGroup.LayoutParams) eVar2).height;
                if (i19 == -2) {
                    i19 = measuredHeight;
                    i13 = i11;
                } else if (i19 == -1) {
                    i19 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i18, i17), View.MeasureSpec.makeMeasureSpec(i19, i13));
                if (z10) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i12++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.L = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.M = true;
        p();
        this.M = false;
        int childCount2 = getChildCount();
        for (int i20 = 0; i20 < childCount2; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8 && ((eVar = (e) childAt2.getLayoutParams()) == null || !eVar.f7024a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * eVar.f7026c), 1073741824), this.L);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i10;
        int i11;
        int i12;
        d dVarH;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i11 = childCount;
            i10 = 0;
            i12 = 1;
        } else {
            i10 = childCount - 1;
            i11 = -1;
            i12 = -1;
        }
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (dVarH = h(childAt)) != null && dVarH.f7020b == this.f7057z && childAt.requestFocus(i, rect)) {
                return true;
            }
            i10 += i12;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f14205u);
        if (this.f7056y != null) {
            u(hVar.f7030w, 0, false, true);
        } else {
            this.A = hVar.f7030w;
            this.B = hVar.f7031x;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        hVar.f7030w = this.f7057z;
        a aVar = this.f7056y;
        if (aVar != null) {
            aVar.getClass();
            hVar.f7031x = null;
        }
        return hVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        if (i != i11) {
            int i13 = this.F;
            r(i, i11, i13, i13);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00da  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.i.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        q(this.f7057z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c8 A[PHI: r7 r11 r16 r17
      0x00c8: PHI (r7v18 int) = (r7v17 int), (r7v4 int), (r7v20 int) binds: [B:61:0x00ed, B:58:0x00d8, B:50:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x00c8: PHI (r11v34 int) = (r11v1 int), (r11v33 int), (r11v36 int) binds: [B:61:0x00ed, B:58:0x00d8, B:50:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x00c8: PHI (r16v4 float) = (r16v2 float), (r16v3 float), (r16v1 float) binds: [B:61:0x00ed, B:58:0x00d8, B:50:0x00bf] A[DONT_GENERATE, DONT_INLINE]
      0x00c8: PHI (r17v3 float) = (r17v2 float), (r17v2 float), (r17v5 float) binds: [B:61:0x00ed, B:58:0x00d8, B:50:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014c A[PHI: r3 r13
      0x014c: PHI (r3v22 float) = (r3v20 float), (r3v21 float), (r3v19 float) binds: [B:95:0x0173, B:92:0x015d, B:85:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x014c: PHI (r13v23 int) = (r13v21 int), (r13v22 int), (r13v20 int) binds: [B:95:0x0173, B:92:0x015d, B:85:0x0143] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(int r19) {
        /*
            Method dump skipped, instruction units count: 962
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.i.q(int):void");
    }

    public final void r(int i, int i10, int i11, int i12) {
        if (i10 > 0 && !this.f7053v.isEmpty()) {
            if (!this.C.isFinished()) {
                this.C.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)) * (((i - getPaddingLeft()) - getPaddingRight()) + i11)), getScrollY());
                return;
            }
        }
        d dVarJ = j(this.f7057z);
        int iMin = (int) ((dVarJ != null ? Math.min(dVarJ.f7023e, this.K) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            d(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.M) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final boolean s() {
        this.f7037c0 = -1;
        this.Q = false;
        this.R = false;
        VelocityTracker velocityTracker = this.f7038d0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f7038d0 = null;
        }
        this.f7043i0.onRelease();
        this.f7044j0.onRelease();
        return this.f7043i0.isFinished() || this.f7044j0.isFinished();
    }

    public void setAdapter(a aVar) {
        ArrayList arrayList = this.f7053v;
        a aVar2 = this.f7056y;
        if (aVar2 != null) {
            synchronized (aVar2) {
            }
            this.f7056y.e(this);
            for (int i = 0; i < arrayList.size(); i++) {
                d dVar = (d) arrayList.get(i);
                a aVar3 = this.f7056y;
                int i10 = dVar.f7020b;
                aVar3.a(dVar.f7019a);
            }
            this.f7056y.b();
            arrayList.clear();
            int i11 = 0;
            while (i11 < getChildCount()) {
                if (!((e) getChildAt(i11).getLayoutParams()).f7024a) {
                    removeViewAt(i11);
                    i11--;
                }
                i11++;
            }
            this.f7057z = 0;
            scrollTo(0, 0);
        }
        this.f7056y = aVar;
        this.f7052u = 0;
        if (aVar != null) {
            if (this.E == null) {
                this.E = new g(0, this);
            }
            this.f7056y.d();
            this.O = false;
            boolean z2 = this.f7045k0;
            this.f7045k0 = true;
            this.f7052u = this.f7056y.c();
            if (this.A >= 0) {
                this.f7056y.getClass();
                u(this.A, 0, false, true);
                this.A = -1;
                this.B = null;
            } else if (z2) {
                requestLayout();
            } else {
                p();
            }
        }
        ArrayList arrayList2 = this.f7049p0;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        int size = this.f7049p0.size();
        for (int i12 = 0; i12 < size; i12++) {
            u9.b bVar = (u9.b) this.f7049p0.get(i12);
            TabLayout tabLayout = bVar.f12796b;
            if (tabLayout.f3487k0 == this) {
                tabLayout.k(aVar, bVar.f12795a);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.O = false;
        u(i, 0, !this.f7045k0, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.P) {
            this.P = i;
            p();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.f7048o0 = fVar;
    }

    public void setPageMargin(int i) {
        int i10 = this.F;
        this.F = i;
        int width = getWidth();
        r(width, width, i, i10);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.G = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.f7051r0 == i) {
            return;
        }
        this.f7051r0 = i;
        f fVar = this.f7048o0;
        if (fVar != null) {
            u9.h hVar = (u9.h) fVar;
            hVar.f12809b = hVar.f12810c;
            hVar.f12810c = i;
            TabLayout tabLayout = (TabLayout) hVar.f12808a.get();
            if (tabLayout != null) {
                tabLayout.f3492q0 = hVar.f12810c;
            }
        }
        ArrayList arrayList = this.f7047n0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar2 = (f) this.f7047n0.get(i10);
                if (fVar2 != null) {
                    u9.h hVar2 = (u9.h) fVar2;
                    hVar2.f12809b = hVar2.f12810c;
                    hVar2.f12810c = i;
                    TabLayout tabLayout2 = (TabLayout) hVar2.f12808a.get();
                    if (tabLayout2 != null) {
                        tabLayout2.f3492q0 = hVar2.f12810c;
                    }
                }
            }
        }
    }

    public final void t(int i, int i10, boolean z2, boolean z10) {
        int scrollX;
        int iAbs;
        d dVarJ = j(i);
        int iMax = dVarJ != null ? (int) (Math.max(this.J, Math.min(dVarJ.f7023e, this.K)) * getClientWidth()) : 0;
        if (!z2) {
            if (z10) {
                f(i);
            }
            d(false);
            scrollTo(iMax, 0);
            n(iMax);
            return;
        }
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
        } else {
            Scroller scroller = this.C;
            if (scroller == null || scroller.isFinished()) {
                scrollX = getScrollX();
            } else {
                scrollX = this.D ? scroller.getCurrX() : scroller.getStartX();
                scroller.abortAnimation();
                setScrollingCacheEnabled(false);
            }
            int i11 = scrollX;
            int scrollY = getScrollY();
            int i12 = iMax - i11;
            int i13 = 0 - scrollY;
            if (i12 == 0 && i13 == 0) {
                d(false);
                p();
                setScrollState(0);
            } else {
                setScrollingCacheEnabled(true);
                setScrollState(2);
                int clientWidth = getClientWidth();
                int i14 = clientWidth / 2;
                float f = clientWidth;
                float f4 = i14;
                float fSin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i12) * 1.0f) / f) - 0.5f) * 0.47123894f)) * f4) + f4;
                int iAbs2 = Math.abs(i10);
                if (iAbs2 > 0) {
                    iAbs = Math.round(Math.abs(fSin / iAbs2) * 1000.0f) * 4;
                } else {
                    this.f7056y.getClass();
                    iAbs = (int) (((Math.abs(i12) / ((f * 1.0f) + this.F)) + 1.0f) * 100.0f);
                }
                int iMin = Math.min(iAbs, 600);
                this.D = false;
                this.C.startScroll(i11, scrollY, i12, i13, iMin);
                WeakHashMap weakHashMap = o0.f10475a;
                postInvalidateOnAnimation();
            }
        }
        if (z10) {
            f(i);
        }
    }

    public final void u(int i, int i10, boolean z2, boolean z10) {
        a aVar = this.f7056y;
        if (aVar == null || aVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        ArrayList arrayList = this.f7053v;
        if (!z10 && this.f7057z == i && arrayList.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.f7056y.c()) {
            i = this.f7056y.c() - 1;
        }
        int i11 = this.P;
        int i12 = this.f7057z;
        if (i > i12 + i11 || i < i12 - i11) {
            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                ((d) arrayList.get(i13)).f7021c = true;
            }
        }
        boolean z11 = this.f7057z != i;
        if (!this.f7045k0) {
            q(i);
            t(i, i10, z2, z11);
        } else {
            this.f7057z = i;
            if (z11) {
                f(i);
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.G;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        e eVar = new e(context, attributeSet);
        eVar.f7026c = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7032s0);
        eVar.f7025b = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
        return eVar;
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getDrawable(i));
    }
}
