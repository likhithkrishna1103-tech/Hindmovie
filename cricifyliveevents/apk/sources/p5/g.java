package p5;

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
import androidx.fragment.app.a1;
import androidx.fragment.app.m;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;
import androidx.lifecycle.n;
import com.google.android.material.datepicker.j;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import nb.w;
import o.d2;
import oa.i;
import t0.d0;
import t0.m0;
import v5.r;
import v5.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends ViewGroup {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int[] f10002t0 = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final a5.f f10003u0 = new a5.f(7);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final b1.d f10004v0 = new b1.d(1);
    public int A;
    public int B;
    public Parcelable C;
    public final Scroller D;
    public boolean E;
    public d2 F;
    public int G;
    public Drawable H;
    public int I;
    public int J;
    public float K;
    public float L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public boolean R;
    public boolean S;
    public final int T;
    public int U;
    public final int V;
    public float W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f10005a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f10006b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f10007c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f10008d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public VelocityTracker f10009e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final int f10010f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final int f10011g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final int f10012h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final int f10013i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final EdgeEffect f10014j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final EdgeEffect f10015k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f10016l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f10017m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f10018n0;
    public ArrayList o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public e f10019p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ArrayList f10020q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final m f10021r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f10022s0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10023v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f10024w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f10025x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f10026y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a f10027z;

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10024w = new ArrayList();
        this.f10025x = new c();
        this.f10026y = new Rect();
        this.B = -1;
        this.C = null;
        this.K = -3.4028235E38f;
        this.L = Float.MAX_VALUE;
        this.Q = 1;
        this.f10008d0 = -1;
        this.f10016l0 = true;
        this.f10021r0 = new m(24, this);
        this.f10022s0 = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.D = new Scroller(context2, f10004v0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.V = viewConfiguration.getScaledPagingTouchSlop();
        this.f10010f0 = (int) (400.0f * f);
        this.f10011g0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f10014j0 = new EdgeEffect(context2);
        this.f10015k0 = new EdgeEffect(context2);
        this.f10012h0 = (int) (25.0f * f);
        this.f10013i0 = (int) (2.0f * f);
        this.T = (int) (f * 16.0f);
        m0.n(this, new j(3, this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        d0.l(this, new w(this));
    }

    public static boolean c(int i, int i10, int i11, View view, boolean z10) {
        int i12;
        if (!(view instanceof ViewGroup)) {
            return z10 ? false : false;
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
        if (z10 || !view.canScrollHorizontally(-i)) {
        }
        return true;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.O != z10) {
            this.O = z10;
        }
    }

    public final c a(int i, int i10) {
        c cVar = new c();
        cVar.f9992b = i;
        r rVar = (r) this.f10027z;
        r0 r0Var = rVar.f13446b;
        if (rVar.f13448d == null) {
            r0Var.getClass();
            rVar.f13448d = new androidx.fragment.app.a(r0Var);
        }
        long j4 = i;
        y yVarE = r0Var.E("android:switcher:" + getId() + ":" + j4);
        if (yVarE != null) {
            androidx.fragment.app.a aVar = rVar.f13448d;
            aVar.getClass();
            aVar.b(new a1(7, yVarE));
        } else {
            s sVar = rVar.f13450g;
            yVarE = (y) sVar.I0.get(((Integer) sVar.J0.get(i)).intValue());
            rVar.f13448d.f(getId(), yVarE, "android:switcher:" + getId() + ":" + j4, 1);
        }
        if (yVarE != rVar.f13449e) {
            if (yVarE.Y) {
                yVarE.Y = false;
            }
            if (rVar.f13447c == 1) {
                rVar.f13448d.i(yVarE, n.f1182y);
            } else {
                yVarE.P(false);
            }
        }
        cVar.f9991a = yVarE;
        this.f10027z.getClass();
        cVar.f9994d = 1.0f;
        ArrayList arrayList = this.f10024w;
        if (i10 < 0 || i10 >= arrayList.size()) {
            arrayList.add(cVar);
            return cVar;
        }
        arrayList.add(i10, cVar);
        return cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i10) {
        c cVarH;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 0 && (cVarH = h(childAt)) != null && cVarH.f9992b == this.A) {
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
        c cVarH;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (cVarH = h(childAt)) != null && cVarH.f9992b == this.A) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        d dVar = (d) layoutParams;
        boolean z10 = dVar.f9996a | (view.getClass().getAnnotation(b.class) != null);
        dVar.f9996a = z10;
        if (!this.N) {
            super.addView(view, i, layoutParams);
        } else {
            if (z10) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            dVar.f9999d = true;
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
        throw new UnsupportedOperationException("Method not decompiled: p5.g.b(int):boolean");
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        if (this.f10027z == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.K)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.L));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.E = true;
        Scroller scroller = this.D;
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
        WeakHashMap weakHashMap = m0.f11777a;
        postInvalidateOnAnimation();
    }

    public final void d(boolean z10) {
        boolean z11 = this.f10022s0 == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            Scroller scroller = this.D;
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
        this.P = false;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f10024w;
            if (i >= arrayList.size()) {
                break;
            }
            c cVar = (c) arrayList.get(i);
            if (cVar.f9993c) {
                cVar.f9993c = false;
                z11 = true;
            }
            i++;
        }
        if (z11) {
            m mVar = this.f10021r0;
            if (!z10) {
                mVar.run();
            } else {
                WeakHashMap weakHashMap = m0.f11777a;
                postOnAnimation(mVar);
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
            int r6 = r5.A
            if (r6 <= 0) goto L61
            int r6 = r6 - r1
            r5.P = r2
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
        throw new UnsupportedOperationException("Method not decompiled: p5.g.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        c cVarH;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (cVarH = h(childAt)) != null && cVarH.f9992b == this.A && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
        EdgeEffect edgeEffect = this.f10015k0;
        EdgeEffect edgeEffect2 = this.f10014j0;
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f10027z) != null && aVar.c() > 1)) {
            if (!edgeEffect2.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.K * width);
                edgeEffect2.setSize(height, width);
                zDraw = edgeEffect2.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!edgeEffect.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.L + 1.0f)) * width2);
                edgeEffect.setSize(height2, width2);
                zDraw |= edgeEffect.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            edgeEffect2.finish();
            edgeEffect.finish();
        }
        if (zDraw) {
            WeakHashMap weakHashMap = m0.f11777a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.H;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e() {
        int iC = this.f10027z.c();
        this.f10023v = iC;
        ArrayList arrayList = this.f10024w;
        boolean z10 = arrayList.size() < (this.Q * 2) + 1 && arrayList.size() < iC;
        int i = this.A;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            c cVar = (c) arrayList.get(i10);
            a aVar = this.f10027z;
            y yVar = cVar.f9991a;
            aVar.getClass();
        }
        Collections.sort(arrayList, f10003u0);
        if (z10) {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                d dVar = (d) getChildAt(i11).getLayoutParams();
                if (!dVar.f9996a) {
                    dVar.f9998c = 0.0f;
                }
            }
            u(i, 0, false, true);
            requestLayout();
        }
    }

    public final void f(int i) {
        e eVar = this.f10019p0;
        if (eVar != null) {
            ((i) eVar).b(i);
        }
        ArrayList arrayList = this.o0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar2 = (e) this.o0.get(i10);
                if (eVar2 != null) {
                    ((i) eVar2).b(i);
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
        d dVar = new d(-1, -1);
        dVar.f9998c = 0.0f;
        return dVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.f10027z;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i10) {
        throw null;
    }

    public int getCurrentItem() {
        return this.A;
    }

    public int getOffscreenPageLimit() {
        return this.Q;
    }

    public int getPageMargin() {
        return this.G;
    }

    public final c h(View view) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f10024w;
            if (i >= arrayList.size()) {
                return null;
            }
            c cVar = (c) arrayList.get(i);
            a aVar = this.f10027z;
            y yVar = cVar.f9991a;
            ((r) aVar).getClass();
            if (yVar.f1103b0 == view) {
                return cVar;
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
    public final p5.c i() {
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
            int r3 = r13.G
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
            java.util.ArrayList r10 = r13.f10024w
            int r11 = r10.size()
            if (r8 >= r11) goto L72
            java.lang.Object r11 = r10.get(r8)
            p5.c r11 = (p5.c) r11
            if (r9 != 0) goto L4c
            int r12 = r11.f9992b
            int r6 = r6 + r5
            if (r12 == r6) goto L4c
            float r1 = r1 + r4
            float r1 = r1 + r3
            p5.c r4 = r13.f10025x
            r4.f9995e = r1
            r4.f9992b = r6
            p5.a r1 = r13.f10027z
            r1.getClass()
            r1 = 1065353216(0x3f800000, float:1.0)
            r4.f9994d = r1
            int r8 = r8 + (-1)
            r6 = r4
            goto L4d
        L4c:
            r6 = r11
        L4d:
            float r1 = r6.f9995e
            float r4 = r6.f9994d
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
            int r4 = r6.f9992b
            float r7 = r6.f9994d
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
        throw new UnsupportedOperationException("Method not decompiled: p5.g.i():p5.c");
    }

    public final c j(int i) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f10024w;
            if (i10 >= arrayList.size()) {
                return null;
            }
            c cVar = (c) arrayList.get(i10);
            if (cVar.f9992b == i) {
                return cVar;
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
            int r14 = r11.f10018n0
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
            p5.d r8 = (p5.d) r8
            boolean r9 = r8.f9996a
            if (r9 != 0) goto L2c
            goto L69
        L2c:
            int r8 = r8.f9997b
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
            p5.e r14 = r11.f10019p0
            if (r14 == 0) goto L75
            oa.i r14 = (oa.i) r14
            r14.a(r13, r12)
        L75:
            java.util.ArrayList r14 = r11.o0
            if (r14 == 0) goto L91
            int r14 = r14.size()
        L7d:
            if (r0 >= r14) goto L91
            java.util.ArrayList r2 = r11.o0
            java.lang.Object r2 = r2.get(r0)
            p5.e r2 = (p5.e) r2
            if (r2 == 0) goto L8e
            oa.i r2 = (oa.i) r2
            r2.a(r13, r12)
        L8e:
            int r0 = r0 + 1
            goto L7d
        L91:
            r11.f10017m0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.g.k(float, int, int):void");
    }

    public final void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f10008d0) {
            int i = actionIndex == 0 ? 1 : 0;
            this.W = motionEvent.getX(i);
            this.f10008d0 = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f10009e0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean m() {
        a aVar = this.f10027z;
        if (aVar == null || this.A >= aVar.c() - 1) {
            return false;
        }
        int i = this.A + 1;
        this.P = false;
        u(i, 0, true, false);
        return true;
    }

    public final boolean n(int i) {
        if (this.f10024w.size() == 0) {
            if (!this.f10016l0) {
                this.f10017m0 = false;
                k(0.0f, 0, 0);
                if (!this.f10017m0) {
                    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
                }
            }
            return false;
        }
        c cVarI = i();
        int clientWidth = getClientWidth();
        int i10 = this.G;
        int i11 = clientWidth + i10;
        float f = clientWidth;
        int i12 = cVarI.f9992b;
        float f10 = ((i / f) - cVarI.f9995e) / (cVarI.f9994d + (i10 / f));
        this.f10017m0 = false;
        k(f10, i12, (int) (i11 * f10));
        if (this.f10017m0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean o(float f) {
        boolean z10;
        boolean z11;
        float f10 = this.W - f;
        this.W = f;
        float scrollX = getScrollX() + f10;
        float clientWidth = getClientWidth();
        float f11 = this.K * clientWidth;
        float f12 = this.L * clientWidth;
        ArrayList arrayList = this.f10024w;
        boolean z12 = false;
        c cVar = (c) arrayList.get(0);
        c cVar2 = (c) arrayList.get(arrayList.size() - 1);
        if (cVar.f9992b != 0) {
            f11 = cVar.f9995e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (cVar2.f9992b != this.f10027z.c() - 1) {
            f12 = cVar2.f9995e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f11) {
            if (z10) {
                this.f10014j0.onPull(Math.abs(f11 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f11;
        } else if (scrollX > f12) {
            if (z11) {
                this.f10015k0.onPull(Math.abs(scrollX - f12) / clientWidth);
                z12 = true;
            }
            scrollX = f12;
        }
        int i = (int) scrollX;
        this.W = (scrollX - i) + this.W;
        scrollTo(i, getScrollY());
        n(i);
        return z12;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10016l0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f10021r0);
        Scroller scroller = this.D;
        if (scroller != null && !scroller.isFinished()) {
            this.D.abortAnimation();
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
        if (this.G <= 0 || this.H == null) {
            return;
        }
        ArrayList arrayList2 = this.f10024w;
        if (arrayList2.size() <= 0 || this.f10027z == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f10 = this.G / width;
        int i11 = 0;
        c cVar = (c) arrayList2.get(0);
        float f11 = cVar.f9995e;
        int size = arrayList2.size();
        int i12 = cVar.f9992b;
        int i13 = ((c) arrayList2.get(size - 1)).f9992b;
        while (i12 < i13) {
            while (true) {
                i = cVar.f9992b;
                if (i12 <= i || i11 >= size) {
                    break;
                }
                i11++;
                cVar = (c) arrayList2.get(i11);
            }
            if (i12 == i) {
                float f12 = cVar.f9995e;
                float f13 = cVar.f9994d;
                f = (f12 + f13) * width;
                f11 = f12 + f13 + f10;
            } else {
                this.f10027z.getClass();
                f = (f11 + 1.0f) * width;
                f11 = 1.0f + f10 + f11;
            }
            if (this.G + f > scrollX) {
                arrayList = arrayList2;
                i10 = scrollX;
                this.H.setBounds(Math.round(f), this.I, Math.round(this.G + f), this.J);
                this.H.draw(canvas);
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
            if (this.R) {
                return true;
            }
            if (this.S) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.f10006b0 = x10;
            this.W = x10;
            float y10 = motionEvent.getY();
            this.f10007c0 = y10;
            this.f10005a0 = y10;
            this.f10008d0 = motionEvent.getPointerId(0);
            this.S = false;
            this.E = true;
            Scroller scroller = this.D;
            scroller.computeScrollOffset();
            if (this.f10022s0 != 2 || Math.abs(scroller.getFinalX() - scroller.getCurrX()) <= this.f10013i0) {
                d(false);
                this.R = false;
            } else {
                scroller.abortAnimation();
                this.P = false;
                p();
                this.R = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.f10008d0;
            if (i != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x11 = motionEvent.getX(iFindPointerIndex);
                float f = x11 - this.W;
                float fAbs = Math.abs(f);
                float y11 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y11 - this.f10007c0);
                if (f != 0.0f) {
                    float f10 = this.W;
                    if ((f10 >= this.U || f <= 0.0f) && ((f10 <= getWidth() - this.U || f >= 0.0f) && c((int) f, (int) x11, (int) y11, this, false))) {
                        this.W = x11;
                        this.f10005a0 = y11;
                        this.S = true;
                        return false;
                    }
                }
                int i10 = this.V;
                float f11 = i10;
                if (fAbs > f11 && fAbs * 0.5f > fAbs2) {
                    this.R = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f12 = this.f10006b0;
                    float f13 = i10;
                    this.W = f > 0.0f ? f12 + f13 : f12 - f13;
                    this.f10005a0 = y11;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > f11) {
                    this.S = true;
                }
                if (this.R && o(x11)) {
                    WeakHashMap weakHashMap = m0.f11777a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            l(motionEvent);
        }
        if (this.f10009e0 == null) {
            this.f10009e0 = VelocityTracker.obtain();
        }
        this.f10009e0.addMovement(motionEvent);
        return this.R;
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
        throw new UnsupportedOperationException("Method not decompiled: p5.g.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i10) {
        d dVar;
        d dVar2;
        int i11;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i10));
        int measuredWidth = getMeasuredWidth();
        this.U = Math.min(measuredWidth / 10, this.T);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            boolean z10 = true;
            int i13 = 1073741824;
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8 && (dVar2 = (d) childAt.getLayoutParams()) != null && dVar2.f9996a) {
                int i14 = dVar2.f9997b;
                int i15 = i14 & 7;
                int i16 = i14 & 112;
                boolean z11 = i16 == 48 || i16 == 80;
                if (i15 != 3 && i15 != 5) {
                    z10 = false;
                }
                int i17 = Integer.MIN_VALUE;
                if (z11) {
                    i11 = Integer.MIN_VALUE;
                    i17 = 1073741824;
                } else {
                    i11 = z10 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i18 = ((ViewGroup.LayoutParams) dVar2).width;
                if (i18 != -2) {
                    if (i18 == -1) {
                        i18 = paddingLeft;
                    }
                    i17 = 1073741824;
                } else {
                    i18 = paddingLeft;
                }
                int i19 = ((ViewGroup.LayoutParams) dVar2).height;
                if (i19 == -2) {
                    i19 = measuredHeight;
                    i13 = i11;
                } else if (i19 == -1) {
                    i19 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i18, i17), View.MeasureSpec.makeMeasureSpec(i19, i13));
                if (z11) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z10) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i12++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.M = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.N = true;
        p();
        this.N = false;
        int childCount2 = getChildCount();
        for (int i20 = 0; i20 < childCount2; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8 && ((dVar = (d) childAt2.getLayoutParams()) == null || !dVar.f9996a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * dVar.f9998c), 1073741824), this.M);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i10;
        int i11;
        int i12;
        c cVarH;
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
            if (childAt.getVisibility() == 0 && (cVarH = h(childAt)) != null && cVarH.f9992b == this.A && childAt.requestFocus(i, rect)) {
                return true;
            }
            i10 += i12;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.f112v);
        if (this.f10027z != null) {
            u(fVar.f10000x, 0, false, true);
        } else {
            this.B = fVar.f10000x;
            this.C = fVar.f10001y;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        fVar.f10000x = this.A;
        a aVar = this.f10027z;
        if (aVar != null) {
            aVar.getClass();
            fVar.f10001y = null;
        }
        return fVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        if (i != i11) {
            int i13 = this.G;
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
        throw new UnsupportedOperationException("Method not decompiled: p5.g.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        q(this.A);
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
        throw new UnsupportedOperationException("Method not decompiled: p5.g.q(int):void");
    }

    public final void r(int i, int i10, int i11, int i12) {
        if (i10 > 0 && !this.f10024w.isEmpty()) {
            if (!this.D.isFinished()) {
                this.D.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)) * (((i - getPaddingLeft()) - getPaddingRight()) + i11)), getScrollY());
                return;
            }
        }
        c cVarJ = j(this.A);
        int iMin = (int) ((cVarJ != null ? Math.min(cVarJ.f9995e, this.L) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            d(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.N) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final boolean s() {
        this.f10008d0 = -1;
        this.R = false;
        this.S = false;
        VelocityTracker velocityTracker = this.f10009e0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f10009e0 = null;
        }
        this.f10014j0.onRelease();
        this.f10015k0.onRelease();
        return this.f10014j0.isFinished() || this.f10015k0.isFinished();
    }

    public void setAdapter(a aVar) {
        ArrayList arrayList = this.f10024w;
        a aVar2 = this.f10027z;
        if (aVar2 != null) {
            synchronized (aVar2) {
            }
            this.f10027z.e(this);
            for (int i = 0; i < arrayList.size(); i++) {
                c cVar = (c) arrayList.get(i);
                a aVar3 = this.f10027z;
                int i10 = cVar.f9992b;
                aVar3.a(cVar.f9991a);
            }
            this.f10027z.b();
            arrayList.clear();
            int i11 = 0;
            while (i11 < getChildCount()) {
                if (!((d) getChildAt(i11).getLayoutParams()).f9996a) {
                    removeViewAt(i11);
                    i11--;
                }
                i11++;
            }
            this.A = 0;
            scrollTo(0, 0);
        }
        this.f10027z = aVar;
        this.f10023v = 0;
        if (aVar != null) {
            if (this.F == null) {
                this.F = new d2(2, this);
            }
            this.f10027z.d();
            this.P = false;
            boolean z10 = this.f10016l0;
            this.f10016l0 = true;
            this.f10023v = this.f10027z.c();
            if (this.B >= 0) {
                this.f10027z.getClass();
                u(this.B, 0, false, true);
                this.B = -1;
                this.C = null;
            } else if (z10) {
                requestLayout();
            } else {
                p();
            }
        }
        ArrayList arrayList2 = this.f10020q0;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        int size = this.f10020q0.size();
        for (int i12 = 0; i12 < size; i12++) {
            oa.c cVar2 = (oa.c) this.f10020q0.get(i12);
            TabLayout tabLayout = cVar2.f9714b;
            if (tabLayout.f2952m0 == this) {
                tabLayout.k(aVar, cVar2.f9713a);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.P = false;
        u(i, 0, !this.f10016l0, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.Q) {
            this.Q = i;
            p();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(e eVar) {
        this.f10019p0 = eVar;
    }

    public void setPageMargin(int i) {
        int i10 = this.G;
        this.G = i;
        int width = getWidth();
        r(width, width, i, i10);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.H = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.f10022s0 == i) {
            return;
        }
        this.f10022s0 = i;
        e eVar = this.f10019p0;
        if (eVar != null) {
            i iVar = (i) eVar;
            iVar.f9727b = iVar.f9728c;
            iVar.f9728c = i;
            TabLayout tabLayout = (TabLayout) iVar.f9726a.get();
            if (tabLayout != null) {
                tabLayout.f2957s0 = iVar.f9728c;
            }
        }
        ArrayList arrayList = this.o0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar2 = (e) this.o0.get(i10);
                if (eVar2 != null) {
                    i iVar2 = (i) eVar2;
                    iVar2.f9727b = iVar2.f9728c;
                    iVar2.f9728c = i;
                    TabLayout tabLayout2 = (TabLayout) iVar2.f9726a.get();
                    if (tabLayout2 != null) {
                        tabLayout2.f2957s0 = iVar2.f9728c;
                    }
                }
            }
        }
    }

    public final void t(int i, int i10, boolean z10, boolean z11) {
        int scrollX;
        int iAbs;
        c cVarJ = j(i);
        int iMax = cVarJ != null ? (int) (Math.max(this.K, Math.min(cVarJ.f9995e, this.L)) * getClientWidth()) : 0;
        if (!z10) {
            if (z11) {
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
            Scroller scroller = this.D;
            if (scroller == null || scroller.isFinished()) {
                scrollX = getScrollX();
            } else {
                scrollX = this.E ? scroller.getCurrX() : scroller.getStartX();
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
                float f10 = i14;
                float fSin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i12) * 1.0f) / f) - 0.5f) * 0.47123894f)) * f10) + f10;
                int iAbs2 = Math.abs(i10);
                if (iAbs2 > 0) {
                    iAbs = Math.round(Math.abs(fSin / iAbs2) * 1000.0f) * 4;
                } else {
                    this.f10027z.getClass();
                    iAbs = (int) (((Math.abs(i12) / ((f * 1.0f) + this.G)) + 1.0f) * 100.0f);
                }
                int iMin = Math.min(iAbs, 600);
                this.E = false;
                this.D.startScroll(i11, scrollY, i12, i13, iMin);
                WeakHashMap weakHashMap = m0.f11777a;
                postInvalidateOnAnimation();
            }
        }
        if (z11) {
            f(i);
        }
    }

    public final void u(int i, int i10, boolean z10, boolean z11) {
        a aVar = this.f10027z;
        if (aVar == null || aVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        ArrayList arrayList = this.f10024w;
        if (!z11 && this.A == i && arrayList.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.f10027z.c()) {
            i = this.f10027z.c() - 1;
        }
        int i11 = this.Q;
        int i12 = this.A;
        if (i > i12 + i11 || i < i12 - i11) {
            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                ((c) arrayList.get(i13)).f9993c = true;
            }
        }
        boolean z12 = this.A != i;
        if (!this.f10016l0) {
            q(i);
            t(i, i10, z10, z12);
        } else {
            this.A = i;
            if (z12) {
                f(i);
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.H;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d dVar = new d(context, attributeSet);
        dVar.f9998c = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f10002t0);
        dVar.f9997b = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
        return dVar;
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getDrawable(i));
    }
}
