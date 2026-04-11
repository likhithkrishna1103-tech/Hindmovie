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
import b2.m;
import g.f;
import g5.l;
import h.n0;
import java.util.WeakHashMap;
import l.j;
import m.v;
import n.e;
import n.h3;
import n.k;
import n.l1;
import n.m1;
import n.m3;
import q0.c1;
import q0.d0;
import q0.d1;
import q0.f0;
import q0.f1;
import q0.g1;
import q0.h1;
import q0.n;
import q0.o;
import q0.o0;
import q0.o1;
import q0.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements l1, n, o {
    public static final int[] W = {g.a.actionBarSize, R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final r1 f878a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final Rect f879b0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public final Rect G;
    public final Rect H;
    public final Rect I;
    public final Rect J;
    public r1 K;
    public r1 L;
    public r1 M;
    public r1 N;
    public n.c O;
    public OverScroller P;
    public ViewPropertyAnimator Q;
    public final l R;
    public final n.b S;
    public final n.b T;
    public final m U;
    public final e V;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f880u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f881v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ContentFrameLayout f882w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ActionBarContainer f883x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m1 f884y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f885z;

    static {
        int i = Build.VERSION.SDK_INT;
        h1 g1Var = i >= 34 ? new g1() : i >= 30 ? new f1() : i >= 29 ? new d1() : new c1();
        g1Var.g(i0.d.c(0, 1, 0, 1));
        f878a0 = g1Var.b();
        f879b0 = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f881v = 0;
        this.G = new Rect();
        this.H = new Rect();
        this.I = new Rect();
        this.J = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        r1 r1Var = r1.f10491b;
        this.K = r1Var;
        this.L = r1Var;
        this.M = r1Var;
        this.N = r1Var;
        this.R = new l(5, this);
        this.S = new n.b(this, 0);
        this.T = new n.b(this, 1);
        i(context);
        this.U = new m();
        e eVar = new e(context);
        eVar.setWillNotDraw(true);
        this.V = eVar;
        addView(eVar);
    }

    public static boolean g(View view, Rect rect, boolean z2) {
        boolean z10;
        n.d dVar = (n.d) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
        int i10 = rect.left;
        if (i != i10) {
            ((ViewGroup.MarginLayoutParams) dVar).leftMargin = i10;
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
        int i12 = rect.top;
        if (i11 != i12) {
            ((ViewGroup.MarginLayoutParams) dVar).topMargin = i12;
            z10 = true;
        }
        int i13 = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
        int i14 = rect.right;
        if (i13 != i14) {
            ((ViewGroup.MarginLayoutParams) dVar).rightMargin = i14;
            z10 = true;
        }
        if (z2) {
            int i15 = ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
            int i16 = rect.bottom;
            if (i15 != i16) {
                ((ViewGroup.MarginLayoutParams) dVar).bottomMargin = i16;
                return true;
            }
        }
        return z10;
    }

    @Override // q0.n
    public final void a(View view, View view2, int i, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // q0.n
    public final void b(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof n.d;
    }

    @Override // q0.o
    public final void d(View view, int i, int i10, int i11, int i12, int i13, int[] iArr) {
        e(view, i, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f885z != null) {
            if (this.f883x.getVisibility() == 0) {
                translationY = (int) (this.f883x.getTranslationY() + this.f883x.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.f885z.setBounds(0, translationY, getWidth(), this.f885z.getIntrinsicHeight() + translationY);
            this.f885z.draw(canvas);
        }
    }

    @Override // q0.n
    public final void e(View view, int i, int i10, int i11, int i12, int i13) {
        if (i13 == 0) {
            onNestedScroll(view, i, i10, i11, i12);
        }
    }

    @Override // q0.n
    public final boolean f(View view, View view2, int i, int i10) {
        return i10 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new n.d(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new n.d(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f883x;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        m mVar = this.U;
        return mVar.f1762b | mVar.f1761a;
    }

    public CharSequence getTitle() {
        k();
        return ((m3) this.f884y).f8443a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.S);
        removeCallbacks(this.T);
        ViewPropertyAnimator viewPropertyAnimator = this.Q;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(W);
        this.f880u = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f885z = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.P = new OverScroller(context);
    }

    public final void j(int i) {
        k();
        if (i == 2) {
            ((m3) this.f884y).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            ((m3) this.f884y).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        m1 wrapper;
        if (this.f882w == null) {
            this.f882w = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.f883x = (ActionBarContainer) findViewById(f.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(f.action_bar);
            if (callbackFindViewById instanceof m1) {
                wrapper = (m1) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f884y = wrapper;
        }
    }

    public final void l(Menu menu, v vVar) {
        k();
        m3 m3Var = (m3) this.f884y;
        Toolbar toolbar = m3Var.f8443a;
        if (m3Var.f8453m == null) {
            k kVar = new k(toolbar.getContext());
            m3Var.f8453m = kVar;
            kVar.C = f.action_menu_presenter;
        }
        k kVar2 = m3Var.f8453m;
        kVar2.f8425y = vVar;
        m.k kVar3 = (m.k) menu;
        if (kVar3 == null && toolbar.f942u == null) {
            return;
        }
        toolbar.f();
        m.k kVar4 = toolbar.f942u.J;
        if (kVar4 == kVar3) {
            return;
        }
        if (kVar4 != null) {
            kVar4.r(toolbar.f934i0);
            kVar4.r(toolbar.f935j0);
        }
        if (toolbar.f935j0 == null) {
            toolbar.f935j0 = new h3(toolbar);
        }
        kVar2.L = true;
        if (kVar3 != null) {
            kVar3.b(kVar2, toolbar.D);
            kVar3.b(toolbar.f935j0, toolbar.D);
        } else {
            kVar2.h(toolbar.D, null);
            toolbar.f935j0.h(toolbar.D, null);
            kVar2.f(true);
            toolbar.f935j0.f(true);
        }
        toolbar.f942u.setPopupTheme(toolbar.E);
        toolbar.f942u.setPresenter(kVar2);
        toolbar.f934i0 = kVar2;
        toolbar.w();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        r1 r1VarH = r1.h(this, windowInsets);
        boolean zG = g(this.f883x, new Rect(r1VarH.b(), r1VarH.d(), r1VarH.c(), r1VarH.a()), false);
        WeakHashMap weakHashMap = o0.f10475a;
        Rect rect = this.G;
        f0.b(this, r1VarH, rect);
        int i = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        o1 o1Var = r1VarH.f10492a;
        r1 r1VarM = o1Var.m(i, i10, i11, i12);
        this.K = r1VarM;
        boolean z2 = true;
        if (!this.L.equals(r1VarM)) {
            this.L = this.K;
            zG = true;
        }
        Rect rect2 = this.H;
        if (rect2.equals(rect)) {
            z2 = zG;
        } else {
            rect2.set(rect);
        }
        if (z2) {
            requestLayout();
        }
        return o1Var.a().f10492a.c().f10492a.b().g();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = o0.f10475a;
        d0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                n.d dVar = (n.d) childAt.getLayoutParams();
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
    public final boolean onNestedFling(View view, float f, float f4, boolean z2) {
        if (!this.C || !z2) {
            return false;
        }
        this.P.fling(0, 0, 0, (int) f4, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.P.getFinalY() > this.f883x.getHeight()) {
            h();
            this.T.run();
        } else {
            h();
            this.S.run();
        }
        this.D = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f4) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i10, int i11, int i12) {
        int i13 = this.E + i10;
        this.E = i13;
        setActionBarHideOffset(i13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        n0 n0Var;
        j jVar;
        this.U.f1761a = i;
        this.E = getActionBarHideOffset();
        h();
        n.c cVar = this.O;
        if (cVar == null || (jVar = (n0Var = (n0) cVar).f5538u) == null) {
            return;
        }
        jVar.a();
        n0Var.f5538u = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f883x.getVisibility() != 0) {
            return false;
        }
        return this.C;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.C || this.D) {
            return;
        }
        if (this.E <= this.f883x.getHeight()) {
            h();
            postDelayed(this.S, 600L);
        } else {
            h();
            postDelayed(this.T, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        k();
        int i10 = this.F ^ i;
        this.F = i;
        boolean z2 = (i & 4) == 0;
        boolean z10 = (i & 256) != 0;
        n.c cVar = this.O;
        if (cVar != null) {
            n0 n0Var = (n0) cVar;
            n0Var.f5534q = !z10;
            if (z2 || !z10) {
                if (n0Var.f5535r) {
                    n0Var.f5535r = false;
                    n0Var.e0(true);
                }
            } else if (!n0Var.f5535r) {
                n0Var.f5535r = true;
                n0Var.e0(true);
            }
        }
        if ((i10 & 256) == 0 || this.O == null) {
            return;
        }
        WeakHashMap weakHashMap = o0.f10475a;
        d0.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f881v = i;
        n.c cVar = this.O;
        if (cVar != null) {
            ((n0) cVar).f5533p = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        h();
        this.f883x.setTranslationY(-Math.max(0, Math.min(i, this.f883x.getHeight())));
    }

    public void setActionBarVisibilityCallback(n.c cVar) {
        this.O = cVar;
        if (getWindowToken() != null) {
            ((n0) this.O).f5533p = this.f881v;
            int i = this.F;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = o0.f10475a;
                d0.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.B = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.C) {
            this.C = z2;
            if (z2) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        k();
        m3 m3Var = (m3) this.f884y;
        m3Var.f8446d = i != 0 ? com.bumptech.glide.d.p(m3Var.f8443a.getContext(), i) : null;
        m3Var.c();
    }

    public void setLogo(int i) {
        k();
        m3 m3Var = (m3) this.f884y;
        m3Var.f8447e = i != 0 ? com.bumptech.glide.d.p(m3Var.f8443a.getContext(), i) : null;
        m3Var.c();
    }

    public void setOverlayMode(boolean z2) {
        this.A = z2;
    }

    @Override // n.l1
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((m3) this.f884y).f8451k = callback;
    }

    @Override // n.l1
    public void setWindowTitle(CharSequence charSequence) {
        k();
        m3 m3Var = (m3) this.f884y;
        if (m3Var.f8448g) {
            return;
        }
        Toolbar toolbar = m3Var.f8443a;
        m3Var.f8449h = charSequence;
        if ((m3Var.f8444b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (m3Var.f8448g) {
                o0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new n.d(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        m3 m3Var = (m3) this.f884y;
        m3Var.f8446d = drawable;
        m3Var.c();
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i10, int[] iArr) {
    }

    @Override // q0.n
    public final void c(View view, int i, int i10, int[] iArr, int i11) {
    }
}
