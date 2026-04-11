package l9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import j9.e0;
import java.util.WeakHashMap;
import m.y;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends FrameLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f8054u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v8.b f8055v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f8056w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public l.h f8057x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public k f8058y;

    public m(Context context, AttributeSet attributeSet, int i, int i10) {
        super(x9.a.a(context, attributeSet, i, i10), attributeSet, i);
        i iVar = new i();
        iVar.f8051v = false;
        this.f8056w = iVar;
        Context context2 = getContext();
        kc.b bVarE = e0.e(context2, attributeSet, p8.l.NavigationBarView, i, i10, p8.l.NavigationBarView_itemTextAppearanceInactive, p8.l.NavigationBarView_itemTextAppearanceActive);
        f fVar = new f(context2, getClass(), getMaxItemCount());
        this.f8054u = fVar;
        v8.b bVar = new v8.b(context2);
        this.f8055v = bVar;
        iVar.f8050u = bVar;
        iVar.f8052w = 1;
        bVar.setPresenter(iVar);
        fVar.b(iVar, fVar.f8205a);
        getContext();
        iVar.f8050u.f8041b0 = fVar;
        int i11 = p8.l.NavigationBarView_itemIconTint;
        TypedArray typedArray = (TypedArray) bVarE.f7621w;
        if (typedArray.hasValue(i11)) {
            bVar.setIconTintList(bVarE.q(p8.l.NavigationBarView_itemIconTint));
        } else {
            bVar.setIconTintList(bVar.c());
        }
        setItemIconSize(typedArray.getDimensionPixelSize(p8.l.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(p8.d.mtrl_navigation_bar_item_default_icon_size)));
        if (typedArray.hasValue(p8.l.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(p8.l.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (typedArray.hasValue(p8.l.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(typedArray.getResourceId(p8.l.NavigationBarView_itemTextAppearanceActive, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(typedArray.getBoolean(p8.l.NavigationBarView_itemTextAppearanceActiveBoldEnabled, true));
        if (typedArray.hasValue(p8.l.NavigationBarView_itemTextColor)) {
            setItemTextColor(bVarE.q(p8.l.NavigationBarView_itemTextColor));
        }
        Drawable background = getBackground();
        ColorStateList colorStateListK = a.a.k(background);
        if (background == null || colorStateListK != null) {
            q9.g gVar = new q9.g(q9.k.c(context2, attributeSet, i, i10).a());
            if (colorStateListK != null) {
                gVar.l(colorStateListK);
            }
            gVar.j(context2);
            WeakHashMap weakHashMap = o0.f10475a;
            setBackground(gVar);
        }
        if (typedArray.hasValue(p8.l.NavigationBarView_itemPaddingTop)) {
            setItemPaddingTop(typedArray.getDimensionPixelSize(p8.l.NavigationBarView_itemPaddingTop, 0));
        }
        if (typedArray.hasValue(p8.l.NavigationBarView_itemPaddingBottom)) {
            setItemPaddingBottom(typedArray.getDimensionPixelSize(p8.l.NavigationBarView_itemPaddingBottom, 0));
        }
        if (typedArray.hasValue(p8.l.NavigationBarView_activeIndicatorLabelPadding)) {
            setActiveIndicatorLabelPadding(typedArray.getDimensionPixelSize(p8.l.NavigationBarView_activeIndicatorLabelPadding, 0));
        }
        if (typedArray.hasValue(p8.l.NavigationBarView_elevation)) {
            setElevation(typedArray.getDimensionPixelSize(p8.l.NavigationBarView_elevation, 0));
        }
        getBackground().mutate().setTintList(a.a.j(context2, bVarE, p8.l.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(typedArray.getInteger(p8.l.NavigationBarView_labelVisibilityMode, -1));
        int resourceId = typedArray.getResourceId(p8.l.NavigationBarView_itemBackground, 0);
        if (resourceId != 0) {
            bVar.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(a.a.j(context2, bVarE, p8.l.NavigationBarView_itemRippleColor));
        }
        int resourceId2 = typedArray.getResourceId(p8.l.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, p8.l.NavigationBarActiveIndicator);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.NavigationBarActiveIndicator_android_width, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.NavigationBarActiveIndicator_android_height, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(p8.l.NavigationBarActiveIndicator_marginHorizontal, 0));
            setItemActiveIndicatorColor(a.a.i(context2, typedArrayObtainStyledAttributes, p8.l.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(q9.k.a(context2, typedArrayObtainStyledAttributes.getResourceId(p8.l.NavigationBarActiveIndicator_shapeAppearance, 0), 0).a());
            typedArrayObtainStyledAttributes.recycle();
        }
        if (typedArray.hasValue(p8.l.NavigationBarView_menu)) {
            int resourceId3 = typedArray.getResourceId(p8.l.NavigationBarView_menu, 0);
            iVar.f8051v = true;
            getMenuInflater().inflate(resourceId3, fVar);
            iVar.f8051v = false;
            iVar.f(true);
        }
        bVarE.E();
        addView(bVar);
        fVar.f8209e = new wb.c(25, (BottomNavigationView) this);
    }

    private MenuInflater getMenuInflater() {
        if (this.f8057x == null) {
            this.f8057x = new l.h(getContext());
        }
        return this.f8057x;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f8055v.getActiveIndicatorLabelPadding();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f8055v.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f8055v.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f8055v.getItemActiveIndicatorMarginHorizontal();
    }

    public q9.k getItemActiveIndicatorShapeAppearance() {
        return this.f8055v.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f8055v.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f8055v.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f8055v.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f8055v.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f8055v.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f8055v.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f8055v.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f8055v.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f8055v.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f8055v.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f8055v.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f8055v.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f8054u;
    }

    public y getMenuView() {
        return this.f8055v;
    }

    public i getPresenter() {
        return this.f8056w;
    }

    public int getSelectedItemId() {
        return this.f8055v.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i5.a.O(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof l)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        l lVar = (l) parcelable;
        super.onRestoreInstanceState(lVar.f14205u);
        this.f8054u.t(lVar.f8053w);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        l lVar = new l(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        lVar.f8053w = bundle;
        this.f8054u.v(bundle);
        return lVar;
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.f8055v.setActiveIndicatorLabelPadding(i);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        i5.a.K(this, f);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f8055v.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z2) {
        this.f8055v.setItemActiveIndicatorEnabled(z2);
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.f8055v.setItemActiveIndicatorHeight(i);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.f8055v.setItemActiveIndicatorMarginHorizontal(i);
    }

    public void setItemActiveIndicatorShapeAppearance(q9.k kVar) {
        this.f8055v.setItemActiveIndicatorShapeAppearance(kVar);
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.f8055v.setItemActiveIndicatorWidth(i);
    }

    public void setItemBackground(Drawable drawable) {
        this.f8055v.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.f8055v.setItemBackgroundRes(i);
    }

    public void setItemIconSize(int i) {
        this.f8055v.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f8055v.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i) {
        this.f8055v.setItemPaddingBottom(i);
    }

    public void setItemPaddingTop(int i) {
        this.f8055v.setItemPaddingTop(i);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f8055v.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.f8055v.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z2) {
        this.f8055v.setItemTextAppearanceActiveBoldEnabled(z2);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f8055v.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f8055v.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        v8.b bVar = this.f8055v;
        if (bVar.getLabelVisibilityMode() != i) {
            bVar.setLabelVisibilityMode(i);
            this.f8056w.f(false);
        }
    }

    public void setOnItemSelectedListener(k kVar) {
        this.f8058y = kVar;
    }

    public void setSelectedItemId(int i) {
        f fVar = this.f8054u;
        MenuItem menuItemFindItem = fVar.findItem(i);
        if (menuItemFindItem == null || fVar.q(menuItemFindItem, this.f8056w, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    public void setOnItemReselectedListener(j jVar) {
    }
}
