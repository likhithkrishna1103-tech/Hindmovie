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
import c.c;
import com.google.android.material.internal.NavigationMenuView;
import e1.d;
import j9.i;
import j9.t;
import j9.w;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k9.b;
import l.h;
import l9.a;
import l9.n;
import l9.o;
import l9.p;
import l9.q;
import m.m;
import p8.k;
import p8.l;
import q0.o0;
import q9.g;
import q9.j;
import q9.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends w implements b {
    public static final int[] R = {R.attr.state_checked};
    public static final int[] S = {-16842910};
    public static final int T = k.Widget_Design_NavigationView;
    public final i B;
    public final t C;
    public p D;
    public final int E;
    public final int[] F;
    public h G;
    public final o H;
    public boolean I;
    public boolean J;
    public int K;
    public final boolean L;
    public final int M;
    public final v N;
    public final k9.h O;
    public final a7.b P;
    public final n Q;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d6 A[PHI: r11
      0x01d6: PHI (r11v3 android.graphics.drawable.Drawable) = 
      (r11v2 android.graphics.drawable.Drawable)
      (r11v6 android.graphics.drawable.Drawable)
      (r11v2 android.graphics.drawable.Drawable)
     binds: [B:54:0x0198, B:60:0x01be, B:58:0x01a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v18 */
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
            Method dump skipped, instruction units count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private MenuInflater getMenuInflater() {
        if (this.G == null) {
            this.G = new h(getContext());
        }
        return this.G;
    }

    @Override // k9.b
    public final void a() {
        Pair pairH = h();
        DrawerLayout drawerLayout = (DrawerLayout) pairH.first;
        k9.h hVar = this.O;
        c cVar = hVar.f;
        hVar.f = null;
        if (cVar == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.c(this, true);
            return;
        }
        int i = ((d) pairH.second).f4278a;
        int i10 = a.f8020a;
        hVar.b(cVar, i, new g5.k(drawerLayout, this, 1), new i4.d(2, drawerLayout));
    }

    @Override // k9.b
    public final void b(c cVar) {
        float f = cVar.f2153c;
        int i = ((d) h().second).f4278a;
        k9.h hVar = this.O;
        if (hVar.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        c cVar2 = hVar.f;
        hVar.f = cVar;
        if (cVar2 != null) {
            hVar.c(f, cVar.f2154d == 0, i);
        }
        if (this.L) {
            this.K = q8.a.c(hVar.f7579a.getInterpolation(f), 0, this.M);
            g(getWidth(), getHeight());
        }
    }

    @Override // k9.b
    public final void c(c cVar) {
        h();
        this.O.f = cVar;
    }

    @Override // k9.b
    public final void d() {
        h();
        this.O.a();
        if (!this.L || this.K == 0) {
            return;
        }
        this.K = 0;
        g(getWidth(), getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        v vVar = this.N;
        Path path = vVar.f11161e;
        if (!vVar.b() || path.isEmpty()) {
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
        ColorStateList colorStateListC = f0.c.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(g.a.colorPrimary, typedValue, true)) {
            return null;
        }
        int i10 = typedValue.data;
        int defaultColor = colorStateListC.getDefaultColor();
        int[] iArr = S;
        return new ColorStateList(new int[][]{iArr, R, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListC.getColorForState(iArr, defaultColor), i10, defaultColor});
    }

    public final InsetDrawable f(kc.b bVar, ColorStateList colorStateList) {
        int i = l.NavigationView_itemShapeAppearance;
        TypedArray typedArray = (TypedArray) bVar.f7621w;
        g gVar = new g(q9.k.a(getContext(), typedArray.getResourceId(i, 0), typedArray.getResourceId(l.NavigationView_itemShapeAppearanceOverlay, 0)).a());
        gVar.l(colorStateList);
        return new InsetDrawable((Drawable) gVar, typedArray.getDimensionPixelSize(l.NavigationView_itemShapeInsetStart, 0), typedArray.getDimensionPixelSize(l.NavigationView_itemShapeInsetTop, 0), typedArray.getDimensionPixelSize(l.NavigationView_itemShapeInsetEnd, 0), typedArray.getDimensionPixelSize(l.NavigationView_itemShapeInsetBottom, 0));
    }

    public final void g(int i, int i10) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof d)) {
            if ((this.K > 0 || this.L) && (getBackground() instanceof g)) {
                int i11 = ((d) getLayoutParams()).f4278a;
                WeakHashMap weakHashMap = o0.f10475a;
                boolean z2 = Gravity.getAbsoluteGravity(i11, getLayoutDirection()) == 3;
                g gVar = (g) getBackground();
                j jVarF = gVar.f11105u.f11090a.f();
                jVarF.b(this.K);
                if (z2) {
                    jVarF.f11116e = new q9.a(0.0f);
                    jVarF.f11118h = new q9.a(0.0f);
                } else {
                    jVarF.f = new q9.a(0.0f);
                    jVarF.f11117g = new q9.a(0.0f);
                }
                q9.k kVarA = jVarF.a();
                gVar.setShapeAppearanceModel(kVarA);
                v vVar = this.N;
                vVar.f11159c = kVarA;
                vVar.c();
                vVar.a(this);
                vVar.f11160d = new RectF(0.0f, 0.0f, i, i10);
                vVar.c();
                vVar.a(this);
                vVar.f11158b = true;
                vVar.a(this);
            }
        }
    }

    public k9.h getBackHelper() {
        return this.O;
    }

    public MenuItem getCheckedItem() {
        return this.C.f6905y.f6895e;
    }

    public int getDividerInsetEnd() {
        return this.C.N;
    }

    public int getDividerInsetStart() {
        return this.C.M;
    }

    public int getHeaderCount() {
        return this.C.f6902v.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.C.G;
    }

    public int getItemHorizontalPadding() {
        return this.C.I;
    }

    public int getItemIconPadding() {
        return this.C.K;
    }

    public ColorStateList getItemIconTintList() {
        return this.C.F;
    }

    public int getItemMaxLines() {
        return this.C.S;
    }

    public ColorStateList getItemTextColor() {
        return this.C.E;
    }

    public int getItemVerticalPadding() {
        return this.C.J;
    }

    public Menu getMenu() {
        return this.B;
    }

    public int getSubheaderInsetEnd() {
        return this.C.P;
    }

    public int getSubheaderInsetStart() {
        return this.C.O;
    }

    public final Pair h() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof d)) {
            return new Pair((DrawerLayout) parent, (d) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    @Override // j9.w, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        k9.c cVar;
        ArrayList arrayList;
        super.onAttachedToWindow();
        i5.a.O(this);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            a7.b bVar = this.P;
            if (((k9.c) bVar.f618v) != null) {
                DrawerLayout drawerLayout = (DrawerLayout) parent;
                n nVar = this.Q;
                if (nVar != null && (arrayList = drawerLayout.N) != null) {
                    arrayList.remove(nVar);
                }
                drawerLayout.a(nVar);
                if (!DrawerLayout.n(this) || (cVar = (k9.c) bVar.f618v) == null) {
                    return;
                }
                cVar.b((NavigationView) bVar.f619w, (NavigationView) bVar.f620x, true);
            }
        }
    }

    @Override // j9.w, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.H);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            n nVar = this.Q;
            if (nVar == null || (arrayList = drawerLayout.N) == null) {
                return;
            }
            arrayList.remove(nVar);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        int mode = View.MeasureSpec.getMode(i);
        int i11 = this.E;
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), i11), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        super.onMeasure(i, i10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof q)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        q qVar = (q) parcelable;
        super.onRestoreInstanceState(qVar.f14205u);
        this.B.t(qVar.f8062w);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        q qVar = new q(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        qVar.f8062w = bundle;
        this.B.v(bundle);
        return qVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        g(i, i10);
    }

    public void setBottomInsetScrimEnabled(boolean z2) {
        this.J = z2;
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.B.findItem(i);
        if (menuItemFindItem != null) {
            this.C.f6905y.h((m) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i) {
        t tVar = this.C;
        tVar.N = i;
        tVar.f(false);
    }

    public void setDividerInsetStart(int i) {
        t tVar = this.C;
        tVar.M = i;
        tVar.f(false);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        i5.a.K(this, f);
    }

    public void setForceCompatClippingEnabled(boolean z2) {
        v vVar = this.N;
        if (z2 != vVar.f11157a) {
            vVar.f11157a = z2;
            vVar.a(this);
        }
    }

    public void setItemBackground(Drawable drawable) {
        t tVar = this.C;
        tVar.G = drawable;
        tVar.f(false);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(getContext().getDrawable(i));
    }

    public void setItemHorizontalPadding(int i) {
        t tVar = this.C;
        tVar.I = i;
        tVar.f(false);
    }

    public void setItemHorizontalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        t tVar = this.C;
        tVar.I = dimensionPixelSize;
        tVar.f(false);
    }

    public void setItemIconPadding(int i) {
        t tVar = this.C;
        tVar.K = i;
        tVar.f(false);
    }

    public void setItemIconPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        t tVar = this.C;
        tVar.K = dimensionPixelSize;
        tVar.f(false);
    }

    public void setItemIconSize(int i) {
        t tVar = this.C;
        if (tVar.L != i) {
            tVar.L = i;
            tVar.Q = true;
            tVar.f(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        t tVar = this.C;
        tVar.F = colorStateList;
        tVar.f(false);
    }

    public void setItemMaxLines(int i) {
        t tVar = this.C;
        tVar.S = i;
        tVar.f(false);
    }

    public void setItemTextAppearance(int i) {
        t tVar = this.C;
        tVar.C = i;
        tVar.f(false);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z2) {
        t tVar = this.C;
        tVar.D = z2;
        tVar.f(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        t tVar = this.C;
        tVar.E = colorStateList;
        tVar.f(false);
    }

    public void setItemVerticalPadding(int i) {
        t tVar = this.C;
        tVar.J = i;
        tVar.f(false);
    }

    public void setItemVerticalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        t tVar = this.C;
        tVar.J = dimensionPixelSize;
        tVar.f(false);
    }

    public void setNavigationItemSelectedListener(p pVar) {
        this.D = pVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        t tVar = this.C;
        if (tVar != null) {
            tVar.V = i;
            NavigationMenuView navigationMenuView = tVar.f6901u;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    public void setSubheaderInsetEnd(int i) {
        t tVar = this.C;
        tVar.P = i;
        tVar.f(false);
    }

    public void setSubheaderInsetStart(int i) {
        t tVar = this.C;
        tVar.O = i;
        tVar.f(false);
    }

    public void setTopInsetScrimEnabled(boolean z2) {
        this.I = z2;
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.B.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.C.f6905y.h((m) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
