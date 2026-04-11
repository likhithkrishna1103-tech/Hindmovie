package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import g.j;
import gc.o;
import j9.b0;
import j9.e0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k5.a;
import k5.c;
import k5.g;
import k5.i;
import k8.c0;
import lc.m;
import lc.n;
import n.a1;
import p0.d;
import p0.e;
import p8.k;
import p8.l;
import q0.f0;
import q0.o0;
import u9.b;
import u9.f;
import u9.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@c
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f3475s0 = k.Widget_Design_TabLayout;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final e f3476t0 = new e(16);
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public ColorStateList F;
    public ColorStateList G;
    public ColorStateList H;
    public Drawable I;
    public int J;
    public final float K;
    public final float L;
    public final int M;
    public int N;
    public final int O;
    public final int P;
    public final int Q;
    public final int R;
    public int S;
    public final int T;
    public int U;
    public int V;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f3477a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3478b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f3479c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f3480d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public c0 f3481e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final TimeInterpolator f3482f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public u9.c f3483g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final ArrayList f3484h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public nc.k f3485i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public ValueAnimator f3486j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public i f3487k0;
    public a l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public g f3488m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public h f3489n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public b f3490o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f3491p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f3492q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final d f3493r0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3494u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f3495v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u9.g f3496w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f3497x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3498y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3499z;

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet) {
        int i = p8.b.tabStyle;
        int i10 = f3475s0;
        super(x9.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f3494u = -1;
        this.f3495v = new ArrayList();
        this.E = -1;
        this.J = 0;
        this.N = Integer.MAX_VALUE;
        this.f3478b0 = -1;
        this.f3484h0 = new ArrayList();
        this.f3493r0 = new d(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(this, context2);
        this.f3497x = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayD = e0.d(context2, attributeSet, l.TabLayout, i, i10, l.TabLayout_tabTextAppearance);
        ColorStateList colorStateListK = a.a.k(getBackground());
        if (colorStateListK != null) {
            q9.g gVar = new q9.g();
            gVar.l(colorStateListK);
            gVar.j(context2);
            WeakHashMap weakHashMap = o0.f10475a;
            gVar.k(f0.e(this));
            setBackground(gVar);
        }
        setSelectedTabIndicator(a.a.m(context2, typedArrayD, l.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayD.getColor(l.TabLayout_tabIndicatorColor, 0));
        fVar.b(typedArrayD.getDimensionPixelSize(l.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayD.getInt(l.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayD.getInt(l.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayD.getBoolean(l.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(l.TabLayout_tabPadding, 0);
        this.B = dimensionPixelSize;
        this.A = dimensionPixelSize;
        this.f3499z = dimensionPixelSize;
        this.f3498y = dimensionPixelSize;
        this.f3498y = typedArrayD.getDimensionPixelSize(l.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f3499z = typedArrayD.getDimensionPixelSize(l.TabLayout_tabPaddingTop, dimensionPixelSize);
        this.A = typedArrayD.getDimensionPixelSize(l.TabLayout_tabPaddingEnd, dimensionPixelSize);
        this.B = typedArrayD.getDimensionPixelSize(l.TabLayout_tabPaddingBottom, dimensionPixelSize);
        if (z7.a.z(context2, p8.b.isMaterial3Theme, false)) {
            this.C = p8.b.textAppearanceTitleSmall;
        } else {
            this.C = p8.b.textAppearanceButton;
        }
        int resourceId = typedArrayD.getResourceId(l.TabLayout_tabTextAppearance, k.TextAppearance_Design_Tab);
        this.D = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, j.TextAppearance);
        try {
            float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.TextAppearance_android_textSize, 0);
            this.K = dimensionPixelSize2;
            this.F = a.a.i(context2, typedArrayObtainStyledAttributes, j.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayD.hasValue(l.TabLayout_tabSelectedTextAppearance)) {
                this.E = typedArrayD.getResourceId(l.TabLayout_tabSelectedTextAppearance, resourceId);
            }
            int i11 = this.E;
            int[] iArr = HorizontalScrollView.EMPTY_STATE_SET;
            int[] iArr2 = HorizontalScrollView.SELECTED_STATE_SET;
            if (i11 != -1) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(i11, j.TextAppearance);
                try {
                    typedArrayObtainStyledAttributes.getDimensionPixelSize(j.TextAppearance_android_textSize, (int) dimensionPixelSize2);
                    ColorStateList colorStateListI = a.a.i(context2, typedArrayObtainStyledAttributes, j.TextAppearance_android_textColor);
                    if (colorStateListI != null) {
                        this.F = new ColorStateList(new int[][]{iArr2, iArr}, new int[]{colorStateListI.getColorForState(new int[]{R.attr.state_selected}, colorStateListI.getDefaultColor()), this.F.getDefaultColor()});
                    }
                } finally {
                }
            }
            if (typedArrayD.hasValue(l.TabLayout_tabTextColor)) {
                this.F = a.a.i(context2, typedArrayD, l.TabLayout_tabTextColor);
            }
            if (typedArrayD.hasValue(l.TabLayout_tabSelectedTextColor)) {
                this.F = new ColorStateList(new int[][]{iArr2, iArr}, new int[]{typedArrayD.getColor(l.TabLayout_tabSelectedTextColor, 0), this.F.getDefaultColor()});
            }
            this.G = a.a.i(context2, typedArrayD, l.TabLayout_tabIconTint);
            j9.f0.e(typedArrayD.getInt(l.TabLayout_tabIconTintMode, -1), null);
            this.H = a.a.i(context2, typedArrayD, l.TabLayout_tabRippleColor);
            this.T = typedArrayD.getInt(l.TabLayout_tabIndicatorAnimationDuration, 300);
            this.f3482f0 = b8.h.y(context2, p8.b.motionEasingEmphasizedInterpolator, q8.a.f11073b);
            this.O = typedArrayD.getDimensionPixelSize(l.TabLayout_tabMinWidth, -1);
            this.P = typedArrayD.getDimensionPixelSize(l.TabLayout_tabMaxWidth, -1);
            this.M = typedArrayD.getResourceId(l.TabLayout_tabBackground, 0);
            this.R = typedArrayD.getDimensionPixelSize(l.TabLayout_tabContentStart, 0);
            this.V = typedArrayD.getInt(l.TabLayout_tabMode, 1);
            this.S = typedArrayD.getInt(l.TabLayout_tabGravity, 0);
            this.W = typedArrayD.getBoolean(l.TabLayout_tabInlineLabel, false);
            this.f3480d0 = typedArrayD.getBoolean(l.TabLayout_tabUnboundedRipple, false);
            typedArrayD.recycle();
            Resources resources = getResources();
            this.L = resources.getDimensionPixelSize(p8.d.design_tab_text_size_2line);
            this.Q = resources.getDimensionPixelSize(p8.d.design_tab_scrollable_min_width);
            c();
        } finally {
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.f3495v;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.O;
        if (i != -1) {
            return i;
        }
        int i10 = this.V;
        if (i10 == 0 || i10 == 2) {
            return this.Q;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f3497x.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        f fVar = this.f3497x;
        int childCount = fVar.getChildCount();
        if (i < childCount) {
            int i10 = 0;
            while (i10 < childCount) {
                View childAt = fVar.getChildAt(i10);
                if ((i10 != i || childAt.isSelected()) && (i10 == i || !childAt.isSelected())) {
                    childAt.setSelected(i10 == i);
                    childAt.setActivated(i10 == i);
                } else {
                    childAt.setSelected(i10 == i);
                    childAt.setActivated(i10 == i);
                    if (childAt instanceof u9.j) {
                        ((u9.j) childAt).f();
                    }
                }
                i10++;
            }
        }
    }

    public final void a(u9.g gVar, boolean z2) {
        ArrayList arrayList = this.f3495v;
        int size = arrayList.size();
        if (gVar.f12806d != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        gVar.f12804b = size;
        arrayList.add(size, gVar);
        int size2 = arrayList.size();
        int i = -1;
        for (int i10 = size + 1; i10 < size2; i10++) {
            if (((u9.g) arrayList.get(i10)).f12804b == this.f3494u) {
                i = i10;
            }
            ((u9.g) arrayList.get(i10)).f12804b = i10;
        }
        this.f3494u = i;
        u9.j jVar = gVar.f12807e;
        jVar.setSelected(false);
        jVar.setActivated(false);
        int i11 = gVar.f12804b;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.V == 1 && this.S == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.f3497x.addView(jVar, i11, layoutParams);
        if (z2) {
            TabLayout tabLayout = gVar.f12806d;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.j(gVar, true);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void b(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = o0.f10475a;
            if (isLaidOut()) {
                f fVar = this.f3497x;
                int childCount = fVar.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    if (fVar.getChildAt(i10).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int iD = d(i, 0.0f);
                if (scrollX != iD) {
                    e();
                    this.f3486j0.setIntValues(scrollX, iD);
                    this.f3486j0.start();
                }
                ValueAnimator valueAnimator = fVar.f12801u;
                if (valueAnimator != null && valueAnimator.isRunning() && fVar.f12802v.f3494u != i) {
                    fVar.f12801u.cancel();
                }
                fVar.d(i, this.T, true);
                return;
            }
        }
        l(i, 0.0f, true, true, true);
    }

    public final void c() {
        int i = this.V;
        int iMax = (i == 0 || i == 2) ? Math.max(0, this.R - this.f3498y) : 0;
        WeakHashMap weakHashMap = o0.f10475a;
        f fVar = this.f3497x;
        fVar.setPaddingRelative(iMax, 0, 0, 0);
        int i10 = this.V;
        if (i10 == 0) {
            int i11 = this.S;
            if (i11 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i11 == 1) {
                fVar.setGravity(1);
            } else if (i11 == 2) {
            }
            fVar.setGravity(8388611);
        } else if (i10 == 1 || i10 == 2) {
            if (this.S == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            fVar.setGravity(1);
        }
        n(true);
    }

    public final int d(int i, float f) {
        f fVar;
        View childAt;
        int i10 = this.V;
        if ((i10 != 0 && i10 != 2) || (childAt = (fVar = this.f3497x).getChildAt(i)) == null) {
            return 0;
        }
        int i11 = i + 1;
        View childAt2 = i11 < fVar.getChildCount() ? fVar.getChildAt(i11) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i12 = (int) ((width + width2) * 0.5f * f);
        WeakHashMap weakHashMap = o0.f10475a;
        return getLayoutDirection() == 0 ? left + i12 : left - i12;
    }

    public final void e() {
        if (this.f3486j0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f3486j0 = valueAnimator;
            valueAnimator.setInterpolator(this.f3482f0);
            this.f3486j0.setDuration(this.T);
            this.f3486j0.addUpdateListener(new b0(2, this));
        }
    }

    public final u9.g f(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return (u9.g) this.f3495v.get(i);
    }

    public final u9.g g() {
        u9.g gVar = (u9.g) f3476t0.i();
        if (gVar == null) {
            gVar = new u9.g();
            gVar.f12804b = -1;
        }
        gVar.f12806d = this;
        d dVar = this.f3493r0;
        u9.j jVar = dVar != null ? (u9.j) dVar.i() : null;
        if (jVar == null) {
            jVar = new u9.j(this, getContext());
        }
        jVar.setTab(gVar);
        jVar.setFocusable(true);
        jVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(null)) {
            jVar.setContentDescription(gVar.f12803a);
        } else {
            jVar.setContentDescription(null);
        }
        gVar.f12807e = jVar;
        return gVar;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        u9.g gVar = this.f3496w;
        if (gVar != null) {
            return gVar.f12804b;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f3495v.size();
    }

    public int getTabGravity() {
        return this.S;
    }

    public ColorStateList getTabIconTint() {
        return this.G;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f3479c0;
    }

    public int getTabIndicatorGravity() {
        return this.U;
    }

    public int getTabMaxWidth() {
        return this.N;
    }

    public int getTabMode() {
        return this.V;
    }

    public ColorStateList getTabRippleColor() {
        return this.H;
    }

    public Drawable getTabSelectedIndicator() {
        return this.I;
    }

    public ColorStateList getTabTextColors() {
        return this.F;
    }

    public final void h() {
        int currentItem;
        String string;
        i();
        a aVar = this.l0;
        if (aVar != null) {
            int iC = aVar.c();
            for (int i = 0; i < iC; i++) {
                u9.g gVarG = g();
                n nVar = ((m) this.l0).f8112g;
                Resources resourcesM = nVar.m();
                int iIntValue = ((Integer) nVar.I0.get(i)).intValue();
                if (iIntValue == 1) {
                    string = resourcesM.getString(o.exo_track_selection_title_audio);
                } else if (iIntValue == 2) {
                    string = resourcesM.getString(o.exo_track_selection_title_video);
                } else {
                    if (iIntValue != 3) {
                        throw new IllegalArgumentException();
                    }
                    string = resourcesM.getString(o.exo_track_selection_title_text);
                }
                if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(string)) {
                    gVarG.f12807e.setContentDescription(string);
                }
                gVarG.f12803a = string;
                u9.j jVar = gVarG.f12807e;
                if (jVar != null) {
                    jVar.d();
                }
                a(gVarG, false);
            }
            i iVar = this.f3487k0;
            if (iVar == null || iC <= 0 || (currentItem = iVar.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            j(f(currentItem), true);
        }
    }

    public final void i() {
        f fVar = this.f3497x;
        int childCount = fVar.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            u9.j jVar = (u9.j) fVar.getChildAt(childCount);
            fVar.removeViewAt(childCount);
            if (jVar != null) {
                jVar.setTab(null);
                jVar.setSelected(false);
                this.f3493r0.b(jVar);
            }
            requestLayout();
        }
        Iterator it = this.f3495v.iterator();
        while (it.hasNext()) {
            u9.g gVar = (u9.g) it.next();
            it.remove();
            gVar.f12806d = null;
            gVar.f12807e = null;
            gVar.f12803a = null;
            gVar.f12804b = -1;
            gVar.f12805c = null;
            f3476t0.b(gVar);
        }
        this.f3496w = null;
    }

    public final void j(u9.g gVar, boolean z2) {
        TabLayout tabLayout;
        u9.g gVar2 = this.f3496w;
        ArrayList arrayList = this.f3484h0;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((u9.c) arrayList.get(size)).getClass();
                }
                b(gVar.f12804b);
                return;
            }
            return;
        }
        int i = gVar != null ? gVar.f12804b : -1;
        if (z2) {
            if ((gVar2 == null || gVar2.f12804b == -1) && i != -1) {
                tabLayout = this;
                tabLayout.l(i, 0.0f, true, true, true);
            } else {
                tabLayout = this;
                b(i);
            }
            if (i != -1) {
                setSelectedTabView(i);
            }
        } else {
            tabLayout = this;
        }
        tabLayout.f3496w = gVar;
        if (gVar2 != null && gVar2.f12806d != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((u9.c) arrayList.get(size2)).getClass();
            }
        }
        if (gVar != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((u9.c) arrayList.get(size3)).a(gVar);
            }
        }
    }

    public final void k(a aVar, boolean z2) {
        g gVar;
        a aVar2 = this.l0;
        if (aVar2 != null && (gVar = this.f3488m0) != null) {
            aVar2.f7017a.unregisterObserver(gVar);
        }
        this.l0 = aVar;
        if (z2 && aVar != null) {
            if (this.f3488m0 == null) {
                this.f3488m0 = new g(2, this);
            }
            aVar.f7017a.registerObserver(this.f3488m0);
        }
        h();
    }

    public final void l(int i, float f, boolean z2, boolean z10, boolean z11) {
        float f4 = i + f;
        int iRound = Math.round(f4);
        if (iRound >= 0) {
            f fVar = this.f3497x;
            if (iRound >= fVar.getChildCount()) {
                return;
            }
            if (z10) {
                fVar.f12802v.f3494u = Math.round(f4);
                ValueAnimator valueAnimator = fVar.f12801u;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    fVar.f12801u.cancel();
                }
                fVar.c(fVar.getChildAt(i), fVar.getChildAt(i + 1), f);
            }
            ValueAnimator valueAnimator2 = this.f3486j0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f3486j0.cancel();
            }
            int iD = d(i, f);
            int scrollX = getScrollX();
            boolean z12 = (i < getSelectedTabPosition() && iD >= scrollX) || (i > getSelectedTabPosition() && iD <= scrollX) || i == getSelectedTabPosition();
            WeakHashMap weakHashMap = o0.f10475a;
            if (getLayoutDirection() == 1) {
                z12 = (i < getSelectedTabPosition() && iD <= scrollX) || (i > getSelectedTabPosition() && iD >= scrollX) || i == getSelectedTabPosition();
            }
            if (z12 || this.f3492q0 == 1 || z11) {
                if (i < 0) {
                    iD = 0;
                }
                scrollTo(iD, 0);
            }
            if (z2) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void m(i iVar, boolean z2) {
        TabLayout tabLayout;
        ArrayList arrayList;
        ArrayList arrayList2;
        i iVar2 = this.f3487k0;
        if (iVar2 != null) {
            h hVar = this.f3489n0;
            if (hVar != null && (arrayList2 = iVar2.f7047n0) != null) {
                arrayList2.remove(hVar);
            }
            b bVar = this.f3490o0;
            if (bVar != null && (arrayList = this.f3487k0.f7049p0) != null) {
                arrayList.remove(bVar);
            }
        }
        nc.k kVar = this.f3485i0;
        ArrayList arrayList3 = this.f3484h0;
        if (kVar != null) {
            arrayList3.remove(kVar);
            this.f3485i0 = null;
        }
        if (iVar != null) {
            this.f3487k0 = iVar;
            if (this.f3489n0 == null) {
                this.f3489n0 = new h(this);
            }
            h hVar2 = this.f3489n0;
            hVar2.f12810c = 0;
            hVar2.f12809b = 0;
            if (iVar.f7047n0 == null) {
                iVar.f7047n0 = new ArrayList();
            }
            iVar.f7047n0.add(hVar2);
            nc.k kVar2 = new nc.k(1, iVar);
            this.f3485i0 = kVar2;
            if (!arrayList3.contains(kVar2)) {
                arrayList3.add(kVar2);
            }
            a adapter = iVar.getAdapter();
            if (adapter != null) {
                k(adapter, true);
            }
            if (this.f3490o0 == null) {
                this.f3490o0 = new b(this);
            }
            b bVar2 = this.f3490o0;
            bVar2.f12795a = true;
            if (iVar.f7049p0 == null) {
                iVar.f7049p0 = new ArrayList();
            }
            iVar.f7049p0.add(bVar2);
            l(iVar.getCurrentItem(), 0.0f, true, true, true);
            tabLayout = this;
        } else {
            tabLayout = this;
            tabLayout.f3487k0 = null;
            k(null, false);
        }
        tabLayout.f3491p0 = z2;
    }

    public final void n(boolean z2) {
        int i = 0;
        while (true) {
            f fVar = this.f3497x;
            if (i >= fVar.getChildCount()) {
                return;
            }
            View childAt = fVar.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.V == 1 && this.S == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z2) {
                childAt.requestLayout();
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i5.a.O(this);
        if (this.f3487k0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof i) {
                m((i) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3491p0) {
            setupWithViewPager(null);
            this.f3491p0 = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        u9.j jVar;
        Drawable drawable;
        int i = 0;
        while (true) {
            f fVar = this.f3497x;
            if (i >= fVar.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = fVar.getChildAt(i);
            if ((childAt instanceof u9.j) && (drawable = (jVar = (u9.j) childAt).C) != null) {
                drawable.setBounds(jVar.getLeft(), jVar.getTop(), jVar.getRight(), jVar.getBottom());
                jVar.C.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) a1.x(1, getTabCount(), 1).f8343u);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = j9.f0.b(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.P
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = j9.f0.b(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.N = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.V
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r7.measure(r0, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        i5.a.K(this, f);
    }

    public void setInlineLabel(boolean z2) {
        if (this.W == z2) {
            return;
        }
        this.W = z2;
        int i = 0;
        while (true) {
            f fVar = this.f3497x;
            if (i >= fVar.getChildCount()) {
                c();
                return;
            }
            View childAt = fVar.getChildAt(i);
            if (childAt instanceof u9.j) {
                u9.j jVar = (u9.j) childAt;
                jVar.setOrientation(!jVar.E.W ? 1 : 0);
                TextView textView = jVar.A;
                if (textView == null && jVar.B == null) {
                    jVar.g(jVar.f12814v, jVar.f12815w, true);
                } else {
                    jVar.g(textView, jVar.B, false);
                }
            }
            i++;
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(u9.d dVar) {
        setOnTabSelectedListener((u9.c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        e();
        this.f3486j0.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = drawable.mutate();
        this.I = drawableMutate;
        int i = this.J;
        if (i != 0) {
            drawableMutate.setTint(i);
        } else {
            drawableMutate.setTintList(null);
        }
        int intrinsicHeight = this.f3478b0;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.I.getIntrinsicHeight();
        }
        this.f3497x.b(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.J = i;
        Drawable drawable = this.I;
        if (i != 0) {
            drawable.setTint(i);
        } else {
            drawable.setTintList(null);
        }
        n(false);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.U != i) {
            this.U = i;
            WeakHashMap weakHashMap = o0.f10475a;
            this.f3497x.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.f3478b0 = i;
        this.f3497x.b(i);
    }

    public void setTabGravity(int i) {
        if (this.S != i) {
            this.S = i;
            c();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            ArrayList arrayList = this.f3495v;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                u9.j jVar = ((u9.g) arrayList.get(i)).f12807e;
                if (jVar != null) {
                    jVar.d();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(f0.c.c(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.f3479c0 = i;
        if (i == 0) {
            this.f3481e0 = new c0(29);
            return;
        }
        if (i == 1) {
            this.f3481e0 = new u9.a(0);
        } else {
            if (i == 2) {
                this.f3481e0 = new u9.a(1);
                return;
            }
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.f3477a0 = z2;
        int i = f.f12800w;
        f fVar = this.f3497x;
        fVar.a(fVar.f12802v.getSelectedTabPosition());
        WeakHashMap weakHashMap = o0.f10475a;
        fVar.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.V) {
            this.V = i;
            c();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.H == colorStateList) {
            return;
        }
        this.H = colorStateList;
        int i = 0;
        while (true) {
            f fVar = this.f3497x;
            if (i >= fVar.getChildCount()) {
                return;
            }
            View childAt = fVar.getChildAt(i);
            if (childAt instanceof u9.j) {
                Context context = getContext();
                int i10 = u9.j.F;
                ((u9.j) childAt).e(context);
            }
            i++;
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(f0.c.c(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            ArrayList arrayList = this.f3495v;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                u9.j jVar = ((u9.g) arrayList.get(i)).f12807e;
                if (jVar != null) {
                    jVar.d();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(a aVar) {
        k(aVar, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.f3480d0 == z2) {
            return;
        }
        this.f3480d0 = z2;
        int i = 0;
        while (true) {
            f fVar = this.f3497x;
            if (i >= fVar.getChildCount()) {
                return;
            }
            View childAt = fVar.getChildAt(i);
            if (childAt instanceof u9.j) {
                Context context = getContext();
                int i10 = u9.j.F;
                ((u9.j) childAt).e(context);
            }
            i++;
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(i iVar) {
        m(iVar, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(u9.c cVar) {
        u9.c cVar2 = this.f3483g0;
        ArrayList arrayList = this.f3484h0;
        if (cVar2 != null) {
            arrayList.remove(cVar2);
        }
        this.f3483g0 = cVar;
        if (cVar == null || arrayList.contains(cVar)) {
            return;
        }
        arrayList.add(cVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(com.bumptech.glide.d.p(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
