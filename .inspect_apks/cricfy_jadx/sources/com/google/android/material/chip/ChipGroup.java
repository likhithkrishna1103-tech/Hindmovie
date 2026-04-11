package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import da.a;
import da.d0;
import da.e;
import da.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import k9.b;
import k9.k;
import k9.l;
import kf.i;
import v9.d;
import v9.f;
import v9.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends e {
    public static final int F = k.Widget_MaterialComponents_ChipGroup;
    public int A;
    public f B;
    public final a C;
    public final int D;
    public final g E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2838z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet) {
        int i = b.chipGroupStyle;
        int i10 = F;
        Context contextA = ra.a.a(context, attributeSet, i, i10);
        super(contextA, attributeSet, i);
        this.f3614x = false;
        TypedArray typedArrayObtainStyledAttributes = contextA.getTheme().obtainStyledAttributes(attributeSet, l.FlowLayout, 0, 0);
        this.f3612v = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.FlowLayout_lineSpacing, 0);
        this.f3613w = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.FlowLayout_horizontalItemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
        a aVar = new a(0);
        this.C = aVar;
        g gVar = new g(this);
        this.E = gVar;
        TypedArray typedArrayD = d0.d(getContext(), attributeSet, l.ChipGroup, i, i10, new int[0]);
        int dimensionPixelOffset = typedArrayD.getDimensionPixelOffset(l.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayD.getDimensionPixelOffset(l.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayD.getDimensionPixelOffset(l.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayD.getBoolean(l.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayD.getBoolean(l.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayD.getBoolean(l.ChipGroup_selectionRequired, false));
        this.D = typedArrayD.getResourceId(l.ChipGroup_checkedChip, -1);
        typedArrayD.recycle();
        aVar.f = new m2.e(this);
        super.setOnHierarchyChangeListener(gVar);
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
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof d);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.C.c();
    }

    public List<Integer> getCheckedChipIds() {
        return this.C.b(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f2838z;
    }

    public int getChipSpacingVertical() {
        return this.A;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.D;
        if (i != -1) {
            a aVar = this.C;
            h hVar = (h) ((HashMap) aVar.f3564d).get(Integer.valueOf(i));
            if (hVar != null && aVar.a(hVar)) {
                aVar.d();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(getRowCount(), this.f3614x ? getVisibleChipCount() : -1, false, this.C.f3562b ? 1 : 2));
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.f2838z != i) {
            this.f2838z = i;
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
        if (this.A != i) {
            this.A = i;
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
    public void setOnCheckedChangeListener(v9.e eVar) {
        if (eVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new i(23, this));
        }
    }

    public void setOnCheckedStateChangeListener(f fVar) {
        this.B = fVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.E.f13543v = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z10) {
        this.C.f3563c = z10;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // da.e
    public void setSingleLine(boolean z10) {
        super.setSingleLine(z10);
    }

    public void setSingleSelection(boolean z10) {
        a aVar = this.C;
        if (aVar.f3562b != z10) {
            aVar.f3562b = z10;
            boolean zIsEmpty = ((HashSet) aVar.f3565e).isEmpty();
            Iterator it = ((HashMap) aVar.f3564d).values().iterator();
            while (it.hasNext()) {
                aVar.e((h) it.next(), false);
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
        return new d(layoutParams);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
