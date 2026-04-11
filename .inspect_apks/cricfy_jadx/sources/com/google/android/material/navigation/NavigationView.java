package com.google.android.material.navigation;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.emoji2.text.v;
import c.c;
import com.google.android.material.internal.NavigationMenuView;
import da.i;
import da.t;
import da.w;
import ea.b;
import fa.a;
import fa.d;
import fa.e;
import fa.f;
import fa.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import k9.k;
import k9.l;
import ka.m;
import ka.x;
import m.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends w implements b {
    public static final int[] U = {R.attr.state_checked};
    public static final int[] V = {-16842910};
    public static final int W = k.Widget_Design_NavigationView;
    public final i C;
    public final t D;
    public f E;
    public final int F;
    public final int[] G;
    public h H;
    public final e I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public final boolean O;
    public final int P;
    public final x Q;
    public final ea.i R;
    public final v S;
    public final d T;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01da A[PHI: r11
      0x01da: PHI (r11v3 android.graphics.drawable.Drawable) = 
      (r11v2 android.graphics.drawable.Drawable)
      (r11v6 android.graphics.drawable.Drawable)
      (r11v2 android.graphics.drawable.Drawable)
     binds: [B:54:0x019d, B:60:0x01c3, B:58:0x01ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationView(android.content.Context r18, android.util.AttributeSet r19) {
        /*
            Method dump skipped, instruction units count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private MenuInflater getMenuInflater() {
        if (this.H == null) {
            this.H = new h(getContext());
        }
        return this.H;
    }

    @Override // ea.b
    public final void a() {
        Pair pairH = h();
        DrawerLayout drawerLayout = (DrawerLayout) pairH.first;
        ea.i iVar = this.R;
        c cVar = iVar.f;
        iVar.f = null;
        if (cVar == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.c(this, true);
            return;
        }
        int i = ((j1.d) pairH.second).f6503a;
        int i10 = fa.c.f4523a;
        int i11 = 0;
        iVar.b(cVar, i, new fa.b(drawerLayout, this, i11), new a(i11, drawerLayout));
    }

    @Override // ea.b
    public final void b(c cVar) {
        float f = cVar.f1938c;
        int i = ((j1.d) h().second).f6503a;
        ea.i iVar = this.R;
        if (iVar.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        c cVar2 = iVar.f;
        iVar.f = cVar;
        if (cVar2 != null) {
            iVar.c(f, cVar.f1939d == 0, i);
        }
        if (this.O) {
            this.N = l9.a.c(iVar.f3852a.getInterpolation(f), 0, this.P);
            g(getWidth(), getHeight());
        }
    }

    @Override // ea.b
    public final void c(c cVar) {
        h();
        this.R.f = cVar;
    }

    @Override // ea.b
    public final void d() {
        h();
        this.R.a();
        if (!this.O || this.N == 0) {
            return;
        }
        this.N = 0;
        g(getWidth(), getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        x xVar = this.Q;
        Path path = xVar.f7388e;
        if (!xVar.b() || path.isEmpty()) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public final ColorStateList e(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListC = i0.c.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(g.a.colorPrimary, typedValue, true)) {
            return null;
        }
        int i10 = typedValue.data;
        int defaultColor = colorStateListC.getDefaultColor();
        int[] iArr = V;
        return new ColorStateList(new int[][]{iArr, U, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListC.getColorForState(iArr, defaultColor), i10, defaultColor});
    }

    public final InsetDrawable f(l7.a aVar, ColorStateList colorStateList) {
        int i = l.NavigationView_itemShapeAppearance;
        TypedArray typedArray = (TypedArray) aVar.f7867x;
        ka.i iVar = new ka.i(m.a(getContext(), typedArray.getResourceId(i, 0), typedArray.getResourceId(l.NavigationView_itemShapeAppearanceOverlay, 0)).a());
        iVar.q(colorStateList);
        return new InsetDrawable((Drawable) iVar, typedArray.getDimensionPixelSize(l.NavigationView_itemShapeInsetStart, 0), typedArray.getDimensionPixelSize(l.NavigationView_itemShapeInsetTop, 0), typedArray.getDimensionPixelSize(l.NavigationView_itemShapeInsetEnd, 0), typedArray.getDimensionPixelSize(l.NavigationView_itemShapeInsetBottom, 0));
    }

    public final void g(int i, int i10) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof j1.d)) {
            if ((this.N > 0 || this.O) && (getBackground() instanceof ka.i)) {
                boolean z10 = Gravity.getAbsoluteGravity(((j1.d) getLayoutParams()).f6503a, getLayoutDirection()) == 3;
                ka.i iVar = (ka.i) getBackground();
                ka.l lVarG = iVar.f7334w.f7316a.g();
                lVarG.b(this.N);
                if (z10) {
                    lVarG.f7343e = new ka.a(0.0f);
                    lVarG.f7345h = new ka.a(0.0f);
                } else {
                    lVarG.f = new ka.a(0.0f);
                    lVarG.f7344g = new ka.a(0.0f);
                }
                m mVarA = lVarG.a();
                iVar.setShapeAppearanceModel(mVarA);
                x xVar = this.Q;
                xVar.f7386c = mVarA;
                xVar.c();
                xVar.a(this);
                xVar.f7387d = new RectF(0.0f, 0.0f, i, i10);
                xVar.c();
                xVar.a(this);
                xVar.f7385b = true;
                xVar.a(this);
            }
        }
    }

    public ea.i getBackHelper() {
        return this.R;
    }

    public MenuItem getCheckedItem() {
        return this.D.f3633z.f3623e;
    }

    public int getDividerInsetEnd() {
        return this.D.O;
    }

    public int getDividerInsetStart() {
        return this.D.N;
    }

    public int getHeaderCount() {
        return this.D.f3630w.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.D.H;
    }

    public int getItemHorizontalPadding() {
        return this.D.J;
    }

    public int getItemIconPadding() {
        return this.D.L;
    }

    public ColorStateList getItemIconTintList() {
        return this.D.G;
    }

    public int getItemMaxLines() {
        return this.D.T;
    }

    public ColorStateList getItemTextColor() {
        return this.D.F;
    }

    public int getItemVerticalPadding() {
        return this.D.K;
    }

    public Menu getMenu() {
        return this.C;
    }

    public int getSubheaderInsetEnd() {
        return this.D.Q;
    }

    public int getSubheaderInsetStart() {
        return this.D.P;
    }

    public final Pair h() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof j1.d)) {
            return new Pair((DrawerLayout) parent, (j1.d) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    @Override // da.w, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        ea.d dVar;
        ArrayList arrayList;
        super.onAttachedToWindow();
        com.bumptech.glide.e.q(this);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            v vVar = this.S;
            if (((ea.d) vVar.f888w) != null) {
                DrawerLayout drawerLayout = (DrawerLayout) parent;
                d dVar2 = this.T;
                if (dVar2 != null && (arrayList = drawerLayout.O) != null) {
                    arrayList.remove(dVar2);
                }
                drawerLayout.a(dVar2);
                if (!DrawerLayout.n(this) || (dVar = (ea.d) vVar.f888w) == null) {
                    return;
                }
                dVar.b((NavigationView) vVar.f889x, (NavigationView) vVar.f890y, true);
            }
        }
    }

    @Override // da.w, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.I);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            d dVar = this.T;
            if (dVar != null && (arrayList = drawerLayout.O) != null) {
                arrayList.remove(dVar);
            }
        }
        v vVar = this.S;
        ea.d dVar2 = (ea.d) vVar.f888w;
        if (dVar2 != null) {
            dVar2.c((NavigationView) vVar.f890y);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        int mode = View.MeasureSpec.getMode(i);
        int i11 = this.F;
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), i11), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        super.onMeasure(i, i10);
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
        Bundle bundle = gVar.f4527x;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.C.f8537u;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (WeakReference weakReference : copyOnWriteArrayList) {
            n.w wVar = (n.w) weakReference.get();
            if (wVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id2 = wVar.getId();
                if (id2 > 0 && (parcelable2 = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                    wVar.b(parcelable2);
                }
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableK;
        g gVar = new g(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        gVar.f4527x = bundle;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.C.f8537u;
        if (copyOnWriteArrayList.isEmpty()) {
            return gVar;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            n.w wVar = (n.w) weakReference.get();
            if (wVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id2 = wVar.getId();
                if (id2 > 0 && (parcelableK = wVar.k()) != null) {
                    sparseArray.put(id2, parcelableK);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        return gVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        g(i, i10);
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.K = z10;
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.C.findItem(i);
        if (menuItemFindItem != null) {
            this.D.f3633z.i((n.m) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i) {
        t tVar = this.D;
        tVar.O = i;
        tVar.a();
    }

    public void setDividerInsetStart(int i) {
        t tVar = this.D;
        tVar.N = i;
        tVar.a();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        com.bumptech.glide.e.o(this, f);
    }

    public void setEndInsetScrimEnabled(boolean z10) {
        this.M = z10;
    }

    public void setForceCompatClippingEnabled(boolean z10) {
        x xVar = this.Q;
        if (z10 != xVar.f7384a) {
            xVar.f7384a = z10;
            xVar.a(this);
        }
    }

    public void setItemBackground(Drawable drawable) {
        t tVar = this.D;
        tVar.H = drawable;
        tVar.f();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(getContext().getDrawable(i));
    }

    public void setItemHorizontalPadding(int i) {
        t tVar = this.D;
        tVar.J = i;
        tVar.f();
    }

    public void setItemHorizontalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        t tVar = this.D;
        tVar.J = dimensionPixelSize;
        tVar.f();
    }

    public void setItemIconPadding(int i) {
        t tVar = this.D;
        tVar.L = i;
        tVar.f();
    }

    public void setItemIconPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        t tVar = this.D;
        tVar.L = dimensionPixelSize;
        tVar.f();
    }

    public void setItemIconSize(int i) {
        t tVar = this.D;
        if (tVar.M != i) {
            tVar.M = i;
            tVar.R = true;
            tVar.f();
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        t tVar = this.D;
        tVar.G = colorStateList;
        tVar.f();
    }

    public void setItemMaxLines(int i) {
        t tVar = this.D;
        tVar.T = i;
        tVar.f();
    }

    public void setItemTextAppearance(int i) {
        t tVar = this.D;
        tVar.D = i;
        tVar.f();
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        t tVar = this.D;
        tVar.E = z10;
        tVar.f();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        t tVar = this.D;
        tVar.F = colorStateList;
        tVar.f();
    }

    public void setItemVerticalPadding(int i) {
        t tVar = this.D;
        tVar.K = i;
        tVar.f();
    }

    public void setItemVerticalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        t tVar = this.D;
        tVar.K = dimensionPixelSize;
        tVar.f();
    }

    public void setNavigationItemSelectedListener(f fVar) {
        this.E = fVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        t tVar = this.D;
        if (tVar != null) {
            tVar.W = i;
            NavigationMenuView navigationMenuView = tVar.f3629v;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    public void setStartInsetScrimEnabled(boolean z10) {
        this.L = z10;
    }

    public void setSubheaderInsetEnd(int i) {
        t tVar = this.D;
        tVar.Q = i;
        tVar.d();
    }

    public void setSubheaderInsetStart(int i) {
        t tVar = this.D;
        tVar.P = i;
        tVar.d();
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.J = z10;
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.C.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.D.f3633z.i((n.m) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
