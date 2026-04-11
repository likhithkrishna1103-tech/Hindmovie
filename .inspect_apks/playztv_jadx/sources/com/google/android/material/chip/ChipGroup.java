package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import b9.f;
import b9.g;
import b9.h;
import b9.i;
import j9.a;
import j9.e;
import j9.e0;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import n.a1;
import p8.b;
import p8.k;
import p8.l;
import q0.o0;
import u5.d;
import wb.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends e {
    public static final int E = k.Widget_MaterialComponents_ChipGroup;
    public h A;
    public final a B;
    public final int C;
    public final i D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3380y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3381z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet) {
        int i = b.chipGroupStyle;
        int i10 = E;
        Context contextA = x9.a.a(context, attributeSet, i, i10);
        super(contextA, attributeSet, i);
        this.f6879w = false;
        TypedArray typedArrayObtainStyledAttributes = contextA.getTheme().obtainStyledAttributes(attributeSet, l.FlowLayout, 0, 0);
        this.f6877u = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.FlowLayout_lineSpacing, 0);
        this.f6878v = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
        a aVar = new a();
        this.B = aVar;
        i iVar = new i(this);
        this.D = iVar;
        TypedArray typedArrayD = e0.d(getContext(), attributeSet, l.ChipGroup, i, i10, new int[0]);
        int dimensionPixelOffset = typedArrayD.getDimensionPixelOffset(l.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayD.getDimensionPixelOffset(l.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayD.getDimensionPixelOffset(l.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayD.getBoolean(l.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayD.getBoolean(l.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayD.getBoolean(l.ChipGroup_selectionRequired, false));
        this.C = typedArrayD.getResourceId(l.ChipGroup_checkedChip, -1);
        typedArrayD.recycle();
        aVar.f6833c = new d(3, this);
        super.setOnHierarchyChangeListener(iVar);
        WeakHashMap weakHashMap = o0.f10475a;
        setImportantForAccessibility(1);
    }

    private int getVisibleChipCount() {
        int i = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof Chip) && getChildAt(i10).getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof f);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.B.c();
    }

    public List<Integer> getCheckedChipIds() {
        return this.B.b(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f3380y;
    }

    public int getChipSpacingVertical() {
        return this.f3381z;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.C;
        if (i != -1) {
            a aVar = this.B;
            j9.h hVar = (j9.h) aVar.f6831a.get(Integer.valueOf(i));
            if (hVar != null && aVar.a(hVar)) {
                aVar.d();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) a1.x(getRowCount(), this.f6879w ? getVisibleChipCount() : -1, this.B.f6834d ? 1 : 2).f8343u);
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.f3380y != i) {
            this.f3380y = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.f3381z != i) {
            this.f3381z = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(g gVar) {
        if (gVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new c(4, this));
        }
    }

    public void setOnCheckedStateChangeListener(h hVar) {
        this.A = hVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.D.f1974u = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z2) {
        this.B.f6835e = z2;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // j9.e
    public void setSingleLine(boolean z2) {
        super.setSingleLine(z2);
    }

    public void setSingleSelection(boolean z2) {
        a aVar = this.B;
        if (aVar.f6834d != z2) {
            aVar.f6834d = z2;
            boolean zIsEmpty = aVar.f6832b.isEmpty();
            Iterator it = aVar.f6831a.values().iterator();
            while (it.hasNext()) {
                aVar.e((j9.h) it.next(), false);
            }
            if (zIsEmpty) {
                return;
            }
            aVar.d();
        }
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f(layoutParams);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
