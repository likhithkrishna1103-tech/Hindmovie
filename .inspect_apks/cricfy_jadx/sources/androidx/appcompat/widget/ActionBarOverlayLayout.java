package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import ba.f;
import com.google.android.gms.internal.measurement.j4;
import d4.e;
import java.util.WeakHashMap;
import m.j;
import n.v;
import o.i1;
import o.j1;
import o.k;
import o.k3;
import o.p3;
import t0.a1;
import t0.b0;
import t0.c1;
import t0.d0;
import t0.d1;
import t0.e1;
import t0.f1;
import t0.m;
import t0.m0;
import t0.m1;
import t0.n;
import t0.p1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements i1, m, n {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int[] f535a0 = {g.a.actionBarSize, R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final p1 f536b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final Rect f537c0;
    public Drawable A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public final Rect H;
    public final Rect I;
    public final Rect J;
    public final Rect K;
    public p1 L;
    public p1 M;
    public p1 N;
    public p1 O;
    public o.c P;
    public OverScroller Q;
    public ViewPropertyAnimator R;
    public final f S;
    public final o.b T;
    public final o.b U;
    public final e V;
    public final o.e W;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f538v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f539w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ContentFrameLayout f540x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ActionBarContainer f541y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public j1 f542z;

    static {
        int i = Build.VERSION.SDK_INT;
        f1 e1Var = i >= 34 ? new e1() : i >= 30 ? new d1() : i >= 29 ? new c1() : new a1();
        e1Var.g(l0.c.c(0, 1, 0, 1));
        f536b0 = e1Var.b();
        f537c0 = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f539w = 0;
        this.H = new Rect();
        this.I = new Rect();
        this.J = new Rect();
        this.K = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        p1 p1Var = p1.f11790b;
        this.L = p1Var;
        this.M = p1Var;
        this.N = p1Var;
        this.O = p1Var;
        this.S = new f(5, this);
        this.T = new o.b(this, 0);
        this.U = new o.b(this, 1);
        i(context);
        this.V = new e();
        o.e eVar = new o.e(context);
        eVar.setWillNotDraw(true);
        this.W = eVar;
        addView(eVar);
    }

    public static boolean g(View view, Rect rect, boolean z10) {
        boolean z11;
        o.d dVar = (o.d) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
        int i10 = rect.left;
        if (i != i10) {
            ((ViewGroup.MarginLayoutParams) dVar).leftMargin = i10;
            z11 = true;
        } else {
            z11 = false;
        }
        int i11 = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
        int i12 = rect.top;
        if (i11 != i12) {
            ((ViewGroup.MarginLayoutParams) dVar).topMargin = i12;
            z11 = true;
        }
        int i13 = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
        int i14 = rect.right;
        if (i13 != i14) {
            ((ViewGroup.MarginLayoutParams) dVar).rightMargin = i14;
            z11 = true;
        }
        if (z10) {
            int i15 = ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
            int i16 = rect.bottom;
            if (i15 != i16) {
                ((ViewGroup.MarginLayoutParams) dVar).bottomMargin = i16;
                return true;
            }
        }
        return z11;
    }

    @Override // t0.m
    public final void a(View view, View view2, int i, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // t0.m
    public final void b(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof o.d;
    }

    @Override // t0.n
    public final void d(View view, int i, int i10, int i11, int i12, int i13, int[] iArr) {
        e(view, i, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.A != null) {
            if (this.f541y.getVisibility() == 0) {
                translationY = (int) (this.f541y.getTranslationY() + this.f541y.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.A.setBounds(0, translationY, getWidth(), this.A.getIntrinsicHeight() + translationY);
            this.A.draw(canvas);
        }
    }

    @Override // t0.m
    public final void e(View view, int i, int i10, int i11, int i12, int i13) {
        if (i13 == 0) {
            onNestedScroll(view, i, i10, i11, i12);
        }
    }

    @Override // t0.m
    public final boolean f(View view, View view2, int i, int i10) {
        return i10 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new o.d(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new o.d(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f541y;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        e eVar = this.V;
        return eVar.f3357b | eVar.f3356a;
    }

    public CharSequence getTitle() {
        k();
        return ((p3) this.f542z).f9308a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.T);
        removeCallbacks(this.U);
        ViewPropertyAnimator viewPropertyAnimator = this.R;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f535a0);
        this.f538v = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.A = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.Q = new OverScroller(context);
    }

    public final void j(int i) {
        k();
        if (i == 2) {
            ((p3) this.f542z).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            ((p3) this.f542z).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        j1 wrapper;
        if (this.f540x == null) {
            this.f540x = (ContentFrameLayout) findViewById(g.f.action_bar_activity_content);
            this.f541y = (ActionBarContainer) findViewById(g.f.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(g.f.action_bar);
            if (callbackFindViewById instanceof j1) {
                wrapper = (j1) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f542z = wrapper;
        }
    }

    public final void l(Menu menu, v vVar) {
        k();
        p3 p3Var = (p3) this.f542z;
        Toolbar toolbar = p3Var.f9308a;
        if (p3Var.f9318m == null) {
            k kVar = new k(toolbar.getContext());
            p3Var.f9318m = kVar;
            kVar.D = g.f.action_menu_presenter;
        }
        k kVar2 = p3Var.f9318m;
        kVar2.f9253z = vVar;
        n.k kVar3 = (n.k) menu;
        if (kVar3 == null && toolbar.f619v == null) {
            return;
        }
        toolbar.f();
        n.k kVar4 = toolbar.f619v.K;
        if (kVar4 == kVar3) {
            return;
        }
        if (kVar4 != null) {
            kVar4.r(toolbar.f611j0);
            kVar4.r(toolbar.f612k0);
        }
        if (toolbar.f612k0 == null) {
            toolbar.f612k0 = new k3(toolbar);
        }
        kVar2.M = true;
        if (kVar3 != null) {
            kVar3.b(kVar2, toolbar.E);
            kVar3.b(toolbar.f612k0, toolbar.E);
        } else {
            kVar2.h(toolbar.E, null);
            toolbar.f612k0.h(toolbar.E, null);
            kVar2.e();
            toolbar.f612k0.e();
        }
        toolbar.f619v.setPopupTheme(toolbar.F);
        toolbar.f619v.setPresenter(kVar2);
        toolbar.f611j0 = kVar2;
        toolbar.v();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        p1 p1VarH = p1.h(this, windowInsets);
        boolean zG = g(this.f541y, new Rect(p1VarH.b(), p1VarH.d(), p1VarH.c(), p1VarH.a()), false);
        WeakHashMap weakHashMap = m0.f11777a;
        Rect rect = this.H;
        d0.b(this, p1VarH, rect);
        int i = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        m1 m1Var = p1VarH.f11791a;
        p1 p1VarM = m1Var.m(i, i10, i11, i12);
        this.L = p1VarM;
        boolean z10 = true;
        if (!this.M.equals(p1VarM)) {
            this.M = this.L;
            zG = true;
        }
        Rect rect2 = this.I;
        if (rect2.equals(rect)) {
            z10 = zG;
        } else {
            rect2.set(rect);
        }
        if (z10) {
            requestLayout();
        }
        return m1Var.a().f11791a.c().f11791a.b().g();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = m0.f11777a;
        b0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                o.d dVar = (o.d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i14 = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + paddingLeft;
                int i15 = ((ViewGroup.MarginLayoutParams) dVar).topMargin + paddingTop;
                childAt.layout(i14, i15, measuredWidth + i14, measuredHeight + i15);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f10, boolean z10) {
        if (!this.D || !z10) {
            return false;
        }
        this.Q.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.Q.getFinalY() > this.f541y.getHeight()) {
            h();
            this.U.run();
        } else {
            h();
            this.T.run();
        }
        this.E = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i10, int i11, int i12) {
        int i13 = this.F + i10;
        this.F = i13;
        setActionBarHideOffset(i13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        h.m0 m0Var;
        j jVar;
        this.V.f3356a = i;
        this.F = getActionBarHideOffset();
        h();
        o.c cVar = this.P;
        if (cVar == null || (jVar = (m0Var = (h.m0) cVar).f5385w) == null) {
            return;
        }
        jVar.a();
        m0Var.f5385w = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f541y.getVisibility() != 0) {
            return false;
        }
        return this.D;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.D || this.E) {
            return;
        }
        if (this.F <= this.f541y.getHeight()) {
            h();
            postDelayed(this.T, 600L);
        } else {
            h();
            postDelayed(this.U, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        k();
        int i10 = this.G ^ i;
        this.G = i;
        boolean z10 = (i & 4) == 0;
        boolean z11 = (i & 256) != 0;
        o.c cVar = this.P;
        if (cVar != null) {
            h.m0 m0Var = (h.m0) cVar;
            m0Var.f5381s = !z11;
            if (z10 || !z11) {
                if (m0Var.f5382t) {
                    m0Var.f5382t = false;
                    m0Var.h0(true);
                }
            } else if (!m0Var.f5382t) {
                m0Var.f5382t = true;
                m0Var.h0(true);
            }
        }
        if ((i10 & 256) == 0 || this.P == null) {
            return;
        }
        WeakHashMap weakHashMap = m0.f11777a;
        b0.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f539w = i;
        o.c cVar = this.P;
        if (cVar != null) {
            ((h.m0) cVar).f5380r = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        h();
        this.f541y.setTranslationY(-Math.max(0, Math.min(i, this.f541y.getHeight())));
    }

    public void setActionBarVisibilityCallback(o.c cVar) {
        this.P = cVar;
        if (getWindowToken() != null) {
            ((h.m0) this.P).f5380r = this.f539w;
            int i = this.G;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = m0.f11777a;
                b0.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.C = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.D) {
            this.D = z10;
            if (z10) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        k();
        p3 p3Var = (p3) this.f542z;
        p3Var.f9311d = i != 0 ? j4.i(p3Var.f9308a.getContext(), i) : null;
        p3Var.c();
    }

    public void setLogo(int i) {
        k();
        p3 p3Var = (p3) this.f542z;
        p3Var.f9312e = i != 0 ? j4.i(p3Var.f9308a.getContext(), i) : null;
        p3Var.c();
    }

    public void setOverlayMode(boolean z10) {
        this.B = z10;
    }

    @Override // o.i1
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((p3) this.f542z).f9316k = callback;
    }

    @Override // o.i1
    public void setWindowTitle(CharSequence charSequence) {
        k();
        p3 p3Var = (p3) this.f542z;
        if (p3Var.f9313g) {
            return;
        }
        Toolbar toolbar = p3Var.f9308a;
        p3Var.f9314h = charSequence;
        if ((p3Var.f9309b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (p3Var.f9313g) {
                m0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new o.d(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        p3 p3Var = (p3) this.f542z;
        p3Var.f9311d = drawable;
        p3Var.c();
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i10, int[] iArr) {
    }

    @Override // t0.m
    public final void c(View view, int i, int i10, int[] iArr, int i11) {
    }
}
