package com.google.android.material.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import k9.k;
import k9.l;
import ka.b0;
import ka.c0;
import ka.d;
import ka.d0;
import ka.e0;
import ka.f0;
import ka.m;
import org.xmlpull.v1.XmlPullParserException;
import p2.s;
import pc.c;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends LinearLayout {
    public static final int F = k.Widget_Material3_MaterialButtonGroup;
    public b0 A;
    public d0 B;
    public int C;
    public f0 D;
    public boolean E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f2829v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f2830w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l4.a f2831x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s f2832y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer[] f2833z;

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, AttributeSet attributeSet, int i) {
        b0 b0VarB;
        XmlResourceParser xml;
        int next;
        f0 f0Var;
        int next2;
        int i10 = F;
        super(ra.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.f2829v = new ArrayList();
        this.f2830w = new ArrayList();
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.f2831x = new l4.a((Object) materialButtonToggleGroup);
        this.f2832y = new s(1, materialButtonToggleGroup);
        this.E = true;
        Context context2 = getContext();
        TypedArray typedArrayD = da.d0.d(context2, attributeSet, l.MaterialButtonGroup, i, i10, new int[0]);
        if (typedArrayD.hasValue(l.MaterialButtonGroup_buttonSizeChange)) {
            int resourceId = typedArrayD.getResourceId(l.MaterialButtonGroup_buttonSizeChange, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                    f0Var = null;
                }
                try {
                    f0Var = new f0();
                    f0Var.f7314c = new int[10][];
                    f0Var.f7315d = new c[10];
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next2 = xml.next();
                        if (next2 == 2) {
                            break;
                        }
                    } while (next2 != 1);
                    if (next2 != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (xml.getName().equals("selector")) {
                        f0Var.a(context2, xml, attributeSetAsAttributeSet, context2.getTheme());
                    }
                    xml.close();
                    this.D = f0Var;
                } finally {
                }
            } else {
                f0Var = null;
                this.D = f0Var;
            }
        }
        if (typedArrayD.hasValue(l.MaterialButtonGroup_shapeAppearance)) {
            d0 d0VarB = d0.b(context2, typedArrayD, l.MaterialButtonGroup_shapeAppearance);
            this.B = d0VarB;
            if (d0VarB == null) {
                c0 c0Var = new c0(m.a(context2, typedArrayD.getResourceId(l.MaterialButtonGroup_shapeAppearance, 0), typedArrayD.getResourceId(l.MaterialButtonGroup_shapeAppearanceOverlay, 0)).a());
                this.B = c0Var.f7292b != 0 ? new d0(c0Var) : null;
            }
        }
        if (typedArrayD.hasValue(l.MaterialButtonGroup_innerCornerSize)) {
            int i11 = l.MaterialButtonGroup_innerCornerSize;
            ka.a aVar = new ka.a(0.0f);
            int resourceId2 = typedArrayD.getResourceId(i11, 0);
            if (resourceId2 != 0 && context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        b0 b0Var = new b0();
                        AttributeSet attributeSetAsAttributeSet2 = Xml.asAttributeSet(xml);
                        do {
                            next = xml.next();
                            if (next == 2) {
                                break;
                            }
                        } while (next != 1);
                        if (next != 2) {
                            throw new XmlPullParserException("No start tag found");
                        }
                        if (xml.getName().equals("selector")) {
                            b0Var.d(context2, xml, attributeSetAsAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                        b0VarB = b0Var;
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    b0VarB = b0.b(aVar);
                }
            } else {
                b0VarB = b0.b(m.d(typedArrayD, i11, aVar));
            }
            this.A = b0VarB;
        }
        this.C = typedArrayD.getDimensionPixelSize(l.MaterialButtonGroup_android_spacing, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayD.getBoolean(l.MaterialButtonGroup_android_enabled, true));
        typedArrayD.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (c(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    public final void a() {
        int iMin;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i - 1);
            if (this.C <= 0) {
                iMin = Math.min(materialButton.getStrokeWidth(), materialButton2.getStrokeWidth());
                materialButton.setShouldDrawSurfaceColorStroke(true);
                materialButton2.setShouldDrawSurfaceColorStroke(true);
            } else {
                materialButton.setShouldDrawSurfaceColorStroke(false);
                materialButton2.setShouldDrawSurfaceColorStroke(false);
                iMin = 0;
            }
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(this.C - iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.C - iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        d();
        this.E = true;
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f2831x);
        this.f2829v.add(materialButton.getShapeAppearanceModel());
        this.f2830w.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float fMax;
        if (this.D == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int iMin = Integer.MAX_VALUE;
        for (int i = firstVisibleChildIndex; i <= lastVisibleChildIndex; i++) {
            if (c(i)) {
                if (c(i) && this.D != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i);
                    f0 f0Var = this.D;
                    int width = materialButton3.getWidth();
                    int i10 = -width;
                    for (int i11 = 0; i11 < f0Var.f7312a; i11++) {
                        e0 e0Var = (e0) f0Var.f7315d[i11].f10180v;
                        int i12 = e0Var.f7305a;
                        float f = e0Var.f7306b;
                        if (i12 == 2) {
                            fMax = Math.max(i10, f);
                        } else if (i12 == 1) {
                            fMax = Math.max(i10, width * f);
                        }
                        i10 = (int) fMax;
                    }
                    int iMax = Math.max(0, i10);
                    int i13 = i - 1;
                    while (true) {
                        materialButton = null;
                        if (i13 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (c(i13)) {
                                materialButton2 = (MaterialButton) getChildAt(i13);
                                break;
                            }
                            i13--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i14 = i + 1;
                    while (true) {
                        if (i14 >= childCount) {
                            break;
                        }
                        if (c(i14)) {
                            materialButton = (MaterialButton) getChildAt(i14);
                            break;
                        }
                        i14++;
                    }
                    iMin = Math.min(iMax, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i != firstVisibleChildIndex && i != lastVisibleChildIndex) {
                    iMin /= 2;
                }
                iMin = Math.min(iMin, iMin);
            }
        }
        int i15 = firstVisibleChildIndex;
        while (i15 <= lastVisibleChildIndex) {
            if (c(i15)) {
                ((MaterialButton) getChildAt(i15)).setSizeChange(this.D);
                ((MaterialButton) getChildAt(i15)).setWidthChangeMax((i15 == firstVisibleChildIndex || i15 == lastVisibleChildIndex) ? iMin : iMin * 2);
            }
            i15++;
        }
    }

    public final boolean c(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public final void d() {
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            LinearLayout.LayoutParams layoutParams = materialButton.Q;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.Q = null;
                materialButton.N = -1.0f;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f2832y);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.f2833z = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [int[][], java.io.Serializable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Serializable, ka.m[]] */
    public final void e() {
        c0 c0Var;
        int i;
        if (!(this.A == null && this.B == null) && this.E) {
            this.E = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i10 = 0;
            while (i10 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i10);
                if (materialButton.getVisibility() != 8) {
                    boolean z10 = i10 == firstVisibleChildIndex;
                    boolean z11 = i10 == lastVisibleChildIndex;
                    d0 d0Var = this.B;
                    if (d0Var == null || (!z10 && !z11)) {
                        d0Var = (d0) this.f2830w.get(i10);
                    }
                    if (d0Var == null) {
                        c0Var = new c0((m) this.f2829v.get(i10));
                    } else {
                        c0 c0Var2 = new c0(0);
                        int i11 = d0Var.f7298a;
                        c0Var2.f7292b = i11;
                        c0Var2.f7293c = d0Var.f7299b;
                        int[][] iArr = d0Var.f7300c;
                        ?? r14 = new int[iArr.length][];
                        c0Var2.f7294d = r14;
                        m[] mVarArr = d0Var.f7301d;
                        c0Var2.f7295e = new m[mVarArr.length];
                        System.arraycopy(iArr, 0, r14, 0, i11);
                        System.arraycopy(mVarArr, 0, (m[]) c0Var2.f7295e, 0, c0Var2.f7292b);
                        c0Var2.f = d0Var.f7302e;
                        c0Var2.f7296g = d0Var.f;
                        c0Var2.f7297h = d0Var.f7303g;
                        c0Var2.i = d0Var.f7304h;
                        c0Var = c0Var2;
                    }
                    boolean z12 = getOrientation() == 0;
                    boolean z13 = getLayoutDirection() == 1;
                    if (z12) {
                        i = z10 ? 5 : 0;
                        if (z11) {
                            i |= 10;
                        }
                        if (z13) {
                            i = ((i & 10) >> 1) | ((i & 5) << 1);
                        }
                    } else {
                        i = z10 ? 3 : 0;
                        if (z11) {
                            i |= 12;
                        }
                    }
                    int i12 = ~i;
                    b0 b0Var = this.A;
                    if ((i12 | 1) == i12) {
                        c0Var.f = b0Var;
                    }
                    if ((i12 | 2) == i12) {
                        c0Var.f7296g = b0Var;
                    }
                    if ((i12 | 4) == i12) {
                        c0Var.f7297h = b0Var;
                    }
                    if ((i12 | 8) == i12) {
                        c0Var.i = b0Var;
                    }
                    d0 d0Var2 = c0Var.f7292b == 0 ? null : new d0(c0Var);
                    if (d0Var2.d()) {
                        materialButton.setStateListShapeAppearanceModel(d0Var2);
                    } else {
                        materialButton.setShapeAppearanceModel(d0Var2.c());
                    }
                }
                i10++;
            }
        }
    }

    public f0 getButtonSizeChange() {
        return this.D;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i10) {
        Integer[] numArr = this.f2833z;
        if (numArr != null && i10 < numArr.length) {
            return numArr[i10].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i10;
    }

    public d getInnerCornerSize() {
        return this.A.f7287b;
    }

    public b0 getInnerCornerSizeStateList() {
        return this.A;
    }

    public m getShapeAppearance() {
        d0 d0Var = this.B;
        if (d0Var == null) {
            return null;
        }
        return d0Var.c();
    }

    public int getSpacing() {
        return this.C;
    }

    public d0 getStateListShapeAppearance() {
        return this.B;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        if (z10) {
            d();
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        e();
        a();
        super.onMeasure(i, i10);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f2829v.remove(iIndexOfChild);
            this.f2830w.remove(iIndexOfChild);
        }
        this.E = true;
        e();
        d();
        a();
    }

    public void setButtonSizeChange(f0 f0Var) {
        if (this.D != f0Var) {
            this.D = f0Var;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setEnabled(z10);
        }
    }

    public void setInnerCornerSize(d dVar) {
        this.A = b0.b(dVar);
        this.E = true;
        e();
        invalidate();
    }

    public void setInnerCornerSizeStateList(b0 b0Var) {
        this.A = b0Var;
        this.E = true;
        e();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (getOrientation() != i) {
            this.E = true;
        }
        super.setOrientation(i);
    }

    public void setShapeAppearance(m mVar) {
        c0 c0Var = new c0(mVar);
        this.B = c0Var.f7292b == 0 ? null : new d0(c0Var);
        this.E = true;
        e();
        invalidate();
    }

    public void setSpacing(int i) {
        this.C = i;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(d0 d0Var) {
        this.B = d0Var;
        this.E = true;
        e();
        invalidate();
    }
}
